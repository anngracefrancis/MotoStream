package com.bumptech.glide.p.l;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;

/* JADX INFO: compiled from: NotificationTarget.java */
/* JADX INFO: loaded from: classes.dex */
public class f extends g<Bitmap> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final RemoteViews f9515f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Context f9516g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f9517h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f9518i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Notification f9519j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f9520k;

    private void d() {
        ((NotificationManager) com.bumptech.glide.r.j.d((NotificationManager) this.f9516g.getSystemService("notification"))).notify(this.f9518i, this.f9517h, this.f9519j);
    }

    @Override // com.bumptech.glide.p.l.i
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onResourceReady(Bitmap bitmap, com.bumptech.glide.p.m.d<? super Bitmap> dVar) {
        this.f9515f.setImageViewBitmap(this.f9520k, bitmap);
        d();
    }
}
