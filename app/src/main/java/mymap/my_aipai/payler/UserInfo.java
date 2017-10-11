package mymap.my_aipai.payler;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Veigar on 16/8/8.
 */
public class UserInfo implements Parcelable {
    public String bid = "";
    public String sid = "";
    public String nickname = "";
    public int gender = 0;
    public String level = "";
    public int status = -1;
    public int type = -1;
    public String middle = "";
    public String big = "";
    public String normal = "";
    public String thumbFileName = "";
    public String url = "";
    public String homeUrl = "";
    public int fansCount = 0;
    public boolean isFans = false;
    public int workCount = 0;
    public String userType = "";

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.bid);
        dest.writeString(this.sid);
        dest.writeString(this.nickname);
        dest.writeInt(this.gender);
        dest.writeString(this.level);
        dest.writeInt(this.status);
        dest.writeInt(this.type);
        dest.writeString(this.middle);
        dest.writeString(this.big);
        dest.writeString(this.normal);
        dest.writeString(this.thumbFileName);
        dest.writeString(this.url);
        dest.writeString(this.homeUrl);
        dest.writeInt(this.fansCount);
        dest.writeByte(this.isFans ? (byte) 1 : (byte) 0);
        dest.writeInt(this.workCount);
        dest.writeString(this.userType);
    }

    public UserInfo() {
    }

    protected UserInfo(Parcel in) {
        this.bid = in.readString();
        this.sid = in.readString();
        this.nickname = in.readString();
        this.gender = in.readInt();
        this.level = in.readString();
        this.status = in.readInt();
        this.type = in.readInt();
        this.middle = in.readString();
        this.big = in.readString();
        this.normal = in.readString();
        this.thumbFileName = in.readString();
        this.url = in.readString();
        this.homeUrl = in.readString();
        this.fansCount = in.readInt();
        this.isFans = in.readByte() != 0;
        this.workCount = in.readInt();
        this.userType = in.readString();
    }

    public static final Parcelable.Creator<UserInfo> CREATOR = new Parcelable.Creator<UserInfo>() {
        @Override
        public UserInfo createFromParcel(Parcel source) {
            return new UserInfo(source);
        }

        @Override
        public UserInfo[] newArray(int size) {
            return new UserInfo[size];
        }
    };
}
