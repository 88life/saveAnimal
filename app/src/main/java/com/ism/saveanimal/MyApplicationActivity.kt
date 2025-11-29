package com.ism.saveanimal

import android.content.Intent
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.ism.saveanimal.databinding.ActivityMyApplicationBinding

class MyApplicationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMyApplicationBinding
    private lateinit var adapter: AnimalAdapter1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyApplicationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        loadDummyData()

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
        adapter = AnimalAdapter1(emptyList(), onItemClick = { item ->
            // ← 여기서 클릭된 아이템의 정보를 받음

            val intent = Intent(this, PostDetailCustomActivity::class.java)
            intent.putExtra("postId", item.documentId)      // 필요한 데이터 전달
            intent.putExtra("name", item.aName)
            intent.putExtra("age", item.aAge)
            intent.putExtra("gender", item.aGender)
            intent.putExtra("image", item.mainImageUrl) // 이미지가 있다면
            intent.putExtra("breed", item.aBreed)
            intent.putExtra("personality", item.aPersonality)
            intent.putExtra("fears", item.aFears)
            intent.putExtra("diseases", item.aDiseases)
            intent.putExtra("shelter", item.aShelter)

            startActivity(intent)
        },
            onButtonClick = {item ->
            val intent = Intent(this, PostDetailCustomActivity::class.java)
                intent.putExtra("postId", item.documentId)
                startActivity(intent)
        }
        )


        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }

    private fun loadDummyData() {
        // 테스트용 데이터 (화면이 바뀐 걸 확인하기 위해 이름만 살짝 바꿔보세요)
        val dummyList = listOf(
            Post("10", "신청한 멍멍이", 3, "수컷", ""),
            Post("11", "신청한 야옹이", 2, "암컷", "")
        )
        adapter.updateData(dummyList)
    }

}