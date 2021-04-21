package ru.ikuzmin.chibbis.routes

import androidx.annotation.IdRes
import androidx.fragment.app.FragmentManager
import ru.ikuzmin.chibbis.fragments.HitsFragment
import ru.ikuzmin.chibbis.fragments.RestaurantsFragment

class HitsRoute(
    @IdRes private val containerId: Int,
    private val fragmentManager: FragmentManager
) : Route {
    override fun tag(): String {
        return "Hits"
    }

    override fun name(): String {
        return "Hits"
    }

    override fun show() {
        fragmentManager.beginTransaction().replace(containerId, HitsFragment(), tag()).commit()
    }
}