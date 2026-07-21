package com.google.android.gms.internal.ads;

import android.os.Environment;
import android.util.Base64;
import com.google.android.gms.ads.internal.zzk;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzwj {
    private final zzwo a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzxn f16872b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f16873c;

    public zzwj(zzwo zzwoVar) {
        this.a = zzwoVar;
        this.f16873c = ((Boolean) zzyt.e().c(zzacu.S3)).booleanValue();
        this.f16872b = new zzxn();
        g();
    }

    private final synchronized void c(zzwl.zza.zzb zzbVar) {
        this.f16872b.f16947h = h();
        this.a.a(zzdrw.b(this.f16872b)).b(zzbVar.i()).c();
        String strValueOf = String.valueOf(Integer.toString(zzbVar.i(), 10));
        zzawz.m(strValueOf.length() != 0 ? "Logging Event with event code : ".concat(strValueOf) : new String("Logging Event with event code : "));
    }

    private final synchronized void d(zzwl.zza.zzb zzbVar) {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory == null) {
            return;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(externalStorageDirectory, "clearcut_events.txt"), true);
            try {
                try {
                    fileOutputStream.write(e(zzbVar).getBytes());
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused) {
                        zzawz.m("Could not close Clearcut output stream.");
                    }
                } catch (IOException unused2) {
                    zzawz.m("Could not write Clearcut to file.");
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused3) {
                        zzawz.m("Could not close Clearcut output stream.");
                    }
                }
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (IOException unused4) {
                    zzawz.m("Could not close Clearcut output stream.");
                }
                throw th;
            }
        } catch (FileNotFoundException unused5) {
            zzawz.m("Could not find file for Clearcut");
        }
    }

    private final synchronized String e(zzwl.zza.zzb zzbVar) {
        return String.format("id=%s,timestamp=%s,event=%s,data=%s\n", this.f16872b.f16943d, Long.valueOf(zzk.zzln().b()), Integer.valueOf(zzbVar.i()), Base64.encodeToString(zzdrw.b(this.f16872b), 3));
    }

    public static zzwj f() {
        return new zzwj();
    }

    private final synchronized void g() {
        this.f16872b.l = new zzxj();
        this.f16872b.l.f16923f = new zzxk();
        this.f16872b.f16948i = new zzxl();
    }

    private static long[] h() {
        int i2;
        List<String> listD = zzacu.d();
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = listD.iterator();
        while (true) {
            i2 = 0;
            if (!it.hasNext()) {
                break;
            }
            String[] strArrSplit = it.next().split(",");
            int length = strArrSplit.length;
            while (i2 < length) {
                try {
                    arrayList.add(Long.valueOf(strArrSplit[i2]));
                } catch (NumberFormatException unused) {
                    zzawz.m("Experiment ID is not a number");
                }
                i2++;
            }
        }
        long[] jArr = new long[arrayList.size()];
        int size = arrayList.size();
        int i3 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            jArr[i3] = ((Long) obj).longValue();
            i3++;
        }
        return jArr;
    }

    public final synchronized void a(zzwk zzwkVar) {
        if (this.f16873c) {
            try {
                zzwkVar.a(this.f16872b);
            } catch (NullPointerException e2) {
                zzk.zzlk().e(e2, "AdMobClearcutLogger.modify");
            }
        }
    }

    public final synchronized void b(zzwl.zza.zzb zzbVar) {
        if (this.f16873c) {
            if (((Boolean) zzyt.e().c(zzacu.T3)).booleanValue()) {
                d(zzbVar);
            } else {
                c(zzbVar);
            }
        }
    }

    private zzwj() {
        this.f16873c = false;
        this.a = new zzwo();
        this.f16872b = new zzxn();
        g();
    }
}
