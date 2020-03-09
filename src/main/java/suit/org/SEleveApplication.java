package suit.org;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import suit.org.Metier.Chauffeur;
import suit.org.Metier.Client;
import suit.org.Metier.RepChauffeur;
import suit.org.Metier.RepClient;
import suit.org.Metier.RepReserver;
import suit.org.Metier.RepVoiture;
import suit.org.Metier.RepVoyage;
import suit.org.Metier.Reserver;
import suit.org.Metier.Voiture;
import suit.org.Metier.Voyage;

@SpringBootApplication
public class SEleveApplication implements CommandLineRunner {
	@Autowired
	RepVoiture repVoiture;
	@Autowired
	RepChauffeur repChauffeur;
	@Autowired
	RepClient repClient;
	@Autowired
	RepReserver repReserver;
	@Autowired
	RepVoyage repVoyage;
	@Autowired
	RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(SEleveApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Voiture.class,Chauffeur.class,Reserver.class,Client.class,Voyage.class);
		// TODO Auto-generated method stub
		Chauffeur c=new Chauffeur(0,"Cisse","Pape","778809098",null,null,"123",true);
		repChauffeur.save(c);
		repVoiture.save(new Voiture(0,"DK 1441","Taxi",5,c,"vvv1.PNG"));
		Client cl=new Client(0,"100000","test","test@gmail.com","123","77009089","provider","nnn",null);
		repClient.save(cl);
		Voyage v =new Voyage(0, c, "SL", "DK", new Date(), 5000, null,2);
		repVoyage.save(v);
		Reserver rs=new Reserver(0, new Date(), 1,"77 802 21 10", cl, v);
		repReserver.save(rs);
		
		
	}

}
