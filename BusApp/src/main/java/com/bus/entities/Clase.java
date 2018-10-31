package com.bus.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "clases")
public class Clase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="fecha")
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	@Column(name="hora_inicio", nullable = false, length=15)
	private String horaInicio;
	
	@Column(name="hora_fin", nullable=false, length=15)
	private String horaFin;
	
	@NotNull(message = "Debe seleccionar un alumno")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="alumnos_id", nullable=false)
	private Alumno alumnoId;
	
	@NotNull(message = "Debe seleccionar una sede")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="sedeId", nullable = false)
	private Sede sedes;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}

	public Alumno getAlumnoId() {
		return alumnoId;
	}

	public void setAlumnoId(Alumno alumnoId) {
		this.alumnoId = alumnoId;
	}
	
}
