package android.example.com.simplepaymentapp

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_pay.*

class PayFragment: Fragment(R.layout.fragment_pay) {

    private lateinit var sendName:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //the name is launched
        sendName= requireArguments().getString("sendName").toString()
    }
    //reference of the views of the layout
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sendName = sendName
        val results = sendName
        resultsTextview.text = results
        //parse data to payCompleteFragment if the condition is satisfied
        nextButton.setOnClickListener {
            if (!TextUtils.isEmpty(("accountNumber" to accountNumberEdit.text.toString()).toString()) &&
                !TextUtils.isEmpty(("money" to amountEditText.text.toString()).toString())
            ) {
                val accountNumber = accountNumberEdit.text.toString()
                val amount = amountEditText.text.toString()
                val bundle = bundleOf(
                    "sendName" to sendName, "accountNumber" to accountNumber,
                    "money" to amount
                )
                //data to parse in the bundle and would be parsed in payCompleteFragment
                findNavController().navigate(R.id.action_payFragment_to_payCompleteFragment,bundle)
            }
            //navigating to disclaimerFragment
            disclaimerButton.setOnClickListener{
                findNavController().navigate(R.id.action_payFragment_to_disclaimerFragment)
            }
        }
    }
}