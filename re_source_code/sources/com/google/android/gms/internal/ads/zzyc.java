package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzyc {
    public static final zzyc a = new zzyc();

    @VisibleForTesting
    protected zzyc() {
    }

    public static zzxz a(Context context, zzaaz zzaazVar) {
        String strC;
        Date dateA = zzaazVar.a();
        long time = dateA != null ? dateA.getTime() : -1L;
        String strB = zzaazVar.b();
        int iE = zzaazVar.e();
        Set<String> setF = zzaazVar.f();
        List listUnmodifiableList = !setF.isEmpty() ? Collections.unmodifiableList(new ArrayList(setF)) : null;
        boolean zN = zzaazVar.n(context);
        int iS = zzaazVar.s();
        Location locationG = zzaazVar.g();
        Bundle bundleK = zzaazVar.k(AdMobAdapter.class);
        boolean zH = zzaazVar.h();
        String strL = zzaazVar.l();
        SearchAdRequest searchAdRequestP = zzaazVar.p();
        zzaca zzacaVar = searchAdRequestP != null ? new zzaca(searchAdRequestP) : null;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            String packageName = applicationContext.getPackageName();
            zzyt.a();
            strC = zzazt.c(Thread.currentThread().getStackTrace(), packageName);
        } else {
            strC = null;
        }
        return new zzxz(8, time, bundleK, iE, listUnmodifiableList, zN, iS, zH, strL, zzacaVar, locationG, strB, zzaazVar.r(), zzaazVar.d(), Collections.unmodifiableList(new ArrayList(zzaazVar.t())), zzaazVar.o(), strC, zzaazVar.m(), null, zzaazVar.u(), zzaazVar.i());
    }
}
