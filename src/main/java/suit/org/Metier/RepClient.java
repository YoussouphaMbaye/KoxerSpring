package suit.org.Metier;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin("*")
@RepositoryRestResource
public interface RepClient extends JpaRepository<Client,Integer>{
	@RestResource(path="/clientIdpv")
	Client findByIdProvider(@Param(value = "idpv") String idpv);
	@RestResource(path="/clientEmailPassword")
	Client findByEmailAndPassword(@Param(value = "email") String email,@Param(value = "password") String password);

}
