package suit.org.web;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import suit.org.Metier.Chauffeur;
import suit.org.Metier.Client;
import suit.org.Metier.Gestionnaire;
import suit.org.Metier.RepChauffeur;
import suit.org.Metier.RepClient;
import suit.org.Metier.RepGestionnaire;
import suit.org.Metier.RepReserver;
import suit.org.Metier.RepVoiture;
import suit.org.Metier.RepVoyage;
import suit.org.Metier.Reserver;
import suit.org.Metier.Voiture;
import suit.org.Metier.Voyage;
@CrossOrigin("*")
@RestController
public class Controller {
	@Autowired
	RepChauffeur repChauffeur;
	@Autowired
	RepVoiture repVoiture;
	@Autowired
	RepClient repClient;
	@Autowired
	RepVoyage repVoyage;
	@Autowired
	RepReserver repReserver;
	@Autowired
	RepGestionnaire repGestionnaire;
	
	@PostMapping(path="/addChauffeur")
	public Chauffeur addChauffeur(@RequestBody Chauffeur chf) {
		System.out.println("asdfghjkl;l'poiuyfgkuygfvbnklfcvbnmfcvnkuy");
		return repChauffeur.save(chf);
		
	}
	
	@PostMapping(path="/addVoiture")
	public Voiture addVoiture(@RequestBody Voiture v) {
		System.out.println("asdfghjkl;l'poiuyfgkuygfvbnklfcvbnmfcvnkuy");
		return repVoiture.save(v);
		
	}
	@PostMapping(path="/addClient")
	public Client addClient(@RequestBody Client c) {
		return repClient.save(c);
	}
	@PostMapping(path="/addVoyage")
	public Voyage addVoyage(@RequestBody Voyage v) {
		
		return repVoyage.save(v);
	}
	@PutMapping(path="/updateVoyage")
	public Voyage updateVoyage(@RequestBody Voyage v) {
		
		return repVoyage.save(v);
	}
	@PostMapping(path="/addReserver")
	public Reserver addReserver(@RequestBody Reserver reserver) {
		reserver.setDateReservation(new Date());
		return repReserver.save(reserver);
	}
	@GetMapping(path="/voiturePhoto/{id}",produces=MediaType.IMAGE_PNG_VALUE)
	public byte[] getPhoto(@PathVariable int id) throws Exception {
		Voiture v=repVoiture.getOne(id);
		return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/ecom/photos/"+v.getPhoto()));
	}
	@PostMapping(path="/uploadPhoto/{id}")
	public void uploadPhoto(MultipartFile file,@PathVariable int id) throws Exception{
		Voiture v=repVoiture.getOne(id);
		v.setPhoto("vvv"+v.getIdVoiture()+".PNG");
		Files.write(Paths.get(System.getProperty("user.home")+"/ecom/photos/"+v.getPhoto()),file.getBytes());
		repVoiture.save(v);
	}
	@PostMapping(path="/addGestionnaire")
	public Gestionnaire addGestionnaire(@RequestBody Gestionnaire gestionnaire) {
		gestionnaire.setPassword("2020gestionnaire123");
		return repGestionnaire.save(gestionnaire);
		
	}

}
