package com.google.firebase.crashlytics.internal.p;

import okhttp3.HttpUrl;

/* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_Event_RolloutAssignment.java */
/* JADX INFO: loaded from: classes2.dex */
final class w extends f0.e.d.AbstractC0226e {
    private final f0.e.d.AbstractC0226e.b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f19488b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f19489c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f19490d;

    /* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_Event_RolloutAssignment.java */
    static final class b extends f0.e.d.AbstractC0226e.a {
        private f0.e.d.AbstractC0226e.b a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f19491b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f19492c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Long f19493d;

        b() {
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.d.AbstractC0226e.a
        public f0.e.d.AbstractC0226e a() {
            f0.e.d.AbstractC0226e.b bVar = this.a;
            String str = HttpUrl.FRAGMENT_ENCODE_SET;
            if (bVar == null) {
                str = HttpUrl.FRAGMENT_ENCODE_SET + " rolloutVariant";
            }
            if (this.f19491b == null) {
                str = str + " parameterKey";
            }
            if (this.f19492c == null) {
                str = str + " parameterValue";
            }
            if (this.f19493d == null) {
                str = str + " templateVersion";
            }
            if (str.isEmpty()) {
                return new w(this.a, this.f19491b, this.f19492c, this.f19493d.longValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.d.AbstractC0226e.a
        public f0.e.d.AbstractC0226e.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null parameterKey");
            }
            this.f19491b = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.d.AbstractC0226e.a
        public f0.e.d.AbstractC0226e.a c(String str) {
            if (str == null) {
                throw new NullPointerException("Null parameterValue");
            }
            this.f19492c = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.d.AbstractC0226e.a
        public f0.e.d.AbstractC0226e.a d(f0.e.d.AbstractC0226e.b bVar) {
            if (bVar == null) {
                throw new NullPointerException("Null rolloutVariant");
            }
            this.a = bVar;
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.d.AbstractC0226e.a
        public f0.e.d.AbstractC0226e.a e(long j2) {
            this.f19493d = Long.valueOf(j2);
            return this;
        }
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.d.AbstractC0226e
    public String b() {
        return this.f19488b;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.d.AbstractC0226e
    public String c() {
        return this.f19489c;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.d.AbstractC0226e
    public f0.e.d.AbstractC0226e.b d() {
        return this.a;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.d.AbstractC0226e
    public long e() {
        return this.f19490d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f0.e.d.AbstractC0226e)) {
            return false;
        }
        f0.e.d.AbstractC0226e abstractC0226e = (f0.e.d.AbstractC0226e) obj;
        return this.a.equals(abstractC0226e.d()) && this.f19488b.equals(abstractC0226e.b()) && this.f19489c.equals(abstractC0226e.c()) && this.f19490d == abstractC0226e.e();
    }

    public int hashCode() {
        int iHashCode = (((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.f19488b.hashCode()) * 1000003) ^ this.f19489c.hashCode()) * 1000003;
        long j2 = this.f19490d;
        return iHashCode ^ ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        return "RolloutAssignment{rolloutVariant=" + this.a + ", parameterKey=" + this.f19488b + ", parameterValue=" + this.f19489c + ", templateVersion=" + this.f19490d + "}";
    }

    private w(f0.e.d.AbstractC0226e.b bVar, String str, String str2, long j2) {
        this.a = bVar;
        this.f19488b = str;
        this.f19489c = str2;
        this.f19490d = j2;
    }
}
