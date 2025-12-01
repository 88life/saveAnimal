package com.ism.saveanimal

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import com.ism.saveanimal.databinding.SaveMenuFullBinding
import android.widget.ImageButton
import android.widget.Spinner
import com.ism.saveanimal.databinding.ActivitySaveAnnouncementEditBinding
import com.ism.saveanimal.databinding.FragmentSaveAnnouncementWriteBinding


class SaveAnnouncementWrite: AppCompatActivity() {
    private lateinit var binding: FragmentSaveAnnouncementWriteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = FragmentSaveAnnouncementWriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val genderGroup = binding.genderGroup
        val female = binding.radioButton3
        val male = binding.radioButton2

        var lastCheckedId = -1

        binding.genderGroup.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId == -1) return@setOnCheckedChangeListener

            if (checkedId == lastCheckedId) {
                group.clearCheck()
                lastCheckedId = -1
            } else {
                lastCheckedId = checkedId
            }
        }

        binding.button11.setOnClickListener {
            val intent = Intent(this, SaveMainActivity::class.java)
            startActivity(intent)
        }


        val spinner = findViewById<Spinner>(R.id.SpeciesSpinner)
        ArrayAdapter.createFromResource(
            this, R.array.species,
            android.R.layout.simple_spinner_item
        ).also {
            adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
        val spinner1 = findViewById<Spinner>(R.id.PersonalSpinner)
        ArrayAdapter.createFromResource(
            this, R.array.personal,
            android.R.layout.simple_spinner_item
        ).also {
                adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner1.adapter = adapter
        }
        val spinner2 = findViewById<Spinner>(R.id.ScaredSpinner)
        ArrayAdapter.createFromResource(
            this, R.array.scared,
            android.R.layout.simple_spinner_item
        ).also {
                adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner2.adapter = adapter
        }
        val spinner3 = findViewById<Spinner>(R.id.DiseasesSpinner)
        ArrayAdapter.createFromResource(
            this, R.array.disease,
            android.R.layout.simple_spinner_item
        ).also {
                adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner3.adapter = adapter
        }



    }




}