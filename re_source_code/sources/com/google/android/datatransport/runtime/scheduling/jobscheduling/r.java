package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import java.util.Set;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: AutoValue_SchedulerConfig_ConfigValue.java */
/* JADX INFO: loaded from: classes2.dex */
final class r extends t.b {
    private final long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f11344b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set<t.c> f11345c;

    /* JADX INFO: compiled from: AutoValue_SchedulerConfig_ConfigValue.java */
    static final class b extends t.b.a {
        private Long a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Long f11346b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Set<t.c> f11347c;

        b() {
        }

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.t.b.a
        public t.b a() {
            Long l = this.a;
            String str = HttpUrl.FRAGMENT_ENCODE_SET;
            if (l == null) {
                str = HttpUrl.FRAGMENT_ENCODE_SET + " delta";
            }
            if (this.f11346b == null) {
                str = str + " maxAllowedDelay";
            }
            if (this.f11347c == null) {
                str = str + " flags";
            }
            if (str.isEmpty()) {
                return new r(this.a.longValue(), this.f11346b.longValue(), this.f11347c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.t.b.a
        public t.b.a b(long j2) {
            this.a = Long.valueOf(j2);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.t.b.a
        public t.b.a c(Set<t.c> set) {
            if (set == null) {
                throw new NullPointerException("Null flags");
            }
            this.f11347c = set;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.t.b.a
        public t.b.a d(long j2) {
            this.f11346b = Long.valueOf(j2);
            return this;
        }
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.t.b
    long b() {
        return this.a;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.t.b
    Set<t.c> c() {
        return this.f11345c;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.t.b
    long d() {
        return this.f11344b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof t.b)) {
            return false;
        }
        t.b bVar = (t.b) obj;
        return this.a == bVar.b() && this.f11344b == bVar.d() && this.f11345c.equals(bVar.c());
    }

    public int hashCode() {
        long j2 = this.a;
        int i2 = (((int) (j2 ^ (j2 >>> 32))) ^ 1000003) * 1000003;
        long j3 = this.f11344b;
        return this.f11345c.hashCode() ^ ((i2 ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003);
    }

    public String toString() {
        return "ConfigValue{delta=" + this.a + ", maxAllowedDelay=" + this.f11344b + ", flags=" + this.f11345c + "}";
    }

    private r(long j2, long j3, Set<t.c> set) {
        this.a = j2;
        this.f11344b = j3;
        this.f11345c = set;
    }
}
