package com.example.demo.entities

import java.util.*
import javax.persistence.*


@Entity
data class Product (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id :Long ,

    var productPrice : Double,
    var productName :String ,
    var productQuantity : Int,

    @Column(name = "created_at", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    var createdAt : Date? ,
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    var updatedAt : Date?,


    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    var category : Category?



)