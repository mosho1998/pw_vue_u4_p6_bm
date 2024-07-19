package com.edu.uce.pw.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.uce.pw.api.repository.IMateriaRepository;
import com.edu.uce.pw.api.repository.modelo.Materia;
import com.edu.uce.pw.api.service.to.MateriaTO;

@Service
public class MateriaServiceImpl implements IMateriaService{

	@Autowired
	private IMateriaRepository iMateriaRepository;
	
	@Override
	public Materia buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.iMateriaRepository.seleccionar(id);
	}

	@Override
	public void actualizar(Materia materia) {
		// TODO Auto-generated method stub
		this.iMateriaRepository.actualizar(materia);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.iMateriaRepository.eliminar(id);
	}

	@Override
	public void guardar(Materia materia) {
		// TODO Auto-generated method stub
		this.iMateriaRepository.insertar(materia);
	}

	@Override
	public Materia buscar(Long long1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MateriaTO> seleccionarPorIdEstudiante(Integer id) {
		// TODO Auto-generated method stub
		List<Materia> lista = this.iMateriaRepository.seleccionarPorIdEstudiante(id);
		
		List<MateriaTO> listaFinal = new ArrayList<>();
		
		for(Materia mat:lista) {
			listaFinal.add(this.convertir(mat));
		}
		return listaFinal;
	}
	
	private MateriaTO convertir(Materia mat) {
		MateriaTO mateTO = new MateriaTO();
		mateTO.setId(mat.getId());
		mateTO.setNombre(mat.getNombre());
		mateTO.setNumeroCreditos(mat.getCreditos());
		return mateTO;
	}

}
