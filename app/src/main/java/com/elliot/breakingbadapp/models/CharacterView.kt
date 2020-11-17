package com.elliot.breakingbadapp.models

data class CharacterView (
    var image: String,
    var name: String,
    var birthday: String,
    var occupation: List<String>,
    var status: String,
    var nickname: String,
    var appearance:List<String>,
    var portrayed: String,
    var category:List<String>
)