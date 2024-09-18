package com.fia.avance2.models.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.fia.avance2.dto.EmpleadoRegistroDTO;
import com.fia.avance2.model.entity.Empleado;
 
public interface IEmpleadoService extends UserDetailsService{
	 
	public Empleado guardar(EmpleadoRegistroDTO registroDTO);
	
	public List<Empleado> listarEmpleados();
	
}
