package vnp.htkh.domains;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class Permission implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String description;

	private boolean islock;
	
	private String link;

	@ManyToOne
	@JoinColumn(name="GROUPID")
	private GroupPermission groupPermission;

	public Permission() {
	}
}