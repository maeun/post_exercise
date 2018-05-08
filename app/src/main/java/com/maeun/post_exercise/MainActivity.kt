package com.maeun.post_exercise

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import com.maeun.post_exercise.post.PostBoardResponse
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.MediaType
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var networkService: NetworkService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        networkService = ApplicationController.instance.networkSerVice

        send.setOnClickListener{
            val id = RequestBody.create(MediaType.parse("text/plain"),main_id.text.toString())
            val title = RequestBody.create(MediaType.parse("text/plain"),main_title.text.toString())
            val content = RequestBody.create(MediaType.parse("text/plain"),main_content.text.toString())
            val pw = RequestBody.create(MediaType.parse("text/plain"),main_pw.text.toString())
            val postBoardResponse = networkService.postBoard(id,title,content,pw)
            postBoardResponse.enqueue(object : Callback<PostBoardResponse>{
                override fun onFailure(call: Call<PostBoardResponse>?, t: Throwable?) {
                    Toast.makeText(applicationContext,"fail",Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(call: Call<PostBoardResponse>?, response: Response<PostBoardResponse>?) {
                    if(response!!.isSuccessful){
                        Toast.makeText(applicationContext,"sent",Toast.LENGTH_SHORT).show()
                    }
                }


        })
    }
}}
