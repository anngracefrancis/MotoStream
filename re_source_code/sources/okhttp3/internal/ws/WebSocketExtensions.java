package okhttp3.internal.ws;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.text.t;
import kotlin.text.u;
import kotlin.text.v;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.internal.Util;

/* JADX INFO: compiled from: WebSocketExtensions.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\b\u0018\u0000 #2\u00020\u0001:\u0001#BG\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002¢\u0006\u0004\b!\u0010\"J\u0015\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0007J\u0012\u0010\f\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\f\u0010\nJ\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0007JP\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0011\u001a\u00020\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001d\u001a\u00020\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u0016\u0010\u0011\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u001fR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\b8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010 R\u0016\u0010\u000f\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u001fR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\b8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010 R\u0016\u0010\u0013\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u001fR\u0016\u0010\u0014\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u001f¨\u0006$"}, d2 = {"Lokhttp3/internal/ws/WebSocketExtensions;", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "clientOriginated", "noContextTakeover", "(Z)Z", "component1", "()Z", HttpUrl.FRAGMENT_ENCODE_SET, "component2", "()Ljava/lang/Integer;", "component3", "component4", "component5", "component6", "perMessageDeflate", "clientMaxWindowBits", "clientNoContextTakeover", "serverMaxWindowBits", "serverNoContextTakeover", "unknownValues", "copy", "(ZLjava/lang/Integer;ZLjava/lang/Integer;ZZ)Lokhttp3/internal/ws/WebSocketExtensions;", HttpUrl.FRAGMENT_ENCODE_SET, "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "Ljava/lang/Integer;", "<init>", "(ZLjava/lang/Integer;ZLjava/lang/Integer;ZZ)V", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
public final /* data */ class WebSocketExtensions {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String HEADER_WEB_SOCKET_EXTENSION = "Sec-WebSocket-Extensions";
    public final Integer clientMaxWindowBits;
    public final boolean clientNoContextTakeover;
    public final boolean perMessageDeflate;
    public final Integer serverMaxWindowBits;
    public final boolean serverNoContextTakeover;
    public final boolean unknownValues;

    /* JADX INFO: compiled from: WebSocketExtensions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lokhttp3/internal/ws/WebSocketExtensions$Companion;", HttpUrl.FRAGMENT_ENCODE_SET, "Lokhttp3/Headers;", "responseHeaders", "Lokhttp3/internal/ws/WebSocketExtensions;", "parse", "(Lokhttp3/Headers;)Lokhttp3/internal/ws/WebSocketExtensions;", HttpUrl.FRAGMENT_ENCODE_SET, "HEADER_WEB_SOCKET_EXTENSION", "Ljava/lang/String;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        /* JADX WARN: Code duplicated, block: B:51:0x00c3 A[PHI: r7 r9
          0x00c3: PHI (r7v6 java.lang.Integer) = (r7v4 java.lang.Integer), (r7v4 java.lang.Integer), (r7v8 java.lang.Integer) binds: [B:45:0x00b9, B:42:0x00b0, B:26:0x0089] A[DONT_GENERATE, DONT_INLINE]
          0x00c3: PHI (r9v9 java.lang.Integer) = (r9v4 java.lang.Integer), (r9v6 java.lang.Integer), (r9v4 java.lang.Integer) binds: [B:45:0x00b9, B:42:0x00b0, B:26:0x0089] A[DONT_GENERATE, DONT_INLINE]] */
        public final WebSocketExtensions parse(Headers responseHeaders) throws IOException {
            m.f(responseHeaders, "responseHeaders");
            int size = responseHeaders.size();
            boolean z = false;
            Integer numJ = null;
            boolean z2 = false;
            Integer numJ2 = null;
            boolean z3 = false;
            boolean z4 = false;
            for (int i2 = 0; i2 < size; i2++) {
                if (u.q(responseHeaders.name(i2), WebSocketExtensions.HEADER_WEB_SOCKET_EXTENSION, true)) {
                    String strValue = responseHeaders.value(i2);
                    int i3 = 0;
                    while (i3 < strValue.length()) {
                        int iDelimiterOffset$default = Util.delimiterOffset$default(strValue, ',', i3, 0, 4, (Object) null);
                        int iDelimiterOffset = Util.delimiterOffset(strValue, ';', i3, iDelimiterOffset$default);
                        String strTrimSubstring = Util.trimSubstring(strValue, i3, iDelimiterOffset);
                        int i4 = iDelimiterOffset + 1;
                        if (u.q(strTrimSubstring, "permessage-deflate", true)) {
                            if (z) {
                                z4 = true;
                            }
                            while (i4 < iDelimiterOffset$default) {
                                int iDelimiterOffset2 = Util.delimiterOffset(strValue, ';', i4, iDelimiterOffset$default);
                                int iDelimiterOffset3 = Util.delimiterOffset(strValue, '=', i4, iDelimiterOffset2);
                                String strTrimSubstring2 = Util.trimSubstring(strValue, i4, iDelimiterOffset3);
                                String strO0 = iDelimiterOffset3 < iDelimiterOffset2 ? v.o0(Util.trimSubstring(strValue, iDelimiterOffset3 + 1, iDelimiterOffset2), "\"") : null;
                                int i5 = iDelimiterOffset2 + 1;
                                if (u.q(strTrimSubstring2, "client_max_window_bits", true)) {
                                    if (numJ != null) {
                                        z4 = true;
                                    }
                                    numJ = strO0 != null ? t.j(strO0) : null;
                                    if (numJ == null) {
                                        z4 = true;
                                    }
                                } else if (u.q(strTrimSubstring2, "client_no_context_takeover", true)) {
                                    if (z2) {
                                        z4 = true;
                                    }
                                    if (strO0 != null) {
                                        z4 = true;
                                    }
                                    z2 = true;
                                } else if (u.q(strTrimSubstring2, "server_max_window_bits", true)) {
                                    if (numJ2 != null) {
                                        z4 = true;
                                    }
                                    numJ2 = strO0 != null ? t.j(strO0) : null;
                                    if (numJ2 == null) {
                                        z4 = true;
                                    }
                                } else if (u.q(strTrimSubstring2, "server_no_context_takeover", true)) {
                                    if (z3) {
                                        z4 = true;
                                    }
                                    if (strO0 != null) {
                                        z4 = true;
                                    }
                                    z3 = true;
                                } else {
                                    z4 = true;
                                }
                                i4 = i5;
                            }
                            i3 = i4;
                            z = true;
                        } else {
                            i3 = i4;
                            z4 = true;
                        }
                    }
                }
            }
            return new WebSocketExtensions(z, numJ, z2, numJ2, z3, z4);
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    public WebSocketExtensions() {
        this(false, null, false, null, false, false, 63, null);
    }

    public WebSocketExtensions(boolean z, Integer num, boolean z2, Integer num2, boolean z3, boolean z4) {
        this.perMessageDeflate = z;
        this.clientMaxWindowBits = num;
        this.clientNoContextTakeover = z2;
        this.serverMaxWindowBits = num2;
        this.serverNoContextTakeover = z3;
        this.unknownValues = z4;
    }

    public static /* synthetic */ WebSocketExtensions copy$default(WebSocketExtensions webSocketExtensions, boolean z, Integer num, boolean z2, Integer num2, boolean z3, boolean z4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = webSocketExtensions.perMessageDeflate;
        }
        if ((i2 & 2) != 0) {
            num = webSocketExtensions.clientMaxWindowBits;
        }
        Integer num3 = num;
        if ((i2 & 4) != 0) {
            z2 = webSocketExtensions.clientNoContextTakeover;
        }
        boolean z5 = z2;
        if ((i2 & 8) != 0) {
            num2 = webSocketExtensions.serverMaxWindowBits;
        }
        Integer num4 = num2;
        if ((i2 & 16) != 0) {
            z3 = webSocketExtensions.serverNoContextTakeover;
        }
        boolean z6 = z3;
        if ((i2 & 32) != 0) {
            z4 = webSocketExtensions.unknownValues;
        }
        return webSocketExtensions.copy(z, num3, z5, num4, z6, z4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getPerMessageDeflate() {
        return this.perMessageDeflate;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getClientMaxWindowBits() {
        return this.clientMaxWindowBits;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getClientNoContextTakeover() {
        return this.clientNoContextTakeover;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Integer getServerMaxWindowBits() {
        return this.serverMaxWindowBits;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getServerNoContextTakeover() {
        return this.serverNoContextTakeover;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getUnknownValues() {
        return this.unknownValues;
    }

    public final WebSocketExtensions copy(boolean perMessageDeflate, Integer clientMaxWindowBits, boolean clientNoContextTakeover, Integer serverMaxWindowBits, boolean serverNoContextTakeover, boolean unknownValues) {
        return new WebSocketExtensions(perMessageDeflate, clientMaxWindowBits, clientNoContextTakeover, serverMaxWindowBits, serverNoContextTakeover, unknownValues);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WebSocketExtensions)) {
            return false;
        }
        WebSocketExtensions webSocketExtensions = (WebSocketExtensions) other;
        return this.perMessageDeflate == webSocketExtensions.perMessageDeflate && m.a(this.clientMaxWindowBits, webSocketExtensions.clientMaxWindowBits) && this.clientNoContextTakeover == webSocketExtensions.clientNoContextTakeover && m.a(this.serverMaxWindowBits, webSocketExtensions.serverMaxWindowBits) && this.serverNoContextTakeover == webSocketExtensions.serverNoContextTakeover && this.unknownValues == webSocketExtensions.unknownValues;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9 */
    public int hashCode() {
        boolean z = this.perMessageDeflate;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i2 = r0 * 31;
        Integer num = this.clientMaxWindowBits;
        int iHashCode = (i2 + (num != null ? num.hashCode() : 0)) * 31;
        boolean z2 = this.clientNoContextTakeover;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i3 = (iHashCode + r2) * 31;
        Integer num2 = this.serverMaxWindowBits;
        int iHashCode2 = (i3 + (num2 != null ? num2.hashCode() : 0)) * 31;
        boolean z3 = this.serverNoContextTakeover;
        ?? r3 = z3;
        if (z3) {
            r3 = 1;
        }
        int i4 = (iHashCode2 + r3) * 31;
        boolean z4 = this.unknownValues;
        return i4 + (z4 ? 1 : z4);
    }

    public final boolean noContextTakeover(boolean clientOriginated) {
        return clientOriginated ? this.clientNoContextTakeover : this.serverNoContextTakeover;
    }

    public String toString() {
        return "WebSocketExtensions(perMessageDeflate=" + this.perMessageDeflate + ", clientMaxWindowBits=" + this.clientMaxWindowBits + ", clientNoContextTakeover=" + this.clientNoContextTakeover + ", serverMaxWindowBits=" + this.serverMaxWindowBits + ", serverNoContextTakeover=" + this.serverNoContextTakeover + ", unknownValues=" + this.unknownValues + ")";
    }

    public /* synthetic */ WebSocketExtensions(boolean z, Integer num, boolean z2, Integer num2, boolean z3, boolean z4, int i2, g gVar) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? null : num, (i2 & 4) != 0 ? false : z2, (i2 & 8) == 0 ? num2 : null, (i2 & 16) != 0 ? false : z3, (i2 & 32) != 0 ? false : z4);
    }
}
