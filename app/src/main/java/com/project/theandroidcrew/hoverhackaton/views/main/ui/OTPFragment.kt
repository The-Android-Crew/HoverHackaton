package com.project.theandroidcrew.hoverhackaton.views.main.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

import com.project.theandroidcrew.hoverhackaton.R
import kotlinx.android.synthetic.main.fragment_otp.*

/**
 * A simple [Fragment] subclass.
 */
class OTPFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_otp, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonVerify.setOnClickListener{
            findNavController().navigate(R.id.action_firstFtagment_to_dashboardFragment)
        }

        textViewMiniDescription3.setOnClickListener{
            // Resend OTP
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}
