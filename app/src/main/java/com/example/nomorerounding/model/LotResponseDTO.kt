package com.example.nomorerounding.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LotResponseDTO(
    var floor: String?,
    var lotColumn: Int?,
    var lotRow: Int?,
    var spaceResponses: SpaceResponseDTO?,
    var specificSpaceResponses: SpecificSpaceResponseDTO?
) : Parcelable