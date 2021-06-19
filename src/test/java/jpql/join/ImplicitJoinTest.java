package jpql.join;

import domain.member.Member;
import domain.order.Order;
import domain.order.OrderStatus;
import jpql.BaseTester;
import org.junit.jupiter.api.Test;

import java.util.Collection;

class ImplicitJoinTest extends BaseTester {


	@Test
	void explicitJoinTest() {
		entityTransaction.begin();

		try {
			Member member1 = new Member("주지민", "춘천", "도림천로", "몰라");
			Order order1 = new Order(member1, OrderStatus.ORDER);
			Order order2 = new Order(member1, OrderStatus.ORDER);

			member1.addOrder(order1);
			member1.addOrder(order2);

			entityManager.persist(member1);

			Collection orders = entityManager.createQuery("SELECT m.order FROM Member m", Collection.class)
											  .getResultList();
//			select
//			order1_.ORDER_ID as order_id1_9_,
//				order1_.DELIVERY_ID as delivery4_9_,
//			order1_.MEMBER_ID as member_i5_9_,
//				order1_.ORDER_DATE as order_da2_9_,
//			order1_.STATUS as status3_9_
//				from
//			MEMBER member0_
//			inner join
//			ORDERS order1_
//			on member0_.MEMBER_ID=order1_.MEMBER_ID
			orders.forEach(System.out::println);
			entityTransaction.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityTransaction.rollback();
		}
	}
}
