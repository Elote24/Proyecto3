package com.elliot.breakingbadapp.repositories

import com.elliot.breakingbadapp.models.Character
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
            object: Callback<List<Character>> {
                override fun onResponse(call: Call<List<Character>>, response: Response<List<Character>>) {
                    it.resume(response.body()!!)
                }

                override fun onFailure(call: Call<List<Character>>, t: Throwable) {
                    it.resumeWithException(t)
                }

            }
        )
    }

    suspend fun getCharacterByName(name: String) = suspendCoroutine<Character> {
        RetrofitInstance.breakingBadService.getCharacterByName(name).enqueue(
            object: Callback<Character> {
                override fun onResponse(call: Call<Character>, response: Response<Character>) {
                    it.resume(response.body()!!)
                }

                override fun onFailure(call: Call<Character>, t: Throwable) {
                    it.resumeWithException(t)
                }

            }
        )
    }
}