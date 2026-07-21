package com.google.android.gms.internal.ads;

import cm.aptoide.pt.DeepLinkIntentReceiver;
import com.google.android.gms.ads.internal.zzk;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzalu<I, O> implements zzalj<I, O> {
    private final zzall<O> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzalm<I> f13959b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzakh f13960c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f13961d;

    zzalu(zzakh zzakhVar, String str, zzalm<I> zzalmVar, zzall<O> zzallVar) {
        this.f13960c = zzakhVar;
        this.f13961d = str;
        this.f13959b = zzalmVar;
        this.a = zzallVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(zzakw zzakwVar, zzalf zzalfVar, I i2, zzbbr<O> zzbbrVar) {
        try {
            zzk.zzlg();
            String strJ0 = zzaxi.j0();
            zzagz.o.c(strJ0, new i2(this, zzakwVar, zzbbrVar));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(DeepLinkIntentReceiver.DeepLinksKeys.ID, strJ0);
            jSONObject.put("args", this.f13959b.b(i2));
            zzalfVar.Y(this.f13961d, jSONObject);
        } catch (Exception e2) {
            try {
                zzbbrVar.c(e2);
                zzbad.c("Unable to invokeJavascript", e2);
            } finally {
                zzakwVar.f();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final zzbbh<O> a(I i2) {
        zzbbr zzbbrVar = new zzbbr();
        zzakw zzakwVarH = this.f13960c.h(null);
        zzakwVarH.d(new g2(this, zzakwVarH, i2, zzbbrVar), new h2(this, zzbbrVar, zzakwVarH));
        return zzbbrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbal
    public final zzbbh<O> zzf(I i2) throws Exception {
        return a(i2);
    }
}
