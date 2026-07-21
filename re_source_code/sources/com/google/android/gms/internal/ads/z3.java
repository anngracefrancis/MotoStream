package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: classes2.dex */
final class z3 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ Bitmap f13672f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzauq f13673g;

    z3(zzauq zzauqVar, Bitmap bitmap) {
        this.f13673g = zzauqVar;
        this.f13672f = bitmap;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.f13672f.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
        synchronized (this.f13673g.l) {
            this.f13673g.f14167c.f16118k = new zzdso();
            this.f13673g.f14167c.f16118k.f16130e = byteArrayOutputStream.toByteArray();
            this.f13673g.f14167c.f16118k.f16129d = "image/png";
            this.f13673g.f14167c.f16118k.f16128c = 1;
        }
    }
}
