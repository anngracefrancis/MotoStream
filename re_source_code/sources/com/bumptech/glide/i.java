package com.bumptech.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bumptech.glide.m.m;
import com.bumptech.glide.m.n;
import com.bumptech.glide.m.p;
import com.bumptech.glide.r.k;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: RequestManager.java */
/* JADX INFO: loaded from: classes.dex */
public class i implements com.bumptech.glide.m.i {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final com.bumptech.glide.p.h f8951f = com.bumptech.glide.p.h.s0(Bitmap.class).Q();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final com.bumptech.glide.p.h f8952g = com.bumptech.glide.p.h.s0(com.bumptech.glide.load.o.g.c.class).Q();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final com.bumptech.glide.p.h f8953h = com.bumptech.glide.p.h.t0(com.bumptech.glide.load.engine.j.f9141c).b0(g.LOW).k0(true);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected final com.bumptech.glide.c f8954i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected final Context f8955j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final com.bumptech.glide.m.h f8956k;
    private final n l;
    private final m m;
    private final p n;
    private final Runnable o;
    private final Handler p;
    private final com.bumptech.glide.m.c q;
    private final CopyOnWriteArrayList<com.bumptech.glide.p.g<Object>> r;
    private com.bumptech.glide.p.h s;

    /* JADX INFO: compiled from: RequestManager.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            i iVar = i.this;
            iVar.f8956k.a(iVar);
        }
    }

    /* JADX INFO: compiled from: RequestManager.java */
    private static class b extends com.bumptech.glide.p.l.j<View, Object> {
        b(View view) {
            super(view);
        }

        @Override // com.bumptech.glide.p.l.i
        public void onResourceReady(Object obj, com.bumptech.glide.p.m.d<? super Object> dVar) {
        }
    }

    /* JADX INFO: compiled from: RequestManager.java */
    private class c implements com.bumptech.glide.m.c.a {
        private final n a;

        c(n nVar) {
            this.a = nVar;
        }

        @Override // com.bumptech.glide.m.c.a
        public void a(boolean z) {
            if (z) {
                synchronized (i.this) {
                    this.a.e();
                }
            }
        }
    }

    public i(com.bumptech.glide.c cVar, com.bumptech.glide.m.h hVar, m mVar, Context context) {
        this(cVar, hVar, mVar, new n(), cVar.g(), context);
    }

    private void q(com.bumptech.glide.p.l.i<?> iVar) {
        if (p(iVar) || this.f8954i.p(iVar) || iVar.getRequest() == null) {
            return;
        }
        com.bumptech.glide.p.d request = iVar.getRequest();
        iVar.setRequest(null);
        request.clear();
    }

    public <ResourceType> h<ResourceType> a(Class<ResourceType> cls) {
        return new h<>(this.f8954i, this, cls, this.f8955j);
    }

    public h<Bitmap> b() {
        return a(Bitmap.class).b(f8951f);
    }

    public h<Drawable> c() {
        return a(Drawable.class);
    }

    public void d(View view) {
        e(new b(view));
    }

    public synchronized void e(com.bumptech.glide.p.l.i<?> iVar) {
        if (iVar == null) {
            return;
        }
        q(iVar);
    }

    List<com.bumptech.glide.p.g<Object>> f() {
        return this.r;
    }

    synchronized com.bumptech.glide.p.h g() {
        return this.s;
    }

    <T> j<?, T> h(Class<T> cls) {
        return this.f8954i.i().e(cls);
    }

    public h<Drawable> i(Uri uri) {
        return c().G0(uri);
    }

    public h<Drawable> j(Integer num) {
        return c().H0(num);
    }

    public h<Drawable> k(String str) {
        return c().K0(str);
    }

    public synchronized void l() {
        this.l.d();
    }

    public synchronized void m() {
        this.l.f();
    }

    protected synchronized void n(com.bumptech.glide.p.h hVar) {
        this.s = hVar.clone().d();
    }

    synchronized void o(com.bumptech.glide.p.l.i<?> iVar, com.bumptech.glide.p.d dVar) {
        this.n.c(iVar);
        this.l.g(dVar);
    }

    @Override // com.bumptech.glide.m.i
    public synchronized void onDestroy() {
        this.n.onDestroy();
        Iterator<com.bumptech.glide.p.l.i<?>> it = this.n.b().iterator();
        while (it.hasNext()) {
            e(it.next());
        }
        this.n.a();
        this.l.c();
        this.f8956k.b(this);
        this.f8956k.b(this.q);
        this.p.removeCallbacks(this.o);
        this.f8954i.s(this);
    }

    @Override // com.bumptech.glide.m.i
    public synchronized void onStart() {
        m();
        this.n.onStart();
    }

    @Override // com.bumptech.glide.m.i
    public synchronized void onStop() {
        l();
        this.n.onStop();
    }

    synchronized boolean p(com.bumptech.glide.p.l.i<?> iVar) {
        com.bumptech.glide.p.d request = iVar.getRequest();
        if (request == null) {
            return true;
        }
        if (!this.l.b(request)) {
            return false;
        }
        this.n.d(iVar);
        iVar.setRequest(null);
        return true;
    }

    public synchronized String toString() {
        return super.toString() + "{tracker=" + this.l + ", treeNode=" + this.m + "}";
    }

    i(com.bumptech.glide.c cVar, com.bumptech.glide.m.h hVar, m mVar, n nVar, com.bumptech.glide.m.d dVar, Context context) {
        this.n = new p();
        a aVar = new a();
        this.o = aVar;
        Handler handler = new Handler(Looper.getMainLooper());
        this.p = handler;
        this.f8954i = cVar;
        this.f8956k = hVar;
        this.m = mVar;
        this.l = nVar;
        this.f8955j = context;
        com.bumptech.glide.m.c cVarA = dVar.a(context.getApplicationContext(), new c(nVar));
        this.q = cVarA;
        if (k.q()) {
            handler.post(aVar);
        } else {
            hVar.a(this);
        }
        hVar.a(cVarA);
        this.r = new CopyOnWriteArrayList<>(cVar.i().c());
        n(cVar.i().d());
        cVar.o(this);
    }
}
