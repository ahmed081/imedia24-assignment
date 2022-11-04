package com.example.demo.entities

import java.util.*
import javax.persistence.*


@Entity
data class Product (

    var productPrice : Double?,
    var productName :String? ,
    var productQuantity : Int?,

    @Column(name = "created_at", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    var createdAt : Date? ,
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    var updatedAt : Date?,

    var currency: String?,
    var exchangeRate : Double?,
    var againstValue :Double?,

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    var category : Category?
) : BaseEntity(null){
    constructor(): this(null,null,null,null,null,null,null,null,null)
}