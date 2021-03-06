package groshevdg.foodex.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import groshevdg.foodex.App
import groshevdg.foodex.R
import groshevdg.foodex.di.factory.ViewModelFactory
import groshevdg.foodex.ui.mainActivity.client.ClientMainActivity
import groshevdg.foodex.ui.viewModel.ClientViewModel
import kotlinx.android.synthetic.main.fragment_login_as_client.view.*
import javax.inject.Inject

class LoginAsClientFragment : Fragment(), View.OnClickListener {
    private lateinit var viewModel: ClientViewModel
    private lateinit var fragmentView: View
    @Inject lateinit var factory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.appComponent.plusFragmentComponent().inject(this)
        viewModel = ViewModelProvider(this, factory).get(ClientViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        fragmentView = inflater.inflate(R.layout.fragment_login_as_client, container, false)
        fragmentView.button_login_as_client.setOnClickListener(this)
        return fragmentView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ClientViewModel::class.java)
        viewModel.client.observe(viewLifecycleOwner, Observer { client ->
            if (client != null) {
                val intent = Intent(activity, ClientMainActivity::class.java)
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
