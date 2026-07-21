package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
final class FragmentState implements Parcelable {
    public static final Parcelable.Creator<FragmentState> CREATOR = new a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final String f1528f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final String f1529g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final boolean f1530h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final int f1531i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final int f1532j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final String f1533k;
    final boolean l;
    final boolean m;
    final boolean n;
    final Bundle o;
    final boolean p;
    final int q;
    Bundle r;

    class a implements Parcelable.Creator<FragmentState> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public FragmentState createFromParcel(Parcel parcel) {
            return new FragmentState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public FragmentState[] newArray(int i2) {
            return new FragmentState[i2];
        }
    }

    FragmentState(Fragment fragment) {
        this.f1528f = fragment.getClass().getName();
        this.f1529g = fragment.mWho;
        this.f1530h = fragment.mFromLayout;
        this.f1531i = fragment.mFragmentId;
        this.f1532j = fragment.mContainerId;
        this.f1533k = fragment.mTag;
        this.l = fragment.mRetainInstance;
        this.m = fragment.mRemoving;
        this.n = fragment.mDetached;
        this.o = fragment.mArguments;
        this.p = fragment.mHidden;
        this.q = fragment.mMaxState.ordinal();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.f1528f);
        sb.append(" (");
        sb.append(this.f1529g);
        sb.append(")}:");
        if (this.f1530h) {
            sb.append(" fromLayout");
        }
        if (this.f1532j != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f1532j));
        }
        String str = this.f1533k;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(this.f1533k);
        }
        if (this.l) {
            sb.append(" retainInstance");
        }
        if (this.m) {
            sb.append(" removing");
        }
        if (this.n) {
            sb.append(" detached");
        }
        if (this.p) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f1528f);
        parcel.writeString(this.f1529g);
        parcel.writeInt(this.f1530h ? 1 : 0);
        parcel.writeInt(this.f1531i);
        parcel.writeInt(this.f1532j);
        parcel.writeString(this.f1533k);
        parcel.writeInt(this.l ? 1 : 0);
        parcel.writeInt(this.m ? 1 : 0);
        parcel.writeInt(this.n ? 1 : 0);
        parcel.writeBundle(this.o);
        parcel.writeInt(this.p ? 1 : 0);
        parcel.writeBundle(this.r);
        parcel.writeInt(this.q);
    }

    FragmentState(Parcel parcel) {
        this.f1528f = parcel.readString();
        this.f1529g = parcel.readString();
        this.f1530h = parcel.readInt() != 0;
        this.f1531i = parcel.readInt();
        this.f1532j = parcel.readInt();
        this.f1533k = parcel.readString();
        this.l = parcel.readInt() != 0;
        this.m = parcel.readInt() != 0;
        this.n = parcel.readInt() != 0;
        this.o = parcel.readBundle();
        this.p = parcel.readInt() != 0;
        this.r = parcel.readBundle();
        this.q = parcel.readInt();
    }
}
