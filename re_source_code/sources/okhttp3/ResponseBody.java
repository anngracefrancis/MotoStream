package okhttp3;

import j.f;
import j.h;
import j.i;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.m;
import kotlin.text.Charsets;
import okhttp3.internal.Util;

/* JADX INFO: compiled from: ResponseBody.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000 +2\u00020\u0001:\u0002,+B\u0007¢\u0006\u0004\b*\u0010'JB\u0010\t\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0004H\u0082\b¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0011\u0010\u000f\u001a\u0004\u0018\u00010\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0005H&¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010 \u001a\u00020\u001f¢\u0006\u0004\b \u0010!J\r\u0010#\u001a\u00020\"¢\u0006\u0004\b#\u0010$J\u000f\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b&\u0010'R\u0018\u0010(\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006-"}, d2 = {"Lokhttp3/ResponseBody;", "Ljava/io/Closeable;", HttpUrl.FRAGMENT_ENCODE_SET, "T", "Lkotlin/Function1;", "Lj/h;", "consumer", HttpUrl.FRAGMENT_ENCODE_SET, "sizeMapper", "consumeSource", "(Lkotlin/a0/c/l;Lkotlin/a0/c/l;)Ljava/lang/Object;", "Ljava/nio/charset/Charset;", "charset", "()Ljava/nio/charset/Charset;", "Lokhttp3/MediaType;", "contentType", "()Lokhttp3/MediaType;", HttpUrl.FRAGMENT_ENCODE_SET, "contentLength", "()J", "Ljava/io/InputStream;", "byteStream", "()Ljava/io/InputStream;", "source", "()Lj/h;", HttpUrl.FRAGMENT_ENCODE_SET, "bytes", "()[B", "Lj/i;", "byteString", "()Lj/i;", "Ljava/io/Reader;", "charStream", "()Ljava/io/Reader;", HttpUrl.FRAGMENT_ENCODE_SET, "string", "()Ljava/lang/String;", "Lkotlin/u;", "close", "()V", "reader", "Ljava/io/Reader;", "<init>", "Companion", "BomAwareReader", "okhttp"}, k = 1, mv = {1, 4, 0})
public abstract class ResponseBody implements Closeable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Reader reader;

    /* JADX INFO: compiled from: ResponseBody.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lokhttp3/ResponseBody$BomAwareReader;", "Ljava/io/Reader;", HttpUrl.FRAGMENT_ENCODE_SET, "cbuf", HttpUrl.FRAGMENT_ENCODE_SET, "off", "len", "read", "([CII)I", "Lkotlin/u;", "close", "()V", "Lj/h;", "source", "Lj/h;", "Ljava/nio/charset/Charset;", "charset", "Ljava/nio/charset/Charset;", "delegate", "Ljava/io/Reader;", HttpUrl.FRAGMENT_ENCODE_SET, "closed", "Z", "<init>", "(Lj/h;Ljava/nio/charset/Charset;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class BomAwareReader extends Reader {
        private final Charset charset;
        private boolean closed;
        private Reader delegate;
        private final h source;

        public BomAwareReader(h hVar, Charset charset) {
            m.f(hVar, "source");
            m.f(charset, "charset");
            this.source = hVar;
            this.charset = charset;
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.closed = true;
            Reader reader = this.delegate;
            if (reader != null) {
                reader.close();
            } else {
                this.source.close();
            }
        }

        @Override // java.io.Reader
        public int read(char[] cbuf, int off, int len) throws IOException {
            m.f(cbuf, "cbuf");
            if (this.closed) {
                throw new IOException("Stream closed");
            }
            Reader inputStreamReader = this.delegate;
            if (inputStreamReader == null) {
                inputStreamReader = new InputStreamReader(this.source.o1(), Util.readBomAsCharset(this.source, this.charset));
                this.delegate = inputStreamReader;
            }
            return inputStreamReader.read(cbuf, off, len);
        }
    }

    /* JADX INFO: compiled from: ResponseBody.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\b\u001a\u00020\u0005*\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\b\u001a\u00020\u0005*\u00020\t2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\nJ\u001f\u0010\b\u001a\u00020\u0005*\u00020\u000b2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\fJ)\u0010\u0011\u001a\u00020\u0005*\u00020\r2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0006\u0010\u0010J!\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0012\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0013J!\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0012\u001a\u00020\tH\u0007¢\u0006\u0004\b\u0006\u0010\u0014J!\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0012\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0006\u0010\u0015J)\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0006\u0010\u0016¨\u0006\u0019"}, d2 = {"Lokhttp3/ResponseBody$Companion;", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "Lokhttp3/MediaType;", "contentType", "Lokhttp3/ResponseBody;", "create", "(Ljava/lang/String;Lokhttp3/MediaType;)Lokhttp3/ResponseBody;", "toResponseBody", HttpUrl.FRAGMENT_ENCODE_SET, "([BLokhttp3/MediaType;)Lokhttp3/ResponseBody;", "Lj/i;", "(Lj/i;Lokhttp3/MediaType;)Lokhttp3/ResponseBody;", "Lj/h;", HttpUrl.FRAGMENT_ENCODE_SET, "contentLength", "(Lj/h;Lokhttp3/MediaType;J)Lokhttp3/ResponseBody;", "asResponseBody", "content", "(Lokhttp3/MediaType;Ljava/lang/String;)Lokhttp3/ResponseBody;", "(Lokhttp3/MediaType;[B)Lokhttp3/ResponseBody;", "(Lokhttp3/MediaType;Lj/i;)Lokhttp3/ResponseBody;", "(Lokhttp3/MediaType;JLj/h;)Lokhttp3/ResponseBody;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ ResponseBody create$default(Companion companion, String str, MediaType mediaType, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(str, mediaType);
        }

        public final ResponseBody create(String str, MediaType mediaType) {
            m.f(str, "$this$toResponseBody");
            Charset charset = Charsets.f25054b;
            if (mediaType != null) {
                Charset charsetCharset$default = MediaType.charset$default(mediaType, null, 1, null);
                if (charsetCharset$default == null) {
                    mediaType = MediaType.INSTANCE.parse(mediaType + "; charset=utf-8");
                } else {
                    charset = charsetCharset$default;
                }
            }
            f fVarV0 = new f().V0(str, charset);
            return create(fVarV0, mediaType, fVarV0.size());
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public static /* synthetic */ ResponseBody create$default(Companion companion, byte[] bArr, MediaType mediaType, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(bArr, mediaType);
        }

        public static /* synthetic */ ResponseBody create$default(Companion companion, i iVar, MediaType mediaType, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(iVar, mediaType);
        }

        public static /* synthetic */ ResponseBody create$default(Companion companion, h hVar, MediaType mediaType, long j2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                mediaType = null;
            }
            if ((i2 & 2) != 0) {
                j2 = -1;
            }
            return companion.create(hVar, mediaType, j2);
        }

        public final ResponseBody create(byte[] bArr, MediaType mediaType) {
            m.f(bArr, "$this$toResponseBody");
            return create(new f().write(bArr), mediaType, bArr.length);
        }

        public final ResponseBody create(i iVar, MediaType mediaType) {
            m.f(iVar, "$this$toResponseBody");
            return create(new f().U0(iVar), mediaType, iVar.P());
        }

        public final ResponseBody create(final h hVar, final MediaType mediaType, final long j2) {
            m.f(hVar, "$this$asResponseBody");
            return new ResponseBody() { // from class: okhttp3.ResponseBody$Companion$asResponseBody$1
                @Override // okhttp3.ResponseBody
                /* JADX INFO: renamed from: contentLength, reason: from getter */
                public long get$contentLength() {
                    return j2;
                }

                @Override // okhttp3.ResponseBody
                /* JADX INFO: renamed from: contentType, reason: from getter */
                public MediaType get$contentType() {
                    return mediaType;
                }

                @Override // okhttp3.ResponseBody
                /* JADX INFO: renamed from: source, reason: from getter */
                public h get$this_asResponseBody() {
                    return hVar;
                }
            };
        }

        public final ResponseBody create(MediaType contentType, String content) {
            m.f(content, "content");
            return create(content, contentType);
        }

        public final ResponseBody create(MediaType contentType, byte[] content) {
            m.f(content, "content");
            return create(content, contentType);
        }

        public final ResponseBody create(MediaType contentType, i content) {
            m.f(content, "content");
            return create(content, contentType);
        }

        public final ResponseBody create(MediaType contentType, long contentLength, h content) {
            m.f(content, "content");
            return create(content, contentType, contentLength);
        }
    }

    private final Charset charset() {
        Charset charset;
        MediaType mediaTypeContentType = get$contentType();
        return (mediaTypeContentType == null || (charset = mediaTypeContentType.charset(Charsets.f25054b)) == null) ? Charsets.f25054b : charset;
    }

    /* JADX WARN: Type inference failed for: r6v3, types: [T, java.lang.Object] */
    private final <T> T consumeSource(Function1<? super h, ? extends T> consumer, Function1<? super T, Integer> sizeMapper) throws IOException {
        long jContentLength = get$contentLength();
        if (jContentLength > Integer.MAX_VALUE) {
            throw new IOException("Cannot buffer entire body for content length: " + jContentLength);
        }
        h hVarSource = get$this_asResponseBody();
        try {
            T tInvoke = consumer.invoke(hVarSource);
            k.b(1);
            kotlin.io.a.a(hVarSource, null);
            k.a(1);
            int iIntValue = sizeMapper.invoke(tInvoke).intValue();
            if (jContentLength == -1 || jContentLength == iIntValue) {
                return tInvoke;
            }
            throw new IOException("Content-Length (" + jContentLength + ") and stream length (" + iIntValue + ") disagree");
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                k.b(1);
                kotlin.io.a.a(hVarSource, th);
                k.a(1);
                throw th2;
            }
        }
    }

    public static final ResponseBody create(h hVar, MediaType mediaType, long j2) {
        return INSTANCE.create(hVar, mediaType, j2);
    }

    public static final ResponseBody create(i iVar, MediaType mediaType) {
        return INSTANCE.create(iVar, mediaType);
    }

    public static final ResponseBody create(String str, MediaType mediaType) {
        return INSTANCE.create(str, mediaType);
    }

    public static final ResponseBody create(MediaType mediaType, long j2, h hVar) {
        return INSTANCE.create(mediaType, j2, hVar);
    }

    public static final ResponseBody create(MediaType mediaType, i iVar) {
        return INSTANCE.create(mediaType, iVar);
    }

    public static final ResponseBody create(MediaType mediaType, String str) {
        return INSTANCE.create(mediaType, str);
    }

    public static final ResponseBody create(MediaType mediaType, byte[] bArr) {
        return INSTANCE.create(mediaType, bArr);
    }

    public static final ResponseBody create(byte[] bArr, MediaType mediaType) {
        return INSTANCE.create(bArr, mediaType);
    }

    public final InputStream byteStream() {
        return get$this_asResponseBody().o1();
    }

    public final i byteString() throws IOException {
        long jContentLength = get$contentLength();
        if (jContentLength > Integer.MAX_VALUE) {
            throw new IOException("Cannot buffer entire body for content length: " + jContentLength);
        }
        h hVarSource = get$this_asResponseBody();
        try {
            i iVarD0 = hVarSource.D0();
            kotlin.io.a.a(hVarSource, null);
            int iP = iVarD0.P();
            if (jContentLength == -1 || jContentLength == iP) {
                return iVarD0;
            }
            throw new IOException("Content-Length (" + jContentLength + ") and stream length (" + iP + ") disagree");
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                kotlin.io.a.a(hVarSource, th);
                throw th2;
            }
        }
    }

    public final byte[] bytes() throws IOException {
        long jContentLength = get$contentLength();
        if (jContentLength > Integer.MAX_VALUE) {
            throw new IOException("Cannot buffer entire body for content length: " + jContentLength);
        }
        h hVarSource = get$this_asResponseBody();
        try {
            byte[] bArrM = hVarSource.M();
            kotlin.io.a.a(hVarSource, null);
            int length = bArrM.length;
            if (jContentLength == -1 || jContentLength == length) {
                return bArrM;
            }
            throw new IOException("Content-Length (" + jContentLength + ") and stream length (" + length + ") disagree");
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                kotlin.io.a.a(hVarSource, th);
                throw th2;
            }
        }
    }

    public final Reader charStream() {
        Reader reader = this.reader;
        if (reader != null) {
            return reader;
        }
        BomAwareReader bomAwareReader = new BomAwareReader(get$this_asResponseBody(), charset());
        this.reader = bomAwareReader;
        return bomAwareReader;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Util.closeQuietly(get$this_asResponseBody());
    }

    /* JADX INFO: renamed from: contentLength */
    public abstract long get$contentLength();

    /* JADX INFO: renamed from: contentType */
    public abstract MediaType get$contentType();

    /* JADX INFO: renamed from: source */
    public abstract h get$this_asResponseBody();

    public final String string() throws IOException {
        h hVarSource = get$this_asResponseBody();
        try {
            String strW0 = hVarSource.w0(Util.readBomAsCharset(hVarSource, charset()));
            kotlin.io.a.a(hVarSource, null);
            return strW0;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                kotlin.io.a.a(hVarSource, th);
                throw th2;
            }
        }
    }
}
