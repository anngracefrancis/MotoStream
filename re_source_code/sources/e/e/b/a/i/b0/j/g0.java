package e.e.b.a.i.b0.j;

import okhttp3.HttpUrl;

/* JADX INFO: compiled from: AutoValue_EventStoreConfig.java */
/* JADX INFO: loaded from: classes2.dex */
final class g0 extends k0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f20764b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f20765c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f20766d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f20767e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f20768f;

    /* JADX INFO: compiled from: AutoValue_EventStoreConfig.java */
    static final class b extends k0.a {
        private Long a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Integer f20769b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Integer f20770c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Long f20771d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Integer f20772e;

        b() {
        }

        @Override // e.e.b.a.i.b0.j.k0.a
        k0 a() {
            Long l = this.a;
            String str = HttpUrl.FRAGMENT_ENCODE_SET;
            if (l == null) {
                str = HttpUrl.FRAGMENT_ENCODE_SET + " maxStorageSizeInBytes";
            }
            if (this.f20769b == null) {
                str = str + " loadBatchSize";
            }
            if (this.f20770c == null) {
                str = str + " criticalSectionEnterTimeoutMs";
            }
            if (this.f20771d == null) {
                str = str + " eventCleanUpAge";
            }
            if (this.f20772e == null) {
                str = str + " maxBlobByteSizePerRow";
            }
            if (str.isEmpty()) {
                return new g0(this.a.longValue(), this.f20769b.intValue(), this.f20770c.intValue(), this.f20771d.longValue(), this.f20772e.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // e.e.b.a.i.b0.j.k0.a
        k0.a b(int i2) {
            this.f20770c = Integer.valueOf(i2);
            return this;
        }

        @Override // e.e.b.a.i.b0.j.k0.a
        k0.a c(long j2) {
            this.f20771d = Long.valueOf(j2);
            return this;
        }

        @Override // e.e.b.a.i.b0.j.k0.a
        k0.a d(int i2) {
            this.f20769b = Integer.valueOf(i2);
            return this;
        }

        @Override // e.e.b.a.i.b0.j.k0.a
        k0.a e(int i2) {
            this.f20772e = Integer.valueOf(i2);
            return this;
        }

        @Override // e.e.b.a.i.b0.j.k0.a
        k0.a f(long j2) {
            this.a = Long.valueOf(j2);
            return this;
        }
    }

    @Override // e.e.b.a.i.b0.j.k0
    int b() {
        return this.f20766d;
    }

    @Override // e.e.b.a.i.b0.j.k0
    long c() {
        return this.f20767e;
    }

    @Override // e.e.b.a.i.b0.j.k0
    int d() {
        return this.f20765c;
    }

    @Override // e.e.b.a.i.b0.j.k0
    int e() {
        return this.f20768f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof k0)) {
            return false;
        }
        k0 k0Var = (k0) obj;
        return this.f20764b == k0Var.f() && this.f20765c == k0Var.d() && this.f20766d == k0Var.b() && this.f20767e == k0Var.c() && this.f20768f == k0Var.e();
    }

    @Override // e.e.b.a.i.b0.j.k0
    long f() {
        return this.f20764b;
    }

    public int hashCode() {
        long j2 = this.f20764b;
        int i2 = (((((((int) (j2 ^ (j2 >>> 32))) ^ 1000003) * 1000003) ^ this.f20765c) * 1000003) ^ this.f20766d) * 1000003;
        long j3 = this.f20767e;
        return this.f20768f ^ ((i2 ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003);
    }

    public String toString() {
        return "EventStoreConfig{maxStorageSizeInBytes=" + this.f20764b + ", loadBatchSize=" + this.f20765c + ", criticalSectionEnterTimeoutMs=" + this.f20766d + ", eventCleanUpAge=" + this.f20767e + ", maxBlobByteSizePerRow=" + this.f20768f + "}";
    }

    private g0(long j2, int i2, int i3, long j3, int i4) {
        this.f20764b = j2;
        this.f20765c = i2;
        this.f20766d = i3;
        this.f20767e = j3;
        this.f20768f = i4;
    }
}
