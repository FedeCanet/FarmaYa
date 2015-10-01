package com.is3.bo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "FAR_T_FORMA_PAGO")
public class FormaPago implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "secuenciaFormaPago", sequenceName = "FAR_S_FORMA_PAGO_SEC", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "secuenciaFormaPago")
	private long id;
	@Column(nullable=false)
	private String nombre; //Ejemplo: Ticket Alimentaci�n, es la que se va a mostrar
	@Column(nullable=false)
	private String descripcion; //Ejemplo: Forma de Pago Ticket de Alimentaci�n 

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


}
