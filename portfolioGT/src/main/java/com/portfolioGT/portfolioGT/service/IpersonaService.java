
package com.portfolioGT.portfolioGT.service;

import com.portfolioGT.portfolioGT.model.Persona;
import java.util.List;


public interface IpersonaService {
    public List<Persona> VerPersonas();
    public void CrearPersona(Persona per);
    public void BorrarPersona(long id);
    public Persona BuscarPersona(long id);
}
