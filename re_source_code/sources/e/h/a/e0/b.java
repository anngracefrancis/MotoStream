package e.h.a.e0;

import java.io.IOException;
import java.io.InputStream;
import java.net.ProtocolException;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: FileDownloadConnection.java */
/* JADX INFO: loaded from: classes2.dex */
public interface b {
    InputStream a() throws IOException;

    Map<String, List<String>> b();

    boolean c(String str, long j2);

    int d() throws IOException;

    String e(String str);

    void execute() throws IOException;

    void f(String str, String str2);

    void g();

    boolean h(String str) throws ProtocolException;

    Map<String, List<String>> i();
}
