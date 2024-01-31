package com.nttdata.transaciones.mapper;

import com.nttdata.transaciones.document.TransactionTypeEntity;
import com.nttdata.transaciones.model.TransactionType;

/**
 * Clase de TypeMapper.
 */
public class TypeMapper {

  /**
   * Metodo para typeDto a dtoEntity.
   *
   * @param typeDto typeDto.
   * @return dtoEntity.
   */
  public static TransactionTypeEntity dtoEntity(TransactionType typeDto) {
    return TransactionTypeEntity.builder()
            .idTransactionType(typeDto.getIdTransactionType())
            .name(typeDto.getName())
            .description(typeDto.getDescription())
            .build();

  }

  /**
   * Metodo para dtoEntity a entityDto.
   *
   * @param dtoEntity dtoEntity.
   * @return entityDto.
   */
  public static TransactionType entityDto(TransactionTypeEntity dtoEntity) {
    TransactionType transactionType = new TransactionType();
    transactionType.setIdTransactionType(dtoEntity.getIdTransactionType());
    transactionType.setName(dtoEntity.getName());
    transactionType.setDescription(dtoEntity.getDescription());
    return transactionType;
  }
}
