package com.project.theandroidcrew.hoverhackaton.views.main.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

import com.project.theandroidcrew.hoverhackaton.R
import kotlinx.android.synthetic.main.fragment_number.*

/**
 * This Fragment shows up before the Onbrading Screen!
 */
class NumberFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_number, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonNumber.setOnClickListener{
            findNavController().navigate(R.id.action_firstFtagment_to_dashboardFragment)
        }

    }



    override fun onDestroy() {
        super.onDestroy()
    }
}
