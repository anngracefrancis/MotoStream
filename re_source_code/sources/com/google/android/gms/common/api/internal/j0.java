package com.google.android.gms.common.api.internal;

/* JADX INFO: loaded from: classes2.dex */
final class j0 implements l0 {
    private final /* synthetic */ zacp a;

    j0(zacp zacpVar) {
        this.a = zacpVar;
    }

    @Override // com.google.android.gms.common.api.internal.l0
    public final void a(BasePendingResult<?> basePendingResult) {
        this.a.f11850c.remove(basePendingResult);
    }
}
