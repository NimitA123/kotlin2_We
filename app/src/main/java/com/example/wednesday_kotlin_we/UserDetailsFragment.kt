package com.example.wednesday_kotlin_we

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_user_details.*
import retrofit2.Response
import javax.security.auth.callback.Callback

import retrofit2.Call


class UserDetailsFragment : Fragment(R.layout.fragment_user_details) {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_details, container, false)
    }
/*enque function run in background thread and result will run in main thread*/
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         btnCallApi.setOnClickListener {
             callAPI()
         }
    }

    private fun callAPI() {
        var apiService = Network.getRetrofitInstance().create(ApiService::class.java)
        apiService.getUSer(2).enqueue(object : retrofit2.Callback<ResponseDTO>{
            override fun onResponse(call: Call<ResponseDTO>, response: Response<ResponseDTO>) {
               response.body()?.let {
                   tvFirstName.text = it.data?.firstName
                   tvLastName.text = it.data?.lastName
               }
            }

            override fun onFailure(call: Call<ResponseDTO>, t: Throwable) {

            }

        })
    }


    }
