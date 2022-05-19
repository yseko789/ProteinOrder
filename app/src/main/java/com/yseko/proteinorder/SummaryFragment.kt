package com.yseko.proteinorder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.yseko.proteinorder.databinding.FragmentSummaryBinding
import com.yseko.proteinorder.model.OrderViewModel


class SummaryFragment : Fragment() {
    private var binding: FragmentSummaryBinding? = null
    private val sharedViewModel: OrderViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentSummaryBinding = FragmentSummaryBinding.inflate(inflater, container, false)
        binding = fragmentSummaryBinding
        return fragmentSummaryBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply{
            viewModel = sharedViewModel
            lifecycleOwner = viewLifecycleOwner
            summaryFragment = this@SummaryFragment
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding =null
    }

    fun sendOrder(){
        Toast.makeText(activity, "Send Order", Toast.LENGTH_SHORT).show()
    }

    fun cancelOrder(){
        sharedViewModel.resetOrder()
        findNavController().navigate(R.id.action_summaryFragment_to_startFragment)
    }
}