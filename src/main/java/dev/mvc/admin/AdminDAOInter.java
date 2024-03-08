package dev.mvc.admin;

public interface AdminDAOInter {

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
