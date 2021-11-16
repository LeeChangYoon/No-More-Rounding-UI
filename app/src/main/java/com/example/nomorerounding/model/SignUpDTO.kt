package com.example.nomorerounding.model

data class CarResponseDTO(
    var carNumber: String?,
    var pregnant: Boolean?,
    var compactCar: Boolean?,
    var electric: Boolean?,
    var disabled: Boolean?
)

data class TokenResponseDTO(
    var accessToken: String?,
    var refreshToken: String?
)

data class SignUpDTO(
    var name: String?,
    var birth: String?,
    var gender: String?,
    var email: String?,
    var CarResponse: CarResponseDTO?,
    var tokenResponse: TokenResponseDTO?
)