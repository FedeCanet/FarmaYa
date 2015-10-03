package com.is3;

import java.sql.Date;
import java.util.HashMap;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import jpaObjetos.Usuario;

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
		u.setEmail(correo);
		u.setIdDireccion(2);
		em.persist(u);
		
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
	
}