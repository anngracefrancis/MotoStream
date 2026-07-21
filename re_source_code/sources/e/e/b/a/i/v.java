package e.e.b.a.i;

import android.content.Context;
import e.e.b.a.i.b0.j.j0;
import java.io.Closeable;
import java.io.IOException;
import javax.inject.Singleton;

/* JADX INFO: compiled from: TransportRuntimeComponent.java */
/* JADX INFO: loaded from: classes2.dex */
@Singleton
abstract class v implements Closeable {

    /* JADX INFO: compiled from: TransportRuntimeComponent.java */
    interface a {
        a a(Context context);

        v c();
    }

    v() {
    }

    abstract j0 a();

    abstract u b();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        a().close();
    }
}
