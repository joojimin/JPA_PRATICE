package domain.item;

import javax.persistence.*;

@Entity
@Table(name = "ITEM")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ITEM_ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "PRICE")
	private int price;

	@Column(name = "STOCKQUENTITY")
	private int stockQuentity;

	protected Item() {
		// empty
	}
}
