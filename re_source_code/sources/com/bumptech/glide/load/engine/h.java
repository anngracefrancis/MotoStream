package com.bumptech.glide.load.engine;

import android.os.Build;
import android.util.Log;
import com.bumptech.glide.Registry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: DecodeJob.java */
/* JADX INFO: loaded from: classes.dex */
class h<R> implements com.bumptech.glide.load.engine.f.a, Runnable, Comparable<h<?>>, com.bumptech.glide.r.l.a.f {
    private Object A;
    private Thread B;
    private com.bumptech.glide.load.f C;
    private com.bumptech.glide.load.f D;
    private Object E;
    private com.bumptech.glide.load.a F;
    private com.bumptech.glide.load.m.d<?> G;
    private volatile com.bumptech.glide.load.engine.f H;
    private volatile boolean I;
    private volatile boolean J;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final e f9116i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final c.i.j.f<h<?>> f9117j;
    private com.bumptech.glide.e m;
    private com.bumptech.glide.load.f n;
    private com.bumptech.glide.g o;
    private n p;
    private int q;
    private int r;
    private j s;
    private com.bumptech.glide.load.i t;
    private b<R> u;
    private int v;
    private EnumC0130h w;
    private g x;
    private long y;
    private boolean z;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.g<R> f9113f = new com.bumptech.glide.load.engine.g<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List<Throwable> f9114g = new ArrayList();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final com.bumptech.glide.r.l.c f9115h = com.bumptech.glide.r.l.c.a();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final d<?> f9118k = new d<>();
    private final f l = new f();

    /* JADX INFO: compiled from: DecodeJob.java */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f9119b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final /* synthetic */ int[] f9120c;

        static {
            int[] iArr = new int[com.bumptech.glide.load.c.values().length];
            f9120c = iArr;
            try {
                iArr[com.bumptech.glide.load.c.SOURCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9120c[com.bumptech.glide.load.c.TRANSFORMED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[EnumC0130h.values().length];
            f9119b = iArr2;
            try {
                iArr2[EnumC0130h.RESOURCE_CACHE.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f9119b[EnumC0130h.DATA_CACHE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f9119b[EnumC0130h.SOURCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f9119b[EnumC0130h.FINISHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f9119b[EnumC0130h.INITIALIZE.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[g.values().length];
            a = iArr3;
            try {
                iArr3[g.INITIALIZE.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[g.SWITCH_TO_SOURCE_SERVICE.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[g.DECODE_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* JADX INFO: compiled from: DecodeJob.java */
    interface b<R> {
        void a(GlideException glideException);

        void b(u<R> uVar, com.bumptech.glide.load.a aVar);

        void c(h<?> hVar);
    }

    /* JADX INFO: compiled from: DecodeJob.java */
    private final class c<Z> implements i.a<Z> {
        private final com.bumptech.glide.load.a a;

        c(com.bumptech.glide.load.a aVar) {
            this.a = aVar;
        }

        @Override // com.bumptech.glide.load.engine.i.a
        public u<Z> a(u<Z> uVar) {
            return h.this.Q(this.a, uVar);
        }
    }

    /* JADX INFO: compiled from: DecodeJob.java */
    private static class d<Z> {
        private com.bumptech.glide.load.f a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private com.bumptech.glide.load.k<Z> f9122b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private t<Z> f9123c;

        d() {
        }

        void a() {
            this.a = null;
            this.f9122b = null;
            this.f9123c = null;
        }

        void b(e eVar, com.bumptech.glide.load.i iVar) {
            com.bumptech.glide.r.l.b.a("DecodeJob.encode");
            try {
                eVar.a().a(this.a, new com.bumptech.glide.load.engine.e(this.f9122b, this.f9123c, iVar));
            } finally {
                this.f9123c.g();
                com.bumptech.glide.r.l.b.d();
            }
        }

        boolean c() {
            return this.f9123c != null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        <X> void d(com.bumptech.glide.load.f fVar, com.bumptech.glide.load.k<X> kVar, t<X> tVar) {
            this.a = fVar;
            this.f9122b = kVar;
            this.f9123c = tVar;
        }
    }

    /* JADX INFO: compiled from: DecodeJob.java */
    interface e {
        com.bumptech.glide.load.engine.a0.a a();
    }

    /* JADX INFO: compiled from: DecodeJob.java */
    private static class f {
        private boolean a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f9124b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f9125c;

        f() {
        }

        private boolean a(boolean z) {
            return (this.f9125c || z || this.f9124b) && this.a;
        }

        synchronized boolean b() {
            this.f9124b = true;
            return a(false);
        }

        synchronized boolean c() {
            this.f9125c = true;
            return a(false);
        }

        synchronized boolean d(boolean z) {
            this.a = true;
            return a(z);
        }

        synchronized void e() {
            this.f9124b = false;
            this.a = false;
            this.f9125c = false;
        }
    }

    /* JADX INFO: compiled from: DecodeJob.java */
    private enum g {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA
    }

    /* JADX INFO: renamed from: com.bumptech.glide.load.engine.h$h, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DecodeJob.java */
    private enum EnumC0130h {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED
    }

    h(e eVar, c.i.j.f<h<?>> fVar) {
        this.f9116i = eVar;
        this.f9117j = fVar;
    }

    private <Data> u<R> A(Data data, com.bumptech.glide.load.a aVar) throws GlideException {
        return U(data, aVar, this.f9113f.h(data.getClass()));
    }

    private void D() {
        if (Log.isLoggable("DecodeJob", 2)) {
            K("Retrieved data", this.y, "data: " + this.E + ", cache key: " + this.C + ", fetcher: " + this.G);
        }
        u<R> uVarY = null;
        try {
            uVarY = y(this.G, this.E, this.F);
        } catch (GlideException e2) {
            e2.i(this.D, this.F);
            this.f9114g.add(e2);
        }
        if (uVarY != null) {
            M(uVarY, this.F);
        } else {
            T();
        }
    }

    private com.bumptech.glide.load.engine.f E() {
        int i2 = a.f9119b[this.w.ordinal()];
        if (i2 == 1) {
            return new v(this.f9113f, this);
        }
        if (i2 == 2) {
            return new com.bumptech.glide.load.engine.c(this.f9113f, this);
        }
        if (i2 == 3) {
            return new y(this.f9113f, this);
        }
        if (i2 == 4) {
            return null;
        }
        throw new IllegalStateException("Unrecognized stage: " + this.w);
    }

    private EnumC0130h F(EnumC0130h enumC0130h) {
        int i2 = a.f9119b[enumC0130h.ordinal()];
        if (i2 == 1) {
            return this.s.a() ? EnumC0130h.DATA_CACHE : F(EnumC0130h.DATA_CACHE);
        }
        if (i2 == 2) {
            return this.z ? EnumC0130h.FINISHED : EnumC0130h.SOURCE;
        }
        if (i2 == 3 || i2 == 4) {
            return EnumC0130h.FINISHED;
        }
        if (i2 == 5) {
            return this.s.b() ? EnumC0130h.RESOURCE_CACHE : F(EnumC0130h.RESOURCE_CACHE);
        }
        throw new IllegalArgumentException("Unrecognized stage: " + enumC0130h);
    }

    private com.bumptech.glide.load.i G(com.bumptech.glide.load.a aVar) {
        com.bumptech.glide.load.i iVar = this.t;
        if (Build.VERSION.SDK_INT < 26) {
            return iVar;
        }
        boolean z = aVar == com.bumptech.glide.load.a.RESOURCE_DISK_CACHE || this.f9113f.w();
        com.bumptech.glide.load.h<Boolean> hVar = com.bumptech.glide.load.o.c.l.f9372d;
        Boolean bool = (Boolean) iVar.a(hVar);
        if (bool != null && (!bool.booleanValue() || z)) {
            return iVar;
        }
        com.bumptech.glide.load.i iVar2 = new com.bumptech.glide.load.i();
        iVar2.b(this.t);
        iVar2.c(hVar, Boolean.valueOf(z));
        return iVar2;
    }

    private int H() {
        return this.o.ordinal();
    }

    private void J(String str, long j2) {
        K(str, j2, null);
    }

    private void K(String str, long j2, String str2) {
        String str3;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" in ");
        sb.append(com.bumptech.glide.r.f.a(j2));
        sb.append(", load key: ");
        sb.append(this.p);
        if (str2 != null) {
            str3 = ", " + str2;
        } else {
            str3 = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        sb.append(str3);
        sb.append(", thread: ");
        sb.append(Thread.currentThread().getName());
        Log.v("DecodeJob", sb.toString());
    }

    private void L(u<R> uVar, com.bumptech.glide.load.a aVar) {
        W();
        this.u.b(uVar, aVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void M(u<R> uVar, com.bumptech.glide.load.a aVar) {
        if (uVar instanceof q) {
            ((q) uVar).a();
        }
        t tVar = 0;
        if (this.f9118k.c()) {
            uVar = t.b(uVar);
            tVar = uVar;
        }
        L(uVar, aVar);
        this.w = EnumC0130h.ENCODE;
        try {
            if (this.f9118k.c()) {
                this.f9118k.b(this.f9116i, this.t);
            }
            if (tVar != 0) {
                tVar.g();
            }
            O();
        } catch (Throwable th) {
            if (tVar != 0) {
                tVar.g();
            }
            throw th;
        }
    }

    private void N() {
        W();
        this.u.a(new GlideException("Failed to load resource", new ArrayList(this.f9114g)));
        P();
    }

    private void O() {
        if (this.l.b()) {
            S();
        }
    }

    private void P() {
        if (this.l.c()) {
            S();
        }
    }

    private void S() {
        this.l.e();
        this.f9118k.a();
        this.f9113f.a();
        this.I = false;
        this.m = null;
        this.n = null;
        this.t = null;
        this.o = null;
        this.p = null;
        this.u = null;
        this.w = null;
        this.H = null;
        this.B = null;
        this.C = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.y = 0L;
        this.J = false;
        this.A = null;
        this.f9114g.clear();
        this.f9117j.a(this);
    }

    private void T() {
        this.B = Thread.currentThread();
        this.y = com.bumptech.glide.r.f.b();
        boolean zA = false;
        while (!this.J && this.H != null && !(zA = this.H.a())) {
            this.w = F(this.w);
            this.H = E();
            if (this.w == EnumC0130h.SOURCE) {
                k();
                return;
            }
        }
        if ((this.w == EnumC0130h.FINISHED || this.J) && !zA) {
            N();
        }
    }

    private <Data, ResourceType> u<R> U(Data data, com.bumptech.glide.load.a aVar, s<Data, ResourceType, R> sVar) throws GlideException {
        com.bumptech.glide.load.i iVarG = G(aVar);
        com.bumptech.glide.load.m.e<Data> eVarL = this.m.h().l(data);
        try {
            return sVar.a(eVarL, iVarG, this.q, this.r, new c(aVar));
        } finally {
            eVarL.b();
        }
    }

    private void V() {
        int i2 = a.a[this.x.ordinal()];
        if (i2 == 1) {
            this.w = F(EnumC0130h.INITIALIZE);
            this.H = E();
            T();
        } else if (i2 == 2) {
            T();
        } else {
            if (i2 == 3) {
                D();
                return;
            }
            throw new IllegalStateException("Unrecognized run reason: " + this.x);
        }
    }

    private void W() {
        Throwable th;
        this.f9115h.c();
        if (!this.I) {
            this.I = true;
            return;
        }
        if (this.f9114g.isEmpty()) {
            th = null;
        } else {
            List<Throwable> list = this.f9114g;
            th = list.get(list.size() - 1);
        }
        throw new IllegalStateException("Already notified", th);
    }

    private <Data> u<R> y(com.bumptech.glide.load.m.d<?> dVar, Data data, com.bumptech.glide.load.a aVar) throws GlideException {
        if (data == null) {
            dVar.b();
            return null;
        }
        try {
            long jB = com.bumptech.glide.r.f.b();
            u<R> uVarA = A(data, aVar);
            if (Log.isLoggable("DecodeJob", 2)) {
                J("Decoded result " + uVarA, jB);
            }
            return uVarA;
        } finally {
            dVar.b();
        }
    }

    h<R> I(com.bumptech.glide.e eVar, Object obj, n nVar, com.bumptech.glide.load.f fVar, int i2, int i3, Class<?> cls, Class<R> cls2, com.bumptech.glide.g gVar, j jVar, Map<Class<?>, com.bumptech.glide.load.l<?>> map, boolean z, boolean z2, boolean z3, com.bumptech.glide.load.i iVar, b<R> bVar, int i4) {
        this.f9113f.u(eVar, obj, fVar, i2, i3, jVar, cls, cls2, gVar, iVar, map, z, z2, this.f9116i);
        this.m = eVar;
        this.n = fVar;
        this.o = gVar;
        this.p = nVar;
        this.q = i2;
        this.r = i3;
        this.s = jVar;
        this.z = z3;
        this.t = iVar;
        this.u = bVar;
        this.v = i4;
        this.x = g.INITIALIZE;
        this.A = obj;
        return this;
    }

    <Z> u<Z> Q(com.bumptech.glide.load.a aVar, u<Z> uVar) {
        u<Z> uVarTransform;
        com.bumptech.glide.load.l<Z> lVar;
        com.bumptech.glide.load.c cVarB;
        com.bumptech.glide.load.f dVar;
        Class<?> cls = uVar.get().getClass();
        com.bumptech.glide.load.k<Z> kVarN = null;
        if (aVar != com.bumptech.glide.load.a.RESOURCE_DISK_CACHE) {
            com.bumptech.glide.load.l<Z> lVarR = this.f9113f.r(cls);
            lVar = lVarR;
            uVarTransform = lVarR.transform(this.m, uVar, this.q, this.r);
        } else {
            uVarTransform = uVar;
            lVar = null;
        }
        if (!uVar.equals(uVarTransform)) {
            uVar.c();
        }
        if (this.f9113f.v(uVarTransform)) {
            kVarN = this.f9113f.n(uVarTransform);
            cVarB = kVarN.b(this.t);
        } else {
            cVarB = com.bumptech.glide.load.c.NONE;
        }
        com.bumptech.glide.load.k kVar = kVarN;
        if (!this.s.d(!this.f9113f.x(this.C), aVar, cVarB)) {
            return uVarTransform;
        }
        if (kVar == null) {
            throw new Registry.NoResultEncoderAvailableException(uVarTransform.get().getClass());
        }
        int i2 = a.f9120c[cVarB.ordinal()];
        if (i2 == 1) {
            dVar = new com.bumptech.glide.load.engine.d(this.C, this.n);
        } else {
            if (i2 != 2) {
                throw new IllegalArgumentException("Unknown strategy: " + cVarB);
            }
            dVar = new w(this.f9113f.b(), this.C, this.n, this.q, this.r, lVar, cls, this.t);
        }
        t tVarB = t.b(uVarTransform);
        this.f9118k.d(dVar, kVar, tVarB);
        return tVarB;
    }

    void R(boolean z) {
        if (this.l.d(z)) {
            S();
        }
    }

    boolean X() {
        EnumC0130h enumC0130hF = F(EnumC0130h.INITIALIZE);
        return enumC0130hF == EnumC0130h.RESOURCE_CACHE || enumC0130hF == EnumC0130h.DATA_CACHE;
    }

    @Override // com.bumptech.glide.load.engine.f.a
    public void g(com.bumptech.glide.load.f fVar, Exception exc, com.bumptech.glide.load.m.d<?> dVar, com.bumptech.glide.load.a aVar) {
        dVar.b();
        GlideException glideException = new GlideException("Fetching data failed", exc);
        glideException.j(fVar, aVar, dVar.a());
        this.f9114g.add(glideException);
        if (Thread.currentThread() == this.B) {
            T();
        } else {
            this.x = g.SWITCH_TO_SOURCE_SERVICE;
            this.u.c(this);
        }
    }

    @Override // com.bumptech.glide.load.engine.f.a
    public void k() {
        this.x = g.SWITCH_TO_SOURCE_SERVICE;
        this.u.c(this);
    }

    @Override // com.bumptech.glide.load.engine.f.a
    public void q(com.bumptech.glide.load.f fVar, Object obj, com.bumptech.glide.load.m.d<?> dVar, com.bumptech.glide.load.a aVar, com.bumptech.glide.load.f fVar2) {
        this.C = fVar;
        this.E = obj;
        this.G = dVar;
        this.F = aVar;
        this.D = fVar2;
        if (Thread.currentThread() != this.B) {
            this.x = g.DECODE_DATA;
            this.u.c(this);
        } else {
            com.bumptech.glide.r.l.b.a("DecodeJob.decodeFromRetrievedData");
            try {
                D();
            } finally {
                com.bumptech.glide.r.l.b.d();
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        com.bumptech.glide.r.l.b.b("DecodeJob#run(model=%s)", this.A);
        com.bumptech.glide.load.m.d<?> dVar = this.G;
        try {
            try {
                try {
                    if (this.J) {
                        N();
                        if (dVar != null) {
                            dVar.b();
                        }
                        com.bumptech.glide.r.l.b.d();
                        return;
                    }
                    V();
                    if (dVar != null) {
                        dVar.b();
                    }
                    com.bumptech.glide.r.l.b.d();
                } catch (com.bumptech.glide.load.engine.b e2) {
                    throw e2;
                }
            } catch (Throwable th) {
                if (Log.isLoggable("DecodeJob", 3)) {
                    Log.d("DecodeJob", "DecodeJob threw unexpectedly, isCancelled: " + this.J + ", stage: " + this.w, th);
                }
                if (this.w != EnumC0130h.ENCODE) {
                    this.f9114g.add(th);
                    N();
                }
                if (!this.J) {
                    throw th;
                }
                throw th;
            }
        } catch (Throwable th2) {
            if (dVar != null) {
                dVar.b();
            }
            com.bumptech.glide.r.l.b.d();
            throw th2;
        }
    }

    @Override // com.bumptech.glide.r.l.a.f
    public com.bumptech.glide.r.l.c u() {
        return this.f9115h;
    }

    public void v() {
        this.J = true;
        com.bumptech.glide.load.engine.f fVar = this.H;
        if (fVar != null) {
            fVar.cancel();
        }
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public int compareTo(h<?> hVar) {
        int iH = H() - hVar.H();
        return iH == 0 ? this.v - hVar.v : iH;
    }
}
