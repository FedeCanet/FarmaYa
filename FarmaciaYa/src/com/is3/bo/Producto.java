package com.is3.bo;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@NamedQueries({
//		@NamedQuery(name = "getModelos", query = "SELECT m FROM Modelo m"),
//		@NamedQuery(name = "getModeloDescripcion", query = "SELECT m FROM Modelo m where m.descripcion = :descripcion"),
})
@Entity
@Table(name = "FAR_T_PRODUCTO")
public class Producto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "secuenciaProducto", sequenceName = "FAR_S_PRODUCTO_SEC", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "secuenciaProducto")
	private long id;

	@Column(nullable=false)
	private String nombre;
	@Column(nullable=false)
	private String descripcion ;
	@Column(nullable=false)
	private String descBusqueda; //buscar por este campo, ejemplo "Pastilla Pildora etc"
	@Column(nullable=false)
	private BigDecimal precioUnitario;
	
}
