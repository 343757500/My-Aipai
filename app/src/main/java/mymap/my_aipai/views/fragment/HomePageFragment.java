package mymap.my_aipai.views.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import mymap.my_aipai.R;
import mymap.my_aipai.adapter.HomeAdapter;
import mymap.my_aipai.base.BaseFragment;
import mymap.my_aipai.bean.pageData;
import mymap.my_aipai.module.ResultState;
import mymap.my_aipai.protocol.HomePageProtocol;
import mymap.my_aipai.utils.CommonUtil;

/**
 * Created by Administrator on 2017/9/21.
 */

public class HomePageFragment extends BaseFragment implements View.OnClickListener {
    /** RecyclerView显示的数据集合 */
    private List listData = new ArrayList();
    private pageData datas;
    private RecyclerView recycle;
    private HomeAdapter homeAdapter;

    @Override
    public void onClick(View v) {

    }

    @Override
    protected ResultState onSubLoad() {
        //HomeDetailProtocol
        HomePageProtocol protocol = new HomePageProtocol();
        //传递包名
        datas = protocol.getData(0);
        //设置数据
        CommonUtil.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                initAdapter();
                listData.add(datas);
                homeAdapter.setDatas(listData);
            }
        });

        //检测状态
        if (datas == null) {
            return ResultState.LOAD_ERROR;
        } else {
            if (datas.getData().getTabList().size() == 0) {
                return ResultState.LOAD_EMPTY;
            } else {
                return ResultState.LOAD_SUCCESS;
            }
        }

    }

    @Override
    public View onSubCreateSuccessView() {
        View view = CommonUtil.inflate(R.layout.fragment_home_page);
        recycle = (RecyclerView) view.findViewById(R.id.recycle);

        return view;
    }

    private void initAdapter() {
        recycle.setLayoutManager(new LinearLayoutManager(mContext));
        homeAdapter = new HomeAdapter(getActivity(), null);
        recycle.setAdapter(homeAdapter);



}



}
