package com.arnassmicius.androiduitricks.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import com.arnassmicius.androiduitricks.viewmodels.MainViewModel
import com.arnassmicius.androiduitricks.R
import com.arnassmicius.androiduitricks.coordinatorlayout.fragments.CoordinatorLayoutFragment
import kotlinx.android.synthetic.main.main_fragment.*


class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        coordinatorLayoutButton.setOnClickListener {
            fragmentManager?.beginTransaction()
                    ?.replace(R.id.mainContainer, CoordinatorLayoutFragment.newInstance())
                    ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    ?.addToBackStack(null)
                    ?.commit()
        }
    }

}
