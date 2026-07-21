package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class n4 implements Callable<List<m7>> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzm f17882f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzgc f17883g;

    n4(zzgc zzgcVar, zzm zzmVar) {
        this.f17883g = zzgcVar;
        this.f17882f = zzmVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<m7> call() throws Exception {
        this.f17883g.f18163f.e0();
        return this.f17883g.f18163f.W().I(this.f17882f.f18234f);
    }
}
