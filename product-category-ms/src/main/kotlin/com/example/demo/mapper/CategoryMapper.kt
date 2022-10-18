package com.example.demo.mapper

import com.example.demo.dtos.CategoryDTO
import com.example.demo.entities.Category
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers


@Mapper
interface CategoryMapper {

    val converter: CategoryMapper
        get() = Mappers.getMapper(CategoryMapper::class.java)

    fun convertToDTO(category: Category): CategoryDTO



}