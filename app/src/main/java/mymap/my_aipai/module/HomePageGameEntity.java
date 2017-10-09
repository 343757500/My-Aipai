package mymap.my_aipai.module;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 首页tab标题Entity
 * Created by devin on 2017/1/5.
 */

public class HomePageGameEntity implements Parcelable {
    private String gameName = "CF";
    private int gameId = 1106;
    private int gameType = 1;//1 手游 2PC
    private String url = "http://m.aipai.com/mobile/game_action-game_gameid-1106.html";
    private String gameIcon;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getGameType() {
        return gameType;
    }

    public void setGameType(int gameType) {
        this.gameType = gameType;
    }

    public String getGameIcon() {
        return gameIcon;
    }

    public void setGameIcon(String gameIcon) {
        this.gameIcon = gameIcon;
    }

    public HomePageGameEntity() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.gameName);
        dest.writeInt(this.gameId);
        dest.writeInt(this.gameType);
        dest.writeString(this.url);
        dest.writeString(this.gameIcon);
    }

    protected HomePageGameEntity(Parcel in) {
        this.gameName = in.readString();
        this.gameId = in.readInt();
        this.gameType = in.readInt();
        this.url = in.readString();
        this.gameIcon = in.readString();
    }

    public static final Creator<HomePageGameEntity> CREATOR = new Creator<HomePageGameEntity>() {
        @Override
        public HomePageGameEntity createFromParcel(Parcel source) {
            return new HomePageGameEntity(source);
        }

        @Override
        public HomePageGameEntity[] newArray(int size) {
            return new HomePageGameEntity[size];
        }
    };
}
