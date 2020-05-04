package groshevdg.foodex.ui.mainActivity.restorator.profile

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider

import groshevdg.foodex.R

class RestoratorProfileFragment : Fragment() {

    companion object {
        fun newInstance() = RestoratorProfileFragment()
    }

    private lateinit var viewModel: RestoratorProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.restorator_profile_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RestoratorProfileViewModel::class.java)
    }

}
