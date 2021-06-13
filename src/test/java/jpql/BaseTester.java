package jpql;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public abstract class BaseTester {

	private static EntityManagerFactory entityManagerFactory;
	protected EntityManager entityManager;
	protected EntityTransaction entityTransaction;

	@BeforeAll
	static void setUpEntityManagerFactory() {
		entityManagerFactory = Persistence.createEntityManagerFactory("myJpa");
	}

	@BeforeEach
	void setUpEntityManager() {
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
	}

	@AfterEach
	void closeEntityManager() {
		entityManager.close();
	}

	@AfterAll
	static void close() {
		entityManagerFactory.close();
	}


}
