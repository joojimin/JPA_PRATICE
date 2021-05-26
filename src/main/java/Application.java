import member.Member;

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
//			insertMember(entityManager);
//			findMember(entityManager);
			updateMember(entityManager);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			entityManager.close();
		}

		entityManagerFactory.close();
	}

	private static void insertMember(final EntityManager entityManager){
		Member member = new Member();
		member.setId(1);
		member.setName("joojimin");

		entityManager.persist(member);
	}

	private static void findMember(final EntityManager entityManager){
		Member member = entityManager.find(Member.class, 1);
		System.out.println(member.getId() + " : " + member.getName());
	}

	private static void updateMember(final EntityManager entityManager){
		Member member = entityManager.find(Member.class, 1);
		member.setName("joooooooooooo");
	}
}
