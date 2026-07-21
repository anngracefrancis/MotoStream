package com.bumptech.glide.load.n;

import android.content.res.AssetManager;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import java.io.InputStream;

/* JADX INFO: compiled from: AssetUriLoader.java */
/* JADX INFO: loaded from: classes.dex */
public class a<Data> implements n<Uri, Data> {
    private static final int a = 22;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AssetManager f9293b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final InterfaceC0132a<Data> f9294c;

    /* JADX INFO: renamed from: com.bumptech.glide.load.n.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AssetUriLoader.java */
    public interface InterfaceC0132a<Data> {
        com.bumptech.glide.load.m.d<Data> a(AssetManager assetManager, String str);
    }

    /* JADX INFO: compiled from: AssetUriLoader.java */
    public static class b implements o<Uri, ParcelFileDescriptor>, InterfaceC0132a<ParcelFileDescriptor> {
        private final AssetManager a;

        public b(AssetManager assetManager) {
            this.a = assetManager;
        }

        @Override // com.bumptech.glide.load.n.a.InterfaceC0132a
        public com.bumptech.glide.load.m.d<ParcelFileDescriptor> a(AssetManager assetManager, String str) {
            return new com.bumptech.glide.load.m.h(assetManager, str);
        }

        @Override // com.bumptech.glide.load.n.o
        public n<Uri, ParcelFileDescriptor> b(r rVar) {
            return new a(this.a, this);
        }
    }

    /* JADX INFO: compiled from: AssetUriLoader.java */
    public static class c implements o<Uri, InputStream>, InterfaceC0132a<InputStream> {
        private final AssetManager a;

        public c(AssetManager assetManager) {
            this.a = assetManager;
        }

        @Override // com.bumptech.glide.load.n.a.InterfaceC0132a
        public com.bumptech.glide.load.m.d<InputStream> a(AssetManager assetManager, String str) {
            return new com.bumptech.glide.load.m.m(assetManager, str);
        }

        @Override // com.bumptech.glide.load.n.o
        public n<Uri, InputStream> b(r rVar) {
            return new a(this.a, this);
        }
    }

    public a(AssetManager assetManager, InterfaceC0132a<Data> interfaceC0132a) {
        this.f9293b = assetManager;
        this.f9294c = interfaceC0132a;
    }

    @Override // com.bumptech.glide.load.n.n
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a<Data> b(Uri uri, int i2, int i3, com.bumptech.glide.load.i iVar) {
        return new n.a<>(new com.bumptech.glide.q.c(uri), this.f9294c.a(this.f9293b, uri.toString().substring(a)));
    }

    @Override // com.bumptech.glide.load.n.n
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(Uri uri) {
        return "file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0));
    }
}
