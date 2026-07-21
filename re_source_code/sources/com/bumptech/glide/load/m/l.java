package com.bumptech.glide.load.m;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: compiled from: LocalUriFetcher.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class l<T> implements d<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Uri f9279f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ContentResolver f9280g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private T f9281h;

    public l(ContentResolver contentResolver, Uri uri) {
        this.f9280g = contentResolver;
        this.f9279f = uri;
    }

    @Override // com.bumptech.glide.load.m.d
    public void b() {
        T t = this.f9281h;
        if (t != null) {
            try {
                c(t);
            } catch (IOException unused) {
            }
        }
    }

    protected abstract void c(T t) throws IOException;

    @Override // com.bumptech.glide.load.m.d
    public void cancel() {
    }

    @Override // com.bumptech.glide.load.m.d
    public com.bumptech.glide.load.a d() {
        return com.bumptech.glide.load.a.LOCAL;
    }

    @Override // com.bumptech.glide.load.m.d
    public final void e(com.bumptech.glide.g gVar, d.a<? super T> aVar) {
        try {
            T tF = f(this.f9279f, this.f9280g);
            this.f9281h = tF;
            aVar.f(tF);
        } catch (FileNotFoundException e2) {
            if (Log.isLoggable("LocalUriFetcher", 3)) {
                Log.d("LocalUriFetcher", "Failed to open Uri", e2);
            }
            aVar.c(e2);
        }
    }

    protected abstract T f(Uri uri, ContentResolver contentResolver) throws FileNotFoundException;
}
