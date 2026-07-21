package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import cm.aptoide.pt.DeepLinkIntentReceiver;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbzt {
    private final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzcdn f14942b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzccj f14943c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzbmy f14944d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzbzb f14945e;

    public zzbzt(Context context, zzcdn zzcdnVar, zzccj zzccjVar, zzbmy zzbmyVar, zzbzb zzbzbVar) {
        this.a = context;
        this.f14942b = zzcdnVar;
        this.f14943c = zzccjVar;
        this.f14944d = zzbmyVar;
        this.f14945e = zzbzbVar;
    }

    final /* synthetic */ void a(zzbgz zzbgzVar, Map map) {
        zzbgzVar.getView().setVisibility(8);
        this.f14944d.r(false);
    }

    final /* synthetic */ void b(Map map, boolean z) {
        HashMap map2 = new HashMap();
        map2.put("messageType", "htmlLoaded");
        map2.put(DeepLinkIntentReceiver.DeepLinksKeys.ID, (String) map.get(DeepLinkIntentReceiver.DeepLinksKeys.ID));
        this.f14943c.e("sendMessageToNativeJs", map2);
    }

    public final View c() throws zzbhj {
        zzbgz zzbgzVarB = this.f14942b.b(zzyd.Y(this.a));
        zzbgzVarB.getView().setVisibility(8);
        zzbgzVarB.f("/sendMessageToSdk", new zzaho(this) { // from class: com.google.android.gms.internal.ads.dg
            private final zzbzt a;

            {
                this.a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzaho
            public final void a(Object obj, Map map) {
                this.a.f((zzbgz) obj, map);
            }
        });
        zzbgzVarB.f("/adMuted", new zzaho(this) { // from class: com.google.android.gms.internal.ads.eg
            private final zzbzt a;

            {
                this.a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzaho
            public final void a(Object obj, Map map) {
                this.a.e((zzbgz) obj, map);
            }
        });
        this.f14943c.f(new WeakReference(zzbgzVarB), "/loadHtml", new zzaho(this) { // from class: com.google.android.gms.internal.ads.fg
            private final zzbzt a;

            {
                this.a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzaho
            public final void a(Object obj, final Map map) {
                final zzbzt zzbztVar = this.a;
                zzbgz zzbgzVar = (zzbgz) obj;
                zzbgzVar.p().i(new zzbij(zzbztVar, map) { // from class: com.google.android.gms.internal.ads.ig
                    private final zzbzt a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    private final Map f12767b;

                    {
                        this.a = zzbztVar;
                        this.f12767b = map;
                    }

                    @Override // com.google.android.gms.internal.ads.zzbij
                    public final void zzae(boolean z) {
                        this.a.b(this.f12767b, z);
                    }
                });
                String str = (String) map.get("overlayHtml");
                String str2 = (String) map.get("baseUrl");
                if (TextUtils.isEmpty(str2)) {
                    zzbgzVar.loadData(str, "text/html", "UTF-8");
                } else {
                    zzbgzVar.loadDataWithBaseURL(str2, str, "text/html", "UTF-8", null);
                }
            }
        });
        this.f14943c.f(new WeakReference(zzbgzVarB), "/showOverlay", new zzaho(this) { // from class: com.google.android.gms.internal.ads.gg
            private final zzbzt a;

            {
                this.a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzaho
            public final void a(Object obj, Map map) {
                this.a.d((zzbgz) obj, map);
            }
        });
        this.f14943c.f(new WeakReference(zzbgzVarB), "/hideOverlay", new zzaho(this) { // from class: com.google.android.gms.internal.ads.hg
            private final zzbzt a;

            {
                this.a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzaho
            public final void a(Object obj, Map map) {
                this.a.a((zzbgz) obj, map);
            }
        });
        return zzbgzVarB.getView();
    }

    final /* synthetic */ void d(zzbgz zzbgzVar, Map map) {
        zzbgzVar.getView().setVisibility(0);
        this.f14944d.r(true);
    }

    final /* synthetic */ void e(zzbgz zzbgzVar, Map map) {
        this.f14945e.n();
    }

    final /* synthetic */ void f(zzbgz zzbgzVar, Map map) {
        this.f14943c.e("sendMessageToNativeJs", map);
    }
}
