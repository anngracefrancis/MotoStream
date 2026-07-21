package com.bumptech.glide.load.m.o;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import com.bumptech.glide.load.m.g;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: ThumbFetcher.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements com.bumptech.glide.load.m.d<InputStream> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Uri f9283f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final e f9284g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private InputStream f9285h;

    /* JADX INFO: compiled from: ThumbFetcher.java */
    static class a implements d {
        private static final String[] a = {"_data"};

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ContentResolver f9286b;

        a(ContentResolver contentResolver) {
            this.f9286b = contentResolver;
        }

        @Override // com.bumptech.glide.load.m.o.d
        public Cursor a(Uri uri) {
            return this.f9286b.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, a, "kind = 1 AND image_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }

    /* JADX INFO: compiled from: ThumbFetcher.java */
    static class b implements d {
        private static final String[] a = {"_data"};

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ContentResolver f9287b;

        b(ContentResolver contentResolver) {
            this.f9287b = contentResolver;
        }

        @Override // com.bumptech.glide.load.m.o.d
        public Cursor a(Uri uri) {
            return this.f9287b.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, a, "kind = 1 AND video_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }

    c(Uri uri, e eVar) {
        this.f9283f = uri;
        this.f9284g = eVar;
    }

    private static c c(Context context, Uri uri, d dVar) {
        return new c(uri, new e(com.bumptech.glide.c.c(context).j().g(), dVar, com.bumptech.glide.c.c(context).e(), context.getContentResolver()));
    }

    public static c f(Context context, Uri uri) {
        return c(context, uri, new a(context.getContentResolver()));
    }

    public static c g(Context context, Uri uri) {
        return c(context, uri, new b(context.getContentResolver()));
    }

    private InputStream h() throws FileNotFoundException {
        InputStream inputStreamD = this.f9284g.d(this.f9283f);
        int iA = inputStreamD != null ? this.f9284g.a(this.f9283f) : -1;
        return iA != -1 ? new g(inputStreamD, iA) : inputStreamD;
    }

    @Override // com.bumptech.glide.load.m.d
    public Class<InputStream> a() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.m.d
    public void b() {
        InputStream inputStream = this.f9285h;
        if (inputStream != null) {
            try {
                inputStream.close();
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

    @Override // com.bumptech.glide.load.m.d
    public void e(com.bumptech.glide.g gVar, com.bumptech.glide.load.m.d.a<? super InputStream> aVar) {
        try {
            InputStream inputStreamH = h();
            this.f9285h = inputStreamH;
            aVar.f(inputStreamH);
        } catch (FileNotFoundException e2) {
            if (Log.isLoggable("MediaStoreThumbFetcher", 3)) {
                Log.d("MediaStoreThumbFetcher", "Failed to find thumbnail file", e2);
            }
            aVar.c(e2);
        }
    }
}
