package passion.troy.anizone.controllers;

import org.springframework.web.bind.annotation.*;
import passion.troy.anizone.entities.Account;
import passion.troy.anizone.services.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

    @GetMapping("/{accountId}")
    public Account getAccount(@PathVariable Long accountId) {
        return accountService.getAccountById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }

}
