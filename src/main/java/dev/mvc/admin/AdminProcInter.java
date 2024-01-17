package dev.mvc.admin;

public interface AdminProcInter {
    /**
     * 
     * @param adminVO
     * @return
     */
    public int admin_create(AdminVO adminVO);
    /**
     * 
     * @param adminVO
     * @return
     */
    public int admin_login(AdminVO adminVO);
}
