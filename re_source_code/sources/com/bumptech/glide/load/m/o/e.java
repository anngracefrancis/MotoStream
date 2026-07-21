package com.bumptech.glide.load.m.o;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: compiled from: ThumbnailStreamOpener.java */
/* JADX INFO: loaded from: classes.dex */
class e {
    private static final a a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f9288b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d f9289c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.z.b f9290d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ContentResolver f9291e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<ImageHeaderParser> f9292f;

    e(List<ImageHeaderParser> list, d dVar, com.bumptech.glide.load.engine.z.b bVar, ContentResolver contentResolver) {
        this(list, a, dVar, bVar, contentResolver);
    }

    private String b(Uri uri) {
        Cursor cursorA = this.f9289c.a(uri);
        if (cursorA != null) {
            try {
                if (cursorA.moveToFirst()) {
                    String string = cursorA.getString(0);
                    cursorA.close();
                    return string;
                }
            } catch (Throwable th) {
                cursorA.close();
                throw th;
            }
        }
        if (cursorA != null) {
            cursorA.close();
        }
        return null;
    }

    private boolean c(File file) {
        return this.f9288b.a(file) && 0 < this.f9288b.c(file);
    }

    int a(Uri uri) {
        InputStream inputStreamOpenInputStream = null;
        try {
            try {
                inputStreamOpenInputStream = this.f9291e.openInputStream(uri);
                return com.bumptech.glide.load.e.a(this.f9292f, inputStreamOpenInputStream, this.f9290d);
            } finally {
                if (0 != 0) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (IOException unused) {
                    }
                }
            }
        } catch (IOException | NullPointerException e2) {
            if (Log.isLoggable("ThumbStreamOpener", 3)) {
                Log.d("ThumbStreamOpener", "Failed to open uri: " + uri, e2);
            }
            if (inputStreamOpenInputStream == null) {
                return -1;
            }
            try {
                inputStreamOpenInputStream.close();
                return -1;
            } catch (IOException unused2) {
                return -1;
            }
        }
    }

    public InputStream d(Uri uri) throws FileNotFoundException {
        String strB = b(uri);
        if (TextUtils.isEmpty(strB)) {
            return null;
        }
        File fileB = this.f9288b.b(strB);
        if (!c(fileB)) {
            return null;
        }
        Uri uriFromFile = Uri.fromFile(fileB);
        try {
            return this.f9291e.openInputStream(uriFromFile);
        } catch (NullPointerException e2) {
            throw ((FileNotFoundException) new FileNotFoundException("NPE opening uri: " + uri + " -> " + uriFromFile).initCause(e2));
        }
    }

    e(List<ImageHeaderParser> list, a aVar, d dVar, com.bumptech.glide.load.engine.z.b bVar, ContentResolver contentResolver) {
        this.f9288b = aVar;
        this.f9289c = dVar;
        this.f9290d = bVar;
        this.f9291e = contentResolver;
        this.f9292f = list;
    }
}
