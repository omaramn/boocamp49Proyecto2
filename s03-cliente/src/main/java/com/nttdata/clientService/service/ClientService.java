package com.nttdata.clientService.service;

import com.nttdata.clientService.document.ClientEntity;
import com.nttdata.clientService.mapper.ClientMapper;
import com.nttdata.clientService.mapper.TypeClientMapper;
import com.nttdata.clientService.mapper.TypeDocumentMapper;
import com.nttdata.clientService.model.Client;
import com.nttdata.clientService.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * clase service.
 */
@Service
public class ClientService {

  @Autowired
  private ClientRepository clientRepository;

  /**
   * Metodo para crear un cliente.
   *
   * @param clientMono (required).
   * @return Client created successfully (status code 201).
   */
  public Mono<Client> createClient(Client clientMono) {
    return clientRepository.save(ClientMapper.dtoEntity(clientMono))
            .flatMap(clientEntity -> Mono.just(ClientMapper.entityDto(clientEntity)));
  }

  /**
   * Buscar un cliente por id.
   *
   * @param clientId (required).
   * @return Client details retrieved successfully (status code 200).
   */
  public Mono<Client> getClientById(String clientId) {
    return clientRepository.findById(clientId)
            .flatMap(clientById -> Mono.just(ClientMapper.entityDto(clientById)));
  }

  /**
   * Metodo de listar clientes.
   */
  public Flux<Client> getAllClients() {
    return clientRepository.findAll()
            .flatMap(client -> Mono.just(ClientMapper.entityDto(client)));
  }

  /**
   * Metodo de actualizar clientes.
   *
   * @param clientId parametro.
   * @return cliente actualizado.
   */
  public Mono<ClientEntity> updateClient(String clientId, Client updatedClient) {
    return clientRepository.findById(clientId)
            .flatMap(existingClient -> {
              existingClient.setName(updatedClient.getName());
              existingClient.setTypeClient(TypeClientMapper
                      .dtoEntity(updatedClient.getTypeclient()));
              existingClient.setTypeDocument(TypeDocumentMapper
                      .dtoEntity(updatedClient.getTypedocument()));
              return clientRepository.save(existingClient);
            });
  }

  /**
   * Metodo que elimina cliente.
   */
  public Mono<Void> deleteClient(String clientId) {
    return clientRepository.deleteById(clientId);
  }
}
