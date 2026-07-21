package com.bumptech.glide.load.n;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: UriLoader.java */
/* JADX INFO: loaded from: classes.dex */
public class w<Data> implements n<Uri, Data> {
    private static final Set<String> a = Collections.unmodifiableSet(new HashSet(Arrays.asList("file", "android.resource", "content")));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c<Data> f9344b;

    /* JADX INFO: compiled from: UriLoader.java */
    public static final class a implements o<Uri, AssetFileDescriptor>, c<AssetFileDescriptor> {
        private final ContentResolver a;

        public a(ContentResolver contentResolver) {
            this.a = contentResolver;
        }

        @Override // com.bumptech.glide.load.n.w.c
        public com.bumptech.glide.load.m.d<AssetFileDescriptor> a(Uri uri) {
            return new com.bumptech.glide.load.m.a(this.a, uri);
        }

        @Override // com.bumptech.glide.load.n.o
        public n<Uri, AssetFileDescriptor> b(r rVar) {
            return new w(this);
        }
    }

    /* JADX INFO: compiled from: UriLoader.java */
    public static class b implements o<Uri, ParcelFileDescriptor>, c<ParcelFileDescriptor> {
        private final ContentResolver a;

        public b(ContentResolver contentResolver) {
            this.a = contentResolver;
        }

        @Override // com.bumptech.glide.load.n.w.c
        public com.bumptech.glide.load.m.d<ParcelFileDescriptor> a(Uri uri) {
            return new com.bumptech.glide.load.m.i(this.a, uri);
        }

        @Override // com.bumptech.glide.load.n.o
        public n<Uri, ParcelFileDescriptor> b(r rVar) {
            return new w(this);
        }
    }

    /* JADX INFO: compiled from: UriLoader.java */
    public interface c<Data> {
        com.bumptech.glide.load.m.d<Data> a(Uri uri);
    }

    /* JADX INFO: compiled from: UriLoader.java */
    public static class d implements o<Uri, InputStream>, c<InputStream> {
        private final ContentResolver a;

        public d(ContentResolver contentResolver) {
            this.a = contentResolver;
        }

        @Override // com.bumptech.glide.load.n.w.c
        public com.bumptech.glide.load.m.d<InputStream> a(Uri uri) {
            return new com.bumptech.glide.load.m.n(this.a, uri);
        }

        @Override // com.bumptech.glide.load.n.o
        public n<Uri, InputStream> b(r rVar) {
            return new w(this);
        }
    }

    public w(c<Data> cVar) {
        this.f9344b = cVar;
    }

    @Override // com.bumptech.glide.load.n.n
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a<Data> b(Uri uri, int i2, int i3, com.bumptech.glide.load.i iVar) {
        return new n.a<>(new com.bumptech.glide.q.c(uri), this.f9344b.a(uri));
    }

    @Override // com.bumptech.glide.load.n.n
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(Uri uri) {
        return a.contains(uri.getScheme());
    }
}
