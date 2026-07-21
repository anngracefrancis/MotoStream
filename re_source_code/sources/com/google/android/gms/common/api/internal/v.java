package com.google.android.gms.common.api.internal;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
final class v extends zabr {
    private WeakReference<zaaw> a;

    v(zaaw zaawVar) {
        this.a = new WeakReference<>(zaawVar);
    }

    @Override // com.google.android.gms.common.api.internal.zabr
    public final void a() {
        zaaw zaawVar = this.a.get();
        if (zaawVar == null) {
            return;
        }
        zaawVar.x();
    }
}
