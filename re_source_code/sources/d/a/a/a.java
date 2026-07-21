package d.a.a;

import e.h.a.e0.b;
import e.h.a.k0.c;
import java.io.IOException;
import java.io.InputStream;
import java.net.ProtocolException;
import java.util.List;
import java.util.Map;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: OkHttp3Connection.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements b {
    final OkHttpClient a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Request.Builder f20672b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Request f20673c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Response f20674d;

    /* JADX INFO: renamed from: d.a.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: OkHttp3Connection.java */
    public static class C0253a implements c.b {
        private OkHttpClient a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private OkHttpClient.Builder f20675b;

        public C0253a() {
        }

        @Override // e.h.a.k0.c.b
        public b a(String str) throws IOException {
            if (this.a == null) {
                synchronized (C0253a.class) {
                    if (this.a == null) {
                        OkHttpClient.Builder builder = this.f20675b;
                        this.a = builder != null ? builder.build() : new OkHttpClient();
                        this.f20675b = null;
                    }
                }
            }
            return new a(str, this.a);
        }

        public C0253a(OkHttpClient.Builder builder) {
            this.f20675b = builder;
        }
    }

    a(Request.Builder builder, OkHttpClient okHttpClient) {
        this.f20672b = builder;
        this.a = okHttpClient;
    }

    @Override // e.h.a.e0.b
    public InputStream a() throws IOException {
        Response response = this.f20674d;
        if (response == null) {
            throw new IOException("Please invoke #execute first!");
        }
        ResponseBody responseBodyBody = response.body();
        if (responseBodyBody != null) {
            return responseBodyBody.byteStream();
        }
        throw new IOException("No body found on response!");
    }

    @Override // e.h.a.e0.b
    public Map<String, List<String>> b() {
        Response response = this.f20674d;
        if (response == null) {
            return null;
        }
        return response.headers().toMultimap();
    }

    @Override // e.h.a.e0.b
    public boolean c(String str, long j2) {
        return false;
    }

    @Override // e.h.a.e0.b
    public int d() throws IOException {
        Response response = this.f20674d;
        if (response != null) {
            return response.code();
        }
        throw new IllegalStateException("Please invoke #execute first!");
    }

    @Override // e.h.a.e0.b
    public String e(String str) {
        Response response = this.f20674d;
        if (response == null) {
            return null;
        }
        return response.header(str);
    }

    @Override // e.h.a.e0.b
    public void execute() throws IOException {
        if (this.f20673c == null) {
            this.f20673c = this.f20672b.build();
        }
        this.f20674d = this.a.newCall(this.f20673c).execute();
    }

    @Override // e.h.a.e0.b
    public void f(String str, String str2) {
        this.f20672b.addHeader(str, str2);
    }

    @Override // e.h.a.e0.b
    public void g() {
        this.f20673c = null;
        this.f20674d = null;
    }

    @Override // e.h.a.e0.b
    public boolean h(String str) throws ProtocolException {
        this.f20672b.method(str, null);
        return true;
    }

    @Override // e.h.a.e0.b
    public Map<String, List<String>> i() {
        if (this.f20673c == null) {
            this.f20673c = this.f20672b.build();
        }
        return this.f20673c.headers().toMultimap();
    }

    public a(String str, OkHttpClient okHttpClient) {
        this(new Request.Builder().url(str), okHttpClient);
    }
}
