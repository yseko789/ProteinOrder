package com.yseko.proteinorder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.yseko.proteinorder.databinding.FragmentDateBinding
import com.yseko.proteinorder.databinding.FragmentStartBinding
import com.yseko.proteinorder.model.OrderViewModel


class DateFragment : Fragment() {
    private var binding: FragmentDateBinding? = null
    private val sharedViewModel: OrderViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentDateBinding = FragmentDateBinding.inflate(inflater, container, false)
        binding = fragmentDateBinding
        return fragmentDateBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply{
            viewModel = sharedViewModel
            dateFragment = this@DateFragment
            lifecycleOwner = viewLifecycleOwner
        }
    }
    fun nextScreen(){
        findNavController().navigate(R.id.action_dateFragment_to_summaryFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}