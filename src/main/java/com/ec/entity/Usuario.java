package com.ec.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_id_usua")
    @SequenceGenerator(name = "sec_id_usua", sequenceName = "sec_id_usua", allocationSize = 1)
    @Column(name = "usua_id")
    private Integer id;


    @Column(name = "usua_userName")
    private String userName;
    @Column(name = "usua_pasword")
    private String pasword;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }
}
