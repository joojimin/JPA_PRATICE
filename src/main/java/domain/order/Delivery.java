package domain.order;

import javax.persistence.*;

@Entity
@Table(name = "DELIVERY")
public class Delivery {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DELIVERY_ID")
	private Long id;

	private String city;

	private String street;

	private String zipCode;

	private OrderStatus status;

	protected Delivery() {
		// empty
	}
}
