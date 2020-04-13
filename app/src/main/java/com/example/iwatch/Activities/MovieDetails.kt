package com.example.iwatch.Activities

import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.iwatch.Entities.Movie
import com.example.iwatch.Fragments.CommentsFragment
import com.example.iwatch.Fragments.MovieDetailsFragment
import com.example.iwatch.Fragments.MovieRoomsFragment
import com.example.iwatch.R
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_movie_details.*
import kotlinx.android.synthetic.main.movie_item.*


class MovieDetails : AppCompatActivity(), MovieDetailsFragment.OnFragmentInteractionListener,
    MovieRoomsFragment.OnFragmentInteractionListener, CommentsFragment.OnFragmentInteractionListener{

    private var mSectionsPagerAdapter:SectionsPagerAdapter? = null
    private var movie: Movie? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        //enable back button on the toolbar
        movie_detail_toolbar.title = ""
        setSupportActionBar(movie_detail_toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)

        // Set up the ViewPager with the sections adapter.
        movie_view_pager.adapter = mSectionsPagerAdapter
        movie_view_pager.currentItem = 0

        movie_view_pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(movie_tabs))
        movie_tabs.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(movie_view_pager))

        //get movie
        movie = intent.getSerializableExtra("movie") as Movie

        //print movie details
        movie_detail_title.text = movie?.title
        for(i in 0..movie!!.genre?.size!!-1){
            movie_detail_genre.text = movie!!.genre?.get(i)?.genreType.toString() + ", "
        }
        movie_detail_released_date.text = movie?.dateSortie
        movie_detail_resume.text = movie?.resume
        movie_rating_bar.rating = (movie?.note + "F").toFloat()
        movie_detail_rate.text = movie?.note

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==android.R.id.home){
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /**
     * A [FragmentPagerAdapter] that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            return when (position){
                0 -> MovieDetailsFragment()
                1 -> MovieRoomsFragment()
                2 -> CommentsFragment()
                else -> Fragment()
            }
        }

        override fun getCount(): Int {
            // Show 5 total pages.
            return 3
        }

    }
}
