package jpql;

import domain.member.Member;
import org.junit.jupiter.api.Test;

import java.util.List;

public class NativeQueryTest extends BaseTester {


	@Test
	void simpleQueryTest() {
		entityTransaction.begin();

		// logic
		try {
			Member member1 = new Member("주지민", "춘천", "도림천로", "몰라");
			Member member2 = new Member("박선정", "구미", "광진구", "몰라");
			entityManager.persist(member1);
			entityManager.persist(member2);

			member1.setCity("서울");
			member2.setStreet("구로구");

			List<Member> list1 = entityManager.createNativeQuery("SELECT * FROM MEMBER", Member.class).getResultList();
			list1.forEach(System.out::println);

			List<Member> list2 = entityManager.createNativeQuery("SELECT * FROM MEMBER m WHERE m.name = '주지민'", Member.class).getResultList();
			list2.forEach(System.out::println);

			entityTransaction.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityTransaction.rollback();
		}
	}
}
