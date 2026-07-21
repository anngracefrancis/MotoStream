package com.bumptech.glide.p.m;

import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: DrawableCrossFadeFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements e<Drawable> {
    private final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f9532b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private b f9533c;

    /* JADX INFO: renamed from: com.bumptech.glide.p.m.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DrawableCrossFadeFactory.java */
    public static class C0141a {
        private final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f9534b;

        public C0141a() {
            this(300);
        }

        public a a() {
            return new a(this.a, this.f9534b);
        }

        public C0141a(int i2) {
            this.a = i2;
        }
    }

    protected a(int i2, boolean z) {
        this.a = i2;
        this.f9532b = z;
    }

    private d<Drawable> b() {
        if (this.f9533c == null) {
            this.f9533c = new b(this.a, this.f9532b);
        }
        return this.f9533c;
    }

    @Override // com.bumptech.glide.p.m.e
    public d<Drawable> a(com.bumptech.glide.load.a aVar, boolean z) {
        return aVar == com.bumptech.glide.load.a.MEMORY_CACHE ? c.b() : b();
    }
}
