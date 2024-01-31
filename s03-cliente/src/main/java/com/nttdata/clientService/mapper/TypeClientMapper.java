package com.nttdata.clientService.mapper;

import com.nttdata.clientService.document.TypeClientEntity;
import com.nttdata.clientService.model.TypeClient;

/**
 * clase TypeClientMapper.
 */
public class TypeClientMapper {

  /**
   * metodo para cambiar de TypeClient a TypeClientEntity.
   *
   * @param typeClientDto parametro TypeClient.
   * @return TypeClientEntity.
   */

  public static TypeClientEntity dtoEntity(TypeClient typeClientDto) {
    return TypeClientEntity.builder()
            .idTypeClient(typeClientDto.getIdTypeClient())
            .type(typeClientDto.getType())
            .status(typeClientDto.getStatus())
            .build();
  }

  /**
   * metodo para cambiar de TypeClientEntity a TypeClient.
   *
   * @param typecliententity typecliententity.
   * @return TypeClient.
   */
  public static TypeClient entityDto(TypeClientEntity typecliententity) {
    TypeClient typeClient = new TypeClient();
    typeClient.setIdTypeClient(typecliententity.getIdTypeClient());
    typeClient.setType(typecliententity.getType());
    typeClient.setStatus(typecliententity.getStatus());
    return typeClient;
  }
}
