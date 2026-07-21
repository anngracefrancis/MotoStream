package org.parceler.g;

import android.os.Parcel;
import android.util.SparseArray;

/* JADX INFO: compiled from: SparseArrayParcelConverter.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class l<T> implements org.parceler.f {
    @Override // org.parceler.f
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public SparseArray<T> a(Parcel parcel) {
        int i2 = parcel.readInt();
        if (i2 < 0) {
            return null;
        }
        SparseArray<T> sparseArray = new SparseArray<>(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            sparseArray.append(parcel.readInt(), d(parcel));
        }
        return sparseArray;
    }

    public abstract T d(Parcel parcel);

    public abstract void e(T t, Parcel parcel);

    @Override // org.parceler.f
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public void b(SparseArray<T> sparseArray, Parcel parcel) {
        if (sparseArray == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(sparseArray.size());
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            parcel.writeInt(sparseArray.keyAt(i2));
            e(sparseArray.valueAt(i2), parcel);
        }
    }
}
