package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class zzpq extends zzpv {
    public static final Parcelable.Creator<zzpq> CREATOR = new u20();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f16589g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f16590h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f16591i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final byte[] f16592j;

    public zzpq(String str, String str2, int i2, byte[] bArr) {
        super("APIC");
        this.f16589g = str;
        this.f16590h = null;
        this.f16591i = 3;
        this.f16592j = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzpq.class == obj.getClass()) {
            zzpq zzpqVar = (zzpq) obj;
            if (this.f16591i == zzpqVar.f16591i && zzsy.g(this.f16589g, zzpqVar.f16589g) && zzsy.g(this.f16590h, zzpqVar.f16590h) && Arrays.equals(this.f16592j, zzpqVar.f16592j)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i2 = (this.f16591i + 527) * 31;
        String str = this.f16589g;
        int iHashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f16590h;
        return ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + Arrays.hashCode(this.f16592j);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f16589g);
        parcel.writeString(this.f16590h);
        parcel.writeInt(this.f16591i);
        parcel.writeByteArray(this.f16592j);
    }

    zzpq(Parcel parcel) {
        super("APIC");
        this.f16589g = parcel.readString();
        this.f16590h = parcel.readString();
        this.f16591i = parcel.readInt();
        this.f16592j = parcel.createByteArray();
    }
}
