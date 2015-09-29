package jpaObjetos;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(
	    name="Usuario", 
	    indexes = {
	       @Index(name = "EMAIL_INDEX", columnList = "email") })
public class Usuario {
	
	private Date fechaCreacion;
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int idUsuario;
	private String nombre;
	private String apellido;
	private String email;
	private String password;
	private int idDireccion;
		
	@Column (nullable=false, length=100)
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Column (nullable=false, length=100)
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	@Column (nullable=false, length=125, unique=true)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getIdDireccion() {
		return idDireccion;
	}
	public void setIdDireccion(int idDireccion) {
		this.idDireccion = idDireccion;
	}	
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "idCliente= " + idUsuario + " " + nombre + " " + apellido;
	}
}
