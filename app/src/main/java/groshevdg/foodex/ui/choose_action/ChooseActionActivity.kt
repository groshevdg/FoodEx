package groshevdg.foodex.ui.choose_action

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import butterknife.BindView
import butterknife.ButterKnife
import groshevdg.foodex.R
import groshevdg.foodex.ui.login.LoginActivity
import groshevdg.foodex.ui.register.RegisterActivity

class ChooseActionActivity : AppCompatActivity(), View.OnClickListener {
    @BindView(R.id.button_login)
    lateinit var loginBtn: Button

    @BindView(R.id.button_register)
    lateinit var registerBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_action)
        ButterKnife.bind(this)
        registerBtn.setOnClickListener(this)
        loginBtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        v?.let {
            when (it.id) {
                R.id.button_register ->
                    startActivity(Intent(this, RegisterActivity::class.java))

                R.id.button_login ->
                    startActivity(Intent(this, LoginActivity::class.java))
            }
        }
    }
}
