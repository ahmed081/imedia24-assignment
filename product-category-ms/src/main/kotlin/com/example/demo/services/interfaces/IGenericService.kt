package com.example.demo.services.interfaces

interface IGenericService<T> {

    fun getOneById(id:Long): T;
    fun getAll(): List<T>;

    fun addOne(dto:T):T;
    fun updateOne(dto:T):T;
    fun deleteOne(id:Long):T;

}