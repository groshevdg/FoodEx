package groshevdg.foodex.ui.mainActivity.client.dishesList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import groshevdg.foodex.R
import groshevdg.foodex.model.Dish
import groshevdg.foodex.ui.mainActivity.client.dishesList.adapter.DishesRecyclerAdapter
import kotlinx.android.synthetic.main.fragment_dishes_list.view.*

class DishesListFragment : Fragment() {

    private lateinit var dishesViewModel: DishesViewModel
    private val adapter = DishesRecyclerAdapter()
    private lateinit var fragmentView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dishesViewModel = ViewModelProvider(this).get(DishesViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        fragmentView = inflater.inflate(R.layout.fragment_dishes_list, container, false)
        fragmentView.fdlDishesRecyclerView.adapter = adapter
        val manager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
        fragmentView.fdlDishesRecyclerView.layoutManager = manager

        val list = mutableListOf<Dish>(Dish("Мясо", "https://avatars.mds.yandex.net/get-pdb/234183/d7883f96-0744-463a-997d-37eb15a2d344/s1200?webp=false", "15 руб", "150 гр"),
            Dish("abc", "", "15", "15"),
            Dish("abc", "", "15", "15"),
            Dish("abc", "https://avatars.mds.yandex.net/get-pdb/234183/d7883f96-0744-463a-997d-37eb15a2d344/s1200?webp=false", "15", "15"),
        Dish("abc", "https://avatars.mds.yandex.net/get-pdb/234183/d7883f96-0744-463a-997d-37eb15a2d344/s1200?webp=false", "15", "15"),
        Dish("abc", "https://avatars.mds.yandex.net/get-pdb/234183/d7883f96-0744-463a-997d-37eb15a2d344/s1200?webp=false", "15", "15"))


        adapter.setData(list)

        return fragmentView
    }
}
