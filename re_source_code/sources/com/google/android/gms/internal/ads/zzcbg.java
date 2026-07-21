package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcbg {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f15010b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f15011c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final zzadw f15012d;

    @VisibleForTesting
    public zzcbg(String str, String str2) {
        this.a = 1;
        this.f15010b = str;
        this.f15011c = str2;
        this.f15012d = null;
    }

    @VisibleForTesting
    public zzcbg(String str, zzadw zzadwVar) {
        this.a = 2;
        this.f15010b = str;
        this.f15011c = null;
        this.f15012d = zzadwVar;
    }
}
