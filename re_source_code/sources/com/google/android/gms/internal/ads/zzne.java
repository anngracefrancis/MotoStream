package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public final class zzne implements Parcelable, Comparator<zza> {
    public static final Parcelable.Creator<zzne> CREATOR = new l10();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zza[] f16505f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f16506g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f16507h;

    public static final class zza implements Parcelable {
        public static final Parcelable.Creator<zza> CREATOR = new m10();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f16508f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final UUID f16509g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final String f16510h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final byte[] f16511i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final boolean f16512j;

        public zza(UUID uuid, String str, byte[] bArr) {
            this(uuid, str, bArr, false);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            zza zzaVar = (zza) obj;
            return this.f16510h.equals(zzaVar.f16510h) && zzsy.g(this.f16509g, zzaVar.f16509g) && Arrays.equals(this.f16511i, zzaVar.f16511i);
        }

        public final int hashCode() {
            if (this.f16508f == 0) {
                this.f16508f = (((this.f16509g.hashCode() * 31) + this.f16510h.hashCode()) * 31) + Arrays.hashCode(this.f16511i);
            }
            return this.f16508f;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            parcel.writeLong(this.f16509g.getMostSignificantBits());
            parcel.writeLong(this.f16509g.getLeastSignificantBits());
            parcel.writeString(this.f16510h);
            parcel.writeByteArray(this.f16511i);
            parcel.writeByte(this.f16512j ? (byte) 1 : (byte) 0);
        }

        private zza(UUID uuid, String str, byte[] bArr, boolean z) {
            this.f16509g = (UUID) zzsk.d(uuid);
            this.f16510h = (String) zzsk.d(str);
            this.f16511i = (byte[]) zzsk.d(bArr);
            this.f16512j = false;
        }

        zza(Parcel parcel) {
            this.f16509g = new UUID(parcel.readLong(), parcel.readLong());
            this.f16510h = parcel.readString();
            this.f16511i = parcel.createByteArray();
            this.f16512j = parcel.readByte() != 0;
        }
    }

    public zzne(zza... zzaVarArr) {
        this(true, zzaVarArr);
    }

    public final zza a(int i2) {
        return this.f16505f[i2];
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zza zzaVar, zza zzaVar2) {
        zza zzaVar3 = zzaVar;
        zza zzaVar4 = zzaVar2;
        UUID uuid = zzkt.f16407b;
        if (uuid.equals(zzaVar3.f16509g)) {
            return uuid.equals(zzaVar4.f16509g) ? 0 : 1;
        }
        return zzaVar3.f16509g.compareTo(zzaVar4.f16509g);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzne.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f16505f, ((zzne) obj).f16505f);
    }

    public final int hashCode() {
        if (this.f16506g == 0) {
            this.f16506g = Arrays.hashCode(this.f16505f);
        }
        return this.f16506g;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeTypedArray(this.f16505f, 0);
    }

    private zzne(boolean z, zza... zzaVarArr) {
        zza[] zzaVarArr2 = (zza[]) zzaVarArr.clone();
        Arrays.sort(zzaVarArr2, this);
        for (int i2 = 1; i2 < zzaVarArr2.length; i2++) {
            if (zzaVarArr2[i2 - 1].f16509g.equals(zzaVarArr2[i2].f16509g)) {
                String strValueOf = String.valueOf(zzaVarArr2[i2].f16509g);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 25);
                sb.append("Duplicate data for uuid: ");
                sb.append(strValueOf);
                throw new IllegalArgumentException(sb.toString());
            }
        }
        this.f16505f = zzaVarArr2;
        this.f16507h = zzaVarArr2.length;
    }

    zzne(Parcel parcel) {
        zza[] zzaVarArr = (zza[]) parcel.createTypedArray(zza.CREATOR);
        this.f16505f = zzaVarArr;
        this.f16507h = zzaVarArr.length;
    }
}
