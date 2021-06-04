package domain.item;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CATEGORY")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CATEGORY_ID")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "PARENT_ID")
	private Category category;

	@Column(name = "NAME")
	private String name;

	@ManyToMany
	@JoinTable(joinColumns = @JoinColumn(name = "CATEGORY_ID"),
			   inverseJoinColumns = @JoinColumn(name = "ITEM_ID"))
	private List<Item> items;
}
