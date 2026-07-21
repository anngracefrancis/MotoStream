package androidx.datastore.preferences.protobuf;

/* JADX INFO: compiled from: LazyFieldLite.java */
/* JADX INFO: loaded from: classes.dex */
public class d0 {
    private static final p a = p.b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private h f1277b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private p f1278c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected volatile q0 f1279d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile h f1280e;

    protected void a(q0 q0Var) {
        if (this.f1279d != null) {
            return;
        }
        synchronized (this) {
            if (this.f1279d != null) {
                return;
            }
            try {
                if (this.f1277b != null) {
                    this.f1279d = q0Var.g().a(this.f1277b, this.f1278c);
                    this.f1280e = this.f1277b;
                } else {
                    this.f1279d = q0Var;
                    this.f1280e = h.f1298f;
                }
            } catch (InvalidProtocolBufferException unused) {
                this.f1279d = q0Var;
                this.f1280e = h.f1298f;
            }
        }
    }

    public int b() {
        if (this.f1280e != null) {
            return this.f1280e.size();
        }
        h hVar = this.f1277b;
        if (hVar != null) {
            return hVar.size();
        }
        if (this.f1279d != null) {
            return this.f1279d.e();
        }
        return 0;
    }

    public q0 c(q0 q0Var) {
        a(q0Var);
        return this.f1279d;
    }

    public q0 d(q0 q0Var) {
        q0 q0Var2 = this.f1279d;
        this.f1277b = null;
        this.f1280e = null;
        this.f1279d = q0Var;
        return q0Var2;
    }

    public h e() {
        if (this.f1280e != null) {
            return this.f1280e;
        }
        h hVar = this.f1277b;
        if (hVar != null) {
            return hVar;
        }
        synchronized (this) {
            if (this.f1280e != null) {
                return this.f1280e;
            }
            if (this.f1279d == null) {
                this.f1280e = h.f1298f;
            } else {
                this.f1280e = this.f1279d.h();
            }
            return this.f1280e;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d0)) {
            return false;
        }
        d0 d0Var = (d0) obj;
        q0 q0Var = this.f1279d;
        q0 q0Var2 = d0Var.f1279d;
        if (q0Var == null && q0Var2 == null) {
            return e().equals(d0Var.e());
        }
        if (q0Var == null || q0Var2 == null) {
            return q0Var != null ? q0Var.equals(d0Var.c(q0Var.b())) : c(q0Var2.b()).equals(q0Var2);
        }
        return q0Var.equals(q0Var2);
    }

    public int hashCode() {
        return 1;
    }
}
