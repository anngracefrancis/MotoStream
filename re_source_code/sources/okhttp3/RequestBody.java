package okhttp3;

import j.d0;
import j.i;
import j.q;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.text.Charsets;
import okhttp3.internal.Util;

/* JADX INFO: compiled from: RequestBody.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b&\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u000f¨\u0006\u0014"}, d2 = {"Lokhttp3/RequestBody;", HttpUrl.FRAGMENT_ENCODE_SET, "Lokhttp3/MediaType;", "contentType", "()Lokhttp3/MediaType;", HttpUrl.FRAGMENT_ENCODE_SET, "contentLength", "()J", "Lj/g;", "sink", "Lkotlin/u;", "writeTo", "(Lj/g;)V", HttpUrl.FRAGMENT_ENCODE_SET, "isDuplex", "()Z", "isOneShot", "<init>", "()V", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
public abstract class RequestBody {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: RequestBody.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\b\u001a\u00020\u0005*\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\b\u001a\u00020\u0005*\u00020\t2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\nJ3\u0010\b\u001a\u00020\u0005*\u00020\u000b2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\fH\u0007¢\u0006\u0004\b\u0006\u0010\u000fJ\u001f\u0010\u0012\u001a\u00020\u0005*\u00020\u00102\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0011J!\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0013\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0014J!\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0013\u001a\u00020\tH\u0007¢\u0006\u0004\b\u0006\u0010\u0015J5\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0013\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\fH\u0007¢\u0006\u0004\b\u0006\u0010\u0016J!\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0017\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0006\u0010\u0018¨\u0006\u001b"}, d2 = {"Lokhttp3/RequestBody$Companion;", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "Lokhttp3/MediaType;", "contentType", "Lokhttp3/RequestBody;", "create", "(Ljava/lang/String;Lokhttp3/MediaType;)Lokhttp3/RequestBody;", "toRequestBody", "Lj/i;", "(Lj/i;Lokhttp3/MediaType;)Lokhttp3/RequestBody;", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "offset", "byteCount", "([BLokhttp3/MediaType;II)Lokhttp3/RequestBody;", "Ljava/io/File;", "(Ljava/io/File;Lokhttp3/MediaType;)Lokhttp3/RequestBody;", "asRequestBody", "content", "(Lokhttp3/MediaType;Ljava/lang/String;)Lokhttp3/RequestBody;", "(Lokhttp3/MediaType;Lj/i;)Lokhttp3/RequestBody;", "(Lokhttp3/MediaType;[BII)Lokhttp3/RequestBody;", "file", "(Lokhttp3/MediaType;Ljava/io/File;)Lokhttp3/RequestBody;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, String str, MediaType mediaType, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(str, mediaType);
        }

        public final RequestBody create(String str, MediaType mediaType) {
            m.f(str, "$this$toRequestBody");
            Charset charset = Charsets.f25054b;
            if (mediaType != null) {
                Charset charsetCharset$default = MediaType.charset$default(mediaType, null, 1, null);
                if (charsetCharset$default == null) {
                    mediaType = MediaType.INSTANCE.parse(mediaType + "; charset=utf-8");
                } else {
                    charset = charsetCharset$default;
                }
            }
            byte[] bytes = str.getBytes(charset);
            m.e(bytes, "(this as java.lang.String).getBytes(charset)");
            return create(bytes, mediaType, 0, bytes.length);
        }

        public final RequestBody create(MediaType mediaType, byte[] bArr) {
            return create$default(this, mediaType, bArr, 0, 0, 12, (Object) null);
        }

        public final RequestBody create(MediaType mediaType, byte[] bArr, int i2) {
            return create$default(this, mediaType, bArr, i2, 0, 8, (Object) null);
        }

        public final RequestBody create(byte[] bArr) {
            return create$default(this, bArr, (MediaType) null, 0, 0, 7, (Object) null);
        }

        public final RequestBody create(byte[] bArr, MediaType mediaType) {
            return create$default(this, bArr, mediaType, 0, 0, 6, (Object) null);
        }

        public final RequestBody create(byte[] bArr, MediaType mediaType, int i2) {
            return create$default(this, bArr, mediaType, i2, 0, 4, (Object) null);
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, i iVar, MediaType mediaType, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(iVar, mediaType);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, byte[] bArr, MediaType mediaType, int i2, int i3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                mediaType = null;
            }
            if ((i4 & 2) != 0) {
                i2 = 0;
            }
            if ((i4 & 4) != 0) {
                i3 = bArr.length;
            }
            return companion.create(bArr, mediaType, i2, i3);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, File file, MediaType mediaType, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(file, mediaType);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, MediaType mediaType, byte[] bArr, int i2, int i3, int i4, Object obj) {
            if ((i4 & 4) != 0) {
                i2 = 0;
            }
            if ((i4 & 8) != 0) {
                i3 = bArr.length;
            }
            return companion.create(mediaType, bArr, i2, i3);
        }

        public final RequestBody create(final i iVar, final MediaType mediaType) {
            m.f(iVar, "$this$toRequestBody");
            return new RequestBody() { // from class: okhttp3.RequestBody$Companion$toRequestBody$1
                @Override // okhttp3.RequestBody
                public long contentLength() {
                    return iVar.P();
                }

                @Override // okhttp3.RequestBody
                /* JADX INFO: renamed from: contentType, reason: from getter */
                public MediaType get$contentType() {
                    return mediaType;
                }

                @Override // okhttp3.RequestBody
                public void writeTo(j.g sink) throws IOException {
                    m.f(sink, "sink");
                    sink.U0(iVar);
                }
            };
        }

        public final RequestBody create(final byte[] bArr, final MediaType mediaType, final int i2, final int i3) {
            m.f(bArr, "$this$toRequestBody");
            Util.checkOffsetAndCount(bArr.length, i2, i3);
            return new RequestBody() { // from class: okhttp3.RequestBody$Companion$toRequestBody$2
                @Override // okhttp3.RequestBody
                public long contentLength() {
                    return i3;
                }

                @Override // okhttp3.RequestBody
                /* JADX INFO: renamed from: contentType, reason: from getter */
                public MediaType get$contentType() {
                    return mediaType;
                }

                @Override // okhttp3.RequestBody
                public void writeTo(j.g sink) throws IOException {
                    m.f(sink, "sink");
                    sink.write(bArr, i2, i3);
                }
            };
        }

        public final RequestBody create(final File file, final MediaType mediaType) {
            m.f(file, "$this$asRequestBody");
            return new RequestBody() { // from class: okhttp3.RequestBody$Companion$asRequestBody$1
                @Override // okhttp3.RequestBody
                public long contentLength() {
                    return file.length();
                }

                @Override // okhttp3.RequestBody
                /* JADX INFO: renamed from: contentType, reason: from getter */
                public MediaType get$contentType() {
                    return mediaType;
                }

                @Override // okhttp3.RequestBody
                public void writeTo(j.g sink) throws IOException {
                    m.f(sink, "sink");
                    d0 d0VarJ = q.j(file);
                    try {
                        sink.B0(d0VarJ);
                        kotlin.io.a.a(d0VarJ, null);
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            kotlin.io.a.a(d0VarJ, th);
                            throw th2;
                        }
                    }
                }
            };
        }

        public final RequestBody create(MediaType contentType, String content) {
            m.f(content, "content");
            return create(content, contentType);
        }

        public final RequestBody create(MediaType contentType, i content) {
            m.f(content, "content");
            return create(content, contentType);
        }

        public final RequestBody create(MediaType contentType, byte[] content, int offset, int byteCount) {
            m.f(content, "content");
            return create(content, contentType, offset, byteCount);
        }

        public final RequestBody create(MediaType contentType, File file) {
            m.f(file, "file");
            return create(file, contentType);
        }
    }

    public static final RequestBody create(i iVar, MediaType mediaType) {
        return INSTANCE.create(iVar, mediaType);
    }

    public static final RequestBody create(File file, MediaType mediaType) {
        return INSTANCE.create(file, mediaType);
    }

    public static final RequestBody create(String str, MediaType mediaType) {
        return INSTANCE.create(str, mediaType);
    }

    public static final RequestBody create(MediaType mediaType, i iVar) {
        return INSTANCE.create(mediaType, iVar);
    }

    public static final RequestBody create(MediaType mediaType, File file) {
        return INSTANCE.create(mediaType, file);
    }

    public static final RequestBody create(MediaType mediaType, String str) {
        return INSTANCE.create(mediaType, str);
    }

    public static final RequestBody create(MediaType mediaType, byte[] bArr) {
        return Companion.create$default(INSTANCE, mediaType, bArr, 0, 0, 12, (Object) null);
    }

    public static final RequestBody create(MediaType mediaType, byte[] bArr, int i2) {
        return Companion.create$default(INSTANCE, mediaType, bArr, i2, 0, 8, (Object) null);
    }

    public static final RequestBody create(MediaType mediaType, byte[] bArr, int i2, int i3) {
        return INSTANCE.create(mediaType, bArr, i2, i3);
    }

    public static final RequestBody create(byte[] bArr) {
        return Companion.create$default(INSTANCE, bArr, (MediaType) null, 0, 0, 7, (Object) null);
    }

    public static final RequestBody create(byte[] bArr, MediaType mediaType) {
        return Companion.create$default(INSTANCE, bArr, mediaType, 0, 0, 6, (Object) null);
    }

    public static final RequestBody create(byte[] bArr, MediaType mediaType, int i2) {
        return Companion.create$default(INSTANCE, bArr, mediaType, i2, 0, 4, (Object) null);
    }

    public static final RequestBody create(byte[] bArr, MediaType mediaType, int i2, int i3) {
        return INSTANCE.create(bArr, mediaType, i2, i3);
    }

    public long contentLength() throws IOException {
        return -1L;
    }

    /* JADX INFO: renamed from: contentType */
    public abstract MediaType get$contentType();

    public boolean isDuplex() {
        return false;
    }

    public boolean isOneShot() {
        return false;
    }

    public abstract void writeTo(j.g sink) throws IOException;
}
