package android.example.com.simplepaymentapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlin.properties.Delegates


class PayCompleteFragment : Fragment(), View.OnClickListener {

    private lateinit var sendName:String
    private lateinit var accountNumber: String
    private var amount by Delegates.notNull<String>()
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sendName= requireArguments().getString("sendName").toString()
        accountNumber= requireArguments().getString("accountNumber").toString()
        amount= requireArguments().getString("money").toString()
        }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pay_complete, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val money=amount
        val sendName= sendName
        val results= sendName

        val confirmationMessage="Payment to"+"\n"+results+ "\n" + "\n"+ "From account number"+
        "\n"+accountNumber+ "\n" +"\n"+"Amount"+"\n"+money

        view.findViewById<TextView>(R.id.confirmationTextView).text=confirmationMessage
        navController= Navigation.findNavController(view)
        view.findViewById<Button>(R.id.doneButton).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.doneButton -> navController.navigate(R.id.action_payCompleteFragment_to_firstFragment)
        }
    }
}