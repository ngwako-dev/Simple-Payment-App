package android.example.com.simplepaymentapp

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_people.*

class PeopleFragment: Fragment(R.layout.fragment_people) {
    //initializing
    private lateinit var listView: ListView
    private val listItems = listOf("Albatruna","Alligamish",
        "Buffaros","Chimadger","Chimpow","Demonkey","Doomling","Fiepecker","Gothyte","parsnipe")
    // //reference of the views of the layout
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listView = myListview

        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, listItems)
        listView.adapter = adapter

        listView.setOnItemClickListener { parent, view, position, id ->

            val listItems = parent.getItemAtPosition(position) as String
            val name = listItems

            if (!TextUtils.isEmpty(listItems)) {
                val bundle = bundleOf("sendName" to name)
                findNavController().navigate(R.id.action_peopleFragment_to_payFragment, bundle)
            }
        }
    }
}