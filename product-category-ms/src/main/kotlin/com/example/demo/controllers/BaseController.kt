package com.example.demo.controllers


interface BaseController<D>  {

    fun getOneById(id:Long): D;
    fun getAll(): List<D>;

    fun addOne(dto:D):D;
    fun updateOne(dto:D):D;
    fun deleteOne(id:Long):D;
}