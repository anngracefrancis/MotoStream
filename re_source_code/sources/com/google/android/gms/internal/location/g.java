package com.google.android.gms.internal.location;

import android.os.DeadObjectException;
import android.os.IInterface;

/* JADX INFO: loaded from: classes2.dex */
final class g implements zzbj<zzao> {
    private final /* synthetic */ zzk a;

    g(zzk zzkVar) {
        this.a = zzkVar;
    }

    @Override // com.google.android.gms.internal.location.zzbj
    public final void a() {
        this.a.checkConnected();
    }

    @Override // com.google.android.gms.internal.location.zzbj
    public final /* synthetic */ IInterface b() throws DeadObjectException {
        return (zzao) this.a.getService();
    }
}
