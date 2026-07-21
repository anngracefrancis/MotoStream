package com.google.android.gms.common;

import com.google.android.gms.common.annotation.KeepName;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
@KeepName
public class GooglePlayServicesManifestException extends IllegalStateException {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f11637f;

    public GooglePlayServicesManifestException(int i2, String str) {
        super(str);
        this.f11637f = i2;
    }
}
