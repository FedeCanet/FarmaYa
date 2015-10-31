package com.is3.bo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


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
	private int cantidad;
	
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "PRODUCTO_FK", referencedColumnName = "ID")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<ProductoOrden> productoOrdenes;
	

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getDescBusqueda() {
		return descBusqueda;
	}
	public void setDescBusqueda(String descBusqueda) {
		this.descBusqueda = descBusqueda;
	}
	public BigDecimal getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	
}
