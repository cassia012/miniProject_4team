package dev.mvc.admin;

public class AdminVO {
  private int adminno;
  private String id;
  private String passwd;
  private String mname;
  private String mdate;
  
    public int getAdminno() {
        return adminno;
    }
    public void setAdminno(int adminno) {
        this.adminno = adminno;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getPasswd() {
        return passwd;
    }
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
    public String getMname() {
        return mname;
    }
    public void setMname(String mname) {
        this.mname = mname;
    }
    public String getMdate() {
        return mdate;
    }
    public void setMdate(String mdate) {
        this.mdate = mdate;
    }
  
  
}