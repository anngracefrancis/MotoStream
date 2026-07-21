package com.google.firebase.crashlytics.internal.p;

import okhttp3.HttpUrl;

/* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_Event.java */
/* JADX INFO: loaded from: classes2.dex */
final class l extends f0.e.d {
    private final long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f19412b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final f0.e.d.a f19413c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final f0.e.d.c f19414d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final f0.e.d.AbstractC0225d f19415e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final f0.e.d.f f19416f;

    /* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_Event.java */
    static final class b extends f0.e.d.b {
        private Long a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f19417b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private f0.e.d.a f19418c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private f0.e.d.c f19419d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private f0.e.d.AbstractC0225d f19420e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private f0.e.d.f f19421f;

        @Override // com.google.firebase.crashlytics.h.p.f0.e.d.b
        public f0.e.d a() {
            Long l = this.a;
            String str = HttpUrl.FRAGMENT_ENCODE_SET;
            if (l == null) {
                str = HttpUrl.FRAGMENT_ENCODE_SET + " timestamp";
            }
            if (this.f19417b == null) {
                str = str + " type";
            }
            if (this.f19418c == null) {
                str = str + " app";
            }
            if (this.f19419d == null) {
                str = str + " device";
            }
            if (str.isEmpty()) {
                return new l(this.a.longValue(), this.f19417b, this.f19418c, this.f19419d, this.f19420e, this.f19421f);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.d.b
        public f0.e.d.b b(f0.e.d.a aVar) {
            if (aVar == null) {
                throw new NullPointerException("Null app");
            }
            this.f19418c = aVar;
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.d.b
        public f0.e.d.b c(f0.e.d.c cVar) {
            if (cVar == null) {
                throw new NullPointerException("Null device");
            }
            this.f19419d = cVar;
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.d.b
        public f0.e.d.b d(f0.e.d.AbstractC0225d abstractC0225d) {
            this.f19420e = abstractC0225d;
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.d.b
        public f0.e.d.b e(f0.e.d.f fVar) {
            this.f19421f = fVar;
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.d.b
        public f0.e.d.b f(long j2) {
            this.a = Long.valueOf(j2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.d.b
        public f0.e.d.b g(String str) {
            if (str == null) {
                throw new NullPointerException("Null type");
            }
            this.f19417b = str;
            return this;
        }

        b() {
        }

        private b(f0.e.d dVar) {
            this.a = Long.valueOf(dVar.f());
            this.f19417b = dVar.g();
            this.f19418c = dVar.b();
            this.f19419d = dVar.c();
            this.f19420e = dVar.d();
            this.f19421f = dVar.e();
        }
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.d
    public f0.e.d.a b() {
        return this.f19413c;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.d
    public f0.e.d.c c() {
        return this.f19414d;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.d
    public f0.e.d.AbstractC0225d d() {
        return this.f19415e;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.d
    public f0.e.d.f e() {
        return this.f19416f;
    }

    public boolean equals(Object obj) {
        f0.e.d.AbstractC0225d abstractC0225d;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f0.e.d)) {
            return false;
        }
        f0.e.d dVar = (f0.e.d) obj;
        if (this.a == dVar.f() && this.f19412b.equals(dVar.g()) && this.f19413c.equals(dVar.b()) && this.f19414d.equals(dVar.c()) && ((abstractC0225d = this.f19415e) != null ? abstractC0225d.equals(dVar.d()) : dVar.d() == null)) {
            f0.e.d.f fVar = this.f19416f;
            if (fVar == null) {
                if (dVar.e() == null) {
                    return true;
                }
            } else if (fVar.equals(dVar.e())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.d
    public long f() {
        return this.a;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.d
    public String g() {
        return this.f19412b;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.d
    public f0.e.d.b h() {
        return new b(this);
    }

    public int hashCode() {
        long j2 = this.a;
        int iHashCode = (((((((((int) (j2 ^ (j2 >>> 32))) ^ 1000003) * 1000003) ^ this.f19412b.hashCode()) * 1000003) ^ this.f19413c.hashCode()) * 1000003) ^ this.f19414d.hashCode()) * 1000003;
        f0.e.d.AbstractC0225d abstractC0225d = this.f19415e;
        int iHashCode2 = (iHashCode ^ (abstractC0225d == null ? 0 : abstractC0225d.hashCode())) * 1000003;
        f0.e.d.f fVar = this.f19416f;
        return iHashCode2 ^ (fVar != null ? fVar.hashCode() : 0);
    }

    public String toString() {
        return "Event{timestamp=" + this.a + ", type=" + this.f19412b + ", app=" + this.f19413c + ", device=" + this.f19414d + ", log=" + this.f19415e + ", rollouts=" + this.f19416f + "}";
    }

    private l(long j2, String str, f0.e.d.a aVar, f0.e.d.c cVar, f0.e.d.AbstractC0225d abstractC0225d, f0.e.d.f fVar) {
        this.a = j2;
        this.f19412b = str;
        this.f19413c = aVar;
        this.f19414d = cVar;
        this.f19415e = abstractC0225d;
        this.f19416f = fVar;
    }
}
