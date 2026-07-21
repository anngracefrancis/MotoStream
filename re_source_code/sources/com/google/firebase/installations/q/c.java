package com.google.firebase.installations.q;

import com.google.firebase.j;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import okhttp3.internal.http2.Http2;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: PersistedInstallation.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {
    private File a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final j f19713b;

    /* JADX INFO: compiled from: PersistedInstallation.java */
    public enum a {
        ATTEMPT_MIGRATION,
        NOT_GENERATED,
        UNREGISTERED,
        REGISTERED,
        REGISTER_ERROR
    }

    public c(j jVar) {
        this.f19713b = jVar;
    }

    private File a() {
        if (this.a == null) {
            synchronized (this) {
                if (this.a == null) {
                    this.a = new File(this.f19713b.i().getFilesDir(), "PersistedInstallation." + this.f19713b.m() + ".json");
                }
            }
        }
        return this.a;
    }

    private JSONObject c() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[Http2.INITIAL_MAX_FRAME_SIZE];
        try {
            FileInputStream fileInputStream = new FileInputStream(a());
            while (true) {
                try {
                    int i2 = fileInputStream.read(bArr, 0, Http2.INITIAL_MAX_FRAME_SIZE);
                    if (i2 < 0) {
                        JSONObject jSONObject = new JSONObject(byteArrayOutputStream.toString());
                        fileInputStream.close();
                        return jSONObject;
                    }
                    byteArrayOutputStream.write(bArr, 0, i2);
                } catch (Throwable th) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable unused) {
                    }
                    throw th;
                }
            }
        } catch (IOException | JSONException unused2) {
            return new JSONObject();
        }
    }

    public d b(d dVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("Fid", dVar.d());
            jSONObject.put("Status", dVar.g().ordinal());
            jSONObject.put("AuthToken", dVar.b());
            jSONObject.put("RefreshToken", dVar.f());
            jSONObject.put("TokenCreationEpochInSecs", dVar.h());
            jSONObject.put("ExpiresInSecs", dVar.c());
            jSONObject.put("FisError", dVar.e());
            File fileCreateTempFile = File.createTempFile("PersistedInstallation", "tmp", this.f19713b.i().getFilesDir());
            FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
            fileOutputStream.write(jSONObject.toString().getBytes("UTF-8"));
            fileOutputStream.close();
            if (!fileCreateTempFile.renameTo(a())) {
                throw new IOException("unable to rename the tmpfile to PersistedInstallation");
            }
        } catch (IOException | JSONException unused) {
        }
        return dVar;
    }

    public d d() {
        JSONObject jSONObjectC = c();
        String strOptString = jSONObjectC.optString("Fid", null);
        int iOptInt = jSONObjectC.optInt("Status", a.ATTEMPT_MIGRATION.ordinal());
        String strOptString2 = jSONObjectC.optString("AuthToken", null);
        String strOptString3 = jSONObjectC.optString("RefreshToken", null);
        long jOptLong = jSONObjectC.optLong("TokenCreationEpochInSecs", 0L);
        long jOptLong2 = jSONObjectC.optLong("ExpiresInSecs", 0L);
        return d.a().d(strOptString).g(a.values()[iOptInt]).b(strOptString2).f(strOptString3).h(jOptLong).c(jOptLong2).e(jSONObjectC.optString("FisError", null)).a();
    }
}
