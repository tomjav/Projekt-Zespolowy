package Application.Controllers;

import Application.Model.Account;
import Application.Model.Role;
import Application.Repository.AccountRepository;
import Application.Security.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/account")
public class AccountGetController {

  @Autowired
  private AccountRepository accountRepository;

  @RequestMapping(method = RequestMethod.GET)
  public List<Account> getAccount(){
    return accountRepository.findAll();
  }

  @RequestMapping(method = RequestMethod.POST)
  public void editAccount(@RequestBody AccountDto accountDto){
    Account account = accountRepository.findOne(accountDto.getId());
    Role role = accountRepository.findRoleByName(accountDto.getRole());
    account.setUsername(accountDto.getUsername());
    account.setRole(role);
    accountRepository.save(account);
  }

  @RequestMapping(value = "roles", method = RequestMethod.GET)
  public List<String> getRoles(){
    return Stream.of(Roles.values()).map(e -> e.name()).collect(Collectors.toList());
  }
}
