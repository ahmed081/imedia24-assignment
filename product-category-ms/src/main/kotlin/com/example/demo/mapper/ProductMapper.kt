package com.example.demo.mapper


import com.example.demo.dtos.ProductDTO
import com.example.demo.entities.Product
import org.mapstruct.Mapper
import org.mapstruct.Mapping


@Mapper
interface ProductMapper {


    @Mapping(target = "categoryId", ignore=true)
    fun convertToDTO(product: Product): ProductDTO
    @Mapping(target = "category", ignore = true)
    fun convertToEntity(product: ProductDTO): Product
    @Mapping(target = "categoryId", ignore =true)
    fun convertListToDTOList(products: List<Product>):List<ProductDTO>





}