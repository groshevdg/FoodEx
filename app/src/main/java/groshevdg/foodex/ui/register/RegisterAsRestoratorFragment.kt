package groshevdg.foodex.ui.register

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import groshevdg.foodex.App
import groshevdg.foodex.R
import groshevdg.foodex.di.factory.ViewModelFactory
import groshevdg.foodex.ui.login.LoginActivity

import groshevdg.foodex.ui.viewModel.RestoratorViewModel
import kotlinx.android.synthetic.main.fragment_register_as_client.view.*
import javax.inject.Inject

class RegisterAsRestoratorFragment : Fragment(), View.OnClickListener {

    private lateinit var viewModel: RestoratorViewModel
    @Inject lateinit var factory: ViewModelFactory
    private lateinit var fragmentView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.appComponent.plusFragmentComponent().inject(this)
        viewModel = ViewModelProvider(this, factory).get(RestoratorViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        fragmentView = inflater.inflate(R.layout.fragment_register_as_restorator, container, false)
        fragmentView.button_register.setOnClickListener(this)
        return fragmentView
    }

    override fun onClick(v: View?) {
        val email = fragmentView.edit_text_login.text.toString()
        val password = fragmentView.edit_text_password.text.toString()
        val repeatedPassword = fragmentView.edit_text_repeat_password.text.toString()
        val phone = fragmentView.edit_text_phone.text.toString()

        if (email.isNotEmpty() && password.isNotEmpty() && repeatedPassword.isNotEmpty()) {
            if (password == repeatedPassword) {
                viewModel.registerRestorator(email, password, phone)

                Toast.makeText(context, "Аккаунт успешно создан!",Toast.LENGTH_LONG).show()

                Handler().postDelayed({startActivity(Intent(activity,
                    LoginActivity::class.java))}, 1500)

            } else {
                Toast.makeText(fragmentView.context, "Пароли не совпадают!", Toast.LENGTH_LONG).show()
            }
        } else {
            Toast.makeText(fragmentView.context, "Заполните все поля!", Toast.LENGTH_LONG).show()
        }
    }
}
