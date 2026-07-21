package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbqw implements zzdti<zzbam<zzcxm, zzayb>> {
    private final zzdtu<Context> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzbai> f14703b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<zzcxv> f14704c;

    public zzbqw(zzdtu<Context> zzdtuVar, zzdtu<zzbai> zzdtuVar2, zzdtu<zzcxv> zzdtuVar3) {
        this.a = zzdtuVar;
        this.f14703b = zzdtuVar2;
        this.f14704c = zzdtuVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        final Context context = this.a.get();
        final zzbai zzbaiVar = this.f14703b.get();
        final zzcxv zzcxvVar = this.f14704c.get();
        return (zzbam) zzdto.b(new zzbam(context, zzbaiVar, zzcxvVar) { // from class: com.google.android.gms.internal.ads.nd
            private final Context a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final zzbai f13048b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final zzcxv f13049c;

            {
                this.a = context;
                this.f13048b = zzbaiVar;
                this.f13049c = zzcxvVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbam
            public final Object a(Object obj) {
                Context context2 = this.a;
                zzbai zzbaiVar2 = this.f13048b;
                zzcxv zzcxvVar2 = this.f13049c;
                zzcxm zzcxmVar = (zzcxm) obj;
                zzayb zzaybVar = new zzayb(context2);
                zzaybVar.h(zzcxmVar.y);
                zzaybVar.i(zzcxmVar.z.toString());
                zzaybVar.j(zzbaiVar2.f14326f);
                zzaybVar.a(zzcxvVar2.f15752f);
                return zzaybVar;
            }
        }, "Cannot return null from a non-@Nullable @Provides method");
    }
}
