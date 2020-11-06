package android.example.com.simplepaymentapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation


class HomeFragment : Fragment(), View.OnClickListener{


  private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController=Navigation.findNavController(view)
        view.findViewById<Button>(R.id.viewButton).setOnClickListener(this)
        view.findViewById<Button>(R.id.payButton).setOnClickListener(this)
    }


    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.viewButton ->navController.navigate(R.id.action_firstFragment_to_viewBalancesFragment)
            R.id.payButton ->navController.navigate(R.id.action_firstFragment_to_peopleFragment)
        }

    }
}