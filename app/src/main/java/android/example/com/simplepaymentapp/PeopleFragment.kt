package android.example.com.simplepaymentapp


import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation



class PeopleFragment : Fragment() {
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

//

              val listItems =parent.getItemAtPosition(position) as String
              val name=listItems

            if (!TextUtils.isEmpty(listItems)){
                val bundle= bundleOf("sendname" to name)

                navController.navigate(R.id.action_peopleFragment_to_payFragment,bundle)
            }


//
//              val intent = Intent(this.context,PayFragment::class.java)
//              intent.putExtra("Name",name)
//              startActivity(intent)
           // Toast.makeText(this.context, "Click on item at $listItems its item id $listItems", Toast.LENGTH_LONG).show()




        }

    }


}

