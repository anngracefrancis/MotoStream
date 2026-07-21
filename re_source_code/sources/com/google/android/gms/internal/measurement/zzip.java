package com.google.android.gms.internal.measurement;

import okhttp3.HttpUrl;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public enum zzip {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf(0.0d)),
    BOOLEAN(Boolean.FALSE),
    STRING(HttpUrl.FRAGMENT_ENCODE_SET),
    BYTE_STRING(zzdu.f17368f),
    ENUM(null),
    MESSAGE(null);

    private final Object p;

    zzip(Object obj) {
        this.p = obj;
    }
}
