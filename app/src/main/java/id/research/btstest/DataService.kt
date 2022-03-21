package id.research.btstest

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.POST

interface DataService {

    @POST("api/login")
    fun login(
        @Field("password") password: String,
        @Field("username") username: String
    ): Call<LoginResponse>

    @POST("api/register")
    fun register(
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("username") username: String
    ): Call<RegisterResponse>

}