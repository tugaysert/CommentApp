package entities;


import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="entities")
@Data
public class Like {
	
	@Id
	Long id;
	Long postId;
	Long userId;
	
	
	
}
