package android.example.com.simplepaymentapp

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_pay.*


class PayFragment : Fragment(), View.OnClickListener{


    private lateinit var navController: NavController
    private lateinit var sendname:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sendname= requireArguments().getString("sendname").toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pay, container, false)
    }






    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       val sendname= sendname
        val results= "Name: $sendname"
        view.findViewById<TextView>(R.id.resultsTextview).text=results
        view.findViewById<Button>(R.id.nextButton).setOnClickListener(this)


          navController= Navigation.findNavController(view)
        view.findViewById<Button>(R.id.disclaimerButton).setOnClickListener(this)
    }


    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.disclaimerButton ->navController.navigate(R.id.action_payFragment_to_disclaimerFragment)
            R.id.nextButton ->
                if (!TextUtils.isEmpty(("accountNumber" to accountNumberEdit.text.toString()).toString()) &&
                        !TextUtils.isEmpty(("money" to amountEditText.text.toString()).toString())){
                    val accountNumber=accountNumberEdit.text.toString()
                    val amount=amountEditText.text.toString()

                    val bundle= bundleOf("sendName" to sendname,"accountNumber" to accountNumber,
                            "money" to amount)

                navController.navigate(R.id.action_payFragment_to_payCompleteFragment,bundle)

                    Toast.makeText(this.context,"name"+bundle,Toast.LENGTH_LONG).show()
        }

    }

}}
