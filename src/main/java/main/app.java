package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Autor;
import entities.Domicilio;
import entities.Libro;
import entities.Localidad;
import entities.Persona;



public class app {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestPersistencePU");
		EntityManager em = emf.createEntityManager();

			try {
				em.getTransaction().begin();
				Persona person = Persona.builder().name("Luciana").last_name("Rosati").dni(38495806).build();
				Localidad location = new Localidad("Godoy Cruz");
				Domicilio address = Domicilio.builder().street("Bouchard").number(91).build();
				
				person.setAddress(address);
				address.setLocation(location);
				
				Libro book = Libro.builder().title("El hacedor").date(1960).gender("Poesia").pages(100).build();	
				Libro book1 = Libro.builder().title("Funes el memorioso").date(1942).gender("Ficcion").pages(250).build();
				Autor author = Autor.builder().name("Julio").last_name("Borges").biography("Destacado escritor de cuentos, poemas y ensayos argentino").build();
				
				
				book.getAuthors().add(author);
				book1.getAuthors().add(author);
				person.getBooks().add(book);
				person.getBooks().add(book1);
				
				em.persist(person);
				em.persist(author);
				
			
				
				em.flush();

				em.getTransaction().commit();
				
			} catch (Exception e) {
				em.getTransaction().rollback();
			}

			em.close();
			emf.close();

		}

}
