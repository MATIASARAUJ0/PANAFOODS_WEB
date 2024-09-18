package com.fia.avance2.dto;

import java.io.Serializable;
import java.util.Date;

public class EmpleadoRegistroDTO{

	private static final long serialVersionUID = 1L;

	private Long id;
	private String dni;
	private String nombre;
	private String apellido;
	private String email;
	private String edad;
	private String celular;
	private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public EmpleadoRegistroDTO(Long id, String dni, String nombre, String apellido, String email, String edad,
			String celular, String password) {
		super();
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.edad = edad;
		this.celular = celular;
		this.password = password;
	}

	public EmpleadoRegistroDTO(String dni, String nombre, String apellido, String email, String edad, String celular,
			String password) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.edad = edad;
		this.celular = celular;
		this.password = password;
	}

	public EmpleadoRegistroDTO(String email) {
		super();
		this.email = email;
	}

	public EmpleadoRegistroDTO() {

	}

}
