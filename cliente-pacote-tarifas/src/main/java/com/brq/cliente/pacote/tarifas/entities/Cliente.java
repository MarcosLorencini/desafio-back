package com.brq.cliente.pacote.tarifas.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	@Column(unique=true)
	private String cpf;
	
	@JsonFormat(pattern="dd/MM/yyyy")
    private Date dataNascimento;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="pacoteTarifa_id")
	private PacoteTarifa pacoteTarifa;
	
		
	public Cliente() {
		
	}
	
	

	public Cliente(Long id, String nome, String cpf, Date dataNascimento, PacoteTarifa pacoteTarifa) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.pacoteTarifa = pacoteTarifa;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public PacoteTarifa getPacoteTarifa() {
		return pacoteTarifa;
	}



	public void setPacoteTarifa(PacoteTarifa pacoteTarifa) {
		this.pacoteTarifa = pacoteTarifa;
	}



	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(id, other.id);
	}
	
	

	
	
	
	
	

}
