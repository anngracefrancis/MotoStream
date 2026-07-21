package androidx.preference;

import android.R;
import android.content.Context;
import android.util.AttributeSet;

/* JADX INFO: loaded from: classes.dex */
public final class PreferenceScreen extends PreferenceGroup {
    private boolean e0;

    public PreferenceScreen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, androidx.core.content.d.g.a(context, m.f1870h, R.attr.preferenceScreenStyle));
        this.e0 = true;
    }

    @Override // androidx.preference.PreferenceGroup
    protected boolean g1() {
        return false;
    }

    @Override // androidx.preference.Preference
    protected void l0() {
        j.b bVarE;
        if (I() != null || G() != null || f1() == 0 || (bVarE = S().e()) == null) {
            return;
        }
        bVarE.onNavigateToScreen(this);
    }

    public boolean n1() {
        return this.e0;
    }
}
