package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzlk implements zzcz<zzlj> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static zzlk f17519f = new zzlk();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzcz<zzlj> f17520g;

    private zzlk(zzcz<zzlj> zzczVar) {
        this.f17520g = zzdc.a(zzczVar);
    }

    public static boolean b() {
        return ((zzlj) f17519f.a()).a();
    }

    public static boolean c() {
        return ((zzlj) f17519f.a()).b();
    }

    @Override // com.google.android.gms.internal.measurement.zzcz
    public final /* synthetic */ zzlj a() {
        return this.f17520g.a();
    }

    public zzlk() {
        this(zzdc.b(new zzlm()));
    }
}
