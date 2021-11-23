package model;

public class UserManager {
    
    private static UserManager instance;
    private EnumJabatan userType;
    private Person person;
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
    public void setUser(Person person) {
        if(person instanceof Kasir) {
            this.kasir = (Kasir) person;
            userType = EnumJabatan.KASIR;
        } else if(person instanceof Person) {
            this.person = (Person) person;
        } else {
            this.person = (Person) person;
            userType = EnumJabatan.ADMIN;
        }
    }
    public Person getUser(){
        return person;
    }
    
    public void logOut() {
        instance = null;
        userType = null;
    }   
}