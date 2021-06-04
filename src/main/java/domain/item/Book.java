package domain.item;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "BOOK")
@DiscriminatorValue("BOOK")
public class Book extends Item{

	@Column(name = "AUTHOR")
	private String author;

	@Column(name = "ISBN")
	private String isbn;
}
