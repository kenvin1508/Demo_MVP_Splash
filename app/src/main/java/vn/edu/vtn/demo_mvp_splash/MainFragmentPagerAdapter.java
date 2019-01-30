package vn.edu.vtn.demo_mvp_splash;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import vn.edu.vtn.demo_mvp_splash.chat.ChatFragment;
import vn.edu.vtn.demo_mvp_splash.info.InfoFragment;

public class MainFragmentPagerAdapter extends FragmentPagerAdapter {
    Context context;

    public MainFragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new ChatFragment();
            case 1:
                return new InfoFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Chat";
            case 1:
                return "Info";
            default:
                return null;
        }
    }
}
