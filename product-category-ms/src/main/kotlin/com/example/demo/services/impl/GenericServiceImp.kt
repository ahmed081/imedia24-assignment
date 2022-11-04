package com.example.demo.services.impl

import com.example.demo.entities.BaseEntity
import com.example.demo.mapper.IMapper
import com.example.demo.services.IGenericService
import org.springframework.data.jpa.repository.JpaRepository

open class GenericServiceImp<DTO,Entity:BaseEntity, Repository:JpaRepository<Entity, Long> , Mapper : IMapper<DTO,Entity>>(
    var repository: Repository,
    var mapper: Mapper

    ) : IGenericService<DTO> {




    override fun getOneById(id: Long): DTO {

        val product: Entity = repository.getOne(id)
        return mapper.toDTO(product)!!
    }

    override fun getAll(): List<DTO> {
        val products : MutableList<Entity> = repository.findAll();

        return mapper.toListDTO(products)
    }

    override fun addOne(dto: DTO): DTO {
        return mapper.toDTO(repository.save(mapper.toEntity(dto)!!))!!
    }

    override fun updateOne(dto: DTO,  id:Long): DTO {
        val entity : Entity? = mapper.toEntity(dto)
        entity?.id = id
        return mapper.toDTO(repository.save(entity!!))!!
    }

    override fun deleteOne(id: Long): DTO {
        val entity: Entity = repository.getOne(id)
        repository.delete(entity)
        return  mapper.toDTO(entity)!!
    }

}