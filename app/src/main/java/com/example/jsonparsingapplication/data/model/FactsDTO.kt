package com.example.jsonparsingapplication.data.model

import com.google.gson.annotations.SerializedName

data class FactsDTO(@SerializedName("title") var title : String,
                    @SerializedName("rows") var rowsDto : List<RowsDTO>)

data class RowsDTO(@SerializedName("title") var title : String,
                   @SerializedName("description") var description : String,
                   @SerializedName("imageHref")var imageUrl : String)