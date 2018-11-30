package com.autentico.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.autentico.models.UsuariosM;
import com.autentico.repository.UsuarioRepository;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioRepository usua;
	
	@RequestMapping(value="/cadastraUsuario", method=RequestMethod.GET)
	public String form(){
		return "usu/FormUsuario";
	}
	
	@RequestMapping(value="/cadastraUsuario", method=RequestMethod.POST)
	public String form(UsuariosM usum){
		
		usua.save(usum);
		
		return "usu/FormUsuario";
	}
	
	@RequestMapping("/listaUsuario")
	public ModelAndView listaUsuario(){
		ModelAndView mv = new ModelAndView("listaUsuario");
		Iterable<UsuariosM> usuS = usua.findAll();
		mv.addObject("usuarios", usuS);
		return mv;
	}
	
	@RequestMapping("/deletarUsuario")
	public String deletarUsuario(String login){
		UsuariosM usuario = usua.findByLogin(login);
		usua.delete(usuario);
		return "redirect:/listaUsuario";
	}
	
}
