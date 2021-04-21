package ru.ikuzmin.chibbis.routes

import androidx.annotation.IdRes
import androidx.fragment.app.FragmentManager
import ru.ikuzmin.chibbis.fragments.RestaurantsFragment
import ru.ikuzmin.chibbis.fragments.ReviewsFragment

class ReviewsRoute(
    @IdRes private val containerId: Int,
    private val fragmentManager: FragmentManager
) : Route {
    override fun tag(): String {
        return "Reviews"
    }

    override fun name(): String {
        return "Reviews"
    }

    override fun show() {
        fragmentManager.beginTransaction().replace(containerId, ReviewsFragment(), tag()).commit()
    }
}