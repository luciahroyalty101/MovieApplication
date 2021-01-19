package com.moringaschool.wallview1.adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class TabPageAdapter extends FragmentPagerAdapter {
    int TOTAL_TAB = 3;

    public TabPageAdapter(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment result = null;
        switch (position) {
            case 0:
            default:
                result = new PopularMoviesFragment();
                break;
            case 1:
                result = new TopRatedFragment();
                break;
            case 2:
                result = new FavoritesFragment();
                break;

        }
        return result;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String result = "";
        switch (position) {
            case 0:
            default:
                result = "Popular";
                break;
            case 1:
                result = "Top Rated";
                break;
            case 2:
                result = "Favorites";
                break;
        }
        return result;
    }

    @Override
    public int getCount() {
        return TOTAL_TAB;
    }
}
