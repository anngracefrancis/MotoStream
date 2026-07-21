package com.google.firebase.crashlytics.internal.p;

import okhttp3.HttpUrl;

/* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_OperatingSystem.java */
/* JADX INFO: loaded from: classes2.dex */
final class z extends f0.e.AbstractC0227e {
    private final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f19496b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f19497c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f19498d;

    /* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_OperatingSystem.java */
    static final class b extends f0.e.AbstractC0227e.a {
        private Integer a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f19499b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f19500c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Boolean f19501d;

        b() {
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.AbstractC0227e.a
        public f0.e.AbstractC0227e a() {
            Integer num = this.a;
            String str = HttpUrl.FRAGMENT_ENCODE_SET;
            if (num == null) {
                str = HttpUrl.FRAGMENT_ENCODE_SET + " platform";
            }
            if (this.f19499b == null) {
                str = str + " version";
            }
            if (this.f19500c == null) {
                str = str + " buildVersion";
            }
            if (this.f19501d == null) {
                str = str + " jailbroken";
            }
            if (str.isEmpty()) {
                return new z(this.a.intValue(), this.f19499b, this.f19500c, this.f19501d.booleanValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.AbstractC0227e.a
        public f0.e.AbstractC0227e.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null buildVersion");
            }
            this.f19500c = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.AbstractC0227e.a
        public f0.e.AbstractC0227e.a c(boolean z) {
            this.f19501d = Boolean.valueOf(z);
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.AbstractC0227e.a
        public f0.e.AbstractC0227e.a d(int i2) {
            this.a = Integer.valueOf(i2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.AbstractC0227e.a
        public f0.e.AbstractC0227e.a e(String str) {
            if (str == null) {
                throw new NullPointerException("Null version");
            }
            this.f19499b = str;
            return this;
        }
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.AbstractC0227e
    public String b() {
        return this.f19497c;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.AbstractC0227e
    public int c() {
        return this.a;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.AbstractC0227e
    public String d() {
        return this.f19496b;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.AbstractC0227e
    public boolean e() {
        return this.f19498d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f0.e.AbstractC0227e)) {
            return false;
        }
        f0.e.AbstractC0227e abstractC0227e = (f0.e.AbstractC0227e) obj;
        return this.a == abstractC0227e.c() && this.f19496b.equals(abstractC0227e.d()) && this.f19497c.equals(abstractC0227e.b()) && this.f19498d == abstractC0227e.e();
    }

    public int hashCode() {
        return ((((((this.a ^ 1000003) * 1000003) ^ this.f19496b.hashCode()) * 1000003) ^ this.f19497c.hashCode()) * 1000003) ^ (this.f19498d ? 1231 : 1237);
    }

    public String toString() {
        return "OperatingSystem{platform=" + this.a + ", version=" + this.f19496b + ", buildVersion=" + this.f19497c + ", jailbroken=" + this.f19498d + "}";
    }

    private z(int i2, String str, String str2, boolean z) {
        this.a = i2;
        this.f19496b = str;
        this.f19497c = str2;
        this.f19498d = z;
    }
}
