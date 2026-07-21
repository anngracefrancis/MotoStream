package com.flurry.sdk;

import com.google.android.gms.ads.AdRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class n7 {
    private static final char[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f10951b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f10952c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f10953d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f10954e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f10955f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private short f10956g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f10957h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ByteBuffer f10958i;

    static {
        char[] cArr = {'F', 'C', 'B', 'M'};
        a = cArr;
        f10951b = new String(cArr);
        f10952c = (cArr.length * 2) + 2 + 1 + 105984;
        int length = cArr.length * 2;
        f10953d = length;
        int i2 = length + 2;
        f10954e = i2;
        f10955f = i2 + 1;
    }

    n7() {
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(f10952c);
        this.f10958i = byteBufferAllocateDirect;
        byteBufferAllocateDirect.asCharBuffer().put(a);
    }

    private m7 a(int i2) {
        this.f10958i.position(f10955f + (i2 * AdRequest.MAX_CONTENT_URL_LENGTH));
        return new m7(this.f10958i.asCharBuffer().limit(this.f10958i.getInt()).toString(), this.f10958i.getLong());
    }

    public static int c() {
        return 1;
    }

    public final List<m7> b() {
        ArrayList arrayList = new ArrayList();
        if (this.f10958i == null) {
            return arrayList;
        }
        if (this.f10957h) {
            for (int i2 = this.f10956g; i2 < 207; i2++) {
                arrayList.add(a(i2));
            }
        }
        for (int i3 = 0; i3 < this.f10956g; i3++) {
            arrayList.add(a(i3));
        }
        return arrayList;
    }

    public final synchronized String toString() {
        short s;
        StringBuilder sb;
        if (this.f10958i == null) {
            s = 0;
        } else {
            s = this.f10957h ? (short) 207 : this.f10956g;
        }
        sb = new StringBuilder();
        sb.append("Total number of breadcrumbs: " + ((int) s) + "\n");
        Iterator<m7> it = b().iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
        }
        return sb.toString();
    }

    public n7(File file) {
        int i2;
        d1.c(6, "com.flurry.android.common.newProviders.errorCrashBreadcrumbsManager", String.format(Locale.getDefault(), "YCrashBreadcrumbs from %s", file.getAbsolutePath()));
        this.f10958i = ByteBuffer.allocate(f10952c);
        if (file.length() != this.f10958i.capacity()) {
            d1.c(6, "com.flurry.android.common.newProviders.errorCrashBreadcrumbsManager", String.format(Locale.getDefault(), "Crash breadcrumbs invalid file length %s != %s", Long.valueOf(file.length()), Integer.valueOf(this.f10958i.capacity())));
            this.f10958i = null;
            return;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            FileChannel channel = fileInputStream.getChannel();
            try {
                i2 = channel.read(this.f10958i);
            } catch (IOException unused) {
                d1.c(6, "com.flurry.android.common.newProviders.errorCrashBreadcrumbsManager", "Issue reading breadcrumbs from file.");
                i2 = 0;
            }
            c2.f(channel);
            c2.f(fileInputStream);
            if (i2 != this.f10958i.capacity()) {
                d1.c(6, "com.flurry.android.common.newProviders.errorCrashBreadcrumbsManager", String.format(Locale.getDefault(), "YCrashBreadcrumbs unexpected read size %s != %s", Integer.valueOf(i2), Integer.valueOf(this.f10958i.capacity())));
                this.f10958i = null;
                return;
            }
            this.f10958i.position(0);
            String string = this.f10958i.asCharBuffer().limit(a.length).toString();
            if (!string.equals(f10951b)) {
                d1.c(6, "com.flurry.android.common.newProviders.errorCrashBreadcrumbsManager", String.format(Locale.getDefault(), "YCrashBreadcrumbs invalid magic string: '%s'", string));
                this.f10958i = null;
                return;
            }
            short s = this.f10958i.getShort(f10953d);
            this.f10956g = s;
            if (s >= 0 && s < 207) {
                this.f10957h = this.f10958i.get(f10954e) == 1;
            } else {
                d1.c(6, "com.flurry.android.common.newProviders.errorCrashBreadcrumbsManager", String.format(Locale.getDefault(), "YCrashBreadcrumbs invalid index: '%s'", Short.valueOf(this.f10956g)));
                this.f10958i = null;
            }
        } catch (FileNotFoundException unused2) {
            d1.c(6, "com.flurry.android.common.newProviders.errorCrashBreadcrumbsManager", "Issue reading breadcrumbs file.");
            this.f10958i = null;
        }
    }
}
