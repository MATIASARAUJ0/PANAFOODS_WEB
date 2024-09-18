package com.fia.avance2.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fia.avance2.dto.EmpleadoRegistroDTO;
import com.fia.avance2.models.service.IEmpleadoService;

@Controller
@RequestMapping("/frmEmpleado")
public class RegistroEmpleadoController {
	
	
	private IEmpleadoService empleadoService;

	public RegistroEmpleadoController(IEmpleadoService empleadoService) {
		super();
		this.empleadoService = empleadoService;
	}

	
	@ModelAttribute("empleado")
    public EmpleadoRegistroDTO retornarNuevoEmpleadoRegistroDTO() {
		return new EmpleadoRegistroDTO();
	}
	
	@GetMapping
	public String mostrarFormularioDeRegistro() {
		return "frmEmpleado";
	}
	
	@PostMapping
	public String registrarCuentaDeEmpleado(@ModelAttribute("empleado") EmpleadoRegistroDTO registroDTO) {
		empleadoService.guardar(registroDTO);
		return "redirect:/frmEmpleado?exito";
	}
	
}
