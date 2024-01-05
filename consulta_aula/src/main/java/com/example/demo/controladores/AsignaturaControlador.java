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

import com.example.demo.entidades.Asignatura;
import com.example.demo.entidades.Docente;
import com.example.demo.entidades.Programa;
import com.example.demo.services.AsignaturaService;
import com.example.demo.services.DocenteService;
import com.example.demo.services.ProgramaService;

@Controller
public class AsignaturaControlador {
	@Autowired
	private AsignaturaService asignatura;
	@Autowired
	private DocenteService docente;
	@Autowired
	private ProgramaService programa;

	@GetMapping("/asignatura")
	public String iniciar(Model model) {
		List<Asignatura> listAsignatura = asignatura.findAll();
		model.addAttribute("asignaturas", listAsignatura);
		return "/asignatura_index";
	}

	@GetMapping("/asignatura/mostrar/{id}")
	public String verDatos(@PathVariable int id, Model model) {
		try {
			Optional<Asignatura> Asignatura = asignatura.findById(id);
			model.addAttribute("asignatura_m", Asignatura.get());
		}catch(Exception e) {
			System.out.println("Error: "+e);
		}
		return "/mostrar_asignatura";
	}

	@GetMapping("/asignatura/editar/{cod}")
	public String editar(@PathVariable int cod,  Model model){
		Optional<Asignatura> Asignatura = asignatura.findById(cod);
		List<Docente> docentes = docente.findAll();
		List<Programa> programas = programa.findAll();
		model.addAttribute("asign", Asignatura.get());
		model.addAttribute("docente", docentes);
		model.addAttribute("programa", programas);
		return "asignatura_edit";
	}

	@GetMapping("/asignatura/borrar/{cod}")
	public String borrado(@PathVariable int cod) {
		try {
			asignatura.deleteById(cod);
		}catch(Exception e){
		System.out.println("Error: " + e);
		}return"redirect:/asignatura";
	}

	@GetMapping("/asignatura/anadir")
	public String crear(Model model){
		Asignatura asign = new Asignatura();
		List<Docente> docentes = docente.findAll();
		List<Programa> programas = programa.findAll();
		model.addAttribute("asign", asign);
		model.addAttribute("docente", docentes);
		model.addAttribute("programa", programas);
		return "asignatura_add";
	}

	@PostMapping("/asignatura/save")
	public String Guardar(@ModelAttribute Asignatura asigns){
		asignatura.save(asigns);
		System.out.println("Asignatura guardada con éxito");
		return "redirect:/asignatura";
	}
}
