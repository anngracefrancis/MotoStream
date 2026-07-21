package androidx.work.impl.utils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.work.impl.WorkDatabase;

/* JADX INFO: compiled from: PreferenceUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class e {
    private final WorkDatabase a;

    public e(WorkDatabase workDatabase) {
        this.a = workDatabase;
    }

    public static void b(Context context, c.u.a.b bVar) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("androidx.work.util.preferences", 0);
        if (sharedPreferences.contains("reschedule_needed") || sharedPreferences.contains("last_cancel_all_time_ms")) {
            long j2 = sharedPreferences.getLong("last_cancel_all_time_ms", 0L);
            long j3 = sharedPreferences.getBoolean("reschedule_needed", false) ? 1L : 0L;
            bVar.n();
            try {
                bVar.l0("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"last_cancel_all_time_ms", Long.valueOf(j2)});
                bVar.l0("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"reschedule_needed", Long.valueOf(j3)});
                sharedPreferences.edit().clear().apply();
                bVar.j0();
            } finally {
                bVar.z0();
            }
        }
    }

    public boolean a() {
        Long lA = this.a.f().a("reschedule_needed");
        return lA != null && lA.longValue() == 1;
    }

    public void c(boolean z) {
        this.a.f().b(new androidx.work.impl.n.d("reschedule_needed", z));
    }
}
