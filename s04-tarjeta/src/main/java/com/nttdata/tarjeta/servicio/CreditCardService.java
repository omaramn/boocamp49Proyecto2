package com.nttdata.tarjeta.servicio;

import com.nttdata.tarjeta.mapper.CrediCardMapper;
import com.nttdata.tarjeta.model.CreditCardCreateInput;
import com.nttdata.tarjeta.model.CreditCardDetails;
import com.nttdata.tarjeta.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * Clase servicio.
 */
@Service
public class CreditCardService {
  @Autowired
  private CreditCardRepository creditCardRepository;

  /**
   * Metodo de crear tarjeta de credito.
   *
   * @param creditCard creditCard.
   * @return saveCreditCard.
   */
  public Mono<CreditCardDetails> saveCreditCard(final CreditCardCreateInput creditCard) {
    return creditCardRepository.save(CrediCardMapper.entitydto(creditCard))
            .flatMap(creditDet -> Mono.just(CrediCardMapper.dtoEntity(creditDet)));
  }
}
