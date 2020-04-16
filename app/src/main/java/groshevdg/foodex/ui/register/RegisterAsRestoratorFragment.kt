package groshevdg.foodex.ui.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import groshevdg.foodex.R

import groshevdg.foodex.ui.view_model.RestoratorViewModel

class RegisterAsRestoratorFragment : Fragment() {

    private lateinit var viewModel: RestoratorViewModel

    companion object {
        fun newInstance() =
            RegisterAsRestoratorFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_register_as_restorator, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RestoratorViewModel::class.java)
    }

}
