package com.google.firebase.crashlytics.internal.p;

import java.util.List;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: AutoValue_CrashlyticsReport_ApplicationExitInfo.java */
/* JADX INFO: loaded from: classes2.dex */
final class c extends f0.a {
    private final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f19323b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f19324c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f19325d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f19326e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f19327f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long f19328g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f19329h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final List<f0.a.AbstractC0210a> f19330i;

    /* JADX INFO: compiled from: AutoValue_CrashlyticsReport_ApplicationExitInfo.java */
    static final class b extends f0.a.b {
        private Integer a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f19331b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Integer f19332c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Integer f19333d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Long f19334e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Long f19335f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private Long f19336g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private String f19337h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private List<f0.a.AbstractC0210a> f19338i;

        b() {
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.a.b
        public f0.a a() {
            Integer num = this.a;
            String str = HttpUrl.FRAGMENT_ENCODE_SET;
            if (num == null) {
                str = HttpUrl.FRAGMENT_ENCODE_SET + " pid";
            }
            if (this.f19331b == null) {
                str = str + " processName";
            }
            if (this.f19332c == null) {
                str = str + " reasonCode";
            }
            if (this.f19333d == null) {
                str = str + " importance";
            }
            if (this.f19334e == null) {
                str = str + " pss";
            }
            if (this.f19335f == null) {
                str = str + " rss";
            }
            if (this.f19336g == null) {
                str = str + " timestamp";
            }
            if (str.isEmpty()) {
                return new c(this.a.intValue(), this.f19331b, this.f19332c.intValue(), this.f19333d.intValue(), this.f19334e.longValue(), this.f19335f.longValue(), this.f19336g.longValue(), this.f19337h, this.f19338i);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.a.b
        public f0.a.b b(List<f0.a.AbstractC0210a> list) {
            this.f19338i = list;
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.a.b
        public f0.a.b c(int i2) {
            this.f19333d = Integer.valueOf(i2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.a.b
        public f0.a.b d(int i2) {
            this.a = Integer.valueOf(i2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.a.b
        public f0.a.b e(String str) {
            if (str == null) {
                throw new NullPointerException("Null processName");
            }
            this.f19331b = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.a.b
        public f0.a.b f(long j2) {
            this.f19334e = Long.valueOf(j2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.a.b
        public f0.a.b g(int i2) {
            this.f19332c = Integer.valueOf(i2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.a.b
        public f0.a.b h(long j2) {
            this.f19335f = Long.valueOf(j2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.a.b
        public f0.a.b i(long j2) {
            this.f19336g = Long.valueOf(j2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.a.b
        public f0.a.b j(String str) {
            this.f19337h = str;
            return this;
        }
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.a
    public List<f0.a.AbstractC0210a> b() {
        return this.f19330i;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.a
    public int c() {
        return this.f19325d;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.a
    public int d() {
        return this.a;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.a
    public String e() {
        return this.f19323b;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f0.a)) {
            return false;
        }
        f0.a aVar = (f0.a) obj;
        if (this.a == aVar.d() && this.f19323b.equals(aVar.e()) && this.f19324c == aVar.g() && this.f19325d == aVar.c() && this.f19326e == aVar.f() && this.f19327f == aVar.h() && this.f19328g == aVar.i() && ((str = this.f19329h) != null ? str.equals(aVar.j()) : aVar.j() == null)) {
            List<f0.a.AbstractC0210a> list = this.f19330i;
            if (list == null) {
                if (aVar.b() == null) {
                    return true;
                }
            } else if (list.equals(aVar.b())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.a
    public long f() {
        return this.f19326e;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.a
    public int g() {
        return this.f19324c;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.a
    public long h() {
        return this.f19327f;
    }

    public int hashCode() {
        int iHashCode = (((((((this.a ^ 1000003) * 1000003) ^ this.f19323b.hashCode()) * 1000003) ^ this.f19324c) * 1000003) ^ this.f19325d) * 1000003;
        long j2 = this.f19326e;
        int i2 = (iHashCode ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003;
        long j3 = this.f19327f;
        int i3 = (i2 ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003;
        long j4 = this.f19328g;
        int i4 = (i3 ^ ((int) (j4 ^ (j4 >>> 32)))) * 1000003;
        String str = this.f19329h;
        int iHashCode2 = (i4 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        List<f0.a.AbstractC0210a> list = this.f19330i;
        return iHashCode2 ^ (list != null ? list.hashCode() : 0);
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.a
    public long i() {
        return this.f19328g;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.a
    public String j() {
        return this.f19329h;
    }

    public String toString() {
        return "ApplicationExitInfo{pid=" + this.a + ", processName=" + this.f19323b + ", reasonCode=" + this.f19324c + ", importance=" + this.f19325d + ", pss=" + this.f19326e + ", rss=" + this.f19327f + ", timestamp=" + this.f19328g + ", traceFile=" + this.f19329h + ", buildIdMappingForArch=" + this.f19330i + "}";
    }

    private c(int i2, String str, int i3, int i4, long j2, long j3, long j4, String str2, List<f0.a.AbstractC0210a> list) {
        this.a = i2;
        this.f19323b = str;
        this.f19324c = i3;
        this.f19325d = i4;
        this.f19326e = j2;
        this.f19327f = j3;
        this.f19328g = j4;
        this.f19329h = str2;
        this.f19330i = list;
    }
}
