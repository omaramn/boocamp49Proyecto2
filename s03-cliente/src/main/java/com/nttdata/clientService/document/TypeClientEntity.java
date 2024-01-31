package com.nttdata.clientService.document;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * clase tipo de cliente.
 */
@Data
@Builder
@Document(collection = "typeclient")
public class TypeClientEntity {
  @Id
  private String idTypeClient;
  private String type;
  private String status;
}
