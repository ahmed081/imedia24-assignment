package com.example.demo.entities

import lombok.Data
import lombok.NoArgsConstructor
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Data
@Entity
@NoArgsConstructor
class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long = 0L;

    var nameCategory:String? = null;



}