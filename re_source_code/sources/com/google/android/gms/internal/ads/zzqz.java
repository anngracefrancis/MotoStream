package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzqz extends zzlr {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f16626b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f16627c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f16628d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f16629e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f16630f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f16631g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f16632h;

    public zzqz(long j2, boolean z) {
        this(j2, j2, 0L, 0L, z, false);
    }

    @Override // com.google.android.gms.internal.ads.zzlr
    public final zzlt c(int i2, zzlt zzltVar, boolean z) {
        zzsk.g(i2, 0, 1);
        Object obj = z ? f16626b : null;
        return zzltVar.a(obj, obj, 0, this.f16627c, 0L, false);
    }

    @Override // com.google.android.gms.internal.ads.zzlr
    public final zzlu e(int i2, zzlu zzluVar, boolean z, long j2) {
        zzsk.g(i2, 0, 1);
        boolean z2 = this.f16631g;
        long j3 = this.f16628d;
        zzluVar.a = null;
        zzluVar.f16440b = -9223372036854775807L;
        zzluVar.f16441c = -9223372036854775807L;
        zzluVar.f16442d = z2;
        zzluVar.f16443e = false;
        zzluVar.f16446h = 0L;
        zzluVar.f16447i = j3;
        zzluVar.f16444f = 0;
        zzluVar.f16445g = 0;
        zzluVar.f16448j = 0L;
        return zzluVar;
    }

    @Override // com.google.android.gms.internal.ads.zzlr
    public final int f(Object obj) {
        return f16626b.equals(obj) ? 0 : -1;
    }

    @Override // com.google.android.gms.internal.ads.zzlr
    public final int g() {
        return 1;
    }

    @Override // com.google.android.gms.internal.ads.zzlr
    public final int h() {
        return 1;
    }

    private zzqz(long j2, long j3, long j4, long j5, boolean z, boolean z2) {
        this.f16627c = j2;
        this.f16628d = j3;
        this.f16629e = 0L;
        this.f16630f = 0L;
        this.f16631g = z;
        this.f16632h = false;
    }
}
