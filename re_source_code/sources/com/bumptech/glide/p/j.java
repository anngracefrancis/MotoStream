package com.bumptech.glide.p;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.u;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: SingleRequest.java */
/* JADX INFO: loaded from: classes.dex */
public final class j<R> implements d, com.bumptech.glide.p.l.h, i, com.bumptech.glide.r.l.a.f {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final c.i.j.f<j<?>> f9499f = com.bumptech.glide.r.l.a.d(150, new a());

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final boolean f9500g = Log.isLoggable("Request", 2);
    private com.bumptech.glide.load.engine.k.d A;
    private long B;
    private b C;
    private Drawable D;
    private Drawable E;
    private Drawable F;
    private int G;
    private int H;
    private RuntimeException I;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f9501h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f9502i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final com.bumptech.glide.r.l.c f9503j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private g<R> f9504k;
    private e l;
    private Context m;
    private com.bumptech.glide.e n;
    private Object o;
    private Class<R> p;
    private com.bumptech.glide.p.a<?> q;
    private int r;
    private int s;
    private com.bumptech.glide.g t;
    private com.bumptech.glide.p.l.i<R> u;
    private List<g<R>> v;
    private com.bumptech.glide.load.engine.k w;
    private com.bumptech.glide.p.m.e<? super R> x;
    private Executor y;
    private u<R> z;

    /* JADX INFO: compiled from: SingleRequest.java */
    class a implements com.bumptech.glide.r.l.a.d<j<?>> {
        a() {
        }

        @Override // com.bumptech.glide.r.l.a.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public j<?> a() {
            return new j<>();
        }
    }

    /* JADX INFO: compiled from: SingleRequest.java */
    private enum b {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED
    }

    j() {
        this.f9502i = f9500g ? String.valueOf(super.hashCode()) : null;
        this.f9503j = com.bumptech.glide.r.l.c.a();
    }

    private void A() {
        e eVar = this.l;
        if (eVar != null) {
            eVar.k(this);
        }
    }

    public static <R> j<R> B(Context context, com.bumptech.glide.e eVar, Object obj, Class<R> cls, com.bumptech.glide.p.a<?> aVar, int i2, int i3, com.bumptech.glide.g gVar, com.bumptech.glide.p.l.i<R> iVar, g<R> gVar2, List<g<R>> list, e eVar2, com.bumptech.glide.load.engine.k kVar, com.bumptech.glide.p.m.e<? super R> eVar3, Executor executor) {
        j<R> jVar = (j) f9499f.b();
        if (jVar == null) {
            jVar = new j<>();
        }
        jVar.s(context, eVar, obj, cls, aVar, i2, i3, gVar, iVar, gVar2, list, eVar2, kVar, eVar3, executor);
        return jVar;
    }

    private synchronized void C(GlideException glideException, int i2) {
        boolean zOnLoadFailed;
        this.f9503j.c();
        glideException.k(this.I);
        int iG = this.n.g();
        if (iG <= i2) {
            Log.w("Glide", "Load failed for " + this.o + " with size [" + this.G + "x" + this.H + "]", glideException);
            if (iG <= 4) {
                glideException.g("Glide");
            }
        }
        this.A = null;
        this.C = b.FAILED;
        boolean z = true;
        this.f9501h = true;
        try {
            List<g<R>> list = this.v;
            if (list != null) {
                Iterator<g<R>> it = list.iterator();
                zOnLoadFailed = false;
                while (it.hasNext()) {
                    zOnLoadFailed |= it.next().onLoadFailed(glideException, this.o, this.u, t());
                }
            } else {
                zOnLoadFailed = false;
            }
            g<R> gVar = this.f9504k;
            if (gVar == null || !gVar.onLoadFailed(glideException, this.o, this.u, t())) {
                z = false;
            }
            if (!(zOnLoadFailed | z)) {
                F();
            }
            this.f9501h = false;
            z();
        } catch (Throwable th) {
            this.f9501h = false;
            throw th;
        }
    }

    private synchronized void D(u<R> uVar, R r, com.bumptech.glide.load.a aVar) {
        boolean zOnResourceReady;
        boolean zT = t();
        this.C = b.COMPLETE;
        this.z = uVar;
        if (this.n.g() <= 3) {
            Log.d("Glide", "Finished loading " + r.getClass().getSimpleName() + " from " + aVar + " for " + this.o + " with size [" + this.G + "x" + this.H + "] in " + com.bumptech.glide.r.f.a(this.B) + " ms");
        }
        boolean z = true;
        this.f9501h = true;
        try {
            List<g<R>> list = this.v;
            if (list != null) {
                Iterator<g<R>> it = list.iterator();
                zOnResourceReady = false;
                while (it.hasNext()) {
                    zOnResourceReady |= it.next().onResourceReady(r, this.o, this.u, aVar, zT);
                }
            } else {
                zOnResourceReady = false;
            }
            g<R> gVar = this.f9504k;
            if (gVar == null || !gVar.onResourceReady(r, this.o, this.u, aVar, zT)) {
                z = false;
            }
            if (!(z | zOnResourceReady)) {
                this.u.onResourceReady(r, this.x.a(aVar, zT));
            }
            this.f9501h = false;
            A();
        } catch (Throwable th) {
            this.f9501h = false;
            throw th;
        }
    }

    private void E(u<?> uVar) {
        this.w.j(uVar);
        this.z = null;
    }

    private synchronized void F() {
        if (m()) {
            Drawable drawableQ = this.o == null ? q() : null;
            if (drawableQ == null) {
                drawableQ = p();
            }
            if (drawableQ == null) {
                drawableQ = r();
            }
            this.u.onLoadFailed(drawableQ);
        }
    }

    private void j() {
        if (this.f9501h) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    private boolean k() {
        e eVar = this.l;
        return eVar == null || eVar.m(this);
    }

    private boolean m() {
        e eVar = this.l;
        return eVar == null || eVar.g(this);
    }

    private boolean n() {
        e eVar = this.l;
        return eVar == null || eVar.j(this);
    }

    private void o() {
        j();
        this.f9503j.c();
        this.u.removeCallback(this);
        com.bumptech.glide.load.engine.k.d dVar = this.A;
        if (dVar != null) {
            dVar.a();
            this.A = null;
        }
    }

    private Drawable p() {
        if (this.D == null) {
            Drawable drawableN = this.q.n();
            this.D = drawableN;
            if (drawableN == null && this.q.m() > 0) {
                this.D = w(this.q.m());
            }
        }
        return this.D;
    }

    private Drawable q() {
        if (this.F == null) {
            Drawable drawableO = this.q.o();
            this.F = drawableO;
            if (drawableO == null && this.q.p() > 0) {
                this.F = w(this.q.p());
            }
        }
        return this.F;
    }

    private Drawable r() {
        if (this.E == null) {
            Drawable drawableU = this.q.u();
            this.E = drawableU;
            if (drawableU == null && this.q.v() > 0) {
                this.E = w(this.q.v());
            }
        }
        return this.E;
    }

    private synchronized void s(Context context, com.bumptech.glide.e eVar, Object obj, Class<R> cls, com.bumptech.glide.p.a<?> aVar, int i2, int i3, com.bumptech.glide.g gVar, com.bumptech.glide.p.l.i<R> iVar, g<R> gVar2, List<g<R>> list, e eVar2, com.bumptech.glide.load.engine.k kVar, com.bumptech.glide.p.m.e<? super R> eVar3, Executor executor) {
        this.m = context;
        this.n = eVar;
        this.o = obj;
        this.p = cls;
        this.q = aVar;
        this.r = i2;
        this.s = i3;
        this.t = gVar;
        this.u = iVar;
        this.f9504k = gVar2;
        this.v = list;
        this.l = eVar2;
        this.w = kVar;
        this.x = eVar3;
        this.y = executor;
        this.C = b.PENDING;
        if (this.I == null && eVar.i()) {
            this.I = new RuntimeException("Glide request origin trace");
        }
    }

    private boolean t() {
        e eVar = this.l;
        return eVar == null || !eVar.b();
    }

    private synchronized boolean v(j<?> jVar) {
        boolean z;
        synchronized (jVar) {
            List<g<R>> list = this.v;
            int size = list == null ? 0 : list.size();
            List<g<?>> list2 = jVar.v;
            z = size == (list2 == null ? 0 : list2.size());
        }
        return z;
    }

    private Drawable w(int i2) {
        return com.bumptech.glide.load.o.e.a.a(this.n, i2, this.q.D() != null ? this.q.D() : this.m.getTheme());
    }

    private void x(String str) {
        Log.v("Request", str + " this: " + this.f9502i);
    }

    private static int y(int i2, float f2) {
        return i2 == Integer.MIN_VALUE ? i2 : Math.round(f2 * i2);
    }

    private void z() {
        e eVar = this.l;
        if (eVar != null) {
            eVar.a(this);
        }
    }

    @Override // com.bumptech.glide.p.i
    public synchronized void a(GlideException glideException) {
        C(glideException, 5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.p.i
    public synchronized void b(u<?> uVar, com.bumptech.glide.load.a aVar) {
        this.f9503j.c();
        this.A = null;
        if (uVar == null) {
            a(new GlideException("Expected to receive a Resource<R> with an object of " + this.p + " inside, but instead got null."));
            return;
        }
        Object obj = uVar.get();
        if (obj != null && this.p.isAssignableFrom(obj.getClass())) {
            if (n()) {
                D(uVar, obj, aVar);
                return;
            } else {
                E(uVar);
                this.C = b.COMPLETE;
                return;
            }
        }
        E(uVar);
        StringBuilder sb = new StringBuilder();
        sb.append("Expected to receive an object of ");
        sb.append(this.p);
        sb.append(" but instead got ");
        sb.append(obj != null ? obj.getClass() : HttpUrl.FRAGMENT_ENCODE_SET);
        sb.append("{");
        sb.append(obj);
        sb.append("} inside Resource{");
        sb.append(uVar);
        sb.append("}.");
        sb.append(obj != null ? HttpUrl.FRAGMENT_ENCODE_SET : " To indicate failure return a null Resource object, rather than a Resource object containing null data.");
        a(new GlideException(sb.toString()));
    }

    @Override // com.bumptech.glide.p.d
    public synchronized void c() {
        j();
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = -1;
        this.s = -1;
        this.u = null;
        this.v = null;
        this.f9504k = null;
        this.l = null;
        this.x = null;
        this.A = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = -1;
        this.H = -1;
        this.I = null;
        f9499f.a(this);
    }

    @Override // com.bumptech.glide.p.d
    public synchronized void clear() {
        j();
        this.f9503j.c();
        b bVar = this.C;
        b bVar2 = b.CLEARED;
        if (bVar == bVar2) {
            return;
        }
        o();
        u<R> uVar = this.z;
        if (uVar != null) {
            E(uVar);
        }
        if (k()) {
            this.u.onLoadCleared(r());
        }
        this.C = bVar2;
    }

    @Override // com.bumptech.glide.p.d
    public synchronized void d() {
        j();
        this.f9503j.c();
        this.B = com.bumptech.glide.r.f.b();
        if (this.o == null) {
            if (com.bumptech.glide.r.k.t(this.r, this.s)) {
                this.G = this.r;
                this.H = this.s;
            }
            C(new GlideException("Received null model"), q() == null ? 5 : 3);
            return;
        }
        b bVar = this.C;
        b bVar2 = b.RUNNING;
        if (bVar == bVar2) {
            throw new IllegalArgumentException("Cannot restart a running request");
        }
        if (bVar == b.COMPLETE) {
            b(this.z, com.bumptech.glide.load.a.MEMORY_CACHE);
            return;
        }
        b bVar3 = b.WAITING_FOR_SIZE;
        this.C = bVar3;
        if (com.bumptech.glide.r.k.t(this.r, this.s)) {
            g(this.r, this.s);
        } else {
            this.u.getSize(this);
        }
        b bVar4 = this.C;
        if ((bVar4 == bVar2 || bVar4 == bVar3) && m()) {
            this.u.onLoadStarted(r());
        }
        if (f9500g) {
            x("finished run method in " + com.bumptech.glide.r.f.a(this.B));
        }
    }

    @Override // com.bumptech.glide.p.d
    public synchronized boolean e(d dVar) {
        boolean z = false;
        if (!(dVar instanceof j)) {
            return false;
        }
        j<?> jVar = (j) dVar;
        synchronized (jVar) {
            if (this.r == jVar.r && this.s == jVar.s && com.bumptech.glide.r.k.c(this.o, jVar.o) && this.p.equals(jVar.p) && this.q.equals(jVar.q) && this.t == jVar.t && v(jVar)) {
                z = true;
            }
        }
        return z;
    }

    @Override // com.bumptech.glide.p.d
    public synchronized boolean f() {
        return l();
    }

    @Override // com.bumptech.glide.p.l.h
    public synchronized void g(int i2, int i3) throws Throwable {
        try {
            this.f9503j.c();
            boolean z = f9500g;
            if (z) {
                x("Got onSizeReady in " + com.bumptech.glide.r.f.a(this.B));
            }
            if (this.C != b.WAITING_FOR_SIZE) {
                return;
            }
            b bVar = b.RUNNING;
            this.C = bVar;
            float fC = this.q.C();
            this.G = y(i2, fC);
            this.H = y(i3, fC);
            if (z) {
                x("finished setup for calling load in " + com.bumptech.glide.r.f.a(this.B));
            }
            try {
                try {
                    this.A = this.w.f(this.n, this.o, this.q.B(), this.G, this.H, this.q.A(), this.p, this.t, this.q.l(), this.q.E(), this.q.N(), this.q.J(), this.q.r(), this.q.H(), this.q.G(), this.q.F(), this.q.q(), this, this.y);
                    if (this.C != bVar) {
                        this.A = null;
                    }
                    if (z) {
                        x("finished onSizeReady in " + com.bumptech.glide.r.f.a(this.B));
                    }
                    return;
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
        throw th;
    }

    @Override // com.bumptech.glide.p.d
    public synchronized boolean h() {
        return this.C == b.FAILED;
    }

    @Override // com.bumptech.glide.p.d
    public synchronized boolean i() {
        return this.C == b.CLEARED;
    }

    @Override // com.bumptech.glide.p.d
    public synchronized boolean isRunning() {
        b bVar;
        bVar = this.C;
        return bVar == b.RUNNING || bVar == b.WAITING_FOR_SIZE;
    }

    @Override // com.bumptech.glide.p.d
    public synchronized boolean l() {
        return this.C == b.COMPLETE;
    }

    @Override // com.bumptech.glide.r.l.a.f
    public com.bumptech.glide.r.l.c u() {
        return this.f9503j;
    }
}
