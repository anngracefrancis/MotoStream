package io.sentry;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.Map;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: NoOpSerializer.java */
/* JADX INFO: loaded from: classes2.dex */
final class b3 implements c2 {
    private static final b3 a = new b3();

    private b3() {
    }

    public static b3 g() {
        return a;
    }

    @Override // io.sentry.c2
    public <T> void a(T t, Writer writer) throws IOException {
    }

    @Override // io.sentry.c2
    public void b(h4 h4Var, OutputStream outputStream) throws Exception {
    }

    @Override // io.sentry.c2
    public <T> T c(Reader reader, Class<T> cls) {
        return null;
    }

    @Override // io.sentry.c2
    public h4 d(InputStream inputStream) {
        return null;
    }

    @Override // io.sentry.c2
    public <T, R> T e(Reader reader, Class<T> cls, l2<R> l2Var) {
        return null;
    }

    @Override // io.sentry.c2
    public String f(Map<String, Object> map) throws Exception {
        return HttpUrl.FRAGMENT_ENCODE_SET;
    }
}
