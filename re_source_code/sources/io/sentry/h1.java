package io.sentry;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: EnvelopeReader.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class h1 implements s1 {
    private static final Charset a = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c2 f22421b;

    public h1(c2 c2Var) {
        this.f22421b = c2Var;
    }

    private i4 b(byte[] bArr, int i2, int i3) {
        StringReader stringReader = new StringReader(new String(bArr, i2, i3, a));
        try {
            i4 i4Var = (i4) this.f22421b.c(stringReader, i4.class);
            stringReader.close();
            return i4Var;
        } catch (Throwable th) {
            try {
                stringReader.close();
            } catch (Throwable unused) {
            }
            throw th;
        }
    }

    private k4 c(byte[] bArr, int i2, int i3) {
        StringReader stringReader = new StringReader(new String(bArr, i2, i3, a));
        try {
            k4 k4Var = (k4) this.f22421b.c(stringReader, k4.class);
            stringReader.close();
            return k4Var;
        } catch (Throwable th) {
            try {
                stringReader.close();
            } catch (Throwable unused) {
            }
            throw th;
        }
    }

    @Override // io.sentry.s1
    public h4 a(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i2 = -1;
        int i3 = 0;
        while (true) {
            try {
                int i4 = inputStream.read(bArr);
                if (i4 <= 0) {
                    break;
                }
                for (int i5 = 0; i2 == -1 && i5 < i4; i5++) {
                    if (bArr[i5] == 10) {
                        i2 = i3 + i5;
                        break;
                    }
                }
                byteArrayOutputStream.write(bArr, 0, i4);
                i3 += i4;
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable unused) {
                }
                throw th;
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (byteArray.length == 0) {
            throw new IllegalArgumentException("Empty stream.");
        }
        if (i2 == -1) {
            throw new IllegalArgumentException("Envelope contains no header.");
        }
        i4 i4VarB = b(byteArray, 0, i2);
        if (i4VarB == null) {
            throw new IllegalArgumentException("Envelope header is null.");
        }
        int i6 = i2 + 1;
        ArrayList arrayList = new ArrayList();
        while (true) {
            int i7 = i6;
            while (true) {
                if (i7 >= byteArray.length) {
                    i7 = -1;
                    break;
                }
                if (byteArray[i7] == 10) {
                    break;
                }
                i7++;
            }
            if (i7 == -1) {
                throw new IllegalArgumentException("Invalid envelope. Item at index '" + arrayList.size() + "'. has no header delimiter.");
            }
            k4 k4VarC = c(byteArray, i6, i7 - i6);
            if (k4VarC == null || k4VarC.a() <= 0) {
                throw new IllegalArgumentException("Item header at index '" + arrayList.size() + "' is null or empty.");
            }
            int iA = k4VarC.a() + i7 + 1;
            if (iA > byteArray.length) {
                throw new IllegalArgumentException("Invalid length for item at index '" + arrayList.size() + "'. Item is '" + iA + "' bytes. There are '" + byteArray.length + "' in the buffer.");
            }
            arrayList.add(new j4(k4VarC, Arrays.copyOfRange(byteArray, i7 + 1, iA)));
            if (iA == byteArray.length) {
                break;
            }
            i6 = iA + 1;
            if (i6 == byteArray.length) {
                if (byteArray[iA] == 10) {
                    break;
                }
                throw new IllegalArgumentException("Envelope has invalid data following an item.");
            }
        }
        h4 h4Var = new h4(i4VarB, arrayList);
        byteArrayOutputStream.close();
        return h4Var;
    }
}
