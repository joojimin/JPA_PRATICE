package domain.order;

import javax.persistence.*;

@Entity
@Table(name = "DELIVERY")
public class Delivery {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DELIVERY_ID")
	private Long id;

	@Column(name = "CITY")
	private String city;

	@Column(name = "STREET")
	private String street;

	@Column(name = "ZIPCODE")
	private String zipCode;

	@Column(name = "STATUS")
	private OrderStatus status;

	protected Delivery() {
		// empty
	}
}
