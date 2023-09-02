package com.ec.service.to;

import java.io.Serializable;

public class UsuarioTO implements Serializable  {

    private static final long serialVersionUID = 1L;

    private String userName;
    private String pasword;

    private String semilla;
    private Integer tiempoVigencia;

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

    public String getSemilla() {
        return semilla;
    }

    public void setSemilla(String semilla) {
        this.semilla = semilla;
    }

    public Integer getTiempoVigencia() {
        return tiempoVigencia;
    }

    public void setTiempoVigencia(Integer tiempoVigencia) {
        this.tiempoVigencia = tiempoVigencia;
    }
}
