package wit.menuapp.activities

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.MenuItem
import androidx.core.view.GravityCompat
import kotlinx.android.synthetic.main.activity_main.*
import wit.menuapp.*
import wit.menuapp.fragments.DrinkFragment
import wit.menuapp.fragments.FoodFragment
import wit.menuapp.fragments.FoodList
import wit.menuapp.fragments.MealFragment

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    setSupportActionBar(findViewById(R.id.toolbar))

    supportFragmentManager.beginTransaction()
     .replace(R.id.frameLayout, FoodList())
     .commit()

    navigationView.setNavigationItemSelectedListener {
      when (it.itemId){
        R.id.nav_allfood -> {
            supportFragmentManager.beginTransaction()
              .replace(R.id.frameLayout, FoodList())
              .commit()
        }
        R.id.nav_meal -> {
          supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout, MealFragment())
            .commit()
        }
        R.id.nav_food -> {
          supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout, FoodFragment())
            .commit()
        }
        R.id.nav_drink -> {
          supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout, DrinkFragment())
            .commit()
        }
      }
      it.isChecked= true
      drawerLayout.closeDrawers()
      true
    }


    supportActionBar?.apply {
      setDisplayHomeAsUpEnabled(true)
      setHomeAsUpIndicator(R.drawable.ic_menuicon)
    }

    findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
      Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
          .setAction("Action", null).show()
    }
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
           drawerLayout.openDrawer(GravityCompat.START)
    return true
  }
    }
