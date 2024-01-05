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

import com.example.demo.entidades.Dia;
import com.example.demo.services.DiaService;

@Controller
public class DiaControlador {
	@Autowired
	private DiaService dia;

	@GetMapping("/")
	public String redireccionar(){
		return "redirect:/dia";
	}

	@GetMapping("/dia")
	public String iniciar(Model model) {
		List<Dia> listDay = dia.findAll(Sort.by("ID"));
		model.addAttribute("dias", listDay);
		return "/dia_index";
	}

	@GetMapping("/dia/mostrar/{id}")
	public String verDatos(@PathVariable int id, Model model) {
		try {
			Optional<Dia> Dia = dia.findById(id);
			model.addAttribute("dias_m", Dia.get());
		}catch(Exception e) {
			System.out.println("Error: "+e);
		}
		return "/mostrar_dia";
	}

	@GetMapping("/dia/editar/{id}")
	public String editar(@PathVariable int id, Model model){
		Optional<Dia> Dia = dia.findById(id);
		model.addAttribute("dia", Dia);
		return "dia_edit";
	}

	@GetMapping("/dia/anadir")
	public String crear(Model model){
		Dia dia = new Dia();
		model.addAttribute("dia", dia);
		return "dia_add";
	}

	@PostMapping("/dia/save")
	public String Guardar(@ModelAttribute Dia dias){
		dia.save(dias);
		System.out.println("Dia añadido con éxito");
		return "redirect:/dia";
	}

	@GetMapping("/dia/borrar/{id}")
	public String borrado(@PathVariable int id) {
		try {
			dia.deleteById(id);
		}catch(Exception e){
		System.out.println("Error: " + e);
		}return"redirect:/dia";
	}

	@GetMapping("/prueba")
	public String probarr(Model model) {
		List<Dia> listDay = dia.findAll(Sort.by("ID"));
		model.addAttribute("dias", listDay);
		return "/prueba";
	}
}
