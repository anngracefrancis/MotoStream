package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcus implements zzcva<zzcur> {
    private final zzavg a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzbbl f15650b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f15651c;

    public zzcus(zzavg zzavgVar, zzbbl zzbblVar, Context context) {
        this.a = zzavgVar;
        this.f15650b = zzbblVar;
        this.f15651c = context;
    }

    final /* synthetic */ zzcur a() throws Exception {
        Long l;
        if (!this.a.D(this.f15651c)) {
            return new zzcur(null, null, null, null, null);
        }
        String strL = this.a.l(this.f15651c);
        String str = strL == null ? HttpUrl.FRAGMENT_ENCODE_SET : strL;
        String strM = this.a.m(this.f15651c);
        String str2 = strM == null ? HttpUrl.FRAGMENT_ENCODE_SET : strM;
        String strN = this.a.n(this.f15651c);
        String str3 = strN == null ? HttpUrl.FRAGMENT_ENCODE_SET : strN;
        String strO = this.a.o(this.f15651c);
        String str4 = strO == null ? HttpUrl.FRAGMENT_ENCODE_SET : strO;
        if ("TIME_OUT".equals(str2)) {
            l = (Long) zzyt.e().c(zzacu.E0);
        } else {
            l = null;
        }
        return new zzcur(str, str2, str3, str4, l);
    }

    @Override // com.google.android.gms.internal.ads.zzcva
    public final zzbbh<zzcur> b() {
        return this.f15650b.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.xo

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final zzcus f13584f;

            {
                this.f13584f = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f13584f.a();
            }
        });
    }
}
