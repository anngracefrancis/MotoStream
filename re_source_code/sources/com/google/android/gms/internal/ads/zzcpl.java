package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcpl extends zzaoz {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzcpk f15498f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private zzbbr<JSONObject> f15499g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final JSONObject f15500h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f15501i;

    public zzcpl(zzcpk zzcpkVar, zzbbr<JSONObject> zzbbrVar) {
        JSONObject jSONObject = new JSONObject();
        this.f15500h = jSONObject;
        this.f15501i = false;
        this.f15499g = zzbbrVar;
        this.f15498f = zzcpkVar;
        try {
            jSONObject.put("adapter_version", zzcpkVar.f15497d.a6().toString());
            jSONObject.put("sdk_version", zzcpkVar.f15497d.i5().toString());
            jSONObject.put("name", zzcpkVar.a);
        } catch (RemoteException | NullPointerException | JSONException unused) {
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaoy
    public final synchronized void R2(String str) throws RemoteException {
        if (this.f15501i) {
            return;
        }
        if (str == null) {
            onFailure("Adapter returned null signals");
            return;
        }
        try {
            this.f15500h.put("signals", str);
        } catch (JSONException unused) {
        }
        this.f15499g.a(this.f15500h);
        this.f15501i = true;
    }

    @Override // com.google.android.gms.internal.ads.zzaoy
    public final synchronized void onFailure(String str) throws RemoteException {
        if (this.f15501i) {
            return;
        }
        try {
            this.f15500h.put("signal_error", str);
        } catch (JSONException unused) {
        }
        this.f15499g.a(this.f15500h);
        this.f15501i = true;
    }
}
