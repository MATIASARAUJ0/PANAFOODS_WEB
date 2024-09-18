package com.fia.avance2.controller;

import java.util.Map; 

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fia.avance2.model.entity.PNFoodsEntity;
import com.fia.avance2.models.service.IPNFoodsService;
 
@Controller
@SessionAttributes("pedido")  
public class PNFoodsController {

	@GetMapping("/navbar")
	public String navbar(Model model) {
		
		return "navbar";
	}
	
	@GetMapping("/nosotros") 
	public String us(Model model) {
		
		return "nosotros";
	}
	
	@GetMapping("/productos")
	public String products(Model model) {
		
		return "productos";
	}
	
	@GetMapping("/sostenibilidad")
	public String sostenibilidad(Model model) {
		
		return "sostenibilidad";
	}
	
	@GetMapping("/contacto")
	public String contact(Model model) {
		
		return "contacto";
	} 
	
	
	
	
	@Autowired
	private IPNFoodsService pedidoService;
	
	@RequestMapping(value="/listar",method = RequestMethod.GET)
	public String lista(Model model) {
		model.addAttribute("titulo", "Listado de Pedidos");
		model.addAttribute("pedidos", pedidoService.findAll());
		return "lista";
	}
	
	

	
	
	
	/* @Autowired
	private IPNFoodsService foodsService;*/

	@RequestMapping(value="/datos")
	public String crear(Map<String,Object>model) {
		
		PNFoodsEntity pedido=new PNFoodsEntity();
		model.put("pedido", pedido);
		model.put("titulo", "Registrar Pedido");
		return "portalEmpleado";
	}
	
	@RequestMapping(value="/datos", method=RequestMethod.POST)
	public String guardar(@Valid PNFoodsEntity pedido, BindingResult result,Model model,SessionStatus status) {
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Crear Pedido");
			return "datos";
		}
		pedidoService.save(pedido);
		status.setComplete();
		return "redirect:listar"; 
	}
	@RequestMapping(value="/portalEmpleado/{id}")
	public String editar(@PathVariable(value="id") Long id, Map<String, Object> model) {
		
		PNFoodsEntity pedido=null;
		
		if(id>0) {
			pedido=pedidoService.findOne(id);
		}else {
			return "redirect:/listar";
		}
		
		model.put("pedido", pedido);
		model.put("titulo", "Editar Pedido");
		return "portalEmpleado";
	}
	
	@RequestMapping(value="/eliminar/{id}")
	public String eliminar(@PathVariable(value="id") Long id) {
		
		if(id>0) {
			pedidoService.delete(id);
		}
		
		return "redirect:/listar"; 
	}
	
	@GetMapping(value="/ver/{id}")
	public String ver(@PathVariable(value="id") Long id,Map<String,Object>model,
			RedirectAttributes flash) {
		PNFoodsEntity pedido=pedidoService.findOne(id);
		if(pedido==null) {
			flash.addFlashAttribute("error", "El cliente no exite en la base de datos");
		return "redirect:/lista";
		}
		model.put("pedido", pedido);
		model.put("titulo", "Detalle del Proveedor N°: "+ pedido.getId()); 
		return "ver";
	}
	
}