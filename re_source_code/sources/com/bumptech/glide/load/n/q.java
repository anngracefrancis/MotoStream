package com.bumptech.glide.load.n;

import com.bumptech.glide.load.engine.GlideException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: MultiModelLoader.java */
/* JADX INFO: loaded from: classes.dex */
class q<Model, Data> implements n<Model, Data> {
    private final List<n<Model, Data>> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c.i.j.f<List<Throwable>> f9328b;

    /* JADX INFO: compiled from: MultiModelLoader.java */
    static class a<Data> implements com.bumptech.glide.load.m.d<Data>, com.bumptech.glide.load.m.d.a<Data> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final List<com.bumptech.glide.load.m.d<Data>> f9329f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final c.i.j.f<List<Throwable>> f9330g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f9331h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private com.bumptech.glide.g f9332i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private com.bumptech.glide.load.m.d.a<? super Data> f9333j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private List<Throwable> f9334k;
        private boolean l;

        a(List<com.bumptech.glide.load.m.d<Data>> list, c.i.j.f<List<Throwable>> fVar) {
            this.f9330g = fVar;
            com.bumptech.glide.r.j.c(list);
            this.f9329f = list;
            this.f9331h = 0;
        }

        private void g() {
            if (this.l) {
                return;
            }
            if (this.f9331h < this.f9329f.size() - 1) {
                this.f9331h++;
                e(this.f9332i, this.f9333j);
            } else {
                com.bumptech.glide.r.j.d(this.f9334k);
                this.f9333j.c(new GlideException("Fetch failed", new ArrayList(this.f9334k)));
            }
        }

        @Override // com.bumptech.glide.load.m.d
        public Class<Data> a() {
            return this.f9329f.get(0).a();
        }

        @Override // com.bumptech.glide.load.m.d
        public void b() {
            List<Throwable> list = this.f9334k;
            if (list != null) {
                this.f9330g.a(list);
            }
            this.f9334k = null;
            Iterator<com.bumptech.glide.load.m.d<Data>> it = this.f9329f.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
        }

        @Override // com.bumptech.glide.load.m.d.a
        public void c(Exception exc) {
            ((List) com.bumptech.glide.r.j.d(this.f9334k)).add(exc);
            g();
        }

        @Override // com.bumptech.glide.load.m.d
        public void cancel() {
            this.l = true;
            Iterator<com.bumptech.glide.load.m.d<Data>> it = this.f9329f.iterator();
            while (it.hasNext()) {
                it.next().cancel();
            }
        }

        @Override // com.bumptech.glide.load.m.d
        public com.bumptech.glide.load.a d() {
            return this.f9329f.get(0).d();
        }

        @Override // com.bumptech.glide.load.m.d
        public void e(com.bumptech.glide.g gVar, com.bumptech.glide.load.m.d.a<? super Data> aVar) {
            this.f9332i = gVar;
            this.f9333j = aVar;
            this.f9334k = this.f9330g.b();
            this.f9329f.get(this.f9331h).e(gVar, this);
            if (this.l) {
                cancel();
            }
        }

        @Override // com.bumptech.glide.load.m.d.a
        public void f(Data data) {
            if (data != null) {
                this.f9333j.f(data);
            } else {
                g();
            }
        }
    }

    q(List<n<Model, Data>> list, c.i.j.f<List<Throwable>> fVar) {
        this.a = list;
        this.f9328b = fVar;
    }

    @Override // com.bumptech.glide.load.n.n
    public boolean a(Model model) {
        Iterator<n<Model, Data>> it = this.a.iterator();
        while (it.hasNext()) {
            if (it.next().a(model)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bumptech.glide.load.n.n
    public n.a<Data> b(Model model, int i2, int i3, com.bumptech.glide.load.i iVar) {
        n.a<Data> aVarB;
        int size = this.a.size();
        ArrayList arrayList = new ArrayList(size);
        com.bumptech.glide.load.f fVar = null;
        for (int i4 = 0; i4 < size; i4++) {
            n<Model, Data> nVar = this.a.get(i4);
            if (nVar.a(model) && (aVarB = nVar.b(model, i2, i3, iVar)) != null) {
                fVar = aVarB.a;
                arrayList.add(aVarB.f9326c);
            }
        }
        if (arrayList.isEmpty() || fVar == null) {
            return null;
        }
        return new n.a<>(fVar, new a(arrayList, this.f9328b));
    }

    public String toString() {
        return "MultiModelLoader{modelLoaders=" + Arrays.toString(this.a.toArray()) + '}';
    }
}
