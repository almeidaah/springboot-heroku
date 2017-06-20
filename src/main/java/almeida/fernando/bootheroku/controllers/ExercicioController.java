package almeida.fernando.bootheroku.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import almeida.fernando.bootheroku.model.Exercicio;
import almeida.fernando.bootheroku.services.ExercicioService;

@Controller
@RequestMapping("/exercicios")
public class ExercicioController {
	
	@Autowired
	private ExercicioService exercicioService;
	
	@GetMapping
	@ResponseBody
	public List<Exercicio> findAll(){
		return exercicioService.findAll();
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public Exercicio findOne(@PathVariable String id){
		return exercicioService.findOne(id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Exercicio> delete(@PathVariable String id){
		exercicioService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Exercicio> insert(@RequestBody Exercicio exercicio){
		exercicioService.insert(exercicio);
		return new ResponseEntity<Exercicio>(exercicio, HttpStatus.CREATED);
	}	
	
}
