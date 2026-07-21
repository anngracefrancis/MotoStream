package com.google.android.gms.internal.ads;

import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public enum zzdrn {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf(0.0d)),
    BOOLEAN(Boolean.FALSE),
    STRING(HttpUrl.FRAGMENT_ENCODE_SET),
    BYTE_STRING(zzdmr.f15982f),
    ENUM(null),
    MESSAGE(null);

    private final Object p;

    zzdrn(Object obj) {
        this.p = obj;
    }
}
