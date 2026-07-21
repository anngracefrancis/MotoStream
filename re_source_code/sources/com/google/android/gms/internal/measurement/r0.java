package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.StrictMode;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class r0 {
    r0() {
    }

    static p0 a(Context context) {
        String str = Build.TYPE;
        String str2 = Build.TAGS;
        String str3 = Build.HARDWARE;
        boolean z = false;
        if ((str.equals("eng") || str.equals("userdebug")) && ((str3.equals("goldfish") || str3.equals("ranchu") || str3.equals("robolectric")) && (str2.contains("dev-keys") || str2.contains("test-keys")))) {
            z = true;
        }
        if (!z) {
            return p0.a();
        }
        if (zzby.a() && !context.isDeviceProtectedStorage()) {
            context = context.createDeviceProtectedStorageContext();
        }
        zzcy<File> zzcyVarC = c(context);
        return zzcyVarC.b() ? b(zzcyVarC.c()) : p0.a();
    }

    private static p0 b(File file) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            try {
                HashMap map = new HashMap();
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        String strValueOf = String.valueOf(file);
                        StringBuilder sb = new StringBuilder(strValueOf.length() + 7);
                        sb.append("Parsed ");
                        sb.append(strValueOf);
                        Log.i("HermeticFileOverrides", sb.toString());
                        p0 p0Var = new p0(map);
                        bufferedReader.close();
                        return p0Var;
                    }
                    String[] strArrSplit = line.split(" ", 3);
                    if (strArrSplit.length != 3) {
                        Log.e("HermeticFileOverrides", line.length() != 0 ? "Invalid: ".concat(line) : new String("Invalid: "));
                    } else {
                        String str = strArrSplit[0];
                        String strDecode = Uri.decode(strArrSplit[1]);
                        String strDecode2 = Uri.decode(strArrSplit[2]);
                        if (!map.containsKey(str)) {
                            map.put(str, new HashMap());
                        }
                        ((Map) map.get(str)).put(strDecode, strDecode2);
                    }
                    throw new RuntimeException(e);
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable th3) {
                        zzdg.b(th, th3);
                    }
                    throw th2;
                }
            }
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static zzcy<File> c(Context context) {
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            StrictMode.allowThreadDiskWrites();
            try {
                File file = new File(context.getDir("phenotype_hermetic", 0), "overrides.txt");
                zzcy<File> zzcyVarA = file.exists() ? zzcy.a(file) : zzcy.d();
                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                return zzcyVarA;
            } catch (RuntimeException e2) {
                Log.e("HermeticFileOverrides", "no data dir", e2);
                zzcy<File> zzcyVarD = zzcy.d();
                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                return zzcyVarD;
            }
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            throw th;
        }
    }
}
