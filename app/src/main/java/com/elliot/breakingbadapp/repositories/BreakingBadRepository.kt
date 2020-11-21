package com.elliot.breakingbadapp.repositories

import com.elliot.breakingbadapp.models.Character
import com.elliot.breakingbadapp.models.Quote
import com.elliot.breakingbadapp.net.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class BreakingBadRepository {

    suspend fun getCharacters() = suspendCoroutine<List<Character>> {
        RetrofitInstance.breakingBadService.getCharacters().enqueue(
            object : Callback<List<Character>> {
                override fun onResponse(
                    call: Call<List<Character>>,
                    response: Response<List<Character>>
                ) {
                    it.resume(response.body()!!)
                }

                override fun onFailure(call: Call<List<Character>>, t: Throwable) {
                    it.resumeWithException(t)
                }

            }
        )
    }

    suspend fun getCharacterByName(name: String) = suspendCoroutine<List<Character>> {
        RetrofitInstance.breakingBadService.getCharacterByName(name).enqueue(
            object : Callback<List<Character>> {
                override fun onResponse(call: Call<List<Character>>, response: Response<List<Character>>) {
                    it.resume(response.body()!!)
                }
                override fun onFailure(call: Call<List<Character>>, t: Throwable) {
                    it.resumeWithException(t)
                }
            }
        )
    }


    suspend fun getCharactersByCategory(category: String) = suspendCoroutine<List<Character>> {
        RetrofitInstance.breakingBadService.getCharactersByCategory(category).enqueue(
            object : Callback<List<Character>> {
                override fun onResponse(
                    call: Call<List<Character>>,
                    response: Response<List<Character>>
                ) {
                    it.resume(response.body()!!)
                }

                override fun onFailure(call: Call<List<Character>>, t: Throwable) {
                    it.resumeWithException(t)
                }
            }
        )
    }

    suspend fun getQuoteByAuthory(author:String) = suspendCoroutine<List<Quote>> {
        RetrofitInstance.breakingBadService.getQuotesByAuthor(author).enqueue(
            object: Callback<List<Quote>> {
                override fun onResponse(call: Call<List<Quote>>, response: Response<List<Quote>>) {
                    it.resume(response.body()!!)
                }

                override fun onFailure(call: Call<List<Quote>>, t: Throwable) {
                    it.resumeWithException(t)
                }
            }
        )
    }



}