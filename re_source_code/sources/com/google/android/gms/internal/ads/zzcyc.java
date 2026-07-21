package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.util.IOUtils;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcyc {
    static final /* synthetic */ void a(InputStream inputStream, ParcelFileDescriptor parcelFileDescriptor) {
        try {
            try {
                ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream = new ParcelFileDescriptor.AutoCloseOutputStream(parcelFileDescriptor);
                try {
                    IOUtils.b(inputStream, autoCloseOutputStream);
                    autoCloseOutputStream.close();
                    if (inputStream != null) {
                        b(null, inputStream);
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        try {
                            autoCloseOutputStream.close();
                        } catch (Throwable th3) {
                            zzdmb.b(th, th3);
                        }
                        throw th2;
                    }
                }
            } catch (IOException unused) {
            }
        } catch (Throwable th4) {
            try {
                throw th4;
            } catch (Throwable th5) {
                if (inputStream != null) {
                    b(th4, inputStream);
                }
                throw th5;
            }
        }
    }

    private static /* synthetic */ void b(Throwable th, InputStream inputStream) throws IOException {
        if (th == null) {
            inputStream.close();
            return;
        }
        try {
            inputStream.close();
        } catch (Throwable th2) {
            zzdmb.b(th, th2);
        }
    }

    public static ParcelFileDescriptor c(final InputStream inputStream) throws IOException {
        ParcelFileDescriptor[] parcelFileDescriptorArrCreatePipe = ParcelFileDescriptor.createPipe();
        ParcelFileDescriptor parcelFileDescriptor = parcelFileDescriptorArrCreatePipe[0];
        final ParcelFileDescriptor parcelFileDescriptor2 = parcelFileDescriptorArrCreatePipe[1];
        zzaxg.a.execute(new Runnable(inputStream, parcelFileDescriptor2) { // from class: com.google.android.gms.internal.ads.zp

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final InputStream f13719f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private final ParcelFileDescriptor f13720g;

            {
                this.f13719f = inputStream;
                this.f13720g = parcelFileDescriptor2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzcyc.a(this.f13719f, this.f13720g);
            }
        });
        return parcelFileDescriptor;
    }
}
