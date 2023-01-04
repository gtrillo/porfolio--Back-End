
package com.portfolioGT.portfolioGT.segurity.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotNull
    private String nombre;
    @NotNull
    private String nombre_usuario;
    @NotNull
    private String email;
    @NotNull
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name="usuario_id"),inverseJoinColumns = @JoinColumn(name="rol_id"))
    private Set<Usuario> roles = new HashSet<>();

    public Usuario(int id, String nombre, String nombre_usuario, String email, String password) {
        this.id = id;
        this.nombre = nombre;
        this.nombre_usuario = nombre_usuario;
        this.email = email;
        this.password = password;
    }

    public Usuario() {
    }
    
    
}
