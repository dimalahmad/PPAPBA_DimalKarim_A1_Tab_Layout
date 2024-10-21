package com.example.tablayout

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tablayout.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {


    private lateinit var binding: FragmentRegisterBinding

    companion object {
        fun newInstance(): RegisterFragment {
            return RegisterFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            registerButton.setOnClickListener {
                val username = usernameEditText.text.toString()
                val password = passwordEditText.text.toString()
                val email = emailEditText.text.toString()
                val phone = phoneEditText.text.toString()

                // Simpan data ke SharedPreferences
                val sharedPreferences = requireActivity().getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
                sharedPreferences.edit().apply {
                    putString("username", username)
                    putString("password", password)
                    putString("email", email)
                    putString("phone", phone)
                    apply()
                }

                // Update data login di MainActivity
                (activity as MainActivity).updateLoginFragmentData(username, password)

                // Beralih ke tab Login
                (activity as MainActivity).switchToLoginTab()
            }
        }
    }
}
