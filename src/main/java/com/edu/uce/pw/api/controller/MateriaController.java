package com.edu.uce.pw.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.uce.pw.api.repository.modelo.Materia;
import com.edu.uce.pw.api.service.IMateriaService;

@RestController
@RequestMapping(path = "/materias")
public class MateriaController {

    @Autowired
    private IMateriaService iMateriaService;

    @PostMapping(produces = MediaType.APPLICATION_XML_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Materia> guardar(@RequestBody Materia mat) {
        this.iMateriaService.guardar(mat);
        
		HttpHeaders cabeceraPost= new HttpHeaders();
		cabeceraPost.add("mensaje_201", "Corresponde a la inserción de un recurso");
		cabeceraPost.add("valor", "Materia ingresada con éxito");
		return new ResponseEntity<>(mat ,cabeceraPost,201); 

    }

    @PutMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Materia> actualizar(@RequestBody Materia mat) {
        this.iMateriaService.actualizar(mat);
        HttpHeaders cabeceraPatch= new HttpHeaders();
		cabeceraPatch.add("mensaje_239", "Corresponde a la actualización parcial de un recurso");
		cabeceraPatch.add("valor", "Materia actualizado parcialmente");
		//return ResponseEntity.status(239).body(est2);
		return new ResponseEntity<>(mat,cabeceraPatch,239);
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> borrar(@PathVariable Integer id) {
        this.iMateriaService.borrar(id);
        
        HttpHeaders cabeceraDelete= new  HttpHeaders();
		cabeceraDelete.add("mensaje_240", "Corresponde a la eliminación del recurso");
		cabeceraDelete.add("valor", "MAteria eliminada");
		return new ResponseEntity<>("Eliminado correctamente",cabeceraDelete,240);
    }

    @PatchMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Materia> actualizarParcial(@RequestBody Materia materia, @PathVariable Integer id) {
        materia.setId(id);
        Materia materia2 = this.iMateriaService.buscar(materia.getId());

        if (materia.getNombre() != null) {
            materia2.setNombre(materia.getNombre());
        }
        if (materia.getProfesor() != null) {
            materia2.setProfesor(materia.getProfesor());
        }
        if (materia.getCodigoUnico() != null) {
            materia2.setCodigoUnico(materia.getCodigoUnico());
        }
        this.iMateriaService.actualizar(materia2);
        return ResponseEntity.status(239).body(materia);
    }
    
}
