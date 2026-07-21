package com.google.firebase.crashlytics.internal.p;

import okhttp3.HttpUrl;

/* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_Application.java */
/* JADX INFO: loaded from: classes2.dex */
final class i extends f0.e.a {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f19384b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f19385c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final f0.e.a.b f19386d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f19387e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f19388f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f19389g;

    /* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_Application.java */
    static final class b extends f0.e.a.AbstractC0212a {
        private String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f19390b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f19391c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private f0.e.a.b f19392d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f19393e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f19394f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f19395g;

        b() {
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.a.AbstractC0212a
        public f0.e.a a() {
            String str = this.a;
            String str2 = HttpUrl.FRAGMENT_ENCODE_SET;
            if (str == null) {
                str2 = HttpUrl.FRAGMENT_ENCODE_SET + " identifier";
            }
            if (this.f19390b == null) {
                str2 = str2 + " version";
            }
            if (str2.isEmpty()) {
                return new i(this.a, this.f19390b, this.f19391c, this.f19392d, this.f19393e, this.f19394f, this.f19395g);
            }
            throw new IllegalStateException("Missing required properties:" + str2);
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.a.AbstractC0212a
        public f0.e.a.AbstractC0212a b(String str) {
            this.f19394f = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.a.AbstractC0212a
        public f0.e.a.AbstractC0212a c(String str) {
            this.f19395g = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.a.AbstractC0212a
        public f0.e.a.AbstractC0212a d(String str) {
            this.f19391c = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.a.AbstractC0212a
        public f0.e.a.AbstractC0212a e(String str) {
            if (str == null) {
                throw new NullPointerException("Null identifier");
            }
            this.a = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.a.AbstractC0212a
        public f0.e.a.AbstractC0212a f(String str) {
            this.f19393e = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.a.AbstractC0212a
        public f0.e.a.AbstractC0212a g(String str) {
            if (str == null) {
                throw new NullPointerException("Null version");
            }
            this.f19390b = str;
            return this;
        }
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.a
    public String b() {
        return this.f19388f;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.a
    public String c() {
        return this.f19389g;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.a
    public String d() {
        return this.f19385c;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.a
    public String e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        String str;
        f0.e.a.b bVar;
        String str2;
        String str3;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f0.e.a)) {
            return false;
        }
        f0.e.a aVar = (f0.e.a) obj;
        if (this.a.equals(aVar.e()) && this.f19384b.equals(aVar.h()) && ((str = this.f19385c) != null ? str.equals(aVar.d()) : aVar.d() == null) && ((bVar = this.f19386d) != null ? bVar.equals(aVar.g()) : aVar.g() == null) && ((str2 = this.f19387e) != null ? str2.equals(aVar.f()) : aVar.f() == null) && ((str3 = this.f19388f) != null ? str3.equals(aVar.b()) : aVar.b() == null)) {
            String str4 = this.f19389g;
            if (str4 == null) {
                if (aVar.c() == null) {
                    return true;
                }
            } else if (str4.equals(aVar.c())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.a
    public String f() {
        return this.f19387e;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.a
    public f0.e.a.b g() {
        return this.f19386d;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.a
    public String h() {
        return this.f19384b;
    }

    public int hashCode() {
        int iHashCode = (((this.a.hashCode() ^ 1000003) * 1000003) ^ this.f19384b.hashCode()) * 1000003;
        String str = this.f19385c;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        f0.e.a.b bVar = this.f19386d;
        int iHashCode3 = (iHashCode2 ^ (bVar == null ? 0 : bVar.hashCode())) * 1000003;
        String str2 = this.f19387e;
        int iHashCode4 = (iHashCode3 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f19388f;
        int iHashCode5 = (iHashCode4 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.f19389g;
        return iHashCode5 ^ (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "Application{identifier=" + this.a + ", version=" + this.f19384b + ", displayVersion=" + this.f19385c + ", organization=" + this.f19386d + ", installationUuid=" + this.f19387e + ", developmentPlatform=" + this.f19388f + ", developmentPlatformVersion=" + this.f19389g + "}";
    }

    private i(String str, String str2, String str3, f0.e.a.b bVar, String str4, String str5, String str6) {
        this.a = str;
        this.f19384b = str2;
        this.f19385c = str3;
        this.f19386d = bVar;
        this.f19387e = str4;
        this.f19388f = str5;
        this.f19389g = str6;
    }
}
