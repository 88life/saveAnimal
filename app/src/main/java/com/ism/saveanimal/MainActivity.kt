package com.ism.saveanimal


import android.os.Bundle
import android.content.Intent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.button.MaterialButtonToggleGroup
import kotlin.jvm.java

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val toggleGroup = findViewById<MaterialButtonToggleGroup>(R.id.toggle_button_group)
        val nextButton = findViewById<MaterialButton>(R.id.button)

        nextButton.setOnClickListener {
            val selectedButtonId = toggleGroup.checkedButtonId

            when(selectedButtonId) {
                R.id.button_animalShelter -> {
                    val intent = Intent(this, SaveMainActivity::class.java)
                    startActivity(intent)
                }

                R.id.button_users -> {
                    val intent = Intent(this, GenMainActivity::class.java)
                    startActivity(intent)
                }
            }
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}