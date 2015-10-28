package com.is3.bo;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


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

//	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//	@JoinColumn(name = "PRODUCTOORDEN_FK", referencedColumnName = "ID")
//	@LazyCollection(LazyCollectionOption.FALSE)
//	private List<Orden> ordenes;
//	
	
	
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


}
