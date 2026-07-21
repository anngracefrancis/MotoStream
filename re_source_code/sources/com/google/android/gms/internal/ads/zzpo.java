package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class zzpo implements Parcelable {
    public static final Parcelable.Creator<zzpo> CREATOR = new t20();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zza[] f16588f;

    public interface zza extends Parcelable {
    }

    public zzpo(List<? extends zza> list) {
        zza[] zzaVarArr = new zza[list.size()];
        this.f16588f = zzaVarArr;
        list.toArray(zzaVarArr);
    }

    public final int a() {
        return this.f16588f.length;
    }

    public final zza b(int i2) {
        return this.f16588f[i2];
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzpo.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f16588f, ((zzpo) obj).f16588f);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f16588f);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f16588f.length);
        for (zza zzaVar : this.f16588f) {
            parcel.writeParcelable(zzaVar, 0);
        }
    }

    zzpo(Parcel parcel) {
        this.f16588f = new zza[parcel.readInt()];
        int i2 = 0;
        while (true) {
            zza[] zzaVarArr = this.f16588f;
            if (i2 >= zzaVarArr.length) {
                return;
            }
            zzaVarArr[i2] = (zza) parcel.readParcelable(zza.class.getClassLoader());
            i2++;
        }
    }
}
