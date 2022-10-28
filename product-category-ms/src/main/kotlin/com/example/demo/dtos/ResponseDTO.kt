package com.example.demo.dtos

class ResponseDTO(status:Boolean, data: Any?, message:String) {
    private var status:Boolean = status
        get() = field
        set(status) {
            field = status
        }

    private var data : Any? = data
        get() = field
        set(data) {
            field = data
        }
    private var message : String = message
        get() = field
        set(message) {
            field = message
        }



}