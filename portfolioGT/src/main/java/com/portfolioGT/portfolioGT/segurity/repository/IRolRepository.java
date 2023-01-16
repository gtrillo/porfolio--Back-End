/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioGT.portfolioGT.segurity.repository;

import com.portfolioGT.portfolioGT.segurity.entidad.Rol;
import com.portfolioGT.portfolioGT.segurity.enumerados.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolRepository extends JpaRepository<Rol,Integer>{
    Optional <Rol> findByRolNombre(RolNombre rolRombre);
    
}
