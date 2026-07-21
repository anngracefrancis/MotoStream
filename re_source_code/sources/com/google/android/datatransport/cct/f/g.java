package com.google.android.datatransport.cct.f;

import java.util.List;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: AutoValue_LogRequest.java */
/* JADX INFO: loaded from: classes2.dex */
final class g extends m {
    private final long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f11265b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final k f11266c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Integer f11267d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f11268e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<l> f11269f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final p f11270g;

    /* JADX INFO: compiled from: AutoValue_LogRequest.java */
    static final class b extends m.a {
        private Long a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Long f11271b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private k f11272c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Integer f11273d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f11274e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private List<l> f11275f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private p f11276g;

        b() {
        }

        @Override // com.google.android.datatransport.cct.f.m.a
        public m a() {
            Long l = this.a;
            String str = HttpUrl.FRAGMENT_ENCODE_SET;
            if (l == null) {
                str = HttpUrl.FRAGMENT_ENCODE_SET + " requestTimeMs";
            }
            if (this.f11271b == null) {
                str = str + " requestUptimeMs";
            }
            if (str.isEmpty()) {
                return new g(this.a.longValue(), this.f11271b.longValue(), this.f11272c, this.f11273d, this.f11274e, this.f11275f, this.f11276g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.cct.f.m.a
        public m.a b(k kVar) {
            this.f11272c = kVar;
            return this;
        }

        @Override // com.google.android.datatransport.cct.f.m.a
        public m.a c(List<l> list) {
            this.f11275f = list;
            return this;
        }

        @Override // com.google.android.datatransport.cct.f.m.a
        m.a d(Integer num) {
            this.f11273d = num;
            return this;
        }

        @Override // com.google.android.datatransport.cct.f.m.a
        m.a e(String str) {
            this.f11274e = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.f.m.a
        public m.a f(p pVar) {
            this.f11276g = pVar;
            return this;
        }

        @Override // com.google.android.datatransport.cct.f.m.a
        public m.a g(long j2) {
            this.a = Long.valueOf(j2);
            return this;
        }

        @Override // com.google.android.datatransport.cct.f.m.a
        public m.a h(long j2) {
            this.f11271b = Long.valueOf(j2);
            return this;
        }
    }

    @Override // com.google.android.datatransport.cct.f.m
    public k b() {
        return this.f11266c;
    }

    @Override // com.google.android.datatransport.cct.f.m
    public List<l> c() {
        return this.f11269f;
    }

    @Override // com.google.android.datatransport.cct.f.m
    public Integer d() {
        return this.f11267d;
    }

    @Override // com.google.android.datatransport.cct.f.m
    public String e() {
        return this.f11268e;
    }

    public boolean equals(Object obj) {
        k kVar;
        Integer num;
        String str;
        List<l> list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        if (this.a == mVar.g() && this.f11265b == mVar.h() && ((kVar = this.f11266c) != null ? kVar.equals(mVar.b()) : mVar.b() == null) && ((num = this.f11267d) != null ? num.equals(mVar.d()) : mVar.d() == null) && ((str = this.f11268e) != null ? str.equals(mVar.e()) : mVar.e() == null) && ((list = this.f11269f) != null ? list.equals(mVar.c()) : mVar.c() == null)) {
            p pVar = this.f11270g;
            if (pVar == null) {
                if (mVar.f() == null) {
                    return true;
                }
            } else if (pVar.equals(mVar.f())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.datatransport.cct.f.m
    public p f() {
        return this.f11270g;
    }

    @Override // com.google.android.datatransport.cct.f.m
    public long g() {
        return this.a;
    }

    @Override // com.google.android.datatransport.cct.f.m
    public long h() {
        return this.f11265b;
    }

    public int hashCode() {
        long j2 = this.a;
        long j3 = this.f11265b;
        int i2 = (((((int) (j2 ^ (j2 >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003;
        k kVar = this.f11266c;
        int iHashCode = (i2 ^ (kVar == null ? 0 : kVar.hashCode())) * 1000003;
        Integer num = this.f11267d;
        int iHashCode2 = (iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str = this.f11268e;
        int iHashCode3 = (iHashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        List<l> list = this.f11269f;
        int iHashCode4 = (iHashCode3 ^ (list == null ? 0 : list.hashCode())) * 1000003;
        p pVar = this.f11270g;
        return iHashCode4 ^ (pVar != null ? pVar.hashCode() : 0);
    }

    public String toString() {
        return "LogRequest{requestTimeMs=" + this.a + ", requestUptimeMs=" + this.f11265b + ", clientInfo=" + this.f11266c + ", logSource=" + this.f11267d + ", logSourceName=" + this.f11268e + ", logEvents=" + this.f11269f + ", qosTier=" + this.f11270g + "}";
    }

    private g(long j2, long j3, k kVar, Integer num, String str, List<l> list, p pVar) {
        this.a = j2;
        this.f11265b = j3;
        this.f11266c = kVar;
        this.f11267d = num;
        this.f11268e = str;
        this.f11269f = list;
        this.f11270g = pVar;
    }
}
