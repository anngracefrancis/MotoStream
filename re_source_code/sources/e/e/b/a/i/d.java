package e.e.b.a.i;

import okhttp3.HttpUrl;

/* JADX INFO: compiled from: AutoValue_SendRequest.java */
/* JADX INFO: loaded from: classes2.dex */
final class d extends p {
    private final q a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f20819b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e.e.b.a.c<?> f20820c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final e.e.b.a.e<?, byte[]> f20821d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final e.e.b.a.b f20822e;

    /* JADX INFO: compiled from: AutoValue_SendRequest.java */
    static final class b extends p.a {
        private q a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f20823b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private e.e.b.a.c<?> f20824c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private e.e.b.a.e<?, byte[]> f20825d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private e.e.b.a.b f20826e;

        b() {
        }

        @Override // e.e.b.a.i.p.a
        public p a() {
            q qVar = this.a;
            String str = HttpUrl.FRAGMENT_ENCODE_SET;
            if (qVar == null) {
                str = HttpUrl.FRAGMENT_ENCODE_SET + " transportContext";
            }
            if (this.f20823b == null) {
                str = str + " transportName";
            }
            if (this.f20824c == null) {
                str = str + " event";
            }
            if (this.f20825d == null) {
                str = str + " transformer";
            }
            if (this.f20826e == null) {
                str = str + " encoding";
            }
            if (str.isEmpty()) {
                return new d(this.a, this.f20823b, this.f20824c, this.f20825d, this.f20826e);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // e.e.b.a.i.p.a
        p.a b(e.e.b.a.b bVar) {
            if (bVar == null) {
                throw new NullPointerException("Null encoding");
            }
            this.f20826e = bVar;
            return this;
        }

        @Override // e.e.b.a.i.p.a
        p.a c(e.e.b.a.c<?> cVar) {
            if (cVar == null) {
                throw new NullPointerException("Null event");
            }
            this.f20824c = cVar;
            return this;
        }

        @Override // e.e.b.a.i.p.a
        p.a d(e.e.b.a.e<?, byte[]> eVar) {
            if (eVar == null) {
                throw new NullPointerException("Null transformer");
            }
            this.f20825d = eVar;
            return this;
        }

        @Override // e.e.b.a.i.p.a
        public p.a e(q qVar) {
            if (qVar == null) {
                throw new NullPointerException("Null transportContext");
            }
            this.a = qVar;
            return this;
        }

        @Override // e.e.b.a.i.p.a
        public p.a f(String str) {
            if (str == null) {
                throw new NullPointerException("Null transportName");
            }
            this.f20823b = str;
            return this;
        }
    }

    @Override // e.e.b.a.i.p
    public e.e.b.a.b b() {
        return this.f20822e;
    }

    @Override // e.e.b.a.i.p
    e.e.b.a.c<?> c() {
        return this.f20820c;
    }

    @Override // e.e.b.a.i.p
    e.e.b.a.e<?, byte[]> e() {
        return this.f20821d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return this.a.equals(pVar.f()) && this.f20819b.equals(pVar.g()) && this.f20820c.equals(pVar.c()) && this.f20821d.equals(pVar.e()) && this.f20822e.equals(pVar.b());
    }

    @Override // e.e.b.a.i.p
    public q f() {
        return this.a;
    }

    @Override // e.e.b.a.i.p
    public String g() {
        return this.f20819b;
    }

    public int hashCode() {
        return ((((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.f20819b.hashCode()) * 1000003) ^ this.f20820c.hashCode()) * 1000003) ^ this.f20821d.hashCode()) * 1000003) ^ this.f20822e.hashCode();
    }

    public String toString() {
        return "SendRequest{transportContext=" + this.a + ", transportName=" + this.f20819b + ", event=" + this.f20820c + ", transformer=" + this.f20821d + ", encoding=" + this.f20822e + "}";
    }

    private d(q qVar, String str, e.e.b.a.c<?> cVar, e.e.b.a.e<?, byte[]> eVar, e.e.b.a.b bVar) {
        this.a = qVar;
        this.f20819b = str;
        this.f20820c = cVar;
        this.f20821d = eVar;
        this.f20822e = bVar;
    }
}
