package com.bumptech.glide.load.m;

import android.content.res.AssetManager;
import android.util.Log;
import java.io.IOException;

/* JADX INFO: compiled from: AssetPathFetcher.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class b<T> implements d<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f9260f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final AssetManager f9261g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private T f9262h;

    public b(AssetManager assetManager, String str) {
        this.f9261g = assetManager;
        this.f9260f = str;
    }

    @Override // com.bumptech.glide.load.m.d
    public void b() {
        T t = this.f9262h;
        if (t == null) {
            return;
        }
        try {
            c(t);
        } catch (IOException unused) {
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
    public void e(com.bumptech.glide.g gVar, d.a<? super T> aVar) {
        try {
            T tF = f(this.f9261g, this.f9260f);
            this.f9262h = tF;
            aVar.f(tF);
        } catch (IOException e2) {
            if (Log.isLoggable("AssetPathFetcher", 3)) {
                Log.d("AssetPathFetcher", "Failed to load data from asset manager", e2);
            }
            aVar.c(e2);
        }
    }

    protected abstract T f(AssetManager assetManager, String str) throws IOException;
}
