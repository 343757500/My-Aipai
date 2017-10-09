package mymap.my_aipai.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/9/30.
 */

public class videoDetialBean {
    /**
     * code : 0
     * data : {"assetInfo":{"id":"46881828","title":"王者那点事：带你走近周边商城","flv":"http://hc46.aipai.com/user/150/63932150/1006/card/46881828/card.mp4?l=q","flv480":"http://hc46.aipai.com/user/150/63932150/1006/card/46881828/card.mp4?l=q","flv720":"http://hc46.aipai.com/user/150/63932150/1006/card/46881828/card_480.mp4?l=v","flv1080":"http://hc46.aipai.com/user/150/63932150/1006/card/46881828/card_720.mp4?l=v","game":"王者荣耀","gameid":52350,"appId":11616,"adwords":"本期视频为大家带来关于周边商城的那点事，谢谢大家的支持。","quality":16,"isClass":1,"class":1,"infoFile":"http://hc46.aipai.com/user/150/63932150/1006/card/46881828/info.xml","shareUrl":"http://www.aipai.com/c46/OjkoKSMrJi1qJWQuLg.html","fileSize":73587284,"share":1,"audit":1,"videoBigPic":"http://hc46.aipai.com/user/150/63932150/1006/card/46881828/46881828_800fix.jpg","mobileInfo":"","goldenMobilePlayer":0,"hyId":0,"click":24735,"saveTime":1506569196,"totalTime":234,"playInfo":{"height":360,"width":640}},"userInfo":{"userPic":"http://fu1.aipai.com/account/150/63932150/account/63932150_normal.jpg","bid":"63932150","nickname":"王者那点事","userType":0,"fansCount":2200,"status":"0","type":"0","gender":1,"worksCount":11}}
     */

    private int code;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * assetInfo : {"id":"46881828","title":"王者那点事：带你走近周边商城","flv":"http://hc46.aipai.com/user/150/63932150/1006/card/46881828/card.mp4?l=q","flv480":"http://hc46.aipai.com/user/150/63932150/1006/card/46881828/card.mp4?l=q","flv720":"http://hc46.aipai.com/user/150/63932150/1006/card/46881828/card_480.mp4?l=v","flv1080":"http://hc46.aipai.com/user/150/63932150/1006/card/46881828/card_720.mp4?l=v","game":"王者荣耀","gameid":52350,"appId":11616,"adwords":"本期视频为大家带来关于周边商城的那点事，谢谢大家的支持。","quality":16,"isClass":1,"class":1,"infoFile":"http://hc46.aipai.com/user/150/63932150/1006/card/46881828/info.xml","shareUrl":"http://www.aipai.com/c46/OjkoKSMrJi1qJWQuLg.html","fileSize":73587284,"share":1,"audit":1,"videoBigPic":"http://hc46.aipai.com/user/150/63932150/1006/card/46881828/46881828_800fix.jpg","mobileInfo":"","goldenMobilePlayer":0,"hyId":0,"click":24735,"saveTime":1506569196,"totalTime":234,"playInfo":{"height":360,"width":640}}
         * userInfo : {"userPic":"http://fu1.aipai.com/account/150/63932150/account/63932150_normal.jpg","bid":"63932150","nickname":"王者那点事","userType":0,"fansCount":2200,"status":"0","type":"0","gender":1,"worksCount":11}
         */

        private AssetInfoBean assetInfo;
        private UserInfoBean userInfo;

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

        public static class AssetInfoBean {
            /**
             * id : 46881828
             * title : 王者那点事：带你走近周边商城
             * flv : http://hc46.aipai.com/user/150/63932150/1006/card/46881828/card.mp4?l=q
             * flv480 : http://hc46.aipai.com/user/150/63932150/1006/card/46881828/card.mp4?l=q
             * flv720 : http://hc46.aipai.com/user/150/63932150/1006/card/46881828/card_480.mp4?l=v
             * flv1080 : http://hc46.aipai.com/user/150/63932150/1006/card/46881828/card_720.mp4?l=v
             * game : 王者荣耀
             * gameid : 52350
             * appId : 11616
             * adwords : 本期视频为大家带来关于周边商城的那点事，谢谢大家的支持。
             * quality : 16
             * isClass : 1
             * class : 1
             * infoFile : http://hc46.aipai.com/user/150/63932150/1006/card/46881828/info.xml
             * shareUrl : http://www.aipai.com/c46/OjkoKSMrJi1qJWQuLg.html
             * fileSize : 73587284
             * share : 1
             * audit : 1
             * videoBigPic : http://hc46.aipai.com/user/150/63932150/1006/card/46881828/46881828_800fix.jpg
             * mobileInfo :
             * goldenMobilePlayer : 0
             * hyId : 0
             * click : 24735
             * saveTime : 1506569196
             * totalTime : 234
             * playInfo : {"height":360,"width":640}
             */

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
            @SerializedName("class")
            private int classX;
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
            private PlayInfoBean playInfo;

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

            public int getClassX() {
                return classX;
            }

            public void setClassX(int classX) {
                this.classX = classX;
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

            public PlayInfoBean getPlayInfo() {
                return playInfo;
            }

            public void setPlayInfo(PlayInfoBean playInfo) {
                this.playInfo = playInfo;
            }

            public static class PlayInfoBean {
                /**
                 * height : 360
                 * width : 640
                 */

                private int height;
                private int width;

                public int getHeight() {
                    return height;
                }

                public void setHeight(int height) {
                    this.height = height;
                }

                public int getWidth() {
                    return width;
                }

                public void setWidth(int width) {
                    this.width = width;
                }
            }
        }

        public static class UserInfoBean {
            /**
             * userPic : http://fu1.aipai.com/account/150/63932150/account/63932150_normal.jpg
             * bid : 63932150
             * nickname : 王者那点事
             * userType : 0
             * fansCount : 2200
             * status : 0
             * type : 0
             * gender : 1
             * worksCount : 11
             */

            private String userPic;
            private String bid;
            private String nickname;
            private int userType;
            private int fansCount;
            private String status;
            private String type;
            private int gender;
            private int worksCount;

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

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
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
        }
    }
}
