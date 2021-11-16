package com.example.nomorerounding.model

data class SignUpRequestDTO(
    var birth: String?,
    var carNumber: String,
    var compactCar: Boolean,
    var disabled: Boolean,
    var electric: Boolean,
    var email:	String,
    var gender:	String,
    var loginId: String,
    var name: String,
    var password: String,
    var pregnant: Boolean
)
