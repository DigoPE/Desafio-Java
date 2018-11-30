package com.autentico.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;


@Entity
public class ComprovanteM implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long idcomp;
	
	@NotEmpty
	private String nomecomp;
	
	@NotEmpty
	private String motivo;
	
	@NotEmpty
	private String expiradt;
	
	@ManyToOne
	private DossieUsu dossieUsu;
	
	public long getIdcomp() {
		return idcomp;
	}
	public void setIdcomp(long idcomp) {
		this.idcomp = idcomp;
	}
	public String getNomecomp() {
		return nomecomp;
	}
	public void setNomecomp(String nomecomp) {
		this.nomecomp = nomecomp;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public String getExpiradt() {
		return expiradt;
	}
	public void setExpiradt(String expiradt) {
		this.expiradt = expiradt;
	}
	
	public DossieUsu getDossieUsu() {
		return dossieUsu;
	}
	public void setDossieUsu(DossieUsu dossieUsu) {
		this.dossieUsu = dossieUsu;
	}

	

}
