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

import com.example.demo.entidades.Programa;
import com.example.demo.services.ProgramaService;

@Controller
public class ProgramaControlador {
	@Autowired
	private ProgramaService programa;

	@GetMapping("/programa")
	public String iniciar(Model model) {
		List<Programa> listAsignatura = programa.findAll();
		model.addAttribute("programas", listAsignatura);
		return "/programa_index";
	}

	@GetMapping("programa/mostrar/{id}")
	public String verDatos(@PathVariable int id, Model model) {
		try {
			Optional<Programa> Programa = programa.findById(id);
			model.addAttribute("programa_m", Programa.get());
		}catch(Exception e) {
			System.out.println("Error: "+e);
		}
		return "/mostrar_programa";
	}

	@GetMapping("/programa/editar/{id}")
	public String editar(@PathVariable int id, Model model){
		Optional<Programa> Programa = programa.findById(id);
		model.addAttribute("programa", Programa);
		return "programa_edit";
	}

	@GetMapping("programa/borrar/{id}")
	public String borrado(@PathVariable int id) {
		try {
			programa.deleteById(id);
		}catch(Exception e){
		System.out.println("Error: " + e);
		}return"redirect:/programa";
	}

	@GetMapping("/programa/anadir")
	public String crear(Model model){
		Programa prog = new Programa();
		model.addAttribute("programa", prog);
		return "programa_add";
	}

	@PostMapping("/programa/save")
	public String Guardar(@ModelAttribute Programa prog){
		programa.save(prog);
		System.out.println("Programa añadido con éxito");
		return "redirect:/programa";
	}
}
