package com.google.android.gms.common.api;

import okhttp3.HttpUrl;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
public class ApiException extends Exception {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Deprecated
    protected final Status f11655f;

    public ApiException(Status status) {
        super(status.z() + ": " + (status.W() != null ? status.W() : HttpUrl.FRAGMENT_ENCODE_SET));
        this.f11655f = status;
    }
}
