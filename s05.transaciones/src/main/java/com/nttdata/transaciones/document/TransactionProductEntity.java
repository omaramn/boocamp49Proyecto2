package com.nttdata.transaciones.document;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Clase de TransactionProductEntity.
 */
@Data
@Builder
@Document(collection = "productTypes")
public class TransactionProductEntity {
  @Id
  private String idProductType;
  private String name;
  private String description;
}
