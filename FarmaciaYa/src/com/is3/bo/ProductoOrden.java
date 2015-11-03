package com.is3.bo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@NamedQueries({
//		@NamedQuery(name = "getSalas", query = "SELECT s FROM SalaDeJuego s"),
//		@NamedQuery(name = "getSalaById", query = "SELECT s FROM SalaDeJuego s WHERE s.id = :id"),
//		@NamedQuery(name = "getSalaByPos", query = "SELECT s FROM SalaDeJuego s WHERE s.pos = :pos"),
//		@NamedQuery(name = "existeSala", query = "SELECT s FROM SalaDeJuego s WHERE (s.pos = :pos) AND s.id <> :id"),
 })
@Entity
@Table(name = "FAR_T_PRODUCTO_ORDEN")
public class ProductoOrden implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "secuenciaProductoOrden", sequenceName = "FAR_S_PRODUCTOORDEN_SEC", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "secuenciaProductoOrden")
	private long id;

	//@ManyToOne (fetch = FetchType.LAZY)
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Producto producto;

	@ManyToOne (fetch = FetchType.LAZY)
	private Orden orden;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Orden getOrden() {
		return orden;
	}

	public void setOrden(Orden orden) {
		this.orden = orden;
	}
}
