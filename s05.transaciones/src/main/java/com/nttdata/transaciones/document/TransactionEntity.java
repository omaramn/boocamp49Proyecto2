package com.nttdata.transaciones.document;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Clase de transaccion.
 */
@Data
@Builder
@Document(collection = "transactions")
public class TransactionEntity {
  @Id
  private String id;
  private String clientId;
  private TransactionProductEntity sourceType;
  private String sourceNumber;
  private TransactionProductEntity destinyType;
  private String destinyNumber;
  private Double amount;
  private String description;
  private LocalDateTime transactionDate;
  private TransactionTypeEntity transactionType;

}
