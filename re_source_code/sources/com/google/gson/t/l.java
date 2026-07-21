package com.google.gson.t;

import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.MalformedJsonException;
import com.google.gson.t.n.n;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;

/* JADX INFO: compiled from: Streams.java */
/* JADX INFO: loaded from: classes2.dex */
public final class l {
    public static com.google.gson.j a(com.google.gson.stream.a aVar) throws JsonParseException {
        boolean z;
        try {
            try {
                aVar.Q();
                z = false;
                try {
                    return n.X.b(aVar);
                } catch (EOFException e2) {
                    e = e2;
                    if (z) {
                        return com.google.gson.k.a;
                    }
                    throw new JsonSyntaxException(e);
                }
            } catch (EOFException e3) {
                e = e3;
                z = true;
            }
        } catch (MalformedJsonException e4) {
            throw new JsonSyntaxException(e4);
        } catch (IOException e5) {
            throw new JsonIOException(e5);
        } catch (NumberFormatException e6) {
            throw new JsonSyntaxException(e6);
        }
    }

    public static void b(com.google.gson.j jVar, com.google.gson.stream.c cVar) throws IOException {
        n.X.d(cVar, jVar);
    }

    public static Writer c(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new a(appendable);
    }

    /* JADX INFO: compiled from: Streams.java */
    private static final class a extends Writer {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Appendable f20223f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final C0243a f20224g = new C0243a();

        /* JADX INFO: renamed from: com.google.gson.t.l$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Streams.java */
        static class C0243a implements CharSequence {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            char[] f20225f;

            C0243a() {
            }

            @Override // java.lang.CharSequence
            public char charAt(int i2) {
                return this.f20225f[i2];
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.f20225f.length;
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int i2, int i3) {
                return new String(this.f20225f, i2, i3 - i2);
            }
        }

        a(Appendable appendable) {
            this.f20223f = appendable;
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i2, int i3) throws IOException {
            C0243a c0243a = this.f20224g;
            c0243a.f20225f = cArr;
            this.f20223f.append(c0243a, i2, i3 + i2);
        }

        @Override // java.io.Writer
        public void write(int i2) throws IOException {
            this.f20223f.append((char) i2);
        }
    }
}
