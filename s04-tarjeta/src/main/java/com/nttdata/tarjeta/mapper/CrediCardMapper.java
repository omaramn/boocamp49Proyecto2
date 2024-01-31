package com.nttdata.tarjeta.mapper;

import com.nttdata.tarjeta.document.CreditCardEntity;
import com.nttdata.tarjeta.model.CreditCardCreateInput;
import com.nttdata.tarjeta.model.CreditCardDetails;
import java.math.BigDecimal;

/**
 * Clase de mapper.
 */
public class CrediCardMapper {

  /**
   * Metodo de para creditdto a entitydto.
   *
   * @param creditdto creditdto.
   * @return entitydto.
   */
  public static CreditCardEntity entitydto(final CreditCardCreateInput creditdto) {
    return CreditCardEntity.builder()
            .clientId(creditdto.getClientId())
            .limit(creditdto.getLimit().doubleValue())
            .cardNumber(creditdto.getCardNumber())
            .balance(0.0)
            .availableCredit(creditdto.getLimit().doubleValue())
            .build();

  }

  /**
   * Metodo para creditCard a dtoEntity.
   *
   * @param creditCard creditCard.
   * @return dtoEntity.
   */
  public static CreditCardDetails dtoEntity(final CreditCardEntity creditCard) {
    CreditCardDetails creditCardDetails = new CreditCardDetails();
    creditCardDetails.setId(creditCard.getId());
    creditCardDetails.setClientId(creditCard.getClientId());
    creditCardDetails.setLimit(new BigDecimal(creditCard.getLimit()));
    creditCardDetails.setCardNumber(creditCard.getCardNumber());
    creditCardDetails.setBalance(new BigDecimal(creditCard.getBalance()));
    creditCardDetails.setAvailableCredit(new BigDecimal(creditCard.getAvailableCredit()));
    return creditCardDetails;
  }
}
