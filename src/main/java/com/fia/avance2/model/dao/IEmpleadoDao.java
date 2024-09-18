package com.fia.avance2.model.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fia.avance2.model.entity.Empleado;

@Repository
public interface IEmpleadoDao extends JpaRepository<Empleado, Long>{
 	  
	public Empleado findByEmail(String email);
}
