package com.google.firebase.installations.r;

import com.google.auto.value.AutoValue;

/* JADX INFO: compiled from: TokenResult.java */
/* JADX INFO: loaded from: classes2.dex */
@AutoValue
public abstract class f {

    /* JADX INFO: compiled from: TokenResult.java */
    @AutoValue.Builder
    public static abstract class a {
        public abstract f a();

        public abstract a b(b bVar);

        public abstract a c(String str);

        public abstract a d(long j2);
    }

    /* JADX INFO: compiled from: TokenResult.java */
    public enum b {
        OK,
        BAD_CONFIG,
        AUTH_ERROR
    }

    public static a a() {
        return new com.google.firebase.installations.r.b.C0232b().d(0L);
    }

    public abstract b b();

    public abstract String c();

    public abstract long d();
}
