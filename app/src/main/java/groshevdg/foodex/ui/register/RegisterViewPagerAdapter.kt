package groshevdg.foodex.ui.register

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class RegisterViewPagerAdapter(manager: FragmentManager, behavior: Int)
    : FragmentPagerAdapter(manager, behavior) {


    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> return RegisterAsClientFragment.newInstance()
            1 -> return RegisterAsRestoratorFragment.newInstance()
        }
        return RegisterAsClientFragment.newInstance()
    }

    override fun getCount(): Int {
        return 2
    }
}