package com.example.testecepapikotlin.activityCEP

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.testecepapikotlin.activityChoose.ChooseActivity
import com.example.testecepapikotlin.viewModel.MainViewModel
import com.example.testecepapikotlin.viewModel.MainViewModelFactory
import com.example.testecepapikotlin.R
import com.example.testecepapikotlin.repository.Repository
import kotlinx.android.synthetic.main.activity_cep.*

class CepActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cep)

        ib_back.setOnClickListener {
            intent = Intent(this, ChooseActivity::class.java)
            startActivity(intent)
        }

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        bt_confirm.setOnClickListener {
        val myNumber = et_cep.text.toString()
        viewModel.getNumberCEP(myNumber)
        viewModel.myResponse.observe(this, Observer { response ->
            if (response.isSuccessful){
                tv_cep.text = "CEP : " + response.body()?.cep!!
                tv_logradouro.text = "Logradouro : " + response.body()?.logradouro!!
                tv_complemento.text = "Complemento : " + response.body()?.complemento!!
                tv_bairro.text = "Bairro : " + response.body()?.bairro!!
                tv_localidade.text = "Localidade : " + response.body()?.localidade!!
                tv_uf.text = "UF : " + response.body()?.uf!!
                tv_ibge.text = "IBGE : " + response.body()?.ibge!!
                tv_gia.text = "GIA : " + response.body()?.gia!!
                tv_ddd.text = "DDD : " + response.body()?.ddd!!
                tv_siafi.text = "Siafi : " + response.body()?.siafi!!
            } else {
                Log.d("Response", response.errorBody().toString())
                tv_error.text = "ERROR : " + response.code().toString()
            }
        })
        }
    }
}
