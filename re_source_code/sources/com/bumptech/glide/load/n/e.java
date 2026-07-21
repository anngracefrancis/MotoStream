package com.bumptech.glide.load.n;

import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: DataUrlLoader.java */
/* JADX INFO: loaded from: classes.dex */
public final class e<Model, Data> implements n<Model, Data> {
    private final a<Data> a;

    /* JADX INFO: compiled from: DataUrlLoader.java */
    public interface a<Data> {
        Class<Data> a();

        void b(Data data) throws IOException;

        Data c(String str) throws IllegalArgumentException;
    }

    /* JADX INFO: compiled from: DataUrlLoader.java */
    private static final class b<Data> implements com.bumptech.glide.load.m.d<Data> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final String f9298f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final a<Data> f9299g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private Data f9300h;

        b(String str, a<Data> aVar) {
            this.f9298f = str;
            this.f9299g = aVar;
        }

        @Override // com.bumptech.glide.load.m.d
        public Class<Data> a() {
            return this.f9299g.a();
        }

        @Override // com.bumptech.glide.load.m.d
        public void b() {
            try {
                this.f9299g.b(this.f9300h);
            } catch (IOException unused) {
            }
        }

        @Override // com.bumptech.glide.load.m.d
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.m.d
        public com.bumptech.glide.load.a d() {
            return com.bumptech.glide.load.a.LOCAL;
        }

        /* JADX WARN: Type inference failed for: r2v3, types: [Data, java.lang.Object] */
        @Override // com.bumptech.glide.load.m.d
        public void e(com.bumptech.glide.g gVar, com.bumptech.glide.load.m.d.a<? super Data> aVar) {
            try {
                Data dataC = this.f9299g.c(this.f9298f);
                this.f9300h = dataC;
                aVar.f(dataC);
            } catch (IllegalArgumentException e2) {
                aVar.c(e2);
            }
        }
    }

    /* JADX INFO: compiled from: DataUrlLoader.java */
    public static final class c<Model> implements o<Model, InputStream> {
        private final a<InputStream> a = new a();

        /* JADX INFO: compiled from: DataUrlLoader.java */
        class a implements a<InputStream> {
            a() {
            }

            @Override // com.bumptech.glide.load.n.e.a
            public Class<InputStream> a() {
                return InputStream.class;
            }

            @Override // com.bumptech.glide.load.n.e.a
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public void b(InputStream inputStream) throws IOException {
                inputStream.close();
            }

            @Override // com.bumptech.glide.load.n.e.a
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public InputStream c(String str) {
                if (!str.startsWith("data:image")) {
                    throw new IllegalArgumentException("Not a valid image data URL.");
                }
                int iIndexOf = str.indexOf(44);
                if (iIndexOf == -1) {
                    throw new IllegalArgumentException("Missing comma in data URL.");
                }
                if (str.substring(0, iIndexOf).endsWith(";base64")) {
                    return new ByteArrayInputStream(Base64.decode(str.substring(iIndexOf + 1), 0));
                }
                throw new IllegalArgumentException("Not a base64 image data URL.");
            }
        }

        @Override // com.bumptech.glide.load.n.o
        public n<Model, InputStream> b(r rVar) {
            return new e(this.a);
        }
    }

    public e(a<Data> aVar) {
        this.a = aVar;
    }

    @Override // com.bumptech.glide.load.n.n
    public boolean a(Model model) {
        return model.toString().startsWith("data:image");
    }

    @Override // com.bumptech.glide.load.n.n
    public n.a<Data> b(Model model, int i2, int i3, com.bumptech.glide.load.i iVar) {
        return new n.a<>(new com.bumptech.glide.q.c(model), new b(model.toString(), this.a));
    }
}
