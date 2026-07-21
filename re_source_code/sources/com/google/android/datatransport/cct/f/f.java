package com.google.android.datatransport.cct.f;

import java.util.Arrays;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: AutoValue_LogEvent.java */
/* JADX INFO: loaded from: classes2.dex */
final class f extends l {
    private final long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Integer f11253b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f11254c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final byte[] f11255d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f11256e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f11257f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final o f11258g;

    /* JADX INFO: compiled from: AutoValue_LogEvent.java */
    static final class b extends l.a {
        private Long a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Integer f11259b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Long f11260c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private byte[] f11261d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f11262e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Long f11263f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private o f11264g;

        b() {
        }

        @Override // com.google.android.datatransport.cct.f.l.a
        public l a() {
            Long l = this.a;
            String str = HttpUrl.FRAGMENT_ENCODE_SET;
            if (l == null) {
                str = HttpUrl.FRAGMENT_ENCODE_SET + " eventTimeMs";
            }
            if (this.f11260c == null) {
                str = str + " eventUptimeMs";
            }
            if (this.f11263f == null) {
                str = str + " timezoneOffsetSeconds";
            }
            if (str.isEmpty()) {
                return new f(this.a.longValue(), this.f11259b, this.f11260c.longValue(), this.f11261d, this.f11262e, this.f11263f.longValue(), this.f11264g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.cct.f.l.a
        public l.a b(Integer num) {
            this.f11259b = num;
            return this;
        }

        @Override // com.google.android.datatransport.cct.f.l.a
        public l.a c(long j2) {
            this.a = Long.valueOf(j2);
            return this;
        }

        @Override // com.google.android.datatransport.cct.f.l.a
        public l.a d(long j2) {
            this.f11260c = Long.valueOf(j2);
            return this;
        }

        @Override // com.google.android.datatransport.cct.f.l.a
        public l.a e(o oVar) {
            this.f11264g = oVar;
            return this;
        }

        @Override // com.google.android.datatransport.cct.f.l.a
        l.a f(byte[] bArr) {
            this.f11261d = bArr;
            return this;
        }

        @Override // com.google.android.datatransport.cct.f.l.a
        l.a g(String str) {
            this.f11262e = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.f.l.a
        public l.a h(long j2) {
            this.f11263f = Long.valueOf(j2);
            return this;
        }
    }

    @Override // com.google.android.datatransport.cct.f.l
    public Integer b() {
        return this.f11253b;
    }

    @Override // com.google.android.datatransport.cct.f.l
    public long c() {
        return this.a;
    }

    @Override // com.google.android.datatransport.cct.f.l
    public long d() {
        return this.f11254c;
    }

    @Override // com.google.android.datatransport.cct.f.l
    public o e() {
        return this.f11258g;
    }

    public boolean equals(Object obj) {
        Integer num;
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        if (this.a == lVar.c() && ((num = this.f11253b) != null ? num.equals(lVar.b()) : lVar.b() == null) && this.f11254c == lVar.d()) {
            if (Arrays.equals(this.f11255d, lVar instanceof f ? ((f) lVar).f11255d : lVar.f()) && ((str = this.f11256e) != null ? str.equals(lVar.g()) : lVar.g() == null) && this.f11257f == lVar.h()) {
                o oVar = this.f11258g;
                if (oVar == null) {
                    if (lVar.e() == null) {
                        return true;
                    }
                } else if (oVar.equals(lVar.e())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.android.datatransport.cct.f.l
    public byte[] f() {
        return this.f11255d;
    }

    @Override // com.google.android.datatransport.cct.f.l
    public String g() {
        return this.f11256e;
    }

    @Override // com.google.android.datatransport.cct.f.l
    public long h() {
        return this.f11257f;
    }

    public int hashCode() {
        long j2 = this.a;
        int i2 = (((int) (j2 ^ (j2 >>> 32))) ^ 1000003) * 1000003;
        Integer num = this.f11253b;
        int iHashCode = num == null ? 0 : num.hashCode();
        long j3 = this.f11254c;
        int iHashCode2 = (((((i2 ^ iHashCode) * 1000003) ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003) ^ Arrays.hashCode(this.f11255d)) * 1000003;
        String str = this.f11256e;
        int iHashCode3 = str == null ? 0 : str.hashCode();
        long j4 = this.f11257f;
        int i3 = (((iHashCode2 ^ iHashCode3) * 1000003) ^ ((int) ((j4 >>> 32) ^ j4))) * 1000003;
        o oVar = this.f11258g;
        return i3 ^ (oVar != null ? oVar.hashCode() : 0);
    }

    public String toString() {
        return "LogEvent{eventTimeMs=" + this.a + ", eventCode=" + this.f11253b + ", eventUptimeMs=" + this.f11254c + ", sourceExtension=" + Arrays.toString(this.f11255d) + ", sourceExtensionJsonProto3=" + this.f11256e + ", timezoneOffsetSeconds=" + this.f11257f + ", networkConnectionInfo=" + this.f11258g + "}";
    }

    private f(long j2, Integer num, long j3, byte[] bArr, String str, long j4, o oVar) {
        this.a = j2;
        this.f11253b = num;
        this.f11254c = j3;
        this.f11255d = bArr;
        this.f11256e = str;
        this.f11257f = j4;
        this.f11258g = oVar;
    }
}
