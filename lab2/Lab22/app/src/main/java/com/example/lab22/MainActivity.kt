package com.example.lab22
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var searchEditText: EditText
    private lateinit var searchButton: Button
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CelebrityAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchEditText = findViewById(R.id.searchEditText)
        searchButton = findViewById(R.id.searchButton)
        recyclerView = findViewById(R.id.celebritiesRecyclerView)
        adapter = CelebrityAdapter()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        searchButton.setOnClickListener {
            val name = searchEditText.text.toString()
            if (name.isNotEmpty()) {
                searchCelebrities(name)
            }
        }
    }

    private fun searchCelebrities(name: String) {
        val apiKey = "PBQI9AKzZOl+t4zX/yZr/Q==4KtRNRv1WyZK0al1"
        GlobalScope.launch(Dispatchers.IO) {
            val celebrities = ApiClient.create().searchCelebrities(name, null, null, null, null, null, apiKey)
            runOnUiThread {
                adapter.updateData(celebrities)
            }
        }
    }
}
