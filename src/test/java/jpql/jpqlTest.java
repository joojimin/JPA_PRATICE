package jpql;

import domain.member.Member;
import org.junit.jupiter.api.Test;

import java.util.List;

public class jpqlTest extends BaseTester {


	@Test
	void test() {
		entityTransaction.begin();

		try {
			Member member1 = new Member("주지민", "춘천", "도림천로", "몰라");
			Member member2 = new Member("박선정", "구미", "광진구", "몰라");
			entityManager.persist(member1);
			entityManager.persist(member2);

			member1.setCity("서울");
			member2.setStreet("구로구");

			List<Member> list1 = entityManager.createQuery("SELECT m FROM Member m", Member.class).getResultList();
			list1.forEach(System.out::println);

			List<Member> list2 = entityManager.createQuery("SELECT m FROM Member m WHERE m.name = :name", Member.class)
				.setParameter("name", member1.getName())
				.getResultList();
			list2.forEach(System.out::println);

			entityTransaction.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityTransaction.rollback();
		}
	}
}
