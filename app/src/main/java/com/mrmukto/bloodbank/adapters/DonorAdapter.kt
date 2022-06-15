package com.mrmukto.bloodbank.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mrmukto.bloodbank.databinding.DonorRowBinding
import com.mrmukto.bloodbank.entities.BloodModel

class DonorAdapter(val actionCallback: (BloodModel, String) -> Unit) : ListAdapter<BloodModel, DonorAdapter.DonorViewHolder>(
    DonorDiffCallback()
) {

    class DonorViewHolder(
        private val binding: DonorRowBinding,
        val actionCallback: (BloodModel, String) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(todoModel: BloodModel) {
            binding.donor = todoModel


//            binding.callDonor.setOnClickListener {
//                try {
//                    val intent = Intent(Intent.ACTION_DIAL).apply {
//                        data = Uri.parse("tel:2546515464")
//                    }
//                    startActivity(intent)
//                }catch (e: ActivityNotFoundException) {
//                    Toast.makeText(requireActivity(), "could not launch app", Toast.LENGTH_SHORT).show()
//                }
//            }


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DonorViewHolder {
        val binding = DonorRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DonorViewHolder(binding, actionCallback)
    }

    override fun onBindViewHolder(holder: DonorViewHolder, position: Int) {
        val todoModel = getItem(position)
        holder.bind(todoModel)
    }
}

class DonorDiffCallback : DiffUtil.ItemCallback<BloodModel>() {
    override fun areItemsTheSame(oldItem: BloodModel, newItem: BloodModel): Boolean {
        return oldItem.bloodId == newItem.bloodId
    }

    override fun areContentsTheSame(oldItem: BloodModel, newItem: BloodModel): Boolean {
        return oldItem == newItem
    }

}