package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
final class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = new a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final int[] f1466f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final ArrayList<String> f1467g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final int[] f1468h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final int[] f1469i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final int f1470j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final String f1471k;
    final int l;
    final int m;
    final CharSequence n;
    final int o;
    final CharSequence p;
    final ArrayList<String> q;
    final ArrayList<String> r;
    final boolean s;

    class a implements Parcelable.Creator<BackStackState> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public BackStackState createFromParcel(Parcel parcel) {
            return new BackStackState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public BackStackState[] newArray(int i2) {
            return new BackStackState[i2];
        }
    }

    public BackStackState(androidx.fragment.app.a aVar) {
        int size = aVar.f1641c.size();
        this.f1466f = new int[size * 5];
        if (!aVar.f1647i) {
            throw new IllegalStateException("Not on back stack");
        }
        this.f1467g = new ArrayList<>(size);
        this.f1468h = new int[size];
        this.f1469i = new int[size];
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            u.a aVar2 = aVar.f1641c.get(i2);
            int i4 = i3 + 1;
            this.f1466f[i3] = aVar2.a;
            ArrayList<String> arrayList = this.f1467g;
            Fragment fragment = aVar2.f1650b;
            arrayList.add(fragment != null ? fragment.mWho : null);
            int[] iArr = this.f1466f;
            int i5 = i4 + 1;
            iArr[i4] = aVar2.f1651c;
            int i6 = i5 + 1;
            iArr[i5] = aVar2.f1652d;
            int i7 = i6 + 1;
            iArr[i6] = aVar2.f1653e;
            iArr[i7] = aVar2.f1654f;
            this.f1468h[i2] = aVar2.f1655g.ordinal();
            this.f1469i[i2] = aVar2.f1656h.ordinal();
            i2++;
            i3 = i7 + 1;
        }
        this.f1470j = aVar.f1646h;
        this.f1471k = aVar.f1649k;
        this.l = aVar.v;
        this.m = aVar.l;
        this.n = aVar.m;
        this.o = aVar.n;
        this.p = aVar.o;
        this.q = aVar.p;
        this.r = aVar.q;
        this.s = aVar.r;
    }

    public androidx.fragment.app.a a(FragmentManager fragmentManager) {
        androidx.fragment.app.a aVar = new androidx.fragment.app.a(fragmentManager);
        int i2 = 0;
        int i3 = 0;
        while (i2 < this.f1466f.length) {
            u.a aVar2 = new u.a();
            int i4 = i2 + 1;
            aVar2.a = this.f1466f[i2];
            if (FragmentManager.H0(2)) {
                Log.v("FragmentManager", "Instantiate " + aVar + " op #" + i3 + " base fragment #" + this.f1466f[i4]);
            }
            String str = this.f1467g.get(i3);
            if (str != null) {
                aVar2.f1650b = fragmentManager.h0(str);
            } else {
                aVar2.f1650b = null;
            }
            aVar2.f1655g = androidx.lifecycle.g.c.values()[this.f1468h[i3]];
            aVar2.f1656h = androidx.lifecycle.g.c.values()[this.f1469i[i3]];
            int[] iArr = this.f1466f;
            int i5 = i4 + 1;
            int i6 = iArr[i4];
            aVar2.f1651c = i6;
            int i7 = i5 + 1;
            int i8 = iArr[i5];
            aVar2.f1652d = i8;
            int i9 = i7 + 1;
            int i10 = iArr[i7];
            aVar2.f1653e = i10;
            int i11 = iArr[i9];
            aVar2.f1654f = i11;
            aVar.f1642d = i6;
            aVar.f1643e = i8;
            aVar.f1644f = i10;
            aVar.f1645g = i11;
            aVar.f(aVar2);
            i3++;
            i2 = i9 + 1;
        }
        aVar.f1646h = this.f1470j;
        aVar.f1649k = this.f1471k;
        aVar.v = this.l;
        aVar.f1647i = true;
        aVar.l = this.m;
        aVar.m = this.n;
        aVar.n = this.o;
        aVar.o = this.p;
        aVar.p = this.q;
        aVar.q = this.r;
        aVar.r = this.s;
        aVar.v(1);
        return aVar;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeIntArray(this.f1466f);
        parcel.writeStringList(this.f1467g);
        parcel.writeIntArray(this.f1468h);
        parcel.writeIntArray(this.f1469i);
        parcel.writeInt(this.f1470j);
        parcel.writeString(this.f1471k);
        parcel.writeInt(this.l);
        parcel.writeInt(this.m);
        TextUtils.writeToParcel(this.n, parcel, 0);
        parcel.writeInt(this.o);
        TextUtils.writeToParcel(this.p, parcel, 0);
        parcel.writeStringList(this.q);
        parcel.writeStringList(this.r);
        parcel.writeInt(this.s ? 1 : 0);
    }

    public BackStackState(Parcel parcel) {
        this.f1466f = parcel.createIntArray();
        this.f1467g = parcel.createStringArrayList();
        this.f1468h = parcel.createIntArray();
        this.f1469i = parcel.createIntArray();
        this.f1470j = parcel.readInt();
        this.f1471k = parcel.readString();
        this.l = parcel.readInt();
        this.m = parcel.readInt();
        this.n = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.o = parcel.readInt();
        this.p = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.q = parcel.createStringArrayList();
        this.r = parcel.createStringArrayList();
        this.s = parcel.readInt() != 0;
    }
}
