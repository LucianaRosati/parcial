package entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.envers.Audited;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "person")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Audited
@Builder

public class Persona extends Base {

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_address")
	private Domicilio address;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@Builder.Default
	private List<Libro> books = new ArrayList<Libro>();
	@JoinTable(name = "person_book", joinColumns = @JoinColumn(name = "person_id"), inverseJoinColumns = @JoinColumn(name = "book_id"))

	@Column(name = "name")
	private String name;
	@Column(name = "last_name")
	private String last_name;
	@Column(name = "dni")
	private int dni;
	

}
