package com.nttdata.credit.mapper;

import com.nttdata.credit.document.CreditEntity;
import com.nttdata.credit.model.Credit;
import java.math.BigDecimal;

/**
 * Clase de mapper.
 */
public class CreditMaper {

  /**
   * Metodo para Credit a CreditEntity.
   *
   * @param creditDto creditDto.
   * @return dtoEntity.
   */
  public static CreditEntity dtoEntity(final Credit creditDto) {
    return CreditEntity.builder()
            .id(creditDto.getId())
            .type(creditDto.getType())
            .idcliente(creditDto.getIdcliente())
            .amount(creditDto.getAmount().intValue())
            .build();
  }

  /**
   * Metodo para creditoEntity a EntityDto.
   *
   * @param creditoEntity creditoEntity.
   * @return EntityDto.
   */
  public static Credit entityDto(final CreditEntity creditoEntity) {
    Credit credit = new Credit();
    credit.setId(creditoEntity.getId());
    credit.setType(creditoEntity.getType());
    credit.setIdcliente(creditoEntity.getIdcliente());
    credit.setAmount(BigDecimal.valueOf(creditoEntity.getAmount()));
    return credit;
  }
}
