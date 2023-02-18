package com.hicarobauer.BookStoreSystem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hicarobauer.BookStoreSystem.domain.Livro;

public interface LivroRepository extends JpaRepository<Livro, Integer> {

	@Query("SELECT obj FROM Livro obj WHERE obj.categoria.id = :id_categoria ORDER BY titulo ASC")
	List<Livro> findAllByCategory(@Param(value = "id_categoria") Integer id_categoria);
}
