package com.example.cw_m5

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.cw_m5.data.LoveModel
import com.example.cw_m5.data.RetrofitInstance
import com.example.cw_m5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(){
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val api = RetrofitInstance.api
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnCalculate.setOnClickListener {
            val firstName = binding.etFirstName.text.toString()
            val secondName = binding.etSecondName.text.toString()

            if (firstName.isEmpty() || secondName.isEmpty()) {
                Toast.makeText(this, "Please enter both names", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            api.getPercentage(
                firstName = binding.etFirstName.text.toString(),
                secondName = binding.etSecondName.text.toString(),
                key = "5fdbc29d4fmshd7cda0e70bb4935p154483jsnb1ff05c79dc2",
                host =  "love-calculator.p.rapidapi.com"
            ).enqueue(object : retrofit2.Callback<LoveModel> {
                override fun onResponse(call: retrofit2.Call<LoveModel>, response: retrofit2.Response<LoveModel>) {
                    if (response.isSuccessful && response.body() != null) {
                    val loveModel = response.body()!!
                    val intent = Intent(this@MainActivity, ResultActivity::class.java)
                        intent.putExtra("loveModel", loveModel)
                        startActivity(intent)
                    } else {
                        Log.e("MainActivity", "API Error: ${response.code()} ${response.message()}()}")
                        Toast.makeText(this@MainActivity, "Error: ${response.errorBody()?.string()}", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(p0: retrofit2.Call<LoveModel>, thr: Throwable) {
                    Log.e("MainActivity", "API Error: ${thr.message}", thr)
                    Toast.makeText(this@MainActivity, "Error: ${thr.message}" , Toast.LENGTH_SHORT).show()


                }

            })
            }

    }

        }