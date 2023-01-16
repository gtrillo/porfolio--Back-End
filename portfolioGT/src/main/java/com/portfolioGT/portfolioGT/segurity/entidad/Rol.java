
package com.portfolioGT.portfolioGT.segurity.entidad;

import com.portfolioGT.portfolioGT.segurity.enumerados.RolNombre;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import javax.validation.constraints.NotNull;


@Entity

public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
     public int id;
    
    
    @NotNull
    @Enumerated(EnumType.STRING)
    public RolNombre nombre_rol;

    public Rol(RolNombre nombre_rol) {
        this.nombre_rol = nombre_rol;
    }

    public Rol() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RolNombre getNombre_rol() {
            return nombre_rol;
        }

    public void setNombre_rol(RolNombre nombre_rol) {
        this.nombre_rol = nombre_rol;
    }
    
    
}
