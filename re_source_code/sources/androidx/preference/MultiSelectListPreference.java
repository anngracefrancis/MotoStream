package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class MultiSelectListPreference extends DialogPreference {
    private CharSequence[] b0;
    private CharSequence[] c0;
    private Set<String> d0;

    public MultiSelectListPreference(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.d0 = new HashSet();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t.j0, i2, i3);
        this.b0 = androidx.core.content.d.g.q(typedArrayObtainStyledAttributes, t.m0, t.k0);
        this.c0 = androidx.core.content.d.g.q(typedArrayObtainStyledAttributes, t.n0, t.l0);
        typedArrayObtainStyledAttributes.recycle();
    }

    public CharSequence[] f1() {
        return this.b0;
    }

    public CharSequence[] g1() {
        return this.c0;
    }

    public Set<String> h1() {
        return this.d0;
    }

    public void i1(Set<String> set) {
        this.d0.clear();
        this.d0.addAll(set);
        B0(set);
        e0();
    }

    @Override // androidx.preference.Preference
    protected Object o0(TypedArray typedArray, int i2) {
        CharSequence[] textArray = typedArray.getTextArray(i2);
        HashSet hashSet = new HashSet();
        for (CharSequence charSequence : textArray) {
            hashSet.add(charSequence.toString());
        }
        return hashSet;
    }

    @Override // androidx.preference.Preference
    protected void s0(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(SavedState.class)) {
            super.s0(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.s0(savedState.getSuperState());
        i1(savedState.f1796f);
    }

    @Override // androidx.preference.Preference
    protected Parcelable t0() {
        Parcelable parcelableT0 = super.t0();
        if (b0()) {
            return parcelableT0;
        }
        SavedState savedState = new SavedState(parcelableT0);
        savedState.f1796f = h1();
        return savedState;
    }

    @Override // androidx.preference.Preference
    protected void u0(Object obj) {
        i1(Q((Set) obj));
    }

    private static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Set<String> f1796f;

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
            int i2 = parcel.readInt();
            this.f1796f = new HashSet();
            String[] strArr = new String[i2];
            parcel.readStringArray(strArr);
            Collections.addAll(this.f1796f, strArr);
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f1796f.size());
            Set<String> set = this.f1796f;
            parcel.writeStringArray((String[]) set.toArray(new String[set.size()]));
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public MultiSelectListPreference(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public MultiSelectListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.core.content.d.g.a(context, m.f1865c, R.attr.dialogPreferenceStyle));
    }
}
