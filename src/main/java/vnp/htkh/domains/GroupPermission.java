package vnp.htkh.domains;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
public class GroupPermission implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String name;
	
	private int parentid;

	@OneToMany(mappedBy="groupPermission", fetch=FetchType.EAGER)
	private List<Permission> permissions;

	public GroupPermission() {
	}
}