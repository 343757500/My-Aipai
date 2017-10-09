package mymap.my_aipai.views;

/**
 * Created by devin on 2017/1/4.
 */

import android.support.v4.app.Fragment;


import java.util.List;

public interface IHomePageView extends IView {

    void updateFragmentList(List<Fragment> fragmentList, List<String> titleList);

    void setSearchKey(String searchKey);



}
