package suit.org.Metier;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idClient;
    private String idProvider;
    private String nom;
    @Column(unique=true)
    private String email;
    private String password;
    private String tel;
    private String provider;
    private String photoUrl;
    @OneToMany(mappedBy="client")
    private Set<Reserver> reservers;
}
