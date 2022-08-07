package com.example.testecepapikotlin.activityAdvice

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.testecepapikotlin.R
import com.example.testecepapikotlin.activityChoose.ChooseActivity
import com.example.testecepapikotlin.repository.Repository
import com.example.testecepapikotlin.viewModel.MainViewModel
import com.example.testecepapikotlin.viewModel.MainViewModelFactory
import kotlinx.android.synthetic.main.activity_advice.*

class ActivityAdvice : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_advice)

        ib_back_advice.setOnClickListener {
            intent = Intent(this, ChooseActivity::class.java)
            startActivity(intent)
        }

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        viewModel.getAdvice()
        viewModel.myResponse2.observe(this, Observer { response ->
            if (response.isSuccessful) {
                tv_advice.text = response.body()?.slip?.advice
            } else {
                Toast.makeText(this, response.code(), Toast.LENGTH_SHORT).show()
            }
        })
    }
}