package com.google.firebase.crashlytics.internal.p;

import okhttp3.HttpUrl;

/* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_Event_Device.java */
/* JADX INFO: loaded from: classes2.dex */
final class u extends f0.e.d.c {
    private final Double a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f19478b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f19479c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f19480d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f19481e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f19482f;

    /* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_Event_Device.java */
    static final class b extends f0.e.d.c.a {
        private Double a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Integer f19483b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Boolean f19484c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Integer f19485d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Long f19486e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Long f19487f;

        b() {
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.d.c.a
        public f0.e.d.c a() {
            Integer num = this.f19483b;
            String str = HttpUrl.FRAGMENT_ENCODE_SET;
            if (num == null) {
                str = HttpUrl.FRAGMENT_ENCODE_SET + " batteryVelocity";
            }
            if (this.f19484c == null) {
                str = str + " proximityOn";
            }
            if (this.f19485d == null) {
                str = str + " orientation";
            }
            if (this.f19486e == null) {
                str = str + " ramUsed";
            }
            if (this.f19487f == null) {
                str = str + " diskUsed";
            }
            if (str.isEmpty()) {
                return new u(this.a, this.f19483b.intValue(), this.f19484c.booleanValue(), this.f19485d.intValue(), this.f19486e.longValue(), this.f19487f.longValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.d.c.a
        public f0.e.d.c.a b(Double d2) {
            this.a = d2;
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.d.c.a
        public f0.e.d.c.a c(int i2) {
            this.f19483b = Integer.valueOf(i2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.d.c.a
        public f0.e.d.c.a d(long j2) {
            this.f19487f = Long.valueOf(j2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.d.c.a
        public f0.e.d.c.a e(int i2) {
            this.f19485d = Integer.valueOf(i2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.d.c.a
        public f0.e.d.c.a f(boolean z) {
            this.f19484c = Boolean.valueOf(z);
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.d.c.a
        public f0.e.d.c.a g(long j2) {
            this.f19486e = Long.valueOf(j2);
            return this;
        }
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.d.c
    public Double b() {
        return this.a;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.d.c
    public int c() {
        return this.f19478b;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.d.c
    public long d() {
        return this.f19482f;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.d.c
    public int e() {
        return this.f19480d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f0.e.d.c)) {
            return false;
        }
        f0.e.d.c cVar = (f0.e.d.c) obj;
        Double d2 = this.a;
        if (d2 != null ? d2.equals(cVar.b()) : cVar.b() == null) {
            if (this.f19478b == cVar.c() && this.f19479c == cVar.g() && this.f19480d == cVar.e() && this.f19481e == cVar.f() && this.f19482f == cVar.d()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.d.c
    public long f() {
        return this.f19481e;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.d.c
    public boolean g() {
        return this.f19479c;
    }

    public int hashCode() {
        Double d2 = this.a;
        int iHashCode = ((((((((d2 == null ? 0 : d2.hashCode()) ^ 1000003) * 1000003) ^ this.f19478b) * 1000003) ^ (this.f19479c ? 1231 : 1237)) * 1000003) ^ this.f19480d) * 1000003;
        long j2 = this.f19481e;
        long j3 = this.f19482f;
        return ((iHashCode ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ ((int) (j3 ^ (j3 >>> 32)));
    }

    public String toString() {
        return "Device{batteryLevel=" + this.a + ", batteryVelocity=" + this.f19478b + ", proximityOn=" + this.f19479c + ", orientation=" + this.f19480d + ", ramUsed=" + this.f19481e + ", diskUsed=" + this.f19482f + "}";
    }

    private u(Double d2, int i2, boolean z, int i3, long j2, long j3) {
        this.a = d2;
        this.f19478b = i2;
        this.f19479c = z;
        this.f19480d = i3;
        this.f19481e = j2;
        this.f19482f = j3;
    }
}
