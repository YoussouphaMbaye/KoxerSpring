package suit.org.Metier;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource
public interface RepChauffeur extends JpaRepository<Chauffeur, Integer> {
	@RestResource(path="/chauffeurByTelPassword")
	public Chauffeur findChauffeurByTelAndPassword(@Param("tel") String tel , @Param("password") String password );

}
