package domain.item;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ALBUM")
@DiscriminatorValue("ALBUM")
public class Album extends Item{

	@Column(name = "ARTIST")
	private String artist;

	@Column(name = "ETC")
	private String etc;
}
