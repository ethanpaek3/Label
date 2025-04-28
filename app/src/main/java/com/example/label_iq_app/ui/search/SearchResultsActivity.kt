package com.example.label_iq_app.ui.search

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.label_iq_app.databinding.ActivitySearchResultsBinding

class SearchResultsActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySearchResultsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchResultsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val filters = intent.getStringArrayListExtra("SELECTED_FILTERS") ?: arrayListOf()
        binding.selectedFiltersTextView.text =
            if (filters.isEmpty()) "No filters applied"
            else "Applied filters: ${filters.joinToString(", ")}"
    }
}
