package com.yseko.proteinorder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.yseko.proteinorder.databinding.FragmentAmountBinding
import com.yseko.proteinorder.model.OrderViewModel


class AmountFragment : Fragment() {
    private var binding: FragmentAmountBinding?= null
    private val sharedViewModel: OrderViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentAmountBinding = FragmentAmountBinding.inflate(inflater, container, false)
        binding = fragmentAmountBinding
        return fragmentAmountBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            viewModel = sharedViewModel
            lifecycleOwner = viewLifecycleOwner
            amountFragment = this@AmountFragment
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    fun nextScreen(){
        findNavController().navigate(R.id.action_amountFragment_to_dateFragment)
    }

    fun cancelOrder(){
        sharedViewModel.resetOrder()
        findNavController().navigate(R.id.action_amountFragment_to_startFragment)
    }

}