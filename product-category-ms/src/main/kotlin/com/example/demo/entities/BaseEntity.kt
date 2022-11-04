package com.example.demo.entities

import javax.persistence.*

@MappedSuperclass
open class BaseEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long?
){
    constructor() : this(null)
}