package entities;



import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.hibernate.envers.Audited;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "book")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Audited
@Builder
public class Libro extends Base{
	
	@Column(name="title")
	private String title;
	@Column(name="date")
	private int date;
	@Column(name="gender")
	private String gender;
	@Column(name="pages")
	private int pages;
	@ManyToMany(cascade=CascadeType.REFRESH)
	@Builder.Default
	private List<Autor> authors = new ArrayList <Autor>();
}
