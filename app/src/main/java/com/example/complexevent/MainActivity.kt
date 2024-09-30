package com.example.complexevent

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var checkBox: CheckBox
    private lateinit var textView: TextView
    private lateinit var button: Button
    private lateinit var progressBar: ProgressBar
    private lateinit var infoTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Инициализация элементов интерфейса
        editText = findViewById(R.id.editText)
        checkBox = findViewById(R.id.checkBox)
        textView = findViewById(R.id.textView)
        button = findViewById(R.id.button)
        progressBar = findViewById(R.id.progressBar)
        infoTextView = findViewById(R.id.infoTextView)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Установка обработчика нажатия на кнопку
        button.setOnClickListener {
            // Проверка, отмечен ли CheckBox
            if (checkBox.isChecked) {
                // Получаем текст из EditText
                val text = editText.text.toString()
                // Устанавливаем текст в TextView
                infoTextView.text = text

                // Увеличиваем значение ProgressBar на 10%
                val newProgress = progressBar.progress + 10
                // Ограничиваем максимальное значение 100
                if (newProgress <= 100) {
                    progressBar.progress = newProgress
                } else {
                    progressBar.progress = 100 // Устанавливаем на максимум, если больше 100
                }
            }
        }
    }
}