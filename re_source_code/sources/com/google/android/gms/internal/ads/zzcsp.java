package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcsp implements zzcva<Cdo> {
    private final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzbbl f15609b;

    zzcsp(Context context, zzbbl zzbblVar) {
        this.a = context;
        this.f15609b = zzbblVar;
    }

    final /* synthetic */ Cdo a() throws Exception {
        zzk.zzlg();
        String strF = zzaxi.F(this.a);
        zzk.zzlg();
        return new Cdo(strF, zzaxi.G(this.a));
    }

    @Override // com.google.android.gms.internal.ads.zzcva
    public final zzbbh<Cdo> b() {
        return this.f15609b.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.bo

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final zzcsp f12356f;

            {
                this.f12356f = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f12356f.a();
            }
        });
    }
}
