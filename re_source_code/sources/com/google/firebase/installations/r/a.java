package com.google.firebase.installations.r;

/* JADX INFO: compiled from: AutoValue_InstallationResponse.java */
/* JADX INFO: loaded from: classes2.dex */
final class a extends d {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f19720b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f19721c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final f f19722d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final d.b f19723e;

    /* JADX INFO: compiled from: AutoValue_InstallationResponse.java */
    static final class b extends d.a {
        private String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f19724b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f19725c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private f f19726d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private d.b f19727e;

        b() {
        }

        @Override // com.google.firebase.installations.r.d.a
        public d a() {
            return new a(this.a, this.f19724b, this.f19725c, this.f19726d, this.f19727e);
        }

        @Override // com.google.firebase.installations.r.d.a
        public d.a b(f fVar) {
            this.f19726d = fVar;
            return this;
        }

        @Override // com.google.firebase.installations.r.d.a
        public d.a c(String str) {
            this.f19724b = str;
            return this;
        }

        @Override // com.google.firebase.installations.r.d.a
        public d.a d(String str) {
            this.f19725c = str;
            return this;
        }

        @Override // com.google.firebase.installations.r.d.a
        public d.a e(d.b bVar) {
            this.f19727e = bVar;
            return this;
        }

        @Override // com.google.firebase.installations.r.d.a
        public d.a f(String str) {
            this.a = str;
            return this;
        }
    }

    @Override // com.google.firebase.installations.r.d
    public f b() {
        return this.f19722d;
    }

    @Override // com.google.firebase.installations.r.d
    public String c() {
        return this.f19720b;
    }

    @Override // com.google.firebase.installations.r.d
    public String d() {
        return this.f19721c;
    }

    @Override // com.google.firebase.installations.r.d
    public d.b e() {
        return this.f19723e;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        String str = this.a;
        if (str != null ? str.equals(dVar.f()) : dVar.f() == null) {
            String str2 = this.f19720b;
            if (str2 != null ? str2.equals(dVar.c()) : dVar.c() == null) {
                String str3 = this.f19721c;
                if (str3 != null ? str3.equals(dVar.d()) : dVar.d() == null) {
                    f fVar = this.f19722d;
                    if (fVar != null ? fVar.equals(dVar.b()) : dVar.b() == null) {
                        d.b bVar = this.f19723e;
                        if (bVar == null) {
                            if (dVar.e() == null) {
                                return true;
                            }
                        } else if (bVar.equals(dVar.e())) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.firebase.installations.r.d
    public String f() {
        return this.a;
    }

    public int hashCode() {
        String str = this.a;
        int iHashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.f19720b;
        int iHashCode2 = (iHashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f19721c;
        int iHashCode3 = (iHashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        f fVar = this.f19722d;
        int iHashCode4 = (iHashCode3 ^ (fVar == null ? 0 : fVar.hashCode())) * 1000003;
        d.b bVar = this.f19723e;
        return iHashCode4 ^ (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "InstallationResponse{uri=" + this.a + ", fid=" + this.f19720b + ", refreshToken=" + this.f19721c + ", authToken=" + this.f19722d + ", responseCode=" + this.f19723e + "}";
    }

    private a(String str, String str2, String str3, f fVar, d.b bVar) {
        this.a = str;
        this.f19720b = str2;
        this.f19721c = str3;
        this.f19722d = fVar;
        this.f19723e = bVar;
    }
}
