package com.example.studiowedding.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.studiowedding.view.activity.services.ChildServiceFragment;

public class TabServiceAdapter extends FragmentStateAdapter {


    public TabServiceAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0 : return new ChildServiceFragment();

            case 1 : return new  ChildServiceFragment();

            default: return new ChildServiceFragment();
        }
    }



    @Override
    public int getItemCount() {
        return 2;
    }
}
