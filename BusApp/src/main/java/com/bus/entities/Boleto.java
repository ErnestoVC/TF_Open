package com.bus.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Boleto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "Ingrese el monto")
	@Column(name = "importe", columnDefinition = "Decimal(8,2)", nullable=false)
	private Double importe;
	
	@NotNull(message="Debe seleccionar un alumno")
	@ManyToOne
	@JoinColumn(name = "alumno_id", nullable=false)
	private Alumno alumnos;
	
	@NotNull(message="Debe seleccionar un viaje")
	@ManyToOne
	@JoinColumn(name = "viaje_id", nullable=false)
	private Viaje viajes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getImporte() {
		return importe;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}

	public Alumno getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(Alumno alumnos) {
		this.alumnos = alumnos;
	}

	public Viaje getViajes() {
		return viajes;
	}

	public void setViajes(Viaje viajes) {
		this.viajes = viajes;
	}
	
}
