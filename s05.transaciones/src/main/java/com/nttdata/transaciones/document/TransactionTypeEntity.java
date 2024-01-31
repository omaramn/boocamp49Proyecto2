package com.nttdata.transaciones.document;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Clase  de TransactionTypeEntity.
 */
@Data
@Builder
@Document(collection = "transactionTypes")
public class TransactionTypeEntity {
  @Id
  private String idTransactionType;
  private String name;
  private String description;
}
