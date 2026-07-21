package j;

import kotlin.text.Charsets;

/* JADX INFO: compiled from: -Platform.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static final byte[] a(String str) {
        kotlin.jvm.internal.m.f(str, "$this$asUtf8ToByteArray");
        byte[] bytes = str.getBytes(Charsets.f25054b);
        kotlin.jvm.internal.m.e(bytes, "(this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    public static final String b(byte[] bArr) {
        kotlin.jvm.internal.m.f(bArr, "$this$toUtf8String");
        return new String(bArr, Charsets.f25054b);
    }
}
