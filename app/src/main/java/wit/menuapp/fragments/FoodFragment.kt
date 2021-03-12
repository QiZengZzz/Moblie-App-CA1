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

class FoodFragment: Fragment(), FoodInfoListener {
    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.food_list,container,false)

        val allfoodItems = FoodData().allFoodItems()
        val foodItems = ArrayList<FoodItem>()

        allfoodItems.forEach {
            if (it.type.contains("food",true)){
                foodItems.add(it)
            }
        }
        print(foodItems)

        root.menuRecyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = MenuAdapter(foodItems,this@FoodFragment)
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