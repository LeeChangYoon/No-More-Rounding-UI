package com.example.nomorerounding.model

data class SignUpDTO(
    var name: String?,
    var birth: String?,
    var gender: String?,
    var email: String?,
    var CarResponse: CarResponseDTO?,
    var tokenResponse: TokenResponseDTO?
)