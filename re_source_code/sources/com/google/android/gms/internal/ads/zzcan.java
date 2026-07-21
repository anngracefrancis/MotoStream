package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Looper;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcan {
    private final zzayu a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Clock f14983b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Executor f14984c;

    public zzcan(zzayu zzayuVar, Clock clock, Executor executor) {
        this.a = zzayuVar;
        this.f14983b = clock;
        this.f14984c = executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap b(byte[] bArr, double d2, boolean z) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDensity = (int) (d2 * 160.0d);
        if (!z) {
            options.inPreferredConfig = Bitmap.Config.RGB_565;
        }
        if (((Boolean) zzyt.e().c(zzacu.V4)).booleanValue()) {
            options.inJustDecodeBounds = true;
            c(bArr, options);
            options.inJustDecodeBounds = false;
            int i2 = options.outWidth * options.outHeight;
            if (i2 > 0) {
                int i3 = i2 - 1;
                options.inSampleSize = 1 << ((33 - Integer.numberOfLeadingZeros(i3 / ((Integer) zzyt.e().c(zzacu.W4)).intValue())) / 2);
            }
        }
        return c(bArr, options);
    }

    private final Bitmap c(byte[] bArr, BitmapFactory.Options options) {
        long jB = this.f14983b.b();
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        long jB2 = this.f14983b.b();
        if (Build.VERSION.SDK_INT >= 19 && bitmapDecodeByteArray != null) {
            int width = bitmapDecodeByteArray.getWidth();
            int height = bitmapDecodeByteArray.getHeight();
            int allocationByteCount = bitmapDecodeByteArray.getAllocationByteCount();
            long j2 = jB2 - jB;
            boolean z = Looper.getMainLooper().getThread() == Thread.currentThread();
            StringBuilder sb = new StringBuilder(108);
            sb.append("Decoded image w: ");
            sb.append(width);
            sb.append(" h:");
            sb.append(height);
            sb.append(" bytes: ");
            sb.append(allocationByteCount);
            sb.append(" time: ");
            sb.append(j2);
            sb.append(" on ui thread: ");
            sb.append(z);
            zzawz.m(sb.toString());
        }
        return bitmapDecodeByteArray;
    }

    public final zzbbh<Bitmap> d(String str, double d2, boolean z) {
        return zzbar.d(zzayu.d(str), new kg(this, d2, z), this.f14984c);
    }
}
