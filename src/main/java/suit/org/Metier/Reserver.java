package suit.org.Metier;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(uniqueConstraints= {@UniqueConstraint(columnNames= {"idVoyage","idClient"})})
public class Reserver implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRserver;
	private Date dateReservation;
	private int nbPlace;
	private String tel;
	@JoinColumn(name="idClient")
	@ManyToOne
	private Client client;
	@JoinColumn(name="idVoyage")
	@ManyToOne
	private Voyage voyage;

}
