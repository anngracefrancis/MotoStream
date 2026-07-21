package androidx.preference;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ExpandButton.java */
/* JADX INFO: loaded from: classes.dex */
final class b extends Preference {
    private long V;

    b(Context context, List<Preference> list, long j2) {
        super(context);
        Z0();
        a1(list);
        this.V = j2 + 1000000;
    }

    private void Z0() {
        L0(q.a);
        I0(o.a);
        R0(r.f1882b);
        O0(androidx.room.j.MAX_BIND_PARAMETER_CNT);
    }

    private void a1(List<Preference> list) {
        ArrayList arrayList = new ArrayList();
        CharSequence string = null;
        for (Preference preference : list) {
            CharSequence charSequenceW = preference.W();
            boolean z = preference instanceof PreferenceGroup;
            if (z && !TextUtils.isEmpty(charSequenceW)) {
                arrayList.add((PreferenceGroup) preference);
            }
            if (arrayList.contains(preference.M())) {
                if (z) {
                    arrayList.add((PreferenceGroup) preference);
                }
            } else if (!TextUtils.isEmpty(charSequenceW)) {
                string = string == null ? charSequenceW : D().getString(r.f1885e, string, charSequenceW);
            }
        }
        P0(string);
    }

    @Override // androidx.preference.Preference
    long H() {
        return this.V;
    }

    @Override // androidx.preference.Preference
    public void k0(l lVar) {
        super.k0(lVar);
        lVar.d(false);
    }
}
