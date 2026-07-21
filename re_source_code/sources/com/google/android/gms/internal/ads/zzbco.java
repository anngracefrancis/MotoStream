package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.TextureView;

/* JADX INFO: loaded from: classes.dex */
@zzard
@TargetApi(14)
public abstract class zzbco extends TextureView implements g8 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected final zzbcy f14345f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected final zzbdi f14346g;

    public zzbco(Context context) {
        super(context);
        this.f14345f = new zzbcy();
        this.f14346g = new zzbdi(context, this);
    }

    public abstract void b();

    public abstract void c();

    public abstract void d();

    public abstract int getCurrentPosition();

    public abstract int getDuration();

    public abstract int getVideoHeight();

    public abstract int getVideoWidth();

    public abstract void h(int i2);

    public abstract void i();

    public abstract void j(float f2, float f3);

    public abstract void k(zzbcn zzbcnVar);

    public void l(String str, String[] strArr) {
        setVideoPath(str);
    }

    public void m(int i2) {
    }

    public void n(int i2) {
    }

    public void o(int i2) {
    }

    public void p(int i2) {
    }

    public void q(int i2) {
    }

    public abstract String r();

    public abstract void setVideoPath(String str);
}
