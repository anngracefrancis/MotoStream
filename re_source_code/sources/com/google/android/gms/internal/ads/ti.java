package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class ti implements zzbal {
    static final zzbal a = new ti();

    private ti() {
    }

    @Override // com.google.android.gms.internal.ads.zzbal
    public final zzbbh zzf(Object obj) {
        return zzbar.l(((ExecutionException) obj).getCause());
    }
}
