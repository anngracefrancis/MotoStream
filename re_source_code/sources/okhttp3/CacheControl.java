package okhttp3;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.text.u;
import kotlin.text.v;
import okhttp3.internal.Util;

/* JADX INFO: compiled from: CacheControl.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u0000 %2\u00020\u0001:\u0002&%Bs\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u001e\u001a\u00020\u0002\u0012\u0006\u0010\"\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\b\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b#\u0010$J\u000f\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\bH\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\r\u001a\u00020\bH\u0007¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\u000f\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u000e\u0010\u0004J\u000f\u0010\u0011\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0010\u0010\nJ\u000f\u0010\u0013\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0012\u0010\nJ\u000f\u0010\u0015\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0014\u0010\u0004J\u000f\u0010\u0017\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0016\u0010\u0004J\u000f\u0010\u0019\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0018\u0010\u0004J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u0019\u0010\r\u001a\u00020\b8\u0007@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b\r\u0010\nR\u0019\u0010\u001e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001e\u0010\u0004R\u0018\u0010 \u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0019\u0010\u000b\u001a\u00020\b8\u0007@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001d\u001a\u0004\b\u000b\u0010\nR\u0019\u0010\"\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010\u001f\u001a\u0004\b\"\u0010\u0004R\u0019\u0010\u0017\u001a\u00020\u00028\u0007@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u001f\u001a\u0004\b\u0017\u0010\u0004R\u0019\u0010\u0019\u001a\u00020\u00028\u0007@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001f\u001a\u0004\b\u0019\u0010\u0004R\u0019\u0010\u0015\u001a\u00020\u00028\u0007@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u001f\u001a\u0004\b\u0015\u0010\u0004R\u0019\u0010\u0013\u001a\u00020\b8\u0007@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u001d\u001a\u0004\b\u0013\u0010\nR\u0019\u0010\u0005\u001a\u00020\u00028\u0007@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001f\u001a\u0004\b\u0005\u0010\u0004R\u0019\u0010\u0011\u001a\u00020\b8\u0007@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001d\u001a\u0004\b\u0011\u0010\nR\u0019\u0010\u0007\u001a\u00020\u00028\u0007@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001f\u001a\u0004\b\u0007\u0010\u0004R\u0019\u0010\u000f\u001a\u00020\u00028\u0007@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001f\u001a\u0004\b\u000f\u0010\u0004¨\u0006'"}, d2 = {"Lokhttp3/CacheControl;", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "-deprecated_noCache", "()Z", "noCache", "-deprecated_noStore", "noStore", HttpUrl.FRAGMENT_ENCODE_SET, "-deprecated_maxAgeSeconds", "()I", "maxAgeSeconds", "-deprecated_sMaxAgeSeconds", "sMaxAgeSeconds", "-deprecated_mustRevalidate", "mustRevalidate", "-deprecated_maxStaleSeconds", "maxStaleSeconds", "-deprecated_minFreshSeconds", "minFreshSeconds", "-deprecated_onlyIfCached", "onlyIfCached", "-deprecated_noTransform", "noTransform", "-deprecated_immutable", "immutable", HttpUrl.FRAGMENT_ENCODE_SET, "toString", "()Ljava/lang/String;", "I", "isPrivate", "Z", "headerValue", "Ljava/lang/String;", "isPublic", "<init>", "(ZZIIZZZIIZZZLjava/lang/String;)V", "Companion", "Builder", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class CacheControl {
    private String headerValue;
    private final boolean immutable;
    private final boolean isPrivate;
    private final boolean isPublic;
    private final int maxAgeSeconds;
    private final int maxStaleSeconds;
    private final int minFreshSeconds;
    private final boolean mustRevalidate;
    private final boolean noCache;
    private final boolean noStore;
    private final boolean noTransform;
    private final boolean onlyIfCached;
    private final int sMaxAgeSeconds;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final CacheControl FORCE_NETWORK = new Builder().noCache().build();
    public static final CacheControl FORCE_CACHE = new Builder().onlyIfCached().maxStale(Integer.MAX_VALUE, TimeUnit.SECONDS).build();

    /* JADX INFO: compiled from: CacheControl.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u0013\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0006\u001a\u00020\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0000¢\u0006\u0004\b\b\u0010\u0007J\u001d\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\t\u0010\fJ\u001d\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\fJ\u001d\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\fJ\r\u0010\u000f\u001a\u00020\u0000¢\u0006\u0004\b\u000f\u0010\u0007J\r\u0010\u0010\u001a\u00020\u0000¢\u0006\u0004\b\u0010\u0010\u0007J\r\u0010\u0011\u001a\u00020\u0000¢\u0006\u0004\b\u0011\u0010\u0007J\r\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0011\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0016R\u0016\u0010\u0006\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0016R\u0016\u0010\b\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0016R\u0016\u0010\u000f\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0016R\u0016\u0010\u0010\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0018¨\u0006\u001d"}, d2 = {"Lokhttp3/CacheControl$Builder;", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "clampToInt", "(J)I", "noCache", "()Lokhttp3/CacheControl$Builder;", "noStore", "maxAge", "Ljava/util/concurrent/TimeUnit;", "timeUnit", "(ILjava/util/concurrent/TimeUnit;)Lokhttp3/CacheControl$Builder;", "maxStale", "minFresh", "onlyIfCached", "noTransform", "immutable", "Lokhttp3/CacheControl;", "build", "()Lokhttp3/CacheControl;", HttpUrl.FRAGMENT_ENCODE_SET, "Z", "minFreshSeconds", "I", "maxStaleSeconds", "maxAgeSeconds", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Builder {
        private boolean immutable;
        private int maxAgeSeconds = -1;
        private int maxStaleSeconds = -1;
        private int minFreshSeconds = -1;
        private boolean noCache;
        private boolean noStore;
        private boolean noTransform;
        private boolean onlyIfCached;

        private final int clampToInt(long j2) {
            if (j2 > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            return (int) j2;
        }

        public final CacheControl build() {
            return new CacheControl(this.noCache, this.noStore, this.maxAgeSeconds, -1, false, false, false, this.maxStaleSeconds, this.minFreshSeconds, this.onlyIfCached, this.noTransform, this.immutable, null, null);
        }

        public final Builder immutable() {
            this.immutable = true;
            return this;
        }

        public final Builder maxAge(int maxAge, TimeUnit timeUnit) {
            m.f(timeUnit, "timeUnit");
            if (maxAge >= 0) {
                this.maxAgeSeconds = clampToInt(timeUnit.toSeconds(maxAge));
                return this;
            }
            throw new IllegalArgumentException(("maxAge < 0: " + maxAge).toString());
        }

        public final Builder maxStale(int maxStale, TimeUnit timeUnit) {
            m.f(timeUnit, "timeUnit");
            if (maxStale >= 0) {
                this.maxStaleSeconds = clampToInt(timeUnit.toSeconds(maxStale));
                return this;
            }
            throw new IllegalArgumentException(("maxStale < 0: " + maxStale).toString());
        }

        public final Builder minFresh(int minFresh, TimeUnit timeUnit) {
            m.f(timeUnit, "timeUnit");
            if (minFresh >= 0) {
                this.minFreshSeconds = clampToInt(timeUnit.toSeconds(minFresh));
                return this;
            }
            throw new IllegalArgumentException(("minFresh < 0: " + minFresh).toString());
        }

        public final Builder noCache() {
            this.noCache = true;
            return this;
        }

        public final Builder noStore() {
            this.noStore = true;
            return this;
        }

        public final Builder noTransform() {
            this.noTransform = true;
            return this;
        }

        public final Builder onlyIfCached() {
            this.onlyIfCached = true;
            return this;
        }
    }

    /* JADX INFO: compiled from: CacheControl.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0006\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\n8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\n8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u000e¨\u0006\u0012"}, d2 = {"Lokhttp3/CacheControl$Companion;", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "characters", HttpUrl.FRAGMENT_ENCODE_SET, "startIndex", "indexOfElement", "(Ljava/lang/String;Ljava/lang/String;I)I", "Lokhttp3/Headers;", "headers", "Lokhttp3/CacheControl;", "parse", "(Lokhttp3/Headers;)Lokhttp3/CacheControl;", "FORCE_CACHE", "Lokhttp3/CacheControl;", "FORCE_NETWORK", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        private final int indexOfElement(String str, String str2, int i2) {
            int length = str.length();
            while (i2 < length) {
                if (v.I(str2, str.charAt(i2), false, 2, null)) {
                    return i2;
                }
                i2++;
            }
            return str.length();
        }

        static /* synthetic */ int indexOfElement$default(Companion companion, String str, String str2, int i2, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                i2 = 0;
            }
            return companion.indexOfElement(str, str2, i2);
        }

        /* JADX WARN: Code duplicated, block: B:100:0x016c A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:15:0x004a  */
        /* JADX WARN: Code duplicated, block: B:17:0x005d  */
        /* JADX WARN: Code duplicated, block: B:19:0x006d  */
        /* JADX WARN: Code duplicated, block: B:34:0x00cf  */
        /* JADX WARN: Code duplicated, block: B:38:0x00dd  */
        /* JADX WARN: Code duplicated, block: B:39:0x00e1  */
        /* JADX WARN: Code duplicated, block: B:41:0x00e9  */
        /* JADX WARN: Code duplicated, block: B:42:0x00ed  */
        /* JADX WARN: Code duplicated, block: B:44:0x00f5  */
        /* JADX WARN: Code duplicated, block: B:46:0x00fd  */
        /* JADX WARN: Code duplicated, block: B:48:0x0106  */
        /* JADX WARN: Code duplicated, block: B:49:0x010b  */
        /* JADX WARN: Code duplicated, block: B:51:0x0113  */
        /* JADX WARN: Code duplicated, block: B:52:0x0116  */
        /* JADX WARN: Code duplicated, block: B:54:0x011e  */
        /* JADX WARN: Code duplicated, block: B:55:0x0121  */
        /* JADX WARN: Code duplicated, block: B:57:0x0129  */
        /* JADX WARN: Code duplicated, block: B:58:0x012d  */
        /* JADX WARN: Code duplicated, block: B:60:0x0135  */
        /* JADX WARN: Code duplicated, block: B:61:0x013d  */
        /* JADX WARN: Code duplicated, block: B:63:0x0145  */
        /* JADX WARN: Code duplicated, block: B:64:0x014b  */
        /* JADX WARN: Code duplicated, block: B:66:0x0154  */
        /* JADX WARN: Code duplicated, block: B:67:0x0157  */
        /* JADX WARN: Code duplicated, block: B:69:0x015f  */
        /* JADX WARN: Code duplicated, block: B:70:0x0162  */
        /* JADX WARN: Code duplicated, block: B:72:0x016a  */
        /* JADX WARN: Code duplicated, block: B:85:0x0175 A[SYNTHETIC] */
        public final CacheControl parse(Headers headers) {
            int i2;
            int i3;
            int iIndexOfElement;
            String strSubstring;
            String string;
            boolean z;
            int iIndexOfElement2;
            String string2;
            Headers headers2 = headers;
            m.f(headers2, "headers");
            int size = headers.size();
            boolean z2 = true;
            int i4 = 0;
            boolean z3 = true;
            String str = null;
            boolean z4 = false;
            boolean z5 = false;
            int nonNegativeInt = -1;
            int nonNegativeInt2 = -1;
            boolean z6 = false;
            boolean z7 = false;
            boolean z8 = false;
            int nonNegativeInt3 = -1;
            int nonNegativeInt4 = -1;
            boolean z9 = false;
            boolean z10 = false;
            boolean z11 = false;
            while (i4 < size) {
                String strName = headers2.name(i4);
                String strValue = headers2.value(i4);
                if (u.q(strName, "Cache-Control", z2)) {
                    if (str == null) {
                        str = strValue;
                    }
                    i3 = 0;
                    while (i3 < strValue.length()) {
                        iIndexOfElement = indexOfElement(strValue, "=,;", i3);
                        strSubstring = strValue.substring(i3, iIndexOfElement);
                        m.e(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        if (strSubstring != null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                        }
                        string = v.O0(strSubstring).toString();
                        int i5 = size;
                        if (iIndexOfElement != strValue.length()) {
                            z = z3;
                            if (strValue.charAt(iIndexOfElement) == ',' && strValue.charAt(iIndexOfElement) != ';') {
                                int iIndexOfNonWhitespace = Util.indexOfNonWhitespace(strValue, iIndexOfElement + 1);
                                if (iIndexOfNonWhitespace >= strValue.length() || strValue.charAt(iIndexOfNonWhitespace) != '\"') {
                                    iIndexOfElement2 = indexOfElement(strValue, ",;", iIndexOfNonWhitespace);
                                    String strSubstring2 = strValue.substring(iIndexOfNonWhitespace, iIndexOfElement2);
                                    m.e(strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                    if (strSubstring2 == null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                                    }
                                    string2 = v.O0(strSubstring2).toString();
                                } else {
                                    int i6 = iIndexOfNonWhitespace + 1;
                                    int iV = v.V(strValue, '\"', i6, false, 4, null);
                                    string2 = strValue.substring(i6, iV);
                                    m.e(string2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                    iIndexOfElement2 = iV + 1;
                                }
                            }
                            z2 = true;
                            if (u.q("no-cache", string, true)) {
                                z4 = true;
                            } else if (u.q("no-store", string, true)) {
                                z5 = true;
                            } else if (u.q("max-age", string, true)) {
                                nonNegativeInt = Util.toNonNegativeInt(string2, -1);
                            } else if (u.q("s-maxage", string, true)) {
                                nonNegativeInt2 = Util.toNonNegativeInt(string2, -1);
                            } else if (u.q("private", string, true)) {
                                z6 = true;
                            } else if (u.q("public", string, true)) {
                                z7 = true;
                            } else if (u.q("must-revalidate", string, true)) {
                                z8 = true;
                            } else if (u.q("max-stale", string, true)) {
                                nonNegativeInt3 = Util.toNonNegativeInt(string2, Integer.MAX_VALUE);
                            } else if (u.q("min-fresh", string, true)) {
                                nonNegativeInt4 = Util.toNonNegativeInt(string2, -1);
                            } else if (u.q("only-if-cached", string, true)) {
                                z9 = true;
                            } else if (u.q("no-transform", string, true)) {
                                z10 = true;
                            } else if (u.q("immutable", string, true)) {
                                z11 = true;
                            }
                            i3 = iIndexOfElement2;
                            size = i5;
                            z3 = z;
                        } else {
                            z = z3;
                        }
                        iIndexOfElement2 = iIndexOfElement + 1;
                        string2 = null;
                        z2 = true;
                        if (u.q("no-cache", string, true)) {
                            z4 = true;
                        } else if (u.q("no-store", string, true)) {
                            z5 = true;
                        } else if (u.q("max-age", string, true)) {
                            nonNegativeInt = Util.toNonNegativeInt(string2, -1);
                        } else if (u.q("s-maxage", string, true)) {
                            nonNegativeInt2 = Util.toNonNegativeInt(string2, -1);
                        } else if (u.q("private", string, true)) {
                            z6 = true;
                        } else if (u.q("public", string, true)) {
                            z7 = true;
                        } else if (u.q("must-revalidate", string, true)) {
                            z8 = true;
                        } else if (u.q("max-stale", string, true)) {
                            nonNegativeInt3 = Util.toNonNegativeInt(string2, Integer.MAX_VALUE);
                        } else if (u.q("min-fresh", string, true)) {
                            nonNegativeInt4 = Util.toNonNegativeInt(string2, -1);
                        } else if (u.q("only-if-cached", string, true)) {
                            z9 = true;
                        } else if (u.q("no-transform", string, true)) {
                            z10 = true;
                        } else if (u.q("immutable", string, true)) {
                            z11 = true;
                        }
                        i3 = iIndexOfElement2;
                        size = i5;
                        z3 = z;
                    }
                    i2 = size;
                    i4++;
                    headers2 = headers;
                    size = i2;
                } else {
                    if (!u.q(strName, "Pragma", z2)) {
                        i2 = size;
                    }
                    i4++;
                    headers2 = headers;
                    size = i2;
                }
                z3 = false;
                i3 = 0;
                while (i3 < strValue.length()) {
                    iIndexOfElement = indexOfElement(strValue, "=,;", i3);
                    strSubstring = strValue.substring(i3, iIndexOfElement);
                    m.e(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    if (strSubstring != null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                    }
                    string = v.O0(strSubstring).toString();
                    int i7 = size;
                    if (iIndexOfElement != strValue.length()) {
                        z = z3;
                        if (strValue.charAt(iIndexOfElement) == ',') {
                        }
                        z2 = true;
                        if (u.q("no-cache", string, true)) {
                            z4 = true;
                        } else if (u.q("no-store", string, true)) {
                            z5 = true;
                        } else if (u.q("max-age", string, true)) {
                            nonNegativeInt = Util.toNonNegativeInt(string2, -1);
                        } else if (u.q("s-maxage", string, true)) {
                            nonNegativeInt2 = Util.toNonNegativeInt(string2, -1);
                        } else if (u.q("private", string, true)) {
                            z6 = true;
                        } else if (u.q("public", string, true)) {
                            z7 = true;
                        } else if (u.q("must-revalidate", string, true)) {
                            z8 = true;
                        } else if (u.q("max-stale", string, true)) {
                            nonNegativeInt3 = Util.toNonNegativeInt(string2, Integer.MAX_VALUE);
                        } else if (u.q("min-fresh", string, true)) {
                            nonNegativeInt4 = Util.toNonNegativeInt(string2, -1);
                        } else if (u.q("only-if-cached", string, true)) {
                            z9 = true;
                        } else if (u.q("no-transform", string, true)) {
                            z10 = true;
                        } else if (u.q("immutable", string, true)) {
                            z11 = true;
                        }
                        i3 = iIndexOfElement2;
                        size = i7;
                        z3 = z;
                    } else {
                        z = z3;
                    }
                    iIndexOfElement2 = iIndexOfElement + 1;
                    string2 = null;
                    z2 = true;
                    if (u.q("no-cache", string, true)) {
                        z4 = true;
                    } else if (u.q("no-store", string, true)) {
                        z5 = true;
                    } else if (u.q("max-age", string, true)) {
                        nonNegativeInt = Util.toNonNegativeInt(string2, -1);
                    } else if (u.q("s-maxage", string, true)) {
                        nonNegativeInt2 = Util.toNonNegativeInt(string2, -1);
                    } else if (u.q("private", string, true)) {
                        z6 = true;
                    } else if (u.q("public", string, true)) {
                        z7 = true;
                    } else if (u.q("must-revalidate", string, true)) {
                        z8 = true;
                    } else if (u.q("max-stale", string, true)) {
                        nonNegativeInt3 = Util.toNonNegativeInt(string2, Integer.MAX_VALUE);
                    } else if (u.q("min-fresh", string, true)) {
                        nonNegativeInt4 = Util.toNonNegativeInt(string2, -1);
                    } else if (u.q("only-if-cached", string, true)) {
                        z9 = true;
                    } else if (u.q("no-transform", string, true)) {
                        z10 = true;
                    } else if (u.q("immutable", string, true)) {
                        z11 = true;
                    }
                    i3 = iIndexOfElement2;
                    size = i7;
                    z3 = z;
                }
                i2 = size;
                i4++;
                headers2 = headers;
                size = i2;
            }
            return new CacheControl(z4, z5, nonNegativeInt, nonNegativeInt2, z6, z7, z8, nonNegativeInt3, nonNegativeInt4, z9, z10, z11, !z3 ? null : str, null);
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    private CacheControl(boolean z, boolean z2, int i2, int i3, boolean z3, boolean z4, boolean z5, int i4, int i5, boolean z6, boolean z7, boolean z8, String str) {
        this.noCache = z;
        this.noStore = z2;
        this.maxAgeSeconds = i2;
        this.sMaxAgeSeconds = i3;
        this.isPrivate = z3;
        this.isPublic = z4;
        this.mustRevalidate = z5;
        this.maxStaleSeconds = i4;
        this.minFreshSeconds = i5;
        this.onlyIfCached = z6;
        this.noTransform = z7;
        this.immutable = z8;
        this.headerValue = str;
    }

    public static final CacheControl parse(Headers headers) {
        return INSTANCE.parse(headers);
    }

    /* JADX INFO: renamed from: -deprecated_immutable, reason: not valid java name and from getter */
    public final boolean getImmutable() {
        return this.immutable;
    }

    /* JADX INFO: renamed from: -deprecated_maxAgeSeconds, reason: not valid java name and from getter */
    public final int getMaxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    /* JADX INFO: renamed from: -deprecated_maxStaleSeconds, reason: not valid java name and from getter */
    public final int getMaxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    /* JADX INFO: renamed from: -deprecated_minFreshSeconds, reason: not valid java name and from getter */
    public final int getMinFreshSeconds() {
        return this.minFreshSeconds;
    }

    /* JADX INFO: renamed from: -deprecated_mustRevalidate, reason: not valid java name and from getter */
    public final boolean getMustRevalidate() {
        return this.mustRevalidate;
    }

    /* JADX INFO: renamed from: -deprecated_noCache, reason: not valid java name and from getter */
    public final boolean getNoCache() {
        return this.noCache;
    }

    /* JADX INFO: renamed from: -deprecated_noStore, reason: not valid java name and from getter */
    public final boolean getNoStore() {
        return this.noStore;
    }

    /* JADX INFO: renamed from: -deprecated_noTransform, reason: not valid java name and from getter */
    public final boolean getNoTransform() {
        return this.noTransform;
    }

    /* JADX INFO: renamed from: -deprecated_onlyIfCached, reason: not valid java name and from getter */
    public final boolean getOnlyIfCached() {
        return this.onlyIfCached;
    }

    /* JADX INFO: renamed from: -deprecated_sMaxAgeSeconds, reason: not valid java name and from getter */
    public final int getSMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    public final boolean immutable() {
        return this.immutable;
    }

    /* JADX INFO: renamed from: isPrivate, reason: from getter */
    public final boolean getIsPrivate() {
        return this.isPrivate;
    }

    /* JADX INFO: renamed from: isPublic, reason: from getter */
    public final boolean getIsPublic() {
        return this.isPublic;
    }

    public final int maxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    public final int maxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    public final int minFreshSeconds() {
        return this.minFreshSeconds;
    }

    public final boolean mustRevalidate() {
        return this.mustRevalidate;
    }

    public final boolean noCache() {
        return this.noCache;
    }

    public final boolean noStore() {
        return this.noStore;
    }

    public final boolean noTransform() {
        return this.noTransform;
    }

    public final boolean onlyIfCached() {
        return this.onlyIfCached;
    }

    public final int sMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    public String toString() {
        String str = this.headerValue;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        if (this.noCache) {
            sb.append("no-cache, ");
        }
        if (this.noStore) {
            sb.append("no-store, ");
        }
        if (this.maxAgeSeconds != -1) {
            sb.append("max-age=");
            sb.append(this.maxAgeSeconds);
            sb.append(", ");
        }
        if (this.sMaxAgeSeconds != -1) {
            sb.append("s-maxage=");
            sb.append(this.sMaxAgeSeconds);
            sb.append(", ");
        }
        if (this.isPrivate) {
            sb.append("private, ");
        }
        if (this.isPublic) {
            sb.append("public, ");
        }
        if (this.mustRevalidate) {
            sb.append("must-revalidate, ");
        }
        if (this.maxStaleSeconds != -1) {
            sb.append("max-stale=");
            sb.append(this.maxStaleSeconds);
            sb.append(", ");
        }
        if (this.minFreshSeconds != -1) {
            sb.append("min-fresh=");
            sb.append(this.minFreshSeconds);
            sb.append(", ");
        }
        if (this.onlyIfCached) {
            sb.append("only-if-cached, ");
        }
        if (this.noTransform) {
            sb.append("no-transform, ");
        }
        if (this.immutable) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
        sb.delete(sb.length() - 2, sb.length());
        String string = sb.toString();
        m.e(string, "StringBuilder().apply(builderAction).toString()");
        this.headerValue = string;
        return string;
    }

    public /* synthetic */ CacheControl(boolean z, boolean z2, int i2, int i3, boolean z3, boolean z4, boolean z5, int i4, int i5, boolean z6, boolean z7, boolean z8, String str, g gVar) {
        this(z, z2, i2, i3, z3, z4, z5, i4, i5, z6, z7, z8, str);
    }
}
