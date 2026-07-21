package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzev {
    private final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f18114b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f18115c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final /* synthetic */ zzet f18116d;

    zzev(zzet zzetVar, int i2, boolean z, boolean z2) {
        this.f18116d = zzetVar;
        this.a = i2;
        this.f18114b = z;
        this.f18115c = z2;
    }

    public final void a(String str) {
        this.f18116d.B(this.a, this.f18114b, this.f18115c, str, null, null, null);
    }

    public final void b(String str, Object obj) {
        this.f18116d.B(this.a, this.f18114b, this.f18115c, str, obj, null, null);
    }

    public final void c(String str, Object obj, Object obj2) {
        this.f18116d.B(this.a, this.f18114b, this.f18115c, str, obj, obj2, null);
    }

    public final void d(String str, Object obj, Object obj2, Object obj3) {
        this.f18116d.B(this.a, this.f18114b, this.f18115c, str, obj, obj2, obj3);
    }
}
