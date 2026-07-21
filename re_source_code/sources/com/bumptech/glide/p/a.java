package com.bumptech.glide.p;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.recyclerview.widget.RecyclerView;
import cm.aptoide.pt.file.CacheHelper;
import com.bumptech.glide.load.l;
import com.bumptech.glide.load.o.c.n;
import com.bumptech.glide.load.o.c.p;
import com.bumptech.glide.p.a;
import com.google.android.gms.ads.AdRequest;
import java.util.Map;
import okhttp3.internal.http2.Http2;

/* JADX INFO: compiled from: BaseRequestOptions.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a<T extends a<T>> implements Cloneable {
    private boolean A;
    private boolean B;
    private boolean C;
    private boolean E;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f9484f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Drawable f9488j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f9489k;
    private Drawable l;
    private int m;
    private boolean r;
    private Drawable t;
    private int u;
    private boolean y;
    private Resources.Theme z;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f9485g = 1.0f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private com.bumptech.glide.load.engine.j f9486h = com.bumptech.glide.load.engine.j.f9143e;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private com.bumptech.glide.g f9487i = com.bumptech.glide.g.NORMAL;
    private boolean n = true;
    private int o = -1;
    private int p = -1;
    private com.bumptech.glide.load.f q = com.bumptech.glide.q.b.a();
    private boolean s = true;
    private com.bumptech.glide.load.i v = new com.bumptech.glide.load.i();
    private Map<Class<?>, l<?>> w = new com.bumptech.glide.r.b();
    private Class<?> x = Object.class;
    private boolean D = true;

    private boolean K(int i2) {
        return L(this.f9484f, i2);
    }

    private static boolean L(int i2, int i3) {
        return (i2 & i3) != 0;
    }

    private T U(com.bumptech.glide.load.o.c.k kVar, l<Bitmap> lVar) {
        return (T) c0(kVar, lVar, false);
    }

    private T c0(com.bumptech.glide.load.o.c.k kVar, l<Bitmap> lVar, boolean z) {
        T t = z ? (T) n0(kVar, lVar) : (T) V(kVar, lVar);
        t.D = true;
        return t;
    }

    private T d0() {
        return this;
    }

    private T f0() {
        if (this.y) {
            throw new IllegalStateException("You cannot modify locked T, consider clone()");
        }
        return (T) d0();
    }

    public final Class<?> A() {
        return this.x;
    }

    public final com.bumptech.glide.load.f B() {
        return this.q;
    }

    public final float C() {
        return this.f9485g;
    }

    public final Resources.Theme D() {
        return this.z;
    }

    public final Map<Class<?>, l<?>> E() {
        return this.w;
    }

    public final boolean F() {
        return this.E;
    }

    public final boolean G() {
        return this.B;
    }

    public final boolean H() {
        return this.n;
    }

    public final boolean I() {
        return K(8);
    }

    boolean J() {
        return this.D;
    }

    public final boolean M() {
        return this.s;
    }

    public final boolean N() {
        return this.r;
    }

    public final boolean O() {
        return K(RecyclerView.l.FLAG_MOVED);
    }

    public final boolean P() {
        return com.bumptech.glide.r.k.t(this.p, this.o);
    }

    public T Q() {
        this.y = true;
        return (T) d0();
    }

    public T R() {
        return (T) V(com.bumptech.glide.load.o.c.k.f9360b, new com.bumptech.glide.load.o.c.g());
    }

    public T S() {
        return (T) U(com.bumptech.glide.load.o.c.k.f9363e, new com.bumptech.glide.load.o.c.h());
    }

    public T T() {
        return (T) U(com.bumptech.glide.load.o.c.k.a, new p());
    }

    final T V(com.bumptech.glide.load.o.c.k kVar, l<Bitmap> lVar) {
        if (this.A) {
            return (T) clone().V(kVar, lVar);
        }
        j(kVar);
        return (T) m0(lVar, false);
    }

    public T X(int i2, int i3) {
        if (this.A) {
            return (T) clone().X(i2, i3);
        }
        this.p = i2;
        this.o = i3;
        this.f9484f |= AdRequest.MAX_CONTENT_URL_LENGTH;
        return (T) f0();
    }

    public T Z(int i2) {
        if (this.A) {
            return (T) clone().Z(i2);
        }
        this.m = i2;
        int i3 = this.f9484f | 128;
        this.f9484f = i3;
        this.l = null;
        this.f9484f = i3 & (-65);
        return (T) f0();
    }

    public T a0(Drawable drawable) {
        if (this.A) {
            return (T) clone().a0(drawable);
        }
        this.l = drawable;
        int i2 = this.f9484f | 64;
        this.f9484f = i2;
        this.m = 0;
        this.f9484f = i2 & (-129);
        return (T) f0();
    }

    public T b(a<?> aVar) {
        if (this.A) {
            return (T) clone().b(aVar);
        }
        if (L(aVar.f9484f, 2)) {
            this.f9485g = aVar.f9485g;
        }
        if (L(aVar.f9484f, 262144)) {
            this.B = aVar.B;
        }
        if (L(aVar.f9484f, CacheHelper.VALUE_TO_CONVERT_MB_TO_BYTES)) {
            this.E = aVar.E;
        }
        if (L(aVar.f9484f, 4)) {
            this.f9486h = aVar.f9486h;
        }
        if (L(aVar.f9484f, 8)) {
            this.f9487i = aVar.f9487i;
        }
        if (L(aVar.f9484f, 16)) {
            this.f9488j = aVar.f9488j;
            this.f9489k = 0;
            this.f9484f &= -33;
        }
        if (L(aVar.f9484f, 32)) {
            this.f9489k = aVar.f9489k;
            this.f9488j = null;
            this.f9484f &= -17;
        }
        if (L(aVar.f9484f, 64)) {
            this.l = aVar.l;
            this.m = 0;
            this.f9484f &= -129;
        }
        if (L(aVar.f9484f, 128)) {
            this.m = aVar.m;
            this.l = null;
            this.f9484f &= -65;
        }
        if (L(aVar.f9484f, 256)) {
            this.n = aVar.n;
        }
        if (L(aVar.f9484f, AdRequest.MAX_CONTENT_URL_LENGTH)) {
            this.p = aVar.p;
            this.o = aVar.o;
        }
        if (L(aVar.f9484f, 1024)) {
            this.q = aVar.q;
        }
        if (L(aVar.f9484f, RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT)) {
            this.x = aVar.x;
        }
        if (L(aVar.f9484f, 8192)) {
            this.t = aVar.t;
            this.u = 0;
            this.f9484f &= -16385;
        }
        if (L(aVar.f9484f, Http2.INITIAL_MAX_FRAME_SIZE)) {
            this.u = aVar.u;
            this.t = null;
            this.f9484f &= -8193;
        }
        if (L(aVar.f9484f, 32768)) {
            this.z = aVar.z;
        }
        if (L(aVar.f9484f, 65536)) {
            this.s = aVar.s;
        }
        if (L(aVar.f9484f, 131072)) {
            this.r = aVar.r;
        }
        if (L(aVar.f9484f, RecyclerView.l.FLAG_MOVED)) {
            this.w.putAll(aVar.w);
            this.D = aVar.D;
        }
        if (L(aVar.f9484f, 524288)) {
            this.C = aVar.C;
        }
        if (!this.s) {
            this.w.clear();
            int i2 = this.f9484f & (-2049);
            this.f9484f = i2;
            this.r = false;
            this.f9484f = i2 & (-131073);
            this.D = true;
        }
        this.f9484f |= aVar.f9484f;
        this.v.b(aVar.v);
        return (T) f0();
    }

    public T b0(com.bumptech.glide.g gVar) {
        if (this.A) {
            return (T) clone().b0(gVar);
        }
        this.f9487i = (com.bumptech.glide.g) com.bumptech.glide.r.j.d(gVar);
        this.f9484f |= 8;
        return (T) f0();
    }

    public T d() {
        if (this.y && !this.A) {
            throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
        }
        this.A = true;
        return (T) Q();
    }

    public T e() {
        return (T) n0(com.bumptech.glide.load.o.c.k.f9360b, new com.bumptech.glide.load.o.c.g());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Float.compare(aVar.f9485g, this.f9485g) == 0 && this.f9489k == aVar.f9489k && com.bumptech.glide.r.k.d(this.f9488j, aVar.f9488j) && this.m == aVar.m && com.bumptech.glide.r.k.d(this.l, aVar.l) && this.u == aVar.u && com.bumptech.glide.r.k.d(this.t, aVar.t) && this.n == aVar.n && this.o == aVar.o && this.p == aVar.p && this.r == aVar.r && this.s == aVar.s && this.B == aVar.B && this.C == aVar.C && this.f9486h.equals(aVar.f9486h) && this.f9487i == aVar.f9487i && this.v.equals(aVar.v) && this.w.equals(aVar.w) && this.x.equals(aVar.x) && com.bumptech.glide.r.k.d(this.q, aVar.q) && com.bumptech.glide.r.k.d(this.z, aVar.z);
    }

    @Override // 
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public T clone() {
        try {
            T t = (T) super.clone();
            com.bumptech.glide.load.i iVar = new com.bumptech.glide.load.i();
            t.v = iVar;
            iVar.b(this.v);
            com.bumptech.glide.r.b bVar = new com.bumptech.glide.r.b();
            t.w = bVar;
            bVar.putAll(this.w);
            t.y = false;
            t.A = false;
            return t;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    public T g(Class<?> cls) {
        if (this.A) {
            return (T) clone().g(cls);
        }
        this.x = (Class) com.bumptech.glide.r.j.d(cls);
        this.f9484f |= RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT;
        return (T) f0();
    }

    public <Y> T g0(com.bumptech.glide.load.h<Y> hVar, Y y) {
        if (this.A) {
            return (T) clone().g0(hVar, y);
        }
        com.bumptech.glide.r.j.d(hVar);
        com.bumptech.glide.r.j.d(y);
        this.v.c(hVar, y);
        return (T) f0();
    }

    public T h() {
        return (T) g0(com.bumptech.glide.load.o.c.l.f9372d, Boolean.FALSE);
    }

    public T h0(com.bumptech.glide.load.f fVar) {
        if (this.A) {
            return (T) clone().h0(fVar);
        }
        this.q = (com.bumptech.glide.load.f) com.bumptech.glide.r.j.d(fVar);
        this.f9484f |= 1024;
        return (T) f0();
    }

    public int hashCode() {
        return com.bumptech.glide.r.k.o(this.z, com.bumptech.glide.r.k.o(this.q, com.bumptech.glide.r.k.o(this.x, com.bumptech.glide.r.k.o(this.w, com.bumptech.glide.r.k.o(this.v, com.bumptech.glide.r.k.o(this.f9487i, com.bumptech.glide.r.k.o(this.f9486h, com.bumptech.glide.r.k.p(this.C, com.bumptech.glide.r.k.p(this.B, com.bumptech.glide.r.k.p(this.s, com.bumptech.glide.r.k.p(this.r, com.bumptech.glide.r.k.n(this.p, com.bumptech.glide.r.k.n(this.o, com.bumptech.glide.r.k.p(this.n, com.bumptech.glide.r.k.o(this.t, com.bumptech.glide.r.k.n(this.u, com.bumptech.glide.r.k.o(this.l, com.bumptech.glide.r.k.n(this.m, com.bumptech.glide.r.k.o(this.f9488j, com.bumptech.glide.r.k.n(this.f9489k, com.bumptech.glide.r.k.k(this.f9485g)))))))))))))))))))));
    }

    public T i(com.bumptech.glide.load.engine.j jVar) {
        if (this.A) {
            return (T) clone().i(jVar);
        }
        this.f9486h = (com.bumptech.glide.load.engine.j) com.bumptech.glide.r.j.d(jVar);
        this.f9484f |= 4;
        return (T) f0();
    }

    public T j(com.bumptech.glide.load.o.c.k kVar) {
        return (T) g0(com.bumptech.glide.load.o.c.k.f9366h, com.bumptech.glide.r.j.d(kVar));
    }

    public T j0(float f2) {
        if (this.A) {
            return (T) clone().j0(f2);
        }
        if (f2 < 0.0f || f2 > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.f9485g = f2;
        this.f9484f |= 2;
        return (T) f0();
    }

    public T k(com.bumptech.glide.load.b bVar) {
        com.bumptech.glide.r.j.d(bVar);
        return (T) g0(com.bumptech.glide.load.o.c.l.a, bVar).g0(com.bumptech.glide.load.o.g.i.a, bVar);
    }

    public T k0(boolean z) {
        if (this.A) {
            return (T) clone().k0(true);
        }
        this.n = !z;
        this.f9484f |= 256;
        return (T) f0();
    }

    public final com.bumptech.glide.load.engine.j l() {
        return this.f9486h;
    }

    public T l0(l<Bitmap> lVar) {
        return (T) m0(lVar, true);
    }

    public final int m() {
        return this.f9489k;
    }

    /* JADX WARN: Multi-variable type inference failed */
    T m0(l<Bitmap> lVar, boolean z) {
        if (this.A) {
            return (T) clone().m0(lVar, z);
        }
        n nVar = new n(lVar, z);
        o0(Bitmap.class, lVar, z);
        o0(Drawable.class, nVar, z);
        o0(BitmapDrawable.class, nVar.a(), z);
        o0(com.bumptech.glide.load.o.g.c.class, new com.bumptech.glide.load.o.g.f(lVar), z);
        return (T) f0();
    }

    public final Drawable n() {
        return this.f9488j;
    }

    final T n0(com.bumptech.glide.load.o.c.k kVar, l<Bitmap> lVar) {
        if (this.A) {
            return (T) clone().n0(kVar, lVar);
        }
        j(kVar);
        return (T) l0(lVar);
    }

    public final Drawable o() {
        return this.t;
    }

    <Y> T o0(Class<Y> cls, l<Y> lVar, boolean z) {
        if (this.A) {
            return (T) clone().o0(cls, lVar, z);
        }
        com.bumptech.glide.r.j.d(cls);
        com.bumptech.glide.r.j.d(lVar);
        this.w.put(cls, lVar);
        int i2 = this.f9484f | RecyclerView.l.FLAG_MOVED;
        this.f9484f = i2;
        this.s = true;
        int i3 = i2 | 65536;
        this.f9484f = i3;
        this.D = false;
        if (z) {
            this.f9484f = i3 | 131072;
            this.r = true;
        }
        return (T) f0();
    }

    public final int p() {
        return this.u;
    }

    public final boolean q() {
        return this.C;
    }

    @Deprecated
    public T q0(l<Bitmap>... lVarArr) {
        return (T) m0(new com.bumptech.glide.load.g(lVarArr), true);
    }

    public final com.bumptech.glide.load.i r() {
        return this.v;
    }

    public T r0(boolean z) {
        if (this.A) {
            return (T) clone().r0(z);
        }
        this.E = z;
        this.f9484f |= CacheHelper.VALUE_TO_CONVERT_MB_TO_BYTES;
        return (T) f0();
    }

    public final int s() {
        return this.o;
    }

    public final int t() {
        return this.p;
    }

    public final Drawable u() {
        return this.l;
    }

    public final int v() {
        return this.m;
    }

    public final com.bumptech.glide.g w() {
        return this.f9487i;
    }
}
