package com.google.android.gms.ads.internal;

import android.content.Context;
import android.text.TextUtils;
import cm.aptoide.pt.reviews.RateAndReviewsFragment;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzacu;
import com.google.android.gms.internal.ads.zzalj;
import com.google.android.gms.internal.ads.zzaln;
import com.google.android.gms.internal.ads.zzalo;
import com.google.android.gms.internal.ads.zzalr;
import com.google.android.gms.internal.ads.zzard;
import com.google.android.gms.internal.ads.zzawl;
import com.google.android.gms.internal.ads.zzbad;
import com.google.android.gms.internal.ads.zzbai;
import com.google.android.gms.internal.ads.zzbal;
import com.google.android.gms.internal.ads.zzbao;
import com.google.android.gms.internal.ads.zzbar;
import com.google.android.gms.internal.ads.zzbbh;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzyt;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzd {
    private long zzbqy = 0;
    private Context zzlj;

    public final void zza(Context context, zzbai zzbaiVar, String str, Runnable runnable) {
        zza(context, zzbaiVar, true, null, str, null, runnable);
    }

    public final void zza(Context context, zzbai zzbaiVar, String str, zzawl zzawlVar) {
        zza(context, zzbaiVar, false, zzawlVar, zzawlVar != null ? zzawlVar.d() : null, str, null);
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0025  */
    @VisibleForTesting
    private final void zza(Context context, zzbai zzbaiVar, boolean z, zzawl zzawlVar, String str, String str2, Runnable runnable) {
        boolean z2;
        if (zzk.zzln().b() - this.zzbqy < 5000) {
            zzbad.i("Not retrying to fetch app settings");
            return;
        }
        this.zzbqy = zzk.zzln().b();
        if (zzawlVar != null) {
            z2 = (((zzk.zzln().a() - zzawlVar.a()) > ((Long) zzyt.e().c(zzacu.f3)).longValue() ? 1 : ((zzk.zzln().a() - zzawlVar.a()) == ((Long) zzyt.e().c(zzacu.f3)).longValue() ? 0 : -1)) > 0) || !zzawlVar.b();
        }
        if (z2) {
            if (context == null) {
                zzbad.i("Context not provided to fetch application settings");
                return;
            }
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                zzbad.i("App settings could not be fetched. Required parameters missing");
                return;
            }
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                applicationContext = context;
            }
            this.zzlj = applicationContext;
            zzalr zzalrVarB = zzk.zzlt().b(this.zzlj, zzbaiVar);
            zzaln<JSONObject> zzalnVar = zzalo.f13955b;
            zzalj zzaljVarA = zzalrVarB.a("google.afma.config.fetchAppSettings", zzalnVar, zzalnVar);
            try {
                JSONObject jSONObject = new JSONObject();
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put(RateAndReviewsFragment.BundleCons.APP_ID, str);
                } else if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("ad_unit_id", str2);
                }
                jSONObject.put("is_init", z);
                jSONObject.put("pn", context.getPackageName());
                zzbbh zzbbhVarA = zzaljVarA.a(jSONObject);
                zzbal zzbalVar = zze.zzbqz;
                Executor executor = zzbbm.f14331b;
                zzbbh zzbbhVarC = zzbar.c(zzbbhVarA, zzbalVar, executor);
                if (runnable != null) {
                    zzbbhVarA.k(runnable, executor);
                }
                zzbao.a(zzbbhVarC, "ConfigLoader.maybeFetchNewAppSettings");
            } catch (Exception e2) {
                zzbad.c("Error requesting application settings", e2);
            }
        }
    }
}
