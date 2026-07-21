package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public class zzaf extends Exception {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzp f13862f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f13863g;

    public zzaf() {
        this.f13862f = null;
    }

    final void a(long j2) {
        this.f13863g = j2;
    }

    public zzaf(zzp zzpVar) {
        this.f13862f = zzpVar;
    }

    public zzaf(String str) {
        super(str);
        this.f13862f = null;
    }

    public zzaf(Throwable th) {
        super(th);
        this.f13862f = null;
    }
}
