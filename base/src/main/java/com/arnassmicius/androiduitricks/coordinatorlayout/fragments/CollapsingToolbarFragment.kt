package com.arnassmicius.androiduitricks.coordinatorlayout.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.os.Parcelable
import android.view.*
import androidx.fragment.app.Fragment
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.arnassmicius.androiduitricks.R
import com.arnassmicius.androiduitricks.activities.MainActivity
import com.arnassmicius.androiduitricks.coordinatorlayout.adapters.CollapsingToolbarSettingsAdapter
import com.arnassmicius.androiduitricks.coordinatorlayout.adapters.CollapsingToolbarSettingsAdapterDelegate
import com.arnassmicius.androiduitricks.coordinatorlayout.viewmodels.CollapsingToolbarViewModel
import com.google.android.material.appbar.AppBarLayout
import kotlinx.android.synthetic.main.collapsing_toolbar_fragment.*
import kotlinx.android.synthetic.main.collapsing_toolbar_fragment.view.*

class CollapsingToolbarFragment : Fragment() {

    companion object {
        fun newInstance() = CollapsingToolbarFragment()
    }

    private lateinit var viewModel: CollapsingToolbarViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.collapsing_toolbar_fragment, container, false).also {
            it.settings.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            (activity as? MainActivity)?.makeTransparentStatusBar(true)
            (activity as AppCompatActivity).setSupportActionBar(it.toolbar)
            setHasOptionsMenu(true)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CollapsingToolbarViewModel::class.java)

        viewModel.adapter.observe(this, Observer {
            settings.adapter = it
        })

        viewModel.snapState.observe(this, Observer {
            setSnapState(it)
        })

        viewModel.actionBarState.observe(this, Observer {
            (fab as View).visibility = if (it) VISIBLE else GONE
        })

        toolbar.setNavigationOnClickListener {
            fragmentManager?.popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        (activity as? MainActivity)?.makeTransparentStatusBar(false)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.collapsing_toolbar_menu, menu)
    }

    private fun setSnapState(isEnabled: Boolean) {
        val params = collapsingToolbarLayout.layoutParams as AppBarLayout.LayoutParams
        if (isEnabled) {
            params.scrollFlags =
                    AppBarLayout.LayoutParams.SCROLL_FLAG_SNAP or
                    AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL or
                    AppBarLayout.LayoutParams.SCROLL_FLAG_EXIT_UNTIL_COLLAPSED
        } else {
            params.scrollFlags =
                    AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL or
                    AppBarLayout.LayoutParams.SCROLL_FLAG_EXIT_UNTIL_COLLAPSED
        }
        collapsingToolbarLayout.layoutParams = params
    }

}
