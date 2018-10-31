package com.bus.entities;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "alumnos")
public class Alumno {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Size(min = 10, max = 10)
	@NotEmpty(message="Ingrese su TIU")
	@Column(name="tiu", nullable=false, unique=true, length=25)
	private String tiu;
	
	@NotEmpty(message="Ingrese su nombre")
	@Column(name="primerNombre", nullable=false, length=75)
	private String primerNombre;
	
	@NotEmpty(message="Ingrese su segundo nombre")
	@Column(name="segundoNombre", nullable=false, length=75)
	private String segundoNombre;
	
	@NotEmpty(message="Ingrese su apellido paterno")
	@Column(name="apellidoPaterno", nullable=false, length=75)
	private String apellidoPaterno;
	
	@NotEmpty(message="Ingrese su apellido materno")
	@Column(name="apellidoMaterno", nullable=false, length=75)
	private String apellidoMaterno;
	
	@NotEmpty(message="Ingrese su email")
	@Column(name="email", nullable=false, length=75)
	private String email;
	
	@NotEmpty(message="Ingrese su contraseña")
	@Column(name="password", nullable=false, length=75)
	private String password;
	
	@Column(name="tarjeta", nullable=true, length=125)
	private Long tarjeta;
	
	@NotEmpty(message="Ingrese saldo")
	@Column(name="saldo", columnDefinition = "Decimal(8,2)", nullable=false)
	private Double saldo;
	
	@OneToMany(mappedBy="alumnoId", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Clase> clases;
	
	@OneToMany(mappedBy="alumnoId", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Boleto> boletos;

	public Alumno() {
		clases = new ArrayList<>();
		boletos = new ArrayList<>();
	}
	
	public List<Boleto> getBoletos() {
		return boletos;
	}

	public void setBoletos(List<Boleto> boletos) {
		this.boletos = boletos;
	}

	public List<Clase> getClases() {
		return clases;
	}

	public void setClases(List<Clase> clases) {
		this.clases = clases;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTiu() {
		return tiu;
	}

	public void setTiu(String tiu) {
		this.tiu = tiu;
	}

	public String getPrimerNombre() {
		return primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getSegundoNombre() {
		return segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(Long tarjeta) {
		this.tarjeta = tarjeta;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	
	
	
}
