package com.example.cw_m5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cw_m5.data.LoveModel
import com.example.cw_m5.databinding.ActivityResultBinding

class ResultActivity: AppCompatActivity() {
    val binding by lazy { ActivityResultBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val loveModel = intent.getParcelableExtra <LoveModel> ("loveModel")
        if (loveModel != null) {
            binding.firstname.text = loveModel.firstName
            binding.secondname.text = loveModel.secondName
            binding.tvPercent.text = loveModel.percentage
            binding.tvScore.text = loveModel.result
            binding.tryAgain.setOnClickListener {
                finish()
            }
        }
    }
}