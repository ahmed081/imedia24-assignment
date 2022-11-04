package com.example.demo.dtos

import java.sql.Timestamp
import java.time.LocalDate

data class Currency (
    val id: Long? ,
    val success: Boolean?,
    val timestamp: Timestamp? ,
    val base: String? ,
    val date: LocalDate? ,
    val rates: Map<String, Double>?,
    val symbols: Map<String, String>?
)