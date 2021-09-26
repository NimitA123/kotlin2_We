package com.example.wednesday_kotlin_we


import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class ResponseDTO(

	@field:SerializedName("data")
	val data: DataDTO? = null,

	@field:SerializedName("support")
	val support: SupportDTO? = null
)