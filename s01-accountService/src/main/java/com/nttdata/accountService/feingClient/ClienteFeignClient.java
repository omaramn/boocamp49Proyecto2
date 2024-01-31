package com.nttdata.accountService.feingClient;

import com.nttdata.accountService.model.ClientDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * llamada a cliente.
 */
@FeignClient(name = "s03-clientService", url = "${ntt.data.bootcamp.s03-client-service}")
public interface ClienteFeignClient {

    /**
     * Metodo que llama a cliente.
     */
    @GetMapping("/clients/{clientId}")
    ClientDTO getClientById(@PathVariable("clientId") String clientId);

}
