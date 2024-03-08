package dev.mvc.calendar;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.mvc.admin.AdminVO;

@Controller
public class CalendarCont{
    
    @Autowired
    @Qualifier("dev.mvc.calendar.CalendarProc")
    private CalendarProcInter calendarProc;
    
    public CalendarCont() {
        System.out.println("->CalendarCont created");
    }
    
    // 월간 조회
    @RequestMapping(value="/calendar/month.do", method=RequestMethod.GET)
    public ModelAndView read_month(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("calendar/month");
        return mav;  
    }
    
    @PostMapping("/calendar/month.do")
    public ModelAndView read_month(@RequestBody Map<String, Integer> requestData, CalendarVO calendarVO) {
       ModelAndView mav = new ModelAndView();
       Integer currentYear = requestData.get("year");
       Integer currentMonth = requestData.get("month");
       calendarVO.setYear(currentYear);
       calendarVO.setMonth(currentMonth);
       ArrayList<CalendarVO> read_month = this.calendarProc.read_month(calendarVO);
       System.out.println("->readmonth"+read_month);
       mav.addObject("data", read_month);//
       mav.setViewName("calendar/month");
       return mav;
    }
//    @RequestMapping(value="/calendar/month.do", method=RequestMethod.POST)
//    public ModelAndView read_month(CalendarVO calendarVO){
//        ModelAndView mav = new ModelAndView();
//        this.calendarProc.read_month(calendarVO);
//        mav.setViewName("calendar/month");
//        return mav;  
//    }

}