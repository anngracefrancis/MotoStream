package com.bumptech.glide.load.m;

import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.load.HttpException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

/* JADX INFO: compiled from: HttpUrlFetcher.java */
/* JADX INFO: loaded from: classes.dex */
public class j implements d<InputStream> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final b f9273f = new a();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final com.bumptech.glide.load.n.g f9274g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f9275h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final b f9276i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private HttpURLConnection f9277j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private InputStream f9278k;
    private volatile boolean l;

    /* JADX INFO: compiled from: HttpUrlFetcher.java */
    private static class a implements b {
        a() {
        }

        @Override // com.bumptech.glide.load.m.j.b
        public HttpURLConnection a(URL url) throws IOException {
            return (HttpURLConnection) url.openConnection();
        }
    }

    /* JADX INFO: compiled from: HttpUrlFetcher.java */
    interface b {
        HttpURLConnection a(URL url) throws IOException;
    }

    public j(com.bumptech.glide.load.n.g gVar, int i2) {
        this(gVar, i2, f9273f);
    }

    private InputStream c(HttpURLConnection httpURLConnection) throws IOException {
        if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
            this.f9278k = com.bumptech.glide.r.c.b(httpURLConnection.getInputStream(), httpURLConnection.getContentLength());
        } else {
            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                Log.d("HttpUrlFetcher", "Got non empty content encoding: " + httpURLConnection.getContentEncoding());
            }
            this.f9278k = httpURLConnection.getInputStream();
        }
        return this.f9278k;
    }

    private static boolean f(int i2) {
        return i2 / 100 == 2;
    }

    private static boolean g(int i2) {
        return i2 / 100 == 3;
    }

    private InputStream h(URL url, int i2, URL url2, Map<String, String> map) throws IOException {
        if (i2 >= 5) {
            throw new HttpException("Too many (> 5) redirects!");
        }
        if (url2 != null) {
            try {
                if (url.toURI().equals(url2.toURI())) {
                    throw new HttpException("In re-direct loop");
                }
            } catch (URISyntaxException unused) {
            }
        }
        this.f9277j = this.f9276i.a(url);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            this.f9277j.addRequestProperty(entry.getKey(), entry.getValue());
        }
        this.f9277j.setConnectTimeout(this.f9275h);
        this.f9277j.setReadTimeout(this.f9275h);
        this.f9277j.setUseCaches(false);
        this.f9277j.setDoInput(true);
        this.f9277j.setInstanceFollowRedirects(false);
        this.f9277j.connect();
        this.f9278k = this.f9277j.getInputStream();
        if (this.l) {
            return null;
        }
        int responseCode = this.f9277j.getResponseCode();
        if (f(responseCode)) {
            return c(this.f9277j);
        }
        if (!g(responseCode)) {
            if (responseCode == -1) {
                throw new HttpException(responseCode);
            }
            throw new HttpException(this.f9277j.getResponseMessage(), responseCode);
        }
        String headerField = this.f9277j.getHeaderField("Location");
        if (TextUtils.isEmpty(headerField)) {
            throw new HttpException("Received empty or null redirect url");
        }
        URL url3 = new URL(url, headerField);
        b();
        return h(url3, i2 + 1, url, map);
    }

    @Override // com.bumptech.glide.load.m.d
    public Class<InputStream> a() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.m.d
    public void b() {
        InputStream inputStream = this.f9278k;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.f9277j;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.f9277j = null;
    }

    @Override // com.bumptech.glide.load.m.d
    public void cancel() {
        this.l = true;
    }

    @Override // com.bumptech.glide.load.m.d
    public com.bumptech.glide.load.a d() {
        return com.bumptech.glide.load.a.REMOTE;
    }

    @Override // com.bumptech.glide.load.m.d
    public void e(com.bumptech.glide.g gVar, d.a<? super InputStream> aVar) {
        StringBuilder sb;
        long jB = com.bumptech.glide.r.f.b();
        try {
            aVar.f(h(this.f9274g.f(), 0, null, this.f9274g.c()));
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                sb = new StringBuilder();
                sb.append("Finished http url fetcher fetch in ");
                sb.append(com.bumptech.glide.r.f.a(jB));
                String string = sb.toString();
            }
        } catch (IOException e2) {
            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                Log.d("HttpUrlFetcher", "Failed to load data for url", e2);
            }
            aVar.c(e2);
            if (!Log.isLoggable("HttpUrlFetcher", 2)) {
            } else {
                sb = new StringBuilder();
            }
        } finally {
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + com.bumptech.glide.r.f.a(jB));
            }
        }
    }

    j(com.bumptech.glide.load.n.g gVar, int i2, b bVar) {
        this.f9274g = gVar;
        this.f9275h = i2;
        this.f9276i = bVar;
    }
}
