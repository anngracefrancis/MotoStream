package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
@KeepForSdk
@SafeParcelable.Class
@Deprecated
public final class WakeLockEvent extends StatsEvent {
    public static final Parcelable.Creator<WakeLockEvent> CREATOR = new zza();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.VersionField
    final int f12142f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    private final long f12143g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    private int f12144h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @SafeParcelable.Field
    private final String f12145i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @SafeParcelable.Field
    private final String f12146j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @SafeParcelable.Field
    private final String f12147k;

    @SafeParcelable.Field
    private final int l;

    @SafeParcelable.Field
    private final List m;

    @SafeParcelable.Field
    private final String n;

    @SafeParcelable.Field
    private final long o;

    @SafeParcelable.Field
    private int p;

    @SafeParcelable.Field
    private final String q;

    @SafeParcelable.Field
    private final float r;

    @SafeParcelable.Field
    private final long s;

    @SafeParcelable.Field
    private final boolean t;
    private long u = -1;

    @SafeParcelable.Constructor
    WakeLockEvent(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) long j2, @SafeParcelable.Param(id = 11) int i3, @SafeParcelable.Param(id = 4) String str, @SafeParcelable.Param(id = 5) int i4, @SafeParcelable.Param(id = 6) List list, @SafeParcelable.Param(id = 12) String str2, @SafeParcelable.Param(id = 8) long j3, @SafeParcelable.Param(id = 14) int i5, @SafeParcelable.Param(id = 10) String str3, @SafeParcelable.Param(id = 13) String str4, @SafeParcelable.Param(id = 15) float f2, @SafeParcelable.Param(id = 16) long j4, @SafeParcelable.Param(id = 17) String str5, @SafeParcelable.Param(id = 18) boolean z) {
        this.f12142f = i2;
        this.f12143g = j2;
        this.f12144h = i3;
        this.f12145i = str;
        this.f12146j = str3;
        this.f12147k = str5;
        this.l = i4;
        this.m = list;
        this.n = str2;
        this.o = j3;
        this.p = i5;
        this.q = str4;
        this.r = f2;
        this.s = j4;
        this.t = z;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final long W() {
        return this.f12143g;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final String Y() {
        List list = this.m;
        String str = this.f12145i;
        int i2 = this.l;
        String str2 = HttpUrl.FRAGMENT_ENCODE_SET;
        String strJoin = list == null ? HttpUrl.FRAGMENT_ENCODE_SET : TextUtils.join(",", list);
        int i3 = this.p;
        String str3 = this.f12146j;
        if (str3 == null) {
            str3 = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        String str4 = this.q;
        if (str4 == null) {
            str4 = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        float f2 = this.r;
        String str5 = this.f12147k;
        if (str5 != null) {
            str2 = str5;
        }
        return "\t" + str + "\t" + i2 + "\t" + strJoin + "\t" + i3 + "\t" + str3 + "\t" + str4 + "\t" + f2 + "\t" + str2 + "\t" + this.t;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.l(parcel, 1, this.f12142f);
        SafeParcelWriter.p(parcel, 2, this.f12143g);
        SafeParcelWriter.u(parcel, 4, this.f12145i, false);
        SafeParcelWriter.l(parcel, 5, this.l);
        SafeParcelWriter.w(parcel, 6, this.m, false);
        SafeParcelWriter.p(parcel, 8, this.o);
        SafeParcelWriter.u(parcel, 10, this.f12146j, false);
        SafeParcelWriter.l(parcel, 11, this.f12144h);
        SafeParcelWriter.u(parcel, 12, this.n, false);
        SafeParcelWriter.u(parcel, 13, this.q, false);
        SafeParcelWriter.l(parcel, 14, this.p);
        SafeParcelWriter.i(parcel, 15, this.r);
        SafeParcelWriter.p(parcel, 16, this.s);
        SafeParcelWriter.u(parcel, 17, this.f12147k, false);
        SafeParcelWriter.c(parcel, 18, this.t);
        SafeParcelWriter.b(parcel, iA);
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final int y() {
        return this.f12144h;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final long z() {
        return this.u;
    }
}
