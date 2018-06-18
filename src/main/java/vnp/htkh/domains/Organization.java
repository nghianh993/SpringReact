package vnp.htkh.domains;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
public class Organization implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int lever;

	private String name;

	private int parentid;
	
	@OneToMany(mappedBy="organization")
	private List<Users> users;

	public Organization() {
	}

}