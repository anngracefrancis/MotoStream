package org.parceler.g;

import android.os.Parcel;

/* JADX INFO: compiled from: BooleanArrayParcelConverter.java */
/* JADX INFO: loaded from: classes3.dex */
public class b implements org.parceler.f {
    @Override // org.parceler.f
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean[] a(Parcel parcel) {
        int i2 = parcel.readInt();
        if (i2 == -1) {
            return null;
        }
        boolean[] zArr = new boolean[i2];
        parcel.readBooleanArray(zArr);
        return zArr;
    }

    @Override // org.parceler.f
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public void b(boolean[] zArr, Parcel parcel) {
        if (zArr == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(zArr.length);
            parcel.writeBooleanArray(zArr);
        }
    }
}
