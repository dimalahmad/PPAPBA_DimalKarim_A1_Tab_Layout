package com.example.tablayout

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    private var registeredUsername: String? = null
    private var registeredPassword: String? = null

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> RegisterFragment.newInstance()
            1 -> LoginFragment.newInstance()
            else -> RegisterFragment.newInstance()// Default case
        }
    }

    fun updateLoginFragmentData(username: String, password: String) {
        registeredUsername = username
        registeredPassword = password
        notifyItemChanged(0)
    }
}
