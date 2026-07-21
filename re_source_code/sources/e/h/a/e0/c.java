package e.h.a.e0;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: FileDownloadUrlConnection.java */
/* JADX INFO: loaded from: classes2.dex */
public class c implements e.h.a.e0.b {
    protected URLConnection a;

    /* JADX INFO: compiled from: FileDownloadUrlConnection.java */
    public static class a {
        static /* synthetic */ Proxy a(a aVar) {
            throw null;
        }

        static /* synthetic */ Integer b(a aVar) {
            throw null;
        }

        static /* synthetic */ Integer c(a aVar) {
            throw null;
        }
    }

    /* JADX INFO: compiled from: FileDownloadUrlConnection.java */
    public static class b implements e.h.a.k0.c.b {
        private final a a;

        public b() {
            this(null);
        }

        @Override // e.h.a.k0.c.b
        public e.h.a.e0.b a(String str) throws IOException {
            return new c(str, this.a);
        }

        public b(a aVar) {
        }
    }

    public c(String str, a aVar) throws IOException {
        this(new URL(str), aVar);
    }

    @Override // e.h.a.e0.b
    public InputStream a() throws IOException {
        return this.a.getInputStream();
    }

    @Override // e.h.a.e0.b
    public Map<String, List<String>> b() {
        return this.a.getHeaderFields();
    }

    @Override // e.h.a.e0.b
    public boolean c(String str, long j2) {
        return false;
    }

    @Override // e.h.a.e0.b
    public int d() throws IOException {
        URLConnection uRLConnection = this.a;
        if (uRLConnection instanceof HttpURLConnection) {
            return ((HttpURLConnection) uRLConnection).getResponseCode();
        }
        return 0;
    }

    @Override // e.h.a.e0.b
    public String e(String str) {
        return this.a.getHeaderField(str);
    }

    @Override // e.h.a.e0.b
    public void execute() throws IOException {
        this.a.connect();
    }

    @Override // e.h.a.e0.b
    public void f(String str, String str2) {
        this.a.addRequestProperty(str, str2);
    }

    @Override // e.h.a.e0.b
    public void g() {
        try {
            this.a.getInputStream().close();
        } catch (IOException unused) {
        }
    }

    @Override // e.h.a.e0.b
    public boolean h(String str) throws ProtocolException {
        URLConnection uRLConnection = this.a;
        if (!(uRLConnection instanceof HttpURLConnection)) {
            return false;
        }
        ((HttpURLConnection) uRLConnection).setRequestMethod(str);
        return true;
    }

    @Override // e.h.a.e0.b
    public Map<String, List<String>> i() {
        return this.a.getRequestProperties();
    }

    public c(URL url, a aVar) throws IOException {
        if (aVar == null || a.a(aVar) == null) {
            this.a = url.openConnection();
        } else {
            this.a = url.openConnection(a.a(aVar));
        }
        if (aVar != null) {
            if (a.b(aVar) != null) {
                this.a.setReadTimeout(a.b(aVar).intValue());
            }
            if (a.c(aVar) != null) {
                this.a.setConnectTimeout(a.c(aVar).intValue());
            }
        }
    }
}
