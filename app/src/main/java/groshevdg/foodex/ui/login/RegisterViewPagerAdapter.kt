package groshevdg.foodex.ui.login

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class RegisterViewPagerAdapter(manager: FragmentManager, behavior: Int)
    : FragmentPagerAdapter(manager, behavior) {

    override fun getItem(position: Int): Fragment {
        when(position) {
            0 -> return LoginAsClientFragment.newInstance();
            1 -> return LoginAsRestoratorFragment.newInstance()
        }
        return LoginAsClientFragment.newInstance()
    }

    override fun getCount(): Int {
       return 2
    }
}