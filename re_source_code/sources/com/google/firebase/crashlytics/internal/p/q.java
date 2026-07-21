package com.google.firebase.crashlytics.internal.p;

import okhttp3.HttpUrl;

/* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal.java */
/* JADX INFO: loaded from: classes2.dex */
final class q extends f0.e.d.a.b.AbstractC0218d {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f19456b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f19457c;

    /* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal.java */
    static final class b extends f0.e.d.a.b.AbstractC0218d.AbstractC0219a {
        private String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f19458b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Long f19459c;

        b() {
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.b.AbstractC0218d.AbstractC0219a
        public f0.e.d.a.b.AbstractC0218d a() {
            String str = this.a;
            String str2 = HttpUrl.FRAGMENT_ENCODE_SET;
            if (str == null) {
                str2 = HttpUrl.FRAGMENT_ENCODE_SET + " name";
            }
            if (this.f19458b == null) {
                str2 = str2 + " code";
            }
            if (this.f19459c == null) {
                str2 = str2 + " address";
            }
            if (str2.isEmpty()) {
                return new q(this.a, this.f19458b, this.f19459c.longValue());
            }
            throw new IllegalStateException("Missing required properties:" + str2);
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.b.AbstractC0218d.AbstractC0219a
        public f0.e.d.a.b.AbstractC0218d.AbstractC0219a b(long j2) {
            this.f19459c = Long.valueOf(j2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.b.AbstractC0218d.AbstractC0219a
        public f0.e.d.a.b.AbstractC0218d.AbstractC0219a c(String str) {
            if (str == null) {
                throw new NullPointerException("Null code");
            }
            this.f19458b = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.b.AbstractC0218d.AbstractC0219a
        public f0.e.d.a.b.AbstractC0218d.AbstractC0219a d(String str) {
            if (str == null) {
                throw new NullPointerException("Null name");
            }
            this.a = str;
            return this;
        }
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.b.AbstractC0218d
    public long b() {
        return this.f19457c;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.b.AbstractC0218d
    public String c() {
        return this.f19456b;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.b.AbstractC0218d
    public String d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f0.e.d.a.b.AbstractC0218d)) {
            return false;
        }
        f0.e.d.a.b.AbstractC0218d abstractC0218d = (f0.e.d.a.b.AbstractC0218d) obj;
        return this.a.equals(abstractC0218d.d()) && this.f19456b.equals(abstractC0218d.c()) && this.f19457c == abstractC0218d.b();
    }

    public int hashCode() {
        int iHashCode = (((this.a.hashCode() ^ 1000003) * 1000003) ^ this.f19456b.hashCode()) * 1000003;
        long j2 = this.f19457c;
        return iHashCode ^ ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        return "Signal{name=" + this.a + ", code=" + this.f19456b + ", address=" + this.f19457c + "}";
    }

    private q(String str, String str2, long j2) {
        this.a = str;
        this.f19456b = str2;
        this.f19457c = j2;
    }
}
