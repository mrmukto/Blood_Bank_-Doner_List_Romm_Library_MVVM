package com.mrmukto.bloodbank

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.mrmukto.bloodbank.adapters.DonorAdapter
import com.mrmukto.bloodbank.databinding.FragmentDonerListBinding
import com.mrmukto.bloodbank.viewModels.BloodViewModel


class DonerListFragment : Fragment() {

    private lateinit var binding: FragmentDonerListBinding
    private lateinit var adapter: DonorAdapter
    private val donorViewModel: BloodViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =  FragmentDonerListBinding.inflate(inflater,container, false)

        adapter = DonorAdapter(){model, action ->

        }
        binding.donorRV.layoutManager = LinearLayoutManager(requireActivity())
        binding.donorRV.adapter = adapter


        donorViewModel.getDonorList().observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }


        binding.addDonorFab.setOnClickListener{
            findNavController().navigate(R.id.action_donerListFragment_to_newDonerFragment)
        }

        return binding.root
    }


}