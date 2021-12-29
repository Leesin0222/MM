package com.example.loginandlegister

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.loginandlegister.databinding.FragmentActionBinding
import com.example.loginandlegister.databinding.FragmentSportsBinding


class SportsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSportsBinding.inflate(inflater, container, false)

        return binding.root
    }

}