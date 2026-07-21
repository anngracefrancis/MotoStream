package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzalk {
    private final Object a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f13952b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private zzalr f13953c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private zzalr f13954d;

    private static Context c(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }

    public final zzalr a(Context context, zzbai zzbaiVar) {
        zzalr zzalrVar;
        synchronized (this.f13952b) {
            if (this.f13954d == null) {
                this.f13954d = new zzalr(c(context), zzbaiVar, (String) zzyt.e().c(zzacu.f13798b));
            }
            zzalrVar = this.f13954d;
        }
        return zzalrVar;
    }

    public final zzalr b(Context context, zzbai zzbaiVar) {
        zzalr zzalrVar;
        synchronized (this.a) {
            if (this.f13953c == null) {
                this.f13953c = new zzalr(c(context), zzbaiVar, (String) zzyt.e().c(zzacu.f13799c));
            }
            zzalrVar = this.f13953c;
        }
        return zzalrVar;
    }
}
