package model;

public class Admin{

    private String nama ; 
    private String userName; 
    private String password;



    public Admin(String nama, String userName, String password) {
        this.nama = nama;
        this.userName = userName;
        this.password = password;
    }

    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    
    
}
