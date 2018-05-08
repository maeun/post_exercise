package com.maeun.post_exercise

import com.maeun.post_exercise.post.PostBoardResponse
import okhttp3.RequestBody
import retrofit2.http.POST
import retrofit2.Call
import retrofit2.http.*

interface NetworkService {
    @POST("board")
    fun postBoard(
            @Part("user_id") id : RequestBody,
            @Part("board_title") title : RequestBody,
            @Part("board_content") content : RequestBody,
            @Part("board_pw") pw : RequestBody
    ) : Call<PostBoardResponse>
}