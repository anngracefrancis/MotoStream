package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class oh implements zzban<zzbgz> {
    private final /* synthetic */ String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ Map f13103b;

    oh(zzccj zzccjVar, String str, Map map) {
        this.a = str;
        this.f13103b = map;
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final void a(Throwable th) {
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final /* synthetic */ void b(zzbgz zzbgzVar) {
        zzbgzVar.y(this.a, this.f13103b);
    }
}
