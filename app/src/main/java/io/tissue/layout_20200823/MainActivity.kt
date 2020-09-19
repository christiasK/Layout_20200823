package io.tissue.layout_20200823

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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

        dial.setOnClickListener {
            val indent = Intent(Intent.ACTION_DIAL, getUri())

            startActivity(indent)
        }

        call.setOnClickListener {
            // 사용자의 요금제를 사용하는 경우 Permission으로 막히기 때문에
            // 별도 권한 획득이 필요함
            val indent = Intent(Intent.ACTION_CALL, getUri())

            startActivity(indent)
        }


        sms.setOnClickListener {
            val cellPhoneNumber = cellPhoneNumber.text.toString()

            val uri = Uri.parse("smsto:${cellPhoneNumber}")

            val indent = Intent(Intent.ACTION_SENDTO, uri)

            // 문자의 내용을 정해서 전달하기
            indent.putExtra("sms_body", "[공유] 이 앱을 공유해주세요~")

            startActivity(indent)
        }

        internet.setOnClickListener {
            val uri = Uri.parse("https://naver.com")

            val indent = Intent(Intent.ACTION_VIEW, uri)

            startActivity(indent)
        }

        playstore.setOnClickListener {
            val uri = Uri.parse("market://details?id=com.nhn.android.search")

            val indent = Intent(Intent.ACTION_VIEW, uri)

            startActivity(indent)
        }

    }

    private fun getUri(): Uri? {
        val cellPhoneNumber = cellPhoneNumber.text.toString()

        return Uri.parse("tel:${cellPhoneNumber}")
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