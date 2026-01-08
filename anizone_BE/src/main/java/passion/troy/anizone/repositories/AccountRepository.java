package passion.troy.anizone.repositories;


import org.springframework.data.repository.CrudRepository;
import passion.troy.anizone.entities.Account;

public interface AccountRepository extends CrudRepository<Account, Long> {

}
