package kotlin.text;

import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlin.h0.d, reason: from Kotlin metadata */
/* JADX INFO: compiled from: Charsets.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000bR\u0010\u0010\u0010\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lkotlin/text/Charsets;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "ISO_8859_1", "Ljava/nio/charset/Charset;", "US_ASCII", "UTF_16", "UTF_16BE", "UTF_16LE", "UTF_32", "UTF32", "()Ljava/nio/charset/Charset;", "UTF_32BE", "UTF32_BE", "UTF_32LE", "UTF32_LE", "UTF_8", "utf_32", "utf_32be", "utf_32le", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Charsets {
    public static final Charsets a = new Charsets();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Charset f25054b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Charset f25055c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Charset f25056d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Charset f25057e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Charset f25058f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Charset f25059g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static Charset f25060h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static Charset f25061i;

    static {
        Charset charsetForName = Charset.forName("UTF-8");
        m.e(charsetForName, "forName(\"UTF-8\")");
        f25054b = charsetForName;
        Charset charsetForName2 = Charset.forName("UTF-16");
        m.e(charsetForName2, "forName(\"UTF-16\")");
        f25055c = charsetForName2;
        Charset charsetForName3 = Charset.forName("UTF-16BE");
        m.e(charsetForName3, "forName(\"UTF-16BE\")");
        f25056d = charsetForName3;
        Charset charsetForName4 = Charset.forName("UTF-16LE");
        m.e(charsetForName4, "forName(\"UTF-16LE\")");
        f25057e = charsetForName4;
        Charset charsetForName5 = Charset.forName("US-ASCII");
        m.e(charsetForName5, "forName(\"US-ASCII\")");
        f25058f = charsetForName5;
        Charset charsetForName6 = Charset.forName("ISO-8859-1");
        m.e(charsetForName6, "forName(\"ISO-8859-1\")");
        f25059g = charsetForName6;
    }

    private Charsets() {
    }

    public final Charset a() {
        Charset charset = f25061i;
        if (charset != null) {
            return charset;
        }
        Charset charsetForName = Charset.forName("UTF-32BE");
        m.e(charsetForName, "forName(\"UTF-32BE\")");
        f25061i = charsetForName;
        return charsetForName;
    }

    public final Charset b() {
        Charset charset = f25060h;
        if (charset != null) {
            return charset;
        }
        Charset charsetForName = Charset.forName("UTF-32LE");
        m.e(charsetForName, "forName(\"UTF-32LE\")");
        f25060h = charsetForName;
        return charsetForName;
    }
}
