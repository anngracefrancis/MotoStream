package androidx.fragment.app;

import android.util.Log;
import java.io.Writer;

/* JADX INFO: compiled from: LogWriter.java */
/* JADX INFO: loaded from: classes.dex */
final class z extends Writer {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f1714f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private StringBuilder f1715g = new StringBuilder(128);

    z(String str) {
        this.f1714f = str;
    }

    private void a() {
        if (this.f1715g.length() > 0) {
            Log.d(this.f1714f, this.f1715g.toString());
            StringBuilder sb = this.f1715g;
            sb.delete(0, sb.length());
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        a();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            char c2 = cArr[i2 + i4];
            if (c2 == '\n') {
                a();
            } else {
                this.f1715g.append(c2);
            }
        }
    }
}
