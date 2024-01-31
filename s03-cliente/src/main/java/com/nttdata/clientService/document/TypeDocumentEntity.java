package com.nttdata.clientService.document;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * clase typo de documento.
 */
@Data
@Builder
@Document(collection = "typedocument")
public class TypeDocumentEntity {

  @Id
  private String idTypeDocument;
  private String type;
  private String typedocument;

}
