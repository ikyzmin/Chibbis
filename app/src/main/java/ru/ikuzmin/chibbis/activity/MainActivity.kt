package ru.ikuzmin.chibbis.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationMenu
import com.google.android.material.bottomnavigation.BottomNavigationView
import ru.ikuzmin.chibbis.ChibbisMainPresenter
import ru.ikuzmin.chibbis.MainView
import ru.ikuzmin.chibbis.R
import ru.ikuzmin.chibbis.routes.ChibbisMainRouter
import ru.ikuzmin.chibbis.routes.HitsRoute
import ru.ikuzmin.chibbis.routes.RestaurantsRoute
import ru.ikuzmin.chibbis.routes.ReviewsRoute

class MainActivity : AppCompatActivity(), MainView {

    private val router = ChibbisMainRouter()
    private val presenter = ChibbisMainPresenter()
    private lateinit var bottomNavigationView: BottomNavigationView
    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.item_restaurants -> presenter.restaurantsSelected()
                R.id.item_hits -> presenter.hitsSelected()
                R.id.item_reviews -> presenter.reviewsSelected()
            }
            true
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.a_main)
        presenter.init(this)
        bottomNavigationView = findViewById(R.id.bottom_bar)
        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }

    override fun showRestaurants() {
        router.route(RestaurantsRoute(R.id.container, supportFragmentManager))
    }

    override fun showReviews() {
        router.route(ReviewsRoute(R.id.container, supportFragmentManager))
    }

    override fun showHits() {
        router.route(HitsRoute(R.id.container, supportFragmentManager))
    }
}