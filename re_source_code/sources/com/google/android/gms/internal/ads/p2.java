package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
final class p2 implements zzahw {
    private final zzbbr a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzamd f13142b;

    public p2(zzamd zzamdVar, zzbbr zzbbrVar) {
        this.f13142b = zzamdVar;
        this.a = zzbbrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzahw
    public final void a(JSONObject jSONObject) {
        try {
            this.a.a(this.f13142b.a.a(jSONObject));
        } catch (IllegalStateException unused) {
        } catch (JSONException e2) {
            this.a.a(e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzahw
    public final void onFailure(String str) {
        try {
            if (str == null) {
                this.a.c(new zzali());
            } else {
                this.a.c(new zzali(str));
            }
        } catch (IllegalStateException unused) {
        }
    }
}
