package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
final class l implements Parcelable.Creator {
    l() {
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new BinderWrapper(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i2) {
        return new BinderWrapper[i2];
    }
}
