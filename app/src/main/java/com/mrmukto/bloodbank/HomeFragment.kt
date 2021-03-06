package com.mrmukto.bloodbank

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

import com.mrmukto.bloodbank.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private  lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container,false)

        binding.donerET.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_newDonerFragment)
        }

        binding.donerList.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_donerListFragment)
        }
       return binding.root
    }



}