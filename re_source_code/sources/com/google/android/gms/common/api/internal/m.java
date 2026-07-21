package com.google.android.gms.common.api.internal;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
final class m extends com.google.android.gms.signin.internal.zac {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final WeakReference<zaak> f11770f;

    m(zaak zaakVar) {
        this.f11770f = new WeakReference<>(zaakVar);
    }

    @Override // com.google.android.gms.signin.internal.zac, com.google.android.gms.signin.internal.zad
    public final void w1(com.google.android.gms.signin.internal.zaj zajVar) {
        zaak zaakVar = this.f11770f.get();
        if (zaakVar == null) {
            return;
        }
        zaakVar.a.h(new n(this, zaakVar, zaakVar, zajVar));
    }
}
