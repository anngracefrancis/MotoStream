package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
final class FragmentManagerState implements Parcelable {
    public static final Parcelable.Creator<FragmentManagerState> CREATOR = new a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    ArrayList<FragmentState> f1522f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    ArrayList<String> f1523g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    BackStackState[] f1524h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f1525i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    String f1526j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    ArrayList<String> f1527k;
    ArrayList<Bundle> l;
    ArrayList<FragmentManager.LaunchedFragmentInfo> m;

    class a implements Parcelable.Creator<FragmentManagerState> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public FragmentManagerState createFromParcel(Parcel parcel) {
            return new FragmentManagerState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public FragmentManagerState[] newArray(int i2) {
            return new FragmentManagerState[i2];
        }
    }

    public FragmentManagerState() {
        this.f1526j = null;
        this.f1527k = new ArrayList<>();
        this.l = new ArrayList<>();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeTypedList(this.f1522f);
        parcel.writeStringList(this.f1523g);
        parcel.writeTypedArray(this.f1524h, i2);
        parcel.writeInt(this.f1525i);
        parcel.writeString(this.f1526j);
        parcel.writeStringList(this.f1527k);
        parcel.writeTypedList(this.l);
        parcel.writeTypedList(this.m);
    }

    public FragmentManagerState(Parcel parcel) {
        this.f1526j = null;
        this.f1527k = new ArrayList<>();
        this.l = new ArrayList<>();
        this.f1522f = parcel.createTypedArrayList(FragmentState.CREATOR);
        this.f1523g = parcel.createStringArrayList();
        this.f1524h = (BackStackState[]) parcel.createTypedArray(BackStackState.CREATOR);
        this.f1525i = parcel.readInt();
        this.f1526j = parcel.readString();
        this.f1527k = parcel.createStringArrayList();
        this.l = parcel.createTypedArrayList(Bundle.CREATOR);
        this.m = parcel.createTypedArrayList(FragmentManager.LaunchedFragmentInfo.CREATOR);
    }
}
