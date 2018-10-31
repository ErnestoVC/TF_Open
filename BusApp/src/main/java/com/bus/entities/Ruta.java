package com.bus.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "rutas")
public class Ruta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message="Debe seleccionar una Sede de Salida")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sedeSalida_id")
	private Sede sedeSalidaId; 
	
	@NotNull(message="Debe seleccionar una Sede de Llegada")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sedeLlegada_id")
	private Sede sedeLlegadaId; 
	
	
	@ManyToMany
	@JoinTable(
				name = "rutaparadero",
				joinColumns = { @JoinColumn(name="ruta_id")},
				inverseJoinColumns = { @JoinColumn(name="paradero_id")})
	private List<Paradero> paraderos;
	
	
	public Ruta() {
		paraderos = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Sede getSedeSalidaId() {
		return sedeSalidaId;
	}

	public void setSedeSalidaId(Sede sedeSalidaId) {
		this.sedeSalidaId = sedeSalidaId;
	}

	public Sede getSedeLlegadaId() {
		return sedeLlegadaId;
	}

	public void setSedeLlegadaId(Sede sedeLlegadaId) {
		this.sedeLlegadaId = sedeLlegadaId;
	}

	public List<Paradero> getParaderos() {
		return paraderos;
	}

	public void setParaderos(List<Paradero> paraderos) {
		this.paraderos = paraderos;
	}


	
}
