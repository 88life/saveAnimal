package com.ism.saveanimal

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.jvm.java

class ResultMainActivity : AppCompatActivity() {
    private val questionList = listOf(
        Question(1, "주말 충전 방식은? (O: 산책, 외출 / X: 실내 활동)"),
        Question(2, "소음이나 어지러움은? (O: 허용 가능 / X: 정돈된 환경)"),
        Question(3, "선호하는 관계는? (O: 끈끈한 애정 / X: 각자의 시간)")
    )
    private val userAnswers = mutableMapOf<Int, String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = QuestionAdapter(questionList, userAnswers)

        findViewById<View>(R.id.btnComplete).setOnClickListener {
            if (userAnswers.size < questionList.size) {
                Toast.makeText(this, "모든 질문에 답해주세요!", Toast.LENGTH_SHORT).show()
            } else {
                val resultKey = StringBuilder()
                for (i in 1..questionList.size) {
                    resultKey.append(userAnswers[i] ?: "X")
                }

                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("RESULT_KEY", resultKey.toString())
                startActivity(intent)
            }
        }
    }
}

data class Question(val id: Int, val text: String)

class QuestionAdapter(
    private val items: List<Question>,
    private val answers: MutableMap<Int, String>
) : RecyclerView.Adapter<QuestionAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvQuestion: TextView = view.findViewById(R.id.tvQuestion)
        val btnO: TextView = view.findViewById(R.id.btnO)
        val btnX: TextView = view.findViewById(R.id.btnX)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_question, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val question = items[position]
        holder.tvQuestion.text = "Q${question.id}. ${question.text}"
        val currentAnswer = answers[question.id]
        val context = holder.itemView.context

        fun updateButtons() {
            if (currentAnswer == "O") {
                holder.btnO.setBackgroundResource(R.drawable.bg_ox_selected)
                holder.btnO.setTextColor(ContextCompat.getColor(context, R.color.purple_500))
            } else {
                holder.btnO.setBackgroundResource(R.drawable.bg_ox_default)
                holder.btnO.setTextColor(Color.BLACK)
            }
            if (currentAnswer == "X") {
                holder.btnX.setBackgroundResource(R.drawable.bg_ox_selected)
                holder.btnX.setTextColor(ContextCompat.getColor(context, R.color.purple_500))
            } else {
                holder.btnX.setBackgroundResource(R.drawable.bg_ox_default)
                holder.btnX.setTextColor(Color.BLACK)
            }
        }
        updateButtons()

        holder.btnO.setOnClickListener {
            answers[question.id] = "O"
            notifyItemChanged(position)
        }
        holder.btnX.setOnClickListener {
            answers[question.id] = "X"
            notifyItemChanged(position)
        }
    }
    override fun getItemCount() = items.size

}