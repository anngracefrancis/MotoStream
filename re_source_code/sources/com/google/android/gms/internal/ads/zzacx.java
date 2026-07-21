package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import com.google.android.gms.ads.internal.zzk;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzacx {
    private String a = (String) zzyt.e().c(zzacu.f0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<String, String> f13808b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f13809c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f13810d;

    public zzacx(Context context, String str) {
        this.f13809c = null;
        this.f13810d = null;
        this.f13809c = context;
        this.f13810d = str;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.f13808b = linkedHashMap;
        linkedHashMap.put("s", "gmob_sdk");
        this.f13808b.put("v", "3");
        this.f13808b.put("os", Build.VERSION.RELEASE);
        this.f13808b.put("sdk", Build.VERSION.SDK);
        Map<String, String> map = this.f13808b;
        zzk.zzlg();
        map.put("device", zzaxi.k0());
        this.f13808b.put("app", context.getApplicationContext() != null ? context.getApplicationContext().getPackageName() : context.getPackageName());
        Map<String, String> map2 = this.f13808b;
        zzk.zzlg();
        map2.put("is_lite_sdk", zzaxi.E(context) ? "1" : "0");
        Future<zzase> futureB = zzk.zzlr().b(this.f13809c);
        try {
            this.f13808b.put("network_coarse", Integer.toString(futureB.get().o));
            this.f13808b.put("network_fine", Integer.toString(futureB.get().p));
        } catch (Exception e2) {
            zzk.zzlk().e(e2, "CsiConfiguration.CsiConfiguration");
        }
    }

    final Context a() {
        return this.f13809c;
    }

    final String b() {
        return this.f13810d;
    }

    final String c() {
        return this.a;
    }

    final Map<String, String> d() {
        return this.f13808b;
    }
}
