package android.example.com.simplepaymentapp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_pay_complete.*
import kotlin.properties.Delegates

class PayCompleteFragment: Fragment(R.layout.fragment_pay) {
    //initializing
    private lateinit var sendName:String
    private lateinit var accountNumber: String
    private var amount by Delegates.notNull<String>()
    //launching name, money and account number in the payCompleteFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sendName= requireArguments().getString("sendName").toString()
        accountNumber= requireArguments().getString("accountNumber").toString()
        amount= requireArguments().getString("money").toString()
    }
    //reference of the views of the layout
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

            val money=amount
            val sendName= sendName
            val results= sendName

            val confirmationMessage="Payment to"+"\n"+results+ "\n" + "\n"+ "From account number"+
                    "\n"+accountNumber+ "\n" +"\n"+"Amount"+"\n"+money
            //message to be displayed on payCompleteFragment
            confirmationTextView.text=confirmationMessage
            //navigate from payCompleteFragment to firstFragment
            doneButton.setOnClickListener{
                findNavController().navigate(R.id.action_payCompleteFragment_to_firstFragment)
        }
    }
}