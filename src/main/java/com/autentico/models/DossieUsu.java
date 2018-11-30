package com.autentico.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

@Entity
public class DossieUsu implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	///Define o campo (matricula) como chave na tabela, como auto incremento). 
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long matricula;
	
	@NotEmpty
	private String nome;
	
	@NotEmpty
	private String email;
	
	@NotEmpty
	private String sexo;
	
	@NotEmpty
	private String nascimentodt;
	
	@NotEmpty
	private String cadastrodt;
	
	@NotEmpty
	private String endereco;
	
	@OneToMany
	private List<ComprovanteM> comprovanteM;
	
	public long getMatricula() {
		return matricula;
	}
	public void setMatricula(long matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getNascimentodt() {
		return nascimentodt;
	}
	public void setNascimentodt(String nascimentodt) {
		this.nascimentodt = nascimentodt;
	}
	public String getCadastrodt() {
		return cadastrodt;
	}
	public void setCadastrodt(String cadastrodt) {
		this.cadastrodt = cadastrodt;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
		
}
