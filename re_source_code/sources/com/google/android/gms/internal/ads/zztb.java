package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class zztb implements Parcelable {
    public static final Parcelable.Creator<zztb> CREATOR = new p30();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f16752f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f16753g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f16754h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final byte[] f16755i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f16756j;

    public zztb(int i2, int i3, int i4, byte[] bArr) {
        this.f16752f = i2;
        this.f16753g = i3;
        this.f16754h = i4;
        this.f16755i = bArr;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zztb.class == obj.getClass()) {
            zztb zztbVar = (zztb) obj;
            if (this.f16752f == zztbVar.f16752f && this.f16753g == zztbVar.f16753g && this.f16754h == zztbVar.f16754h && Arrays.equals(this.f16755i, zztbVar.f16755i)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (this.f16756j == 0) {
            this.f16756j = ((((((this.f16752f + 527) * 31) + this.f16753g) * 31) + this.f16754h) * 31) + Arrays.hashCode(this.f16755i);
        }
        return this.f16756j;
    }

    public final String toString() {
        int i2 = this.f16752f;
        int i3 = this.f16753g;
        int i4 = this.f16754h;
        boolean z = this.f16755i != null;
        StringBuilder sb = new StringBuilder(55);
        sb.append("ColorInfo(");
        sb.append(i2);
        sb.append(", ");
        sb.append(i3);
        sb.append(", ");
        sb.append(i4);
        sb.append(", ");
        sb.append(z);
        sb.append(")");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f16752f);
        parcel.writeInt(this.f16753g);
        parcel.writeInt(this.f16754h);
        parcel.writeInt(this.f16755i != null ? 1 : 0);
        byte[] bArr = this.f16755i;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
    }

    zztb(Parcel parcel) {
        this.f16752f = parcel.readInt();
        this.f16753g = parcel.readInt();
        this.f16754h = parcel.readInt();
        this.f16755i = parcel.readInt() != 0 ? parcel.createByteArray() : null;
    }
}
