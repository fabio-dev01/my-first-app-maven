package app;
	//importações necessárias
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import domain.Usuario;

public class Application {

	public static void main(String[] args) { //instancia
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa"); 
		EntityManager em = emf.createEntityManager();//faz a conexão
		
		Usuario u1 = new Usuario (null,"Natan Drake", "nate@gmail.com");
		Usuario u2 = new Usuario (null,"Jason Brody", "JasonBro@gmail.com");
		
			//inicia a transação
			em.getTransaction().begin();
			em.persist(u1);
			em.persist(u2);
					//confirma as alterações
			em.getTransaction().commit();
			System.out.println("PRONTO");
			em.close();
			emf.close();
				//adicionou automaticamente no banco de dados
	}

}
