package com.google.android.gms.internal.ads;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzalh implements zzajq, zzalg {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzalf f13950f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final HashSet<AbstractMap.SimpleEntry<String, zzaho<? super zzalf>>> f13951g = new HashSet<>();

    public zzalh(zzalf zzalfVar) {
        this.f13950f = zzalfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzalg
    public final void F() {
        for (AbstractMap.SimpleEntry<String, zzaho<? super zzalf>> simpleEntry : this.f13951g) {
            String strValueOf = String.valueOf(simpleEntry.getValue().toString());
            zzawz.m(strValueOf.length() != 0 ? "Unregistering eventhandler: ".concat(strValueOf) : new String("Unregistering eventhandler: "));
            this.f13950f.i(simpleEntry.getKey(), simpleEntry.getValue());
        }
        this.f13951g.clear();
    }

    @Override // com.google.android.gms.internal.ads.zzajq
    public final void X(String str, String str2) {
        zzajr.a(this, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzakg
    public final void Y(String str, JSONObject jSONObject) {
        zzajr.c(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzalf
    public final void f(String str, zzaho<? super zzalf> zzahoVar) {
        this.f13950f.f(str, zzahoVar);
        this.f13951g.add(new AbstractMap.SimpleEntry<>(str, zzahoVar));
    }

    @Override // com.google.android.gms.internal.ads.zzalf
    public final void i(String str, zzaho<? super zzalf> zzahoVar) {
        this.f13950f.i(str, zzahoVar);
        this.f13951g.remove(new AbstractMap.SimpleEntry(str, zzahoVar));
    }

    @Override // com.google.android.gms.internal.ads.zzajq, com.google.android.gms.internal.ads.zzaji
    public final void j(String str, JSONObject jSONObject) {
        zzajr.d(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzajq, com.google.android.gms.internal.ads.zzakg
    public final void k(String str) {
        this.f13950f.k(str);
    }

    @Override // com.google.android.gms.internal.ads.zzaji
    public final void y(String str, Map map) {
        zzajr.b(this, str, map);
    }
}
