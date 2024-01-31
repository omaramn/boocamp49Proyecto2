package com.nttdata.clientService.mapper;

import com.nttdata.clientService.document.TypeDocumentEntity;
import com.nttdata.clientService.model.TypeDocument;

/**
 * clase TypeDocumentMapper.
 */
public class TypeDocumentMapper {

  /**
   * metodo para cambiar de typeDocumentDto a TypeDocumentEntity.
   *
   * @param typeDocumentDto typeDocumentDto.
   * @return TypeDocumentEntity.
   */
  public static TypeDocumentEntity dtoEntity(TypeDocument typeDocumentDto) {
    return TypeDocumentEntity.builder()
            .idTypeDocument(typeDocumentDto.getIdTypeDocument())
            .type(typeDocumentDto.getType())
            .typedocument(typeDocumentDto.getTypedoc())
            .build();
  }

  /**
   * metodo para cambiar de TypeDocumentEntity a TypeDocument.
   *
   * @param typedocumententity typedocumententity.
   * @return TypeDocument.
   */
  public static TypeDocument entity(TypeDocumentEntity typedocumententity) {
    TypeDocument typeDocument = new TypeDocument();
    typeDocument.setIdTypeDocument(typedocumententity.getIdTypeDocument());
    typeDocument.setType(typedocumententity.getType());
    typeDocument.setTypedoc(typedocumententity.getTypedocument());
    return typeDocument;
  }
}
