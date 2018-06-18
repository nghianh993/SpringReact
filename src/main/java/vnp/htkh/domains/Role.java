package vnp.htkh.domains;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String rolename;

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "ROLES_PERMISSION",
 		joinColumns = @JoinColumn(name = "ROLEID", referencedColumnName = "ID"),
 		inverseJoinColumns = @JoinColumn(name = "PERMISSIONID", referencedColumnName = "ID"))
 	private Set<Permission> permissions = new HashSet<Permission>();
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "USER_ROLE_MAPPING",
 		joinColumns = @JoinColumn(name = "ROLEID", referencedColumnName = "ID"),
 		inverseJoinColumns = @JoinColumn(name = "USERID", referencedColumnName = "ID"))
 	private Set<Users> users = new HashSet<Users>();

	public Role() {
	}

}