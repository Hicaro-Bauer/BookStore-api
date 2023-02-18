package com.hicarobauer.BookStoreSystem.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hicarobauer.BookStoreSystem.domain.Categoria;
import com.hicarobauer.BookStoreSystem.domain.Livro;
import com.hicarobauer.BookStoreSystem.repositories.CategoriaRepository;
import com.hicarobauer.BookStoreSystem.repositories.LivroRepository;

@Service
public class DBService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;
	
	public void instanciaBanco() {
		Categoria cat1 = new Categoria(null, "Informática", "Livros de Informática");
		Categoria cat2 = new Categoria(null, "Robótica", "Livros de Robótica");
		Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "Lorem ipsum", cat1);
		Livro l2 = new Livro(null, "Clean Code 2", "Robert Martin 2", "Lorem ipsum 2", cat1);
		Livro l3 = new Livro(null, "Clean Code 3", "Robert Martin 3", "Lorem ipsum 3", cat2);
		Livro l4 = new Livro(null, "Clean Code 4", "Robert Martin 4", "Lorem ipsum 4", cat2);
		
		cat1.getLivros().addAll(Arrays.asList(l1, l2));
		cat2.getLivros().addAll(Arrays.asList(l3, l4));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4));
	}
}
