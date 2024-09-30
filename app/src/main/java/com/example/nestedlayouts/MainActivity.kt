package com.example.nestedlayouts

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var textView1: TextView
    private lateinit var textView2: TextView
    private lateinit var textView3: TextView
    private lateinit var textView4: TextView
    private lateinit var textView5: TextView
    private lateinit var textView6: TextView
    private lateinit var textViewConstraint1: TextView
    private lateinit var textViewConstraint2: TextView
    private lateinit var textViewConstraint3: TextView
    private lateinit var rollButton: Button

    private var currentIndex = 0
    private val textViews = mutableListOf<TextView>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Инициализация TextView
        textView1 = findViewById(R.id.textView1)
        textView2 = findViewById(R.id.textView2)
        textView3 = findViewById(R.id.textView3)
        textView4 = findViewById(R.id.textView4)
        textView5 = findViewById(R.id.textView5)
        textView6 = findViewById(R.id.textView6)
        textViewConstraint1 = findViewById(R.id.tvConstraintLayout1)
        textViewConstraint2 = findViewById(R.id.tvConstraintLayout2)
        textViewConstraint3 = findViewById(R.id.tvConstraintLayout3)
        val rollButton = findViewById<Button>(R.id.button)

        // Очистка всех полей и установка значения "1" для первых элементов
        resetTextViews()

        // Собираем все TextView в последовательности схемы
        textViews.addAll(listOf(textView1, textView2, textView3, textView4, textView5, textView6, textViewConstraint1, textViewConstraint2, textViewConstraint3))

        // Обработчик нажатия кнопки
        rollButton.setOnClickListener {
            incrementNextTextView()
        }
    }

    // Функция для очистки TextView и установки начального значения
    private fun resetTextViews() {
        // Устанавливаем текст "1" для первых TextView
        textView1.text = "1"
        textView4.text = "1"
        textViewConstraint1.text = "1"

        // Очищаем остальные TextView
        textView2.text = ""
        textView3.text = ""
        textView5.text = ""
        textView6.text = ""
        textViewConstraint2.text = ""
        textViewConstraint3.text = ""
    }

    // Функция для увеличения значения следующего TextView
    private fun incrementNextTextView() {
        // Если currentIndex вышел за пределы списка, сбрасываем его на начало
        if (currentIndex < textViews.size) {
            val currentTextView = textViews[currentIndex]
            val currentValue = currentTextView.text.toString().toIntOrNull() ?: 0
            currentTextView.text = (currentValue + 1).toString()
            currentIndex++
        } else {
            currentIndex = 0
        }
    }
}