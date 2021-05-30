import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Application {

	public static void main(String[] args){
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myJpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		// transaction
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();

		// code
		try {
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			entityManager.close();
		}

		entityManagerFactory.close();
	}
}
