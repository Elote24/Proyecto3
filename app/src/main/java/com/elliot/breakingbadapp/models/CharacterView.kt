package com.elliot.breakingbadapp.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CharacterView (
    var name: String,
    var image: String,
    var birthday: String,
    var occupation: String,
    var nickname: String,
    var appearance: String,
    var portrayed:String
): Parcelable