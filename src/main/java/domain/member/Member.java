package domain.member;

import domain.order.Order;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

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

	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
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

	public void setName(String name) {
		this.name = name;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", Member.class.getSimpleName() + "[", "]")
			.add("id=" + id)
			.add("name='" + name + "'")
			.add("city='" + city + "'")
			.add("street='" + street + "'")
			.add("zipCode='" + zipCode + "'")
			.toString();
	}

	public String getName() {
		return name;
	}

	public String getCity() {
		return city;
	}

	public String getStreet() {
		return street;
	}

	public String getZipCode() {
		return zipCode;
	}
}
