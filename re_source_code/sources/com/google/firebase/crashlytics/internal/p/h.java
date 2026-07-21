package com.google.firebase.crashlytics.internal.p;

import java.util.List;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session.java */
/* JADX INFO: loaded from: classes2.dex */
final class h extends f0.e {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f19364b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f19365c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f19366d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Long f19367e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f19368f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final f0.e.a f19369g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final f0.e.f f19370h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final f0.e.AbstractC0227e f19371i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final f0.e.c f19372j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final List<f0.e.d> f19373k;
    private final int l;

    /* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session.java */
    static final class b extends f0.e.b {
        private String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f19374b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f19375c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Long f19376d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Long f19377e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Boolean f19378f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private f0.e.a f19379g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private f0.e.f f19380h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private f0.e.AbstractC0227e f19381i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private f0.e.c f19382j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private List<f0.e.d> f19383k;
        private Integer l;

        @Override // com.google.firebase.crashlytics.h.p.f0.e.b
        public f0.e a() {
            String str = this.a;
            String str2 = HttpUrl.FRAGMENT_ENCODE_SET;
            if (str == null) {
                str2 = HttpUrl.FRAGMENT_ENCODE_SET + " generator";
            }
            if (this.f19374b == null) {
                str2 = str2 + " identifier";
            }
            if (this.f19376d == null) {
                str2 = str2 + " startedAt";
            }
            if (this.f19378f == null) {
                str2 = str2 + " crashed";
            }
            if (this.f19379g == null) {
                str2 = str2 + " app";
            }
            if (this.l == null) {
                str2 = str2 + " generatorType";
            }
            if (str2.isEmpty()) {
                return new h(this.a, this.f19374b, this.f19375c, this.f19376d.longValue(), this.f19377e, this.f19378f.booleanValue(), this.f19379g, this.f19380h, this.f19381i, this.f19382j, this.f19383k, this.l.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str2);
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.b
        public f0.e.b b(f0.e.a aVar) {
            if (aVar == null) {
                throw new NullPointerException("Null app");
            }
            this.f19379g = aVar;
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.b
        public f0.e.b c(String str) {
            this.f19375c = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.b
        public f0.e.b d(boolean z) {
            this.f19378f = Boolean.valueOf(z);
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.b
        public f0.e.b e(f0.e.c cVar) {
            this.f19382j = cVar;
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.b
        public f0.e.b f(Long l) {
            this.f19377e = l;
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.b
        public f0.e.b g(List<f0.e.d> list) {
            this.f19383k = list;
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.b
        public f0.e.b h(String str) {
            if (str == null) {
                throw new NullPointerException("Null generator");
            }
            this.a = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.b
        public f0.e.b i(int i2) {
            this.l = Integer.valueOf(i2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.b
        public f0.e.b j(String str) {
            if (str == null) {
                throw new NullPointerException("Null identifier");
            }
            this.f19374b = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.b
        public f0.e.b l(f0.e.AbstractC0227e abstractC0227e) {
            this.f19381i = abstractC0227e;
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.b
        public f0.e.b m(long j2) {
            this.f19376d = Long.valueOf(j2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.b
        public f0.e.b n(f0.e.f fVar) {
            this.f19380h = fVar;
            return this;
        }

        b() {
        }

        private b(f0.e eVar) {
            this.a = eVar.g();
            this.f19374b = eVar.i();
            this.f19375c = eVar.c();
            this.f19376d = Long.valueOf(eVar.l());
            this.f19377e = eVar.e();
            this.f19378f = Boolean.valueOf(eVar.n());
            this.f19379g = eVar.b();
            this.f19380h = eVar.m();
            this.f19381i = eVar.k();
            this.f19382j = eVar.d();
            this.f19383k = eVar.f();
            this.l = Integer.valueOf(eVar.h());
        }
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e
    public f0.e.a b() {
        return this.f19369g;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e
    public String c() {
        return this.f19365c;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e
    public f0.e.c d() {
        return this.f19372j;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e
    public Long e() {
        return this.f19367e;
    }

    public boolean equals(Object obj) {
        String str;
        Long l;
        f0.e.f fVar;
        f0.e.AbstractC0227e abstractC0227e;
        f0.e.c cVar;
        List<f0.e.d> list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f0.e)) {
            return false;
        }
        f0.e eVar = (f0.e) obj;
        return this.a.equals(eVar.g()) && this.f19364b.equals(eVar.i()) && ((str = this.f19365c) != null ? str.equals(eVar.c()) : eVar.c() == null) && this.f19366d == eVar.l() && ((l = this.f19367e) != null ? l.equals(eVar.e()) : eVar.e() == null) && this.f19368f == eVar.n() && this.f19369g.equals(eVar.b()) && ((fVar = this.f19370h) != null ? fVar.equals(eVar.m()) : eVar.m() == null) && ((abstractC0227e = this.f19371i) != null ? abstractC0227e.equals(eVar.k()) : eVar.k() == null) && ((cVar = this.f19372j) != null ? cVar.equals(eVar.d()) : eVar.d() == null) && ((list = this.f19373k) != null ? list.equals(eVar.f()) : eVar.f() == null) && this.l == eVar.h();
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e
    public List<f0.e.d> f() {
        return this.f19373k;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e
    public String g() {
        return this.a;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e
    public int h() {
        return this.l;
    }

    public int hashCode() {
        int iHashCode = (((this.a.hashCode() ^ 1000003) * 1000003) ^ this.f19364b.hashCode()) * 1000003;
        String str = this.f19365c;
        int iHashCode2 = str == null ? 0 : str.hashCode();
        long j2 = this.f19366d;
        int i2 = (((iHashCode ^ iHashCode2) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003;
        Long l = this.f19367e;
        int iHashCode3 = (((((i2 ^ (l == null ? 0 : l.hashCode())) * 1000003) ^ (this.f19368f ? 1231 : 1237)) * 1000003) ^ this.f19369g.hashCode()) * 1000003;
        f0.e.f fVar = this.f19370h;
        int iHashCode4 = (iHashCode3 ^ (fVar == null ? 0 : fVar.hashCode())) * 1000003;
        f0.e.AbstractC0227e abstractC0227e = this.f19371i;
        int iHashCode5 = (iHashCode4 ^ (abstractC0227e == null ? 0 : abstractC0227e.hashCode())) * 1000003;
        f0.e.c cVar = this.f19372j;
        int iHashCode6 = (iHashCode5 ^ (cVar == null ? 0 : cVar.hashCode())) * 1000003;
        List<f0.e.d> list = this.f19373k;
        return ((iHashCode6 ^ (list != null ? list.hashCode() : 0)) * 1000003) ^ this.l;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e
    public String i() {
        return this.f19364b;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e
    public f0.e.AbstractC0227e k() {
        return this.f19371i;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e
    public long l() {
        return this.f19366d;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e
    public f0.e.f m() {
        return this.f19370h;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e
    public boolean n() {
        return this.f19368f;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e
    public f0.e.b o() {
        return new b(this);
    }

    public String toString() {
        return "Session{generator=" + this.a + ", identifier=" + this.f19364b + ", appQualitySessionId=" + this.f19365c + ", startedAt=" + this.f19366d + ", endedAt=" + this.f19367e + ", crashed=" + this.f19368f + ", app=" + this.f19369g + ", user=" + this.f19370h + ", os=" + this.f19371i + ", device=" + this.f19372j + ", events=" + this.f19373k + ", generatorType=" + this.l + "}";
    }

    private h(String str, String str2, String str3, long j2, Long l, boolean z, f0.e.a aVar, f0.e.f fVar, f0.e.AbstractC0227e abstractC0227e, f0.e.c cVar, List<f0.e.d> list, int i2) {
        this.a = str;
        this.f19364b = str2;
        this.f19365c = str3;
        this.f19366d = j2;
        this.f19367e = l;
        this.f19368f = z;
        this.f19369g = aVar;
        this.f19370h = fVar;
        this.f19371i = abstractC0227e;
        this.f19372j = cVar;
        this.f19373k = list;
        this.l = i2;
    }
}
