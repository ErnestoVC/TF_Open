package com.bus.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="sede")
public class Sede {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany(mappedBy="claseId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Clase> clases;
	
	@OneToMany(mappedBy="rutaId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Clase> rutas;
	
	public Sede() {
		clases = new ArrayList<>();
		rutas = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Clase> getClases() {
		return clases;
	}

	public void setClases(List<Clase> clases) {
		this.clases = clases;
	}

	public List<Clase> getRutas() {
		return rutas;
	}

	public void setRutas(List<Clase> rutas) {
		this.rutas = rutas;
	}
	
	
	
}
