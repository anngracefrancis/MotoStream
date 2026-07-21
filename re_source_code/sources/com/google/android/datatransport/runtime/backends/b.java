package com.google.android.datatransport.runtime.backends;

/* JADX INFO: compiled from: AutoValue_BackendResponse.java */
/* JADX INFO: loaded from: classes2.dex */
final class b extends g {
    private final g.a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f11303b;

    b(g.a aVar, long j2) {
        if (aVar == null) {
            throw new NullPointerException("Null status");
        }
        this.a = aVar;
        this.f11303b = j2;
    }

    @Override // com.google.android.datatransport.runtime.backends.g
    public long b() {
        return this.f11303b;
    }

    @Override // com.google.android.datatransport.runtime.backends.g
    public g.a c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.a.equals(gVar.c()) && this.f11303b == gVar.b();
    }

    public int hashCode() {
        int iHashCode = (this.a.hashCode() ^ 1000003) * 1000003;
        long j2 = this.f11303b;
        return iHashCode ^ ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        return "BackendResponse{status=" + this.a + ", nextRequestWaitMillis=" + this.f11303b + "}";
    }
}
