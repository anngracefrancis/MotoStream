package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import cm.aptoide.pt.account.AccountAnalytics;
import com.google.android.gms.ads.internal.zzk;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcaq {
    private final zzbbl a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzcau f14987b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzcbd f14988c;

    public zzcaq(zzbbl zzbblVar, zzcau zzcauVar, zzcbd zzcbdVar) {
        this.a = zzbblVar;
        this.f14987b = zzcauVar;
        this.f14988c = zzcbdVar;
    }

    public final zzbbh<zzbyt> a(final zzcxu zzcxuVar, final zzcxm zzcxmVar, final JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        zzbbh zzbbhVarO;
        final zzbbh zzbbhVarSubmit = this.a.submit(new Callable(this, zzcxuVar, zzcxmVar, jSONObject) { // from class: com.google.android.gms.internal.ads.lg

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final zzcaq f12935f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private final zzcxu f12936g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            private final zzcxm f12937h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            private final JSONObject f12938i;

            {
                this.f12935f = this;
                this.f12936g = zzcxuVar;
                this.f12937h = zzcxmVar;
                this.f12938i = jSONObject;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() throws zzcmw {
                zzcxu zzcxuVar2 = this.f12936g;
                zzcxm zzcxmVar2 = this.f12937h;
                JSONObject jSONObject2 = this.f12938i;
                zzbyt zzbytVar = new zzbyt();
                zzbytVar.M(jSONObject2.optInt("template_id", -1));
                zzbytVar.P(jSONObject2.optString("custom_template_id"));
                zzcxv zzcxvVar = zzcxuVar2.a.a;
                if (!zzcxvVar.f15753g.contains(Integer.toString(zzbytVar.w()))) {
                    int iW = zzbytVar.w();
                    StringBuilder sb = new StringBuilder(32);
                    sb.append("Invalid template ID: ");
                    sb.append(iW);
                    throw new zzcmw(sb.toString(), 0);
                }
                if (zzbytVar.w() == 3) {
                    if (zzbytVar.e() == null) {
                        throw new zzcmw("No custom template id for custom template ad response.", 0);
                    }
                    if (!zzcxvVar.f15754h.contains(zzbytVar.e())) {
                        throw new zzcmw("Unexpected custom template id in the response.", 0);
                    }
                }
                zzbytVar.o(jSONObject2.optDouble("rating", -1.0d));
                String strOptString = jSONObject2.optString("headline", null);
                if (zzcxmVar2.E) {
                    zzk.zzlg();
                    String strM0 = zzaxi.m0();
                    StringBuilder sb2 = new StringBuilder(String.valueOf(strM0).length() + 3 + String.valueOf(strOptString).length());
                    sb2.append(strM0);
                    sb2.append(" : ");
                    sb2.append(strOptString);
                    strOptString = sb2.toString();
                }
                zzbytVar.T("headline", strOptString);
                zzbytVar.T("body", jSONObject2.optString("body", null));
                zzbytVar.T("call_to_action", jSONObject2.optString("call_to_action", null));
                zzbytVar.T(AccountAnalytics.STORE, jSONObject2.optString(AccountAnalytics.STORE, null));
                zzbytVar.T("price", jSONObject2.optString("price", null));
                zzbytVar.T("advertiser", jSONObject2.optString("advertiser", null));
                return zzbytVar;
            }
        });
        final zzbbh<List<zzadw>> zzbbhVarH = this.f14987b.h(jSONObject, "images");
        final zzbbh<zzadw> zzbbhVarG = this.f14987b.g(jSONObject, "secondary_image");
        final zzbbh<zzadw> zzbbhVarG2 = this.f14987b.g(jSONObject, "app_icon");
        final zzbbh<zzadt> zzbbhVarI = this.f14987b.i(jSONObject, "attribution");
        final zzbbh<zzbgz> zzbbhVarN = this.f14987b.n(jSONObject);
        final zzcau zzcauVar = this.f14987b;
        if (jSONObject.optBoolean("enable_omid") && (jSONObjectOptJSONObject = jSONObject.optJSONObject("omid_settings")) != null) {
            final String strOptString = jSONObjectOptJSONObject.optString("omid_html");
            zzbbhVarO = TextUtils.isEmpty(strOptString) ? zzbar.o(null) : zzbar.c(zzbar.o(null), new zzbal(zzcauVar, strOptString) { // from class: com.google.android.gms.internal.ads.qg
                private final zzcau a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private final String f13231b;

                {
                    this.a = zzcauVar;
                    this.f13231b = strOptString;
                }

                @Override // com.google.android.gms.internal.ads.zzbal
                public final zzbbh zzf(Object obj) {
                    return this.a.f(this.f13231b, obj);
                }
            }, zzbbm.a);
        } else {
            zzbbhVarO = zzbar.o(null);
        }
        final zzbbh zzbbhVar = zzbbhVarO;
        final zzbbh<List<zzcbg>> zzbbhVarA = this.f14988c.a(jSONObject, "custom_assets");
        return zzbar.a(zzbbhVarSubmit, zzbbhVarH, zzbbhVarG, zzbbhVarG2, zzbbhVarI, zzbbhVarN, zzbbhVar, zzbbhVarA).a(new Callable(this, zzbbhVarSubmit, zzbbhVarH, zzbbhVarG2, zzbbhVarG, zzbbhVarI, jSONObject, zzbbhVarN, zzbbhVar, zzbbhVarA) { // from class: com.google.android.gms.internal.ads.mg

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final zzcaq f12982f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private final zzbbh f12983g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            private final zzbbh f12984h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            private final zzbbh f12985i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            private final zzbbh f12986j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            private final zzbbh f12987k;
            private final JSONObject l;
            private final zzbbh m;
            private final zzbbh n;
            private final zzbbh o;

            {
                this.f12982f = this;
                this.f12983g = zzbbhVarSubmit;
                this.f12984h = zzbbhVarH;
                this.f12985i = zzbbhVarG2;
                this.f12986j = zzbbhVarG;
                this.f12987k = zzbbhVarI;
                this.l = jSONObject;
                this.m = zzbbhVarN;
                this.n = zzbbhVar;
                this.o = zzbbhVarA;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzbbh zzbbhVar2 = this.f12983g;
                zzbbh zzbbhVar3 = this.f12984h;
                zzbbh zzbbhVar4 = this.f12985i;
                zzbbh zzbbhVar5 = this.f12986j;
                zzbbh zzbbhVar6 = this.f12987k;
                JSONObject jSONObject2 = this.l;
                zzbbh zzbbhVar7 = this.m;
                zzbbh zzbbhVar8 = this.n;
                zzbbh zzbbhVar9 = this.o;
                zzbyt zzbytVar = (zzbyt) zzbbhVar2.get();
                zzbytVar.n((List) zzbbhVar3.get());
                zzbytVar.u((zzaei) zzbbhVar4.get());
                zzbytVar.L((zzaei) zzbbhVar5.get());
                zzbytVar.t((zzaea) zzbbhVar6.get());
                zzbytVar.N(zzcau.k(jSONObject2));
                zzbytVar.s(zzcau.l(jSONObject2));
                zzbgz zzbgzVar = (zzbgz) zzbbhVar7.get();
                if (zzbgzVar != null) {
                    zzbytVar.R(zzbgzVar);
                    zzbytVar.Z(zzbgzVar.getView());
                    zzbytVar.K(zzbgzVar.h());
                }
                zzbgz zzbgzVar2 = (zzbgz) zzbbhVar8.get();
                if (zzbgzVar2 != null) {
                    zzbytVar.S(zzbgzVar2);
                }
                for (zzcbg zzcbgVar : (List) zzbbhVar9.get()) {
                    int i2 = zzcbgVar.a;
                    if (i2 == 1) {
                        zzbytVar.T(zzcbgVar.f15010b, zzcbgVar.f15011c);
                    } else if (i2 == 2) {
                        zzbytVar.v(zzcbgVar.f15010b, zzcbgVar.f15012d);
                    }
                }
                return zzbytVar;
            }
        }, this.a);
    }
}
