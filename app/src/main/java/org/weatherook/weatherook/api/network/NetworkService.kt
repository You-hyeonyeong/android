package org.weatherook.weatherook.api.network

import io.reactivex.Observable
import org.weatherook.weatherook.api.model.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*


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
    @FormUrlEncoded
    @POST("/auth/signin")
    fun postSignin(@Field("user_id") id : String, @Field("user_pw") pw : String) : Observable<SigninModel>

    @FormUrlEncoded
    @POST("/weather/comment")
    fun postTempWeather(@Field("weather_temp") temp : Int, @Field("weather_weather") weather : Int) : Observable<WeatherCommentModel>

    @FormUrlEncoded
    @POST("/board/comment")
    fun postComment(@Field("board_idx") idx : Int, @Field("comment_desc") comment : String) : Observable<BoardCommentModel>

    @GET("/board/today/latest")
    fun getLatestBoard() : Observable<LatestBoardModel>

    @GET("/board/today/popular")
    fun getPopularBoard() : Observable<PopularBoardModel>

    @GET("/board/comment/{board_idx}")
    fun getOneBoardComment(@Path("board_idx") idx : Int) : Observable<GetCommentModel>

    @GET("/board/follow")
    fun postFollowBoard(@Header("token") token: String) : Observable<FollowBoardModel>

    @POST("/user/show")
    fun getMyBoard(@Header("token") token:String) : Observable<MyBoardModel>

    @GET("/user/follower")
    fun getMyFollowerProfile(@Header("token") token:String) : Observable<FollowerModel>

    @GET("/user/following")
    fun getMyFollowingProfile(@Header("token") token:String) : Observable<FollowingModel>

    @POST("/board/commend")
    fun postRecommend(@Header("token") token:String , @Field("x") lat:Int, @Field("y") long:Int,@Field("date_type") date:Int) : Observable<RecommendModel>

}