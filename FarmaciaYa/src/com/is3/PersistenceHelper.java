package com.is3;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.is3.bo.Direccion;
import com.is3.bo.Farmacia;
import com.is3.bo.FormaPago;
import com.is3.bo.Orden;
import com.is3.bo.Producto;
import com.is3.bo.ProductoOrden;
import com.is3.bo.Usuario;
import com.is3.dto.Posicion;

public class PersistenceHelper {


	
	public PersistenceHelper(){
	}
	
	public void addUsuario(String nom, String app, String correo, String direccion, String pass){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("prueba", new HashMap());
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		//Nuevo Usuario
		Usuario nuevoUsuario = new Usuario();
		nuevoUsuario.setNombre(nom);
		nuevoUsuario.setApellido(app);
		nuevoUsuario.setFechaCreacion(new Date(System.currentTimeMillis()));
		nuevoUsuario.setPassword(pass);
		nuevoUsuario.setCorreo(correo);
				
		//Lista de Direcciones
		List<Direccion> direcciones = new ArrayList<Direccion>();
		
		//Nueva Direccion
		Direccion nuevaDireccion = new Direccion();
		nuevaDireccion.setCalle(direccion);
		nuevaDireccion.setNumeroAPTO("001");
		nuevaDireccion.setNumeroDePuerta(2283);
		direcciones.add(nuevaDireccion);
		
		//Agregamos las direcciones al usuario y guardamos.
		nuevoUsuario.setDirecciones(direcciones);
		em.persist(nuevoUsuario);
		
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
	
	public boolean existUsuario(String correo, String password){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("prueba", new HashMap());
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Query queryCinco = em.createQuery("SELECT u.correo " +
				"FROM Usuario u " +
				"where u.correo = :correo and u.password = :password ");

		queryCinco.setParameter("correo", correo);
		queryCinco.setParameter("password", password);

		ArrayList usuarios = (ArrayList)queryCinco.getResultList();
				
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		if(usuarios.size() > 0){
			return true;
		}else{
			return false;
		}
	}
	
	public Usuario getUsuario(String correo, String password){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("prueba", new HashMap());
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Query queryCinco = em.createQuery("SELECT u " +
				"FROM Usuario u " +
				"where u.correo = :correo and u.password = :password ");

		queryCinco.setParameter("correo", correo);
		queryCinco.setParameter("password", password);

		ArrayList usuarios = (ArrayList)queryCinco.getResultList();
				
		em.getTransaction().commit();
		em.close();
		emf.close();
		return (Usuario)usuarios.get(0);
	}
	
	public List <Farmacia> obtenerFarmaciasCercanas(Posicion p){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("prueba", new HashMap());
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		TypedQuery<Farmacia> queryCinco = em.createQuery("SELECT f FROM Farmacia f",Farmacia.class);
		
		List<Farmacia> farmacias2 = new ArrayList<Farmacia>();
		List<Farmacia> farmacias = queryCinco.getResultList();
		for (Farmacia farm : farmacias){
			Posicion p2 = new Posicion(farm.getDireccion());
			//System.out.println("lat: "+p2.getLatitud()+" long: "+p2.getLongitud());
			if (p.estaCerca(p2,1000)){
				farmacias2.add(farm);
			}
		}
		em.close();
		emf.close();
		return farmacias2;
	}
	
	public Farmacia obtenerFarmacia(long idFarmacia){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("prueba", new HashMap());
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Farmacia laFarmacia = null;
	
		Query queryCinco = em.createQuery("SELECT f FROM Farmacia f Where f.id = :id");
		queryCinco.setParameter("id", idFarmacia);
		
		ArrayList farmacias = (ArrayList)queryCinco.getResultList();
		
		if(farmacias != null){
			if(farmacias.size() > 0){
				laFarmacia = (Farmacia)farmacias.get(0);
			}
		}
		
		em.close();
		emf.close();
		
		return laFarmacia;
	}
	
	public List<Producto> obtenerProductos(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("prueba", new HashMap());
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		TypedQuery<Producto> queryCinco = em.createQuery("SELECT p FROM Producto p",Producto.class);
		
		List<Producto> productos = queryCinco.getResultList();

		em.close();
		emf.close();
		return productos;
	}
	
	public Producto obtenerProducto(long idProducto){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("prueba", new HashMap());
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Producto producto = null;
	
		Query queryCinco = em.createQuery("SELECT p FROM Producto p Where p.id = :id");
		queryCinco.setParameter("id", idProducto);
		
		ArrayList productos = (ArrayList)queryCinco.getResultList();
		
		if(productos != null){
			if(productos.size() > 0){
				producto = (Producto)productos.get(0);
			}
		}
		
		em.close();
		emf.close();
		
		return producto;
	}
	
	public void confirmarOrden(Orden _orden){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("prueba", new HashMap());
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Farmacia f = em.find(Farmacia.class, _orden.getFarmacia().getId());

		FormaPago fp = em.find(FormaPago.class, _orden.getFormaDePAgo().getId());
		
		Usuario u = em.find(Usuario.class, _orden.getUsuario().getId());
		
		BigDecimal ordenTotal = _orden.getTotal();
		
		String aclaracion = _orden.getAclaracion();
		
		Orden orden = new Orden();
		orden.setAclaracion(aclaracion);
		orden.setFarmacia(f);
		orden.setFechaOrden(new Date(System.currentTimeMillis()));
		orden.setFormaDePAgo(fp);
		orden.setUsuario(u);
		orden.setTotal(ordenTotal);

		em.persist(orden);

		for (ProductoOrden produOrden : _orden.getProductoOrden()) {
			Producto produ = em.find(Producto.class, produOrden.getProducto().getId());
			ProductoOrden po = new ProductoOrden();
			po.setOrden(orden);
			po.setProducto(produ);
			em.persist(po);
		}
				
		em.getTransaction().commit();
		em.close();
		emf.close();		
	}

	public Usuario getUsuarioById(Long id){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("prueba", new HashMap());
		EntityManager em = emf.createEntityManager();
		
		Usuario usuario = em.find(Usuario.class, id);
		
		em.close();
		emf.close();
		return usuario;
	}
	

	public void puntuarOrden(long idOrden, float puntaje){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("prueba", new HashMap());
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Orden laOrden = em.find(Orden.class, idOrden);
		laOrden.setPuntaje(puntaje);
		
		em.merge(laOrden);
				
		em.getTransaction().commit();
		em.close();
		emf.close();		
	}
	
	public void actualizarContrasena(String correo, String nuevaPass){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("prueba", new HashMap());
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Query queryCinco = em.createQuery("SELECT u " +
				"FROM Usuario u " +
				"where u.correo = :correo");

		queryCinco.setParameter("correo", correo);
		
		ArrayList usuarios = (ArrayList)queryCinco.getResultList();
		
		if(usuarios.size() > 0){
			Usuario usuario = (Usuario)usuarios.get(0);
			usuario.setPassword(nuevaPass);
			em.merge(usuario);
		}
				
		em.getTransaction().commit();
		em.close();
		emf.close();		
	}
	
	private void puntuarFarmacia(Farmacia farmacia, Orden orden){
		// cant 12 promedio 4.1 entonces  (4.1 * 12 + nuevo puntaje) /  (12 +1)  
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("prueba", new HashMap());
		EntityManager em = emf.createEntityManager();
		float puntajeNuevo = (farmacia.getPuntaje() * farmacia.getCantPuntuajes()) + orden.getPuntaje() / (farmacia.getCantPuntuajes() +1);
		farmacia.setPuntaje(puntajeNuevo);
		em.merge(farmacia);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}