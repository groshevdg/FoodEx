package groshevdg.foodex.ui.mainActivity.client.restaurants

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import groshevdg.foodex.R

class RestaurantsFragment : Fragment() {
    private lateinit var fragmentView: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentView = inflater.inflate(R.layout.fragment_restaurants, container, false)
        return fragmentView
    }
}