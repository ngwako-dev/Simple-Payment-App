package android.example.com.simplepaymentapp

import android.os.Bundle
import android.text.TextUtils
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_pay.*

class PayFragment: Fragment(R.layout.fragment_pay) {

    private lateinit var sendName:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)//menu item is launched
        //the name is launched
        sendName= requireArguments().getString("sendName").toString()
    }
    //reference of the views of the layout
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sendName = sendName
        val results = sendName
        resultsTextview.text = results
        //navigating to disclaimerFragment
            disclaimerButton.setOnClickListener{
                findNavController().navigate(R.id.action_payFragment_to_disclaimerFragment)
        }
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.next, menu)
    }
    //parse data to payCompleteFragment if the condition is satisfied
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_next) {
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
                findNavController().navigate(R.id.action_payFragment_to_payCompleteFragment, bundle)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}