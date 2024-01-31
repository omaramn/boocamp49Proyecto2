package com.nttdata.transaciones.apiDelegate;

import com.nttdata.transaciones.api.TransactionsApiDelegate;
import com.nttdata.transaciones.model.Transaction;
import com.nttdata.transaciones.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * Clase de Component.
 */
@Component
public class TransactionApiDelegateImpl implements TransactionsApiDelegate {

  @Autowired
  private TransactionService transactionService;

  /**
   * Metodo para crear la transacciones.
   *
   * @param transaction (required) transaction.
   * @param exchange    exchange.
   * @return createTransaction.
   */
  @Override
  public Mono<ResponseEntity<Transaction>> createTransaction(Mono<Transaction> transaction,
                                                             ServerWebExchange exchange) {
    return transaction
            .flatMap(transactionRequest -> transactionService.saveTransaction(transactionRequest))
            .flatMap(transactionCreate -> Mono.just(ResponseEntity.ok(transactionCreate)));
  }
}
