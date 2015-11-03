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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


@NamedQueries({
//	@NamedQuery(name = "getDispositivoPorNumero", query = "SELECT d.id FROM Dispositivo d WHERE d.numeroDispositivo = :numero"),
})
@Entity
@Table(name = "FAR_T_FARMACIA")
public class Farmacia implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "secuenciaFarmacia", sequenceName = "FAR_S_FARMACIA_SEC", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "secuenciaFarmacia")
	private long id;

	@Column(nullable=false)
	private Date fechaCreacion;
	@Column(nullable=false)
	private String nombre ;

	private String descripcion ;
	@OneToOne(cascade=CascadeType.ALL, orphanRemoval=true, optional=false)
	private Direccion direccion;

	private Long importeMinimo ;

	@Temporal(TemporalType.TIME)
	private Date horarioDesde;
	@Temporal(TemporalType.TIME)
	private Date horarioHasta;
	@Column(nullable=false)
	private boolean tieneDelivery; //Esto lo pidio Gonzalo.
	private float puntaje;//este se calcula  como la suma de todas las ordenes puntuadas dividido la cantidad de ordenes puntuadas
	private int cantPuntuajes;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "FORMA_DE_PAGO_FK", referencedColumnName = "ID")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<FormaPago> formasDePago;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public Long getImporteMinimo() {
		return importeMinimo;
	}

	public void setImporteMinimo(Long importeMinimo) {
		this.importeMinimo = importeMinimo;
	}

	public Date getHorarioDesde() {
		return horarioDesde;
	}

	public void setHorarioDesde(Date horarioDesde) {
		this.horarioDesde = horarioDesde;
	}

	public Date getHorarioHasta() {
		return horarioHasta;
	}

	public void setHorarioHasta(Date horarioHasta) {
		this.horarioHasta = horarioHasta;
	}

	public boolean isTieneDelivery() {
		return tieneDelivery;
	}

	public void setTieneDelivery(boolean tieneDelivery) {
		this.tieneDelivery = tieneDelivery;
	}

	public float getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(float puntaje) {
		this.puntaje = puntaje;
	}

	public int getCantPuntuajes() {
		return cantPuntuajes;
	}

	public void setCantPuntuajes(int cantPuntuajes) {
		this.cantPuntuajes = cantPuntuajes;
	}

	public List<FormaPago> getFormasDePago() {
		return formasDePago;
	}

	public void setFormasDePago(List<FormaPago> formasDePago) {
		this.formasDePago = formasDePago;
	}
}
