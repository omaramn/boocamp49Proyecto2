package com.nttdata.transaciones.mapper;

import com.nttdata.transaciones.document.TransactionEntity;
import com.nttdata.transaciones.model.Transaction;
import java.time.LocalDateTime;

/**
 * Clase de TransactionMapper.
 */
public class TransactionMapper {

  /**
   * Metodo para transactionDto a dtoEntity.
   *
   * @param transactionDto transactionDto.
   * @return dtoEntity.
   */
  public static TransactionEntity dtoEntity(final Transaction transactionDto) {
    return TransactionEntity.builder()
            .id(transactionDto.getId())
            .clientId(transactionDto.getClientId())
            .sourceType(ProductMapper.dtoEntity(transactionDto.getSourceType()))
            .sourceNumber(transactionDto.getSourceNumber())
            .destinyType(ProductMapper.dtoEntity(transactionDto.getDestinyType()))
            .destinyNumber(transactionDto.getDestinyNumber())
            .amount(transactionDto.getAmount())
            .description(transactionDto.getDescription())
            .transactionDate(LocalDateTime.now())
            .transactionType(TypeMapper.dtoEntity(transactionDto.getTransactionType()))
            .build();
  }

  /**
   * Metodo para dtoTransaction a entityDto.
   *
   * @param dtoTransaction dtoTransaction.
   * @return entityDto.
   */

  public static Transaction entityDto(final TransactionEntity dtoTransaction) {
    Transaction transaction = new Transaction();
    transaction.setId(dtoTransaction.getId());
    transaction.setClientId(dtoTransaction.getClientId());
    transaction.setSourceType(ProductMapper.entityDto(dtoTransaction.getSourceType()));
    transaction.setSourceNumber(dtoTransaction.getSourceNumber());
    transaction.setDestinyType(ProductMapper.entityDto(dtoTransaction.getDestinyType()));
    transaction.setDestinyNumber(dtoTransaction.getDestinyNumber());
    transaction.setAmount(dtoTransaction.getAmount());
    transaction.setDescription(dtoTransaction.getDescription());
    transaction.setTransactionDate(LocalDateTime.now());
    transaction.setTransactionType(TypeMapper.entityDto(dtoTransaction.getTransactionType()));
    return transaction;
  }
}
