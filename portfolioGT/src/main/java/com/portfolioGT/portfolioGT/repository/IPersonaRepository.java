
package com.portfolioGT.portfolioGT.repository;

import com.portfolioGT.portfolioGT.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepository extends JpaRepository<Persona, Long>{
    
}
