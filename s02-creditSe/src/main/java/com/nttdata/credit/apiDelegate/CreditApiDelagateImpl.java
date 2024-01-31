package com.nttdata.credit.apiDelegate;

import com.nttdata.credit.api.CreditsApiDelegate;
import com.nttdata.credit.model.Credit;
import com.nttdata.credit.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * clase componente.
 */
@Component
public class CreditApiDelagateImpl implements CreditsApiDelegate {

  @Autowired
  private CreditService creditService;

  /**
   * Metodo para crear credito.
   *
   * @param credit  (optional).
   * @return createcredit.
   */
  @Override
  public Mono<ResponseEntity<Credit>> createcredit(Mono<Credit> credit,
                                                   ServerWebExchange exchange) {
    return credit
            .flatMap(creditRequest -> creditService.createCreditSave(creditRequest)
                    .flatMap(createCredit -> Mono.just(ResponseEntity.ok(createCredit)))
                    .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()))
            );
  }
}
