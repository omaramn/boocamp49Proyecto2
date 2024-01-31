package com.nttdata.transaciones.mapper;

import com.nttdata.transaciones.document.TransactionProductEntity;
import com.nttdata.transaciones.model.ProductType;

/**
 * Clase de ProductMapper.
 */
public class ProductMapper {

  /**
   * Metodo para productDto a dtoEntity.
   *
   * @param productDto productDto.
   * @return dtoEntity.
   */
  public static TransactionProductEntity dtoEntity(ProductType productDto) {
    return TransactionProductEntity.builder()
            .idProductType(productDto.getIdProductType())
            .name(productDto.getName())
            .description(productDto.getDescription())
            .build();
  }

  /**
   * Metodo para dtoProducto a entityDto.
   *
   * @param dtoProducto dtoProducto.
   * @return entityDto.
   */
  public static ProductType entityDto(TransactionProductEntity dtoProducto) {
    ProductType productType = new ProductType();
    productType.setIdProductType(dtoProducto.getIdProductType());
    productType.setName(dtoProducto.getName());
    productType.setDescription(dtoProducto.getDescription());
    return productType;
  }
}
