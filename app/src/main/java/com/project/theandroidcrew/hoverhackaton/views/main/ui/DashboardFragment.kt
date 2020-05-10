package com.project.theandroidcrew.hoverhackaton.views.main.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.hover.sdk.actions.HoverAction
import com.hover.sdk.api.Hover
import com.hover.sdk.api.Hover.DownloadListener
import com.hover.sdk.permissions.PermissionActivity
import com.project.theandroidcrew.hoverhackaton.R
import com.project.theandroidcrew.hoverhackaton.databinding.FragmentDashboardBinding
import java.util.ArrayList


/**
 * A simple [Fragment] subclass.
 */
class DashboardFragment : Fragment(), View.OnClickListener, Hover.DownloadListener{

    private lateinit var binding: FragmentDashboardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_dashboard, container, false)

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Hover.initialize(context, this)
        startActivityForResult(Intent(context, PermissionActivity::class.java), 0)
        binding.apply {
            fragDashboardAirtimeTopupCardView.setOnClickListener(this@DashboardFragment)
            fragDashboardCheckBalanceCardView.setOnClickListener(this@DashboardFragment)
            fragDashboardCreateAccountCardView.setOnClickListener(this@DashboardFragment)
            fragDashboardFundsTransferCardView.setOnClickListener(this@DashboardFragment)
            fragDashboardOtherServicesCardView.setOnClickListener(this@DashboardFragment)
            fragDashboardPayBillsCardView.setOnClickListener(this@DashboardFragment)
        }
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.frag_dashboard_check_balance_cardView -> {
                this.findNavController().navigate(DashboardFragmentDirections.actionDashboardFragmentToBankSelectFragment(2))
            }

        }
    }

    override fun onSuccess(p0: ArrayList<HoverAction>?) {
        Toast.makeText(context, "Downloaded",Toast.LENGTH_LONG).show()
    }

    override fun onError(p0: String?) {
        Toast.makeText(context, "Error",Toast.LENGTH_LONG).show()
    }

}
