package com.example.demo.services.interfaces

interface IGenericService<T> {

    fun getOneById(id:Long): T;
    fun getAll(): List<T>;
}