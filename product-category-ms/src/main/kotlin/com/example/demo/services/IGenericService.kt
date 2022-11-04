package com.example.demo.services

interface IGenericService<T> {

    /**
     * to get element by it id
     * @author Ahmed EL ASSIMI
     * @param id
     * @return  T
     */
    fun getOneById(id:Long): T;

    /**
     * to get all element
     * @author Ahmed EL ASSIMI
     * @return  List<T>
     */
    fun getAll(): List<T>;

    /**
     * to add one element
     * @author Ahmed EL ASSIMI
     * @param dto
     * @return  T
     */
    fun addOne(dto:T):T;

    /**
     * to update an element
     * @author Ahmed EL ASSIMI
     * @param dto
     * @param id
     * @return  T
     */
    fun updateOne(dto:T,  id:Long):T;

    /**
     * to delete an element
     * @author Ahmed EL ASSIMI
     * @param id
     * @return  T
     */
    fun deleteOne(id:Long):T;

}