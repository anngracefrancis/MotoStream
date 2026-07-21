package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.IOUtils;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
final class r3 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ OutputStream f13252f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ byte[] f13253g;

    r3(zzaru zzaruVar, OutputStream outputStream, byte[] bArr) {
        this.f13252f = outputStream;
        this.f13253g = bArr;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x003f  */
    /* JADX WARN: Code duplicated, block: B:22:0x0045  */
    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        DataOutputStream dataOutputStream;
        Throwable th;
        IOException e2;
        try {
            dataOutputStream = new DataOutputStream(this.f13252f);
            try {
                try {
                    dataOutputStream.writeInt(this.f13253g.length);
                    dataOutputStream.write(this.f13253g);
                    IOUtils.a(dataOutputStream);
                } catch (IOException e3) {
                    e2 = e3;
                    zzbad.c("Error transporting the ad response", e2);
                    zzk.zzlk().e(e2, "LargeParcelTeleporter.pipeData.1");
                    if (dataOutputStream == null) {
                        IOUtils.a(this.f13252f);
                    } else {
                        IOUtils.a(dataOutputStream);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (dataOutputStream == null) {
                    IOUtils.a(this.f13252f);
                } else {
                    IOUtils.a(dataOutputStream);
                }
                throw th;
            }
        } catch (IOException e4) {
            dataOutputStream = null;
            e2 = e4;
        } catch (Throwable th3) {
            dataOutputStream = null;
            th = th3;
            if (dataOutputStream == null) {
                IOUtils.a(this.f13252f);
            } else {
                IOUtils.a(dataOutputStream);
            }
            throw th;
        }
    }
}
