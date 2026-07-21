package com.google.firebase.crashlytics.internal.p;

/* JADX INFO: compiled from: AutoValue_StaticSessionData_DeviceData.java */
/* JADX INFO: loaded from: classes2.dex */
final class d0 extends g0.b {
    private final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f19348b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f19349c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f19350d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f19351e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f19352f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f19353g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f19354h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f19355i;

    d0(int i2, String str, int i3, long j2, long j3, boolean z, int i4, String str2, String str3) {
        this.a = i2;
        if (str == null) {
            throw new NullPointerException("Null model");
        }
        this.f19348b = str;
        this.f19349c = i3;
        this.f19350d = j2;
        this.f19351e = j3;
        this.f19352f = z;
        this.f19353g = i4;
        if (str2 == null) {
            throw new NullPointerException("Null manufacturer");
        }
        this.f19354h = str2;
        if (str3 == null) {
            throw new NullPointerException("Null modelClass");
        }
        this.f19355i = str3;
    }

    @Override // com.google.firebase.crashlytics.h.p.g0.b
    public int a() {
        return this.a;
    }

    @Override // com.google.firebase.crashlytics.h.p.g0.b
    public int b() {
        return this.f19349c;
    }

    @Override // com.google.firebase.crashlytics.h.p.g0.b
    public long d() {
        return this.f19351e;
    }

    @Override // com.google.firebase.crashlytics.h.p.g0.b
    public boolean e() {
        return this.f19352f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g0.b)) {
            return false;
        }
        g0.b bVar = (g0.b) obj;
        return this.a == bVar.a() && this.f19348b.equals(bVar.g()) && this.f19349c == bVar.b() && this.f19350d == bVar.j() && this.f19351e == bVar.d() && this.f19352f == bVar.e() && this.f19353g == bVar.i() && this.f19354h.equals(bVar.f()) && this.f19355i.equals(bVar.h());
    }

    @Override // com.google.firebase.crashlytics.h.p.g0.b
    public String f() {
        return this.f19354h;
    }

    @Override // com.google.firebase.crashlytics.h.p.g0.b
    public String g() {
        return this.f19348b;
    }

    @Override // com.google.firebase.crashlytics.h.p.g0.b
    public String h() {
        return this.f19355i;
    }

    public int hashCode() {
        int iHashCode = (((((this.a ^ 1000003) * 1000003) ^ this.f19348b.hashCode()) * 1000003) ^ this.f19349c) * 1000003;
        long j2 = this.f19350d;
        int i2 = (iHashCode ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003;
        long j3 = this.f19351e;
        return ((((((((i2 ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003) ^ (this.f19352f ? 1231 : 1237)) * 1000003) ^ this.f19353g) * 1000003) ^ this.f19354h.hashCode()) * 1000003) ^ this.f19355i.hashCode();
    }

    @Override // com.google.firebase.crashlytics.h.p.g0.b
    public int i() {
        return this.f19353g;
    }

    @Override // com.google.firebase.crashlytics.h.p.g0.b
    public long j() {
        return this.f19350d;
    }

    public String toString() {
        return "DeviceData{arch=" + this.a + ", model=" + this.f19348b + ", availableProcessors=" + this.f19349c + ", totalRam=" + this.f19350d + ", diskSpace=" + this.f19351e + ", isEmulator=" + this.f19352f + ", state=" + this.f19353g + ", manufacturer=" + this.f19354h + ", modelClass=" + this.f19355i + "}";
    }
}
