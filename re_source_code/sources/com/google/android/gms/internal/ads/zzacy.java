package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzacy {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @VisibleForTesting
    private ExecutorService f13811b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @VisibleForTesting
    private String f13814e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @VisibleForTesting
    private Context f13815f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @VisibleForTesting
    private String f13816g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private AtomicBoolean f13817h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private File f13818i;

    @VisibleForTesting
    private BlockingQueue<zzadi> a = new ArrayBlockingQueue(100);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @VisibleForTesting
    private LinkedHashMap<String, String> f13812c = new LinkedHashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @VisibleForTesting
    private Map<String, zzadc> f13813d = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    public final void f() throws Throwable {
        while (true) {
            try {
                zzadi zzadiVarTake = this.a.take();
                String strE = zzadiVarTake.e();
                if (!TextUtils.isEmpty(strE)) {
                    Map<String, String> mapA = a(this.f13812c, zzadiVarTake.f());
                    Uri.Builder builderBuildUpon = Uri.parse(this.f13814e).buildUpon();
                    for (Map.Entry<String, String> entry : mapA.entrySet()) {
                        builderBuildUpon.appendQueryParameter(entry.getKey(), entry.getValue());
                    }
                    String str = builderBuildUpon.build().toString() + "&it=" + strE;
                    if (this.f13817h.get()) {
                        File file = this.f13818i;
                        if (file != null) {
                            FileOutputStream fileOutputStream = null;
                            try {
                                try {
                                    FileOutputStream fileOutputStream2 = new FileOutputStream(file, true);
                                    try {
                                        fileOutputStream2.write(str.getBytes());
                                        fileOutputStream2.write(10);
                                        try {
                                            fileOutputStream2.close();
                                        } catch (IOException e2) {
                                            zzbad.d("CsiReporter: Cannot close file: sdk_csi_data.txt.", e2);
                                        }
                                    } catch (IOException e3) {
                                        e = e3;
                                        fileOutputStream = fileOutputStream2;
                                        zzbad.d("CsiReporter: Cannot write to file: sdk_csi_data.txt.", e);
                                        if (fileOutputStream != null) {
                                            try {
                                                fileOutputStream.close();
                                            } catch (IOException e4) {
                                                zzbad.d("CsiReporter: Cannot close file: sdk_csi_data.txt.", e4);
                                            }
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        fileOutputStream = fileOutputStream2;
                                        if (fileOutputStream != null) {
                                            try {
                                                fileOutputStream.close();
                                            } catch (IOException e5) {
                                                zzbad.d("CsiReporter: Cannot close file: sdk_csi_data.txt.", e5);
                                            }
                                        }
                                        throw th;
                                    }
                                } catch (IOException e6) {
                                    e = e6;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        } else {
                            zzbad.i("CsiReporter: File doesn't exists. Cannot write CSI data to file.");
                        }
                    } else {
                        zzk.zzlg();
                        zzaxi.J(this.f13815f, this.f13816g, str);
                    }
                }
            } catch (InterruptedException e7) {
                zzbad.d("CsiReporter:reporter interrupted", e7);
                return;
            }
        }
    }

    final Map<String, String> a(Map<String, String> map, Map<String, String> map2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        if (map2 == null) {
            return linkedHashMap;
        }
        for (Map.Entry<String, String> entry : map2.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            linkedHashMap.put(key, e(key).a((String) linkedHashMap.get(key), value));
        }
        return linkedHashMap;
    }

    public final void b(Context context, String str, String str2, Map<String, String> map) {
        File externalStorageDirectory;
        this.f13815f = context;
        this.f13816g = str;
        this.f13814e = str2;
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.f13817h = atomicBoolean;
        atomicBoolean.set(((Boolean) zzyt.e().c(zzacu.g0)).booleanValue());
        if (this.f13817h.get() && (externalStorageDirectory = Environment.getExternalStorageDirectory()) != null) {
            this.f13818i = new File(externalStorageDirectory, "sdk_csi_data.txt");
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            this.f13812c.put(entry.getKey(), entry.getValue());
        }
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        this.f13811b = executorServiceNewSingleThreadExecutor;
        executorServiceNewSingleThreadExecutor.execute(new t(this));
        Map<String, zzadc> map2 = this.f13813d;
        zzadc zzadcVar = zzadc.f13819b;
        map2.put("action", zzadcVar);
        this.f13813d.put("ad_format", zzadcVar);
        this.f13813d.put("e", zzadc.f13820c);
    }

    public final boolean d(zzadi zzadiVar) {
        return this.a.offer(zzadiVar);
    }

    public final zzadc e(String str) {
        zzadc zzadcVar = this.f13813d.get(str);
        return zzadcVar != null ? zzadcVar : zzadc.a;
    }
}
