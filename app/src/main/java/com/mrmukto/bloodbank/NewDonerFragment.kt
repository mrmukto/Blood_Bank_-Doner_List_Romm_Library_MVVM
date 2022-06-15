package com.mrmukto.bloodbank

import android.R
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.RadioButton
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.mrmukto.bloodbank.customsDialouge.DatePickerFragment
import com.mrmukto.bloodbank.databinding.FragmentNewDonerBinding
import com.mrmukto.bloodbank.entities.BloodModel
import com.mrmukto.bloodbank.viewModels.BloodViewModel

class NewDonerFragment : Fragment() {

    private lateinit var binding: FragmentNewDonerBinding
    private val bloodViewModel: BloodViewModel by viewModels()
    private var bloodRGroup = "B+"
    private var selectedDate = ""
    private var gender = " "
    var dateInMillis = System.currentTimeMillis()
    private var day = 0
    private var month = 0
    private var year = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewDonerBinding.inflate(inflater, container, false)
        initBloodSpinner()

        binding.genderRG.setOnCheckedChangeListener { group, checkedId ->
            val rb: RadioButton = group.findViewById(checkedId)
            gender = rb.text.toString()
        }
        binding.btnDOB.setOnClickListener {
            DatePickerFragment {
                selectedDate = it
                binding.showDateTV.text = it
            }.show(childFragmentManager, null)
        }
        binding.saveBtn.setOnClickListener {
            val name = binding.donorName.text.toString()
            val age = binding.donorAge.text.toString()
            val phone = binding.donorPhone.text.toString()
            val donor = BloodModel(
                name = name,
                age = age,
                phone = phone,
                gender = gender,
                bloodRGroup = bloodRGroup,
                date = dateInMillis,
                day = day,
                month = month,
                year = year,
            )
            bloodViewModel.insertDonor(donor)
            findNavController().popBackStack()

        }



        return binding.root
    }

    private fun initBloodSpinner() {
        val bloodAdapter = ArrayAdapter<String>(
            requireActivity(),
            R.layout.simple_spinner_dropdown_item,
            bloodGroup
        )
        binding.bloodSpinner.adapter = bloodAdapter

        binding.bloodSpinner.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    bloodRGroup = p0?.getItemAtPosition(p2).toString()
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {

                }

            }
    }

}
val bloodGroup = listOf("A+", "A-", "B+", "B-", "O+", "O-", "AB+","AB-")