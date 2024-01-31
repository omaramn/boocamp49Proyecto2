package com.nttdata.clientService.delegate;

import com.nttdata.clientService.api.ClientsApiDelegate;
import com.nttdata.clientService.model.Client;
import com.nttdata.clientService.model.SuccessResponse;
import com.nttdata.clientService.service.ClientService;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * clase componente.
 */
@Component
public class ClientApiDelegateImpl implements ClientsApiDelegate {
  @Autowired
  private ClientService clientService;

  /**
   * Metodo para crear un cliente.
   *
   * @param client (required)
   * @return Client created successfully (status code 201)
   */
  @Override
  public Mono<ResponseEntity<SuccessResponse>> createClient(Mono<Client> client, ServerWebExchange
          exchange) {
    return client
            .flatMap(clientRequest -> clientService.createClient(clientRequest)
                    .flatMap(createClient -> Mono.fromCallable(() -> {
                      SuccessResponse successResponse = new SuccessResponse();
                      successResponse.setIsSuccess(true);
                      successResponse.setStatus(BigDecimal.valueOf(200));
                      successResponse.setData(createClient);
                      successResponse.setMessage("Se creo");
                      successResponse.setTimestamp(LocalDateTime.now());
                      return ResponseEntity.ok(successResponse);
                    })));
  }

  /**
   * Buscar un cliente por id.
   *
   * @param clientId (required).
   * @return Client details retrieved successfully (status code 200)
   */
  @Override
  public Mono<ResponseEntity<Client>> getClientById(String clientId, ServerWebExchange exchange) {
    return clientService.getClientById(clientId)
            .flatMap(client -> Mono.just(ResponseEntity.ok(client)))
            .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
  }

  /**
   * metodo para listar clientes.
   */
  @Override
  public Mono<ResponseEntity<Flux<Client>>> getAllClients(ServerWebExchange exchange) {
    return Mono.just(ResponseEntity.ok(clientService.getAllClients()));
  }

  /**
   * Actualiza los clientes.
   */
  @Override
  public Mono<ResponseEntity<SuccessResponse>> updateClientById(String clientId, Mono<Client>
          client, ServerWebExchange exchange) {
    return client
            .flatMap(updatedClient -> clientService.updateClient(clientId, updatedClient)
                    .flatMap(savedClient -> Mono.fromCallable(() -> {
                      SuccessResponse successResponse = new SuccessResponse();
                      successResponse.setIsSuccess(true);
                      successResponse.setStatus(BigDecimal.valueOf(200));
                      successResponse.setData(savedClient);
                      successResponse.setMessage("Se Actualizo");
                      successResponse.setTimestamp(LocalDateTime.now());
                      return ResponseEntity.ok(successResponse);
                    }))
            );
  }

  /**
   * Elimina un cliente.
   */
  @Override
  public Mono<ResponseEntity<Void>> deleteClientById(String clientId, ServerWebExchange exchange) {
    return clientService.deleteClient(clientId)
            .then(Mono.just(ResponseEntity.noContent().<Void>build()))
            .defaultIfEmpty(ResponseEntity.notFound().build());
  }
}
