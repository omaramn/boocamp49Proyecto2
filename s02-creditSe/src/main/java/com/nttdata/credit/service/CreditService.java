package com.nttdata.credit.service;

import com.nttdata.credit.mapper.CreditMaper;
import com.nttdata.credit.model.Credit;
import com.nttdata.credit.repository.CreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * Clase servicio.
 */
@Service
public class CreditService {

  @Autowired
  private CreditRepository creditRepository;

  /**
   * Metodo para crear credito.
   *
   * @param credit credit.
   * @return createCreditSave.
   */
  public Mono<Credit> createCreditSave(Credit credit) {
    return creditRepository.save(CreditMaper.dtoEntity(credit))
            .flatMap(creditEntity -> Mono.just(CreditMaper.entityDto(creditEntity)));
  }
}
