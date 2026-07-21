package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcvy implements zzcva<zzcvx> {
    private final zzasc a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f15694b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f15695c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzbbl f15696d;

    public zzcvy(zzasc zzascVar, Context context, String str, zzbbl zzbblVar) {
        this.a = zzascVar;
        this.f15694b = context;
        this.f15695c = str;
        this.f15696d = zzbblVar;
    }

    final /* synthetic */ zzcvx a() throws Exception {
        JSONObject jSONObject = new JSONObject();
        zzasc zzascVar = this.a;
        if (zzascVar != null) {
            zzascVar.a(this.f15694b, this.f15695c, jSONObject);
        }
        return new zzcvx(jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzcva
    public final zzbbh<zzcvx> b() {
        return this.f15696d.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.jp

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final zzcvy f12837f;

            {
                this.f12837f = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f12837f.a();
            }
        });
    }
}
