package com.example.demo.mapper

import com.example.demo.entities.BaseEntity

interface IMapper <DTO, Entity:BaseEntity>{

    /**
     * @author Ahmed EL ASSIMI
     * @param entity
     * @return DTO
     */
    fun toDTO(entity :Entity?): DTO?

    /**
     * @author Ahmed EL ASSIMI
     * @param entities
     * @return List<DTO>
     */
    fun toListDTO(entities: List<Entity>): List<DTO>

    /**
     * @author Ahmed EL ASSIMI
     * @param dto
     * @return Entity
     */
    fun toEntity(dto :DTO?): Entity?


}