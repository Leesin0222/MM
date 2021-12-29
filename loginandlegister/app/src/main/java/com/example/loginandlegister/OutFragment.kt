package com.example.loginandlegister

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.loginandlegister.databinding.FragmentHorrorBinding
import com.example.loginandlegister.databinding.FragmentOutBinding


class OutFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentOutBinding.inflate(inflater, container, false)

        binding.outbtn.setOnClickListener {
            startActivity((Intent(context, ProfileActivity::class.java)))

        }
        return binding.root
    }

}