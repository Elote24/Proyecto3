package com.elliot.breakingbadapp.net

import com.elliot.breakingbadapp.BASE_URL
import com.elliot.breakingbadapp.net.service.BreakingBadService
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitInstance {

    companion object {
        @JvmStatic
        private val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        @JvmStatic
        public val breakingBadService = retrofit.create(BreakingBadService::class.java)
    }

}