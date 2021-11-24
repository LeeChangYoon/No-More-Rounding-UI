package com.example.nomorerounding

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RelativeLayout
import android.widget.Toast
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.nomorerounding.User.server
import com.example.nomorerounding.databinding.Pmc2Binding
import com.example.nomorerounding.databinding.Pmc5Binding
import com.example.nomorerounding.model.LotResponseDTO
import com.example.nomorerounding.model.UserResponseDTO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PMC5Activity : AppCompatActivity() {
    private var binding: Pmc5Binding? = null
    private var user: UserResponseDTO? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = Pmc5Binding.inflate(layoutInflater)  // 뷰바인딩
        val view: View = binding!!.root
        setContentView(view)

        Toast.makeText(this, "로그인에 성공했습니다!", Toast.LENGTH_LONG).show()

        val intent: Intent = intent
        user = intent.getParcelableExtra("user") // 로그인 유저 정보 받아오기

        if (user != null) { // 유저정보 있으면 출력
            setUserDock()
        }

        setParkingLot() // search 후 색깔 칠하는것까지 다 해주는거

    }

    private fun setUserDock() {
        binding?.userInfo?.text = user?.name.plus(" ".plus(user?.carResponse?.carNumber))

        if(user?.carResponse?.compactCar == true) {
            binding?.iconCompactCar?.setImageResource(R.drawable.ic_round_eco_25)
        }
        if(user?.carResponse?.electric == true) {
            binding?.iconElectric?.setImageResource(R.drawable.ic_round_electric_car_25)
        }
        if(user?.carResponse?.disabled == true) {
            binding?.iconDisabled?.setImageResource(R.drawable.ic_round_accessible_25)
        }
        if(user?.carResponse?.pregnant == true) {
            binding?.iconPregnant?.setImageResource(R.drawable.ic_round_pregnant_woman_25)
        }

        binding?.userParkingTime?.text = "-- : --"
        binding?.userParkingLocation?.text = "--"
    }

    private fun setParkingLot() {
        val callGetSearch = server.getParkingLot("1", PMC2Activity.prefs.token!!)
        callGetSearch.enqueue(object : Callback<LotResponseDTO> {
            override fun onResponse(
                call: Call<LotResponseDTO>,
                response: Response<LotResponseDTO>
            ) {
                if (response.isSuccessful) { // 성공하면
                    var map : LotResponseDTO? = response.body()

                    checkEmptySpace(map) // 여기서 map 분석해서 색깔 잘 칠해서 띄워주는 함수 실행

                } else {
                    when (response.code()) { // 미완벽 구현
                        400 -> onFailure(call, Throwable())
                        404 -> onFailure(call, Throwable())
                        500 -> onFailure(call, Throwable())
                    }
                }
            }

            override fun onFailure(call: Call<LotResponseDTO>, t: Throwable) {
                Log.d("lol", call.toString())
                Log.d("lol", t.toString())
            }
        })
    }


    private fun checkEmptySpace(map : LotResponseDTO?) {

        var relativeArray : ArrayList<RelativeLayout> = ArrayList()

        relativeArray.add(binding!!.a01)
        relativeArray.add(binding!!.a02)
        relativeArray.add(binding!!.a03)
        relativeArray.add(binding!!.a04)
        relativeArray.add(binding!!.a05)
        relativeArray.add(binding!!.a06)
        relativeArray.add(binding!!.b01)
        relativeArray.add(binding!!.b02)
        relativeArray.add(binding!!.b03)
        relativeArray.add(binding!!.b04)
        relativeArray.add(binding!!.b05)
        relativeArray.add(binding!!.b06)

        for (i in map?.spaceResponses!!){
            //Log.d("lol", i.toString())
                if (i.userId != user?.id) {
                    relativeArray[i.spaceColumn!!.times(6) + i.spaceRow!!].setBackground(
                        ContextCompat.getDrawable(this, R.drawable.x));
                }
                else{
                    relativeArray[i.spaceColumn!!.times(6) + i.spaceRow!!].setBackgroundColor(Color.parseColor("#FEBE49"))
                }
        }

        for (i in map?.specificSpaceResponses!!){
            Log.d("lol", i.toString())


        }

    }

    }