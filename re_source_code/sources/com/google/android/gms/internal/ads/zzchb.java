package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public final class zzchb implements zzdti<zzbbh<String>> {
    private final zzdtu<zzdh> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<Context> f15234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<zzbbl> f15235c;

    private zzchb(zzdtu<zzdh> zzdtuVar, zzdtu<Context> zzdtuVar2, zzdtu<zzbbl> zzdtuVar3) {
        this.a = zzdtuVar;
        this.f15234b = zzdtuVar2;
        this.f15235c = zzdtuVar3;
    }

    public static zzchb a(zzdtu<zzdh> zzdtuVar, zzdtu<Context> zzdtuVar2, zzdtu<zzbbl> zzdtuVar3) {
        return new zzchb(zzdtuVar, zzdtuVar2, zzdtuVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        final zzdh zzdhVar = this.a.get();
        final Context context = this.f15234b.get();
        return (zzbbh) zzdto.b(this.f15235c.get().submit(new Callable(zzdhVar, context) { // from class: com.google.android.gms.internal.ads.yi

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final zzdh f13644f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private final Context f13645g;

            {
                this.f13644f = zzdhVar;
                this.f13645g = context;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzdh zzdhVar2 = this.f13644f;
                return zzdhVar2.f().zza(this.f13645g);
            }
        }), "Cannot return null from a non-@Nullable @Provides method");
    }
}
