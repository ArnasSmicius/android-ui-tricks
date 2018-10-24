package com.arnassmicius.androiduitricks.coordinatorlayout.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import com.arnassmicius.androiduitricks.coordinatorlayout.viewmodels.CoordinatorLayoutViewModel
import com.arnassmicius.androiduitricks.R
import kotlinx.android.synthetic.main.coordinator_layout_fragment.*


class CoordinatorLayoutFragment : Fragment() {

    companion object {
        fun newInstance() = CoordinatorLayoutFragment()
    }

    private lateinit var viewModel: CoordinatorLayoutViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.coordinator_layout_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CoordinatorLayoutViewModel::class.java)

        collapsingToolbarButton.setOnClickListener {
            fragmentManager?.beginTransaction()
                    ?.replace(R.id.mainContainer, CollapsingToolbarFragment.newInstance())
                    ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    ?.addToBackStack(null)
                    ?.commit()
        }
    }

}
