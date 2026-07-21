package com.google.android.gms.internal.ads;

import cm.aptoide.pt.DeepLinkIntentReceiver;
import com.google.android.gms.ads.internal.zzk;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzamd<I, O> implements zzbal<I, O> {
    private final zzall<O> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzalm<I> f13963b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f13964c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzbbh<zzalf> f13965d;

    zzamd(zzbbh<zzalf> zzbbhVar, String str, zzalm<I> zzalmVar, zzall<O> zzallVar) {
        this.f13965d = zzbbhVar;
        this.f13964c = str;
        this.f13963b = zzalmVar;
        this.a = zzallVar;
    }

    final /* synthetic */ zzbbh c(Object obj, zzalf zzalfVar) throws Exception {
        zzbbr zzbbrVar = new zzbbr();
        zzk.zzlg();
        String strJ0 = zzaxi.j0();
        zzagz.o.c(strJ0, new p2(this, zzbbrVar));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(DeepLinkIntentReceiver.DeepLinksKeys.ID, strJ0);
        jSONObject.put("args", this.f13963b.b(obj));
        zzalfVar.Y(this.f13964c, jSONObject);
        return zzbbrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbal
    public final zzbbh<O> zzf(final I i2) throws Exception {
        return zzbar.c(this.f13965d, new zzbal(this, i2) { // from class: com.google.android.gms.internal.ads.o2
            private final zzamd a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final Object f13081b;

            {
                this.a = this;
                this.f13081b = i2;
            }

            @Override // com.google.android.gms.internal.ads.zzbal
            public final zzbbh zzf(Object obj) {
                return this.a.c(this.f13081b, (zzalf) obj);
            }
        }, zzbbm.f14331b);
    }
}
