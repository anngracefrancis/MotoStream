package com.google.firebase.installations.r;

import okhttp3.HttpUrl;

/* JADX INFO: compiled from: AutoValue_TokenResult.java */
/* JADX INFO: loaded from: classes2.dex */
final class b extends f {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f19728b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final f.b f19729c;

    /* JADX INFO: renamed from: com.google.firebase.installations.r.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AutoValue_TokenResult.java */
    static final class C0232b extends f.a {
        private String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Long f19730b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private f.b f19731c;

        C0232b() {
        }

        @Override // com.google.firebase.installations.r.f.a
        public f a() {
            Long l = this.f19730b;
            String str = HttpUrl.FRAGMENT_ENCODE_SET;
            if (l == null) {
                str = HttpUrl.FRAGMENT_ENCODE_SET + " tokenExpirationTimestamp";
            }
            if (str.isEmpty()) {
                return new b(this.a, this.f19730b.longValue(), this.f19731c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.installations.r.f.a
        public f.a b(f.b bVar) {
            this.f19731c = bVar;
            return this;
        }

        @Override // com.google.firebase.installations.r.f.a
        public f.a c(String str) {
            this.a = str;
            return this;
        }

        @Override // com.google.firebase.installations.r.f.a
        public f.a d(long j2) {
            this.f19730b = Long.valueOf(j2);
            return this;
        }
    }

    @Override // com.google.firebase.installations.r.f
    public f.b b() {
        return this.f19729c;
    }

    @Override // com.google.firebase.installations.r.f
    public String c() {
        return this.a;
    }

    @Override // com.google.firebase.installations.r.f
    public long d() {
        return this.f19728b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        String str = this.a;
        if (str != null ? str.equals(fVar.c()) : fVar.c() == null) {
            if (this.f19728b == fVar.d()) {
                f.b bVar = this.f19729c;
                if (bVar == null) {
                    if (fVar.b() == null) {
                        return true;
                    }
                } else if (bVar.equals(fVar.b())) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.a;
        int iHashCode = str == null ? 0 : str.hashCode();
        long j2 = this.f19728b;
        int i2 = (((iHashCode ^ 1000003) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003;
        f.b bVar = this.f19729c;
        return i2 ^ (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "TokenResult{token=" + this.a + ", tokenExpirationTimestamp=" + this.f19728b + ", responseCode=" + this.f19729c + "}";
    }

    private b(String str, long j2, f.b bVar) {
        this.a = str;
        this.f19728b = j2;
        this.f19729c = bVar;
    }
}
