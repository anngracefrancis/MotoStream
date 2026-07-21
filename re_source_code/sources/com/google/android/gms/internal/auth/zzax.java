package com.google.android.gms.internal.auth;

import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes2.dex */
public final class zzax implements ProxyApi.SpatulaHeaderResult {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Status f17039f;

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f17039f;
    }
}
