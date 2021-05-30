import domain.member.Member;
import domain.order.OrderStatus;
import domain.order.Order;

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
			System.out.println("=========================");
			Member member = new Member("주지민", "서울", "도림천로", "몰라");
			entityManager.persist(member); // 영속 등록, DB 조회( identity )

			Order order = new Order(member, OrderStatus.ORDER);
			member.addOrder(order);
			entityManager.persist(order);



			System.out.println("=========================");
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			entityManager.close();
		}

		entityManagerFactory.close();
	}
}
