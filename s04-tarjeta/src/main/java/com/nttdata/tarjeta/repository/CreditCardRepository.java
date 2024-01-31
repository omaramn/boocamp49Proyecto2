package com.nttdata.tarjeta.repository;

import com.nttdata.tarjeta.document.CreditCardEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * Coneccion a la BD.
 */
public interface CreditCardRepository extends ReactiveMongoRepository<CreditCardEntity, String> {
}
