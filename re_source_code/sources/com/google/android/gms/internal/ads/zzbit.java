package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzj;
import com.google.android.gms.ads.internal.zzk;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzbit {
    public static zzbgz a(final Context context, final zzbin zzbinVar, final String str, final boolean z, final boolean z2, final zzdh zzdhVar, final zzbai zzbaiVar, zzadi zzadiVar, final zzj zzjVar, final com.google.android.gms.ads.internal.zza zzaVar, final zzwj zzwjVar) throws zzbhj {
        try {
            final zzadi zzadiVar2 = null;
            return (zzbgz) zzazl.b(new Callable(context, zzbinVar, str, z, z2, zzdhVar, zzbaiVar, zzadiVar2, zzjVar, zzaVar, zzwjVar) { // from class: com.google.android.gms.internal.ads.nb

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                private final Context f13032f;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                private final zzbin f13033g;

                /* JADX INFO: renamed from: h, reason: collision with root package name */
                private final String f13034h;

                /* JADX INFO: renamed from: i, reason: collision with root package name */
                private final boolean f13035i;

                /* JADX INFO: renamed from: j, reason: collision with root package name */
                private final boolean f13036j;

                /* JADX INFO: renamed from: k, reason: collision with root package name */
                private final zzdh f13037k;
                private final zzbai l;
                private final zzadi m;
                private final zzj n;
                private final com.google.android.gms.ads.internal.zza o;
                private final zzwj p;

                {
                    this.f13032f = context;
                    this.f13033g = zzbinVar;
                    this.f13034h = str;
                    this.f13035i = z;
                    this.f13036j = z2;
                    this.f13037k = zzdhVar;
                    this.l = zzbaiVar;
                    this.m = zzadiVar2;
                    this.n = zzjVar;
                    this.o = zzaVar;
                    this.p = zzwjVar;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Context context2 = this.f13032f;
                    zzbin zzbinVar2 = this.f13033g;
                    String str2 = this.f13034h;
                    boolean z3 = this.f13035i;
                    boolean z4 = this.f13036j;
                    zzdh zzdhVar2 = this.f13037k;
                    zzbai zzbaiVar2 = this.l;
                    zzadi zzadiVar3 = this.m;
                    zzj zzjVar2 = this.n;
                    com.google.android.gms.ads.internal.zza zzaVar2 = this.o;
                    zzwj zzwjVar2 = this.p;
                    zzbio zzbioVar = new zzbio();
                    ob obVar = new ob(new zzbim(context2), zzbioVar, zzbinVar2, str2, z3, z4, zzdhVar2, zzbaiVar2, zzadiVar3, zzjVar2, zzaVar2, zzwjVar2);
                    zzbhk zzbhkVar = new zzbhk(obVar);
                    obVar.setWebChromeClient(new zzbgr(zzbhkVar));
                    zzbioVar.y(zzbhkVar, z4);
                    return zzbhkVar;
                }
            });
        } catch (Throwable th) {
            zzk.zzlk().e(th, "AdWebViewFactory.newAdWebView2");
            throw new zzbhj("Webview initialization failed.", th);
        }
    }
}
