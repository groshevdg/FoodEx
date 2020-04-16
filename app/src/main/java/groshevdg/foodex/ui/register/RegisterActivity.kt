package groshevdg.foodex.ui.register

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import butterknife.BindView
import butterknife.ButterKnife
import com.google.android.material.tabs.TabLayout
import groshevdg.foodex.R

class RegisterActivity : AppCompatActivity() {
    @BindView(R.id.tabs)
    lateinit var tabs: TabLayout

    @BindView(R.id.view_pager_register)
    lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        ButterKnife.bind(this)

        viewPager.adapter = RegisterViewPagerAdapter(supportFragmentManager, 0)
        tabs.setupWithViewPager(viewPager)
        tabs.getTabAt(0)?.text = resources.getString(R.string.tab_client)
        tabs.getTabAt(1)?.text = resources.getString(R.string.tab_restorator)
    }
}
