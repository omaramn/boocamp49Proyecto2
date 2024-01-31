package com.nttdata.accountService.service;

import com.nttdata.accountService.feingClient.ClienteFeignClient;
import com.nttdata.accountService.mapper.AccountMapper;
import com.nttdata.accountService.model.AccountCreate;
import com.nttdata.accountService.model.AccountDetails;
import com.nttdata.accountService.model.ClientDTO;
import com.nttdata.accountService.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * clase servicio.
 */
@Service
public class AccountService {

  @Autowired
  private AccountRepository accountRepository;

  @Autowired
  private ClienteFeignClient clienteFeignClient;

  /**
   * Metodo de crear una cuenta.
   *
   * @param accountCreate accountCreate.
   * @return accountsPost.
   */
  public Mono<AccountDetails> accountsPost(AccountCreate accountCreate) {

    ClientDTO clientDto = clienteFeignClient.getClientById(accountCreate.getIdclient());

    return accountRepository.save(AccountMapper.dtoEntity(accountCreate))
            .flatMap(accountEntity -> Mono.just(AccountMapper
                    .entityDto(accountEntity, clientDto)));
  }

}
