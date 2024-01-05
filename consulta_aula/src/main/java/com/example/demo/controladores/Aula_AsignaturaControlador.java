package com.example.demo.controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entidades.Asignatura;
import com.example.demo.entidades.Aula;
import com.example.demo.entidades.Aula_Asignatura;
import com.example.demo.entidades.Dia;
import com.example.demo.services.AsignaturaService;
import com.example.demo.services.AulaService;
import com.example.demo.services.Aula_AsignaturaService;
import com.example.demo.services.DiaService;

@Controller
public class Aula_AsignaturaControlador {
	@Autowired
	private Aula_AsignaturaService aula_asign;
	@Autowired
	private AsignaturaService asign;
	@Autowired
	private DiaService dia;
	@Autowired
	private AulaService aula;

	@GetMapping("/aula_asignatura")
	public String iniciar(Model model) {
		List<Aula_Asignatura> listAula_Asign = aula_asign.findAll();
		model.addAttribute("aulas_asign", listAula_Asign);
		return "aula_asignatura_index";
	}

	@GetMapping("/aula_asignatura/mostrar/{id}")
	public String verDatos(@PathVariable int id, Model model) {
		try {
			Optional<Aula_Asignatura> Aula_Asignatura = aula_asign.findById(id);
			model.addAttribute("aula_asign_m", Aula_Asignatura.get());
		}catch(Exception e) {
			System.out.println("Error: "+e);
		}
		return "/mostrar_aula_asignatura";
	}

	@GetMapping("/aula_asignatura/editar/{id}")
	public String editar(@PathVariable int id, Model model){
		Optional<Aula_Asignatura> aula_asigns = aula_asign.findById(id);
		List<Asignatura> asignaturas = asign.findAll();
		List<Dia> dias = dia.findAll(Sort.by("ID"));
		List<Aula> aulas = aula.findAll();
		model.addAttribute("aula_asign", aula_asigns.get());
		model.addAttribute("asign", asignaturas);
		model.addAttribute("dia", dias);
		model.addAttribute("aula", aulas);
		return "/aula_asignatura_edit";
	}

	@GetMapping("/aula_asignatura/borrar/{id}")
	public String borrado(@PathVariable int id) {
		try {
			aula_asign.deleteById(id);
		}catch(Exception e){
		System.out.println("Error: " + e);
		}return"redirect:/aula_asignatura";
	}

	@GetMapping("/aula_asignatura/anadir")
	public String crear(Model model){
		Aula_Asignatura aula_asign = new Aula_Asignatura();
		List<Asignatura> asignaturas = asign.findAll();
		List<Dia> dias = dia.findAll(Sort.by("ID"));
		List<Aula> aulas = aula.findAll();
		model.addAttribute("aula_asign", aula_asign);
		model.addAttribute("asign", asignaturas);
		model.addAttribute("dia", dias);
		model.addAttribute("aula", aulas);
		return "aula_asignatura_add";
	}

	@PostMapping("/aula_asignatura/save")
	public String Guardar(@ModelAttribute Aula_Asignatura aula_asigns){
		aula_asign.save(aula_asigns);
		System.out.println("Aula_Asignatura guardada con éxito");
		return "redirect:/aula_asignatura";
	}
}
