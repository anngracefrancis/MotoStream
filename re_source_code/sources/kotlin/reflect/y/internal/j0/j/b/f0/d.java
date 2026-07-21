package kotlin.reflect.y.internal.j0.j.b.f0;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: BuiltInsResourceLoader.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public final InputStream a(String str) throws IOException {
        m.f(str, "path");
        ClassLoader classLoader = d.class.getClassLoader();
        if (classLoader == null) {
            return ClassLoader.getSystemResourceAsStream(str);
        }
        URL resource = classLoader.getResource(str);
        if (resource == null) {
            return null;
        }
        URLConnection uRLConnectionOpenConnection = resource.openConnection();
        uRLConnectionOpenConnection.setUseCaches(false);
        return uRLConnectionOpenConnection.getInputStream();
    }
}
