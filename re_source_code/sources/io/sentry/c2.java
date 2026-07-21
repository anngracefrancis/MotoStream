package io.sentry;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.Map;

/* JADX INFO: compiled from: ISerializer.java */
/* JADX INFO: loaded from: classes2.dex */
public interface c2 {
    <T> void a(T t, Writer writer) throws IOException;

    void b(h4 h4Var, OutputStream outputStream) throws Exception;

    <T> T c(Reader reader, Class<T> cls);

    h4 d(InputStream inputStream);

    <T, R> T e(Reader reader, Class<T> cls, l2<R> l2Var);

    String f(Map<String, Object> map) throws Exception;
}
