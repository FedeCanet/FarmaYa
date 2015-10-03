package com.is3;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.is3.bo.Direccion;
import com.is3.bo.Usuario;


public class main {

	public static void main(String[] args) {

		EntityManagerFactory emf = 	Persistence.createEntityManagerFactory("prueba", new HashMap());
		EntityManager em = emf.createEntityManager();
		
		UNO_getClienteQueMasProductosHaComprado(em);
		
		em.close();
		emf.close();	
	}	
	
	public static void UNO_getClienteQueMasProductosHaComprado(EntityManager em){
		em.getTransaction().begin();
		
		Usuario u = new Usuario();
		u.setNombre("prueba1");
		u.setApellido("apellido");
		u.setFechaCreacion(new Date(System.currentTimeMillis()));
		u.setPassword("1234");
		u.setCorreo("nicpfer@as.com");
		
		List<Direccion> direciones = new  ArrayList<>();
		Direccion d = new Direccion();
		d.setCalle("maldonado");
		d.setNumeroAPTO("001");
		
		d.setNumeroDePuerta(2283);
		direciones.add(d);
		
		
		Direccion d2 = new Direccion();
		d2.setCalle("liber arce");
		d2.setNumeroAPTO("802");
		
		d2.setNumeroDePuerta(3247);
		direciones.add(d2);

		u.setDirecciones(direciones);
		em.persist(u);
		
		em.getTransaction().commit();
	}
}
