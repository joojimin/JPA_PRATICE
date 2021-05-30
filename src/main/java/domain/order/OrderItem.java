package domain.order;

import javax.persistence.*;

@Entity
@Table(name = "ORDER_ITEM")
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ORDER_ITEM_ID")
	private Long id;

	@Column(name = "ORDER_ID")
	private Long orderId;

	@Column(name = "ITEM_ID")
	private Long itemId;

	@Column(name = "ORDERPRICE")
	private int orderPrice;

	@Column(name = "COUNT")
	private int count;

	protected OrderItem() {
		// empty
	}
}
