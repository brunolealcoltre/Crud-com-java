package br.com.conexao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {
private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Estoque");// ABRE A CONEX�O E MANIPULA AS TRANSA��ES
	
	public static EntityManager getConnection() {
		return emf.createEntityManager();
		
	}
}

	


