package com.google.firebase.crashlytics.internal.s;

import android.content.Context;
import cm.aptoide.pt.networking.BodyInterceptorV3;
import com.google.android.datatransport.cct.c;
import com.google.android.gms.tasks.Task;
import com.google.firebase.crashlytics.internal.n.b0;
import com.google.firebase.crashlytics.internal.n.n0;
import com.google.firebase.crashlytics.internal.p.f0;
import com.google.firebase.crashlytics.internal.p.h0.j;
import com.google.firebase.crashlytics.internal.t.i;
import e.e.b.a.b;
import e.e.b.a.e;
import e.e.b.a.g;
import e.e.b.a.i.u;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: DataTransportCrashlyticsReportSender.java */
/* JADX INFO: loaded from: classes2.dex */
public class d {
    private static final j a = new j();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f19525b = d("hts/cahyiseot-agolai.o/1frlglgc/aclg", "tp:/rsltcrprsp.ogepscmv/ieo/eaybtho");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f19526c = d("AzSBpY4F0rHiHFdinTvM", "IayrSTFL9eJ69YeSUO2");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final e<f0, byte[]> f19527d = new e() { // from class: com.google.firebase.crashlytics.h.s.a
        @Override // e.e.b.a.e
        public final Object a(Object obj) {
            return d.a.M((f0) obj).getBytes(Charset.forName("UTF-8"));
        }
    };

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final e f19528e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final e<f0, byte[]> f19529f;

    d(e eVar, e<f0, byte[]> eVar2) {
        this.f19528e = eVar;
        this.f19529f = eVar2;
    }

    public static d a(Context context, i iVar, n0 n0Var) {
        u.f(context);
        g gVarG = u.c().g(new c(f19525b, f19526c));
        b bVarB = b.b(BodyInterceptorV3.RESPONSE_MODE_JSON);
        e<f0, byte[]> eVar = f19527d;
        return new d(new e(gVarG.a("FIREBASE_CRASHLYTICS_REPORT", f0.class, bVarB, eVar), iVar.b(), n0Var), eVar);
    }

    private static String d(String str, String str2) {
        int length = str.length() - str2.length();
        if (length < 0 || length > 1) {
            throw new IllegalArgumentException("Invalid input received");
        }
        StringBuilder sb = new StringBuilder(str.length() + str2.length());
        for (int i2 = 0; i2 < str.length(); i2++) {
            sb.append(str.charAt(i2));
            if (str2.length() > i2) {
                sb.append(str2.charAt(i2));
            }
        }
        return sb.toString();
    }

    public Task<b0> b(b0 b0Var, boolean z) {
        return this.f19528e.g(b0Var, z).a();
    }
}
