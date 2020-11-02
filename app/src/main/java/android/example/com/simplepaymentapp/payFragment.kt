package android.example.com.simplepaymentapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation


class payFragment : Fragment(), View.OnClickListener{


    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pay, container, false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController= Navigation.findNavController(view)
        view.findViewById<Button>(R.id.disclaimerButton).setOnClickListener(this)
    }


    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.disclaimerButton ->navController.navigate(R.id.action_payFragment_to_disclaimerFragment)
        }

    }
    //nSaveButton(){
    //al accountNuner=8g9FI10@
    //g9
    //al amount=
}
//}