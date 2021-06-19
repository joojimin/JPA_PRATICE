package domain.order;

import domain.member.Member;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

@Entity
@Table(name = "ORDERS")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ORDER_ID")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "MEMBER_ID")
	private Member member;

	@OneToOne
	@JoinColumn(name = "DELIVERY_ID", unique = true)
	private Delivery delivery;

	@Column(name = "ORDER_DATE")
	private LocalDateTime orderDate;

	@Enumerated(value = EnumType.STRING)
	@Column(name = "STATUS")
	private OrderStatus status;

	@OneToMany(mappedBy = "order")
	private List<OrderItem> orderItems = new ArrayList<>();

	protected Order() {
		// empty
	}

	public Order(final Member member, final OrderStatus status){
		this.member = member;
		this.orderDate = LocalDateTime.now();
		this.status = status;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", Order.class.getSimpleName() + "[", "]")
			.add("id=" + id)
			.add("member=" + member)
			.add("delivery=" + delivery)
			.add("orderDate=" + orderDate)
			.add("status=" + status)
			.toString();
	}
}
