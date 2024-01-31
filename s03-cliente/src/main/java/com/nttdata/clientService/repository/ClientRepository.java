package com.nttdata.clientService.repository;

import com.nttdata.clientService.document.ClientEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Component;

/**
 * interface para la comunicacion ala BD de mongo.
 */
@Component
public interface ClientRepository extends ReactiveMongoRepository<ClientEntity, String> {
}
