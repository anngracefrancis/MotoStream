package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;

/* JADX INFO: loaded from: classes2.dex */
public final class zabw {
    public final RegisterListenerMethod<Api.AnyClient, ?> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final UnregisterListenerMethod<Api.AnyClient, ?> f11836b;

    public zabw(RegisterListenerMethod<Api.AnyClient, ?> registerListenerMethod, UnregisterListenerMethod<Api.AnyClient, ?> unregisterListenerMethod) {
        this.a = registerListenerMethod;
        this.f11836b = unregisterListenerMethod;
    }
}
