package com.example.demo.controllers

import com.example.demo.dtos.ResponseDTO
import org.springframework.http.ResponseEntity


interface IBaseController<DAO>  {

    /**
     * to get element by it id
     * @author Ahmed EL ASSIMI
     * @param id
     * @return  T
     */
    fun getOneById(id:Long): ResponseEntity<ResponseDTO<DAO>>;

    /**
     * to get all element
     * @author Ahmed EL ASSIMI
     * @return  List<T>
     */
    fun getAll():  ResponseEntity<ResponseDTO<DAO>>;

    /**
     * to add one element
     * @author Ahmed EL ASSIMI
     * @param dto
     * @return  T
     */
    fun addOne(dto:DAO): ResponseEntity<ResponseDTO<DAO>>;

    /**
     * to update an element
     * @author Ahmed EL ASSIMI
     * @param dto
     * @param id
     * @return  T
     */
    fun updateOne(dto:DAO,id: Long): ResponseEntity<ResponseDTO<DAO>>;

    /**
     * to delete an element
     * @author Ahmed EL ASSIMI
     * @param id
     * @return  T
     */
    fun deleteOne(id:Long): ResponseEntity<ResponseDTO<DAO>>;
}