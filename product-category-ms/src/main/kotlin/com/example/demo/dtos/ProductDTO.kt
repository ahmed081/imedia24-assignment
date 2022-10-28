package com.example.demo.dtos

import com.example.demo.entities.Category

data class ProductDTO (
    var id:Long,
    var productPrice : Double ,
    var productName :String ,
    var productQuantity : Int ,
    var categoryId : Long?
)