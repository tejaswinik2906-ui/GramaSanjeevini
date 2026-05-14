package com.example.gramasanjeevini

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: MedicineAdapter
    private val allMedicines = mutableListOf<Medicine>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadMockData()

        val recyclerView = findViewById<RecyclerView>(R.id.medicineRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = MedicineAdapter(allMedicines)
        recyclerView.adapter = adapter

        val searchView = findViewById<SearchView>(R.id.searchView)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean = false
            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }
        })
    }

    private fun loadMockData() {
        allMedicines.add(Medicine("Insulin", "Village A Store", 2.1, true))
        allMedicines.add(Medicine("Paracetamol", "Grama Medicals", 5.4, false))
        allMedicines.add(Medicine("Antiserum", "Sanjeevini Center", 0.8, true))
    }

    private fun filterList(query: String?) {
        val filtered = allMedicines.filter { it.name.contains(query ?: "", true) }
        adapter.update(filtered)
    }
}