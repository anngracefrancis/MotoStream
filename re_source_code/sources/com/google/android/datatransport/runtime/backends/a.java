package com.google.android.datatransport.runtime.backends;

import java.util.Arrays;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: AutoValue_BackendRequest.java */
/* JADX INFO: loaded from: classes2.dex */
final class a extends f {
    private final Iterable<e.e.b.a.i.j> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte[] f11301b;

    /* JADX INFO: compiled from: AutoValue_BackendRequest.java */
    static final class b extends f.a {
        private Iterable<e.e.b.a.i.j> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private byte[] f11302b;

        b() {
        }

        @Override // com.google.android.datatransport.runtime.backends.f.a
        public f a() {
            Iterable<e.e.b.a.i.j> iterable = this.a;
            String str = HttpUrl.FRAGMENT_ENCODE_SET;
            if (iterable == null) {
                str = HttpUrl.FRAGMENT_ENCODE_SET + " events";
            }
            if (str.isEmpty()) {
                return new a(this.a, this.f11302b);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.runtime.backends.f.a
        public f.a b(Iterable<e.e.b.a.i.j> iterable) {
            if (iterable == null) {
                throw new NullPointerException("Null events");
            }
            this.a = iterable;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.backends.f.a
        public f.a c(byte[] bArr) {
            this.f11302b = bArr;
            return this;
        }
    }

    @Override // com.google.android.datatransport.runtime.backends.f
    public Iterable<e.e.b.a.i.j> b() {
        return this.a;
    }

    @Override // com.google.android.datatransport.runtime.backends.f
    public byte[] c() {
        return this.f11301b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        if (this.a.equals(fVar.b())) {
            if (Arrays.equals(this.f11301b, fVar instanceof a ? ((a) fVar).f11301b : fVar.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f11301b);
    }

    public String toString() {
        return "BackendRequest{events=" + this.a + ", extras=" + Arrays.toString(this.f11301b) + "}";
    }

    private a(Iterable<e.e.b.a.i.j> iterable, byte[] bArr) {
        this.a = iterable;
        this.f11301b = bArr;
    }
}
