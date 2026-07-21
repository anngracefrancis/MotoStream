package com.flurry.sdk;

import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends d7<l> {
    protected l p;
    protected h7 q;
    protected j r;
    protected g s;
    protected f t;
    protected AtomicBoolean u;
    protected f7<i7> v;

    final class a extends f2 {
        a() {
        }

        @Override // com.flurry.sdk.f2
        public final void a() throws Exception {
            h.this.r.a();
        }
    }

    final class b extends f2 {
        b() {
        }

        @Override // com.flurry.sdk.f2
        public final void a() throws Exception {
            g0.a();
            g0.f("IdProvider: Provider start", Collections.emptyMap());
            h.this.d();
        }
    }

    final class c extends f2 {

        final class a extends f2 {

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ boolean f10804h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            final /* synthetic */ String f10805i;

            a(boolean z, String str) {
                this.f10804h = z;
                this.f10805i = str;
            }

            @Override // com.flurry.sdk.f2
            public final void a() throws Exception {
                h.this.t.a();
                boolean z = this.f10804h;
                f fVar = h.this.t;
                if (z == fVar.p && this.f10805i.equals(fVar.o)) {
                    return;
                }
                g0.a();
                g0.f("IdProvider: Advertising Info update", Collections.emptyMap());
                h.this.d();
            }
        }

        c() {
        }

        @Override // com.flurry.sdk.f2
        public final void a() {
            String strConcat;
            h.this.u.set(false);
            h.this.r.a();
            byte[] bArrI = null;
            try {
                f fVar = h.this.t;
                String strG = p2.g("advertising_id", null);
                boolean z = !b0.a().getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0).getBoolean(String.format(Locale.US, "com.flurry.sdk.%s", "ad_tracking_enabled"), false);
                if (strG != null) {
                    fVar.o = strG;
                    fVar.p = z;
                } else {
                    fVar.a();
                }
                f fVar2 = h.this.t;
                String str = fVar2.o;
                boolean z2 = fVar2.p;
                if (!str.isEmpty()) {
                    h.this.p.b(m.AndroidAdvertisingId, str);
                    h.this.p.f10893b = z2;
                }
                if (!h.this.t.q.get()) {
                    h.this.m(new a(z2, str));
                }
            } catch (Exception e2) {
                d1.c(6, "IdProvider", "Error Fetching Ad Id - " + e2.getLocalizedMessage());
                g0.a();
                g0.c("Error fetching Ad Id", "Exception happened during fetching Ad Id", e2);
            }
            try {
                g gVar = h.this.s;
                if (TextUtils.isEmpty(gVar.a)) {
                    String string = Settings.Secure.getString(b0.a().getContentResolver(), "android_id");
                    strConcat = gVar.f10766b.contains(string.toLowerCase(Locale.US)) ? null : "AND".concat(string);
                    if (TextUtils.isEmpty(strConcat)) {
                        String strA = g.a();
                        if (TextUtils.isEmpty(strA)) {
                            strA = gVar.c();
                            if (TextUtils.isEmpty(strA)) {
                                strA = "ID" + Long.toString(Double.doubleToLongBits(new SecureRandom().nextDouble()) + ((System.nanoTime() + (c2.j(a2.a(b0.a())) * 37)) * 37), 16);
                            }
                            g.b(strA);
                        }
                        gVar.a = strA;
                        strConcat = gVar.a;
                    }
                } else {
                    strConcat = gVar.a;
                }
                if (strConcat != null) {
                    h.this.p.b(m.DeviceId, strConcat);
                }
            } catch (Exception e3) {
                d1.c(6, "IdProvider", "Error Fetching Device Id - " + e3.getLocalizedMessage());
                g0.a();
                g0.c("Error fetching Device Id", "Exception happened during fetching Device Id", e3);
            }
            try {
                j jVar = h.this.r;
                byte[] bArr = jVar.f10836b;
                if (bArr == null) {
                    b7.a aVar = Build.VERSION.SDK_INT < 23 ? b7.a.CRYPTO_ALGO_PADDING_5 : b7.a.CRYPTO_ALGO_PADDING_7;
                    byte[] bArrC = jVar.c(jVar.d());
                    if (bArrC == null) {
                        String lowerCase = UUID.randomUUID().toString().toLowerCase(Locale.ENGLISH);
                        if (!TextUtils.isEmpty(lowerCase)) {
                            String strReplaceAll = lowerCase.replaceAll("[^a-f0-9]+", HttpUrl.FRAGMENT_ENCODE_SET);
                            if (strReplaceAll.length() % 2 != 0) {
                                d1.c(4, "InstallationIdProvider", "Input string must contain an even number of characters ".concat(strReplaceAll));
                            } else {
                                bArrI = c2.i(strReplaceAll);
                            }
                        }
                        jVar.b(bArrI, aVar);
                        bArr = bArrI;
                    } else {
                        bArr = bArrC;
                    }
                    jVar.f10836b = bArr;
                }
                if (bArr != null) {
                    h.this.p.b(m.AndroidInstallationId, Base64.encodeToString(bArr, 2));
                }
            } catch (Exception e4) {
                d1.c(6, "IdProvider", "Error Fetching Install Id - " + e4.getLocalizedMessage());
                g0.a();
                g0.c("Error fetching Install Id", "Exception happened during fetching Install Id", e4);
            }
            h.this.u.set(true);
            if (h.this.c()) {
                h hVar = h.this;
                hVar.t(hVar.p.c());
            }
        }
    }

    final class d implements f7<i7> {
        d() {
        }

        @Override // com.flurry.sdk.f7
        public final /* synthetic */ void a(i7 i7Var) {
            h.this.d();
            h.z(i7Var);
        }
    }

    public h(h7 h7Var) {
        super("IdProvider");
        this.p = null;
        this.u = new AtomicBoolean(false);
        this.v = new d();
        this.q = h7Var;
        this.r = new j();
        this.s = new g();
        this.t = new f();
        this.p = new l();
        this.q.v(this.v);
    }

    static /* synthetic */ void z(i7 i7Var) {
        HashMap map = new HashMap();
        map.put("previous_state", i7Var.a.name());
        map.put("current_state", i7Var.f10835b.name());
        g0.a();
        g0.f("IdProvider: App State Change", map);
    }

    public final boolean c() {
        boolean z = this.u.get();
        l lVar = this.p;
        return z && (lVar != null && lVar.a() != null && this.p.a().size() > 0);
    }

    protected final void d() {
        m(new c());
    }

    @Override // com.flurry.sdk.d7
    public final void u() {
        m(new a());
        m(new b());
    }

    @Override // com.flurry.sdk.d7
    public final void v(f7<l> f7Var) {
        super.v(f7Var);
    }
}
