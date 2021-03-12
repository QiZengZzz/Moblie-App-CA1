package wit.menuapp.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.food_list.view.*
import kotlinx.android.synthetic.main.menu_row.*
import kotlinx.android.synthetic.main.menu_row.view.*
import wit.menuapp.models.FoodInfoListener
import wit.menuapp.R
import wit.menuapp.adapters.MenuAdapter
import wit.menuapp.models.FoodData


class FoodList : Fragment(), FoodInfoListener {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.food_list, container, false)

        val foodItems = FoodData().allFoodItems()

        root.menuRecyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = MenuAdapter(foodItems, this@FoodList)
        }

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


    override fun foodListener() {
       requireActivity().supportFragmentManager
          .beginTransaction()
           .replace(R.id.frameLayout, FoodInfoFragment(), null)
           .addToBackStack(null)
           .commit()
    }

    override fun addOrder() {

    }

}