
package com.portfolioGT.portfolioGT.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import static java.lang.Long.max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



        
       
@Entity
public class Persona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUrl_foto() {
        return url_foto;
    }

    public void setUrl_foto(String url_foto) {
        this.url_foto = url_foto;
    }

    /*public long getTecnologias_id() {
        return tecnologias_id;
    }

    public void setTecnologias_id(long tecnologias_id) {
        this.tecnologias_id = tecnologias_id;
    }*/
    
    @NotNull
 
   // @Size(min = 1, max 48, message ="longitud no valida")
    private String nombre;
    private String apellido;
    @Size(min = 0, max=300)
    private String acerca_de;
    private String profesion;
    private String url_foto;
    
    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }
    public String getAcerca_de() {
        return acerca_de;
    }

    public void setAcerca_de(String acerca_de) {
        this.acerca_de = acerca_de;
    }
   /* private long tecnologias_id;*/
    
    public Persona(long id, String nombre, String apellido, String url_foto, String acerca_de,String profesion/*,long tecnologias_id*/) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.url_foto = url_foto;
        this.acerca_de = acerca_de;
        this.profesion = profesion;
        /*this.tecnologias_id = tecnologias_id;*/
    }
    
    public Persona()
    {
    }      

  
      
   
}