package com.bumptech.glide.load.engine.c0;

import android.os.Handler;
import android.os.Looper;
import com.bumptech.glide.load.b;
import com.bumptech.glide.load.engine.a0.h;
import com.bumptech.glide.load.engine.z.e;

/* JADX INFO: compiled from: BitmapPreFiller.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    private final h a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e f9096b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b f9097c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Handler f9098d = new Handler(Looper.getMainLooper());

    public a(h hVar, e eVar, b bVar) {
        this.a = hVar;
        this.f9096b = eVar;
        this.f9097c = bVar;
    }
}
