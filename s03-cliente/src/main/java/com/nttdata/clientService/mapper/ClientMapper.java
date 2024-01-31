package com.nttdata.clientService.mapper;

import com.nttdata.clientService.document.ClientEntity;
import com.nttdata.clientService.model.Client;

/**
 * clase ClientMapper.
 */
public class ClientMapper {

  /**
   * metodo para cambiar de cliente a cliente entity.
   *
   * @param clientDto parametro Client.
   * @return ClientEntity.
   */
  public static ClientEntity dtoEntity(final Client clientDto) {
    return ClientEntity.builder()
            .id(clientDto.getId())
            .name(clientDto.getName())
            .typeClient(TypeClientMapper.dtoEntity(clientDto.getTypeclient()))
            .typeDocument(TypeDocumentMapper.dtoEntity(clientDto.getTypedocument()))
            .build();
  }

  /**
   * Metodo que devulve cliente a cliente entity.
   *
   * @param clientEntity ClientEntity.
   * @return Client.
   */
  public static Client entityDto(final ClientEntity clientEntity) {
    Client client = new Client();
    client.setId(clientEntity.getId());
    client.setName(clientEntity.getName());
    client.setTypeclient(TypeClientMapper.entityDto(clientEntity.getTypeClient()));
    client.setTypedocument(TypeDocumentMapper.entity(clientEntity.getTypeDocument()));
    return client;

  }
}
