package com.neppplus.livrarypractice_20211105

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setValues()
        setupEvents()
    }


    fun setupEvents(){

//        이미지뷰 / 텍스트뷰 / LinearLayout 등은 버튼처럼
        imgProfile.setOnClickListener() {

            val myIntent = Intent(this, ViewPhotoActivity::class.java)
            startActivity(myIntent)
        }

    }

   fun setValues() {

   }


}