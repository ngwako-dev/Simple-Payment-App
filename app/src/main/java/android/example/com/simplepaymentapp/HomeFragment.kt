package android.example.com.simplepaymentapp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(R.layout.fragment_home){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       //navigate to viewBalancesFragment
       viewButton.setOnClickListener{
           findNavController().navigate(R.id.action_firstFragment_to_viewBalancesFragment)
       }
        //navigate to peopleFragment
        payButton.setOnClickListener{
         findNavController().navigate(R.id.action_firstFragment_to_peopleFragment)
        }
    }
}