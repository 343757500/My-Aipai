package mymap.my_aipai.presenter;


import mymap.my_aipai.views.IView;

public interface IPresenter<V extends IView> {
    void resume();

    void pause();

    void destroy();

    void setView(V var1);
}
