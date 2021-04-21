package ru.ikuzmin.chibbis.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import ru.ikuzmin.chibbis.ChibbisApp
import ru.ikuzmin.chibbis.R
import ru.ikuzmin.chibbis.views.ReviewAdapter
import ru.ikuzmin.db.repository.DbReviewsRepository
import ru.ikuzmin.domain.model.Review
import ru.ikuzmin.remote.repository.RemoteReviewsRepository
import ru.ikuzmin.remote.service.CommonChibbisServiceProvider
import ru.ikuzmin.sync.interactors.ChibbisReviewsInteractor

class ReviewsFragment : Fragment(), ReviewsView,SwipeRefreshLayout.OnRefreshListener {

    lateinit var progress: ProgressBar
    lateinit var swipeRefreshLayout: SwipeRefreshLayout
    lateinit var recyclerView: RecyclerView
    lateinit var presenter: ReviewsPresenter
    lateinit var adapter : ReviewAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.f_reviews, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        progress = view.findViewById(R.id.progress)
        swipeRefreshLayout = view.findViewById(R.id.swipe_refresh)
        recyclerView = view.findViewById(R.id.reviews_list)
        swipeRefreshLayout.setOnRefreshListener(this)
        presenter = ChibbisReviewsPresenter(ChibbisReviewsInteractor(DbReviewsRepository(ChibbisApp.instance.reviewsDao()),RemoteReviewsRepository(CommonChibbisServiceProvider())))
        adapter = ReviewAdapter(requireContext())
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter
        presenter.init(this)
        presenter.loadReviews(false)
    }

    override fun showProgress() {
        progress.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progress.visibility = View.GONE
    }

    override fun showUpdate() {
        swipeRefreshLayout.isRefreshing = true
    }

    override fun hideUpdate() {
        swipeRefreshLayout.isRefreshing = false
    }

    override fun showReviews(reviews: List<Review>) {
        swipeRefreshLayout.visibility = View.VISIBLE
        adapter.setItems(reviews)
    }

    override fun onRefresh() {
        presenter.loadReviews(true)
    }
}