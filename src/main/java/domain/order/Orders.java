package domain.order;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ORDERS")
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ORDER_ID")
	private Long id;

	@Column(name = "MEMBER_ID")
	private Long memberId;

	@Column(name = "ORDER_DATE")
	private LocalDateTime orderDate;

	@Enumerated(value = EnumType.STRING)
	@Column(name = "STATUS")
	private OrderStatus status;

	protected Orders() {
		// empty
	}
}
