package com.airbnb.lottie.t;

import android.content.Context;
import c.i.j.e;
import com.airbnb.lottie.d;
import com.airbnb.lottie.k;
import com.airbnb.lottie.l;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.zip.ZipInputStream;

/* JADX INFO: compiled from: NetworkFetcher.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    private final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f8846b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b f8847c;

    /* JADX INFO: compiled from: NetworkFetcher.java */
    class a implements Callable<k<d>> {
        a() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public k<d> call() throws Exception {
            return c.this.f();
        }
    }

    private c(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        this.f8846b = str;
        this.f8847c = new b(applicationContext, str);
    }

    private l<d> a() {
        return new l<>(new a());
    }

    public static l<d> b(Context context, String str) {
        return new c(context, str).a();
    }

    private d c() {
        e<com.airbnb.lottie.t.a, InputStream> eVarA = this.f8847c.a();
        if (eVarA == null) {
            return null;
        }
        com.airbnb.lottie.t.a aVar = eVarA.a;
        InputStream inputStream = eVarA.f3281b;
        k<d> kVarM = aVar == com.airbnb.lottie.t.a.Zip ? com.airbnb.lottie.e.m(new ZipInputStream(inputStream), this.f8846b) : com.airbnb.lottie.e.f(inputStream, this.f8846b);
        if (kVarM.b() != null) {
            return kVarM.b();
        }
        return null;
    }

    private k<d> d() {
        try {
            return e();
        } catch (IOException e2) {
            return new k<>((Throwable) e2);
        }
    }

    private k e() throws IOException {
        com.airbnb.lottie.t.a aVar;
        k<d> kVarM;
        com.airbnb.lottie.c.b("Fetching " + this.f8846b);
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f8846b).openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.connect();
        if (httpURLConnection.getErrorStream() == null && httpURLConnection.getResponseCode() == 200) {
            String contentType = httpURLConnection.getContentType();
            byte b2 = -1;
            int iHashCode = contentType.hashCode();
            if (iHashCode != -1248325150) {
                if (iHashCode == -43840953 && contentType.equals("application/json")) {
                    b2 = 1;
                }
            } else if (contentType.equals("application/zip")) {
                b2 = 0;
            }
            if (b2 != 0) {
                com.airbnb.lottie.c.b("Received json response.");
                aVar = com.airbnb.lottie.t.a.Json;
                kVarM = com.airbnb.lottie.e.f(new FileInputStream(new File(this.f8847c.e(httpURLConnection.getInputStream(), aVar).getAbsolutePath())), this.f8846b);
            } else {
                com.airbnb.lottie.c.b("Handling zip response.");
                aVar = com.airbnb.lottie.t.a.Zip;
                kVarM = com.airbnb.lottie.e.m(new ZipInputStream(new FileInputStream(this.f8847c.e(httpURLConnection.getInputStream(), aVar))), this.f8846b);
            }
            if (kVarM.b() != null) {
                this.f8847c.d(aVar);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Completed fetch from network. Success: ");
            sb.append(kVarM.b() != null);
            com.airbnb.lottie.c.b(sb.toString());
            return kVarM;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return new k((Throwable) new IllegalArgumentException("Unable to fetch " + this.f8846b + ". Failed with " + httpURLConnection.getResponseCode() + "\n" + ((Object) sb2)));
            }
            sb2.append(line);
            sb2.append('\n');
        }
    }

    public k<d> f() {
        d dVarC = c();
        if (dVarC != null) {
            return new k<>(dVarC);
        }
        com.airbnb.lottie.c.b("Animation for " + this.f8846b + " not found in cache. Fetching from network.");
        return d();
    }
}
