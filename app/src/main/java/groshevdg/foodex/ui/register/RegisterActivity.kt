package groshevdg.foodex.ui.register

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import groshevdg.foodex.R
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        window.statusBarColor = ContextCompat.getColor(applicationContext, R.color.colorPrimaryDark)

        view_pager_register.adapter = RegisterViewPagerAdapter(supportFragmentManager, 0)
        tabs.setupWithViewPager(view_pager_register)
        tabs.getTabAt(0)?.text = resources.getString(R.string.tab_client)
        tabs.getTabAt(1)?.text = resources.getString(R.string.tab_restorator)
    }
}
