package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcrp implements zzcva<zzcro> {
    private final zzcva<zzcvf> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzcxv f15576b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f15577c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzawm f15578d;

    public zzcrp(zzcsk<zzcvf> zzcskVar, zzcxv zzcxvVar, Context context, zzawm zzawmVar) {
        this.a = zzcskVar;
        this.f15576b = zzcxvVar;
        this.f15577c = context;
        this.f15578d = zzawmVar;
    }

    final /* synthetic */ zzcro a(zzcvf zzcvfVar) {
        String str;
        boolean z;
        String strT;
        float f2;
        int i2;
        int i3;
        int i4;
        DisplayMetrics displayMetrics;
        zzyd zzydVar = this.f15576b.f15751e;
        zzyd[] zzydVarArr = zzydVar.l;
        if (zzydVarArr != null) {
            str = null;
            boolean z2 = false;
            boolean z3 = false;
            z = false;
            for (zzyd zzydVar2 : zzydVarArr) {
                boolean z4 = zzydVar2.n;
                if (!z4 && !z2) {
                    str = zzydVar2.f16987f;
                    z2 = true;
                }
                if (z4 && !z3) {
                    z3 = true;
                    z = true;
                }
                if (z2 && z3) {
                    break;
                }
            }
        } else {
            str = zzydVar.f16987f;
            z = zzydVar.n;
        }
        Resources resources = this.f15577c.getResources();
        if (resources == null || (displayMetrics = resources.getDisplayMetrics()) == null) {
            strT = null;
            f2 = 0.0f;
            i2 = 0;
            i3 = 0;
        } else {
            float f3 = displayMetrics.density;
            int i5 = displayMetrics.widthPixels;
            i3 = displayMetrics.heightPixels;
            strT = this.f15578d.r().t();
            i2 = i5;
            f2 = f3;
        }
        StringBuilder sb = new StringBuilder();
        zzyd[] zzydVarArr2 = zzydVar.l;
        if (zzydVarArr2 != null) {
            boolean z5 = false;
            for (zzyd zzydVar3 : zzydVarArr2) {
                if (zzydVar3.n) {
                    z5 = true;
                } else {
                    if (sb.length() != 0) {
                        sb.append("|");
                    }
                    int i6 = zzydVar3.f16991j;
                    if (i6 == -1 && f2 != 0.0f) {
                        i6 = (int) (zzydVar3.f16992k / f2);
                    }
                    sb.append(i6);
                    sb.append("x");
                    int i7 = zzydVar3.f16988g;
                    if (i7 == -2 && f2 != 0.0f) {
                        i7 = (int) (zzydVar3.f16989h / f2);
                    }
                    sb.append(i7);
                }
            }
            if (z5) {
                if (sb.length() != 0) {
                    i4 = 0;
                    sb.insert(0, "|");
                } else {
                    i4 = 0;
                }
                sb.insert(i4, "320x50");
            }
        }
        return new zzcro(zzydVar, str, z, sb.toString(), f2, i2, i3, strT);
    }

    @Override // com.google.android.gms.internal.ads.zzcva
    public final zzbbh<zzcro> b() {
        return zzbar.d(this.a.b(), new zzbam(this) { // from class: com.google.android.gms.internal.ads.rn
            private final zzcrp a;

            {
                this.a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzbam
            public final Object a(Object obj) {
                return this.a.a((zzcvf) obj);
            }
        }, zzbbm.f14331b);
    }
}
