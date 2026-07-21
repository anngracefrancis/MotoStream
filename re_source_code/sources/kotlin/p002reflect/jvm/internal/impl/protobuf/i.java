package kotlin.p002reflect.jvm.internal.impl.protobuf;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: Internal.java */
/* JADX INFO: loaded from: classes3.dex */
public class i {
    public static final byte[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ByteBuffer f25439b;

    /* JADX INFO: compiled from: Internal.java */
    public interface a {
        int f();
    }

    /* JADX INFO: compiled from: Internal.java */
    public interface b<T extends a> {
        T a(int i2);
    }

    static {
        byte[] bArr = new byte[0];
        a = bArr;
        f25439b = ByteBuffer.wrap(bArr);
    }

    public static boolean a(byte[] bArr) {
        return v.e(bArr);
    }

    public static String b(byte[] bArr) {
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("UTF-8 not supported?", e2);
        }
    }
}
