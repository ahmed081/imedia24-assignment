package com.example.demo.mapper

import com.example.demo.dtos.ProductDTO
import com.example.demo.entities.Product
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers


@Mapper
interface ProductMapper {
    val converter: ProductMapper
        get() = Mappers.getMapper(ProductMapper::class.java)

    fun convertToDTO(product:Product): ProductDTO



}