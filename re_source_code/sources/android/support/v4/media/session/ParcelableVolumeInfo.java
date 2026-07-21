package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class ParcelableVolumeInfo implements Parcelable {
    public static final Parcelable.Creator<ParcelableVolumeInfo> CREATOR = new a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f38f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f39g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f40h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f41i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f42j;

    static class a implements Parcelable.Creator<ParcelableVolumeInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParcelableVolumeInfo createFromParcel(Parcel parcel) {
            return new ParcelableVolumeInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ParcelableVolumeInfo[] newArray(int i2) {
            return new ParcelableVolumeInfo[i2];
        }
    }

    public ParcelableVolumeInfo(Parcel parcel) {
        this.f38f = parcel.readInt();
        this.f40h = parcel.readInt();
        this.f41i = parcel.readInt();
        this.f42j = parcel.readInt();
        this.f39g = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f38f);
        parcel.writeInt(this.f40h);
        parcel.writeInt(this.f41i);
        parcel.writeInt(this.f42j);
        parcel.writeInt(this.f39g);
    }
}
