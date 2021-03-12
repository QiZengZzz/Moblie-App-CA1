package wit.menuapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.menu_row.view.*
import wit.menuapp.models.FoodInfoListener
import wit.menuapp.R
import wit.menuapp.models.FoodItem

class MenuAdapter (val foodItems: List<FoodItem>, private val listener: FoodInfoListener) :
    RecyclerView.Adapter<MenuAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.menu_row, parent, false)

        return ViewHolder(view)
    }
    override fun getItemCount() = foodItems.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val foodItem = foodItems[position]
        holder.imageView.setImageResource(foodItem.imageResourceId)
        holder.bind(foodItem,listener)
    }

    class ViewHolder(val view: View): RecyclerView.ViewHolder(view){
        val imageView: ImageView = view.findViewById(R.id.mainPhoto)

        fun bind(foodItem: FoodItem, listener: FoodInfoListener) {
            itemView.foodTitle.text = foodItem.name
            itemView.foodPrice.text = "$ ${foodItem.price}"
            itemView.foodDescription.text = foodItem.description

            imageView.setOnClickListener {
                listener.foodListener()
            }

            view.btnaddOrder.setOnClickListener {
                listener.addOrder()
            }

        }

    }
}