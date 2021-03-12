package wit.menuapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.food_list.view.*
import wit.menuapp.models.FoodInfoListener

import wit.menuapp.adapters.MenuAdapter
import wit.menuapp.R
import wit.menuapp.models.FoodData
import wit.menuapp.models.FoodItem

class DrinkFragment: Fragment(), FoodInfoListener {
    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.food_list,container,false)

        val allfoodItems = FoodData().allFoodItems()
        val drinkItems = ArrayList<FoodItem>()

        allfoodItems.forEach {
            if (it.type.contains("drink",true)){
                drinkItems.add(it)
            }
        }
        print(drinkItems)

        root.menuRecyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = MenuAdapter(drinkItems,this@DrinkFragment)
        }

        return root
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