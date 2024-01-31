package com.nttdata.transaciones.repository;

import com.nttdata.transaciones.document.TransactionEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * Coneccion a la BD.
 */
public interface TransactionRepository extends ReactiveMongoRepository<TransactionEntity, String> {

}
