package com.example.cw_m5

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cw_m5.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), CounterContract {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val presenter = CounterPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        presenter.attachContract(this)

        binding.apply {
            btnIncrement.setOnClickListener {
                presenter.onIncrement()}

            btnDecrement.setOnClickListener {
                presenter.onDecrement()
            }
        }
    }


    override fun showCount(count: String) {
        binding.tvCount.text = count
    }

    override fun showCongratulations() {
        Toast.makeText(this, "Поздравляем!", Toast.LENGTH_SHORT).show()
    }

    override fun setGreenTextColor() {
        binding.tvCount.setTextColor(Color.GREEN)
    }

    override fun resetTextColor() {
        binding.tvCount.setTextColor(Color.BLACK)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachContract()
    }
}