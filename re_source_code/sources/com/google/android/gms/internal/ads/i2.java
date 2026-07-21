package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
final class i2 implements zzahw {
    private final zzakw a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzbbr f12740b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzalu f12741c;

    public i2(zzalu zzaluVar, zzakw zzakwVar, zzbbr zzbbrVar) {
        this.f12741c = zzaluVar;
        this.a = zzakwVar;
        this.f12740b = zzbbrVar;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017 A[ExcHandler: JSONException -> 0x0017] */
    @Override // com.google.android.gms.internal.ads.zzahw
    public final void a(JSONObject jSONObject) {
        try {
            this.f12740b.a(this.f12741c.a.a(jSONObject));
        } catch (JSONException e2) {
            this.f12740b.a(e2);
        } catch (IllegalStateException unused) {
        } finally {
            this.a.f();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzahw
    public final void onFailure(String str) {
        try {
            if (str == null) {
                this.f12740b.c(new zzali());
            } else {
                this.f12740b.c(new zzali(str));
            }
            this.a.f();
        } catch (IllegalStateException unused) {
        } finally {
            this.a.f();
        }
    }
}
