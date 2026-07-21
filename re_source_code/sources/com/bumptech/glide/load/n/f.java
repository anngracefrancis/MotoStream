package com.bumptech.glide.load.n;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: FileLoader.java */
/* JADX INFO: loaded from: classes.dex */
public class f<Data> implements n<File, Data> {
    private final d<Data> a;

    /* JADX INFO: compiled from: FileLoader.java */
    public static class a<Data> implements o<File, Data> {
        private final d<Data> a;

        public a(d<Data> dVar) {
            this.a = dVar;
        }

        @Override // com.bumptech.glide.load.n.o
        public final n<File, Data> b(r rVar) {
            return new f(this.a);
        }
    }

    /* JADX INFO: compiled from: FileLoader.java */
    public static class b extends a<ParcelFileDescriptor> {

        /* JADX INFO: compiled from: FileLoader.java */
        class a implements d<ParcelFileDescriptor> {
            a() {
            }

            @Override // com.bumptech.glide.load.n.f.d
            public Class<ParcelFileDescriptor> a() {
                return ParcelFileDescriptor.class;
            }

            @Override // com.bumptech.glide.load.n.f.d
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public void b(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
                parcelFileDescriptor.close();
            }

            @Override // com.bumptech.glide.load.n.f.d
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public ParcelFileDescriptor c(File file) throws FileNotFoundException {
                return ParcelFileDescriptor.open(file, 268435456);
            }
        }

        public b() {
            super(new a());
        }
    }

    /* JADX INFO: compiled from: FileLoader.java */
    private static final class c<Data> implements com.bumptech.glide.load.m.d<Data> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final File f9301f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final d<Data> f9302g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private Data f9303h;

        c(File file, d<Data> dVar) {
            this.f9301f = file;
            this.f9302g = dVar;
        }

        @Override // com.bumptech.glide.load.m.d
        public Class<Data> a() {
            return this.f9302g.a();
        }

        @Override // com.bumptech.glide.load.m.d
        public void b() {
            Data data = this.f9303h;
            if (data != null) {
                try {
                    this.f9302g.b(data);
                } catch (IOException unused) {
                }
            }
        }

        @Override // com.bumptech.glide.load.m.d
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.m.d
        public com.bumptech.glide.load.a d() {
            return com.bumptech.glide.load.a.LOCAL;
        }

        /* JADX WARN: Type inference failed for: r3v3, types: [Data, java.lang.Object] */
        @Override // com.bumptech.glide.load.m.d
        public void e(com.bumptech.glide.g gVar, com.bumptech.glide.load.m.d.a<? super Data> aVar) {
            try {
                Data dataC = this.f9302g.c(this.f9301f);
                this.f9303h = dataC;
                aVar.f(dataC);
            } catch (FileNotFoundException e2) {
                if (Log.isLoggable("FileLoader", 3)) {
                    Log.d("FileLoader", "Failed to open file", e2);
                }
                aVar.c(e2);
            }
        }
    }

    /* JADX INFO: compiled from: FileLoader.java */
    public interface d<Data> {
        Class<Data> a();

        void b(Data data) throws IOException;

        Data c(File file) throws FileNotFoundException;
    }

    /* JADX INFO: compiled from: FileLoader.java */
    public static class e extends a<InputStream> {

        /* JADX INFO: compiled from: FileLoader.java */
        class a implements d<InputStream> {
            a() {
            }

            @Override // com.bumptech.glide.load.n.f.d
            public Class<InputStream> a() {
                return InputStream.class;
            }

            @Override // com.bumptech.glide.load.n.f.d
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public void b(InputStream inputStream) throws IOException {
                inputStream.close();
            }

            @Override // com.bumptech.glide.load.n.f.d
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public InputStream c(File file) throws FileNotFoundException {
                return new FileInputStream(file);
            }
        }

        public e() {
            super(new a());
        }
    }

    public f(d<Data> dVar) {
        this.a = dVar;
    }

    @Override // com.bumptech.glide.load.n.n
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a<Data> b(File file, int i2, int i3, com.bumptech.glide.load.i iVar) {
        return new n.a<>(new com.bumptech.glide.q.c(file), new c(file, this.a));
    }

    @Override // com.bumptech.glide.load.n.n
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(File file) {
        return true;
    }
}
