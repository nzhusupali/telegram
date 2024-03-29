package nzhusupali.project.telegram.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import nzhusupali.project.telegram.R

open class BaseFragment(private val layout: Int) : Fragment() {
    private lateinit var mRootView: View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mRootView = inflater.inflate(layout, container, false)
        return mRootView

    }

    override fun onStart() {
        super.onStart()

    }
}
