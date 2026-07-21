package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class p4 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ String f17902f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ String f17903g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ String f17904h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final /* synthetic */ long f17905i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final /* synthetic */ zzgc f17906j;

    p4(zzgc zzgcVar, String str, String str2, String str3, long j2) {
        this.f17906j = zzgcVar;
        this.f17902f = str;
        this.f17903g = str2;
        this.f17904h = str3;
        this.f17905i = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str = this.f17902f;
        if (str == null) {
            this.f17906j.f18163f.g0().Q().K(this.f17903g, null);
        } else {
            this.f17906j.f18163f.g0().Q().K(this.f17903g, new zzig(this.f17904h, str, this.f17905i));
        }
    }
}
