package com.nttdata.credit.document;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Clase de cuentas.
 */
@Data
@Builder
@Document(collection = "credit")
public class CreditEntity {
  @Id
  private String id;
  private String type;
  private String idcliente;
  private Integer amount;
}
