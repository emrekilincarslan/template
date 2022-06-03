package com.scalefocus.base_service.common

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class IntValue(
    @SerializedName("value")
    @Expose
    val value: Int?
)