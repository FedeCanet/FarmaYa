package com.is3;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.is3.bo.Direccion;
import com.is3.bo.Usuario;

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
		
		/*
		Usuario p = null;
		String email = null;
		
		for (int i = 0; i < usuarios.size(); i++) {
			Object [] datosDevueltos = (Object [])usuarios.get(i);
			email = (String)datosDevueltos[0];
		}
		*/
		
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		if(usuarios.size() > 0){
			return true;
		}else{
			return false;
		}
	}
	
}