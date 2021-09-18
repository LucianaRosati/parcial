package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.envers.Audited;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "author")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Audited
@Builder
public class Autor extends Base{
	
	
	
	
	@Column(name="name")
	private String name;
	@Column(name="last_name")
	private String last_name;
	@Column(name="biography", length=1500)
	private String biography; 
}
