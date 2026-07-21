package com.bumptech.glide.load.o.g;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bumptech.glide.load.l;
import com.bumptech.glide.r.k;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: GifFrameLoader.java */
/* JADX INFO: loaded from: classes.dex */
class g {
    private final com.bumptech.glide.l.a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f9425b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<b> f9426c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final com.bumptech.glide.i f9427d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.z.e f9428e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f9429f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f9430g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f9431h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private com.bumptech.glide.h<Bitmap> f9432i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private a f9433j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f9434k;
    private a l;
    private Bitmap m;
    private l<Bitmap> n;
    private a o;
    private d p;

    /* JADX INFO: compiled from: GifFrameLoader.java */
    static class a extends com.bumptech.glide.p.l.g<Bitmap> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Handler f9435f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final int f9436g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final long f9437h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private Bitmap f9438i;

        a(Handler handler, int i2, long j2) {
            this.f9435f = handler;
            this.f9436g = i2;
            this.f9437h = j2;
        }

        Bitmap c() {
            return this.f9438i;
        }

        @Override // com.bumptech.glide.p.l.i
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void onResourceReady(Bitmap bitmap, com.bumptech.glide.p.m.d<? super Bitmap> dVar) {
            this.f9438i = bitmap;
            this.f9435f.sendMessageAtTime(this.f9435f.obtainMessage(1, this), this.f9437h);
        }
    }

    /* JADX INFO: compiled from: GifFrameLoader.java */
    public interface b {
        void a();
    }

    /* JADX INFO: compiled from: GifFrameLoader.java */
    private class c implements Handler.Callback {
        c() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                g.this.n((a) message.obj);
                return true;
            }
            if (i2 != 2) {
                return false;
            }
            g.this.f9427d.e((a) message.obj);
            return false;
        }
    }

    /* JADX INFO: compiled from: GifFrameLoader.java */
    interface d {
        void a();
    }

    g(com.bumptech.glide.c cVar, com.bumptech.glide.l.a aVar, int i2, int i3, l<Bitmap> lVar, Bitmap bitmap) {
        this(cVar.f(), com.bumptech.glide.c.t(cVar.h()), aVar, null, j(com.bumptech.glide.c.t(cVar.h()), i2, i3), lVar, bitmap);
    }

    private static com.bumptech.glide.load.f g() {
        return new com.bumptech.glide.q.c(Double.valueOf(Math.random()));
    }

    private int h() {
        return k.g(c().getWidth(), c().getHeight(), c().getConfig());
    }

    private static com.bumptech.glide.h<Bitmap> j(com.bumptech.glide.i iVar, int i2, int i3) {
        return iVar.b().b(com.bumptech.glide.p.h.t0(com.bumptech.glide.load.engine.j.f9140b).r0(true).k0(true).X(i2, i3));
    }

    private void m() {
        if (!this.f9429f || this.f9430g) {
            return;
        }
        if (this.f9431h) {
            com.bumptech.glide.r.j.a(this.o == null, "Pending target must be null when starting from the first frame");
            this.a.g();
            this.f9431h = false;
        }
        a aVar = this.o;
        if (aVar != null) {
            this.o = null;
            n(aVar);
            return;
        }
        this.f9430g = true;
        long jUptimeMillis = SystemClock.uptimeMillis() + ((long) this.a.e());
        this.a.c();
        this.l = new a(this.f9425b, this.a.h(), jUptimeMillis);
        this.f9432i.b(com.bumptech.glide.p.h.v0(g())).I0(this.a).A0(this.l);
    }

    private void o() {
        Bitmap bitmap = this.m;
        if (bitmap != null) {
            this.f9428e.c(bitmap);
            this.m = null;
        }
    }

    private void q() {
        if (this.f9429f) {
            return;
        }
        this.f9429f = true;
        this.f9434k = false;
        m();
    }

    private void r() {
        this.f9429f = false;
    }

    void a() {
        this.f9426c.clear();
        o();
        r();
        a aVar = this.f9433j;
        if (aVar != null) {
            this.f9427d.e(aVar);
            this.f9433j = null;
        }
        a aVar2 = this.l;
        if (aVar2 != null) {
            this.f9427d.e(aVar2);
            this.l = null;
        }
        a aVar3 = this.o;
        if (aVar3 != null) {
            this.f9427d.e(aVar3);
            this.o = null;
        }
        this.a.clear();
        this.f9434k = true;
    }

    ByteBuffer b() {
        return this.a.b().asReadOnlyBuffer();
    }

    Bitmap c() {
        a aVar = this.f9433j;
        return aVar != null ? aVar.c() : this.m;
    }

    int d() {
        a aVar = this.f9433j;
        if (aVar != null) {
            return aVar.f9436g;
        }
        return -1;
    }

    Bitmap e() {
        return this.m;
    }

    int f() {
        return this.a.d();
    }

    int i() {
        return c().getHeight();
    }

    int k() {
        return this.a.i() + h();
    }

    int l() {
        return c().getWidth();
    }

    void n(a aVar) {
        d dVar = this.p;
        if (dVar != null) {
            dVar.a();
        }
        this.f9430g = false;
        if (this.f9434k) {
            this.f9425b.obtainMessage(2, aVar).sendToTarget();
            return;
        }
        if (!this.f9429f) {
            this.o = aVar;
            return;
        }
        if (aVar.c() != null) {
            o();
            a aVar2 = this.f9433j;
            this.f9433j = aVar;
            for (int size = this.f9426c.size() - 1; size >= 0; size--) {
                this.f9426c.get(size).a();
            }
            if (aVar2 != null) {
                this.f9425b.obtainMessage(2, aVar2).sendToTarget();
            }
        }
        m();
    }

    void p(l<Bitmap> lVar, Bitmap bitmap) {
        this.n = (l) com.bumptech.glide.r.j.d(lVar);
        this.m = (Bitmap) com.bumptech.glide.r.j.d(bitmap);
        this.f9432i = this.f9432i.b(new com.bumptech.glide.p.h().l0(lVar));
    }

    void s(b bVar) {
        if (this.f9434k) {
            throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        }
        if (this.f9426c.contains(bVar)) {
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
        boolean zIsEmpty = this.f9426c.isEmpty();
        this.f9426c.add(bVar);
        if (zIsEmpty) {
            q();
        }
    }

    void t(b bVar) {
        this.f9426c.remove(bVar);
        if (this.f9426c.isEmpty()) {
            r();
        }
    }

    g(com.bumptech.glide.load.engine.z.e eVar, com.bumptech.glide.i iVar, com.bumptech.glide.l.a aVar, Handler handler, com.bumptech.glide.h<Bitmap> hVar, l<Bitmap> lVar, Bitmap bitmap) {
        this.f9426c = new ArrayList();
        this.f9427d = iVar;
        handler = handler == null ? new Handler(Looper.getMainLooper(), new c()) : handler;
        this.f9428e = eVar;
        this.f9425b = handler;
        this.f9432i = hVar;
        this.a = aVar;
        p(lVar, bitmap);
    }
}
