package com.guardian.model.news

import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName

data class GuardianNewsDto(
    @SerializedName("response")
    val response: NewsResponseDto?
)

data class NewsResponseDto(
    @SerializedName("currentPage")
    val currentPage: Int?,
    @SerializedName("orderBy")
    val orderBy: String?,
    @SerializedName("pageSize")
    val pageSize: Int?,
    @SerializedName("pages")
    val pages: Int?,
    @SerializedName("results")
    val results: List<NewsResultDto>?,
    @SerializedName("startIndex")
    val startIndex: Int?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("total")
    val total: Int?,
    @SerializedName("userTier")
    val userTier: String?
)

data class NewsResultDto(

    @SerializedName("apiUrl")
    @ColumnInfo
    val apiUrl: String?,

    @SerializedName("id")
    @ColumnInfo
    val id: String?,

    @SerializedName("isHosted")
    @ColumnInfo
    val isHosted: Boolean?,

    @SerializedName("pillarId")
    @ColumnInfo
    val pillarId: String?,

    @SerializedName("pillarName")
    @ColumnInfo
    val pillarName: String?,

    @SerializedName("sectionId")
    @ColumnInfo
    val sectionId: String?,

    @SerializedName("sectionName")
    @ColumnInfo
    val sectionName: String?,

    @SerializedName("type")
    @ColumnInfo
    val type: String?,

    @SerializedName("webPublicationDate")
    @ColumnInfo
    val webPublicationDate: String?,

    @SerializedName("webTitle")
    @ColumnInfo
    val webTitle: String?,

    @SerializedName("webUrl")
    @ColumnInfo
    val webUrl: String?
)