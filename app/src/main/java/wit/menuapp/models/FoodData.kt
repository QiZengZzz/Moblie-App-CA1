package wit.menuapp.models

import wit.menuapp.R
import wit.menuapp.models.FoodItem

class FoodData {

    fun allFoodItems(): List<FoodItem> {
      return listOf(
          FoodItem("1","food",R.drawable.hamburger, "Beef Burger", 3.99, "Nice Beef Burger!"),
          FoodItem("2","food",R.drawable.fishburger, "Fish burger", 3.49, "Good Fish Burger!"),
          FoodItem("3","food",R.drawable.hotdog, "Chicken burger", 3.40, "Nice Chicken Burger!"),
          FoodItem("4","food",R.drawable.chickenroll, "Chicken Roll", 3.99, "Nice Chicken Roll !"),
          FoodItem("5","meal",R.drawable.burgermeal, "Burger Meal", 8.99, "Good! Burger with chips"),
          FoodItem("6","meal",R.drawable.famliymeal, "Famliy Meal", 24.99, "Good for you!"),
          FoodItem("7","drink",R.drawable.coke, "Coke", 2.50, "Coke"),
          FoodItem("8","drink",R.drawable.cokezero, "Cokezero", 2.00, "Cokezero"),
          FoodItem("9","drink",R.drawable.sevenup, "7UP", 2.00, "7UP"),
          FoodItem("10","drink",R.drawable.sprite, "Sprite", 2.20, "Sprite"),
          FoodItem("11","drink",R.drawable.coffee, "Coffee", 3.10, "Coffee"),
          FoodItem("12","drink",R.drawable.tea, "Tea", 3.00, "Tea")
      )
    }
  }



