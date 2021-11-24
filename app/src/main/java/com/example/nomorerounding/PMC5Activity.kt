package com.example.nomorerounding

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.nomorerounding.databinding.Pmc4Binding
import com.example.nomorerounding.databinding.Pmc5Binding
import com.example.nomorerounding.model.UserResponseDTO

class PMC5Activity : AppCompatActivity() {
    private var binding: Pmc5Binding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = Pmc5Binding.inflate(layoutInflater)  // 뷰바인딩
        val view: View = binding!!.root
        setContentView(view)

        Toast.makeText(this, "로그인에 성공했습니다!", Toast.LENGTH_LONG).show()

        val intent: Intent = intent
        var user: UserResponseDTO? = intent.getParcelableExtra("user") // 로그인 유저 정보 받아오기

        if (user != null) { // 유저정보 있으면 출력
            setUserDock(user)
        }

        // 최초에 search 해줘야 함

    }

    private fun setUserDock(user: UserResponseDTO) {
        binding?.userInfo?.text = user.name.plus(" ".plus(user.carResponse?.carNumber))

        if(user.carResponse?.compactCar == true) {
            binding?.iconCompactCar?.setImageResource(R.drawable.ic_round_eco_25)
        }
        if(user.carResponse?.electric == true) {
            binding?.iconElectric?.setImageResource(R.drawable.ic_round_electric_car_25)
        }
        if(user.carResponse?.disabled == true) {
            binding?.iconDisabled?.setImageResource(R.drawable.ic_round_accessible_25)
        }
        if(user.carResponse?.pregnant == true) {
            binding?.iconPregnant?.setImageResource(R.drawable.ic_round_pregnant_woman_25)
        }

        binding?.userParkingTime?.text = "-- : --"
        binding?.userParkingLocation?.text = "--"
    }

    private fun setParkingLot() {

    }
}