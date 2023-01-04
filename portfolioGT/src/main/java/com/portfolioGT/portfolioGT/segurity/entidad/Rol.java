
package com.portfolioGT.portfolioGT.segurity.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
     private int id;
    @NotNull
    private String nombre_rol;

    public Rol(String nombre_nombre) {
        this.nombre_rol = nombre_nombre;
    }

    public Rol() {
    }
    
    
}
