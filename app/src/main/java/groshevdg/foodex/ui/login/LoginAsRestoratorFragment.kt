package groshevdg.foodex.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import groshevdg.foodex.App
import groshevdg.foodex.R
import groshevdg.foodex.di.factory.ViewModelFactory
import groshevdg.foodex.ui.mainActivity.restorator.RestoratorMainActivity
import groshevdg.foodex.ui.viewModel.RestoratorViewModel
import kotlinx.android.synthetic.main.fragment_login_as_restorator.view.*
import javax.inject.Inject

class LoginAsRestoratorFragment : Fragment(), View.OnClickListener {

    private lateinit var viewModel: RestoratorViewModel
    private lateinit var fragmentView: View
    @Inject lateinit var factory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.appComponent.plusFragmentComponent().inject(this)

        viewModel = ViewModelProvider(this, factory).get(RestoratorViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        fragmentView = layoutInflater.inflate(R.layout.fragment_login_as_restorator, container, false)
        fragmentView.button_login_as_restorator.setOnClickListener(this)
        return fragmentView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RestoratorViewModel::class.java)
        viewModel.restorator.observe(viewLifecycleOwner, Observer { restorator ->
            if (restorator != null) {
                App.restorator = restorator
                val intent = Intent(activity, RestoratorMainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
            }
            else {
                Toast.makeText(fragmentView.context, "Логин и пароль не совпадают!", Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onClick(v: View?) {
        val email = fragmentView.edit_text_email.text.toString()
        val password = fragmentView.edit_text_password.text.toString()

        if (email.isNotEmpty() && password.isNotEmpty()) {
            viewModel.tryLogin(email, password)
        }
        else {
            Toast.makeText(context, "Заполните все поля!", Toast.LENGTH_LONG).show()
        }
    }
}
