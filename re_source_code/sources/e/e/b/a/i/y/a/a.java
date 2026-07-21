package e.e.b.a.i.y.a;

import e.e.b.a.i.n;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: ClientMetrics.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private static final a a = new C0257a().b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final f f20858b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<d> f20859c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final b f20860d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f20861e;

    /* JADX INFO: renamed from: e.e.b.a.i.y.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ClientMetrics.java */
    public static final class C0257a {
        private f a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List<d> f20862b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private b f20863c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f20864d = HttpUrl.FRAGMENT_ENCODE_SET;

        C0257a() {
        }

        public C0257a a(d dVar) {
            this.f20862b.add(dVar);
            return this;
        }

        public a b() {
            return new a(this.a, Collections.unmodifiableList(this.f20862b), this.f20863c, this.f20864d);
        }

        public C0257a c(String str) {
            this.f20864d = str;
            return this;
        }

        public C0257a d(b bVar) {
            this.f20863c = bVar;
            return this;
        }

        public C0257a e(f fVar) {
            this.a = fVar;
            return this;
        }
    }

    a(f fVar, List<d> list, b bVar, String str) {
        this.f20858b = fVar;
        this.f20859c = list;
        this.f20860d = bVar;
        this.f20861e = str;
    }

    public static C0257a e() {
        return new C0257a();
    }

    @com.google.firebase.encoders.i.f(tag = 4)
    public String a() {
        return this.f20861e;
    }

    @com.google.firebase.encoders.i.f(tag = 3)
    public b b() {
        return this.f20860d;
    }

    @com.google.firebase.encoders.i.f(tag = 2)
    public List<d> c() {
        return this.f20859c;
    }

    @com.google.firebase.encoders.i.f(tag = 1)
    public f d() {
        return this.f20858b;
    }

    public byte[] f() {
        return n.a(this);
    }
}
