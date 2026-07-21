package com.google.firebase.crashlytics.internal.o;

/* JADX INFO: compiled from: AutoValue_RolloutAssignment.java */
/* JADX INFO: loaded from: classes2.dex */
final class c extends j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f19146b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f19147c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f19148d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f19149e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f19150f;

    c(String str, String str2, String str3, String str4, long j2) {
        if (str == null) {
            throw new NullPointerException("Null rolloutId");
        }
        this.f19146b = str;
        if (str2 == null) {
            throw new NullPointerException("Null parameterKey");
        }
        this.f19147c = str2;
        if (str3 == null) {
            throw new NullPointerException("Null parameterValue");
        }
        this.f19148d = str3;
        if (str4 == null) {
            throw new NullPointerException("Null variantId");
        }
        this.f19149e = str4;
        this.f19150f = j2;
    }

    @Override // com.google.firebase.crashlytics.internal.o.j
    public String c() {
        return this.f19147c;
    }

    @Override // com.google.firebase.crashlytics.internal.o.j
    public String d() {
        return this.f19148d;
    }

    @Override // com.google.firebase.crashlytics.internal.o.j
    public String e() {
        return this.f19146b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return this.f19146b.equals(jVar.e()) && this.f19147c.equals(jVar.c()) && this.f19148d.equals(jVar.d()) && this.f19149e.equals(jVar.g()) && this.f19150f == jVar.f();
    }

    @Override // com.google.firebase.crashlytics.internal.o.j
    public long f() {
        return this.f19150f;
    }

    @Override // com.google.firebase.crashlytics.internal.o.j
    public String g() {
        return this.f19149e;
    }

    public int hashCode() {
        int iHashCode = (((((((this.f19146b.hashCode() ^ 1000003) * 1000003) ^ this.f19147c.hashCode()) * 1000003) ^ this.f19148d.hashCode()) * 1000003) ^ this.f19149e.hashCode()) * 1000003;
        long j2 = this.f19150f;
        return iHashCode ^ ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        return "RolloutAssignment{rolloutId=" + this.f19146b + ", parameterKey=" + this.f19147c + ", parameterValue=" + this.f19148d + ", variantId=" + this.f19149e + ", templateVersion=" + this.f19150f + "}";
    }
}
