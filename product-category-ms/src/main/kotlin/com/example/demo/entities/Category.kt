package com.example.demo.entities


import javax.persistence.*

@Entity
class Category(


    var nameCategory:String?,
    var descCategory:String?
): BaseEntity(null){
    constructor() : this(null,null)
}