package com.google.firebase.installations.q;

import okhttp3.HttpUrl;

/* JADX INFO: compiled from: AutoValue_PersistedInstallationEntry.java */
/* JADX INFO: loaded from: classes2.dex */
final class a extends d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f19698b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c.a f19699c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f19700d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f19701e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f19702f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long f19703g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f19704h;

    /* JADX INFO: compiled from: AutoValue_PersistedInstallationEntry.java */
    static final class b extends d.a {
        private String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private c.a f19705b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f19706c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f19707d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Long f19708e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Long f19709f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f19710g;

        @Override // com.google.firebase.installations.q.d.a
        public d a() {
            c.a aVar = this.f19705b;
            String str = HttpUrl.FRAGMENT_ENCODE_SET;
            if (aVar == null) {
                str = HttpUrl.FRAGMENT_ENCODE_SET + " registrationStatus";
            }
            if (this.f19708e == null) {
                str = str + " expiresInSecs";
            }
            if (this.f19709f == null) {
                str = str + " tokenCreationEpochInSecs";
            }
            if (str.isEmpty()) {
                return new a(this.a, this.f19705b, this.f19706c, this.f19707d, this.f19708e.longValue(), this.f19709f.longValue(), this.f19710g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.installations.q.d.a
        public d.a b(String str) {
            this.f19706c = str;
            return this;
        }

        @Override // com.google.firebase.installations.q.d.a
        public d.a c(long j2) {
            this.f19708e = Long.valueOf(j2);
            return this;
        }

        @Override // com.google.firebase.installations.q.d.a
        public d.a d(String str) {
            this.a = str;
            return this;
        }

        @Override // com.google.firebase.installations.q.d.a
        public d.a e(String str) {
            this.f19710g = str;
            return this;
        }

        @Override // com.google.firebase.installations.q.d.a
        public d.a f(String str) {
            this.f19707d = str;
            return this;
        }

        @Override // com.google.firebase.installations.q.d.a
        public d.a g(c.a aVar) {
            if (aVar == null) {
                throw new NullPointerException("Null registrationStatus");
            }
            this.f19705b = aVar;
            return this;
        }

        @Override // com.google.firebase.installations.q.d.a
        public d.a h(long j2) {
            this.f19709f = Long.valueOf(j2);
            return this;
        }

        b() {
        }

        private b(d dVar) {
            this.a = dVar.d();
            this.f19705b = dVar.g();
            this.f19706c = dVar.b();
            this.f19707d = dVar.f();
            this.f19708e = Long.valueOf(dVar.c());
            this.f19709f = Long.valueOf(dVar.h());
            this.f19710g = dVar.e();
        }
    }

    @Override // com.google.firebase.installations.q.d
    public String b() {
        return this.f19700d;
    }

    @Override // com.google.firebase.installations.q.d
    public long c() {
        return this.f19702f;
    }

    @Override // com.google.firebase.installations.q.d
    public String d() {
        return this.f19698b;
    }

    @Override // com.google.firebase.installations.q.d
    public String e() {
        return this.f19704h;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        String str3 = this.f19698b;
        if (str3 != null ? str3.equals(dVar.d()) : dVar.d() == null) {
            if (this.f19699c.equals(dVar.g()) && ((str = this.f19700d) != null ? str.equals(dVar.b()) : dVar.b() == null) && ((str2 = this.f19701e) != null ? str2.equals(dVar.f()) : dVar.f() == null) && this.f19702f == dVar.c() && this.f19703g == dVar.h()) {
                String str4 = this.f19704h;
                if (str4 == null) {
                    if (dVar.e() == null) {
                        return true;
                    }
                } else if (str4.equals(dVar.e())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.firebase.installations.q.d
    public String f() {
        return this.f19701e;
    }

    @Override // com.google.firebase.installations.q.d
    public c.a g() {
        return this.f19699c;
    }

    @Override // com.google.firebase.installations.q.d
    public long h() {
        return this.f19703g;
    }

    public int hashCode() {
        String str = this.f19698b;
        int iHashCode = ((((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ this.f19699c.hashCode()) * 1000003;
        String str2 = this.f19700d;
        int iHashCode2 = (iHashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f19701e;
        int iHashCode3 = (iHashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        long j2 = this.f19702f;
        int i2 = (iHashCode3 ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003;
        long j3 = this.f19703g;
        int i3 = (i2 ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003;
        String str4 = this.f19704h;
        return i3 ^ (str4 != null ? str4.hashCode() : 0);
    }

    @Override // com.google.firebase.installations.q.d
    public d.a n() {
        return new b(this);
    }

    public String toString() {
        return "PersistedInstallationEntry{firebaseInstallationId=" + this.f19698b + ", registrationStatus=" + this.f19699c + ", authToken=" + this.f19700d + ", refreshToken=" + this.f19701e + ", expiresInSecs=" + this.f19702f + ", tokenCreationEpochInSecs=" + this.f19703g + ", fisError=" + this.f19704h + "}";
    }

    private a(String str, c.a aVar, String str2, String str3, long j2, long j3, String str4) {
        this.f19698b = str;
        this.f19699c = aVar;
        this.f19700d = str2;
        this.f19701e = str3;
        this.f19702f = j2;
        this.f19703g = j3;
        this.f19704h = str4;
    }
}
