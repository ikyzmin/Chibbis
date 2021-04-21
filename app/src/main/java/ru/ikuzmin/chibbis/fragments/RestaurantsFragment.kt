package ru.ikuzmin.chibbis.fragments

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.AppBarLayout
import ru.ikuzmin.chibbis.ChibbisApp
import ru.ikuzmin.chibbis.R
import ru.ikuzmin.chibbis.views.RestaurantsAdapter
import ru.ikuzmin.db.repository.DbRestarauntsRepository
import ru.ikuzmin.domain.model.Restaraunt
import ru.ikuzmin.remote.repository.RemoteRestarauntsRepository
import ru.ikuzmin.remote.service.CommonChibbisServiceProvider
import ru.ikuzmin.sync.interactors.ChibbisRestaurantsInteractor

class RestaurantsFragment : Fragment(), RestarauntsView, SearchView.OnQueryTextListener {

    lateinit var recyclerView: RecyclerView
    lateinit var progress: ProgressBar
    lateinit var presenter: RestaurantsPresenter
    lateinit var adapter: RestaurantsAdapter
    lateinit var appBar: AppBarLayout
    lateinit var toolbar: Toolbar

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.f_restaurants, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.search_menu, menu)
        val searchItem: MenuItem? = menu.findItem(R.id.action_search)
        val searchView: SearchView = searchItem?.actionView as SearchView
        searchView.setOnQueryTextListener(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = ChibbisRestaurantPresenter(
            ChibbisRestaurantsInteractor(
                DbRestarauntsRepository(ChibbisApp.instance.restaurantsDao()),
                RemoteRestarauntsRepository(CommonChibbisServiceProvider())
            )
        )
        recyclerView = view.findViewById(R.id.restaurants_list)
        appBar = view.findViewById(R.id.appBarLayout)
        toolbar = view.findViewById(R.id.toolbar)
        progress = view.findViewById(R.id.progress)
        adapter = RestaurantsAdapter(requireContext())
        (requireActivity() as AppCompatActivity).setSupportActionBar(toolbar)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter
        presenter.init(this)
        presenter.loadRestaurants()

    }

    override fun showProgress() {
        progress.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progress.visibility = View.GONE
    }

    override fun showRestaurants(restaurants: List<Restaraunt>) {
        recyclerView.visibility = View.VISIBLE
        adapter.setItems(restaurants)
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        adapter.filter(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        adapter.filter(newText)
        return true
    }
}