package com.google.firebase.installations;

import okhttp3.HttpUrl;

/* JADX INFO: compiled from: AutoValue_InstallationTokenResult.java */
/* JADX INFO: loaded from: classes2.dex */
final class f extends l {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f19676b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f19677c;

    /* JADX INFO: compiled from: AutoValue_InstallationTokenResult.java */
    static final class b extends l.a {
        private String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Long f19678b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Long f19679c;

        b() {
        }

        @Override // com.google.firebase.installations.l.a
        public l a() {
            String str = this.a;
            String str2 = HttpUrl.FRAGMENT_ENCODE_SET;
            if (str == null) {
                str2 = HttpUrl.FRAGMENT_ENCODE_SET + " token";
            }
            if (this.f19678b == null) {
                str2 = str2 + " tokenExpirationTimestamp";
            }
            if (this.f19679c == null) {
                str2 = str2 + " tokenCreationTimestamp";
            }
            if (str2.isEmpty()) {
                return new f(this.a, this.f19678b.longValue(), this.f19679c.longValue());
            }
            throw new IllegalStateException("Missing required properties:" + str2);
        }

        @Override // com.google.firebase.installations.l.a
        public l.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null token");
            }
            this.a = str;
            return this;
        }

        @Override // com.google.firebase.installations.l.a
        public l.a c(long j2) {
            this.f19679c = Long.valueOf(j2);
            return this;
        }

        @Override // com.google.firebase.installations.l.a
        public l.a d(long j2) {
            this.f19678b = Long.valueOf(j2);
            return this;
        }
    }

    @Override // com.google.firebase.installations.l
    public String b() {
        return this.a;
    }

    @Override // com.google.firebase.installations.l
    public long c() {
        return this.f19677c;
    }

    @Override // com.google.firebase.installations.l
    public long d() {
        return this.f19676b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return this.a.equals(lVar.b()) && this.f19676b == lVar.d() && this.f19677c == lVar.c();
    }

    public int hashCode() {
        int iHashCode = (this.a.hashCode() ^ 1000003) * 1000003;
        long j2 = this.f19676b;
        long j3 = this.f19677c;
        return ((iHashCode ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ ((int) (j3 ^ (j3 >>> 32)));
    }

    public String toString() {
        return "InstallationTokenResult{token=" + this.a + ", tokenExpirationTimestamp=" + this.f19676b + ", tokenCreationTimestamp=" + this.f19677c + "}";
    }

    private f(String str, long j2, long j3) {
        this.a = str;
        this.f19676b = j2;
        this.f19677c = j3;
    }
}
