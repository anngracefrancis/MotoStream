package e.e.b.a.i.b0.j;

/* JADX INFO: compiled from: AutoValue_PersistedEvent.java */
/* JADX INFO: loaded from: classes2.dex */
final class h0 extends q0 {
    private final long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e.e.b.a.i.q f20773b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e.e.b.a.i.j f20774c;

    h0(long j2, e.e.b.a.i.q qVar, e.e.b.a.i.j jVar) {
        this.a = j2;
        if (qVar == null) {
            throw new NullPointerException("Null transportContext");
        }
        this.f20773b = qVar;
        if (jVar == null) {
            throw new NullPointerException("Null event");
        }
        this.f20774c = jVar;
    }

    @Override // e.e.b.a.i.b0.j.q0
    public e.e.b.a.i.j b() {
        return this.f20774c;
    }

    @Override // e.e.b.a.i.b0.j.q0
    public long c() {
        return this.a;
    }

    @Override // e.e.b.a.i.b0.j.q0
    public e.e.b.a.i.q d() {
        return this.f20773b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof q0)) {
            return false;
        }
        q0 q0Var = (q0) obj;
        return this.a == q0Var.c() && this.f20773b.equals(q0Var.d()) && this.f20774c.equals(q0Var.b());
    }

    public int hashCode() {
        long j2 = this.a;
        return this.f20774c.hashCode() ^ ((((((int) (j2 ^ (j2 >>> 32))) ^ 1000003) * 1000003) ^ this.f20773b.hashCode()) * 1000003);
    }

    public String toString() {
        return "PersistedEvent{id=" + this.a + ", transportContext=" + this.f20773b + ", event=" + this.f20774c + "}";
    }
}
