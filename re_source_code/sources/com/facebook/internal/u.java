package com.facebook.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import java.util.ArrayList;

/* JADX INFO: compiled from: CustomTab.kt */
/* JADX INFO: loaded from: classes2.dex */
public class u {
    public static final a a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Uri f9900b;

    /* JADX INFO: compiled from: CustomTab.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public Uri a(String str, Bundle bundle) {
            kotlin.jvm.internal.m.f(str, "action");
            p0 p0Var = p0.a;
            n0 n0Var = n0.a;
            String strB = n0.b();
            StringBuilder sb = new StringBuilder();
            com.facebook.a0 a0Var = com.facebook.a0.a;
            sb.append(com.facebook.a0.n());
            sb.append("/dialog/");
            sb.append(str);
            return p0.e(strB, sb.toString(), bundle);
        }
    }

    public u(String str, Bundle bundle) {
        Uri uriA;
        kotlin.jvm.internal.m.f(str, "action");
        bundle = bundle == null ? new Bundle() : bundle;
        e0[] e0VarArrValuesCustom = e0.valuesCustom();
        ArrayList arrayList = new ArrayList(e0VarArrValuesCustom.length);
        for (e0 e0Var : e0VarArrValuesCustom) {
            arrayList.add(e0Var.k());
        }
        if (arrayList.contains(str)) {
            p0 p0Var = p0.a;
            n0 n0Var = n0.a;
            uriA = p0.e(n0.g(), kotlin.jvm.internal.m.n("/dialog/", str), bundle);
        } else {
            uriA = a.a(str, bundle);
        }
        this.f9900b = uriA;
    }

    public final boolean a(Activity activity, String str) {
        kotlin.jvm.internal.m.f(activity, "activity");
        c.c.b.c cVarC = new c.c.b.c.a(com.facebook.login.q.f10020f.b()).c();
        cVarC.a.setPackage(str);
        try {
            cVarC.a(activity, this.f9900b);
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }

    protected final void b(Uri uri) {
        kotlin.jvm.internal.m.f(uri, "<set-?>");
        this.f9900b = uri;
    }
}
