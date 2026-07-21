package androidx.preference;

import android.R;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.u;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class Preference implements Comparable<Preference> {
    private Object A;
    private boolean B;
    private boolean C;
    private boolean D;
    private boolean E;
    private boolean F;
    private boolean G;
    private boolean H;
    private boolean I;
    private boolean J;
    private boolean K;
    private int L;
    private int M;
    private b N;
    private List<Preference> O;
    private PreferenceGroup P;
    private boolean Q;
    private boolean R;
    private e S;
    private f T;
    private final View.OnClickListener U;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Context f1797f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private j f1798g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private androidx.preference.e f1799h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f1800i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f1801j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private c f1802k;
    private d l;
    private int m;
    private int n;
    private CharSequence o;
    private CharSequence p;
    private int q;
    private Drawable r;
    private String s;
    private Intent t;
    private String u;
    private Bundle v;
    private boolean w;
    private boolean x;
    private boolean y;
    private String z;

    public static class BaseSavedState extends AbsSavedState {
        public static final Parcelable.Creator<BaseSavedState> CREATOR = new a();

        static class a implements Parcelable.Creator<BaseSavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public BaseSavedState createFromParcel(Parcel parcel) {
                return new BaseSavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public BaseSavedState[] newArray(int i2) {
                return new BaseSavedState[i2];
            }
        }

        public BaseSavedState(Parcel parcel) {
            super(parcel);
        }

        public BaseSavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Preference.this.x0(view);
        }
    }

    interface b {
        void a(Preference preference);

        void b(Preference preference);

        void e(Preference preference);
    }

    public interface c {
        boolean a(Preference preference, Object obj);
    }

    public interface d {
        boolean onPreferenceClick(Preference preference);
    }

    private static class e implements View.OnCreateContextMenuListener, MenuItem.OnMenuItemClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Preference f1804f;

        e(Preference preference) {
            this.f1804f = preference;
        }

        @Override // android.view.View.OnCreateContextMenuListener
        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            CharSequence charSequenceU = this.f1804f.U();
            if (!this.f1804f.Z() || TextUtils.isEmpty(charSequenceU)) {
                return;
            }
            contextMenu.setHeaderTitle(charSequenceU);
            contextMenu.add(0, 0, 0, r.a).setOnMenuItemClickListener(this);
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            ClipboardManager clipboardManager = (ClipboardManager) this.f1804f.D().getSystemService("clipboard");
            CharSequence charSequenceU = this.f1804f.U();
            clipboardManager.setPrimaryClip(ClipData.newPlainText("Preference", charSequenceU));
            Toast.makeText(this.f1804f.D(), this.f1804f.D().getString(r.f1884d, charSequenceU), 0).show();
            return true;
        }
    }

    public interface f<T extends Preference> {
        CharSequence a(T t);
    }

    public Preference(Context context, AttributeSet attributeSet, int i2, int i3) {
        this.m = Integer.MAX_VALUE;
        this.n = 0;
        this.w = true;
        this.x = true;
        this.y = true;
        this.B = true;
        this.C = true;
        this.D = true;
        this.E = true;
        this.F = true;
        this.H = true;
        this.K = true;
        int i4 = q.f1879b;
        this.L = i4;
        this.U = new a();
        this.f1797f = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t.q0, i2, i3);
        this.q = androidx.core.content.d.g.n(typedArrayObtainStyledAttributes, t.O0, t.r0, 0);
        this.s = androidx.core.content.d.g.o(typedArrayObtainStyledAttributes, t.R0, t.x0);
        this.o = androidx.core.content.d.g.p(typedArrayObtainStyledAttributes, t.Z0, t.v0);
        this.p = androidx.core.content.d.g.p(typedArrayObtainStyledAttributes, t.Y0, t.y0);
        this.m = androidx.core.content.d.g.d(typedArrayObtainStyledAttributes, t.T0, t.z0, Integer.MAX_VALUE);
        this.u = androidx.core.content.d.g.o(typedArrayObtainStyledAttributes, t.N0, t.E0);
        this.L = androidx.core.content.d.g.n(typedArrayObtainStyledAttributes, t.S0, t.u0, i4);
        this.M = androidx.core.content.d.g.n(typedArrayObtainStyledAttributes, t.a1, t.A0, 0);
        this.w = androidx.core.content.d.g.b(typedArrayObtainStyledAttributes, t.M0, t.t0, true);
        this.x = androidx.core.content.d.g.b(typedArrayObtainStyledAttributes, t.V0, t.w0, true);
        this.y = androidx.core.content.d.g.b(typedArrayObtainStyledAttributes, t.U0, t.s0, true);
        this.z = androidx.core.content.d.g.o(typedArrayObtainStyledAttributes, t.K0, t.B0);
        int i5 = t.H0;
        this.E = androidx.core.content.d.g.b(typedArrayObtainStyledAttributes, i5, i5, this.x);
        int i6 = t.I0;
        this.F = androidx.core.content.d.g.b(typedArrayObtainStyledAttributes, i6, i6, this.x);
        int i7 = t.J0;
        if (typedArrayObtainStyledAttributes.hasValue(i7)) {
            this.A = o0(typedArrayObtainStyledAttributes, i7);
        } else {
            int i8 = t.C0;
            if (typedArrayObtainStyledAttributes.hasValue(i8)) {
                this.A = o0(typedArrayObtainStyledAttributes, i8);
            }
        }
        this.K = androidx.core.content.d.g.b(typedArrayObtainStyledAttributes, t.W0, t.D0, true);
        int i9 = t.X0;
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(i9);
        this.G = zHasValue;
        if (zHasValue) {
            this.H = androidx.core.content.d.g.b(typedArrayObtainStyledAttributes, i9, t.F0, true);
        }
        this.I = androidx.core.content.d.g.b(typedArrayObtainStyledAttributes, t.P0, t.G0, false);
        int i10 = t.Q0;
        this.D = androidx.core.content.d.g.b(typedArrayObtainStyledAttributes, i10, i10, true);
        int i11 = t.L0;
        this.J = androidx.core.content.d.g.b(typedArrayObtainStyledAttributes, i11, i11, false);
        typedArrayObtainStyledAttributes.recycle();
    }

    private void C0() {
        if (TextUtils.isEmpty(this.z)) {
            return;
        }
        Preference preferenceA = A(this.z);
        if (preferenceA != null) {
            preferenceA.D0(this);
            return;
        }
        throw new IllegalStateException("Dependency \"" + this.z + "\" not found for preference \"" + this.s + "\" (title: \"" + ((Object) this.o) + "\"");
    }

    private void D0(Preference preference) {
        if (this.O == null) {
            this.O = new ArrayList();
        }
        this.O.add(preference);
        preference.m0(this, U0());
    }

    private void H0(View view, boolean z) {
        view.setEnabled(z);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                H0(viewGroup.getChildAt(childCount), z);
            }
        }
    }

    private void W0(SharedPreferences.Editor editor) {
        if (this.f1798g.r()) {
            editor.apply();
        }
    }

    private void X0() {
        Preference preferenceA;
        String str = this.z;
        if (str == null || (preferenceA = A(str)) == null) {
            return;
        }
        preferenceA.Y0(this);
    }

    private void Y0(Preference preference) {
        List<Preference> list = this.O;
        if (list != null) {
            list.remove(preference);
        }
    }

    private void y() {
        if (R() != null) {
            v0(true, this.A);
            return;
        }
        if (V0() && T().contains(this.s)) {
            v0(true, null);
            return;
        }
        Object obj = this.A;
        if (obj != null) {
            v0(false, obj);
        }
    }

    protected <T extends Preference> T A(String str) {
        j jVar = this.f1798g;
        if (jVar == null) {
            return null;
        }
        return (T) jVar.a(str);
    }

    protected boolean A0(String str) {
        if (!V0()) {
            return false;
        }
        if (TextUtils.equals(str, P(null))) {
            return true;
        }
        if (R() != null) {
            throw null;
        }
        SharedPreferences.Editor editorC = this.f1798g.c();
        editorC.putString(this.s, str);
        W0(editorC);
        return true;
    }

    public boolean B0(Set<String> set) {
        if (!V0()) {
            return false;
        }
        if (set.equals(Q(null))) {
            return true;
        }
        if (R() != null) {
            throw null;
        }
        SharedPreferences.Editor editorC = this.f1798g.c();
        editorC.putStringSet(this.s, set);
        W0(editorC);
        return true;
    }

    public Context D() {
        return this.f1797f;
    }

    public Bundle E() {
        if (this.v == null) {
            this.v = new Bundle();
        }
        return this.v;
    }

    public void E0(Bundle bundle) {
        v(bundle);
    }

    StringBuilder F() {
        StringBuilder sb = new StringBuilder();
        CharSequence charSequenceW = W();
        if (!TextUtils.isEmpty(charSequenceW)) {
            sb.append(charSequenceW);
            sb.append(' ');
        }
        CharSequence charSequenceU = U();
        if (!TextUtils.isEmpty(charSequenceU)) {
            sb.append(charSequenceU);
            sb.append(' ');
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb;
    }

    public void F0(Bundle bundle) {
        x(bundle);
    }

    public String G() {
        return this.u;
    }

    public void G0(boolean z) {
        if (this.w != z) {
            this.w = z;
            f0(U0());
            e0();
        }
    }

    long H() {
        return this.f1800i;
    }

    public Intent I() {
        return this.t;
    }

    public void I0(int i2) {
        J0(c.a.k.a.a.d(this.f1797f, i2));
        this.q = i2;
    }

    public String J() {
        return this.s;
    }

    public void J0(Drawable drawable) {
        if (this.r != drawable) {
            this.r = drawable;
            this.q = 0;
            e0();
        }
    }

    public final int K() {
        return this.L;
    }

    public void K0(Intent intent) {
        this.t = intent;
    }

    public int L() {
        return this.m;
    }

    public void L0(int i2) {
        this.L = i2;
    }

    public PreferenceGroup M() {
        return this.P;
    }

    final void M0(b bVar) {
        this.N = bVar;
    }

    protected boolean N(boolean z) {
        if (!V0()) {
            return z;
        }
        if (R() == null) {
            return this.f1798g.j().getBoolean(this.s, z);
        }
        throw null;
    }

    public void N0(d dVar) {
        this.l = dVar;
    }

    protected int O(int i2) {
        if (!V0()) {
            return i2;
        }
        if (R() == null) {
            return this.f1798g.j().getInt(this.s, i2);
        }
        throw null;
    }

    public void O0(int i2) {
        if (i2 != this.m) {
            this.m = i2;
            g0();
        }
    }

    protected String P(String str) {
        if (!V0()) {
            return str;
        }
        if (R() == null) {
            return this.f1798g.j().getString(this.s, str);
        }
        throw null;
    }

    public void P0(CharSequence charSequence) {
        if (V() != null) {
            throw new IllegalStateException("Preference already has a SummaryProvider set.");
        }
        if (TextUtils.equals(this.p, charSequence)) {
            return;
        }
        this.p = charSequence;
        e0();
    }

    public Set<String> Q(Set<String> set) {
        if (!V0()) {
            return set;
        }
        if (R() == null) {
            return this.f1798g.j().getStringSet(this.s, set);
        }
        throw null;
    }

    public final void Q0(f fVar) {
        this.T = fVar;
        e0();
    }

    public androidx.preference.e R() {
        androidx.preference.e eVar = this.f1799h;
        if (eVar != null) {
            return eVar;
        }
        j jVar = this.f1798g;
        if (jVar != null) {
            return jVar.h();
        }
        return null;
    }

    public void R0(int i2) {
        S0(this.f1797f.getString(i2));
    }

    public j S() {
        return this.f1798g;
    }

    public void S0(CharSequence charSequence) {
        if ((charSequence != null || this.o == null) && (charSequence == null || charSequence.equals(this.o))) {
            return;
        }
        this.o = charSequence;
        e0();
    }

    public SharedPreferences T() {
        if (this.f1798g == null || R() != null) {
            return null;
        }
        return this.f1798g.j();
    }

    public final void T0(boolean z) {
        if (this.D != z) {
            this.D = z;
            b bVar = this.N;
            if (bVar != null) {
                bVar.b(this);
            }
        }
    }

    public CharSequence U() {
        return V() != null ? V().a(this) : this.p;
    }

    public boolean U0() {
        return !a0();
    }

    public final f V() {
        return this.T;
    }

    protected boolean V0() {
        return this.f1798g != null && b0() && Y();
    }

    public CharSequence W() {
        return this.o;
    }

    public final int X() {
        return this.M;
    }

    public boolean Y() {
        return !TextUtils.isEmpty(this.s);
    }

    public boolean Z() {
        return this.J;
    }

    public boolean a0() {
        return this.w && this.B && this.C;
    }

    public boolean b0() {
        return this.y;
    }

    public boolean c0() {
        return this.x;
    }

    public final boolean d0() {
        return this.D;
    }

    protected void e0() {
        b bVar = this.N;
        if (bVar != null) {
            bVar.e(this);
        }
    }

    public void f0(boolean z) {
        List<Preference> list = this.O;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            list.get(i2).m0(this, z);
        }
    }

    void g(PreferenceGroup preferenceGroup) {
        if (preferenceGroup != null && this.P != null) {
            throw new IllegalStateException("This preference already has a parent. You must remove the existing parent before assigning a new one.");
        }
        this.P = preferenceGroup;
    }

    protected void g0() {
        b bVar = this.N;
        if (bVar != null) {
            bVar.a(this);
        }
    }

    public void h0() {
        C0();
    }

    protected void i0(j jVar) {
        this.f1798g = jVar;
        if (!this.f1801j) {
            this.f1800i = jVar.d();
        }
        y();
    }

    protected void j0(j jVar, long j2) {
        this.f1800i = j2;
        this.f1801j = true;
        try {
            i0(jVar);
        } finally {
            this.f1801j = false;
        }
    }

    public boolean k(Object obj) {
        c cVar = this.f1802k;
        return cVar == null || cVar.a(this, obj);
    }

    public void k0(l lVar) {
        Integer numValueOf;
        View view = lVar.itemView;
        view.setOnClickListener(this.U);
        view.setId(this.n);
        TextView textView = (TextView) lVar.a(R.id.summary);
        if (textView != null) {
            CharSequence charSequenceU = U();
            if (TextUtils.isEmpty(charSequenceU)) {
                textView.setVisibility(8);
                numValueOf = null;
            } else {
                textView.setText(charSequenceU);
                textView.setVisibility(0);
                numValueOf = Integer.valueOf(textView.getCurrentTextColor());
            }
        } else {
            numValueOf = null;
        }
        TextView textView2 = (TextView) lVar.a(R.id.title);
        if (textView2 != null) {
            CharSequence charSequenceW = W();
            if (TextUtils.isEmpty(charSequenceW)) {
                textView2.setVisibility(8);
            } else {
                textView2.setText(charSequenceW);
                textView2.setVisibility(0);
                if (this.G) {
                    textView2.setSingleLine(this.H);
                }
                if (!c0() && a0() && numValueOf != null) {
                    textView2.setTextColor(numValueOf.intValue());
                }
            }
        }
        ImageView imageView = (ImageView) lVar.a(R.id.icon);
        if (imageView != null) {
            int i2 = this.q;
            if (i2 != 0 || this.r != null) {
                if (this.r == null) {
                    this.r = c.a.k.a.a.d(this.f1797f, i2);
                }
                Drawable drawable = this.r;
                if (drawable != null) {
                    imageView.setImageDrawable(drawable);
                }
            }
            if (this.r != null) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(this.I ? 4 : 8);
            }
        }
        View viewA = lVar.a(p.a);
        if (viewA == null) {
            viewA = lVar.a(R.id.icon_frame);
        }
        if (viewA != null) {
            if (this.r != null) {
                viewA.setVisibility(0);
            } else {
                viewA.setVisibility(this.I ? 4 : 8);
            }
        }
        if (this.K) {
            H0(view, a0());
        } else {
            H0(view, true);
        }
        boolean zC0 = c0();
        view.setFocusable(zC0);
        view.setClickable(zC0);
        lVar.d(this.E);
        lVar.e(this.F);
        boolean Z = Z();
        if (Z && this.S == null) {
            this.S = new e(this);
        }
        view.setOnCreateContextMenuListener(Z ? this.S : null);
        view.setLongClickable(Z);
        if (!Z || zC0) {
            return;
        }
        u.m0(view, null);
    }

    protected void l0() {
    }

    public void m0(Preference preference, boolean z) {
        if (this.B == z) {
            this.B = !z;
            f0(U0());
            e0();
        }
    }

    public void n0() {
        X0();
        this.Q = true;
    }

    protected Object o0(TypedArray typedArray, int i2) {
        return null;
    }

    @Deprecated
    public void p0(androidx.core.view.d0.c cVar) {
    }

    final void q() {
        this.Q = false;
    }

    public void q0(Preference preference, boolean z) {
        if (this.C == z) {
            this.C = !z;
            f0(U0());
            e0();
        }
    }

    protected void r0() {
        X0();
    }

    protected void s0(Parcelable parcelable) {
        this.R = true;
        if (parcelable != AbsSavedState.EMPTY_STATE && parcelable != null) {
            throw new IllegalArgumentException("Wrong state class -- expecting Preference State");
        }
    }

    protected Parcelable t0() {
        this.R = true;
        return AbsSavedState.EMPTY_STATE;
    }

    public String toString() {
        return F().toString();
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public int compareTo(Preference preference) {
        int i2 = this.m;
        int i3 = preference.m;
        if (i2 != i3) {
            return i2 - i3;
        }
        CharSequence charSequence = this.o;
        CharSequence charSequence2 = preference.o;
        if (charSequence == charSequence2) {
            return 0;
        }
        if (charSequence == null) {
            return 1;
        }
        if (charSequence2 == null) {
            return -1;
        }
        return charSequence.toString().compareToIgnoreCase(preference.o.toString());
    }

    protected void u0(Object obj) {
    }

    void v(Bundle bundle) {
        Parcelable parcelable;
        if (!Y() || (parcelable = bundle.getParcelable(this.s)) == null) {
            return;
        }
        this.R = false;
        s0(parcelable);
        if (!this.R) {
            throw new IllegalStateException("Derived class did not call super.onRestoreInstanceState()");
        }
    }

    @Deprecated
    protected void v0(boolean z, Object obj) {
        u0(obj);
    }

    public void w0() {
        j.c cVarF;
        if (a0() && c0()) {
            l0();
            d dVar = this.l;
            if (dVar == null || !dVar.onPreferenceClick(this)) {
                j jVarS = S();
                if ((jVarS == null || (cVarF = jVarS.f()) == null || !cVarF.onPreferenceTreeClick(this)) && this.t != null) {
                    D().startActivity(this.t);
                }
            }
        }
    }

    void x(Bundle bundle) {
        if (Y()) {
            this.R = false;
            Parcelable parcelableT0 = t0();
            if (!this.R) {
                throw new IllegalStateException("Derived class did not call super.onSaveInstanceState()");
            }
            if (parcelableT0 != null) {
                bundle.putParcelable(this.s, parcelableT0);
            }
        }
    }

    protected void x0(View view) {
        w0();
    }

    protected boolean y0(boolean z) {
        if (!V0()) {
            return false;
        }
        if (z == N(!z)) {
            return true;
        }
        if (R() != null) {
            throw null;
        }
        SharedPreferences.Editor editorC = this.f1798g.c();
        editorC.putBoolean(this.s, z);
        W0(editorC);
        return true;
    }

    protected boolean z0(int i2) {
        if (!V0()) {
            return false;
        }
        if (i2 == O(i2 ^ (-1))) {
            return true;
        }
        if (R() != null) {
            throw null;
        }
        SharedPreferences.Editor editorC = this.f1798g.c();
        editorC.putInt(this.s, i2);
        W0(editorC);
        return true;
    }

    public Preference(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public Preference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.core.content.d.g.a(context, m.f1871i, R.attr.preferenceStyle));
    }

    public Preference(Context context) {
        this(context, null);
    }
}
