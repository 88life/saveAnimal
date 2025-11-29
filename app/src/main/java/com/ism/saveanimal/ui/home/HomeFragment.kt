package com.ism.saveanimal.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ism.saveanimal.databinding.SaveHomeBinding
class HomeFragment : Fragment() {

    private var _binding: SaveHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = SaveHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val name = arguments?.getString("name")
        binding.nickname.text = "$name 보호소 담당자님,"

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
