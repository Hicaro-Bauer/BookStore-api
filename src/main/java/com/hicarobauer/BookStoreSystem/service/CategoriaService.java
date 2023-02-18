package com.hicarobauer.BookStoreSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.hicarobauer.BookStoreSystem.domain.Categoria;
import com.hicarobauer.BookStoreSystem.dtos.CategoriaDTO;
import com.hicarobauer.BookStoreSystem.repositories.CategoriaRepository;
import com.hicarobauer.BookStoreSystem.service.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;
	
	public Categoria findById(Integer id) {
		Optional<Categoria> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo " + Categoria.class.getName()));
	}
	
	public List<Categoria> findAll(){
		return repository.findAll();
	}
	
	public Categoria create(Categoria obj) {
		obj.setId(null);
		return repository.save(obj);
	}
	
	public Categoria update(Integer id, CategoriaDTO objDto) {
		Categoria obj = findById(id);
		if(objDto.getNome() != null) {
			obj.setNome(objDto.getNome());
		}
		if(objDto.getDescricao() != null) {
			obj.setDescricao(objDto.getDescricao());
		}
		return repository.save(obj);
	}
	
	public void delete(Integer id) {
		findById(id);
		try {
			repository.deleteById(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new com.hicarobauer.BookStoreSystem.service.exceptions.DataIntegrityViolationException("A categoria possui livros associadas a ela. Não é possível apagar.");
		}
	}
}
