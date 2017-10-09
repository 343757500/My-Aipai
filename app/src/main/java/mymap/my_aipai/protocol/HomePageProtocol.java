package mymap.my_aipai.protocol;

import com.google.gson.Gson;

import mymap.my_aipai.base.BaseProtocol;
import mymap.my_aipai.bean.pageData;

/**
 * Created by Administrator on 2017/9/26.
 */

public class HomePageProtocol extends BaseProtocol<pageData> {
    @Override
    protected pageData parseData(String result) {
        Gson gson=new Gson();
        pageData homeJsonBean = gson.fromJson(result, pageData.class);
        return homeJsonBean;
    }

    @Override
    protected String getKey() {
        return "indexPage/pageData";
    }

    @Override
    protected String getParams() {
        return null;
    }
}
