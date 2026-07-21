package com.flurry.sdk;

import android.os.Build;
import android.os.Debug;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class o7 {
    public static Map<String, String> a() {
        HashMap map = new HashMap();
        b(map);
        c(map);
        e(map);
        h(map);
        i(map);
        d(map);
        f(map);
        g(map);
        return map;
    }

    private static void b(Map<String, String> map) {
        try {
            map.put("mem.java.max", Long.toString(Runtime.getRuntime().maxMemory()));
        } catch (RuntimeException e2) {
            d1.d(6, "CrashParameterCollector", "Error retrieving max memory", e2);
        }
    }

    private static void c(Map<String, String> map) {
        try {
            Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
            Debug.getMemoryInfo(memoryInfo);
            map.put("mem.pss", Long.toString(memoryInfo.getTotalPss() * 1024));
        } catch (RuntimeException e2) {
            d1.d(6, "CrashParameterCollector", "Error retrieving pss memory", e2);
        }
    }

    private static void d(Map<String, String> map) throws Throwable {
        BufferedReader bufferedReader;
        Pattern patternCompile = Pattern.compile("^Vm(RSS|Size|Peak):\\s+(\\d+)\\s+kB$");
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(new File(new File("/proc/" + Integer.toString(Process.myPid())), "status"));
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream2));
                try {
                    for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                        Matcher matcher = patternCompile.matcher(line);
                        if (matcher.find()) {
                            String strGroup = matcher.group(1);
                            String strGroup2 = matcher.group(2);
                            if (!TextUtils.isEmpty(strGroup) && !TextUtils.isEmpty(strGroup2)) {
                                byte b2 = -1;
                                int iHashCode = strGroup.hashCode();
                                if (iHashCode != 81458) {
                                    if (iHashCode != 2483455) {
                                        if (iHashCode == 2577441 && strGroup.equals("Size")) {
                                            b2 = 1;
                                        }
                                    } else if (strGroup.equals("Peak")) {
                                        b2 = 2;
                                    }
                                } else if (strGroup.equals("RSS")) {
                                    b2 = 0;
                                }
                                if (b2 == 0) {
                                    map.put("mem.rss", strGroup2);
                                } else if (b2 == 1) {
                                    map.put("mem.virt", strGroup2);
                                } else if (b2 == 2) {
                                    map.put("mem.virt.max", strGroup2);
                                }
                            }
                        }
                    }
                    c2.f(fileInputStream2);
                } catch (IOException e2) {
                    e = e2;
                    fileInputStream = fileInputStream2;
                    try {
                        d1.d(6, "CrashParameterCollector", "Error getting proc file Info", e);
                        c2.f(fileInputStream);
                    } catch (Throwable th) {
                        th = th;
                        c2.f(fileInputStream);
                        c2.f(bufferedReader);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    c2.f(fileInputStream);
                    c2.f(bufferedReader);
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
                bufferedReader = null;
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
        } catch (IOException e4) {
            e = e4;
            bufferedReader = null;
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
        }
        c2.f(bufferedReader);
    }

    private static void e(Map<String, String> map) {
        map.put("application.state", Integer.toString(e7.a().f10731j.y().f10800j));
    }

    private static void f(Map<String, String> map) {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        int i2 = Build.VERSION.SDK_INT;
        map.put("disk.size.free", Long.toString((i2 >= 18 ? statFs.getAvailableBlocksLong() : statFs.getAvailableBlocks()) * (i2 >= 18 ? statFs.getBlockSizeLong() : statFs.getBlockSize())));
    }

    private static void g(Map<String, String> map) {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        int i2 = Build.VERSION.SDK_INT;
        map.put("disk.size.total", Long.toString((i2 >= 18 ? statFs.getBlockCountLong() : statFs.getBlockCount()) * (i2 >= 18 ? statFs.getBlockSizeLong() : statFs.getBlockSize())));
    }

    private static void h(Map<String, String> map) {
        map.put("net.status", Integer.toString(e7.a().f10724c.T().ordinal()));
    }

    private static void i(Map<String, String> map) {
        map.put("orientation", Integer.toString(e7.a().f10725d.q));
    }
}
