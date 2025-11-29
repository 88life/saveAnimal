package com.ism.saveanimal

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.ism.saveanimal.databinding.ActivityMyPickBinding // [주의] 바인딩 이름 확인

class MyPickActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMyPickBinding // [주의] 바인딩 타입 변경
    private lateinit var adapter: AnimalAdapter1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // [주의] 바인딩 inflate 변경
        binding = ActivityMyPickBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbarAndDrawer()
        setupRecyclerView()
        loadDummyData() // 나중엔 '찜한 목록'만 불러오는 함수로 바꾸면 됨
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
        adapter = AnimalAdapter1(emptyList())
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }

    private fun loadDummyData() {
        // 일단 가짜 데이터 (나중엔 DB에서 내가 찜한 것만 가져오기)
        val dummyList = listOf(
            Post("1", "찜한 강아지", 3, "수컷", ""),
            Post("2", "찜한 고양이", 2, "암컷", "")
        )
        adapter.updateData(dummyList)
    }
}