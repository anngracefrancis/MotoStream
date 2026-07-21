package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public final class zzps extends zzpv {
    public static final Parcelable.Creator<zzps> CREATOR = new v20();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f16593g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f16594h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f16595i;

    public zzps(String str, String str2, String str3) {
        super("COMM");
        this.f16593g = str;
        this.f16594h = str2;
        this.f16595i = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzps.class == obj.getClass()) {
            zzps zzpsVar = (zzps) obj;
            if (zzsy.g(this.f16594h, zzpsVar.f16594h) && zzsy.g(this.f16593g, zzpsVar.f16593g) && zzsy.g(this.f16595i, zzpsVar.f16595i)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f16593g;
        int iHashCode = ((str != null ? str.hashCode() : 0) + 527) * 31;
        String str2 = this.f16594h;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f16595i;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f16596f);
        parcel.writeString(this.f16593g);
        parcel.writeString(this.f16595i);
    }

    zzps(Parcel parcel) {
        super("COMM");
        this.f16593g = parcel.readString();
        this.f16594h = parcel.readString();
        this.f16595i = parcel.readString();
    }
}
