package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes2.dex */
@KeepForSdkWithMembers
@SafeParcelable.Class
public class ProxyRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ProxyRequest> CREATOR = new zza();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f11483f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f11484g = 1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f11485h = 2;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f11486i = 3;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f11487j = 4;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f11488k = 5;
    public static final int l = 6;
    public static final int m = 7;
    public static final int n = 7;

    @SafeParcelable.VersionField
    private final int o;

    @SafeParcelable.Field
    public final String p;

    @SafeParcelable.Field
    public final int q;

    @SafeParcelable.Field
    public final long r;

    @SafeParcelable.Field
    public final byte[] s;

    @SafeParcelable.Field
    private Bundle t;

    @KeepForSdkWithMembers
    public static class Builder {
    }

    @SafeParcelable.Constructor
    ProxyRequest(@SafeParcelable.Param(id = 1000) int i2, @SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) int i3, @SafeParcelable.Param(id = 3) long j2, @SafeParcelable.Param(id = 4) byte[] bArr, @SafeParcelable.Param(id = 5) Bundle bundle) {
        this.o = i2;
        this.p = str;
        this.q = i3;
        this.r = j2;
        this.s = bArr;
        this.t = bundle;
    }

    public String toString() {
        String str = this.p;
        int i2 = this.q;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 42);
        sb.append("ProxyRequest[ url: ");
        sb.append(str);
        sb.append(", method: ");
        sb.append(i2);
        sb.append(" ]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, this.p, false);
        SafeParcelWriter.l(parcel, 2, this.q);
        SafeParcelWriter.p(parcel, 3, this.r);
        SafeParcelWriter.f(parcel, 4, this.s, false);
        SafeParcelWriter.e(parcel, 5, this.t, false);
        SafeParcelWriter.l(parcel, 1000, this.o);
        SafeParcelWriter.b(parcel, iA);
    }
}
