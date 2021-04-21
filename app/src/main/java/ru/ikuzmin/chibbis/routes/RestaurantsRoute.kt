package ru.ikuzmin.chibbis.routes

import androidx.annotation.IdRes
import androidx.fragment.app.FragmentManager
import ru.ikuzmin.chibbis.fragments.RestaurantsFragment

class RestaurantsRoute(
    @IdRes private val containerId: Int,
    private val fragmentManager: FragmentManager
) : Route {
    override fun tag(): String {
        return "Restaurants"
    }

    override fun name(): String {
        return "Restaurants"
    }

    override fun show() {
        fragmentManager.beginTransaction().replace(containerId, RestaurantsFragment(), tag())
            .commit()
    }
}