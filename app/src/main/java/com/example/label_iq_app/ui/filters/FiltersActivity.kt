package com.example.label_iq_app.ui.filters

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.label_iq_app.databinding.ActivityFiltersBinding
import com.example.label_iq_app.ui.search.SearchResultsActivity
import com.google.android.material.chip.Chip

class FiltersActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFiltersBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFiltersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.applyFiltersButton.setOnClickListener {
            // Collect the text of each checked Chip
            val selectedFilters = binding.chipGroup.checkedChipIds.mapNotNull { id ->
                (binding.chipGroup.findViewById(id) as? Chip)?.text?.toString()
            }

            // Launch the SearchResults screen, passing our list
            Intent(this, SearchResultsActivity::class.java).apply {
                putStringArrayListExtra("SELECTED_FILTERS", ArrayList(selectedFilters))
                startActivity(this)
            }
        }
    }
}
