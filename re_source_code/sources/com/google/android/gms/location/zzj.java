package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class
public final class zzj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzj> CREATOR = new zzk();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    private boolean f17676f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    private long f17677g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    private float f17678h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @SafeParcelable.Field
    private long f17679i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @SafeParcelable.Field
    private int f17680j;

    public zzj() {
        this(true, 50L, 0.0f, Long.MAX_VALUE, Integer.MAX_VALUE);
    }

    @SafeParcelable.Constructor
    zzj(@SafeParcelable.Param(id = 1) boolean z, @SafeParcelable.Param(id = 2) long j2, @SafeParcelable.Param(id = 3) float f2, @SafeParcelable.Param(id = 4) long j3, @SafeParcelable.Param(id = 5) int i2) {
        this.f17676f = z;
        this.f17677g = j2;
        this.f17678h = f2;
        this.f17679i = j3;
        this.f17680j = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzj)) {
            return false;
        }
        zzj zzjVar = (zzj) obj;
        return this.f17676f == zzjVar.f17676f && this.f17677g == zzjVar.f17677g && Float.compare(this.f17678h, zzjVar.f17678h) == 0 && this.f17679i == zzjVar.f17679i && this.f17680j == zzjVar.f17680j;
    }

    public final int hashCode() {
        return Objects.b(Boolean.valueOf(this.f17676f), Long.valueOf(this.f17677g), Float.valueOf(this.f17678h), Long.valueOf(this.f17679i), Integer.valueOf(this.f17680j));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DeviceOrientationRequest[mShouldUseMag=");
        sb.append(this.f17676f);
        sb.append(" mMinimumSamplingPeriodMs=");
        sb.append(this.f17677g);
        sb.append(" mSmallestAngleChangeRadians=");
        sb.append(this.f17678h);
        long j2 = this.f17679i;
        if (j2 != Long.MAX_VALUE) {
            long jElapsedRealtime = j2 - SystemClock.elapsedRealtime();
            sb.append(" expireIn=");
            sb.append(jElapsedRealtime);
            sb.append("ms");
        }
        if (this.f17680j != Integer.MAX_VALUE) {
            sb.append(" num=");
            sb.append(this.f17680j);
        }
        sb.append(']');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.c(parcel, 1, this.f17676f);
        SafeParcelWriter.p(parcel, 2, this.f17677g);
        SafeParcelWriter.i(parcel, 3, this.f17678h);
        SafeParcelWriter.p(parcel, 4, this.f17679i);
        SafeParcelWriter.l(parcel, 5, this.f17680j);
        SafeParcelWriter.b(parcel, iA);
    }
}
