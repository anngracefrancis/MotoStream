package io.sentry.vendor;

import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: Base64.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: io.sentry.vendor.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Base64.java */
    static abstract class AbstractC0309a {
        public byte[] a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f22774b;

        AbstractC0309a() {
        }
    }

    /* JADX INFO: compiled from: Base64.java */
    static class b extends AbstractC0309a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final byte[] f22775c = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final byte[] f22776d = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final byte[] f22777e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f22778f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f22779g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f22780h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final boolean f22781i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final boolean f22782j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final byte[] f22783k;

        public b(int i2, byte[] bArr) {
            this.a = bArr;
            this.f22780h = (i2 & 1) == 0;
            boolean z = (i2 & 2) == 0;
            this.f22781i = z;
            this.f22782j = (i2 & 4) != 0;
            this.f22783k = (i2 & 8) == 0 ? f22775c : f22776d;
            this.f22777e = new byte[2];
            this.f22778f = 0;
            this.f22779g = z ? 19 : -1;
        }

        /* JADX WARN: Code duplicated, block: B:12:0x0050  */
        /* JADX WARN: Code duplicated, block: B:27:0x0094  */
        /* JADX WARN: Code duplicated, block: B:31:0x00d8  */
        /* JADX WARN: Code duplicated, block: B:32:0x00dd A[EDGE_INSN: B:32:0x00dd->B:22:0x008a BREAK  A[LOOP:0: B:25:0x0090->B:33:0x00e4]] */
        /* JADX WARN: Code duplicated, block: B:33:0x00e4 A[LOOP:0: B:25:0x0090->B:33:0x00e4, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:88:0x00d4 A[SYNTHETIC] */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        public boolean a(byte[] r18, int r19, int r20, boolean r21) {
            /*
                Method dump skipped, instruction units count: 477
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.sentry.vendor.a.b.a(byte[], int, int, boolean):boolean");
        }
    }

    public static byte[] a(byte[] bArr, int i2) {
        return b(bArr, 0, bArr.length, i2);
    }

    public static byte[] b(byte[] bArr, int i2, int i3, int i4) {
        b bVar = new b(i4, null);
        int i5 = (i3 / 3) * 4;
        if (!bVar.f22780h) {
            int i6 = i3 % 3;
            if (i6 == 1) {
                i5 += 2;
            } else if (i6 == 2) {
                i5 += 3;
            }
        } else if (i3 % 3 > 0) {
            i5 += 4;
        }
        if (bVar.f22781i && i3 > 0) {
            i5 += (((i3 - 1) / 57) + 1) * (bVar.f22782j ? 2 : 1);
        }
        bVar.a = new byte[i5];
        bVar.a(bArr, i2, i3, true);
        return bVar.a;
    }

    public static String c(byte[] bArr, int i2) {
        try {
            return new String(a(bArr, i2), "US-ASCII");
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }
}
