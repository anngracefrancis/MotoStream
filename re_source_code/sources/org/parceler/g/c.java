package org.parceler.g;

import android.os.Parcel;

/* JADX INFO: compiled from: CharArrayParcelConverter.java */
/* JADX INFO: loaded from: classes3.dex */
public class c implements org.parceler.f {
    @Override // org.parceler.f
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public char[] a(Parcel parcel) {
        int i2 = parcel.readInt();
        if (i2 == -1) {
            return null;
        }
        char[] cArr = new char[i2];
        parcel.readCharArray(cArr);
        return cArr;
    }

    @Override // org.parceler.f
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public void b(char[] cArr, Parcel parcel) {
        if (cArr == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(cArr.length);
            parcel.writeCharArray(cArr);
        }
    }
}
