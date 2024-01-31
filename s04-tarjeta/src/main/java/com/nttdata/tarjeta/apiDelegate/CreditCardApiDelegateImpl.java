package com.nttdata.tarjeta.apiDelegate;

import com.nttdata.tarjeta.api.CreditCardsApiDelegate;
import com.nttdata.tarjeta.model.CreditCardCreateInput;
import com.nttdata.tarjeta.model.CreditCardDetails;
import com.nttdata.tarjeta.servicio.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * Clase de Component.
 */
@Component
public class CreditCardApiDelegateImpl implements CreditCardsApiDelegate {

  @Autowired
  CreditCardService creditCardService;

  /**
   * Metodo apra crear credito.
   *
   * @param creditCardCreateInput (required).
   * @return creditCardsPost.
   */
  @Override
  public Mono<ResponseEntity<CreditCardDetails>> creditCardsPost(Mono<CreditCardCreateInput>
                                                                           creditCardCreateInput,
                                                                 ServerWebExchange exchange) {
    return creditCardCreateInput
            .flatMap(creditCarRequest -> creditCardService.saveCreditCard(creditCarRequest))
            .flatMap(credit -> Mono.just(ResponseEntity.ok(credit)));
  }
}
