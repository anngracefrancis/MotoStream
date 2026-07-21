package com.google.android.gms.internal.ads;

import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeoutException;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes2.dex */
final class nl<T> implements zzban<T> {
    private final /* synthetic */ String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ long f13060b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzcmu f13061c;

    nl(zzcmu zzcmuVar, String str, long j2) {
        this.f13061c = zzcmuVar;
        this.a = str;
        this.f13060b = j2;
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final void a(Throwable th) {
        long jB = this.f13061c.a.b();
        int i2 = 3;
        if (th instanceof TimeoutException) {
            i2 = 2;
        } else if (!(th instanceof zzcmk)) {
            if (th instanceof CancellationException) {
                i2 = 4;
            } else {
                i2 = ((th instanceof zzcgm) && ((zzcgm) th).a() == 3) ? 1 : 6;
            }
        }
        this.f13061c.d(this.a, i2, jB - this.f13060b);
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final void b(T t) {
        this.f13061c.d(this.a, 0, this.f13061c.a.b() - this.f13060b);
    }
}
