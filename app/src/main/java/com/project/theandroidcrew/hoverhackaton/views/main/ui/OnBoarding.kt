package com.project.theandroidcrew.hoverhackaton.views.main.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2

import com.project.theandroidcrew.hoverhackaton.R
import com.project.theandroidcrew.hoverhackaton.utils.OnBoardSlide
import com.project.theandroidcrew.hoverhackaton.utils.OnBoardSliderAdapter
import kotlinx.android.synthetic.main.fragment_on_boarding.*
import kotlinx.android.synthetic.main.fragment_on_boarding.view.*


class OnBoarding : Fragment() {

    private lateinit var viewPager: ViewPager2
    private lateinit var indicatorCont: LinearLayout

    private val introSliderAdapter = OnBoardSliderAdapter(
        listOf(
            OnBoardSlide(
                "Make Payments", R.drawable.paybills
            ), OnBoardSlide(
                "Transfer Money", R.drawable.transfercash
            ), OnBoardSlide(
                "Do everything offline", R.drawable.transactions
            )
        )
    )


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_on_boarding, container, false)

        viewPager = view.findViewById(R.id.viewpager)
        indicatorCont = view.findViewById(R.id.indicatorContainer)
        viewPager.adapter = introSliderAdapter
        setUpIndicator(indicatorCont)
        setCurrentIndicator(0, indicatorCont)
        viewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position, indicatorCont)
            }
        }
        )

       view.materialButton.setOnClickListener {
            findNavController().navigate(R.id.action_onBoarding_to_dashboardFragment)
        }
        // Inflate the layout for this fragment
        return view
    }

    private fun setUpIndicator(view: LinearLayout) {
        val indicators = arrayOfNulls<ImageView>(introSliderAdapter.itemCount)
        val layoutParams: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(12, 12)
        layoutParams.setMargins(8, 0, 8, 0)
        for (i in indicators.indices) {
            indicators[i] = ImageView(context)
            indicators[i].apply {
                this?.setImageDrawable(
                    ContextCompat.getDrawable(
                        context, R.drawable.indicator_inactive
                    )
                )
                this?.layoutParams = layoutParams
            }
            view.addView(indicators[i])
        }
    }

    private fun setCurrentIndicator(index: Int, view: LinearLayout) {
        val childCount = view.childCount
        for (i in 0 until childCount) {
            val imageView = view.get(i) as ImageView
            if (i == index) {
                imageView.setImageDrawable(
                    context?.let {
                        ContextCompat.getDrawable(
                            it, R.drawable.indicator_active
                        )
                    }
                )
            } else {
                imageView.setImageDrawable(
                    context?.let {
                        ContextCompat.getDrawable(
                            it, R.drawable.indicator_inactive
                        )
                    }
                )

            }
        }
    }

}
