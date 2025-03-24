package org.example.models;

import javax.persistence.*;

@Entity
@Table(name = "user_tbl")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    @Column(name = "user_name" , length = 16)
    private String userName ;

    @Column(name = "pwd" , length = 16)
    private String pwd;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return pwd;
    }

    public void setPassWord(String passWord) {
        this.pwd = passWord;
    }

    public User() {

    }
}
