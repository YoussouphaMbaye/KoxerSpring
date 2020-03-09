package suit.org.Metier;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(uniqueConstraints= {@UniqueConstraint(columnNames= {"dateDepart","idChauffeur"})})
public class Voyage implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idVoyage;
	@ManyToOne
	@JoinColumn(name="idChauffeur")
	private Chauffeur chauffeur;
	private String depart;
	private String destination;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm")
	private Date dateDepart;
	private double tarif;
	@OneToMany(mappedBy="voyage")
    private Set<Reserver> reserver;
	private int nbPlace;
	

}
