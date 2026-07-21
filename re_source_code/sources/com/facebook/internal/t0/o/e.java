package com.facebook.internal.t0.o;

import cm.aptoide.pt.install.installer.RootCommandOnSubscribe;
import com.facebook.GraphRequest;
import com.facebook.a0;
import com.facebook.d0;
import com.facebook.internal.p0;
import com.facebook.internal.t0.k;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import kotlin.collections.y;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.jvm.internal.m;
import kotlin.text.Regex;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ErrorReportHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class e {
    public static final e a = new e();

    private e() {
    }

    public static final void a() {
        a0 a0Var = a0.a;
        if (a0.g()) {
            h();
        }
    }

    public static final File[] e() {
        k kVar = k.a;
        File fileC = k.c();
        if (fileC == null) {
            return new File[0];
        }
        File[] fileArrListFiles = fileC.listFiles(new FilenameFilter() { // from class: com.facebook.internal.t0.o.c
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str) {
                return e.f(file, str);
            }
        });
        m.e(fileArrListFiles, "reportDir.listFiles { dir, name ->\n      name.matches(Regex(String.format(\"^%s[0-9]+.json$\", InstrumentUtility.ERROR_REPORT_PREFIX)))\n    }");
        return fileArrListFiles;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean f(File file, String str) {
        m.e(str, "name");
        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
        String str2 = String.format("^%s[0-9]+.json$", Arrays.copyOf(new Object[]{"error_log_"}, 1));
        m.e(str2, "java.lang.String.format(format, *args)");
        return new Regex(str2).b(str);
    }

    public static final void g(String str) {
        try {
            new d(str).e();
        } catch (Exception unused) {
        }
    }

    public static final void h() {
        p0 p0Var = p0.a;
        if (p0.X()) {
            return;
        }
        File[] fileArrE = e();
        final ArrayList arrayList = new ArrayList();
        int length = fileArrE.length;
        int i2 = 0;
        while (i2 < length) {
            File file = fileArrE[i2];
            i2++;
            d dVar = new d(file);
            if (dVar.d()) {
                arrayList.add(dVar);
            }
        }
        y.y(arrayList, new Comparator() { // from class: com.facebook.internal.t0.o.a
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return e.i((d) obj, (d) obj2);
            }
        });
        JSONArray jSONArray = new JSONArray();
        for (int i3 = 0; i3 < arrayList.size() && i3 < 1000; i3++) {
            jSONArray.put(arrayList.get(i3));
        }
        k kVar = k.a;
        k.s("error_reports", jSONArray, new GraphRequest.b() { // from class: com.facebook.internal.t0.o.b
            @Override // com.facebook.GraphRequest.b
            public final void b(d0 d0Var) {
                e.j(arrayList, d0Var);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int i(d dVar, d dVar2) {
        m.e(dVar2, "o2");
        return dVar.b(dVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(ArrayList arrayList, d0 d0Var) {
        m.f(arrayList, "$validReports");
        m.f(d0Var, "response");
        try {
            if (d0Var.b() == null) {
                JSONObject jSONObjectD = d0Var.d();
                if (m.a(jSONObjectD == null ? null : Boolean.valueOf(jSONObjectD.getBoolean(RootCommandOnSubscribe.SUCCESS_OUTPUT_CONFIRMATION)), Boolean.TRUE)) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((d) it.next()).a();
                    }
                }
            }
        } catch (JSONException unused) {
        }
    }
}
