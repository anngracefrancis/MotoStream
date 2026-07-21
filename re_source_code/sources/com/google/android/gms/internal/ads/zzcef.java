package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcef implements zzdti<zzwj> {
    private final zzdtu<Context> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<String> f15137b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<zzbai> f15138c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzdtu<Integer> f15139d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzdtu<String> f15140e;

    private zzcef(zzdtu<Context> zzdtuVar, zzdtu<String> zzdtuVar2, zzdtu<zzbai> zzdtuVar3, zzdtu<Integer> zzdtuVar4, zzdtu<String> zzdtuVar5) {
        this.a = zzdtuVar;
        this.f15137b = zzdtuVar2;
        this.f15138c = zzdtuVar3;
        this.f15139d = zzdtuVar4;
        this.f15140e = zzdtuVar5;
    }

    public static zzcef a(zzdtu<Context> zzdtuVar, zzdtu<String> zzdtuVar2, zzdtu<zzbai> zzdtuVar3, zzdtu<Integer> zzdtuVar4, zzdtu<String> zzdtuVar5) {
        return new zzcef(zzdtuVar, zzdtuVar2, zzdtuVar3, zzdtuVar4, zzdtuVar5);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        Context context = this.a.get();
        final String str = this.f15137b.get();
        zzbai zzbaiVar = this.f15138c.get();
        final int iIntValue = this.f15139d.get().intValue();
        final String str2 = this.f15140e.get();
        zzwj zzwjVar = new zzwj(new zzwo(context));
        final zzxo zzxoVar = new zzxo();
        zzxoVar.f16951c = Integer.valueOf(zzbaiVar.f14327g);
        zzxoVar.f16952d = Integer.valueOf(zzbaiVar.f14328h);
        zzxoVar.f16953e = Integer.valueOf(zzbaiVar.f14329i ? 0 : 2);
        zzwjVar.a(new zzwk(iIntValue, str, zzxoVar, str2) { // from class: com.google.android.gms.internal.ads.fi
            private final int a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final String f12590b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final zzxo f12591c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private final String f12592d;

            {
                this.a = iIntValue;
                this.f12590b = str;
                this.f12591c = zzxoVar;
                this.f12592d = str2;
            }

            @Override // com.google.android.gms.internal.ads.zzwk
            public final void a(zzxn zzxnVar) {
                int i2 = this.a;
                String str3 = this.f12590b;
                zzxo zzxoVar2 = this.f12591c;
                String str4 = this.f12592d;
                zzxnVar.l.f16920c = Integer.valueOf(i2);
                zzxl zzxlVar = zzxnVar.f16948i;
                zzxlVar.f16934c = str3;
                zzxlVar.f16937f = zzxoVar2;
                zzxnVar.f16943d = str4;
            }
        });
        return (zzwj) zzdto.b(zzwjVar, "Cannot return null from a non-@Nullable @Provides method");
    }
}
