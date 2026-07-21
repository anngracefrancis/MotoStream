package com.bumptech.glide.load.n;

/* JADX INFO: compiled from: UnitModelLoader.java */
/* JADX INFO: loaded from: classes.dex */
public class v<Model> implements n<Model, Model> {
    private static final v<?> a = new v<>();

    /* JADX INFO: compiled from: UnitModelLoader.java */
    public static class a<Model> implements o<Model, Model> {
        private static final a<?> a = new a<>();

        @Deprecated
        public a() {
        }

        public static <T> a<T> a() {
            return (a<T>) a;
        }

        @Override // com.bumptech.glide.load.n.o
        public n<Model, Model> b(r rVar) {
            return v.c();
        }
    }

    /* JADX INFO: compiled from: UnitModelLoader.java */
    private static class b<Model> implements com.bumptech.glide.load.m.d<Model> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Model f9343f;

        b(Model model) {
            this.f9343f = model;
        }

        @Override // com.bumptech.glide.load.m.d
        public Class<Model> a() {
            return (Class<Model>) this.f9343f.getClass();
        }

        @Override // com.bumptech.glide.load.m.d
        public void b() {
        }

        @Override // com.bumptech.glide.load.m.d
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.m.d
        public com.bumptech.glide.load.a d() {
            return com.bumptech.glide.load.a.LOCAL;
        }

        @Override // com.bumptech.glide.load.m.d
        public void e(com.bumptech.glide.g gVar, com.bumptech.glide.load.m.d.a<? super Model> aVar) {
            aVar.f(this.f9343f);
        }
    }

    @Deprecated
    public v() {
    }

    public static <T> v<T> c() {
        return (v<T>) a;
    }

    @Override // com.bumptech.glide.load.n.n
    public boolean a(Model model) {
        return true;
    }

    @Override // com.bumptech.glide.load.n.n
    public n.a<Model> b(Model model, int i2, int i3, com.bumptech.glide.load.i iVar) {
        return new n.a<>(new com.bumptech.glide.q.c(model), new b(model));
    }
}
