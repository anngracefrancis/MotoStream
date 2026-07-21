package com.google.firebase.crashlytics.internal.p;

import okhttp3.HttpUrl;

/* JADX INFO: compiled from: AutoValue_CrashlyticsReport.java */
/* JADX INFO: loaded from: classes2.dex */
final class b extends f0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f19301b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f19302c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f19303d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f19304e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f19305f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f19306g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f19307h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f19308i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final f0.e f19309j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final f0.d f19310k;
    private final f0.a l;

    /* JADX INFO: renamed from: com.google.firebase.crashlytics.h.p.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AutoValue_CrashlyticsReport.java */
    static final class C0209b extends f0.b {
        private String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f19311b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Integer f19312c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f19313d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f19314e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f19315f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f19316g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private String f19317h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private f0.e f19318i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private f0.d f19319j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private f0.a f19320k;

        @Override // com.google.firebase.crashlytics.h.p.f0.b
        public f0 a() {
            String str = this.a;
            String str2 = HttpUrl.FRAGMENT_ENCODE_SET;
            if (str == null) {
                str2 = HttpUrl.FRAGMENT_ENCODE_SET + " sdkVersion";
            }
            if (this.f19311b == null) {
                str2 = str2 + " gmpAppId";
            }
            if (this.f19312c == null) {
                str2 = str2 + " platform";
            }
            if (this.f19313d == null) {
                str2 = str2 + " installationUuid";
            }
            if (this.f19316g == null) {
                str2 = str2 + " buildVersion";
            }
            if (this.f19317h == null) {
                str2 = str2 + " displayVersion";
            }
            if (str2.isEmpty()) {
                return new b(this.a, this.f19311b, this.f19312c.intValue(), this.f19313d, this.f19314e, this.f19315f, this.f19316g, this.f19317h, this.f19318i, this.f19319j, this.f19320k);
            }
            throw new IllegalStateException("Missing required properties:" + str2);
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.b
        public f0.b b(f0.a aVar) {
            this.f19320k = aVar;
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.b
        public f0.b c(String str) {
            this.f19315f = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.b
        public f0.b d(String str) {
            if (str == null) {
                throw new NullPointerException("Null buildVersion");
            }
            this.f19316g = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.b
        public f0.b e(String str) {
            if (str == null) {
                throw new NullPointerException("Null displayVersion");
            }
            this.f19317h = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.b
        public f0.b f(String str) {
            this.f19314e = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.b
        public f0.b g(String str) {
            if (str == null) {
                throw new NullPointerException("Null gmpAppId");
            }
            this.f19311b = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.b
        public f0.b h(String str) {
            if (str == null) {
                throw new NullPointerException("Null installationUuid");
            }
            this.f19313d = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.b
        public f0.b i(f0.d dVar) {
            this.f19319j = dVar;
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.b
        public f0.b j(int i2) {
            this.f19312c = Integer.valueOf(i2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.b
        public f0.b k(String str) {
            if (str == null) {
                throw new NullPointerException("Null sdkVersion");
            }
            this.a = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.b
        public f0.b l(f0.e eVar) {
            this.f19318i = eVar;
            return this;
        }

        C0209b() {
        }

        private C0209b(f0 f0Var) {
            this.a = f0Var.l();
            this.f19311b = f0Var.h();
            this.f19312c = Integer.valueOf(f0Var.k());
            this.f19313d = f0Var.i();
            this.f19314e = f0Var.g();
            this.f19315f = f0Var.d();
            this.f19316g = f0Var.e();
            this.f19317h = f0Var.f();
            this.f19318i = f0Var.m();
            this.f19319j = f0Var.j();
            this.f19320k = f0Var.c();
        }
    }

    @Override // com.google.firebase.crashlytics.internal.p.f0
    public f0.a c() {
        return this.l;
    }

    @Override // com.google.firebase.crashlytics.internal.p.f0
    public String d() {
        return this.f19306g;
    }

    @Override // com.google.firebase.crashlytics.internal.p.f0
    public String e() {
        return this.f19307h;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        f0.e eVar;
        f0.d dVar;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f0)) {
            return false;
        }
        f0 f0Var = (f0) obj;
        if (this.f19301b.equals(f0Var.l()) && this.f19302c.equals(f0Var.h()) && this.f19303d == f0Var.k() && this.f19304e.equals(f0Var.i()) && ((str = this.f19305f) != null ? str.equals(f0Var.g()) : f0Var.g() == null) && ((str2 = this.f19306g) != null ? str2.equals(f0Var.d()) : f0Var.d() == null) && this.f19307h.equals(f0Var.e()) && this.f19308i.equals(f0Var.f()) && ((eVar = this.f19309j) != null ? eVar.equals(f0Var.m()) : f0Var.m() == null) && ((dVar = this.f19310k) != null ? dVar.equals(f0Var.j()) : f0Var.j() == null)) {
            f0.a aVar = this.l;
            if (aVar == null) {
                if (f0Var.c() == null) {
                    return true;
                }
            } else if (aVar.equals(f0Var.c())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.p.f0
    public String f() {
        return this.f19308i;
    }

    @Override // com.google.firebase.crashlytics.internal.p.f0
    public String g() {
        return this.f19305f;
    }

    @Override // com.google.firebase.crashlytics.internal.p.f0
    public String h() {
        return this.f19302c;
    }

    public int hashCode() {
        int iHashCode = (((((((this.f19301b.hashCode() ^ 1000003) * 1000003) ^ this.f19302c.hashCode()) * 1000003) ^ this.f19303d) * 1000003) ^ this.f19304e.hashCode()) * 1000003;
        String str = this.f19305f;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f19306g;
        int iHashCode3 = (((((iHashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003) ^ this.f19307h.hashCode()) * 1000003) ^ this.f19308i.hashCode()) * 1000003;
        f0.e eVar = this.f19309j;
        int iHashCode4 = (iHashCode3 ^ (eVar == null ? 0 : eVar.hashCode())) * 1000003;
        f0.d dVar = this.f19310k;
        int iHashCode5 = (iHashCode4 ^ (dVar == null ? 0 : dVar.hashCode())) * 1000003;
        f0.a aVar = this.l;
        return iHashCode5 ^ (aVar != null ? aVar.hashCode() : 0);
    }

    @Override // com.google.firebase.crashlytics.internal.p.f0
    public String i() {
        return this.f19304e;
    }

    @Override // com.google.firebase.crashlytics.internal.p.f0
    public f0.d j() {
        return this.f19310k;
    }

    @Override // com.google.firebase.crashlytics.internal.p.f0
    public int k() {
        return this.f19303d;
    }

    @Override // com.google.firebase.crashlytics.internal.p.f0
    public String l() {
        return this.f19301b;
    }

    @Override // com.google.firebase.crashlytics.internal.p.f0
    public f0.e m() {
        return this.f19309j;
    }

    @Override // com.google.firebase.crashlytics.internal.p.f0
    protected f0.b n() {
        return new C0209b(this);
    }

    public String toString() {
        return "CrashlyticsReport{sdkVersion=" + this.f19301b + ", gmpAppId=" + this.f19302c + ", platform=" + this.f19303d + ", installationUuid=" + this.f19304e + ", firebaseInstallationId=" + this.f19305f + ", appQualitySessionId=" + this.f19306g + ", buildVersion=" + this.f19307h + ", displayVersion=" + this.f19308i + ", session=" + this.f19309j + ", ndkPayload=" + this.f19310k + ", appExitInfo=" + this.l + "}";
    }

    private b(String str, String str2, int i2, String str3, String str4, String str5, String str6, String str7, f0.e eVar, f0.d dVar, f0.a aVar) {
        this.f19301b = str;
        this.f19302c = str2;
        this.f19303d = i2;
        this.f19304e = str3;
        this.f19305f = str4;
        this.f19306g = str5;
        this.f19307h = str6;
        this.f19308i = str7;
        this.f19309j = eVar;
        this.f19310k = dVar;
        this.l = aVar;
    }
}
