package com.example.lab22

import com.google.gson.annotations.SerializedName

data class Celebrity(
    val name: String,
    @SerializedName("net_worth")
    val netWorth: Long,
    val gender: String,
    val nationality: String,
    @SerializedName("height")
    val height: Double
)
