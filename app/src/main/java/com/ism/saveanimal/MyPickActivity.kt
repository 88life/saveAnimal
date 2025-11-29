package com.ism.saveanimal

import android.content.Intent
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.ism.saveanimal.databinding.ActivityMyPickBinding

class MyPickActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMyPickBinding
    private lateinit var adapter: AnimalAdapter1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyPickBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        loadDummyData() // 함수 호출
    }

    private fun setupToolbarAndDrawer() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val toggle = ActionBarDrawerToggle(
            this, binding.drawerLayout, binding.toolbar,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        toggle.drawerArrowDrawable.color = getColor(R.color.theme_orange)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                } else {
                    isEnabled = false
                    onBackPressedDispatcher.onBackPressed()
                }
            }
        })
    }

    private fun setupRecyclerView() {

        adapter = AnimalAdapter1(
            emptyList(),
            onItemClick = { item ->

                val intent = Intent(this, PostDetailCustomActivity::class.java)
                intent.putExtra("postId", item.documentId)
                intent.putExtra("name", item.aName)
                intent.putExtra("age", item.aAge)
                intent.putExtra("gender", item.aGender)
                intent.putExtra("image", item.mainImageUrl)
                intent.putExtra("breed", item.aBreed)
                intent.putExtra("personality", item.aPersonality)
                intent.putExtra("fears", item.aFears)
                intent.putExtra("diseases", item.aDiseases)
                intent.putExtra("shelter", item.aShelter)

                startActivity(intent)
            },
            onButtonClick = { item ->
                val intent = Intent(this, PostDetailCustomActivity::class.java)
                intent.putExtra("postId", item.documentId)
                startActivity(intent)
            }
        )
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }

    private fun loadDummyData() {
        val dummyList = listOf(
            Post("1", "찜한 강아지", 3, "수컷", ""),
            Post("2", "찜한 고양이", 2, "암컷", "")
        )
        adapter.updateData(dummyList)
    }
}
