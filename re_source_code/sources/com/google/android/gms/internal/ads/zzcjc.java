package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcjc {
    private final zzcja a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzbbl f15286b;

    public zzcjc(zzcja zzcjaVar, zzbbl zzbblVar) {
        this.a = zzcjaVar;
        this.f15286b = zzbblVar;
    }

    public final void a(zzczc<SQLiteDatabase, Void> zzczcVar) {
        zzbbl zzbblVar = this.f15286b;
        zzcja zzcjaVar = this.a;
        zzcjaVar.getClass();
        zzbar.f(zzbblVar.submit(xj.a(zzcjaVar)), new yj(this, zzczcVar), this.f15286b);
    }
}
