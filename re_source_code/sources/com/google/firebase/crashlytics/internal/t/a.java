package com.google.firebase.crashlytics.internal.t;

import com.google.firebase.crashlytics.internal.h;
import com.google.firebase.crashlytics.internal.n.t;
import com.google.firebase.crashlytics.internal.r.f;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import org.json.JSONObject;

/* JADX INFO: compiled from: CachedSettingsIo.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    private final File a;

    public a(f fVar) {
        this.a = fVar.e("com.crashlytics.settings.json");
    }

    private File a() {
        return this.a;
    }

    public JSONObject b() throws Throwable {
        Throwable th;
        FileInputStream fileInputStream;
        JSONObject jSONObject;
        h.f().b("Checking for cached settings...");
        FileInputStream fileInputStream2 = null;
        try {
            try {
                File fileA = a();
                if (fileA.exists()) {
                    fileInputStream = new FileInputStream(fileA);
                    try {
                        jSONObject = new JSONObject(t.A(fileInputStream));
                        fileInputStream2 = fileInputStream;
                    } catch (Exception e2) {
                        e = e2;
                        h.f().e("Failed to fetch cached settings", e);
                        t.f(fileInputStream, "Error while closing settings cache file.");
                        return null;
                    }
                } else {
                    h.f().i("Settings file does not exist.");
                    jSONObject = null;
                }
                t.f(fileInputStream2, "Error while closing settings cache file.");
                return jSONObject;
            } catch (Throwable th2) {
                th = th2;
                t.f(null, "Error while closing settings cache file.");
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            t.f(null, "Error while closing settings cache file.");
            throw th;
        }
    }

    public void c(long j2, JSONObject jSONObject) throws Throwable {
        h.f().i("Writing settings to cache file...");
        if (jSONObject != null) {
            FileWriter fileWriter = null;
            try {
                try {
                    jSONObject.put("expires_at", j2);
                    FileWriter fileWriter2 = new FileWriter(a());
                    try {
                        fileWriter2.write(jSONObject.toString());
                        fileWriter2.flush();
                        t.f(fileWriter2, "Failed to close settings writer.");
                    } catch (Exception e2) {
                        e = e2;
                        fileWriter = fileWriter2;
                        h.f().e("Failed to cache settings", e);
                        t.f(fileWriter, "Failed to close settings writer.");
                    } catch (Throwable th) {
                        th = th;
                        fileWriter = fileWriter2;
                        t.f(fileWriter, "Failed to close settings writer.");
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e3) {
                e = e3;
            }
        }
    }
}
