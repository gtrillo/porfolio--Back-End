package com.portfolioGT.portfolioGT.segurity.entidad;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UsuarioPrincipal implements UserDetails
{

    public UsuarioPrincipal(String nombre, String apellido, String nombreUsuario, String password, String email,Collection<? extends GrantedAuthority> autoridades) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.autoridades = autoridades;
    }
    private String nombre;
    private String apellido;
    private String nombreUsuario;
    private String password;
    private String email;
    private Collection<? extends GrantedAuthority> autoridades;

    public static UsuarioPrincipal build (Usuario usuario){
        List<GrantedAuthority> autoridades = usuario.getRoles().stream().
                map(rol->new SimpleGrantedAuthority(rol.getNombre_rol().name())).
                collect(Collectors.toList());
        return new UsuarioPrincipal(usuario.getNombre(),usuario.getNombre(),usuario.getNombreUsuario(),usuario.getPassword(),usuario.getEmail(),autoridades);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       return autoridades;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return nombreUsuario;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
       return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String getEmail(){
        return email;
    }
}
