package org.weatherook.weatherook.api.network

import io.reactivex.Observable
import org.weatherook.weatherook.api.model.*
import org.weatherook.weatherook.item.UserSettingUpdateData
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
    @FormUrlEncoded
    @POST("/auth")
    fun postSignup(@Field("user_id") id : String, @Field("user_pw") pw : String,
    @Field("user_age")age :Int, @Field("user_gender") gender : String, @Field("user_height") height: Int,
                   @Field("user_weight") weight : Int,@Field("user_stylelist")list:ArrayList<String>) : Observable<SignupModel>

    //로그인
    @FormUrlEncoded
    @POST("/auth/signin")
    fun postSignin(@Field("user_id") id : String, @Field("user_pw") pw : String) : Observable<SigninModel>

    //어제, 오늘, 내일 날씨
    @FormUrlEncoded
    @POST("/weather")
    fun postWeather(@Field("x") x : Double, @Field("y") y : Double, @Field("date_type") date : Int) : Observable<WeatherModel>

    // 3시간 단위 날씨
    @FormUrlEncoded
    @POST("/weather/list")
    fun postTimeWeather(@Field("x") x : Float, @Field("y") y : Float) : Observable<WeatherTimeModel>

    //갬성글
    @FormUrlEncoded
    @POST("/weather/comment")
    fun postTempWeather(@Field("weather_temp") temp : Int, @Field("weather_weather") weather : Int) : Observable<WeatherCommentModel>

    @FormUrlEncoded
    @POST("/board/comment")
    fun postComment(@Field("board_idx") idx : Int, @Field("comment_desc") comment : String) : Observable<BoardCommentModel>

    //마이페이지 정보 다 불러오기
    @FormUrlEncoded
    @POST("/user/show")
    fun getMyBoard(@Header("token") token:String, @Field("other_id") otherid : String?) : Observable<MyBoardModel>

    @FormUrlEncoded
    @POST("/board/commend")
    fun postRecommend(@Header("token") token:String? , @Field("x") lat:Float, @Field("y") long:Float,@Field("date_type") date:Int) : Observable<RecommendModel>

    //게시글 댓글 달기
    @FormUrlEncoded
    @POST("/board/comment")
    fun postcomment(@Header("token") token:String? , @Field("board_idx") idx : Int, @Field("comment_desc") comment : String ) : Observable<PostCommentModel>

    //오늘의 게시물 필터링
    @FormUrlEncoded
    @POST("/board/today/filter")
    fun postTodayFilter(@Field("gender") gender : String, @Field("height") height: Int,@Field("size") size : String,@Field("stylelist") stylelist : ArrayList<String>)

    //메인 최신순
    @GET("/board/today/latest")
    fun getLatestBoard() : Observable<LatestBoardModel>

    //메인 인기순
    @GET("/board/today/popular")
    fun getPopularBoard() : Observable<PopularBoardModel>

    //메인 팔로잉하는 글 보기
    @GET("/board/follow")
    fun postFollowBoard(@Header("token") token: String) : Observable<FollowBoardModel>

    //한 게시물 댓글보기
    @GET("/board/comment/{board_idx}")
    fun getOneBoardComment(@Header("token") token:String, @Path("board_idx") idx : Int) : Observable<GetCommentModel>

    @GET("/user/follower")
    fun getMyFollowerProfile(@Header("token") token:String) : Observable<FollowerModel>

    @GET("/user/following")
    fun getMyFollowingProfile(@Header("token") token:String) : Observable<FollowingModel>

    @GET("/user/news")
    fun getBell(@Header("token")token: String) : Observable<BellModel>

    @GET("/user/setting")
    fun getUserSetting(@Header("token") token:String) : Observable<UserSettingModel>

    @PUT("/user/setting")
    fun putUserSetting(@Header("token") token:String, @Body updateData : UserSettingUpdateData): Observable<UserSettingUpdateModel>


}