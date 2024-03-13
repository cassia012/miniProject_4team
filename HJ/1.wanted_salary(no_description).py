# 주석x 

# 설치: pip install selenium undetected_chromedriver python-dotenv
import os
import time

import requests
import undetected_chromedriver as uc
from bs4 import BeautifulSoup as bs
from dotenv import load_dotenv
from selenium import webdriver
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.common.alert import Alert
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.select import Select
from selenium.webdriver.support.ui import WebDriverWait

# step0. uc.Chrome()로 크롤링 할 driver객체 만들기
driver = uc.Chrome()
driver.get('https://www.wanted.co.kr/salary/518')
time.sleep(3)

# step1. 로그인 과정
# step1-1. 태그 건드리면 로그인 페이지 뜸(로그인 해야 select태그 이동해서 데이터 보기 가능)
select1 = '#__next > div.Salary_Salary__OUYDA > div > div.SearchBar_SearchBar__8ma00 > div > div > div:nth-child(3) > div > select'
driver.find_element(By.CSS_SELECTOR, select1).click()
time.sleep(3)
# step1-2. 로그인 종류 선택 -> 구글 로그인
select2 = '#__next > main > section > div > div > div > form > div.css-1qsnvsb > button.css-you85z > p'
driver.find_element(By.CSS_SELECTOR, select2).click()
time.sleep(3)

load_dotenv() # 이 함수를 한번 실행시켜야, .env파일에서 가져오기 가능
# step1-3. google_id
driver.find_element(By.CSS_SELECTOR, '#identifierId').click()
driver.find_element(By.CSS_SELECTOR, '#identifierId').send_keys(os.getenv('ID'))
time.sleep(3)
driver.find_element(By.CSS_SELECTOR, '#identifierNext > div > button').click()
time.sleep(4)
# step1-4. google_pw
driver.find_element(By.CSS_SELECTOR, '#password > div.aCsJod.oJeWuf > div > div.Xb9hP > input').click()
driver.find_element(By.CSS_SELECTOR, '#password > div.aCsJod.oJeWuf > div > div.Xb9hP > input').send_keys(os.getenv('PW'))
time.sleep(3)
driver.find_element(By.CSS_SELECTOR, '#passwordNext > div > button').click()
time.sleep(10)


# step2. select태그 클릭해서 직무별 & 연차별 연봉 뽑아내기
select = Select(driver.find_element(By.NAME, 'subCategory'))
all_options = select.options
all_options[0].text
salary_dict = {}
for k in range(1,len(all_options)): # 0은 '직무' block태그임
    # step2-1. 조회
    select.select_by_index(k) 
    key = all_options[k].text
    time.sleep(3)

    # step2-2. 신입(0년) 연봉 데이터 추출
    soup = bs(driver.page_source, 'html.parser') # xlml이 아니라, html.parser로 해야 안 짤리고 전부 나옴
    newbie = soup.select('h2.Info_jobCategorySalary__M4Ql6')[0].text # 신입연봉: ' x,xxx  만원'
    newbie = int(newbie[1:6].replace(',','')) # int: 3613

    # step2-3. 신입,1~10 -> 신입의 height기준으로 나머지 비율구해서 연봉구하기 can
    len(soup.select('path.recharts-rectangle')) # 11
    path_list = soup.select('path.recharts-rectangle')
    height_list = [x['height'] for x in path_list]
    height_list # 신입~10년차 막대의 height가 주어짐
    salary_list = [int(float(y)*newbie/float(height_list[0])) for y in height_list]
    # [3613, 3772, 4138, 4557, 4984, 5041, 5461, 6054, 6426, 6513, 7698]
    value = salary_list
    salary_dict[key] = value

print(salary_dict)
# {'전체': [3535, 3693, 3982, 4316, 4623, 4818..], ...,  'DBA': [3535, 3693, ..., 5859, 6185, 7056]}