package domain.item;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "MOVIE")
@DiscriminatorValue("MOVIE")
public class Movie extends Item{

	@Column(name = "DIRECTOR")
	private String director;

	@Column(name = "ACTOR")
	private String actor;
}
