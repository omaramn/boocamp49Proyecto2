package com.nttdata.accountService.apidelegate;

import com.nttdata.accountService.api.AccountsApiDelegate;
import com.nttdata.accountService.model.AccountCreate;
import com.nttdata.accountService.model.AccountDetails;
import com.nttdata.accountService.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * clase componente.
 */
@Component
public class AccountApiDelegateImpl implements AccountsApiDelegate {

  @Autowired
  private AccountService accountService;

  /**
   * POST /accounts : Create a new bank account.
   *
   * @param accountCreate (required).
   * @return Account created successfully (status code 201).
   */
  @Override
  public Mono<ResponseEntity<AccountDetails>> accountsPost(Mono<AccountCreate> accountCreate,
                                                           ServerWebExchange exchange) {
    return accountCreate
            .flatMap(accoutRequest -> accountService.accountsPost(accoutRequest))
            .flatMap(crearAccount -> Mono.just(ResponseEntity.ok(crearAccount)));
  }
}
