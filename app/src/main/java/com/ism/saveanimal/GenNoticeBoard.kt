package com.ism.saveanimal

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.ism.saveanimal.databinding.ActivityMainBinding
import com.ism.saveanimal.databinding.FragmentGenHomeBinding
import com.ism.saveanimal.databinding.GenBoardBinding

class GenNoticeBoard : AppCompatActivity() {

    private lateinit var binding: GenBoardBinding
    private lateinit var adapter: AnimalAdapter

    // 원본 데이터를 저장해두는 리스트 (검색/정렬 할 때 사용)
    private var originalList = listOf<Post>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = GenBoardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbarAndDrawer() // 툴바, 드로어 설정 분리
        setupRecyclerView()     // 리스트 설정 분리
        loadDummyData()         // 데이터 로드
        setupEvents()           //버튼 및 검색 기능 연결
    }

    // 툴바 및 드로어(메뉴) 설정
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

    // 리사이클러뷰 설정
    private fun setupRecyclerView() {
        adapter = AnimalAdapter(emptyList())
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }

    //가짜 데이터( 실행되는지만 보려고 만든 데이터라 데이터베이스 들어갈 때 삭제해주세요)
    private fun loadDummyData() {
        originalList = listOf(
            Post("1", "바둑이", 3, "수컷", ""),
            Post("2", "나비", 2, "암컷", ""),
            Post("3", "초코", 5, "수컷", ""),
            Post("4", "인절미", 1, "암컷", ""),
            Post("5", "뭉치", 7, "수컷", ""),
            Post("6", "두부", 4, "암컷", "")
        )
        // 처음엔 전체 데이터를 화면에 표시
//        adapter.updateData(originalList)
    }

    // 버튼 클릭 및 검색 기능 설정
    private fun setupEvents() {
        // (1) 검색창 기능-글자를 칠 때마다 실행됨
        binding.etSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val searchText = s.toString().trim()
                filterList(searchText)
            }
            override fun afterTextChanged(s: Editable?) {}
        })

        // 정렬 버튼 기능
        binding.btnSortLatest.setOnClickListener {
            updateFilterStyle(binding.btnSortLatest) // 버튼 스타일 변경
            // 최신순-원래 리스트 순서대로 보여줌 (ID순이라고 가정)
            val sorted = originalList.sortedBy { it.documentId }
//            adapter.updateData(sorted)
        }

        binding.btnSortDistance.setOnClickListener {
            updateFilterStyle(binding.btnSortDistance)
            // 거리순-가짜 데이터라 거리 정보가 없으니 '이름순'으로 정렬
            val sorted = originalList.sortedBy { it.aName }
//            adapter.updateData(sorted)
        }

        binding.btnSortRecommend.setOnClickListener {
            updateFilterStyle(binding.btnSortRecommend)
            // 추천순: '나이순'으로 정렬
            val sorted = originalList.sortedBy { it.aAge }
//            adapter.updateData(sorted)
        }
    }

    // 검색어에 따라 리스트 걸러내기
    private fun filterList(query: String) {
        if (query.isEmpty()) {
//            adapter.updateData(originalList)
        } else {
            // 이름에 검색어가 포함된 동물만 남김
            val filtered = originalList.filter { post ->
                post.aName.contains(query)
            }
//            adapter.updateData(filtered)
        }
    }

    // 선택된 버튼만 진하게 만들고 나머지는 연하게 (시각 효과)
    private fun updateFilterStyle(selectedBtn: TextView) {
        // 모든 버튼 초기화 (연한 회색)
        val buttons = listOf(binding.btnSortLatest, binding.btnSortDistance, binding.btnSortRecommend)
        buttons.forEach { btn ->
            btn.background.setTint(Color.parseColor("#FFFFFF")) // 흰색 배경
            btn.typeface = android.graphics.Typeface.DEFAULT
        }

        // 선택된 버튼만 강조 (진한 회색)
        selectedBtn.background.setTint(Color.parseColor("#E0E0E0"))
        selectedBtn.typeface = android.graphics.Typeface.DEFAULT_BOLD
    }
}