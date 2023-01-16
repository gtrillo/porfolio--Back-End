
package com.portfolioGT.portfolioGT.segurity.Dto;

import javax.validation.constraints.NotBlank;

public class LoginUsuario {
    @NotBlank
    private String Nombreusuario;
     @NotBlank
    private String password;

    public String getNombreusuario() {
        return Nombreusuario;
    }

    public void setNombreusuario(String Nombreusuario) {
        this.Nombreusuario = Nombreusuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
     
     
}
