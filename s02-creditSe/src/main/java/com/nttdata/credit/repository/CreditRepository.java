package com.nttdata.credit.repository;

import com.nttdata.credit.document.CreditEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * coneccion a la BD.
 */
public interface CreditRepository extends ReactiveMongoRepository<CreditEntity, String> {
}
