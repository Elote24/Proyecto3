package com.elliot.breakingbadapp.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.elliot.breakingbadapp.R
import com.elliot.breakingbadapp.adapters.CategoryAdapter
import com.elliot.breakingbadapp.adapters.QuoteAdapter
import com.elliot.breakingbadapp.models.Character
import com.elliot.breakingbadapp.models.Quote
import com.elliot.breakingbadapp.viewmodels.CategoryCharacterViewModel
import com.elliot.breakingbadapp.viewmodels.QuotesActivityViewModel
import com.google.android.material.button.MaterialButton

class QuotesActivity : AppCompatActivity() {
    private lateinit var editAuthor: EditText
    val QuotesActivityViewModel : QuotesActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)

        editAuthor = findViewById<EditText>(R.id.EditAuthor)


        val  buttonSave = findViewById<MaterialButton>(R.id.button_seach)
        buttonSave.setOnClickListener {
            val recyclerViewData = findViewById<RecyclerView>(R.id.recyclerViewQuote)
            val QuoteAdapter = QuoteAdapter()

            recyclerViewData.layoutManager = LinearLayoutManager(this)
            recyclerViewData.adapter = QuoteAdapter


            QuotesActivityViewModel.listQuoteLiveData.observe(this,
                Observer<List<Quote>> {
                    QuoteAdapter.addResults(it)
                    QuoteAdapter.notifyDataSetChanged()
                })


            QuotesActivityViewModel.getQuotesByAuthor(editAuthor.text.toString())

        }
    }
}