package com.google.android.gms.common.api;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class UnsupportedApiCallException extends UnsupportedOperationException {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Feature f11693f;

    @KeepForSdk
    public UnsupportedApiCallException(Feature feature) {
        this.f11693f = feature;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return "Missing ".concat(String.valueOf(this.f11693f));
    }
}
