package id.research.btstest

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    fun apiRequest(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://94.74.86.174:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}