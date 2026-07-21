package com.facebook.internal.t0;

import com.facebook.GraphRequest;
import com.facebook.a0;
import com.facebook.internal.p0;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.jvm.internal.m;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.u;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: InstrumentUtility.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class k {
    public static final k a = new k();

    private k() {
    }

    public static final boolean a(String str) {
        File fileC = c();
        if (fileC == null || str == null) {
            return false;
        }
        return new File(fileC, str).delete();
    }

    public static final String b(Throwable th) {
        if (th == null) {
            return null;
        }
        return th.getCause() == null ? th.toString() : String.valueOf(th.getCause());
    }

    public static final File c() {
        a0 a0Var = a0.a;
        File file = new File(a0.c().getCacheDir(), "instrument");
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        return null;
    }

    public static final String d(Thread thread) {
        m.f(thread, "thread");
        StackTraceElement[] stackTrace = thread.getStackTrace();
        JSONArray jSONArray = new JSONArray();
        m.e(stackTrace, "stackTrace");
        int length = stackTrace.length;
        int i2 = 0;
        while (i2 < length) {
            StackTraceElement stackTraceElement = stackTrace[i2];
            i2++;
            jSONArray.put(stackTraceElement.toString());
        }
        return jSONArray.toString();
    }

    public static final String e(Throwable th) {
        Throwable th2 = null;
        if (th == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        while (th != null && th != th2) {
            StackTraceElement[] stackTrace = th.getStackTrace();
            m.e(stackTrace, "t.stackTrace");
            int i2 = 0;
            int length = stackTrace.length;
            while (i2 < length) {
                StackTraceElement stackTraceElement = stackTrace[i2];
                i2++;
                jSONArray.put(stackTraceElement.toString());
            }
            th2 = th;
            th = th.getCause();
        }
        return jSONArray.toString();
    }

    public static final boolean f(StackTraceElement stackTraceElement) {
        m.f(stackTraceElement, "element");
        String className = stackTraceElement.getClassName();
        m.e(className, "element.className");
        if (!u.E(className, "com.facebook", false, 2, null)) {
            String className2 = stackTraceElement.getClassName();
            m.e(className2, "element.className");
            if (!u.E(className2, "com.meta", false, 2, null)) {
                return false;
            }
        }
        return true;
    }

    public static final boolean g(Throwable th) {
        if (th == null) {
            return false;
        }
        Throwable th2 = null;
        while (th != null && th != th2) {
            StackTraceElement[] stackTrace = th.getStackTrace();
            m.e(stackTrace, "t.stackTrace");
            int length = stackTrace.length;
            int i2 = 0;
            while (i2 < length) {
                StackTraceElement stackTraceElement = stackTrace[i2];
                i2++;
                m.e(stackTraceElement, "element");
                if (f(stackTraceElement)) {
                    return true;
                }
            }
            th2 = th;
            th = th.getCause();
        }
        return false;
    }

    public static final boolean h(Thread thread) {
        StackTraceElement[] stackTrace;
        if (thread != null && (stackTrace = thread.getStackTrace()) != null) {
            for (StackTraceElement stackTraceElement : stackTrace) {
                m.e(stackTraceElement, "element");
                if (f(stackTraceElement)) {
                    String className = stackTraceElement.getClassName();
                    m.e(className, "element.className");
                    if (!u.E(className, "com.facebook.appevents.codeless", false, 2, null)) {
                        String className2 = stackTraceElement.getClassName();
                        m.e(className2, "element.className");
                        if (!u.E(className2, "com.facebook.appevents.suggestedevents", false, 2, null)) {
                            return true;
                        }
                    }
                    String methodName = stackTraceElement.getMethodName();
                    m.e(methodName, "element.methodName");
                    if (u.E(methodName, "onClick", false, 2, null)) {
                        continue;
                    } else {
                        String methodName2 = stackTraceElement.getMethodName();
                        m.e(methodName2, "element.methodName");
                        if (u.E(methodName2, "onItemClick", false, 2, null)) {
                            continue;
                        } else {
                            String methodName3 = stackTraceElement.getMethodName();
                            m.e(methodName3, "element.methodName");
                            if (!u.E(methodName3, "onTouch", false, 2, null)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static final File[] l() {
        File fileC = c();
        if (fileC == null) {
            return new File[0];
        }
        File[] fileArrListFiles = fileC.listFiles(new FilenameFilter() { // from class: com.facebook.internal.t0.e
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str) {
                return k.m(file, str);
            }
        });
        return fileArrListFiles == null ? new File[0] : fileArrListFiles;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean m(File file, String str) {
        m.e(str, "name");
        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
        String str2 = String.format("^%s[0-9]+.json$", Arrays.copyOf(new Object[]{"anr_log_"}, 1));
        m.e(str2, "java.lang.String.format(format, *args)");
        return new Regex(str2).b(str);
    }

    public static final File[] n() {
        File fileC = c();
        if (fileC == null) {
            return new File[0];
        }
        File[] fileArrListFiles = fileC.listFiles(new FilenameFilter() { // from class: com.facebook.internal.t0.f
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str) {
                return k.o(file, str);
            }
        });
        return fileArrListFiles == null ? new File[0] : fileArrListFiles;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean o(File file, String str) {
        m.e(str, "name");
        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
        String str2 = String.format("^%s[0-9]+.json$", Arrays.copyOf(new Object[]{"analysis_log_"}, 1));
        m.e(str2, "java.lang.String.format(format, *args)");
        return new Regex(str2).b(str);
    }

    public static final File[] p() {
        File fileC = c();
        if (fileC == null) {
            return new File[0];
        }
        File[] fileArrListFiles = fileC.listFiles(new FilenameFilter() { // from class: com.facebook.internal.t0.g
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str) {
                return k.q(file, str);
            }
        });
        return fileArrListFiles == null ? new File[0] : fileArrListFiles;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean q(File file, String str) {
        m.e(str, "name");
        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
        String str2 = String.format("^(%s|%s|%s)[0-9]+.json$", Arrays.copyOf(new Object[]{"crash_log_", "shield_log_", "thread_check_log_"}, 3));
        m.e(str2, "java.lang.String.format(format, *args)");
        return new Regex(str2).b(str);
    }

    public static final JSONObject r(String str, boolean z) {
        File fileC = c();
        if (fileC != null && str != null) {
            try {
                FileInputStream fileInputStream = new FileInputStream(new File(fileC, str));
                p0 p0Var = p0.a;
                return new JSONObject(p0.s0(fileInputStream));
            } catch (Exception unused) {
                if (z) {
                    a(str);
                }
            }
        }
        return null;
    }

    public static final void s(String str, JSONArray jSONArray, GraphRequest.b bVar) {
        m.f(jSONArray, "reports");
        if (jSONArray.length() == 0) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(str, jSONArray.toString());
            p0 p0Var = p0.a;
            JSONObject jSONObjectA = p0.A();
            if (jSONObjectA != null) {
                Iterator<String> itKeys = jSONObjectA.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    jSONObject.put(next, jSONObjectA.get(next));
                }
            }
            GraphRequest.c cVar = GraphRequest.a;
            StringCompanionObject stringCompanionObject = StringCompanionObject.a;
            a0 a0Var = a0.a;
            String str2 = String.format("%s/instruments", Arrays.copyOf(new Object[]{a0.d()}, 1));
            m.e(str2, "java.lang.String.format(format, *args)");
            cVar.A(null, str2, jSONObject, bVar).k();
        } catch (JSONException unused) {
        }
    }

    public static final void t(String str, String str2) {
        File fileC = c();
        if (fileC == null || str == null || str2 == null) {
            return;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(fileC, str));
            byte[] bytes = str2.getBytes(Charsets.f25054b);
            m.e(bytes, "(this as java.lang.String).getBytes(charset)");
            fileOutputStream.write(bytes);
            fileOutputStream.close();
        } catch (Exception unused) {
        }
    }
}
