package com.example.testecepapikotlin.activityChoose

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testecepapikotlin.activityAdvice.ActivityAdvice
import com.example.testecepapikotlin.activityCEP.CepActivity
import com.example.testecepapikotlin.R
import com.example.testecepapikotlin.activityChuckNorris.ChuckNorrisActivity
import kotlinx.android.synthetic.main.activity_choose.*

class ChooseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose)

        bt_consult_cep.setOnClickListener {
            intent = Intent(this,CepActivity::class.java)
            startActivity(intent)
        }

        bt_advice.setOnClickListener {
            intent = Intent(this, ActivityAdvice::class.java)
            startActivity(intent)
        }

        bt_chuck_norris.setOnClickListener {
            intent = Intent(this, ChuckNorrisActivity::class.java)
            startActivity(intent)
        }
    }
}
