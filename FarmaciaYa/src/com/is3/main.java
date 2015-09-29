package com.is3;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import jpaObjetos.Usuario;


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
		u.setEmail("nicpfer@as.com");
		u.setIdDireccion(2);
		em.persist(u);
		
		em.getTransaction().commit();
	}
}
