package com.example.demo.entities


import javax.persistence.*

@Entity
data class Category (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long,
    var nameCategory:String?
)