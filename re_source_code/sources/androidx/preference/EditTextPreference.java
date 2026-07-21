package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.EditText;

/* JADX INFO: loaded from: classes.dex */
public class EditTextPreference extends DialogPreference {
    private String b0;
    private a c0;

    public interface a {
        void a(EditText editText);
    }

    public static final class b implements Preference.f<EditTextPreference> {
        private static b a;

        private b() {
        }

        public static b b() {
            if (a == null) {
                a = new b();
            }
            return a;
        }

        @Override // androidx.preference.Preference.f
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public CharSequence a(EditTextPreference editTextPreference) {
            return TextUtils.isEmpty(editTextPreference.g1()) ? editTextPreference.D().getString(r.f1883c) : editTextPreference.g1();
        }
    }

    public EditTextPreference(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t.R, i2, i3);
        int i4 = t.S;
        if (androidx.core.content.d.g.b(typedArrayObtainStyledAttributes, i4, i4, false)) {
            Q0(b.b());
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.Preference
    public boolean U0() {
        return TextUtils.isEmpty(this.b0) || super.U0();
    }

    a f1() {
        return this.c0;
    }

    public String g1() {
        return this.b0;
    }

    public void h1(String str) {
        boolean zU0 = U0();
        this.b0 = str;
        A0(str);
        boolean zU1 = U0();
        if (zU1 != zU0) {
            f0(zU1);
        }
        e0();
    }

    @Override // androidx.preference.Preference
    protected Object o0(TypedArray typedArray, int i2) {
        return typedArray.getString(i2);
    }

    @Override // androidx.preference.Preference
    protected void s0(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(SavedState.class)) {
            super.s0(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.s0(savedState.getSuperState());
        h1(savedState.f1794f);
    }

    @Override // androidx.preference.Preference
    protected Parcelable t0() {
        Parcelable parcelableT0 = super.t0();
        if (b0()) {
            return parcelableT0;
        }
        SavedState savedState = new SavedState(parcelableT0);
        savedState.f1794f = g1();
        return savedState;
    }

    @Override // androidx.preference.Preference
    protected void u0(Object obj) {
        h1(P((String) obj));
    }

    private static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        String f1794f;

        static class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.f1794f = parcel.readString();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeString(this.f1794f);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public EditTextPreference(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public EditTextPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.core.content.d.g.a(context, m.f1867e, R.attr.editTextPreferenceStyle));
    }
}
