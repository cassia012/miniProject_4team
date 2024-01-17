package dev.mvc.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("dev.mvc.admin.AdminProc")
public class AdminProc implements AdminProcInter {
    
 @Autowired
private AdminDAOInter adminDAO;
 
    public int admin_create(AdminVO adminVO) {
        int cnt = this.adminDAO.admin_create(adminVO);
        return cnt;
    }

    @Override
    public int admin_login(AdminVO adminVO) {
        int cnt = this.adminDAO.admin_login(adminVO);
        return cnt;
    }
 
} 
