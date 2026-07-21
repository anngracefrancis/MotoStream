package com.google.firebase.crashlytics.internal.o;

import cm.aptoide.pt.account.AndroidAccountManagerPersistence;
import com.google.firebase.crashlytics.internal.h;
import com.google.firebase.crashlytics.internal.n.t;
import com.google.firebase.crashlytics.internal.r.f;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: MetaDataStore.java */
/* JADX INFO: loaded from: classes2.dex */
class g {
    private static final Charset a = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final f f19155b;

    /* JADX INFO: compiled from: MetaDataStore.java */
    class a extends JSONObject {
        final /* synthetic */ String a;

        a(String str) throws JSONException {
            this.a = str;
            put(AndroidAccountManagerPersistence.ACCOUNT_ID, str);
        }
    }

    public g(f fVar) {
        this.f19155b = fVar;
    }

    private static Map<String, String> e(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            map.put(next, o(jSONObject, next));
        }
        return map;
    }

    private static List<j> f(String str) throws JSONException {
        JSONArray jSONArray = new JSONObject(str).getJSONArray("rolloutsState");
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            String string = jSONArray.getString(i2);
            try {
                arrayList.add(j.a(string));
            } catch (Exception e2) {
                h.f().l("Failed de-serializing rollouts state. " + string, e2);
            }
        }
        return arrayList;
    }

    private String g(String str) throws JSONException {
        return o(new JSONObject(str), AndroidAccountManagerPersistence.ACCOUNT_ID);
    }

    private static String h(Map<String, String> map) {
        return new JSONObject(map).toString();
    }

    private static String l(List<j> list) {
        HashMap map = new HashMap();
        JSONArray jSONArray = new JSONArray();
        for (int i2 = 0; i2 < list.size(); i2++) {
            try {
                jSONArray.put(new JSONObject(j.a.b(list.get(i2))));
            } catch (JSONException e2) {
                h.f().l("Exception parsing rollout assignment!", e2);
            }
        }
        map.put("rolloutsState", jSONArray);
        return new JSONObject(map).toString();
    }

    private static void m(File file) {
        if (file.exists() && file.delete()) {
            h.f().g("Deleted corrupt file: " + file.getAbsolutePath());
        }
    }

    private static String n(String str) throws JSONException {
        return new a(str).toString();
    }

    private static String o(JSONObject jSONObject, String str) {
        if (jSONObject.isNull(str)) {
            return null;
        }
        return jSONObject.optString(str, null);
    }

    public File a(String str) {
        return this.f19155b.o(str, "internal-keys");
    }

    public File b(String str) {
        return this.f19155b.o(str, "keys");
    }

    public File c(String str) {
        return this.f19155b.o(str, "rollouts-state");
    }

    public File d(String str) {
        return this.f19155b.o(str, "user-data");
    }

    Map<String, String> i(String str, boolean z) throws Throwable {
        FileInputStream fileInputStream;
        Exception e2;
        File fileA = z ? a(str) : b(str);
        if (!fileA.exists() || fileA.length() == 0) {
            m(fileA);
            return Collections.emptyMap();
        }
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(fileA);
            try {
                try {
                    Map<String, String> mapE = e(t.A(fileInputStream));
                    t.f(fileInputStream, "Failed to close user metadata file.");
                    return mapE;
                } catch (Exception e3) {
                    e2 = e3;
                    h.f().l("Error deserializing user metadata.", e2);
                    m(fileA);
                    t.f(fileInputStream, "Failed to close user metadata file.");
                    return Collections.emptyMap();
                }
            } catch (Throwable th) {
                th = th;
                fileInputStream2 = fileInputStream;
                t.f(fileInputStream2, "Failed to close user metadata file.");
                throw th;
            }
        } catch (Exception e4) {
            fileInputStream = null;
            e2 = e4;
        } catch (Throwable th2) {
            th = th2;
            t.f(fileInputStream2, "Failed to close user metadata file.");
            throw th;
        }
    }

    public List<j> j(String str) throws Throwable {
        File fileC = c(str);
        if (!fileC.exists() || fileC.length() == 0) {
            m(fileC);
            return Collections.emptyList();
        }
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(fileC);
                try {
                    List<j> listF = f(t.A(fileInputStream2));
                    h.f().b("Loaded rollouts state:\n" + listF + "\nfor session " + str);
                    t.f(fileInputStream2, "Failed to close rollouts state file.");
                    return listF;
                } catch (Exception e2) {
                    e = e2;
                    fileInputStream = fileInputStream2;
                    h.f().l("Error deserializing rollouts state.", e);
                    m(fileC);
                    t.f(fileInputStream, "Failed to close rollouts state file.");
                    return Collections.emptyList();
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    t.f(fileInputStream, "Failed to close rollouts state file.");
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public String k(String str) throws Throwable {
        FileInputStream fileInputStream;
        File fileD = d(str);
        FileInputStream fileInputStream2 = null;
        if (!fileD.exists() || fileD.length() == 0) {
            h.f().b("No userId set for session " + str);
            m(fileD);
            return null;
        }
        try {
            fileInputStream = new FileInputStream(fileD);
            try {
                try {
                    String strG = g(t.A(fileInputStream));
                    h.f().b("Loaded userId " + strG + " for session " + str);
                    t.f(fileInputStream, "Failed to close user metadata file.");
                    return strG;
                } catch (Exception e2) {
                    e = e2;
                    h.f().l("Error deserializing user metadata.", e);
                    m(fileD);
                    t.f(fileInputStream, "Failed to close user metadata file.");
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                fileInputStream2 = fileInputStream;
                t.f(fileInputStream2, "Failed to close user metadata file.");
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            t.f(fileInputStream2, "Failed to close user metadata file.");
            throw th;
        }
    }

    public void p(String str, Map<String, String> map) throws Throwable {
        q(str, map, false);
    }

    public void q(String str, Map<String, String> map, boolean z) throws Throwable {
        File fileA = z ? a(str) : b(str);
        BufferedWriter bufferedWriter = null;
        try {
            try {
                String strH = h(map);
                BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileA), a));
                try {
                    bufferedWriter2.write(strH);
                    bufferedWriter2.flush();
                    t.f(bufferedWriter2, "Failed to close key/value metadata file.");
                } catch (Exception e2) {
                    e = e2;
                    bufferedWriter = bufferedWriter2;
                    h.f().l("Error serializing key/value metadata.", e);
                    m(fileA);
                    t.f(bufferedWriter, "Failed to close key/value metadata file.");
                } catch (Throwable th) {
                    th = th;
                    bufferedWriter = bufferedWriter2;
                    t.f(bufferedWriter, "Failed to close key/value metadata file.");
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    public void r(String str, List<j> list) throws Throwable {
        File fileC = c(str);
        if (list.isEmpty()) {
            m(fileC);
            return;
        }
        BufferedWriter bufferedWriter = null;
        try {
            try {
                String strL = l(list);
                BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileC), a));
                try {
                    bufferedWriter2.write(strL);
                    bufferedWriter2.flush();
                    t.f(bufferedWriter2, "Failed to close rollouts state file.");
                } catch (Exception e2) {
                    e = e2;
                    bufferedWriter = bufferedWriter2;
                    h.f().l("Error serializing rollouts state.", e);
                    m(fileC);
                    t.f(bufferedWriter, "Failed to close rollouts state file.");
                } catch (Throwable th) {
                    th = th;
                    bufferedWriter = bufferedWriter2;
                    t.f(bufferedWriter, "Failed to close rollouts state file.");
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    public void s(String str, String str2) throws Throwable {
        File fileD = d(str);
        BufferedWriter bufferedWriter = null;
        try {
            try {
                String strN = n(str2);
                BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileD), a));
                try {
                    bufferedWriter2.write(strN);
                    bufferedWriter2.flush();
                    t.f(bufferedWriter2, "Failed to close user metadata file.");
                } catch (Exception e2) {
                    e = e2;
                    bufferedWriter = bufferedWriter2;
                    h.f().l("Error serializing user metadata.", e);
                    t.f(bufferedWriter, "Failed to close user metadata file.");
                } catch (Throwable th) {
                    th = th;
                    bufferedWriter = bufferedWriter2;
                    t.f(bufferedWriter, "Failed to close user metadata file.");
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
