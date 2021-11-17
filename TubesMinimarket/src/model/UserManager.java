package model;

public class UserManager {
    
    private static UserManager instance;
    private EnumJabatan userType;
    private Kasir kasir;
    private Admin admin;
    
    public static UserManager getInstance() {
        if(instance==null) {
            instance = new UserManager();
        }
        return instance;
    }

    public EnumJabatan getUserType() {
        return userType;
    }
    
    public void setUser(Object object) {
        if(object instanceof Kasir) {
            this.kasir = (Kasir) object;
            userType = EnumJabatan.KASIR;
        } else {
            this.admin = (Admin) object;
            userType = EnumJabatan.ADMIN;
        }
    }
    
    public Kasir getKasir() {
        return kasir;
    }

    public Admin getAdmin() {
        return admin;
    }
    
    public void logOut() {
        instance = null;
        userType = null;
    }   
}