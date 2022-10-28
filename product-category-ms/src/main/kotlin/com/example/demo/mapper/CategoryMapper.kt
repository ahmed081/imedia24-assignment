package com.example.demo.mapper

import com.example.demo.dtos.CategoryDTO
import com.example.demo.entities.Category
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers
import org.springframework.stereotype.Component


@Mapper
@Component
interface CategoryMapper {

    fun convertToDTO(category: Category): CategoryDTO
    fun convertToEntity(category: CategoryDTO): Category
    fun convertListToDTOList(categories: List<Category>):List<CategoryDTO>



}