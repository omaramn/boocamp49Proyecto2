package com.nttdata.accountService.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * clase cuenta.
 */
@Data
@Document(collection = "accounts")
public class AccountDocument {
  @Id
  private String id;
  private String typecuenta;
  private String idcliente;

}
