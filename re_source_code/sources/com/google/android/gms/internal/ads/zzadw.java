package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzadw extends zzaej {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Drawable f13840f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Uri f13841g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final double f13842h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f13843i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f13844j;

    public zzadw(Drawable drawable, Uri uri, double d2, int i2, int i3) {
        this.f13840f = drawable;
        this.f13841g = uri;
        this.f13842h = d2;
        this.f13843i = i2;
        this.f13844j = i3;
    }

    @Override // com.google.android.gms.internal.ads.zzaei
    public final Uri I0() throws RemoteException {
        return this.f13841g;
    }

    @Override // com.google.android.gms.internal.ads.zzaei
    public final double T3() {
        return this.f13842h;
    }

    @Override // com.google.android.gms.internal.ads.zzaei
    public final int getHeight() {
        return this.f13844j;
    }

    @Override // com.google.android.gms.internal.ads.zzaei
    public final int getWidth() {
        return this.f13843i;
    }

    @Override // com.google.android.gms.internal.ads.zzaei
    public final IObjectWrapper t4() throws RemoteException {
        return ObjectWrapper.E0(this.f13840f);
    }
}
