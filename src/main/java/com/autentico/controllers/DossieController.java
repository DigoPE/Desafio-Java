package com.autentico.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.autentico.models.ComprovanteM;
import com.autentico.models.DossieUsu;
import com.autentico.repository.ComprovanteRepository;
import com.autentico.repository.DossieRepository;

@Controller
public class DossieController {
	
	@Autowired
	private DossieRepository doss;
	
	@Autowired
	private ComprovanteRepository cr;

	@Autowired
	private ComprovanteRepository cor;
	
	@RequestMapping(value="/cadastraDossie", method=RequestMethod.GET)
	public String form(){
		return "dossie/FormDossieUsu";
	}
	
	@RequestMapping(value="/cadastraDossie", method=RequestMethod.POST)
	public String form(@Valid DossieUsu dossiu, BindingResult result, RedirectAttributes attributes){
		if(result.hasErrors()){
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/cadastraDossie";
		}
		doss.save(dossiu);
		attributes.addFlashAttribute("mensagem", "Dossiê cadastrado com sucesso!");
		return "dossie/FormDossieUsu";
	}
	
	@RequestMapping("/listaDossie")
	public ModelAndView listaDossie(){
		ModelAndView mv = new ModelAndView("listaDossieUsu");
		Iterable<DossieUsu> dossiUsu = doss.findAll();
		mv.addObject("dossiusu", dossiUsu);
		return mv;
	}
	
	@RequestMapping(value="/{matricula}", method=RequestMethod.GET)
	//@RequestMapping("/{matricula}")
	public ModelAndView detalhesDossieUsu(@PathVariable("matricula") long matricula){
		DossieUsu dossiusu = doss.findByMatricula(matricula);
		
		ModelAndView mv = new ModelAndView("dossie/detalhesDossieUsu");
		mv.addObject("dossiusu", dossiusu);
		
		Iterable<ComprovanteM> comprovantes = cr.findByDossieUsu(dossiusu);
		mv.addObject("comprovantes", comprovantes);
		
		//System.out.println("dossiusu" + dossiusu);
		return mv;
	}
	
	/*
	@RequestMapping(value="/{matricula}", method=RequestMethod.POST)
	//@RequestMapping("/{matricula}")
	public ModelAndView detalhesComprovante(@PathVariable("matricula") long matricula){
		DossieUsu dossiusu = doss.findByMatricula(matricula);
		
		ModelAndView mv = new ModelAndView("dossie/detalhesComprovante");
		mv.addObject("dossiusu", dossiusu);
		
		Iterable<ComprovanteM> doccomprovante = cr.findByDossieUsu(dossiusu);
		mv.addObject("doccomprovante", doccomprovante);
		
		//System.out.println("dossiusu" + dossiusu);
		return mv;
	}
	*/
	
	@RequestMapping("/deletarDossieUsu")
	public String deletarDossieUsu(long matricula){
		DossieUsu dossiusu = doss.findByMatricula(matricula);
		doss.delete(dossiusu);
		return "redirect:/listaDossie";
	}
	
	
	@RequestMapping(value="/{matricula}", method=RequestMethod.POST)
	public String detalhesDossieUsuPost(@PathVariable("matricula") long matricula, @Valid ComprovanteM comprovante, BindingResult result, RedirectAttributes attributes){
		
		if(result.hasErrors()){
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/{matricula}";
		}
		
		DossieUsu dossieUsu = doss.findByMatricula(matricula);
		comprovante.setDossieUsu(dossieUsu);
		cr.save(comprovante);
		attributes.addFlashAttribute("mensagem", "Convidado adicionado com sucesso!");
		return "redirect:/{matricula}";
	}
	
	
	@RequestMapping("/deletarComprovante")
	public String deletarComprovante(long idcomp){
		ComprovanteM comprov = cr.findByidcomp(idcomp);
		cr.delete(comprov);

		DossieUsu dossieUsu = comprov.getDossieUsu();
		long matriculaLong = dossieUsu.getMatricula();
		String matricula = "" + matriculaLong;
		return "redirect:/" + matricula;
	}
	
	
}
	
