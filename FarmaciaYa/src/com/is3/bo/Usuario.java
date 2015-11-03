package com.is3.bo;

import java.io.Serializable;
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
@Table(name = "FAR_T_USUARIO")
public class Usuario implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "secuenciaUsuario", sequenceName = "FARM_S_USUARIO_SEC", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "secuenciaUsuario")
	private long id;


	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "USUARIO_FK", referencedColumnName = "ID")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Direccion> direcciones;

	@Column(nullable=false)
	private Date fechaCreacion;
	@Column(nullable=false)
	private String nombre ;
	@Column(nullable=false)
	private String apellido;
	@Column(nullable=false)
	private String correo ;
	@Column(nullable=false)
	private String password ;


	private boolean confirmado;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "usuario_id", referencedColumnName = "id")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Orden> listaOrdenes;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Direccion> getDirecciones() {
		return direcciones;
	}

	public void setDirecciones(List<Direccion> direcciones) {
		this.direcciones = direcciones;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "idCliente= " + id + " " + nombre + " " + apellido;
	}

	public boolean isConfirmado() {
		return confirmado;
	}

	public void setConfirmado(boolean confirmado) {
		this.confirmado = confirmado;
	}
	public String getNombreCompleto(){
		return this.getNombre()+" "+this.getApellido();
	}

	public List<Orden> getOrdenes() {
		return listaOrdenes;
	}
	public void setOrdenes(List<Orden> ordenes) {
		this.listaOrdenes = ordenes;
	}
}
