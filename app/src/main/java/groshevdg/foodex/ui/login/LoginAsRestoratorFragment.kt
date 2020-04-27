package groshevdg.foodex.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import groshevdg.foodex.R
import groshevdg.foodex.ui.register.RegisterAsRestoratorFragment
import groshevdg.foodex.ui.viewModel.RestoratorViewModel

class LoginAsRestoratorFragment : Fragment() {

    private lateinit var viewModel: RestoratorViewModel

    companion object {
        fun newInstance() =
            RegisterAsRestoratorFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        return layoutInflater.inflate(R.layout.fragment_login_as_restorator, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RestoratorViewModel::class.java)
    }
}
