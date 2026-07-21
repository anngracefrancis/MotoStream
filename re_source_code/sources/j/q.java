package j;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/* JADX INFO: loaded from: classes3.dex */
public final class q {
    public static final b0 a(File file) throws FileNotFoundException {
        return r.b(file);
    }

    public static final b0 b() {
        return s.a();
    }

    public static final g c(b0 b0Var) {
        return s.b(b0Var);
    }

    public static final h d(d0 d0Var) {
        return s.c(d0Var);
    }

    public static final boolean e(AssertionError assertionError) {
        return r.c(assertionError);
    }

    public static final b0 f(File file, boolean z) throws FileNotFoundException {
        return r.d(file, z);
    }

    public static final b0 g(OutputStream outputStream) {
        return r.e(outputStream);
    }

    public static final b0 h(Socket socket) throws IOException {
        return r.f(socket);
    }

    public static final d0 j(File file) throws FileNotFoundException {
        return r.h(file);
    }

    public static final d0 k(InputStream inputStream) {
        return r.i(inputStream);
    }

    public static final d0 l(Socket socket) throws IOException {
        return r.j(socket);
    }
}
