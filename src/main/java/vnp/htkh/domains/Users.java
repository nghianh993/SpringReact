package vnp.htkh.domains;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Users implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String address;

	@Temporal(TemporalType.DATE)
	private Date datecreate;

	private String email;

	private String fullname;

	private String iplogin;

	private boolean islock;

	private String lockresion;

	private String password;

	private String phone;
	
	private String dob;

	private String username;

	private String images;

	private Date datemodify;
	
	@ManyToOne
	@JoinColumn(name="ORGANIZATIONID")
	private Organization organization;

	@ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "USER_ROLE_MAPPING",
      joinColumns =  @JoinColumn(name = "userid", referencedColumnName = "ID"),
      inverseJoinColumns =  @JoinColumn(name = "roleid", referencedColumnName = "ID"))
	private List<Role> roles = new ArrayList<Role>();

	public Users() {
	}
}