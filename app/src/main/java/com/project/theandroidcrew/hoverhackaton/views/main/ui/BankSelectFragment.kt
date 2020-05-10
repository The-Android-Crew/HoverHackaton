package com.project.theandroidcrew.hoverhackaton.views.main.ui

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.hover.sdk.api.Hover
import com.hover.sdk.api.HoverParameters
import com.project.theandroidcrew.hoverhackaton.R
import com.project.theandroidcrew.hoverhackaton.databinding.FragmentBankSelectBinding
import com.project.theandroidcrew.hoverhackaton.views.main.adapter.BankClickListener
import com.project.theandroidcrew.hoverhackaton.views.main.adapter.BankSelectAdapter


/**
 * A simple [Fragment] subclass.
 */
@SuppressLint("UseRequireInsteadOfGet")
class BankSelectFragment : Fragment() {

    private lateinit var binding : FragmentBankSelectBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_bank_select,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Hover.initialize(context)
        val arg = BankSelectFragmentArgs.fromBundle(requireArguments())
        val adapter = BankSelectAdapter(BankClickListener {
            Toast.makeText(context,it,Toast.LENGTH_LONG).show()
            val i : Intent = HoverParameters.Builder(context)
                .request("38198ef5")
                .buildIntent()
            startActivityForResult(i, 0)
//            when(arg.action){
//                2 -> {
//
//                }
//            }

        })
        binding.fraBankSelectBackButton.setOnClickListener {
            activity?.onBackPressed()
        }
        binding.fragBankSelectRecyclerView.adapter = adapter

        val banks = listOf("Guarantee Trust Bank", "United Bank for Africa", "Fidelity Bank", "Access Bank", "Access Bank(Diamond)","First Bank of Nigeria", "First City Monument Bank(FCMB)", "Stanbic IBTC Bank", "Sterling Bank", "Eco Bank", "Union Bank", "Keystone Bank", "Polaris bank", "Wema Bank", "Zenith Bank")

        adapter.submitList(banks.sorted())
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 0 && resultCode == Activity.RESULT_OK) {
            val sessionTextArr = data!!.getStringArrayExtra("session_messages")
            Toast.makeText(context!!, "Success: $sessionTextArr", Toast.LENGTH_LONG).show()
            val uuid = data.getStringExtra("uuid")
        } else if (requestCode == 0 && resultCode == Activity.RESULT_CANCELED) {
            Toast.makeText(context!!, "Error: " + data!!.getStringExtra("error"), Toast.LENGTH_LONG)
                .show()
        }
    }

}
