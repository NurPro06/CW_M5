package com.example.cw_m5

import android.os.Bundle
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
                presenter.onIncrement()
            }
            btnDecrement.setOnClickListener {
                presenter.onDecrement()
            }
        }
    }


    override fun showCount(count: String) {
        binding.tvCount.text = count
    }
    override fun onDestroy() {
        super.onDestroy()
        presenter.detachContract()

    }
}