package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;
import java.util.Set;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public final class zzctw implements zzcva<zzctv> {
    private final zzbbl a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f15624b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set<String> f15625c;

    public zzctw(zzbbl zzbblVar, Context context, Set<String> set) {
        this.a = zzbblVar;
        this.f15624b = context;
        this.f15625c = set;
    }

    final /* synthetic */ zzctv a() throws Exception {
        return (((Boolean) zzyt.e().c(zzacu.b4)).booleanValue() && zzctv.b(this.f15625c)) ? new zzctv(zzk.zzlv().a(this.f15624b)) : new zzctv(null);
    }

    @Override // com.google.android.gms.internal.ads.zzcva
    public final zzbbh<zzctv> b() {
        return this.a.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.oo

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final zzctw f13112f;

            {
                this.f13112f = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f13112f.a();
            }
        });
    }
}
