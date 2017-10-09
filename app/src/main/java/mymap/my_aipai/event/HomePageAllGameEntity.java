package mymap.my_aipai.event;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

import mymap.my_aipai.module.HomePageGameEntity;


/**
 * Created by devin on 2017/1/11.
 */

public class HomePageAllGameEntity implements Parcelable {
    private List<HomePageGameEntity> commonList;
    private List<HomePageGameEntity> moreList;

    public List<HomePageGameEntity> getCommonList() {
        return commonList;
    }

    public void setCommonList(List<HomePageGameEntity> commonList) {
        this.commonList = commonList;
    }

    public List<HomePageGameEntity> getMoreList() {
        return moreList;
    }

    public void setMoreList(List<HomePageGameEntity> moreList) {
        this.moreList = moreList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.commonList);
        dest.writeTypedList(this.moreList);
    }

    public HomePageAllGameEntity() {
    }

    protected HomePageAllGameEntity(Parcel in) {
        this.commonList = in.createTypedArrayList(HomePageGameEntity.CREATOR);
        this.moreList = in.createTypedArrayList(HomePageGameEntity.CREATOR);
    }

    public static final Parcelable.Creator<HomePageAllGameEntity> CREATOR = new Parcelable.Creator<HomePageAllGameEntity>() {
        @Override
        public HomePageAllGameEntity createFromParcel(Parcel source) {
            return new HomePageAllGameEntity(source);
        }

        @Override
        public HomePageAllGameEntity[] newArray(int size) {
            return new HomePageAllGameEntity[size];
        }
    };
}
