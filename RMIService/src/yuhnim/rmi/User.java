package yuhnim.rmi;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class User implements Serializable{
    private static final long serialVersionUID = 227L;
    private Integer ID;
    private String name;
    private ArrayList<Licence> licences;

    public User() {
    }

    public User(String name, ArrayList<Licence> licences) {
        this.name = name;
        this.licences = licences;
    }

    public User(Integer userId) {
        this.ID = userId;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Licence> getLicences() {
        return this.licences;
    }

    public void setLicences(ArrayList<Licence> licences) {
        this.licences = licences;
    }

    public User name(String name) {
        this.name = name;
        return this;
    }

    public User licences(ArrayList<Licence> licences) {
        this.licences = licences;
        return this;
    }



    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof User)) {
            return false;
        }
        User User = (User) o;
        return Objects.equals(name, User.name) && Objects.equals(licences, User.licences);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, licences);
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", licences=" + licences +
                '}';
    }

    //Add more
    public boolean equals_user(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof User)) {
            return false;
        }
        User User = (User) o;
        return Objects.equals(name, User.name) && Objects.equals(licences, User.licences);
    }

    public String toStringLicences() {
        return "User{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", licences=" + licences +
                '}';
    }
    
}