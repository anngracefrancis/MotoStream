package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: loaded from: classes2.dex */
final class c0 implements BaseGmsClient.SignOutCallbacks {
    final /* synthetic */ GoogleApiManager.zaa a;

    c0(GoogleApiManager.zaa zaaVar) {
        this.a = zaaVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.SignOutCallbacks
    public final void a() {
        GoogleApiManager.this.v.post(new d0(this));
    }
}
