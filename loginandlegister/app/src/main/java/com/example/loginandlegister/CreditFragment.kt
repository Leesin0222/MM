package com.example.loginandlegister

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.loginandlegister.databinding.FragmentCreditBinding


class CreditFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentCreditBinding.inflate(inflater, container, false)
         binding.githubbtn.setOnClickListener {
             val openURL = Intent(Intent.ACTION_VIEW)
             openURL.data = Uri.parse("https://github.com/leeyongjin0222")
             startActivity(openURL)
         }
         return binding.root


    }

}