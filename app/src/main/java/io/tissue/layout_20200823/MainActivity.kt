package io.tissue.layout_20200823

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val REQ_FOR_NICKNAME = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        changeNickNameBtn.setOnClickListener {
            val myIntent = Intent(this, EditNickName::class.java)

            startActivityForResult(myIntent, REQ_FOR_NICKNAME)
        }
    }

    // 다른 액티비티에서 결과를 받아서 돌아온다.
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQ_FOR_NICKNAME) {
            if (resultCode == Activity.RESULT_OK) {
				val nickName = data?.getStringExtra("nickName")

                nickname.text = nickName
            }
        }

    }

}