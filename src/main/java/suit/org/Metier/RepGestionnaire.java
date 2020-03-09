package suit.org.Metier;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin("*")
public interface RepGestionnaire extends JpaRepository<Gestionnaire,Integer> {

}
