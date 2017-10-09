package mymap.my_aipai.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by devin on 2017/1/4.
 */

public class TabPagerAdapter extends FragmentPagerAdapter {
    private List<String> titleList;
    private List<? extends Fragment> fragmentList;


    public TabPagerAdapter(FragmentManager fm, List<String> titleList, List<? extends Fragment> fragmentList) {
        super(fm);
        this.titleList = titleList;
        this.fragmentList = fragmentList;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (titleList != null && position >= 0 && position < titleList.size()) {
            return titleList.get(position);
        }
        return super.getPageTitle(position);
    }

    @Override
    public Fragment getItem(int position) {
        if (fragmentList != null && position >= 0 && position < fragmentList.size()) {
            return fragmentList.get(position);
        }

        return null;
    }




    @Override
    public int getCount() {
        if (fragmentList != null) {
            return fragmentList.size();
        }
        return 0;
    }
}
