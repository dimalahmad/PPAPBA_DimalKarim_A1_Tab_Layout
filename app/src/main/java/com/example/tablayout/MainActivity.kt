package com.example.tablayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tablayout.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewPagerAdapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewPagerAdapter = ViewPagerAdapter(this)
        binding.viewPager.adapter = viewPagerAdapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Register"
                1 -> "Login"
                else -> null
            }
        }.attach()

        // Cek jika perlu berpindah ke tab login
        if (intent.getBooleanExtra("switchToLoginTab", false)) {
            switchToLoginTab()
        }
    }

    fun updateLoginFragmentData(username: String, password: String) {
        viewPagerAdapter.updateLoginFragmentData(username, password)
    }

    fun switchToLoginTab() {
        binding.viewPager.currentItem = 1
    }
}
