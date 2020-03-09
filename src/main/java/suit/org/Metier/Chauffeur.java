package suit.org.Metier;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Chauffeur implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idChauffeur;
	private String nom;
	private String Prenom;
	private String tel;
	@OneToOne(mappedBy="chauffeur")
	private Voiture voiture;
	@OneToMany(mappedBy="chauffeur")
	private Set<Voyage> voyage;
	private String password;
	private boolean etat;

}
