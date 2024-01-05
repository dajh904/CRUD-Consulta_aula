package com.example.demo.controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entidades.Aula;
import com.example.demo.services.AulaService;

@Controller
public class AulaControlador {
	@Autowired
	private AulaService aula;

	@GetMapping("/aula")
	public String iniciar(Model model) {
		List<Aula> listAsignatura = aula.findAll();
		model.addAttribute("aulas", listAsignatura);
		return "aula_index";
	}

	@GetMapping("/aula/mostrar/{id}")
	public String verDatos(@PathVariable String id, Model model) {
		try {
			Optional<Aula> Aula = aula.findById(id);
			model.addAttribute("aula_m", Aula.get());
		}catch(Exception e) {
			System.out.println("Error: "+e);
		}
		return "/mostrar_aula";
	}

	@GetMapping("/aula/editar/{id}")
	public String editar(@PathVariable String id, Model model){
		Optional<Aula> Aula = aula.findById(id);
		model.addAttribute("aula", Aula);
		return "aula_edit";
	}

	@GetMapping("/aula/borrar/{id}")
	public String borrado(@PathVariable String id) {
		try {
			aula.deleteById(id);
		}catch(Exception e){
		System.out.println("Error: " + e);
		}return"redirect:/aula";
	}

	@GetMapping("/aula/anadir")
	public String crear(Model model){
		Aula aula = new Aula();
		model.addAttribute("aula", aula);
		return "aula_add";
	}

	@PostMapping("/aula/save")
	public String Guardar(@ModelAttribute Aula aulas){
		aula.save(aulas);
		System.out.println("Aula guardada con éxito");
		return "redirect:/aula";
	}
}
