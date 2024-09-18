package com.fia.avance2.models.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.fia.avance2.dto.EmpleadoRegistroDTO;
import com.fia.avance2.model.dao.IEmpleadoDao;
import com.fia.avance2.model.entity.Empleado;
import com.fia.avance2.model.entity.Rol;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService{

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	private IEmpleadoDao empleadoRepositorio;
	
	
	public EmpleadoServiceImpl(IEmpleadoDao empleadoRepositorio) {
		super();
		this.empleadoRepositorio = empleadoRepositorio;
	}


	@Override
	public Empleado guardar(EmpleadoRegistroDTO registroDTO) {
		Empleado empleado = new Empleado(registroDTO.getDni(),
				registroDTO.getNombre(),registroDTO.getApellido(),
				registroDTO.getEmail(),registroDTO.getEdad(),
				registroDTO.getCelular(),passwordEncoder.encode(registroDTO.getPassword()),
				Arrays.asList(new Rol("ROLE_USER")));
		return empleadoRepositorio.save(empleado);
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Empleado empleado = empleadoRepositorio.findByEmail(username);
		if(empleado==null) {
			throw new UsernameNotFoundException("Usuario o password inválidos");
		}
		return new User(empleado.getEmail(), empleado.getPassword(), mapearAutoridadesRoles(empleado.getRoles()));
	}
	
	private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<Rol> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());
	}
	
	@Override
	public List<Empleado> listarEmpleados() {
		return empleadoRepositorio.findAll();
	}
}
