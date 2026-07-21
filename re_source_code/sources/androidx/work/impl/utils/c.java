package androidx.work.impl.utils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.work.impl.WorkDatabase;

/* JADX INFO: compiled from: IdGenerator.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    private final WorkDatabase a;

    public c(WorkDatabase workDatabase) {
        this.a = workDatabase;
    }

    public static void a(Context context, c.u.a.b bVar) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("androidx.work.util.id", 0);
        if (sharedPreferences.contains("next_job_scheduler_id") || sharedPreferences.contains("next_job_scheduler_id")) {
            int i2 = sharedPreferences.getInt("next_job_scheduler_id", 0);
            int i3 = sharedPreferences.getInt("next_alarm_manager_id", 0);
            bVar.n();
            try {
                bVar.l0("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"next_job_scheduler_id", Integer.valueOf(i2)});
                bVar.l0("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"next_alarm_manager_id", Integer.valueOf(i3)});
                sharedPreferences.edit().clear().apply();
                bVar.j0();
            } finally {
                bVar.z0();
            }
        }
    }

    private int c(String str) {
        this.a.beginTransaction();
        try {
            Long lA = this.a.f().a(str);
            int i2 = 0;
            int iIntValue = lA != null ? lA.intValue() : 0;
            if (iIntValue != Integer.MAX_VALUE) {
                i2 = iIntValue + 1;
            }
            e(str, i2);
            this.a.setTransactionSuccessful();
            return iIntValue;
        } finally {
            this.a.endTransaction();
        }
    }

    private void e(String str, int i2) {
        this.a.f().b(new androidx.work.impl.n.d(str, i2));
    }

    public int b() {
        int iC;
        synchronized (c.class) {
            iC = c("next_alarm_manager_id");
        }
        return iC;
    }

    public int d(int i2, int i3) {
        synchronized (c.class) {
            int iC = c("next_job_scheduler_id");
            if (iC < i2 || iC > i3) {
                e("next_job_scheduler_id", i2 + 1);
            } else {
                i2 = iC;
            }
        }
        return i2;
    }
}
