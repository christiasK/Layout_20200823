package io.tissue.layout_20200823

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_edit_nick_name2.*

class EditNickName : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_nick_name2)

        okBtn.setOnClickListener {

            val nickName = nickname.text.toString()

            val resultIndent = Intent()

            resultIndent.putExtra("nickName", nickName)

            setResult(Activity.RESULT_OK, resultIndent)

            finish()
        }
    }
}