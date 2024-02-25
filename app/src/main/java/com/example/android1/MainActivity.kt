package com.example.android1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {

    private lateinit var searchEditText: EditText
    private lateinit var searchButton: Button
    private lateinit var imageView1: ImageView
    private lateinit var titleTextView1: TextView
    private lateinit var descriptionTextView1: TextView
    private lateinit var imageView2: ImageView
    private lateinit var titleTextView2: TextView
    private lateinit var descriptionTextView2: TextView
    private lateinit var imageView3: ImageView
    private lateinit var titleTextView3: TextView
    private lateinit var descriptionTextView3: TextView
    private lateinit var imageView4: ImageView
    private lateinit var titleTextView4: TextView
    private lateinit var descriptionTextView4: TextView
    private lateinit var imageView5: ImageView
    private lateinit var titleTextView5: TextView
    private lateinit var descriptionTextView5: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchEditText = findViewById(R.id.searchEditText)
        searchButton = findViewById(R.id.searchButton)
        imageView1 = findViewById(R.id.imageView1)
        titleTextView1 = findViewById(R.id.titleTextView1)
        descriptionTextView1 = findViewById(R.id.descriptionTextView1)
        imageView2 = findViewById(R.id.imageView2)
        titleTextView2 = findViewById(R.id.titleTextView2)
        descriptionTextView2 = findViewById(R.id.descriptionTextView2)
        imageView3 = findViewById(R.id.imageView3)
        titleTextView3 = findViewById(R.id.titleTextView3)
        descriptionTextView3 = findViewById(R.id.descriptionTextView3)
        imageView4 = findViewById(R.id.imageView4)
        titleTextView4 = findViewById(R.id.titleTextView4)
        descriptionTextView4 = findViewById(R.id.descriptionTextView4)
        imageView5 = findViewById(R.id.imageView5)
        titleTextView5 = findViewById(R.id.titleTextView5)
        descriptionTextView5 = findViewById(R.id.descriptionTextView5)

        // Обработчик нажатия кнопки поиска
        searchButton.setOnClickListener {
            val query = searchEditText.text.toString().trim()
            performSearch(query)
        }
    }

    private fun performSearch(query: String) {
        // Реализуйте здесь логику поиска
        // Это может быть обращение к базе данных или другому источнику данных
        // Здесь предполагается, что вы находите соответствующие элементы
        // и отображаете их или скрываете, в зависимости от результата поиска
        // Например:
        val pizza1Visible = titleTextView1.text.contains(query, ignoreCase = true) ||
                descriptionTextView1.text.contains(query, ignoreCase = true)
        val pizza2Visible = titleTextView2.text.contains(query, ignoreCase = true) ||
                descriptionTextView2.text.contains(query, ignoreCase = true)
        val pizza3Visible = titleTextView3.text.contains(query, ignoreCase = true) ||
                descriptionTextView3.text.contains(query, ignoreCase = true)
        val pizza4Visible = titleTextView4.text.contains(query, ignoreCase = true) ||
                descriptionTextView4.text.contains(query, ignoreCase = true)
        val pizza5Visible = titleTextView5.text.contains(query, ignoreCase = true) ||
                descriptionTextView5.text.contains(query, ignoreCase = true)

        imageView1.isVisible = pizza1Visible
        titleTextView1.isVisible = pizza1Visible
        descriptionTextView1.isVisible = pizza1Visible

        imageView2.isVisible = pizza2Visible
        titleTextView2.isVisible = pizza2Visible
        descriptionTextView2.isVisible = pizza2Visible

        imageView3.isVisible = pizza3Visible
        titleTextView3.isVisible = pizza3Visible
        descriptionTextView3.isVisible = pizza3Visible

        imageView4.isVisible = pizza4Visible
        titleTextView4.isVisible = pizza4Visible
        descriptionTextView4.isVisible = pizza4Visible

        imageView5.isVisible = pizza5Visible
        titleTextView5.isVisible = pizza5Visible
        descriptionTextView5.isVisible = pizza5Visible
    }
}
