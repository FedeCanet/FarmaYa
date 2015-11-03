package com.is3.bo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
@Table(name = "FAR_T_ORDEN")
public class Orden implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "secuenciaOrden", sequenceName = "FAR_S_ORDEN_SEC", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "secuenciaOrden")
	private long id;

	@ManyToOne (fetch = FetchType.LAZY)
	private Usuario usuario;
	@Column(nullable=false)
	private Date fechaOrden ;
	@Column(nullable=false)
	private BigDecimal total ;

	@ManyToOne (fetch = FetchType.LAZY)
	private FormaPago formaDePAgo;

	//@ManyToOne (fetch = FetchType.LAZY)
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Farmacia farmacia;

	private String aclaracion;
	private float puntaje;

	//@OneToMany (mappedBy="orden")
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "orden", cascade = CascadeType.ALL)
	private List<ProductoOrden> productoOrdenes;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<ProductoOrden> getProductoOrden() {
		return productoOrdenes;
	}
	public void setProductoOrden(List<ProductoOrden> productoOrdenes) {
		this.productoOrdenes = productoOrdenes;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Date getFechaOrden() {
		return fechaOrden;
	}

	public void setFechaOrden(Date fechaOrden) {
		this.fechaOrden = fechaOrden;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public FormaPago getFormaDePAgo() {
		return formaDePAgo;
	}

	public void setFormaDePAgo(FormaPago formaDePAgo) {
		this.formaDePAgo = formaDePAgo;
	}

	public String getAclaracion() {
		return aclaracion;
	}

	public void setAclaracion(String aclaracion) {
		this.aclaracion = aclaracion;
	}

	public float getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(float puntaje) {
		this.puntaje = puntaje;
	}

	public Farmacia getFarmacia() {
		return farmacia;
	}

	public void setFarmacia(Farmacia farmacia) {
		this.farmacia = farmacia;
	}
}
