package mymap.my_aipai.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

import mymap.my_aipai.payler.CommonRedPacketEntity;

/**
 * Created by devin on 2017/1/12.
 */

public class AllRedPacketEntity implements Parcelable {

    private int status;//状态码，0成功领取，1已领取完，2重复领取

    private AipaiRedPacketEntity aipaiRedPacket;
    private HrRedPacketEntity hrRedPacket;



    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public AipaiRedPacketEntity getAipaiRedPacket() {
        return aipaiRedPacket;
    }

    public void setAipaiRedPacket(AipaiRedPacketEntity aipaiRedPacket) {
        this.aipaiRedPacket = aipaiRedPacket;
    }

    public HrRedPacketEntity getHrRedPacket() {
        return hrRedPacket;
    }

    public void setHrRedPacket(HrRedPacketEntity hrRedPacket) {
        this.hrRedPacket = hrRedPacket;
    }

    public static class AipaiRedPacketEntity implements Parcelable {
        /**
         * list : [{"left":43784,"count":50268}]
         * count : 10078
         */

        private int count;
        private List<CommonRedPacketEntity> list;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public List<CommonRedPacketEntity> getList() {
            return list;
        }

        public void setList(List<CommonRedPacketEntity> list) {
            this.list = list;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.count);
            dest.writeTypedList(this.list);
        }

        public AipaiRedPacketEntity() {
        }

        protected AipaiRedPacketEntity(Parcel in) {
            this.count = in.readInt();
            this.list = in.createTypedArrayList(CommonRedPacketEntity.CREATOR);
        }

        public static final Creator<AipaiRedPacketEntity> CREATOR = new Creator<AipaiRedPacketEntity>() {
            @Override
            public AipaiRedPacketEntity createFromParcel(Parcel source) {
                return new AipaiRedPacketEntity(source);
            }

            @Override
            public AipaiRedPacketEntity[] newArray(int size) {
                return new AipaiRedPacketEntity[size];
            }
        };
    }

    public static class HrRedPacketEntity implements Parcelable {
        /**
         * count : 45218
         * list : [{"nickname":"测试内容61wy","left":33884,"avatar":"测试内容h3h8","bid":"测试内容064u","count":87215}]
         */

        private int count;
        private List<CommonRedPacketEntity> list;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public List<CommonRedPacketEntity> getList() {
            return list;
        }

        public void setList(List<CommonRedPacketEntity> list) {
            this.list = list;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.count);
            dest.writeTypedList(this.list);
        }

        public HrRedPacketEntity() {
        }

        protected HrRedPacketEntity(Parcel in) {
            this.count = in.readInt();
            this.list = in.createTypedArrayList(CommonRedPacketEntity.CREATOR);
        }

        public static final Creator<HrRedPacketEntity> CREATOR = new Creator<HrRedPacketEntity>() {
            @Override
            public HrRedPacketEntity createFromParcel(Parcel source) {
                return new HrRedPacketEntity(source);
            }

            @Override
            public HrRedPacketEntity[] newArray(int size) {
                return new HrRedPacketEntity[size];
            }
        };
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.status);
        dest.writeParcelable(this.aipaiRedPacket, flags);
        dest.writeParcelable(this.hrRedPacket, flags);
    }

    public AllRedPacketEntity() {
    }

    protected AllRedPacketEntity(Parcel in) {
        this.status = in.readInt();
        this.aipaiRedPacket = in.readParcelable(AipaiRedPacketEntity.class.getClassLoader());
        this.hrRedPacket = in.readParcelable(HrRedPacketEntity.class.getClassLoader());
    }

    public static final Creator<AllRedPacketEntity> CREATOR = new Creator<AllRedPacketEntity>() {
        @Override
        public AllRedPacketEntity createFromParcel(Parcel source) {
            return new AllRedPacketEntity(source);
        }

        @Override
        public AllRedPacketEntity[] newArray(int size) {
            return new AllRedPacketEntity[size];
        }
    };
}
