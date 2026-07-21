package com.google.firebase;

/* JADX INFO: compiled from: AutoValue_StartupTime.java */
/* JADX INFO: loaded from: classes2.dex */
final class g extends n {
    private final long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f19618b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f19619c;

    g(long j2, long j3, long j4) {
        this.a = j2;
        this.f19618b = j3;
        this.f19619c = j4;
    }

    @Override // com.google.firebase.n
    public long b() {
        return this.f19618b;
    }

    @Override // com.google.firebase.n
    public long c() {
        return this.a;
    }

    @Override // com.google.firebase.n
    public long d() {
        return this.f19619c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return this.a == nVar.c() && this.f19618b == nVar.b() && this.f19619c == nVar.d();
    }

    public int hashCode() {
        long j2 = this.a;
        long j3 = this.f19618b;
        int i2 = (((((int) (j2 ^ (j2 >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003;
        long j4 = this.f19619c;
        return ((int) (j4 ^ (j4 >>> 32))) ^ i2;
    }

    public String toString() {
        return "StartupTime{epochMillis=" + this.a + ", elapsedRealtime=" + this.f19618b + ", uptimeMillis=" + this.f19619c + "}";
    }
}
