package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.Switch;

/* JADX INFO: loaded from: classes.dex */
public class SwitchPreference extends TwoStatePreference {
    private final a a0;
    private CharSequence b0;
    private CharSequence c0;

    private class a implements CompoundButton.OnCheckedChangeListener {
        a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (SwitchPreference.this.k(Boolean.valueOf(z))) {
                SwitchPreference.this.a1(z);
            } else {
                compoundButton.setChecked(!z);
            }
        }
    }

    public SwitchPreference(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.a0 = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t.C1, i2, i3);
        d1(androidx.core.content.d.g.o(typedArrayObtainStyledAttributes, t.K1, t.D1));
        c1(androidx.core.content.d.g.o(typedArrayObtainStyledAttributes, t.J1, t.E1));
        h1(androidx.core.content.d.g.o(typedArrayObtainStyledAttributes, t.M1, t.G1));
        g1(androidx.core.content.d.g.o(typedArrayObtainStyledAttributes, t.L1, t.H1));
        b1(androidx.core.content.d.g.b(typedArrayObtainStyledAttributes, t.I1, t.F1, false));
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void i1(View view) {
        boolean z = view instanceof Switch;
        if (z) {
            ((Switch) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.V);
        }
        if (z) {
            Switch r4 = (Switch) view;
            r4.setTextOn(this.b0);
            r4.setTextOff(this.c0);
            r4.setOnCheckedChangeListener(this.a0);
        }
    }

    private void j1(View view) {
        if (((AccessibilityManager) D().getSystemService("accessibility")).isEnabled()) {
            i1(view.findViewById(R.id.switch_widget));
            e1(view.findViewById(R.id.summary));
        }
    }

    public void g1(CharSequence charSequence) {
        this.c0 = charSequence;
        e0();
    }

    public void h1(CharSequence charSequence) {
        this.b0 = charSequence;
        e0();
    }

    @Override // androidx.preference.Preference
    public void k0(l lVar) {
        super.k0(lVar);
        i1(lVar.a(R.id.switch_widget));
        f1(lVar);
    }

    @Override // androidx.preference.Preference
    protected void x0(View view) {
        super.x0(view);
        j1(view);
    }

    public SwitchPreference(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public SwitchPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.core.content.d.g.a(context, m.m, R.attr.switchPreferenceStyle));
    }
}
