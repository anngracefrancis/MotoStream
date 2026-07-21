package j;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/* JADX INFO: compiled from: ByteString.kt */
/* JADX INFO: loaded from: classes3.dex */
public class i implements Serializable, Comparable<i> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private transient int f22843h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private transient String f22844i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final byte[] f22845j;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f22842g = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final i f22841f = new i(new byte[0]);

    /* JADX INFO: compiled from: ByteString.kt */
    public static final class a {
        private a() {
        }

        public static /* synthetic */ i f(a aVar, byte[] bArr, int i2, int i3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i2 = 0;
            }
            if ((i4 & 2) != 0) {
                i3 = bArr.length;
            }
            return aVar.e(bArr, i2, i3);
        }

        public final i a(String str) {
            kotlin.jvm.internal.m.f(str, "$this$decodeBase64");
            byte[] bArrA = j.a.a(str);
            if (bArrA != null) {
                return new i(bArrA);
            }
            return null;
        }

        public final i b(String str) {
            kotlin.jvm.internal.m.f(str, "$this$decodeHex");
            if (!(str.length() % 2 == 0)) {
                throw new IllegalArgumentException(("Unexpected hex string: " + str).toString());
            }
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) ((j.g0.b.e(str.charAt(i3)) << 4) + j.g0.b.e(str.charAt(i3 + 1)));
            }
            return new i(bArr);
        }

        public final i c(String str, Charset charset) {
            kotlin.jvm.internal.m.f(str, "$this$encode");
            kotlin.jvm.internal.m.f(charset, "charset");
            byte[] bytes = str.getBytes(charset);
            kotlin.jvm.internal.m.e(bytes, "(this as java.lang.String).getBytes(charset)");
            return new i(bytes);
        }

        public final i d(String str) {
            kotlin.jvm.internal.m.f(str, "$this$encodeUtf8");
            i iVar = new i(b.a(str));
            iVar.M(str);
            return iVar;
        }

        public final i e(byte[] bArr, int i2, int i3) {
            kotlin.jvm.internal.m.f(bArr, "$this$toByteString");
            c.b(bArr.length, i2, i3);
            return new i(kotlin.collections.m.h(bArr, i2, i3 + i2));
        }

        public final i g(InputStream inputStream, int i2) throws IOException {
            kotlin.jvm.internal.m.f(inputStream, "$this$readByteString");
            int i3 = 0;
            if (!(i2 >= 0)) {
                throw new IllegalArgumentException(("byteCount < 0: " + i2).toString());
            }
            byte[] bArr = new byte[i2];
            while (i3 < i2) {
                int i4 = inputStream.read(bArr, i3, i2 - i3);
                if (i4 == -1) {
                    throw new EOFException();
                }
                i3 += i4;
            }
            return new i(bArr);
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public i(byte[] bArr) {
        kotlin.jvm.internal.m.f(bArr, "data");
        this.f22845j = bArr;
    }

    public static final i q(String str) {
        return f22842g.b(str);
    }

    private final void readObject(ObjectInputStream objectInputStream) throws IllegalAccessException, NoSuchFieldException, IOException {
        i iVarG = f22842g.g(objectInputStream, objectInputStream.readInt());
        Field declaredField = i.class.getDeclaredField("j");
        kotlin.jvm.internal.m.e(declaredField, "field");
        declaredField.setAccessible(true);
        declaredField.set(this, iVarG.f22845j);
    }

    public static final i v(String str) {
        return f22842g.d(str);
    }

    private final void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.f22845j.length);
        objectOutputStream.write(this.f22845j);
    }

    public final int A() {
        return this.f22843h;
    }

    public int D() {
        return y().length;
    }

    public final String E() {
        return this.f22844i;
    }

    public String F() {
        char[] cArr = new char[y().length * 2];
        int i2 = 0;
        for (byte b2 : y()) {
            int i3 = i2 + 1;
            cArr[i2] = j.g0.b.f()[(b2 >> 4) & 15];
            i2 = i3 + 1;
            cArr[i3] = j.g0.b.f()[b2 & 15];
        }
        return new String(cArr);
    }

    public byte[] G() {
        return y();
    }

    public byte H(int i2) {
        return y()[i2];
    }

    public final i I() {
        return u("MD5");
    }

    public boolean J(int i2, i iVar, int i3, int i4) {
        kotlin.jvm.internal.m.f(iVar, "other");
        return iVar.K(i3, y(), i2, i4);
    }

    public boolean K(int i2, byte[] bArr, int i3, int i4) {
        kotlin.jvm.internal.m.f(bArr, "other");
        return i2 >= 0 && i2 <= y().length - i4 && i3 >= 0 && i3 <= bArr.length - i4 && c.a(y(), i2, bArr, i3, i4);
    }

    public final void L(int i2) {
        this.f22843h = i2;
    }

    public final void M(String str) {
        this.f22844i = str;
    }

    public final i N() {
        return u("SHA-1");
    }

    public final i O() {
        return u("SHA-256");
    }

    public final int P() {
        return D();
    }

    public final boolean Q(i iVar) {
        kotlin.jvm.internal.m.f(iVar, "prefix");
        return J(0, iVar, 0, iVar.P());
    }

    public i R() {
        byte b2;
        for (int i2 = 0; i2 < y().length; i2++) {
            byte b3 = y()[i2];
            byte b4 = (byte) 65;
            if (b3 >= b4 && b3 <= (b2 = (byte) 90)) {
                byte[] bArrY = y();
                byte[] bArrCopyOf = Arrays.copyOf(bArrY, bArrY.length);
                kotlin.jvm.internal.m.e(bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
                bArrCopyOf[i2] = (byte) (b3 + 32);
                for (int i3 = i2 + 1; i3 < bArrCopyOf.length; i3++) {
                    byte b5 = bArrCopyOf[i3];
                    if (b5 >= b4 && b5 <= b2) {
                        bArrCopyOf[i3] = (byte) (b5 + 32);
                    }
                }
                return new i(bArrCopyOf);
            }
        }
        return this;
    }

    public String S() {
        String strE = E();
        if (strE != null) {
            return strE;
        }
        String strB = b.b(G());
        M(strB);
        return strB;
    }

    public void T(f fVar, int i2, int i3) {
        kotlin.jvm.internal.m.f(fVar, "buffer");
        j.g0.b.d(this, fVar, i2, i3);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            if (iVar.P() == y().length && iVar.K(0, y(), 0, y().length)) {
                return true;
            }
        }
        return false;
    }

    public String g() {
        return j.a.c(y(), null, 1, null);
    }

    public int hashCode() {
        int iA = A();
        if (iA != 0) {
            return iA;
        }
        int iHashCode = Arrays.hashCode(y());
        L(iHashCode);
        return iHashCode;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0030 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:14:0x0032 A[ORIG_RETURN, RETURN] */
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public int compareTo(i iVar) {
        kotlin.jvm.internal.m.f(iVar, "other");
        int iP = P();
        int iP2 = iVar.P();
        int iMin = Math.min(iP, iP2);
        for (int i2 = 0; i2 < iMin; i2++) {
            int iX = x(i2) & 255;
            int iX2 = iVar.x(i2) & 255;
            if (iX != iX2) {
                if (iX < iX2) {
                    return -1;
                }
                return 1;
            }
        }
        if (iP == iP2) {
            return 0;
        }
        if (iP < iP2) {
            return -1;
        }
        return 1;
    }

    public String toString() {
        if (y().length == 0) {
            return "[size=0]";
        }
        int iC = j.g0.b.c(y(), 64);
        if (iC == -1) {
            if (y().length <= 64) {
                return "[hex=" + F() + ']';
            }
            StringBuilder sb = new StringBuilder();
            sb.append("[size=");
            sb.append(y().length);
            sb.append(" hex=");
            if (64 <= y().length) {
                sb.append((64 == y().length ? this : new i(kotlin.collections.m.h(y(), 0, 64))).F());
                sb.append("…]");
                return sb.toString();
            }
            throw new IllegalArgumentException(("endIndex > length(" + y().length + ')').toString());
        }
        String strS = S();
        if (strS == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = strS.substring(0, iC);
        kotlin.jvm.internal.m.e(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        String strA = kotlin.text.u.A(kotlin.text.u.A(kotlin.text.u.A(strSubstring, "\\", "\\\\", false, 4, null), "\n", "\\n", false, 4, null), "\r", "\\r", false, 4, null);
        if (iC >= strS.length()) {
            return "[text=" + strA + ']';
        }
        return "[size=" + y().length + " text=" + strA + "…]";
    }

    public i u(String str) throws NoSuchAlgorithmException {
        kotlin.jvm.internal.m.f(str, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        messageDigest.update(this.f22845j, 0, P());
        byte[] bArrDigest = messageDigest.digest();
        kotlin.jvm.internal.m.e(bArrDigest, "digestBytes");
        return new i(bArrDigest);
    }

    public final byte x(int i2) {
        return H(i2);
    }

    public final byte[] y() {
        return this.f22845j;
    }
}
