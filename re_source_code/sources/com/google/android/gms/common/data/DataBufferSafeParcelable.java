package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes2.dex */
@KeepForSdk
public class DataBufferSafeParcelable<T extends SafeParcelable> extends AbstractDataBuffer<T> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String[] f11907g = {"data"};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Parcelable.Creator<T> f11908h;

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    @KeepForSdk
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public T get(int i2) {
        DataHolder dataHolder = this.f11896f;
        byte[] bArrY = dataHolder.y("data", i2, dataHolder.e0(i2));
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.unmarshall(bArrY, 0, bArrY.length);
        parcelObtain.setDataPosition(0);
        T tCreateFromParcel = this.f11908h.createFromParcel(parcelObtain);
        parcelObtain.recycle();
        return tCreateFromParcel;
    }
}
