package com.elliot.breakingbadapp.net.service

import com.elliot.breakingbadapp.models.Character
import com.elliot.breakingbadapp.models.Quote
import com.elliot.breakingbadapp.models.QuoteView
import retrofit2.Call
import retrofit2.http.*


interface BreakingBadService {
    @GET("characters")
    fun getCharacters() : Call<List<Character>>

    @GET("characters")
    fun getCharacterByName(@Query("name")name: String) : Call<Character>

    @GET("characters")
    fun getCharactersByCategory(@Query("category")category: String) : Call<List<Character>>

    @GET("quote")
    fun getQuotesByAuthor(@Query("author") author: String) : Call<List<Quote>>
}