package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.zzk;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcsv implements zzcva<zzcsu> {
    private final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzbbl f15611b;

    public zzcsv(Context context, zzbbl zzbblVar) {
        this.a = context;
        this.f15611b = zzbblVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcva
    public final zzbbh<zzcsu> b() {
        return this.f15611b.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.eo

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final zzcsv f12540f;

            {
                this.f12540f = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                String strG;
                String strA;
                String strJ;
                zzk.zzlg();
                zzuu zzuuVarO = zzk.zzlk().r().o();
                Bundle bundle = null;
                if (zzuuVarO != null && (!zzk.zzlk().r().k() || !zzk.zzlk().r().b())) {
                    if (zzuuVarO.i()) {
                        zzuuVarO.a();
                    }
                    zzuo zzuoVarG = zzuuVarO.g();
                    if (zzuoVarG != null) {
                        strG = zzuoVarG.i();
                        strJ = zzuoVarG.j();
                        strA = zzuoVarG.k();
                        if (strG != null) {
                            zzk.zzlk().r().l(strG);
                        }
                        if (strA != null) {
                            zzk.zzlk().r().p(strA);
                        }
                    } else {
                        strG = zzk.zzlk().r().g();
                        strA = zzk.zzlk().r().A();
                        strJ = null;
                    }
                    Bundle bundle2 = new Bundle(1);
                    if (strA != null && !zzk.zzlk().r().b()) {
                        bundle2.putString("v_fp_vertical", strA);
                    }
                    if (strG != null && !zzk.zzlk().r().k()) {
                        bundle2.putString("fingerprint", strG);
                        if (!strG.equals(strJ)) {
                            bundle2.putString("v_fp", strJ);
                        }
                    }
                    if (!bundle2.isEmpty()) {
                        bundle = bundle2;
                    }
                }
                return new zzcsu(bundle);
            }
        });
    }
}
