package com.ism.saveanimal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentHome.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentHome : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.save_home, container, false)
    }
    // 여기서 리사이클러뷰 세팅!
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. 레이아웃에서 RecyclerView 가져오기
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)

        // 2. 레이아웃 매니저 설정 (세로 스크롤)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // 3. 어댑터 설정 (테스트용 더미 데이터)
        val dummyPosts = listOf(
            SaveDataItem("강아지 보호 공고", "2025-01-11", "3개월 추정, 믹스, 여아"),
            SaveDataItem("고양이 보호 공고", "2025-01-10", "2살 추정, 코숏, 중성화 완료"),
            SaveDataItem("유기견 구조 완료", "2025-01-09", "치와와, 건강양호")
        )

//        recyclerView.adapter = SaveHome(dummyPosts)
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentHome.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentHome().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}