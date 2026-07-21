package com.facebook.internal.t0.l;

import cm.aptoide.pt.install.installer.RootCommandOnSubscribe;
import com.facebook.GraphRequest;
import com.facebook.a0;
import com.facebook.d0;
import com.facebook.internal.p0;
import com.facebook.internal.t0.i;
import com.facebook.internal.t0.k;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.IntIterator;
import kotlin.collections.c0;
import kotlin.jvm.internal.m;
import kotlin.ranges.l;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ANRHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class e {
    public static final e a = new e();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f9886b = new AtomicBoolean(false);

    private e() {
    }

    public static final synchronized void a() {
        if (f9886b.getAndSet(true)) {
            return;
        }
        a0 a0Var = a0.a;
        if (a0.g()) {
            d();
        }
        d dVar = d.a;
        d.d();
    }

    public static final void d() {
        p0 p0Var = p0.a;
        if (p0.X()) {
            return;
        }
        k kVar = k.a;
        File[] fileArrL = k.l();
        ArrayList arrayList = new ArrayList(fileArrL.length);
        for (File file : fileArrL) {
            i.a aVar = i.a.a;
            arrayList.add(i.a.d(file));
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((i) obj).f()) {
                arrayList2.add(obj);
            }
        }
        final List listX0 = c0.x0(arrayList2, new Comparator() { // from class: com.facebook.internal.t0.l.c
            @Override // java.util.Comparator
            public final int compare(Object obj2, Object obj3) {
                return e.e((i) obj2, (i) obj3);
            }
        });
        JSONArray jSONArray = new JSONArray();
        Iterator<Integer> it = l.k(0, Math.min(listX0.size(), 5)).iterator();
        while (it.hasNext()) {
            jSONArray.put(listX0.get(((IntIterator) it).b()));
        }
        k kVar2 = k.a;
        k.s("anr_reports", jSONArray, new GraphRequest.b() { // from class: com.facebook.internal.t0.l.b
            @Override // com.facebook.GraphRequest.b
            public final void b(d0 d0Var) {
                e.f(listX0, d0Var);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int e(i iVar, i iVar2) {
        m.e(iVar2, "o2");
        return iVar.b(iVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(List list, d0 d0Var) {
        m.f(list, "$validReports");
        m.f(d0Var, "response");
        try {
            if (d0Var.b() == null) {
                JSONObject jSONObjectD = d0Var.d();
                if (m.a(jSONObjectD == null ? null : Boolean.valueOf(jSONObjectD.getBoolean(RootCommandOnSubscribe.SUCCESS_OUTPUT_CONFIRMATION)), Boolean.TRUE)) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((i) it.next()).a();
                    }
                }
            }
        } catch (JSONException unused) {
        }
    }
}
