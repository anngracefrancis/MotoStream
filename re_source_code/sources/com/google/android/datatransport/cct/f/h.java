package com.google.android.datatransport.cct.f;

/* JADX INFO: compiled from: AutoValue_LogResponse.java */
/* JADX INFO: loaded from: classes2.dex */
final class h extends n {
    private final long a;

    h(long j2) {
        this.a = j2;
    }

    @Override // com.google.android.datatransport.cct.f.n
    public long c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof n) && this.a == ((n) obj).c();
    }

    public int hashCode() {
        long j2 = this.a;
        return 1000003 ^ ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        return "LogResponse{nextRequestWaitMillis=" + this.a + "}";
    }
}
