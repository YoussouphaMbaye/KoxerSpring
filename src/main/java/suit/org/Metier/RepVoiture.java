package suit.org.Metier;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;

import java.lang.String;
import suit.org.Metier.Voiture;
import java.util.List;
@CrossOrigin("*")
@RepositoryRestResource
public interface RepVoiture extends JpaRepository<Voiture, Integer>{

	@RestResource(path="/voitureParType")
	List<Voiture> findByType(@Param("type") String type);
}
