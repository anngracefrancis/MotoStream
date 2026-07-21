package com.google.firebase.crashlytics.internal.p;

import okhttp3.HttpUrl;

/* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_Event_Application_ProcessDetails.java */
/* JADX INFO: loaded from: classes2.dex */
final class t extends f0.e.d.a.c {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f19472b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f19473c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f19474d;

    /* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_Event_Application_ProcessDetails.java */
    static final class b extends f0.e.d.a.c.AbstractC0224a {
        private String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Integer f19475b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Integer f19476c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Boolean f19477d;

        b() {
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.c.AbstractC0224a
        public f0.e.d.a.c a() {
            String str = this.a;
            String str2 = HttpUrl.FRAGMENT_ENCODE_SET;
            if (str == null) {
                str2 = HttpUrl.FRAGMENT_ENCODE_SET + " processName";
            }
            if (this.f19475b == null) {
                str2 = str2 + " pid";
            }
            if (this.f19476c == null) {
                str2 = str2 + " importance";
            }
            if (this.f19477d == null) {
                str2 = str2 + " defaultProcess";
            }
            if (str2.isEmpty()) {
                return new t(this.a, this.f19475b.intValue(), this.f19476c.intValue(), this.f19477d.booleanValue());
            }
            throw new IllegalStateException("Missing required properties:" + str2);
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.c.AbstractC0224a
        public f0.e.d.a.c.AbstractC0224a b(boolean z) {
            this.f19477d = Boolean.valueOf(z);
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.c.AbstractC0224a
        public f0.e.d.a.c.AbstractC0224a c(int i2) {
            this.f19476c = Integer.valueOf(i2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.c.AbstractC0224a
        public f0.e.d.a.c.AbstractC0224a d(int i2) {
            this.f19475b = Integer.valueOf(i2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.c.AbstractC0224a
        public f0.e.d.a.c.AbstractC0224a e(String str) {
            if (str == null) {
                throw new NullPointerException("Null processName");
            }
            this.a = str;
            return this;
        }
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.c
    public int b() {
        return this.f19473c;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.c
    public int c() {
        return this.f19472b;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.c
    public String d() {
        return this.a;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.c
    public boolean e() {
        return this.f19474d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f0.e.d.a.c)) {
            return false;
        }
        f0.e.d.a.c cVar = (f0.e.d.a.c) obj;
        return this.a.equals(cVar.d()) && this.f19472b == cVar.c() && this.f19473c == cVar.b() && this.f19474d == cVar.e();
    }

    public int hashCode() {
        return ((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.f19472b) * 1000003) ^ this.f19473c) * 1000003) ^ (this.f19474d ? 1231 : 1237);
    }

    public String toString() {
        return "ProcessDetails{processName=" + this.a + ", pid=" + this.f19472b + ", importance=" + this.f19473c + ", defaultProcess=" + this.f19474d + "}";
    }

    private t(String str, int i2, int i3, boolean z) {
        this.a = str;
        this.f19472b = i2;
        this.f19473c = i3;
        this.f19474d = z;
    }
}
