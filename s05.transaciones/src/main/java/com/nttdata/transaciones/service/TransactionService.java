package com.nttdata.transaciones.service;

import com.nttdata.transaciones.mapper.TransactionMapper;
import com.nttdata.transaciones.model.Transaction;
import com.nttdata.transaciones.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * Clase de TransactionService.
 */
@Service
public class TransactionService {

  @Autowired
  private TransactionRepository transactionRepository;

  /**
   * Metodo de creacion de transaccion.
   *
   * @param transaction transaction.
   * @return saveTransaction.
   */
  public Mono<Transaction> saveTransaction(Transaction transaction) {
    return transactionRepository.save(TransactionMapper.dtoEntity(transaction))
            .flatMap(transacionEntity -> Mono.just(TransactionMapper.entityDto(transacionEntity)));
  }
}
