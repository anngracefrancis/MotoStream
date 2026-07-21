package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;

/* JADX INFO: loaded from: classes2.dex */
final class m6 implements zzban {
    private final /* synthetic */ String a;

    m6(String str) {
        this.a = str;
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final void a(Throwable th) {
        zzk.zzlk().e(th, this.a);
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final void b(Object obj) {
    }
}
