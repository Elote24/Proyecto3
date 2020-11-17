package com.elliot.breakingbadapp.net.service

import com.elliot.breakingbadapp.models.Character
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url


interface BreakingBadService {
    @GET("characters")
    fun getCharacters() : Call<List<Character>>

    @GET("characters/{name}")
    fun getCharacterByName(@Path("name")name: String) : Call<Character>
}