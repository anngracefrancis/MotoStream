package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;

/* JADX INFO: loaded from: classes.dex */
public class CheckBoxPreference extends TwoStatePreference {
    private final a a0;

    private class a implements CompoundButton.OnCheckedChangeListener {
        a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (CheckBoxPreference.this.k(Boolean.valueOf(z))) {
                CheckBoxPreference.this.a1(z);
            } else {
                compoundButton.setChecked(!z);
            }
        }
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void g1(View view) {
        boolean z = view instanceof CompoundButton;
        if (z) {
            ((CompoundButton) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.V);
        }
        if (z) {
            ((CompoundButton) view).setOnCheckedChangeListener(this.a0);
        }
    }

    private void h1(View view) {
        if (((AccessibilityManager) D().getSystemService("accessibility")).isEnabled()) {
            g1(view.findViewById(R.id.checkbox));
            e1(view.findViewById(R.id.summary));
        }
    }

    @Override // androidx.preference.Preference
    public void k0(l lVar) {
        super.k0(lVar);
        g1(lVar.a(R.id.checkbox));
        f1(lVar);
    }

    @Override // androidx.preference.Preference
    protected void x0(View view) {
        super.x0(view);
        h1(view);
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.a0 = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t.s, i2, i3);
        d1(androidx.core.content.d.g.o(typedArrayObtainStyledAttributes, t.y, t.t));
        c1(androidx.core.content.d.g.o(typedArrayObtainStyledAttributes, t.x, t.u));
        b1(androidx.core.content.d.g.b(typedArrayObtainStyledAttributes, t.w, t.v, false));
        typedArrayObtainStyledAttributes.recycle();
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.core.content.d.g.a(context, m.a, R.attr.checkBoxPreferenceStyle));
    }
}
