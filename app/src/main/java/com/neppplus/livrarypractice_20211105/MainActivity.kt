package com.neppplus.livrarypractice_20211105

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.normal.TedPermission
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setValues()
        setupEvents()
    }


    fun setupEvents(){

        btnCall.setOnClickListener() {
//        권한 획득
//            1)권한 여하에 /따른 사황별 대처방안 미리 변수에 담아두자

            val permissionListener = object : PermissionListener {
                override fun onPermissionGranted() {

//                    권한이 최종 획등 ok 일때 실행할 코드

                    val myUri = Uri.parse("tel:010-5555-6666")
                    val myIntent = Intent(Intent.ACTION_CALL,myUri)
                    startActivity(myIntent)
                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {

//                    최종 권한 거부 되었을 때
                    Toast.makeText(this@MainActivity,"권한이 거부되어 전화안됨",Toast.LENGTH_SHORT).show()

                }


            }

//            게획 수립은 완료. 실제로 권한이 있는지 물어보자.
            TedPermission.create()
                .setPermissionListener(permissionListener)
                .setPermissions( Manifest.permission.CALL_PHONE )
                .check()

        }

//        이미지뷰 / 텍스트뷰 / LinearLayout 등은 버튼처럼
        imgProfile.setOnClickListener() {

            val myIntent = Intent(this, ViewPhotoActivity::class.java)
            startActivity(myIntent)
        }

    }

   fun setValues() {

       Glide.with(this).load("https://images.chosun.com/resizer/HoGaPo0K-HNh_w9wmkUxpt404rc=/616x0/filters:focal(291x444:301x454)/cloudfront-ap-northeast-1.images.arcpublishing.com/chosun/XG2MW2H3ZRW5FHDVSOMF6FDT3E.jpg").into(imgAction)


   }


}