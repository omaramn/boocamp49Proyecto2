package com.nttdata.tarjeta.document;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Clase de creditos.
 */
@Data
@Builder
@Document(collection = "creditCards")
public class CreditCardEntity {
  @Id
  private String id;
  private String clientId;
  private Double limit;
  private String cardNumber;
  private Double balance;
  private Double availableCredit;
}
