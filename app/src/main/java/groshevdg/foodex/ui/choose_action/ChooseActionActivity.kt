package groshevdg.foodex.ui.choose_action

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.content.ContextCompat
import groshevdg.foodex.R
import groshevdg.foodex.ui.login.LoginActivity
import groshevdg.foodex.ui.register.RegisterActivity
import kotlinx.android.synthetic.main.activity_choose_action.*

class ChooseActionActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_action)
        button_register.setOnClickListener(this)
        button_login.setOnClickListener(this)
        window.statusBarColor = ContextCompat.getColor(applicationContext, R.color.colorPrimaryDark)
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
