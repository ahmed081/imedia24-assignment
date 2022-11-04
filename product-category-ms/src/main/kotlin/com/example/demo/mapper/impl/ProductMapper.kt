package com.example.demo.mapper.impl


import com.example.demo.dtos.ProductDTO
import com.example.demo.entities.Product
import com.example.demo.mapper.IMapper
import org.springframework.stereotype.Service

@Service
class ProductMapper (var categoryMapper: CategoryMapper) : IMapper<ProductDTO, Product> {


    override fun toDTO(entity: Product?): ProductDTO? {
        return ProductDTO(
            entity?.id,
            entity?.productPrice,
            entity?.productName,
            entity?.productQuantity,
            categoryMapper.toDTO(entity?.category),
            entity?.currency,
            entity?.exchangeRate,
            entity?.againstValue,
        )
    }

    override fun toListDTO(entities: List<Product>): List<ProductDTO> {
        return entities.map { toDTO(it)!! }
    }


    override fun toEntity(dto: ProductDTO?): Product? {
        val product = Product()
        product.id= dto?.id
        product.productPrice= dto?.productPrice
        product.productName= dto?.productName
        product.productQuantity= dto?.productQuantity
        product.againstValue= dto?.againstValue
        product.currency= dto?.currency
        product.exchangeRate= dto?.exchangeRate

        product.category= categoryMapper.toEntity(dto?.category!!)

        return product
    }




}