package com.bumptech.glide.load.n;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import java.io.File;
import java.io.FileNotFoundException;

/* JADX INFO: compiled from: MediaStoreFileLoader.java */
/* JADX INFO: loaded from: classes.dex */
public final class k implements n<Uri, File> {
    private final Context a;

    /* JADX INFO: compiled from: MediaStoreFileLoader.java */
    public static final class a implements o<Uri, File> {
        private final Context a;

        public a(Context context) {
            this.a = context;
        }

        @Override // com.bumptech.glide.load.n.o
        public n<Uri, File> b(r rVar) {
            return new k(this.a);
        }
    }

    /* JADX INFO: compiled from: MediaStoreFileLoader.java */
    private static class b implements com.bumptech.glide.load.m.d<File> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final String[] f9318f = {"_data"};

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final Context f9319g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final Uri f9320h;

        b(Context context, Uri uri) {
            this.f9319g = context;
            this.f9320h = uri;
        }

        @Override // com.bumptech.glide.load.m.d
        public Class<File> a() {
            return File.class;
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
        public void e(com.bumptech.glide.g gVar, com.bumptech.glide.load.m.d.a<? super File> aVar) {
            Cursor cursorQuery = this.f9319g.getContentResolver().query(this.f9320h, f9318f, null, null, null);
            String string = null;
            if (cursorQuery != null) {
                try {
                    string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data")) : null;
                    cursorQuery.close();
                } catch (Throwable th) {
                    cursorQuery.close();
                    throw th;
                }
            }
            if (!TextUtils.isEmpty(string)) {
                aVar.f(new File(string));
                return;
            }
            aVar.c(new FileNotFoundException("Failed to find file path for: " + this.f9320h));
        }
    }

    public k(Context context) {
        this.a = context;
    }

    @Override // com.bumptech.glide.load.n.n
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a<File> b(Uri uri, int i2, int i3, com.bumptech.glide.load.i iVar) {
        return new n.a<>(new com.bumptech.glide.q.c(uri), new b(this.a, uri));
    }

    @Override // com.bumptech.glide.load.n.n
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(Uri uri) {
        return com.bumptech.glide.load.m.o.b.b(uri);
    }
}
