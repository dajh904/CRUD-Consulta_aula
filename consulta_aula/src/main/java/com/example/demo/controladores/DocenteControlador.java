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

import com.example.demo.entidades.Docente;
import com.example.demo.services.DocenteService;

@Controller
public class DocenteControlador {
	@Autowired
	private DocenteService docente;

	@GetMapping("/docente")
	public String iniciar(Model model) {
		List<Docente> listAsignatura = docente.findAll();
		model.addAttribute("docentes", listAsignatura);
		return "/docente_index";
	}

	@GetMapping("/docente/mostrar/{id}")
	public String verDatos(@PathVariable int id, Model model) {
		try {
			Optional<Docente> Docente = docente.findById(id);
			model.addAttribute("docente_m", Docente.get());
		}catch(Exception e) {
			System.out.println("Error: "+e);
		}
		return "/mostrar_docente";
	}

	@GetMapping("/docente/editar/{id}")
	public String editar(@PathVariable int id, Model model){
		Optional<Docente> Docente = docente.findById(id);
		model.addAttribute("docente", Docente);
		return "docente_edit";
	}

	@GetMapping("/docente/borrar/{id}")
	public String borrado(@PathVariable int id) {
		try {
			docente.deleteById(id);
		}catch(Exception e){
		System.out.println("Error: " + e);
		}return"redirect:/docente";
	}
	
	@GetMapping("/docente/anadir")
	public String crear(Model model){
		Docente docente = new Docente();
		model.addAttribute("docente", docente);
		return "docente_add";
	}

	@PostMapping("/docente/save")
	public String Guardar(@ModelAttribute Docente docentes){
		docente.save(docentes);
		System.out.println("Docente añadido con éxito");
		return "redirect:/docente";
	}
}
