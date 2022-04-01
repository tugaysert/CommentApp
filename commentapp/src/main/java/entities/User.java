package entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="users")
@Data
public class User {
	
	@Id
	Long id;
	
	String userName;
	
	String password;
	

}
