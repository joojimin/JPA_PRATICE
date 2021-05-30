package domain.member;

import domain.order.Order;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "MEMBER")
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MEMBER_ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "CITY")
	private String city;

	@Column(name = "STREET")
	private String street;

	@Column(name = "ZIPCODE")
	private String zipCode;

	@OneToMany(mappedBy = "member")
	private List<Order> order = new ArrayList<>();

	protected Member() {
		// empty
	}

	public Member(final String name, final String city, final String street, final String zipCode){
		this.name = name;
		this.city = city;
		this.street = street;
		this.zipCode = zipCode;
	}

	public void addOrder(final Order order){
		this.order.add(order);
		order.setMember(this);
	}
}
