/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioGT.portfolioGT.controller;

import com.portfolioGT.portfolioGT.model.Persona;
import com.portfolioGT.portfolioGT.segurity.entidad.Saludo;
import com.portfolioGT.portfolioGT.service.IpersonaService;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class Controller {
    @Autowired public IpersonaService personaService;
    @PostMapping("api/new/persona")
    public void AgregarPersona(@RequestBody Persona per)
    {
        personaService.CrearPersona(per);
    }
    
    @GetMapping("api/ver/persona")
    @ResponseBody
    public List<Persona> VerPersonas()
    {
        return personaService.VerPersonas();
    }
    
    @GetMapping("api/ver/traerpersona")
    @ResponseBody
    public Persona TraerPersona()
    {
        return personaService.BuscarPersona(1);
    }
    
    
    
    @DeleteMapping("api/delete/{id}")
    public void BorrarPersona(long Id)
    {
        personaService.BorrarPersona(Id);
    }
    
    @PutMapping("api/editar/{id}")
    public Persona EditarPersona(@PathVariable Long id, 
                                 @RequestParam("nombre") String nuevoNombre,
                                 @RequestParam("apellido") String nuevoApellido,
                                 @RequestParam("url_foto") String nuevaUrl_foto
                               /*  @RequestParam("tecnologias_id") long nuevaTecnologias_id*/){
       Persona persona = personaService.BuscarPersona(id);
       
       persona.setNombre(nuevoNombre);
       persona.setApellido(nuevoApellido);
       persona.setUrl_foto(nuevaUrl_foto);
       /*persona.setTecnologias_id(nuevaTecnologias_id);*/
       
       
       return persona;
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @RestController
    @RequestMapping("/api/v1")
public class SaludoController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/greeting")
	public Saludo greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Saludo(counter.incrementAndGet(), String.format(template, name));
	}
}
}