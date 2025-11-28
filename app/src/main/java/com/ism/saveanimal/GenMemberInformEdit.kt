package com.ism.saveanimal

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ism.saveanimal.databinding.FragmentActivityProfileBinding
import com.ism.saveanimal.databinding.GenMemberInformEditBinding

class GenMemberInformEdit : AppCompatActivity() {

    private lateinit var binding: GenMemberInformEditBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = GenMemberInformEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
