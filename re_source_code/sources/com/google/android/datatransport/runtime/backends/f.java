package com.google.android.datatransport.runtime.backends;

import com.google.auto.value.AutoValue;

/* JADX INFO: compiled from: BackendRequest.java */
/* JADX INFO: loaded from: classes2.dex */
@AutoValue
public abstract class f {

    /* JADX INFO: compiled from: BackendRequest.java */
    @AutoValue.Builder
    public static abstract class a {
        public abstract f a();

        public abstract a b(Iterable<e.e.b.a.i.j> iterable);

        public abstract a c(byte[] bArr);
    }

    public static a a() {
        return new com.google.android.datatransport.runtime.backends.a.b();
    }

    public abstract Iterable<e.e.b.a.i.j> b();

    public abstract byte[] c();
}
