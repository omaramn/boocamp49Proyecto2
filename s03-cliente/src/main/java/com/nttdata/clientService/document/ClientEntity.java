package com.nttdata.clientService.document;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * clase cliente.
 */
@Data
@Builder
@Document(collection = "clients")
public class ClientEntity {
  @Id
  private String id;
  private String name;
  private TypeClientEntity typeClient;
  private TypeDocumentEntity typeDocument;

}
