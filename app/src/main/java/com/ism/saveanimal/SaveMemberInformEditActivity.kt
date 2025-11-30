package com.ism.saveanimal

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.ism.saveanimal.databinding.SaveMemberInformEditBinding

class SaveMemberInformEditActivity : AppCompatActivity() {

    private lateinit var binding: SaveMemberInformEditBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SaveMemberInformEditBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val spinner = findViewById<Spinner>(R.id.spinnerRegion)
        ArrayAdapter.createFromResource(
            this, R.array.region_list,
            android.R.layout.simple_spinner_item
        ).also {
                adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
//        }
    }

}

