package com.example.youtubeapi.model

import android.content.ClipData
import android.graphics.pdf.PdfDocument

data class Playlists(
    val kind: String? = null,
    val items: List<Item>,
)
class Snippet (
    val channelId: String,
    val channelTitle: String,
    val description: String,
    val localized: Localized,
    val publishedAt: String,
    val thumbnails: Thumbnails,
    val title: String
)


data class PageInfo(
    val resultsPerPage: Int,
    val totalResults: Int
)

data class Localized (
    val description: String,
    val title: String
)

data class Item(
    val contentDetails: ContentDetails,
    val etag: String,
    val id: String,
    val kind: String,
    val snippet: Snippet
)

data class Default(
    val height: Int,
    val url: String,
    val width: Int
)

class ContentDetails (
    val itemCount: Int
)

data class High(
    val height: Int,
    val url: String,
    val width: Int
)

data class Maxres(
    val height: Int,
    val url: String,
    val width: Int
)

data class Medium(
    val height: Int,
    val url: String,
    val width: Int
)
data class Playlist(
    val etag: String,
    val items: List<Item>,
    val kind: String,
    val nextPageToken: String,
    val pageInfo: PdfDocument.PageInfo
)

data class Standard(
    val height: Int,
    val url: String,
    val width: Int
)

data class Thumbnails(
    val default: Default,
    val high: High,
    val maxres: Maxres,
    val medium: Medium,
    val standard: Standard
)

data class test(
    val etag: String,
    val items: List<Item>,
    val kind: String,
    val nextPageToken: String,
    val pageInfo: PageInfo
)