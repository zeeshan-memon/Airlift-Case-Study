package com.example.airliftcasestudy.data.model.response

data class BaseDataModel (
    var total : Int,
    var totalHits : Int,
    var hits: List<Hits>

)

data class Hits(
    var id: Int,
    var pageURL: String,
    var views: String,
    var type: String,
    var tags: String,
    var previewURL: String,
    var previewWidth: Int,
    var previewHeight: Int,
    var webformatURL: String,
    var webformatWidth: Int,
    var webformatHeight: Int,
)
