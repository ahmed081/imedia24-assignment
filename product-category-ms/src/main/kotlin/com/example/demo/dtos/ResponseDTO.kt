package com.example.demo.dtos

data class ResponseDTO<DTO>(
    var status:Boolean?,
    var data : DTO?,
    var list: List<DTO>?,
    var message : String?,
)