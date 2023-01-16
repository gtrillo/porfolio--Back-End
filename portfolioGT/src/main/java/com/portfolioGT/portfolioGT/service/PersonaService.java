
package com.portfolioGT.portfolioGT.service;

import com.portfolioGT.portfolioGT.model.Persona;
import java.io.Serial;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
    
@Service
public class PersonaService implements IpersonaService{

    @Autowired
    public IPersonaRepository repoPerso;
    @Override
    public List<Persona> VerPersonas() {
        
        return repoPerso.findAll();
        
    }
    @Override
    public void CrearPersona(Persona per) {
      repoPerso.save(per);
    }

    @Override
    public void BorrarPersona(long id) {
       repoPerso.deleteById((int)id);
    }

    @Override
    public Persona BuscarPersona(long id) {
      return repoPerso.findById((int)id).orElse(null);
    }
   
}
    