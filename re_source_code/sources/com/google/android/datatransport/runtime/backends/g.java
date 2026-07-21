package com.google.android.datatransport.runtime.backends;

import com.google.auto.value.AutoValue;

/* JADX INFO: compiled from: BackendResponse.java */
/* JADX INFO: loaded from: classes2.dex */
@AutoValue
public abstract class g {

    /* JADX INFO: compiled from: BackendResponse.java */
    public enum a {
        OK,
        TRANSIENT_ERROR,
        FATAL_ERROR,
        INVALID_PAYLOAD
    }

    public static g a() {
        return new b(a.FATAL_ERROR, -1L);
    }

    public static g d() {
        return new b(a.INVALID_PAYLOAD, -1L);
    }

    public static g e(long j2) {
        return new b(a.OK, j2);
    }

    public static g f() {
        return new b(a.TRANSIENT_ERROR, -1L);
    }

    public abstract long b();

    public abstract a c();
}
