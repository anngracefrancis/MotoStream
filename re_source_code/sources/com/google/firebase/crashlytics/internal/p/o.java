package com.google.firebase.crashlytics.internal.p;

import okhttp3.HttpUrl;

/* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage.java */
/* JADX INFO: loaded from: classes2.dex */
final class o extends f0.e.d.a.b.AbstractC0214a {
    private final long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f19442b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f19443c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f19444d;

    /* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage.java */
    static final class b extends f0.e.d.a.b.AbstractC0214a.AbstractC0215a {
        private Long a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Long f19445b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f19446c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f19447d;

        b() {
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.b.AbstractC0214a.AbstractC0215a
        public f0.e.d.a.b.AbstractC0214a a() {
            Long l = this.a;
            String str = HttpUrl.FRAGMENT_ENCODE_SET;
            if (l == null) {
                str = HttpUrl.FRAGMENT_ENCODE_SET + " baseAddress";
            }
            if (this.f19445b == null) {
                str = str + " size";
            }
            if (this.f19446c == null) {
                str = str + " name";
            }
            if (str.isEmpty()) {
                return new o(this.a.longValue(), this.f19445b.longValue(), this.f19446c, this.f19447d);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.b.AbstractC0214a.AbstractC0215a
        public f0.e.d.a.b.AbstractC0214a.AbstractC0215a b(long j2) {
            this.a = Long.valueOf(j2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.b.AbstractC0214a.AbstractC0215a
        public f0.e.d.a.b.AbstractC0214a.AbstractC0215a c(String str) {
            if (str == null) {
                throw new NullPointerException("Null name");
            }
            this.f19446c = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.b.AbstractC0214a.AbstractC0215a
        public f0.e.d.a.b.AbstractC0214a.AbstractC0215a d(long j2) {
            this.f19445b = Long.valueOf(j2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.b.AbstractC0214a.AbstractC0215a
        public f0.e.d.a.b.AbstractC0214a.AbstractC0215a e(String str) {
            this.f19447d = str;
            return this;
        }
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.b.AbstractC0214a
    public long b() {
        return this.a;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.b.AbstractC0214a
    public String c() {
        return this.f19443c;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.b.AbstractC0214a
    public long d() {
        return this.f19442b;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.b.AbstractC0214a
    public String e() {
        return this.f19444d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f0.e.d.a.b.AbstractC0214a)) {
            return false;
        }
        f0.e.d.a.b.AbstractC0214a abstractC0214a = (f0.e.d.a.b.AbstractC0214a) obj;
        if (this.a == abstractC0214a.b() && this.f19442b == abstractC0214a.d() && this.f19443c.equals(abstractC0214a.c())) {
            String str = this.f19444d;
            if (str == null) {
                if (abstractC0214a.e() == null) {
                    return true;
                }
            } else if (str.equals(abstractC0214a.e())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j2 = this.a;
        long j3 = this.f19442b;
        int iHashCode = (((((((int) (j2 ^ (j2 >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003) ^ this.f19443c.hashCode()) * 1000003;
        String str = this.f19444d;
        return (str == null ? 0 : str.hashCode()) ^ iHashCode;
    }

    public String toString() {
        return "BinaryImage{baseAddress=" + this.a + ", size=" + this.f19442b + ", name=" + this.f19443c + ", uuid=" + this.f19444d + "}";
    }

    private o(long j2, long j3, String str, String str2) {
        this.a = j2;
        this.f19442b = j3;
        this.f19443c = str;
        this.f19444d = str2;
    }
}
