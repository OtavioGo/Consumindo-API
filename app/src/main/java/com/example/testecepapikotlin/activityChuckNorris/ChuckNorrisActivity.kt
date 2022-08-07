package com.example.testecepapikotlin.activityChuckNorris

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.testecepapikotlin.R
import com.example.testecepapikotlin.activityChoose.ChooseActivity
import com.example.testecepapikotlin.repository.Repository
import com.example.testecepapikotlin.viewModel.MainViewModel
import com.example.testecepapikotlin.viewModel.MainViewModelFactory
import kotlinx.android.synthetic.main.activity_chuck_norris.*

class ChuckNorrisActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chuck_norris)

        ib_back_chuck.setOnClickListener {
            intent = Intent(this, ChooseActivity::class.java)
            startActivity(intent)
        }

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        viewModel.getChuckNorris()
        viewModel.myResponse3.observe(this, Observer { response ->
            if (response.isSuccessful){
                Glide.with(this).load(response.body()?.icon_url).into(iv_chuck)
                tv_url.text = response.body()?.url
                tv_message.text = response.body()?.value
            } else {
                Toast.makeText(this, response.code(), Toast.LENGTH_SHORT).show()
            }
        })
    }
}