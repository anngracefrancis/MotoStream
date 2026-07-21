package com.google.android.gms.common.api;

import com.google.android.gms.common.api.Result;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
public class Response<T extends Result> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Result f11684f;

    protected T f() {
        return (T) this.f11684f;
    }

    public void g(T t) {
        this.f11684f = t;
    }
}
