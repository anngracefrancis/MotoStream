package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.File;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzayl extends zzak {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Context f14278e;

    private zzayl(Context context, zzas zzasVar) {
        super(zzasVar);
        this.f14278e = context;
    }

    public static zzv d(Context context) {
        zzv zzvVar = new zzv(new zzan(new File(context.getCacheDir(), "admob_volley"), 20971520), new zzayl(context, new zzat()));
        zzvVar.a();
        return zzvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzak, com.google.android.gms.internal.ads.zzm
    public final zzp a(zzr<?> zzrVar) throws zzaf {
        if (zzrVar.P() && zzrVar.k() == 0) {
            if (Pattern.matches((String) zzyt.e().c(zzacu.D3), zzrVar.q())) {
                zzyt.a();
                if (zzazt.s(this.f14278e, 13400000)) {
                    zzp zzpVarA = new zzaii(this.f14278e).a(zzrVar);
                    if (zzpVarA != null) {
                        String strValueOf = String.valueOf(zzrVar.q());
                        zzawz.m(strValueOf.length() != 0 ? "Got gmscore asset response: ".concat(strValueOf) : new String("Got gmscore asset response: "));
                        return zzpVarA;
                    }
                    String strValueOf2 = String.valueOf(zzrVar.q());
                    zzawz.m(strValueOf2.length() != 0 ? "Failed to get gmscore asset response: ".concat(strValueOf2) : new String("Failed to get gmscore asset response: "));
                }
            }
        }
        return super.a(zzrVar);
    }
}
