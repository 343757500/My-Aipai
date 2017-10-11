package mymap.my_aipai.payler;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by devin on 2017/1/13.
 */

public class CommonRedPacketEntity implements Parcelable {

    /**
     * nickname : 测试内容61wy
     * left : 33884
     * avatar : 测试内容h3h8
     * bid : 测试内容064u
     * count : 87215
     */

    private String nickname;
    private String avatar;
    private String bid;
    private int id;
    private int count;
    private int left;
    private String title;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nickname);
        dest.writeString(this.avatar);
        dest.writeString(this.bid);
        dest.writeInt(this.id);
        dest.writeInt(this.count);
        dest.writeInt(this.left);
        dest.writeString(this.title);
    }

    public CommonRedPacketEntity() {
    }

    protected CommonRedPacketEntity(Parcel in) {
        this.nickname = in.readString();
        this.avatar = in.readString();
        this.bid = in.readString();
        this.id = in.readInt();
        this.count = in.readInt();
        this.left = in.readInt();
        this.title = in.readString();
    }

    public static final Creator<CommonRedPacketEntity> CREATOR = new Creator<CommonRedPacketEntity>() {
        @Override
        public CommonRedPacketEntity createFromParcel(Parcel source) {
            return new CommonRedPacketEntity(source);
        }

        @Override
        public CommonRedPacketEntity[] newArray(int size) {
            return new CommonRedPacketEntity[size];
        }
    };
}
