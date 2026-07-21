package com.bumptech.glide.load.n;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import java.io.File;
import java.io.InputStream;

/* JADX INFO: compiled from: StringLoader.java */
/* JADX INFO: loaded from: classes.dex */
public class u<Data> implements n<String, Data> {
    private final n<Uri, Data> a;

    /* JADX INFO: compiled from: StringLoader.java */
    public static final class a implements o<String, AssetFileDescriptor> {
        @Override // com.bumptech.glide.load.n.o
        public n<String, AssetFileDescriptor> b(r rVar) {
            return new u(rVar.d(Uri.class, AssetFileDescriptor.class));
        }
    }

    /* JADX INFO: compiled from: StringLoader.java */
    public static class b implements o<String, ParcelFileDescriptor> {
        @Override // com.bumptech.glide.load.n.o
        public n<String, ParcelFileDescriptor> b(r rVar) {
            return new u(rVar.d(Uri.class, ParcelFileDescriptor.class));
        }
    }

    /* JADX INFO: compiled from: StringLoader.java */
    public static class c implements o<String, InputStream> {
        @Override // com.bumptech.glide.load.n.o
        public n<String, InputStream> b(r rVar) {
            return new u(rVar.d(Uri.class, InputStream.class));
        }
    }

    public u(n<Uri, Data> nVar) {
        this.a = nVar;
    }

    private static Uri e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.charAt(0) == '/') {
            return f(str);
        }
        Uri uri = Uri.parse(str);
        return uri.getScheme() == null ? f(str) : uri;
    }

    private static Uri f(String str) {
        return Uri.fromFile(new File(str));
    }

    @Override // com.bumptech.glide.load.n.n
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a<Data> b(String str, int i2, int i3, com.bumptech.glide.load.i iVar) {
        Uri uriE = e(str);
        if (uriE == null || !this.a.a(uriE)) {
            return null;
        }
        return this.a.b(uriE, i2, i3, iVar);
    }

    @Override // com.bumptech.glide.load.n.n
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(String str) {
        return true;
    }
}
