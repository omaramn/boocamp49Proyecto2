package com.nttdata.accountService.repository;

import com.nttdata.accountService.document.AccountDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * Coneccion de la BD.
 */
public interface AccountRepository extends ReactiveMongoRepository<AccountDocument, String> {

}
