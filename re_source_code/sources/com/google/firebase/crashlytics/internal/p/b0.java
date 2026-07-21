package com.google.firebase.crashlytics.internal.p;

/* JADX INFO: compiled from: AutoValue_StaticSessionData.java */
/* JADX INFO: loaded from: classes2.dex */
final class b0 extends g0 {
    private final g0.a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g0.c f19321b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final g0.b f19322c;

    b0(g0.a aVar, g0.c cVar, g0.b bVar) {
        if (aVar == null) {
            throw new NullPointerException("Null appData");
        }
        this.a = aVar;
        if (cVar == null) {
            throw new NullPointerException("Null osData");
        }
        this.f19321b = cVar;
        if (bVar == null) {
            throw new NullPointerException("Null deviceData");
        }
        this.f19322c = bVar;
    }

    @Override // com.google.firebase.crashlytics.internal.p.g0
    public g0.a a() {
        return this.a;
    }

    @Override // com.google.firebase.crashlytics.internal.p.g0
    public g0.b c() {
        return this.f19322c;
    }

    @Override // com.google.firebase.crashlytics.internal.p.g0
    public g0.c d() {
        return this.f19321b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g0)) {
            return false;
        }
        g0 g0Var = (g0) obj;
        return this.a.equals(g0Var.a()) && this.f19321b.equals(g0Var.d()) && this.f19322c.equals(g0Var.c());
    }

    public int hashCode() {
        return ((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.f19321b.hashCode()) * 1000003) ^ this.f19322c.hashCode();
    }

    public String toString() {
        return "StaticSessionData{appData=" + this.a + ", osData=" + this.f19321b + ", deviceData=" + this.f19322c + "}";
    }
}
