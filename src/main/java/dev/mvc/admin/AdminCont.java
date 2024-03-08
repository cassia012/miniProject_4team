package dev.mvc.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminCont{
    
    @Autowired
    @Qualifier("dev.mvc.admin.AdminProc")
    private AdminProcInter adminProc;
   
    public AdminCont() {
        System.out.println("->AdminCont created.");
    }
    
    // 관리자 계정생성
    @RequestMapping(value="/admin/create.do", method=RequestMethod.GET)
    public ModelAndView admin_create(){
        ModelAndView mav = new ModelAndView();
        //mav.setViewName("/admin/create_form");
        mav.setViewName("admin/create_form");
        return mav;  
    }

    @RequestMapping(value="/admin/create.do", method=RequestMethod.POST)
    public ModelAndView admin_create(AdminVO adminVO) {
        ModelAndView mav = new ModelAndView();
        int cnt = this.adminProc.admin_create(adminVO);
        //mav.setViewName("/admin/create_form");
        if (cnt == 1) {
            mav.setViewName("admin/create_form_success");
        } else {
            mav.setViewName("admin/create_form_fail");
        }
        return mav;  
    }
    
    // 관리자 로그인
    @RequestMapping(value="/admin/login.do", method=RequestMethod.GET)
    public ModelAndView admin_login(){
        ModelAndView mav = new ModelAndView();
        //mav.setViewName("/admin/create_form");
        mav.setViewName("admin/login_form");
        return mav;  
    }
    
    @RequestMapping(value="/admin/login.do", method=RequestMethod.POST)
    public ModelAndView admin_login(AdminVO adminVO) {
        ModelAndView mav = new ModelAndView();
        int cnt = this.adminProc.admin_login(adminVO);
        if (cnt == 1) {
            mav.setViewName("admin/login_success");
        } else {
            mav.setViewName("admin/login_fail");
        }
        return mav;  
    }
}