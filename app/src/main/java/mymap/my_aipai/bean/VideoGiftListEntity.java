package mymap.my_aipai.bean;

import android.os.Parcel;
import android.os.Parcelable;


import java.util.List;

import mymap.my_aipai.payler.UserInfo;

/**
 * 视频礼物榜单数据
 * Created by LinZheng on 2016/11/3.
 */
public class VideoGiftListEntity implements Parcelable {
    private MyScoreBean myScore;
    private GiftScoreTotalBean giftScoreTotal;
    private int sponsorTotal;                   // 赞助商总数
    private SponsorStatusBean sponsorStatus;    // 赞助状态
    private List<GiftScoreRankBean> giftScoreRank;
    private List<SponsorListBean> sponsorList;
    private UserNewCardBean userNewCard;
    private AllRedPacketEntity redPacket;

    public MyScoreBean getMyScore() {
        return myScore;
    }

    public GiftScoreTotalBean getGiftScoreTotal() {
        return giftScoreTotal;
    }

    public int getSponsorTotal() {
        return sponsorTotal;
    }

    public SponsorStatusBean getSponsorStatus() {
        return sponsorStatus;
    }

    public List<GiftScoreRankBean> getGiftScoreRank() {
        return giftScoreRank;
    }

    public List<SponsorListBean> getSponsorList() {
        return sponsorList;
    }

    public UserNewCardBean getUserNewCard() {
        return userNewCard;
    }

    public AllRedPacketEntity getRedPacket() {
        return redPacket;
    }

    public void setRedPacket(AllRedPacketEntity redPacket) {
        this.redPacket = redPacket;
    }

    public static class UserNewCardBean implements Parcelable {
        private String thumbFileName;
        private String url;
        private String videoId;

        protected UserNewCardBean(Parcel in) {
            thumbFileName = in.readString();
            url = in.readString();
            videoId = in.readString();
        }

        public static final Creator<UserNewCardBean> CREATOR = new Creator<UserNewCardBean>() {
            @Override
            public UserNewCardBean createFromParcel(Parcel in) {
                return new UserNewCardBean(in);
            }

            @Override
            public UserNewCardBean[] newArray(int size) {
                return new UserNewCardBean[size];
            }
        };

        public String getThumbFileName() {
            return thumbFileName;
        }

        public String getUrl() {
            return url;
        }

        public String getVideoId() {
            return videoId;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(thumbFileName);
            dest.writeString(url);
            dest.writeString(videoId);
        }
    }

    public static class MyScoreBean implements Parcelable {
        private String score;
        private String scoreFormatTenThousand;
        private int rank;

        public String getScoreFormatTenThousand() {
            return scoreFormatTenThousand;
        }

        public MyScoreBean(String score) {
            this.score = score;
        }

        public String getScore() {
            return score;
        }

        public int getRank() {
            return rank;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.score);
            dest.writeString(this.scoreFormatTenThousand);
            dest.writeInt(this.rank);
        }

        protected MyScoreBean(Parcel in) {
            this.score = in.readString();
            this.scoreFormatTenThousand = in.readString();
            this.rank = in.readInt();
        }

        public static final Creator<MyScoreBean> CREATOR = new Creator<MyScoreBean>() {
            @Override
            public MyScoreBean createFromParcel(Parcel source) {
                return new MyScoreBean(source);
            }

            @Override
            public MyScoreBean[] newArray(int size) {
                return new MyScoreBean[size];
            }
        };
    }

    public static class GiftScoreTotalBean implements Parcelable {
        private String starCoinScore;
        private String rewardScore;
        private String flowerScore;
        private String scoreTotal;
        private String apBeanScore;
        private String flowerScoreFormatTenThousand;
        private String apBeanScoreFormatTenThousand;
        private String rewardScoreFormatTenThousand;
        private String starCoinScoreFormatTenThousand;
        private String scoreTotalFormatTenThousand;

        public String getFlowerScoreFormatTenThousand() {
            return flowerScoreFormatTenThousand;
        }

        public String getApBeanScoreFormatTenThousand() {
            return apBeanScoreFormatTenThousand;
        }

        public String getRewardScoreFormatTenThousand() {
            return rewardScoreFormatTenThousand;
        }

        public String getStarCoinScoreFormatTenThousand() {
            return starCoinScoreFormatTenThousand;
        }

        public String getScoreTotalFormatTenThousand() {
            return scoreTotalFormatTenThousand;
        }

        public String getStarCoinScore() {
            return starCoinScore;
        }

        public String getRewardScore() {
            return rewardScore;
        }

        public String getFlowerScore() {
            return flowerScore;
        }

        public String getScoreTotal() {
            return scoreTotal;
        }

        public String getApBeanScore() {
            return apBeanScore;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.starCoinScore);
            dest.writeString(this.rewardScore);
            dest.writeString(this.flowerScore);
            dest.writeString(this.scoreTotal);
            dest.writeString(this.apBeanScore);
            dest.writeString(this.flowerScoreFormatTenThousand);
            dest.writeString(this.apBeanScoreFormatTenThousand);
            dest.writeString(this.rewardScoreFormatTenThousand);
            dest.writeString(this.starCoinScoreFormatTenThousand);
            dest.writeString(this.scoreTotalFormatTenThousand);
        }

        public GiftScoreTotalBean() {
        }

        protected GiftScoreTotalBean(Parcel in) {
            this.starCoinScore = in.readString();
            this.rewardScore = in.readString();
            this.flowerScore = in.readString();
            this.scoreTotal = in.readString();
            this.apBeanScore = in.readString();
            this.flowerScoreFormatTenThousand = in.readString();
            this.apBeanScoreFormatTenThousand = in.readString();
            this.rewardScoreFormatTenThousand = in.readString();
            this.starCoinScoreFormatTenThousand = in.readString();
            this.scoreTotalFormatTenThousand = in.readString();
        }

        public static final Creator<GiftScoreTotalBean> CREATOR = new Creator<GiftScoreTotalBean>() {
            @Override
            public GiftScoreTotalBean createFromParcel(Parcel source) {
                return new GiftScoreTotalBean(source);
            }

            @Override
            public GiftScoreTotalBean[] newArray(int size) {
                return new GiftScoreTotalBean[size];
            }
        };
    }

    public static class SponsorStatusBean implements Parcelable {

        private int notifyType;
        private String scoreLeft;
        private String scoreTotal;
        private String sponsorLine;
        private SponsorInfoBean sponsorInfo;


        public SponsorInfoBean getSponsorInfo() {
            return sponsorInfo;
        }

        public String getScoreLeft() {
            return scoreLeft;
        }

        public void setScoreLeft(String scoreLeft) {
            this.scoreLeft = scoreLeft;
        }

        public String getSponsorLine() {
            return sponsorLine;
        }

        public void setSponsorLine(String sponsorLine) {
            this.sponsorLine = sponsorLine;
        }

        public String getScoreTotal() {
            return scoreTotal;
        }

        public void setScoreTotal(String scoreTotal) {
            this.scoreTotal = scoreTotal;
        }

        public int getNotifyType() {
            return notifyType;
        }

        public void setNotifyType(int notifyType) {
            this.notifyType = notifyType;
        }

        public static class SponsorInfoBean implements Parcelable {
            private int sponsorRank;

            public int getSponsorRank() {
                return sponsorRank;
            }

            public void setSponsorRank(int sponsorRank) {
                this.sponsorRank = sponsorRank;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(this.sponsorRank);
            }

            public SponsorInfoBean() {
            }

            protected SponsorInfoBean(Parcel in) {
                this.sponsorRank = in.readInt();
            }

            public static final Creator<SponsorInfoBean> CREATOR = new Creator<SponsorInfoBean>() {
                @Override
                public SponsorInfoBean createFromParcel(Parcel source) {
                    return new SponsorInfoBean(source);
                }

                @Override
                public SponsorInfoBean[] newArray(int size) {
                    return new SponsorInfoBean[size];
                }
            };
        }

        public SponsorStatusBean() {
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.notifyType);
            dest.writeString(this.scoreLeft);
            dest.writeString(this.scoreTotal);
            dest.writeString(this.sponsorLine);
            dest.writeParcelable(this.sponsorInfo, flags);
        }

        protected SponsorStatusBean(Parcel in) {
            this.notifyType = in.readInt();
            this.scoreLeft = in.readString();
            this.scoreTotal = in.readString();
            this.sponsorLine = in.readString();
            this.sponsorInfo = in.readParcelable(SponsorInfoBean.class.getClassLoader());
        }

        public static final Creator<SponsorStatusBean> CREATOR = new Creator<SponsorStatusBean>() {
            @Override
            public SponsorStatusBean createFromParcel(Parcel source) {
                return new SponsorStatusBean(source);
            }

            @Override
            public SponsorStatusBean[] newArray(int size) {
                return new SponsorStatusBean[size];
            }
        };
    }

    public static class GiftScoreRankBean implements Parcelable {

        private UserInfo userInfo;
        private String scoreTotal;
        private String scoreTotalFormatTenThousand;
        private String bid;
        private boolean isSponsor;

        public String getScoreTotalFormatTenThousand() {
            return scoreTotalFormatTenThousand;
        }

        public UserInfo getUserInfo() {
            return userInfo;
        }

        public String getScoreTotal() {
            return scoreTotal;
        }

        public String getBid() {
            return bid;
        }

        public boolean isSponsor() {
            return isSponsor;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeParcelable(this.userInfo, flags);
            dest.writeString(this.scoreTotal);
            dest.writeString(this.bid);
            dest.writeByte(this.isSponsor ? (byte) 1 : (byte) 0);
            dest.writeString(this.scoreTotalFormatTenThousand);
        }

        public GiftScoreRankBean() {
        }

        protected GiftScoreRankBean(Parcel in) {
            this.userInfo = in.readParcelable(UserInfo.class.getClassLoader());
            this.scoreTotal = in.readString();
            this.bid = in.readString();
            this.isSponsor = in.readByte() != 0;
            this.scoreTotalFormatTenThousand =in.readString();
        }

        public static final Parcelable.Creator<GiftScoreRankBean> CREATOR = new Parcelable.Creator<GiftScoreRankBean>() {
            @Override
            public GiftScoreRankBean createFromParcel(Parcel source) {
                return new GiftScoreRankBean(source);
            }

            @Override
            public GiftScoreRankBean[] newArray(int size) {
                return new GiftScoreRankBean[size];
            }
        };
    }

    public static class SponsorListBean implements Parcelable {

        private UserInfo userInfo;
        private String bid;
        private String scoreTotal;

        public UserInfo getUserInfo() {
            return userInfo;
        }

        public String getBid() {
            return bid;
        }

        public String getScoreTotal() {
            return scoreTotal;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeParcelable(this.userInfo, flags);
            dest.writeString(this.bid);
            dest.writeString(this.scoreTotal);
        }

        public SponsorListBean() {
        }

        protected SponsorListBean(Parcel in) {
            this.userInfo = in.readParcelable(UserInfo.class.getClassLoader());
            this.bid = in.readString();
            this.scoreTotal = in.readString();
        }

        public static final Parcelable.Creator<SponsorListBean> CREATOR = new Parcelable.Creator<SponsorListBean>() {
            @Override
            public SponsorListBean createFromParcel(Parcel source) {
                return new SponsorListBean(source);
            }

            @Override
            public SponsorListBean[] newArray(int size) {
                return new SponsorListBean[size];
            }
        };
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.myScore, flags);
        dest.writeParcelable(this.giftScoreTotal, flags);
        dest.writeInt(this.sponsorTotal);
        dest.writeParcelable(this.sponsorStatus, flags);
        dest.writeTypedList(this.giftScoreRank);
        dest.writeTypedList(this.sponsorList);
        dest.writeParcelable(this.redPacket,flags);
    }

    public VideoGiftListEntity() {
    }

    protected VideoGiftListEntity(Parcel in) {
        this.myScore = in.readParcelable(MyScoreBean.class.getClassLoader());
        this.giftScoreTotal = in.readParcelable(GiftScoreTotalBean.class.getClassLoader());
        this.sponsorTotal = in.readInt();
        this.sponsorStatus = in.readParcelable(SponsorStatusBean.class.getClassLoader());
        this.giftScoreRank = in.createTypedArrayList(GiftScoreRankBean.CREATOR);
        this.sponsorList = in.createTypedArrayList(SponsorListBean.CREATOR);
        this.redPacket = in.readParcelable(AllRedPacketEntity.class.getClassLoader());
    }

    public static final Parcelable.Creator<VideoGiftListEntity> CREATOR = new Parcelable.Creator<VideoGiftListEntity>() {
        @Override
        public VideoGiftListEntity createFromParcel(Parcel source) {
            return new VideoGiftListEntity(source);
        }

        @Override
        public VideoGiftListEntity[] newArray(int size) {
            return new VideoGiftListEntity[size];
        }
    };
}
