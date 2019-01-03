package com.example.nuriaperalta.kotlinstart3.Client.Model

data class Beer (val videos: List<Videos>)
data class Videos (val name: String, val imageUrl : String)