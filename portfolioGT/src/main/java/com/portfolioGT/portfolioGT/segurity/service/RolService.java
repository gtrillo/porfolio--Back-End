
package com.portfolioGT.portfolioGT.segurity.service;

import com.portfolioGT.portfolioGT.segurity.entidad.Rol;
import com.portfolioGT.portfolioGT.segurity.enumerados.RolNombre;
import com.portfolioGT.portfolioGT.segurity.repository.IRolRepository;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService {
    @Autowired
    IRolRepository irolRepository;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return irolRepository.findByRolNombre(rolNombre);
    }
    
    public void save(Rol rol){
        irolRepository.save(rol);
    }
}