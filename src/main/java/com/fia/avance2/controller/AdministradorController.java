package com.fia.avance2.controller;


import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.fia.avance2.dto.EmpleadoRegistroDTO;
import com.fia.avance2.model.entity.Empleado;
import com.fia.avance2.model.entity.PNFoodsEntity;
import com.fia.avance2.models.service.IEmpleadoService;
import com.fia.avance2.models.service.IPNFoodsService; 

@Controller
public class AdministradorController {
	
	
	@Autowired
	private IPNFoodsService pedidoService;
	
	@Autowired
	private IEmpleadoService servicio;
	
	@GetMapping("/adminLogin")
	public String admin(Model model) {
		 
		return "administrador"; 
	}
	
	
	@RequestMapping(value="/empleados",method = RequestMethod.POST) 
	public String empleados(Model model) {
		model.addAttribute("empleados",servicio.listarEmpleados());
		 
		return "gestionEmpleados";  
	}
	
	@RequestMapping(value="/gestPedidos",method = RequestMethod.GET) 
	public String gestPedidos(Model model) {
		
		model.addAttribute("pedidos", pedidoService.findAll());
		 
		return "gestionPedidos";  
	}
	@RequestMapping(value="/gestEmpleados",method = RequestMethod.GET) 
	public String gestEmpleados(Model model) {
		
		model.addAttribute("empleados",servicio.listarEmpleados());
		 
		return "gestionEmpleados";  
	}
	
	
	@GetMapping("/")
	public String verPaginaDeInicio(Model model) {
		
		return "redirect:listar";
	} 
	
	@GetMapping("/script.js")
	public String verPaginaDeInicioASD(Model model) {
		
		return "redirect:listar";
	} 
	
	
	@GetMapping("/pedidos") 
	public String pedidos(Model model) { 
		 
		return "gestionPedidos";  
	} 
	
	
	@RequestMapping("/intranet")
	public String intranet(Model model) {
		
		return "Intranet";
	} 
	
	
	
	@RequestMapping(value="/intranet", method=RequestMethod.POST)
	public String guardar(@Valid Empleado empleado, BindingResult result,Model model,SessionStatus status) {
		if(result.hasErrors()) {
			
			return "Intranet";
		}
		
		status.setComplete();
		return "redirect:intranet"; 
	}
	
	
	
	
	
	 
	
}
