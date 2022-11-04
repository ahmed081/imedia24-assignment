package com.example.demo.controllers


interface IBaseController<DAO>  {

    /**
     * to get element by it id
     * @author Ahmed EL ASSIMI
     * @param id
     * @return  T
     */
    fun getOneById(id:Long): DAO;

    /**
     * to get all element
     * @author Ahmed EL ASSIMI
     * @return  List<T>
     */
    fun getAll(): List<DAO>;

    /**
     * to add one element
     * @author Ahmed EL ASSIMI
     * @param dto
     * @return  T
     */
    fun addOne(dto:DAO):DAO;

    /**
     * to update an element
     * @author Ahmed EL ASSIMI
     * @param dto
     * @param id
     * @return  T
     */
    fun updateOne(dto:DAO,id: Long):DAO;

    /**
     * to delete an element
     * @author Ahmed EL ASSIMI
     * @param id
     * @return  T
     */
    fun deleteOne(id:Long):DAO;
}