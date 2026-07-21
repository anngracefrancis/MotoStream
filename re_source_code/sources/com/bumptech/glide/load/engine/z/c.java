package com.bumptech.glide.load.engine.z;

import android.graphics.Bitmap;

/* JADX INFO: compiled from: AttributeStrategy.java */
/* JADX INFO: loaded from: classes.dex */
class c implements l {
    private final b a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final h<a, Bitmap> f9220b = new h<>();

    /* JADX INFO: compiled from: AttributeStrategy.java */
    static class a implements m {
        private final b a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f9221b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f9222c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Bitmap.Config f9223d;

        public a(b bVar) {
            this.a = bVar;
        }

        @Override // com.bumptech.glide.load.engine.z.m
        public void a() {
            this.a.c(this);
        }

        public void b(int i2, int i3, Bitmap.Config config) {
            this.f9221b = i2;
            this.f9222c = i3;
            this.f9223d = config;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f9221b == aVar.f9221b && this.f9222c == aVar.f9222c && this.f9223d == aVar.f9223d;
        }

        public int hashCode() {
            int i2 = ((this.f9221b * 31) + this.f9222c) * 31;
            Bitmap.Config config = this.f9223d;
            return i2 + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return c.g(this.f9221b, this.f9222c, this.f9223d);
        }
    }

    /* JADX INFO: compiled from: AttributeStrategy.java */
    static class b extends d<a> {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bumptech.glide.load.engine.z.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public a a() {
            return new a(this);
        }

        a e(int i2, int i3, Bitmap.Config config) {
            a aVarB = b();
            aVarB.b(i2, i3, config);
            return aVarB;
        }
    }

    c() {
    }

    static String g(int i2, int i3, Bitmap.Config config) {
        return "[" + i2 + "x" + i3 + "], " + config;
    }

    private static String h(Bitmap bitmap) {
        return g(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    @Override // com.bumptech.glide.load.engine.z.l
    public Bitmap a() {
        return this.f9220b.f();
    }

    @Override // com.bumptech.glide.load.engine.z.l
    public String b(int i2, int i3, Bitmap.Config config) {
        return g(i2, i3, config);
    }

    @Override // com.bumptech.glide.load.engine.z.l
    public void c(Bitmap bitmap) {
        this.f9220b.d(this.a.e(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
    }

    @Override // com.bumptech.glide.load.engine.z.l
    public Bitmap d(int i2, int i3, Bitmap.Config config) {
        return this.f9220b.a(this.a.e(i2, i3, config));
    }

    @Override // com.bumptech.glide.load.engine.z.l
    public int e(Bitmap bitmap) {
        return com.bumptech.glide.r.k.h(bitmap);
    }

    @Override // com.bumptech.glide.load.engine.z.l
    public String f(Bitmap bitmap) {
        return h(bitmap);
    }

    public String toString() {
        return "AttributeStrategy:\n  " + this.f9220b;
    }
}
