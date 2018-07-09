package org.weatherook.weatherook.api.network

import io.reactivex.Observable
import org.weatherook.weatherook.api.model.SigninModel
import org.weatherook.weatherook.api.model.SignupModel
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.GET



interface NetworkService {

    companion object {
        fun create(): NetworkService {

            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("http://52.78.105.130:3004/")
                    .build()

            return retrofit.create(NetworkService::class.java)
        }
    }
    //회원가입
    @POST("/auth")
    fun postSignup(@Body idpw: SignupModel) : Observable<SignupModel>


    //로그인
    @POST("/auth/signin")
    fun postSignin(@Body user : SigninModel) : Observable<SigninModel>
}