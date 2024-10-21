package com.example.tablayout

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.tablayout.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var sharedPreferences: SharedPreferences

    companion object {
        // Metode newInstance untuk membuat instance baru dari LoginFragment
        fun newInstance(): LoginFragment {
            return LoginFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPreferences = requireActivity().getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)

        with(binding) {
            loginButton.setOnClickListener {
                val inputUsername = usernameEditText.text.toString()
                val inputPassword = passwordLoginText.text.toString()

                // Ambil data dari SharedPreferences
                val registeredUsername = sharedPreferences.getString("username", "")
                val registeredPassword = sharedPreferences.getString("password", "")

                if (inputUsername == registeredUsername && inputPassword == registeredPassword) {
                    val intent = Intent(requireActivity(), ThirdActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(requireContext(), "Invalid username or password", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
