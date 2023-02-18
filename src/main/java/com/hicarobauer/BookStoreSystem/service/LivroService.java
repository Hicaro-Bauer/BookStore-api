package com.hicarobauer.BookStoreSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hicarobauer.BookStoreSystem.domain.Categoria;
import com.hicarobauer.BookStoreSystem.domain.Livro;
import com.hicarobauer.BookStoreSystem.repositories.LivroRepository;
import com.hicarobauer.BookStoreSystem.service.exceptions.ObjectNotFoundException;

@Service
public class LivroService {

	@Autowired
	private LivroRepository repository;
	
	@Autowired
	private CategoriaService categoriaService;
	
	public Livro findById(Integer id) {
		Optional<Livro> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo " + Livro.class.getName()));
	}
	
	public List<Livro> findAll(Integer id_categoria){
		categoriaService.findById(id_categoria);
		return repository.findAllByCategory(id_categoria);
	}
	
	public Livro create(Integer id_categoria, Livro obj) {
		obj.setId(null);
		Categoria cat = categoriaService.findById(id_categoria);
		obj.setCategoria(cat);
		return repository.save(obj);
	}
	
	public Livro update(Integer id, Livro obj) {
		Livro newObj = findById(id);
		updateData(newObj, obj);
		return repository.save(newObj);
	}
	
	private void updateData(Livro newObj, Livro obj) {
		if(obj.getTitulo() != null) {
			newObj.setTitulo(obj.getTitulo());
		}
		if(obj.getNome_autor() != null) {
			newObj.setNome_autor(obj.getNome_autor());
		}
		if(obj.getTexto() != null) {
			newObj.setTexto(obj.getTexto());	
		}
	}
	
	public void delete(Integer id) {
		findById(id);
		repository.deleteById(id);
	}
}
