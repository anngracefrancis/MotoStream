package com.bumptech.glide.load.n;

import java.util.Queue;

/* JADX INFO: compiled from: ModelCache.java */
/* JADX INFO: loaded from: classes.dex */
public class m<A, B> {
    private final com.bumptech.glide.r.g<b<A>, B> a;

    /* JADX INFO: compiled from: ModelCache.java */
    class a extends com.bumptech.glide.r.g<b<A>, B> {
        a(long j2) {
            super(j2);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bumptech.glide.r.g
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public void j(b<A> bVar, B b2) {
            bVar.c();
        }
    }

    /* JADX INFO: compiled from: ModelCache.java */
    static final class b<A> {
        private static final Queue<b<?>> a = com.bumptech.glide.r.k.f(0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f9322b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f9323c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private A f9324d;

        private b() {
        }

        static <A> b<A> a(A a2, int i2, int i3) {
            b<A> bVar;
            Queue<b<?>> queue = a;
            synchronized (queue) {
                bVar = (b) queue.poll();
            }
            if (bVar == null) {
                bVar = new b<>();
            }
            bVar.b(a2, i2, i3);
            return bVar;
        }

        private void b(A a2, int i2, int i3) {
            this.f9324d = a2;
            this.f9323c = i2;
            this.f9322b = i3;
        }

        public void c() {
            Queue<b<?>> queue = a;
            synchronized (queue) {
                queue.offer(this);
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f9323c == bVar.f9323c && this.f9322b == bVar.f9322b && this.f9324d.equals(bVar.f9324d);
        }

        public int hashCode() {
            return (((this.f9322b * 31) + this.f9323c) * 31) + this.f9324d.hashCode();
        }
    }

    public m(long j2) {
        this.a = new a(j2);
    }

    public B a(A a2, int i2, int i3) {
        b<A> bVarA = b.a(a2, i2, i3);
        B bG = this.a.g(bVarA);
        bVarA.c();
        return bG;
    }

    public void b(A a2, int i2, int i3, B b2) {
        this.a.k(b.a(a2, i2, i3), b2);
    }
}
