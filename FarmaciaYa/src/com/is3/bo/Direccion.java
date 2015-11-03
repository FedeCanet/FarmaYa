package com.is3.bo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "FAR_T_DIRECCION")
public class Direccion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "secuenciaDireccion", sequenceName = "FAR_S_DIRECCION_SEC", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "secuenciaDireccion")
	private long id;

    private String calle;

    private int numeroDePuerta;

    private String numeroAPTO;

    private String ciudad;

    private float latitud;

    private float longitud;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNumeroDePuerta() {
		return numeroDePuerta;
	}

	public void setNumeroDePuerta(int numeroDePuerta) {
		this.numeroDePuerta = numeroDePuerta;
	}

	public String getNumeroAPTO() {
		return numeroAPTO;
	}

	public void setNumeroAPTO(String numeroAPTO) {
		this.numeroAPTO = numeroAPTO;
	}

	public float getLatitud() {
		return latitud;
	}

	public void setLatitud(float latitud) {
		this.latitud = latitud;
	}

	public float getLongitud() {
		return longitud;
	}

	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
}
