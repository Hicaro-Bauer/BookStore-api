package com.hicarobauer.BookStoreSystem.dtos;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import com.hicarobauer.BookStoreSystem.domain.Categoria;

import jakarta.validation.constraints.NotEmpty;

public class CategoriaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message = "Campo nome é obrigatório")
	@Length(min = 3, max = 100, message = "O campo nome deve possuir entre 3 e 100 caracteres")
	private String nome;
	
	@NotEmpty(message = "Campo descrição é obrigatório")
	@Length(min = 5, max = 300, message = "O campo descrição deve possuir entre 5 e 300 caracteres")
	private String descricao;
	
	public CategoriaDTO() {
	}

	public CategoriaDTO(Categoria obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.descricao = obj.getDescricao();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
