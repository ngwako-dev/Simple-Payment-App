package android.example.com.simplepaymentapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlin.properties.Delegates


class PayCompleteFragment : Fragment() {

    private lateinit var sendname:String
    private lateinit var accountNumber: Number
    private var amount by Delegates.notNull<Double>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sendname= requireArguments().getString("sendname").toString()
        accountNumber= requireArguments().getLong("accountNumber")
        amount= requireArguments().getDouble("money")
        }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pay_complete, container, false)
    }


//    view.findViewById<TextView>(R.id.resultsTextview).text=results
//    view.findViewById<Button>(R.id.nextButton).setOnClickListener(this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val money=amount
        val sendname= sendname
        val results= "Name: $sendname"


        val confirmationMessage="Payment to"+"\n"+results+ "\n"+ "From account number"+
        "\n"+accountNumber+"\n"+"Amount"+"\n"+money

        view.findViewById<TextView>(R.id.confirmationTextView).text=confirmationMessage
    }
}