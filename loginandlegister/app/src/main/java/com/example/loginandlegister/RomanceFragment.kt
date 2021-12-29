package com.example.loginandlegister

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.loginandlegister.databinding.FragmentActionBinding
import com.example.loginandlegister.databinding.FragmentRomanceBinding


class RomanceFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentRomanceBinding.inflate(inflater, container, false)

        return binding.root
    }


}