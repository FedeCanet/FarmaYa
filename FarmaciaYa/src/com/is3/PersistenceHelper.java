package com.is3;

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
import com.is3.bo.Producto;
import com.is3.bo.Usuario;
import com.is3.dto.Posicion;

public class PersistenceHelper {


	
	public PersistenceHelper(){
	}
	
	public void addUsuario(String nom, String app, String correo, String direccion, String pass){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("prueba", new HashMap());
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Usuario u = new Usuario();
		u.setNombre(nom);
		u.setApellido(app);
		u.setFechaCreacion(new Date(System.currentTimeMillis()));
		u.setPassword(pass);
		u.setCorreo(correo);
		
		// direccion hay que pasarle una lista de direcciones , tenes que hacerlo despues
		em.persist(u);
		
		Direccion d = new Direccion();
		d.setCalle(direccion);
		em.persist(d);
		
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
}