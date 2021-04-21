package ru.ikuzmin.chibbis.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.core.app.SharedElementCallback
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import ru.ikuzmin.chibbis.ChibbisApp
import ru.ikuzmin.chibbis.R
import ru.ikuzmin.chibbis.views.HitsAdapter
import ru.ikuzmin.db.repository.DbHitsRepository
import ru.ikuzmin.domain.model.Hit
import ru.ikuzmin.remote.repository.RemoteHitsRepository
import ru.ikuzmin.remote.service.CommonChibbisServiceProvider
import ru.ikuzmin.sync.interactors.ChibbisHitsInteractor

import ru.ikuzmin.chibbis.activity.MainActivity

import android.app.Dialog
import android.view.Window
import android.widget.ImageView
import com.squareup.picasso.Picasso


class HitsFragment : Fragment(), HitsView, SwipeRefreshLayout.OnRefreshListener,
    HitsAdapter.ItemLongClickListener {

    lateinit var recyclerView: RecyclerView
    lateinit var progressBar: ProgressBar
    lateinit var swipeRefreshLayout: SwipeRefreshLayout
    lateinit var adapter: HitsAdapter
    lateinit var presenter: HitsPresenter
    lateinit var  nagDialog :Dialog

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.f_hits, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.hits_list)
        progressBar = view.findViewById(R.id.progress)
        swipeRefreshLayout = view.findViewById(R.id.swipe_refresh)
        swipeRefreshLayout.setOnRefreshListener(this)
        adapter = HitsAdapter(requireContext(), this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        presenter = ChibbisHitsPresenter(
            ChibbisHitsInteractor(
                DbHitsRepository(ChibbisApp.instance.hitsDao()),
                RemoteHitsRepository(CommonChibbisServiceProvider())
            )
        )
        nagDialog = Dialog(
            requireContext(),
            android.R.style.Theme_Material_Dialog
        )
        presenter.init(this)
        presenter.loadHits(false)
    }

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBar.visibility = View.GONE
    }

    override fun showUpdate() {
        swipeRefreshLayout.isRefreshing = true
    }

    override fun hideUpdate() {
        swipeRefreshLayout.isRefreshing = false
    }

    override fun showHits(hits: List<Hit>) {
        swipeRefreshLayout.visibility = View.VISIBLE
        adapter.setItem(hits)
    }

    override fun onRefresh() {
        presenter.loadHits(true)
    }

    override fun onLongClicked(v: View, item: Hit) {
        nagDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        nagDialog.setCancelable(false)
        nagDialog.setContentView(R.layout.f_hit_image)
        val ivPreview = nagDialog.findViewById(R.id.hit_image) as ImageView
        Picasso.get().load(item.productImageURL).fit().into(ivPreview)
        nagDialog.show()
    }

    override fun onReleased() {
        nagDialog.dismiss()
        nagDialog = Dialog(
            requireContext(),
            android.R.style.Theme_Material_Dialog
        )
    }
}