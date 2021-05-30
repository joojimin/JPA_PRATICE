package domain.order;

import domain.member.Member;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
}
