package android.example.com.simplepaymentapp


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.NavController
import androidx.navigation.Navigation


class peopleFragment : Fragment() {

    private lateinit var listView: ListView
    private lateinit var navController: NavController

    override fun onCreateView(


        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_people, container, false)

    }

    private val listItems = listOf("Albatruna","Alligamish","Buffaros","Chimadger","Chimpow","Demonkey","Doomling","Fiepecker","Gothyte","parsnipe")


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listView = view.findViewById(R.id.myListview)
        navController= Navigation.findNavController(view)



        val adapter =ArrayAdapter(requireContext(),android.R.layout.simple_list_item_1,listItems)
        listView.adapter=adapter

        listView.setOnItemClickListener{parent, view, position, id ->


            //  var listItems =parent.getItemAtPosition(position) as String
            navController.navigate(R.id.action_peopleFragment_to_payFragment)

        }

    }


}
