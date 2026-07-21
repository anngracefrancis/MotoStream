package org.parceler.g;

import android.os.Parcel;

/* JADX INFO: compiled from: NullableParcelConverter.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class k<T> implements org.parceler.f {
    @Override // org.parceler.f
    public T a(Parcel parcel) {
        if (parcel.readInt() == -1) {
            return null;
        }
        return c(parcel);
    }

    @Override // org.parceler.f
    public void b(T t, Parcel parcel) {
        if (t == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(1);
            d(t, parcel);
        }
    }

    public abstract T c(Parcel parcel);

    public abstract void d(T t, Parcel parcel);
}
