package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public final class zzpw extends zzpv {
    public static final Parcelable.Creator<zzpw> CREATOR = new w20();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f16597g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f16598h;

    public zzpw(String str, String str2, String str3) {
        super(str);
        this.f16597g = null;
        this.f16598h = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzpw.class == obj.getClass()) {
            zzpw zzpwVar = (zzpw) obj;
            if (this.f16596f.equals(zzpwVar.f16596f) && zzsy.g(this.f16597g, zzpwVar.f16597g) && zzsy.g(this.f16598h, zzpwVar.f16598h)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (this.f16596f.hashCode() + 527) * 31;
        String str = this.f16597g;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f16598h;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f16596f);
        parcel.writeString(this.f16597g);
        parcel.writeString(this.f16598h);
    }

    zzpw(Parcel parcel) {
        super(parcel.readString());
        this.f16597g = parcel.readString();
        this.f16598h = parcel.readString();
    }
}
