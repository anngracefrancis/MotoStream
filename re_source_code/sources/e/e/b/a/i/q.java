package e.e.b.a.i;

import android.util.Base64;
import com.google.auto.value.AutoValue;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: TransportContext.java */
/* JADX INFO: loaded from: classes2.dex */
@AutoValue
public abstract class q {

    /* JADX INFO: compiled from: TransportContext.java */
    @AutoValue.Builder
    public static abstract class a {
        public abstract q a();

        public abstract a b(String str);

        public abstract a c(byte[] bArr);

        public abstract a d(e.e.b.a.d dVar);
    }

    public static a a() {
        return new e.b().d(e.e.b.a.d.DEFAULT);
    }

    public abstract String b();

    public abstract byte[] c();

    public abstract e.e.b.a.d d();

    public boolean e() {
        return c() != null;
    }

    public q f(e.e.b.a.d dVar) {
        return a().b(b()).d(dVar).c(c()).a();
    }

    public final String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = b();
        objArr[1] = d();
        objArr[2] = c() == null ? HttpUrl.FRAGMENT_ENCODE_SET : Base64.encodeToString(c(), 2);
        return String.format("TransportContext(%s, %s, %s)", objArr);
    }
}
