package mymap.my_aipai.bean;

import android.os.Parcel;
import android.os.Parcelable;


import java.util.ArrayList;
import java.util.List;

import mymap.my_aipai.payler.VideoGiftListEntity;

/**
 * 新的VideoInfo的替代类
 * Created by devin on 16/10/11.
 */

public class VideoDetailInfo implements Parcelable {

    /**
     * id : 43804987
     * title : 王者荣耀德古拉：肉的人神共愤能打能抗
     * flv : http://hc31.aipai.com/user/128/31977128/6009407/card/43804987/card.mp4?l=h
     * flv480 : http://hc31.aipai.com/user/128/31977128/6009407/card/43804987/card.mp4?l=h
     * flv720 : http://hc31.aipai.com/user/128/31977128/6009407/card/43804987/card.mp4?l=l
     * flv1080 :
     * game : 王者荣耀
     * gameid : 52350
     * appId : 11616
     * adwords : 德古拉 粉丝QQ一群：216514423（已满）； 粉丝QQ二群： 15492778；订阅我收看首发更新，喜欢视频请把它分享给你的朋友！ 欢迎大家收看德古拉解说王者荣耀手游，手机上的LOL， 这里有最好玩的王者荣耀解说。尽情【订阅】【收藏】【点赞】【分享】
     * quality : 15
     * isClass : 1
     * infoFile : http://hc31.aipai.com/user/128/31977128/6009407/card/43804987/info.xml
     * shareUrl : http://shouyou.aipai.com/c31/OjwoISYqLCJqJWQoKQ.html
     * fileSize : 102138796
     * share : 1
     * audit : 1
     * videoBigPic : http://hc31.aipai.com/user/128/31977128/6009407/card/43804987/43804987_800fix.jpg
     * mobileInfo :
     * goldenMobilePlayer : 0
     * hyId : 0
     * click : 16282
     * saveTime : 1476040489
     */

    private AssetInfoBean assetInfo;
    /**
     * userPic : http://fu1.aipai.com/account/128/31977128/account/31977128_normal.jpg
     * bid : 31977128
     * nickname : Dracula
     * userType : 3
     * fansCount : 2809
     * gender : 1
     * worksCount : 2772
     */

    private UserInfoBean userInfo;

    /**片头赞助商列表数据**/
    private List<VideoGiftListEntity.SponsorListBean> sponsorList;


    public AssetInfoBean getAssetInfo() {
        return assetInfo;
    }

    public void setAssetInfo(AssetInfoBean assetInfo) {
        this.assetInfo = assetInfo;
    }

    public UserInfoBean getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfoBean userInfo) {
        this.userInfo = userInfo;
    }

    public List<VideoGiftListEntity.SponsorListBean> getSponsorList() {
        return sponsorList;
    }

    public void setSponsorList(List<VideoGiftListEntity.SponsorListBean> sponsorList) {
        this.sponsorList = sponsorList;
    }

    public static class AssetInfoBean implements Parcelable {
        private String id;
        private String title;
        private String flv;
        private String flv480;
        private String flv720;
        private String flv1080;
        private String game;
        private int gameid;
        private int appId;
        private String adwords;
        private int quality;
        private int isClass;
        private String infoFile;
        private String shareUrl;
        private int fileSize;
        private int share;
        private int audit;
        private String videoBigPic;
        private String mobileInfo;
        private int goldenMobilePlayer;
        private int hyId;
        private int click;
        private int saveTime;
        private int totalTime;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getFlv() {
            return flv;
        }

        public void setFlv(String flv) {
            this.flv = flv;
        }

        public String getFlv480() {
            return flv480;
        }

        public void setFlv480(String flv480) {
            this.flv480 = flv480;
        }

        public String getFlv720() {
            return flv720;
        }

        public void setFlv720(String flv720) {
            this.flv720 = flv720;
        }

        public String getFlv1080() {
            return flv1080;
        }

        public void setFlv1080(String flv1080) {
            this.flv1080 = flv1080;
        }

        public String getGame() {
            return game;
        }

        public void setGame(String game) {
            this.game = game;
        }

        public int getGameid() {
            return gameid;
        }

        public void setGameid(int gameid) {
            this.gameid = gameid;
        }

        public int getAppId() {
            return appId;
        }

        public void setAppId(int appId) {
            this.appId = appId;
        }

        public String getAdwords() {
            return adwords;
        }

        public void setAdwords(String adwords) {
            this.adwords = adwords;
        }

        public int getQuality() {
            return quality;
        }

        public void setQuality(int quality) {
            this.quality = quality;
        }

        public int getIsClass() {
            return isClass;
        }

        public void setIsClass(int isClass) {
            this.isClass = isClass;
        }

        public String getInfoFile() {
            return infoFile;
        }

        public void setInfoFile(String infoFile) {
            this.infoFile = infoFile;
        }

        public String getShareUrl() {
            return shareUrl;
        }

        public void setShareUrl(String shareUrl) {
            this.shareUrl = shareUrl;
        }

        public int getFileSize() {
            return fileSize;
        }

        public void setFileSize(int fileSize) {
            this.fileSize = fileSize;
        }

        public int getShare() {
            return share;
        }

        public void setShare(int share) {
            this.share = share;
        }

        public int getAudit() {
            return audit;
        }

        public void setAudit(int audit) {
            this.audit = audit;
        }

        public String getVideoBigPic() {
            return videoBigPic;
        }

        public void setVideoBigPic(String videoBigPic) {
            this.videoBigPic = videoBigPic;
        }

        public String getMobileInfo() {
            return mobileInfo;
        }

        public void setMobileInfo(String mobileInfo) {
            this.mobileInfo = mobileInfo;
        }

        public int getGoldenMobilePlayer() {
            return goldenMobilePlayer;
        }

        public void setGoldenMobilePlayer(int goldenMobilePlayer) {
            this.goldenMobilePlayer = goldenMobilePlayer;
        }

        public int getHyId() {
            return hyId;
        }

        public void setHyId(int hyId) {
            this.hyId = hyId;
        }

        public int getClick() {
            return click;
        }

        public void setClick(int click) {
            this.click = click;
        }

        public int getSaveTime() {
            return saveTime;
        }

        public void setSaveTime(int saveTime) {
            this.saveTime = saveTime;
        }

        public int getTotalTime() {
            return totalTime;
        }

        public void setTotalTime(int totalTime) {
            this.totalTime = totalTime;
        }


        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.id);
            dest.writeString(this.title);
            dest.writeString(this.flv);
            dest.writeString(this.flv480);
            dest.writeString(this.flv720);
            dest.writeString(this.flv1080);
            dest.writeString(this.game);
            dest.writeInt(this.gameid);
            dest.writeInt(this.appId);
            dest.writeString(this.adwords);
            dest.writeInt(this.quality);
            dest.writeInt(this.isClass);
            dest.writeString(this.infoFile);
            dest.writeString(this.shareUrl);
            dest.writeInt(this.fileSize);
            dest.writeInt(this.share);
            dest.writeInt(this.audit);
            dest.writeString(this.videoBigPic);
            dest.writeString(this.mobileInfo);
            dest.writeInt(this.goldenMobilePlayer);
            dest.writeInt(this.hyId);
            dest.writeInt(this.click);
            dest.writeInt(this.saveTime);
            dest.writeInt(this.totalTime);
        }

        public AssetInfoBean() {
        }

        protected AssetInfoBean(Parcel in) {
            this.id = in.readString();
            this.title = in.readString();
            this.flv = in.readString();
            this.flv480 = in.readString();
            this.flv720 = in.readString();
            this.flv1080 = in.readString();
            this.game = in.readString();
            this.gameid = in.readInt();
            this.appId = in.readInt();
            this.adwords = in.readString();
            this.quality = in.readInt();
            this.isClass = in.readInt();
            this.infoFile = in.readString();
            this.shareUrl = in.readString();
            this.fileSize = in.readInt();
            this.share = in.readInt();
            this.audit = in.readInt();
            this.videoBigPic = in.readString();
            this.mobileInfo = in.readString();
            this.goldenMobilePlayer = in.readInt();
            this.hyId = in.readInt();
            this.click = in.readInt();
            this.saveTime = in.readInt();
            this.totalTime = in.readInt();
        }

        public static final Creator<AssetInfoBean> CREATOR = new Creator<AssetInfoBean>() {
            @Override
            public AssetInfoBean createFromParcel(Parcel source) {
                return new AssetInfoBean(source);
            }

            @Override
            public AssetInfoBean[] newArray(int size) {
                return new AssetInfoBean[size];
            }
        };

        @Override
        public String toString() {
            return "AssetInfoBean{" +
                    "id='" + id + '\'' +
                    ", title='" + title + '\'' +
                    ", flv='" + flv + '\'' +
                    ", flv480='" + flv480 + '\'' +
                    ", flv720='" + flv720 + '\'' +
                    ", flv1080='" + flv1080 + '\'' +
                    ", game='" + game + '\'' +
                    ", gameid=" + gameid +
                    ", appId=" + appId +
                    ", adwords='" + adwords + '\'' +
                    ", quality=" + quality +
                    ", isClass=" + isClass +
                    ", infoFile='" + infoFile + '\'' +
                    ", shareUrl='" + shareUrl + '\'' +
                    ", fileSize=" + fileSize +
                    ", share=" + share +
                    ", audit=" + audit +
                    ", videoBigPic='" + videoBigPic + '\'' +
                    ", mobileInfo='" + mobileInfo + '\'' +
                    ", goldenMobilePlayer=" + goldenMobilePlayer +
                    ", hyId=" + hyId +
                    ", click=" + click +
                    ", saveTime=" + saveTime +
                    ", totalTime=" + totalTime +
                    '}';
        }
    }

    /**
     * 注意，fansCount和isFans这两个值需要实时数据，参考@VideoDetailDirectEntity，需要请求回来后赋值
     */
    public static class UserInfoBean implements Parcelable {
        private String userPic;
        private String bid;
        private String nickname="";
        private int userType;
        private int fansCount;
        private int gender;
        private int worksCount;
        private int isFans = 0;

        public int getIsFans() {
            return isFans;
        }

        public void setIsFans(int isFans) {
            this.isFans = isFans;
        }

        public String getUserPic() {
            return userPic;
        }

        public void setUserPic(String userPic) {
            this.userPic = userPic;
        }

        public String getBid() {
            return bid;
        }

        public void setBid(String bid) {
            this.bid = bid;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public int getUserType() {
            return userType;
        }

        public void setUserType(int userType) {
            this.userType = userType;
        }

        public int getFansCount() {
            return fansCount;
        }

        public void setFansCount(int fansCount) {
            this.fansCount = fansCount;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public int getWorksCount() {
            return worksCount;
        }

        public void setWorksCount(int worksCount) {
            this.worksCount = worksCount;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.userPic);
            dest.writeString(this.bid);
            dest.writeString(this.nickname);
            dest.writeInt(this.userType);
            dest.writeInt(this.fansCount);
            dest.writeInt(this.gender);
            dest.writeInt(this.worksCount);
            dest.writeInt(this.isFans);
        }

        public UserInfoBean() {
        }

        protected UserInfoBean(Parcel in) {
            this.userPic = in.readString();
            this.bid = in.readString();
            this.nickname = in.readString();
            this.userType = in.readInt();
            this.fansCount = in.readInt();
            this.gender = in.readInt();
            this.worksCount = in.readInt();
            this.isFans = in.readInt();
        }

        public static final Creator<UserInfoBean> CREATOR = new Creator<UserInfoBean>() {
            @Override
            public UserInfoBean createFromParcel(Parcel source) {
                return new UserInfoBean(source);
            }

            @Override
            public UserInfoBean[] newArray(int size) {
                return new UserInfoBean[size];
            }
        };
    }

    public VideoDetailInfo() {
    }

    public VideoDetailInfo(AssetInfoBean assetInfo, UserInfoBean userInfo) {
        this.assetInfo = assetInfo;
        this.userInfo = userInfo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.assetInfo, flags);
        dest.writeParcelable(this.userInfo, flags);
        dest.writeList(this.sponsorList);
    }

    protected VideoDetailInfo(Parcel in) {
        this.assetInfo = in.readParcelable(AssetInfoBean.class.getClassLoader());
        this.userInfo = in.readParcelable(UserInfoBean.class.getClassLoader());
        this.sponsorList = new ArrayList<VideoGiftListEntity.SponsorListBean>();
        in.readList(this.sponsorList, VideoGiftListEntity.SponsorListBean.class.getClassLoader());
    }

    public static final Creator<VideoDetailInfo> CREATOR = new Creator<VideoDetailInfo>() {
        @Override
        public VideoDetailInfo createFromParcel(Parcel source) {
            return new VideoDetailInfo(source);
        }

        @Override
        public VideoDetailInfo[] newArray(int size) {
            return new VideoDetailInfo[size];
        }
    };
}