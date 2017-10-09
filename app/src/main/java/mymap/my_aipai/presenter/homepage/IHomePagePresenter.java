package mymap.my_aipai.presenter.homepage;


import mymap.my_aipai.module.HomePageGameEntity;
import mymap.my_aipai.presenter.IPresenter;
import mymap.my_aipai.views.IHomePageView;

/**
 * Created by devin on 2017/1/4.
 */

public interface IHomePagePresenter extends IPresenter<IHomePageView> {
    void present();

    HomePageGameEntity getCurrentGameEntity(int i);
}
