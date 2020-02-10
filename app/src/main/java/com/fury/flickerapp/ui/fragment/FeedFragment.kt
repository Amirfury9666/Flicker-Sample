package com.fury.flickerapp.ui.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.fury.flickerapp.data.viewmodel.FeedViewModel
import com.fury.flickerapp.R
import com.fury.flickerapp.adapter.FeedAdapter
import com.fury.flickerapp.base.core.BaseFragment
import com.fury.flickerapp.databinding.FragmentFeedBinding
import com.fury.flickerapp.utility.getViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

const val  TAG = "tag"
class FeedFragment : BaseFragment<FragmentFeedBinding>() {

    private lateinit var mFeedViewModel: FeedViewModel
    private val mFeedAdapter = FeedAdapter()
    override val layoutResId: Int get() = R.layout.fragment_feed

    override fun onFragmentReady(instanceState: Bundle?, binding: FragmentFeedBinding) {
        activity?.let {
            mFeedViewModel = it.getViewModel()
        }

        binding.feedRecycler.adapter = mFeedAdapter

        arguments?.let {bundle ->
            val tag = bundle.getString(TAG)
            tag?.let {
                mFeedViewModel.loadFeedByTag(it)
                setUpData(it)
            }
        }

    }


    private fun setUpData(tag : String){
        CoroutineScope(Dispatchers.Main).launch {
            val feeds = mFeedViewModel.fetchFeedByTagAsyc(tag).await()
            feeds.observe(this@FeedFragment, Observer {
                if (it == null) return@Observer
                mFeedAdapter.submitList(it.feeds)
            })
        }
    }

    companion object{
        fun getNewInstance(tag : String) : Fragment{
            Bundle().also {
                it.putString(TAG,tag)
                val fragment = FeedFragment()
                fragment.arguments = it
                return fragment
            }
        }
    }
}
