package passion.troy.anizone.services;

import org.springframework.stereotype.Service;
import passion.troy.anizone.entities.Account;
import passion.troy.anizone.repositories.AccountRepository;

import java.util.Optional;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    //method to create an account will go here it calls the methods in Crudrepository with the dependency injected into this class
    public Account createAccount(Account account){
        return accountRepository.save(account);
    }

    //basically find by id method
    public Optional<Account> getAccountById(Long id){
        return accountRepository.findById(id);
    }
}
