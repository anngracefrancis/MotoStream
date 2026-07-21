package io.sentry.android.core.internal.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.VisibleForTesting;

/* JADX INFO: compiled from: CpuInfoUtils.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class m {
    private static final m a = new m();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<Integer> f22188b = new ArrayList();

    private m() {
    }

    public static m a() {
        return a;
    }

    @VisibleForTesting
    String b() {
        return "/sys/devices/system/cpu";
    }

    public synchronized List<Integer> c() {
        if (!this.f22188b.isEmpty()) {
            return this.f22188b;
        }
        File[] fileArrListFiles = new File(b()).listFiles();
        if (fileArrListFiles == null) {
            return new ArrayList();
        }
        for (File file : fileArrListFiles) {
            if (file.getName().matches("cpu[0-9]+")) {
                File file2 = new File(file, "cpufreq/cpuinfo_max_freq");
                if (file2.exists() && file2.canRead()) {
                    try {
                        String strC = io.sentry.util.l.c(file2);
                        if (strC != null) {
                            this.f22188b.add(Integer.valueOf((int) (Long.parseLong(strC.trim()) / 1000)));
                        }
                    } catch (IOException | NumberFormatException unused) {
                    }
                }
            }
        }
        return this.f22188b;
    }
}
