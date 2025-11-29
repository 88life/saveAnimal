package com.ism.saveanimal.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ism.saveanimal.ResultActivity
import com.ism.saveanimal.SaveMemberInformEditActivity
import com.ism.saveanimal.databinding.GenHomeBinding
import com.ism.saveanimal.databinding.SaveHomeBinding
class HomeFragment1 : Fragment() {

    private var _binding: GenHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = GenHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val name = arguments?.getString("name")
        binding.nickname.text = "$name 입양자님"

        binding.testBtn.setOnClickListener {
            val intent = Intent(requireContext(), ResultActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
