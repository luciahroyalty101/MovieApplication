package com.moringaschool.wallview1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Build;
import android.os.Bundle;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.moringaschool.wallview1.model.MovieResults;

public class DetailActivity extends BaseActivity<ActivityDetailBinding, DetailViewModel> {
    MovieResults movie;
    boolean isFav;
    private Toolbar detailToolbar;
    private FloatingActionButton btnFav;
    private ViewPager detailViewPager;
    private TabLayout detailTabs;
    private AppBarLayout detailAppbarLayout;
    private CollapsingToolbarLayout detailCollapsingToolbarLayout;
    private DetailViewModel viewModel;

    @Override
    public int getLayoutResource() {
        return R.layout.activity_detail;
    }

    @Override
    public Class<DetailViewModel> getViewModel() {
        return DetailViewModel.class;
    }

    @Override
    protected void onCreate(Bundle instance, DetailViewModel viewModel, ActivityDetailBinding dataBinding) {
        detailToolbar = findViewById(R.id.detail_toolbar);
        btnFav = findViewById(R.id.btnfav);
        detailViewPager = findViewById(R.id.detail_viewpager);
        detailTabs = findViewById(R.id.detail_tabs);
        detailAppbarLayout = findViewById(R.id.detail_appbarlayout);
        detailCollapsingToolbarLayout = findViewById(R.id.detail_collapsing_toolbarlayout);
        this.viewModel = viewModel;
        setUpUI();
        if (getIntent().getExtras().get(Constants.EXTRA_POPULAR_MOVIES) != null) {
            movie = getIntent().getParcelableExtra(Constants.EXTRA_POPULAR_MOVIES);

            setupViewPager(movie);
            fabBehaviour(movie);
            btnFav.setOnClickListener(v -> favorite());
            checkFav();
            detailTabs.setupWithViewPager(detailViewPager);
            dataBinding.setMovie(movie);
        }
    }

    private void setUpUI() {
        setSupportActionBar(detailToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    private void setupViewPager(MovieResults movie) {
        DetailTabPageAdapter adapter = new DetailTabPageAdapter(getSupportFragmentManager(), movie);
        detailViewPager.setAdapter(adapter);
    }

    private void fabBehaviour(MovieResults movie) {
        detailAppbarLayout.addOnOffsetChangedListener((appBarLayout, verticalOffset) -> {
            if (Math.abs(verticalOffset) - appBarLayout.getTotalScrollRange() == 0) {
                btnFav.hide();
                getSupportActionBar().setDisplayShowTitleEnabled(true);
                detailToolbar.setTitle(movie.getTitle());
            } else {
                btnFav.show();
                getSupportActionBar().setDisplayShowTitleEnabled(false);
                detailToolbar.setTitle(" ");
            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            detailCollapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent, null));
        } else {
            detailCollapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));
        }
    }

    private void checkFav() {
        viewModel.getSingleMovie(movie.getMovieId()).observe(this, movieResults -> {
            if (movieResults != null) {
                btnFav.setImageDrawable(getResources().getDrawable(R.drawable.ic_fav, null));
            } else {
                btnFav.setImageDrawable(getResources().getDrawable(R.drawable.ic_favorite_border, null));
            }
        });
    }

    private void favorite() {
        if (isFav) {
            viewModel.deleteMovie(movie);
        } else {
            viewModel.insertMovie(movie);
        }
    }
}