package com.nttdata.accountService.mapper;

import com.nttdata.accountService.document.AccountDocument;
import com.nttdata.accountService.model.AccountCreate;
import com.nttdata.accountService.model.AccountDetails;
import com.nttdata.accountService.model.ClientDTO;

/**
 * clase CuentaMapper.
 */
public class AccountMapper {

  /**
   * Metodo para llamar AccountCreate a AccountDocument.
   *
   * @param accoutDto accoutDto.
   * @return AccountDocument.
   */
  public static AccountDocument dtoEntity(final AccountCreate accoutDto) {
    AccountDocument accountDocument = new AccountDocument();
    accountDocument.setId(accoutDto.getId());
    accountDocument.setTypecuenta(accoutDto.getTypecuenta());
    accountDocument.setIdcliente(accoutDto.getIdclient());
    return accountDocument;
  }

  /**
   * Metodo para llamar AccountDocument y ClientDTO.
   *
   * @param acountEntity acountEntity.
   * @param clientDto    clientDto.
   * @return AccountDetails.
   */
  public static AccountDetails entityDto(AccountDocument acountEntity, ClientDTO clientDto) {
    AccountDetails accountDetails = new AccountDetails();
    accountDetails.setId(acountEntity.getId());
    accountDetails.setTypecuenta(acountEntity.getTypecuenta());
    accountDetails.setClients(clientDto);
    return accountDetails;
  }
}
