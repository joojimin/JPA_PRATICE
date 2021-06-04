package domain;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
public class BaseEntity {

	@Column(name = "CREATED_USER", nullable = false)
	private String createdUser;

	@Column(name = "CREATED_AT", nullable = false)
	private LocalDateTime createdAt = LocalDateTime.now();

	@Column(name = "UPDATED_USER")
	private String updatedUser;

	@Column(name = "UPDATE_AT")
	private LocalDateTime updateAt;
}
