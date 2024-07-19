package com.edu.uce.pw.api.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edu.uce.pw.api.repository.modelo.Estudiante;
import com.edu.uce.pw.api.repository.modelo.Materia;
import com.edu.uce.pw.api.service.IEstudianteService;
import com.edu.uce.pw.api.service.IMateriaService;
import com.edu.uce.pw.api.service.to.EstudianteTO;
import com.edu.uce.pw.api.service.to.MateriaTO;

@RestController
@RequestMapping(path = "/estudiantes")
public class EstudianteController {

	// Se inyecta la capa Service
	@Autowired
	private IEstudianteService estudianteService;

	@Autowired
	private IMateriaService iMateriaService;

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/guardar
	// Nivel 1: http://localhost:8080/API/v1.0/Matricula/estudiantes
	@PostMapping(produces = "application/json", consumes = "application/xml")
	public ResponseEntity<Estudiante> guardar(@RequestBody Estudiante est) {

		HttpHeaders cabeceraPost = new HttpHeaders();
		cabeceraPost.add("mensaje_201", "Corresponde a la inserción de un recurso");
		cabeceraPost.add("valor", "Estudiante insertado con éxito");

//		Estudiante est= new Estudiante();
//		est.setNombre("Alex");
//		est.setApellido("Andrango");
//		est.setFechaNacimiento(LocalDateTime.of(1999,11,21,1,1));
		this.estudianteService.guardar(est);
		return ResponseEntity.status(201).body(est);

	}

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/actualizar
	// Nivel 1:http://localhost:8080/API/v1.0/Matricula/estudiantes/2
	@PutMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<Estudiante> actualizar(@RequestBody Estudiante est, @PathVariable Integer id) {
//		Estudiante est=this.estudianteService.buscar(1);
//		est.setNombre("Ronaldo");
//		est.setApellido("Tuquerres");
//		est.setFechaNacimiento(LocalDateTime.of(1997,21,11,1,1));
		est.setId(id);
		this.estudianteService.actualizar(est);

		HttpHeaders cabeceraPut = new HttpHeaders();
		cabeceraPut.add("mensaje_238", "Corresponde a la actualización de un recurso");
		cabeceraPut.add("valor", "Estudiante actualizado");
		return new ResponseEntity<>(est, cabeceraPut, 238);

	}

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/actualizarParcial
	// Nivel 1:http://localhost:8080/API/v1.0/Matricula/estudiantes/2
	@PatchMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<Estudiante> actualizarParcial(@RequestBody Estudiante est, @PathVariable Integer id) {
		est.setId(id);
		Estudiante est2 = this.estudianteService.buscar(est.getId());
		if (est.getNombre() != null) {
			est2.setNombre(est.getNombre());
		}
		if (est.getApellido() != null) {
			est2.setApellido(est.getApellido());
		}
		if (est.getFechaNacimiento() != null) {
			est2.setFechaNacimiento(est.getFechaNacimiento());
		}

		this.estudianteService.actualizar(est2);
		return ResponseEntity.status(239).body(est2);
	}

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/borrar
	// http://localhost:8080/API/v1.0/Matricula/estudiantes/borrar/1
	// Nivel 1: http://localhost:8080/API/v1.0/Matricula/estudiantes/2
	@DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> borrar(@PathVariable Integer id) {

		System.out.println("Borrar");
		this.estudianteService.borrar(id);

		HttpHeaders cabeceraDelete = new HttpHeaders();
		cabeceraDelete.add("mensaje_240", "Corresponde a la eliminación del recurso");
		cabeceraDelete.add("valor", "Estudiante eliminado");
		return new ResponseEntity<>("Eliminado correctamente", cabeceraDelete, 240);

	}

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/buscar/1/nuevo/prueba
	// Nivel 1: http://localhost:8080/API/v1.0/Matricula/estudiantes/1
	@GetMapping(path = "/{id}", produces = "application/json")
	public ResponseEntity<Estudiante> buscarPorId(@PathVariable Integer id) {
		// return ResponseEntity.status(236).body(this.estudianteService.buscar(id));
		HttpHeaders cabeceras = new HttpHeaders();
		cabeceras.add("mensaje_236", "Corresponde a la consulta de un recurso");
		cabeceras.add("valor", "Estudiante encontrado");
		return new ResponseEntity<>(this.estudianteService.buscar(id), cabeceras, 236);
	}

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/buscarPorGenero?genero=F&edad=35
	// Nivel 1: http://localhost:8080/API/v1.0/Matricula/estudiantes/genero?genero=F
	@GetMapping(path = "/genero")
	public List<Estudiante> buscarPorGenero(@RequestParam String genero) {
		List<Estudiante> lista = this.estudianteService.buscarPorGenero(genero);
		return lista;

	}

	@GetMapping(path = "/texto/plano")
	public String prueba() {
		String prueba = "Texto de prueba";
		return prueba;

	}

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/buscarMixto/2?prueba=HolaMundo
	// Nivel 1:
	// http://localhost:8080/API/v1.0/Matricula/estudiantes/mixto/2?prueba=HolaMundo
	@GetMapping(path = "/mixto/{id}")
	public Estudiante buscarMixto(@PathVariable Integer id, @RequestParam String prueba) {
		System.out.println("ID:" + id);
		System.out.println("Prueba:" + prueba);
		return this.estudianteService.buscar(id);

	}

	// Nivel 1: http://localhost:8080/API/v1.0/Matricula/estudiantes/test/1
	@GetMapping(path = "/test/{id}")
	public Estudiante test(@PathVariable Integer id, @RequestBody Estudiante est) {
		System.out.println(est);
		return this.estudianteService.buscar(id);
	}

	@GetMapping(path = "/hateoas/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public EstudianteTO buscarHateoas(@PathVariable Integer id) {
		EstudianteTO est = this.estudianteService.buscarPorId(id);

		// ERROR esto es una carga EAGER
		// List<MateriaTO> lista = this.iMateriaService.seleccionarPorIdEstudiante(id);
		// est.setMaterias(lista);
		Link myLink = linkTo(methodOn(EstudianteController.class).buscarMateriasPorIdEstudiante(id))
				.withRel("susMaterias");

		Link myLink2 = linkTo(methodOn(EstudianteController.class).buscarPorId(id)).withSelfRel();
		est.add(myLink);
		est.add(myLink2);
		return est;
	}

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/7/materias GET
	@GetMapping(path = "/{id}/materias", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<MateriaTO> buscarMateriasPorIdEstudiante(@PathVariable Integer id) {
		return this.iMateriaService.seleccionarPorIdEstudiante(id);
	}

	@GetMapping(path = "/hateoasEst", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<EstudianteTO> buscarEstudianteTOHateoas() {

		List<EstudianteTO> lista = this.estudianteService.bsucarTodosEstudiantes();

		for (EstudianteTO est : lista) {
			Link myLink = linkTo(methodOn(EstudianteController.class).buscarMateriasPorIdEstudiante(est.getId()))
					.withRel("susMaterias");

			est.add(myLink);
		}

		return lista;
	}
	
	
	
	
	
	
	
	////////////////////////CAPACIDADES PARA VUE///////////////////////////////////
	@PutMapping(path = "/cedula/{cedula}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<Estudiante> actualizarPorCedula(@RequestBody Estudiante est, @PathVariable Integer cedula) {

		est.setId(cedula);
		this.estudianteService.actualizarPorCedula(est);

		HttpHeaders cabeceraPut = new HttpHeaders();
		cabeceraPut.add("mensaje_238", "Corresponde a la actualización de un recurso");
		cabeceraPut.add("valor", "Estudiante actualizado");
		return new ResponseEntity<>(est, cabeceraPut, 238);

	}
	
	
	@DeleteMapping(path = "/cedula/{cedula}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> borrarPorCedula(@PathVariable Integer cedula) {

		System.out.println("Borrar");
		this.estudianteService.borrarPorCedula(cedula);

		HttpHeaders cabeceraDelete = new HttpHeaders();
		cabeceraDelete.add("mensaje_240", "Corresponde a la eliminación del recurso");
		cabeceraDelete.add("valor", "Estudiante eliminado");
		return new ResponseEntity<>("Eliminado correctamente", cabeceraDelete, 240);

	}
	
	@GetMapping(path = "/cedula/{cedula}", produces = MediaType.APPLICATION_JSON_VALUE)
	public EstudianteTO buscarPorCedula(@PathVariable Integer cedula) {
		EstudianteTO est = this.estudianteService.buscarPorId(cedula);

		return est;
	}

}