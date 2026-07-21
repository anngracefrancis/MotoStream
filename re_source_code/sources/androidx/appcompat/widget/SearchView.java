package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.customview.view.AbsSavedState;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes.dex */
public class SearchView extends c0 implements c.a.o.c {
    static final n u;
    final ImageView A;
    final ImageView B;
    final ImageView C;
    private final View D;
    private o E;
    private Rect F;
    private Rect G;
    private int[] H;
    private int[] I;
    private final ImageView J;
    private final Drawable K;
    private final int L;
    private final int M;
    private final Intent N;
    private final Intent O;
    private final CharSequence P;
    private l Q;
    private k R;
    View.OnFocusChangeListener S;
    private m T;
    private View.OnClickListener U;
    private boolean V;
    private boolean W;
    c.j.a.a a0;
    private boolean b0;
    private CharSequence c0;
    private boolean d0;
    private boolean e0;
    private int f0;
    private boolean g0;
    private CharSequence h0;
    private CharSequence i0;
    private boolean j0;
    private int k0;
    SearchableInfo l0;
    private Bundle m0;
    private final Runnable n0;
    private Runnable o0;
    private final WeakHashMap<String, Drawable.ConstantState> p0;
    private final View.OnClickListener q0;
    View.OnKeyListener r0;
    private final TextView.OnEditorActionListener s0;
    private final AdapterView.OnItemClickListener t0;
    private final AdapterView.OnItemSelectedListener u0;
    final SearchAutoComplete v;
    private TextWatcher v0;
    private final View w;
    private final View x;
    private final View y;
    final ImageView z;

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        boolean f425h;

        class a implements Parcelable.ClassLoaderCreator<SavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f425h + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeValue(Boolean.valueOf(this.f425h));
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f425h = ((Boolean) parcel.readValue(null)).booleanValue();
        }
    }

    public static class SearchAutoComplete extends androidx.appcompat.widget.c {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f426i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private SearchView f427j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private boolean f428k;
        final Runnable l;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SearchAutoComplete.this.c();
            }
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, c.a.a.p);
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i2 = configuration.screenWidthDp;
            int i3 = configuration.screenHeightDp;
            if (i2 >= 960 && i3 >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (i2 < 600) {
                return (i2 < 640 || i3 < 480) ? 160 : 192;
            }
            return 192;
        }

        void a() {
            if (Build.VERSION.SDK_INT < 29) {
                SearchView.u.c(this);
                return;
            }
            setInputMethodMode(1);
            if (enoughToFilter()) {
                showDropDown();
            }
        }

        boolean b() {
            return TextUtils.getTrimmedLength(getText()) == 0;
        }

        void c() {
            if (this.f428k) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                this.f428k = false;
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public boolean enoughToFilter() {
            return this.f426i <= 0 || super.enoughToFilter();
        }

        @Override // androidx.appcompat.widget.c, android.widget.TextView, android.view.View
        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.f428k) {
                removeCallbacks(this.l);
                post(this.l);
            }
            return inputConnectionOnCreateInputConnection;
        }

        @Override // android.view.View
        protected void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        protected void onFocusChanged(boolean z, int i2, Rect rect) {
            super.onFocusChanged(z, i2, rect);
            this.f427j.Z();
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public boolean onKeyPreIme(int i2, KeyEvent keyEvent) {
            if (i2 == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                }
                if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f427j.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i2, keyEvent);
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.f427j.hasFocus() && getVisibility() == 0) {
                this.f428k = true;
                if (SearchView.M(getContext())) {
                    a();
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView
        protected void replaceText(CharSequence charSequence) {
        }

        void setImeVisibility(boolean z) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z) {
                this.f428k = false;
                removeCallbacks(this.l);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else {
                if (!inputMethodManager.isActive(this)) {
                    this.f428k = true;
                    return;
                }
                this.f428k = false;
                removeCallbacks(this.l);
                inputMethodManager.showSoftInput(this, 0);
            }
        }

        void setSearchView(SearchView searchView) {
            this.f427j = searchView;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int i2) {
            super.setThreshold(i2);
            this.f426i = i2;
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i2) {
            super(context, attributeSet, i2);
            this.l = new a();
            this.f426i = getThreshold();
        }
    }

    class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            SearchView.this.Y(charSequence);
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SearchView.this.f0();
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.j.a.a aVar = SearchView.this.a0;
            if (aVar instanceof k0) {
                aVar.changeCursor(null);
            }
        }
    }

    class d implements View.OnFocusChangeListener {
        d() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            SearchView searchView = SearchView.this;
            View.OnFocusChangeListener onFocusChangeListener = searchView.S;
            if (onFocusChangeListener != null) {
                onFocusChangeListener.onFocusChange(searchView, z);
            }
        }
    }

    class e implements View.OnLayoutChangeListener {
        e() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            SearchView.this.B();
        }
    }

    class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SearchView searchView = SearchView.this;
            if (view == searchView.z) {
                searchView.V();
                return;
            }
            if (view == searchView.B) {
                searchView.R();
                return;
            }
            if (view == searchView.A) {
                searchView.W();
            } else if (view == searchView.C) {
                searchView.a0();
            } else if (view == searchView.v) {
                searchView.H();
            }
        }
    }

    class g implements View.OnKeyListener {
        g() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i2, KeyEvent keyEvent) {
            SearchView searchView = SearchView.this;
            if (searchView.l0 == null) {
                return false;
            }
            if (searchView.v.isPopupShowing() && SearchView.this.v.getListSelection() != -1) {
                return SearchView.this.X(view, i2, keyEvent);
            }
            if (SearchView.this.v.b() || !keyEvent.hasNoModifiers() || keyEvent.getAction() != 1 || i2 != 66) {
                return false;
            }
            view.cancelLongPress();
            SearchView searchView2 = SearchView.this;
            searchView2.P(0, null, searchView2.v.getText().toString());
            return true;
        }
    }

    class h implements TextView.OnEditorActionListener {
        h() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            SearchView.this.W();
            return true;
        }
    }

    class i implements AdapterView.OnItemClickListener {
        i() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            SearchView.this.S(i2, 0, null);
        }
    }

    class j implements AdapterView.OnItemSelectedListener {
        j() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
            SearchView.this.T(i2);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    public interface k {
        boolean a();
    }

    public interface l {
        boolean a(String str);

        boolean b(String str);
    }

    public interface m {
        boolean onSuggestionClick(int i2);

        boolean onSuggestionSelect(int i2);
    }

    private static class n {
        private Method a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Method f438b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Method f439c;

        @SuppressLint({"DiscouragedPrivateApi", "SoonBlockedPrivateApi"})
        n() {
            this.a = null;
            this.f438b = null;
            this.f439c = null;
            d();
            try {
                Method declaredMethod = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                Method declaredMethod2 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.f438b = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            try {
                Method method = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                this.f439c = method;
                method.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
        }

        private static void d() {
            if (Build.VERSION.SDK_INT >= 29) {
                throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
            }
        }

        void a(AutoCompleteTextView autoCompleteTextView) {
            d();
            Method method = this.f438b;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        void b(AutoCompleteTextView autoCompleteTextView) {
            d();
            Method method = this.a;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        void c(AutoCompleteTextView autoCompleteTextView) {
            d();
            Method method = this.f439c;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, Boolean.TRUE);
                } catch (Exception unused) {
                }
            }
        }
    }

    private static class o extends TouchDelegate {
        private final View a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Rect f440b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Rect f441c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Rect f442d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f443e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f444f;

        public o(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.f443e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            this.f440b = new Rect();
            this.f442d = new Rect();
            this.f441c = new Rect();
            a(rect, rect2);
            this.a = view;
        }

        public void a(Rect rect, Rect rect2) {
            this.f440b.set(rect);
            this.f442d.set(rect);
            Rect rect3 = this.f442d;
            int i2 = this.f443e;
            rect3.inset(-i2, -i2);
            this.f441c.set(rect2);
        }

        /* JADX WARN: Code duplicated, block: B:20:0x003d  */
        @Override // android.view.TouchDelegate
        public boolean onTouchEvent(MotionEvent motionEvent) {
            boolean z;
            boolean z2;
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int action = motionEvent.getAction();
            boolean z3 = true;
            if (action != 0) {
                if (action == 1 || action == 2) {
                    z2 = this.f444f;
                    if (z2 && !this.f442d.contains(x, y)) {
                        z3 = z2;
                        z = false;
                    }
                } else if (action != 3) {
                    z = true;
                    z3 = false;
                } else {
                    z2 = this.f444f;
                    this.f444f = false;
                }
                z3 = z2;
                z = true;
            } else if (this.f440b.contains(x, y)) {
                this.f444f = true;
                z = true;
            } else {
                z = true;
                z3 = false;
            }
            if (!z3) {
                return false;
            }
            if (!z || this.f441c.contains(x, y)) {
                Rect rect = this.f441c;
                motionEvent.setLocation(x - rect.left, y - rect.top);
            } else {
                motionEvent.setLocation(this.a.getWidth() / 2, this.a.getHeight() / 2);
            }
            return this.a.dispatchTouchEvent(motionEvent);
        }
    }

    static {
        u = Build.VERSION.SDK_INT < 29 ? new n() : null;
    }

    public SearchView(Context context) {
        this(context, null);
    }

    private Intent C(String str, Uri uri, String str2, String str3, int i2, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.i0);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.m0;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        if (i2 != 0) {
            intent.putExtra("action_key", i2);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.l0.getSearchActivity());
        return intent;
    }

    private Intent D(Cursor cursor, int i2, String str) {
        int position;
        String strE;
        try {
            String strE2 = k0.e(cursor, "suggest_intent_action");
            if (strE2 == null) {
                strE2 = this.l0.getSuggestIntentAction();
            }
            if (strE2 == null) {
                strE2 = "android.intent.action.SEARCH";
            }
            String str2 = strE2;
            String strE3 = k0.e(cursor, "suggest_intent_data");
            if (strE3 == null) {
                strE3 = this.l0.getSuggestIntentData();
            }
            if (strE3 != null && (strE = k0.e(cursor, "suggest_intent_data_id")) != null) {
                strE3 = strE3 + "/" + Uri.encode(strE);
            }
            return C(str2, strE3 == null ? null : Uri.parse(strE3), k0.e(cursor, "suggest_intent_extra_data"), k0.e(cursor, "suggest_intent_query"), i2, str);
        } catch (RuntimeException e2) {
            try {
                position = cursor.getPosition();
            } catch (RuntimeException unused) {
                position = -1;
            }
            Log.w("SearchView", "Search suggestions cursor at row " + position + " returned exception.", e2);
            return null;
        }
    }

    private Intent E(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1073741824);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.m0;
        if (bundle2 != null) {
            bundle.putParcelable("app_data", bundle2);
        }
        Intent intent3 = new Intent(intent);
        Resources resources = getResources();
        String string = searchableInfo.getVoiceLanguageModeId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageModeId()) : "free_form";
        String string2 = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
        String string3 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
        int voiceMaxResults = searchableInfo.getVoiceMaxResults() != 0 ? searchableInfo.getVoiceMaxResults() : 1;
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", string);
        intent3.putExtra("android.speech.extra.PROMPT", string2);
        intent3.putExtra("android.speech.extra.LANGUAGE", string3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", voiceMaxResults);
        intent3.putExtra("calling_package", searchActivity != null ? searchActivity.flattenToShortString() : null);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    private Intent F(Intent intent, SearchableInfo searchableInfo) {
        Intent intent2 = new Intent(intent);
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        intent2.putExtra("calling_package", searchActivity == null ? null : searchActivity.flattenToShortString());
        return intent2;
    }

    private void G() {
        this.v.dismissDropDown();
    }

    private void I(View view, Rect rect) {
        view.getLocationInWindow(this.H);
        getLocationInWindow(this.I);
        int[] iArr = this.H;
        int i2 = iArr[1];
        int[] iArr2 = this.I;
        int i3 = i2 - iArr2[1];
        int i4 = iArr[0] - iArr2[0];
        rect.set(i4, i3, view.getWidth() + i4, view.getHeight() + i3);
    }

    private CharSequence J(CharSequence charSequence) {
        if (!this.V || this.K == null) {
            return charSequence;
        }
        double textSize = this.v.getTextSize();
        Double.isNaN(textSize);
        int i2 = (int) (textSize * 1.25d);
        this.K.setBounds(0, 0, i2, i2);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.K), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    private boolean K() {
        SearchableInfo searchableInfo = this.l0;
        if (searchableInfo == null || !searchableInfo.getVoiceSearchEnabled()) {
            return false;
        }
        Intent intent = null;
        if (this.l0.getVoiceSearchLaunchWebSearch()) {
            intent = this.N;
        } else if (this.l0.getVoiceSearchLaunchRecognizer()) {
            intent = this.O;
        }
        return (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) ? false : true;
    }

    static boolean M(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    private boolean N() {
        return (this.b0 || this.g0) && !L();
    }

    private void O(Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            getContext().startActivity(intent);
        } catch (RuntimeException e2) {
            Log.e("SearchView", "Failed launch activity: " + intent, e2);
        }
    }

    private boolean Q(int i2, int i3, String str) {
        Cursor cursor = this.a0.getCursor();
        if (cursor == null || !cursor.moveToPosition(i2)) {
            return false;
        }
        O(D(cursor, i3, str));
        return true;
    }

    private void b0() {
        post(this.n0);
    }

    private void c0(int i2) {
        Editable text = this.v.getText();
        Cursor cursor = this.a0.getCursor();
        if (cursor == null) {
            return;
        }
        if (!cursor.moveToPosition(i2)) {
            setQuery(text);
            return;
        }
        CharSequence charSequenceConvertToString = this.a0.convertToString(cursor);
        if (charSequenceConvertToString != null) {
            setQuery(charSequenceConvertToString);
        } else {
            setQuery(text);
        }
    }

    private void e0() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.v.getText());
        if (!z2 && (!this.V || this.j0)) {
            z = false;
        }
        this.B.setVisibility(z ? 0 : 8);
        Drawable drawable = this.B.getDrawable();
        if (drawable != null) {
            drawable.setState(z2 ? ViewGroup.ENABLED_STATE_SET : ViewGroup.EMPTY_STATE_SET);
        }
    }

    private void g0() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.v;
        if (queryHint == null) {
            queryHint = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        searchAutoComplete.setHint(J(queryHint));
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(c.a.d.f2707g);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(c.a.d.f2708h);
    }

    private void h0() {
        this.v.setThreshold(this.l0.getSuggestThreshold());
        this.v.setImeOptions(this.l0.getImeOptions());
        int inputType = this.l0.getInputType();
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.l0.getSuggestAuthority() != null) {
                inputType = inputType | 65536 | 524288;
            }
        }
        this.v.setInputType(inputType);
        c.j.a.a aVar = this.a0;
        if (aVar != null) {
            aVar.changeCursor(null);
        }
        if (this.l0.getSuggestAuthority() != null) {
            k0 k0Var = new k0(getContext(), this, this.l0, this.p0);
            this.a0 = k0Var;
            this.v.setAdapter(k0Var);
            ((k0) this.a0).n(this.d0 ? 2 : 1);
        }
    }

    private void i0() {
        this.y.setVisibility((N() && (this.A.getVisibility() == 0 || this.C.getVisibility() == 0)) ? 0 : 8);
    }

    private void j0(boolean z) {
        this.A.setVisibility((this.b0 && N() && hasFocus() && (z || !this.g0)) ? 0 : 8);
    }

    private void k0(boolean z) {
        this.W = z;
        int i2 = z ? 0 : 8;
        boolean z2 = !TextUtils.isEmpty(this.v.getText());
        this.z.setVisibility(i2);
        j0(z2);
        this.w.setVisibility(z ? 8 : 0);
        this.J.setVisibility((this.J.getDrawable() == null || this.V) ? 8 : 0);
        e0();
        l0(!z2);
        i0();
    }

    private void l0(boolean z) {
        int i2 = 8;
        if (this.g0 && !L() && z) {
            this.A.setVisibility(8);
            i2 = 0;
        }
        this.C.setVisibility(i2);
    }

    private void setQuery(CharSequence charSequence) {
        this.v.setText(charSequence);
        this.v.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    void B() {
        if (this.D.getWidth() > 1) {
            Resources resources = getContext().getResources();
            int paddingLeft = this.x.getPaddingLeft();
            Rect rect = new Rect();
            boolean zB = w0.b(this);
            int dimensionPixelSize = this.V ? resources.getDimensionPixelSize(c.a.d.f2705e) + resources.getDimensionPixelSize(c.a.d.f2706f) : 0;
            this.v.getDropDownBackground().getPadding(rect);
            this.v.setDropDownHorizontalOffset(zB ? -rect.left : paddingLeft - (rect.left + dimensionPixelSize));
            this.v.setDropDownWidth((((this.D.getWidth() + rect.left) + rect.right) + dimensionPixelSize) - paddingLeft);
        }
    }

    void H() {
        if (Build.VERSION.SDK_INT >= 29) {
            this.v.refreshAutoCompleteResults();
            return;
        }
        n nVar = u;
        nVar.b(this.v);
        nVar.a(this.v);
    }

    public boolean L() {
        return this.W;
    }

    void P(int i2, String str, String str2) {
        getContext().startActivity(C("android.intent.action.SEARCH", null, null, str2, i2, str));
    }

    void R() {
        if (!TextUtils.isEmpty(this.v.getText())) {
            this.v.setText(HttpUrl.FRAGMENT_ENCODE_SET);
            this.v.requestFocus();
            this.v.setImeVisibility(true);
        } else if (this.V) {
            k kVar = this.R;
            if (kVar == null || !kVar.a()) {
                clearFocus();
                k0(true);
            }
        }
    }

    boolean S(int i2, int i3, String str) {
        m mVar = this.T;
        if (mVar != null && mVar.onSuggestionClick(i2)) {
            return false;
        }
        Q(i2, 0, null);
        this.v.setImeVisibility(false);
        G();
        return true;
    }

    boolean T(int i2) {
        m mVar = this.T;
        if (mVar != null && mVar.onSuggestionSelect(i2)) {
            return false;
        }
        c0(i2);
        return true;
    }

    void U(CharSequence charSequence) {
        setQuery(charSequence);
    }

    void V() {
        k0(false);
        this.v.requestFocus();
        this.v.setImeVisibility(true);
        View.OnClickListener onClickListener = this.U;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    void W() {
        Editable text = this.v.getText();
        if (text == null || TextUtils.getTrimmedLength(text) <= 0) {
            return;
        }
        l lVar = this.Q;
        if (lVar == null || !lVar.b(text.toString())) {
            if (this.l0 != null) {
                P(0, null, text.toString());
            }
            this.v.setImeVisibility(false);
            G();
        }
    }

    boolean X(View view, int i2, KeyEvent keyEvent) {
        if (this.l0 != null && this.a0 != null && keyEvent.getAction() == 0 && keyEvent.hasNoModifiers()) {
            if (i2 == 66 || i2 == 84 || i2 == 61) {
                return S(this.v.getListSelection(), 0, null);
            }
            if (i2 == 21 || i2 == 22) {
                this.v.setSelection(i2 == 21 ? 0 : this.v.length());
                this.v.setListSelection(0);
                this.v.clearListSelection();
                this.v.a();
                return true;
            }
            if (i2 != 19 || this.v.getListSelection() == 0) {
                return false;
            }
        }
        return false;
    }

    void Y(CharSequence charSequence) {
        Editable text = this.v.getText();
        this.i0 = text;
        boolean z = !TextUtils.isEmpty(text);
        j0(z);
        l0(!z);
        e0();
        i0();
        if (this.Q != null && !TextUtils.equals(charSequence, this.h0)) {
            this.Q.a(charSequence.toString());
        }
        this.h0 = charSequence.toString();
    }

    void Z() {
        k0(L());
        b0();
        if (this.v.hasFocus()) {
            H();
        }
    }

    void a0() {
        SearchableInfo searchableInfo = this.l0;
        if (searchableInfo == null) {
            return;
        }
        try {
            if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                getContext().startActivity(F(this.N, searchableInfo));
            } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                getContext().startActivity(E(this.O, searchableInfo));
            }
        } catch (ActivityNotFoundException unused) {
            Log.w("SearchView", "Could not find voice search activity");
        }
    }

    @Override // c.a.o.c
    public void c() {
        if (this.j0) {
            return;
        }
        this.j0 = true;
        int imeOptions = this.v.getImeOptions();
        this.k0 = imeOptions;
        this.v.setImeOptions(imeOptions | 33554432);
        this.v.setText(HttpUrl.FRAGMENT_ENCODE_SET);
        setIconified(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        this.e0 = true;
        super.clearFocus();
        this.v.clearFocus();
        this.v.setImeVisibility(false);
        this.e0 = false;
    }

    public void d0(CharSequence charSequence, boolean z) {
        this.v.setText(charSequence);
        if (charSequence != null) {
            SearchAutoComplete searchAutoComplete = this.v;
            searchAutoComplete.setSelection(searchAutoComplete.length());
            this.i0 = charSequence;
        }
        if (!z || TextUtils.isEmpty(charSequence)) {
            return;
        }
        W();
    }

    @Override // c.a.o.c
    public void f() {
        d0(HttpUrl.FRAGMENT_ENCODE_SET, false);
        clearFocus();
        k0(true);
        this.v.setImeOptions(this.k0);
        this.j0 = false;
    }

    void f0() {
        int[] iArr = this.v.hasFocus() ? ViewGroup.FOCUSED_STATE_SET : ViewGroup.EMPTY_STATE_SET;
        Drawable background = this.x.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.y.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    public int getImeOptions() {
        return this.v.getImeOptions();
    }

    public int getInputType() {
        return this.v.getInputType();
    }

    public int getMaxWidth() {
        return this.f0;
    }

    public CharSequence getQuery() {
        return this.v.getText();
    }

    public CharSequence getQueryHint() {
        CharSequence charSequence = this.c0;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.l0;
        return (searchableInfo == null || searchableInfo.getHintId() == 0) ? this.P : getContext().getText(this.l0.getHintId());
    }

    int getSuggestionCommitIconResId() {
        return this.M;
    }

    int getSuggestionRowLayout() {
        return this.L;
    }

    public c.j.a.a getSuggestionsAdapter() {
        return this.a0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.n0);
        post(this.o0);
        super.onDetachedFromWindow();
    }

    @Override // androidx.appcompat.widget.c0, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (z) {
            I(this.v, this.F);
            Rect rect = this.G;
            Rect rect2 = this.F;
            rect.set(rect2.left, 0, rect2.right, i5 - i3);
            o oVar = this.E;
            if (oVar != null) {
                oVar.a(this.G, this.F);
                return;
            }
            o oVar2 = new o(this.G, this.F, this.v);
            this.E = oVar2;
            setTouchDelegate(oVar2);
        }
    }

    @Override // androidx.appcompat.widget.c0, android.view.View
    protected void onMeasure(int i2, int i3) {
        int i4;
        if (L()) {
            super.onMeasure(i2, i3);
            return;
        }
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE) {
            int i5 = this.f0;
            size = i5 > 0 ? Math.min(i5, size) : Math.min(getPreferredWidth(), size);
        } else if (mode == 0) {
            size = this.f0;
            if (size <= 0) {
                size = getPreferredWidth();
            }
        } else if (mode == 1073741824 && (i4 = this.f0) > 0) {
            size = Math.min(i4, size);
        }
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(getPreferredHeight(), size2);
        } else if (mode2 == 0) {
            size2 = getPreferredHeight();
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        k0(savedState.f425h);
        requestLayout();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f425h = L();
        return savedState;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        b0();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int i2, Rect rect) {
        if (this.e0 || !isFocusable()) {
            return false;
        }
        if (L()) {
            return super.requestFocus(i2, rect);
        }
        boolean zRequestFocus = this.v.requestFocus(i2, rect);
        if (zRequestFocus) {
            k0(false);
        }
        return zRequestFocus;
    }

    public void setAppSearchData(Bundle bundle) {
        this.m0 = bundle;
    }

    public void setIconified(boolean z) {
        if (z) {
            R();
        } else {
            V();
        }
    }

    public void setIconifiedByDefault(boolean z) {
        if (this.V == z) {
            return;
        }
        this.V = z;
        k0(z);
        g0();
    }

    public void setImeOptions(int i2) {
        this.v.setImeOptions(i2);
    }

    public void setInputType(int i2) {
        this.v.setInputType(i2);
    }

    public void setMaxWidth(int i2) {
        this.f0 = i2;
        requestLayout();
    }

    public void setOnCloseListener(k kVar) {
        this.R = kVar;
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.S = onFocusChangeListener;
    }

    public void setOnQueryTextListener(l lVar) {
        this.Q = lVar;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.U = onClickListener;
    }

    public void setOnSuggestionListener(m mVar) {
        this.T = mVar;
    }

    public void setQueryHint(CharSequence charSequence) {
        this.c0 = charSequence;
        g0();
    }

    public void setQueryRefinementEnabled(boolean z) {
        this.d0 = z;
        c.j.a.a aVar = this.a0;
        if (aVar instanceof k0) {
            ((k0) aVar).n(z ? 2 : 1);
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.l0 = searchableInfo;
        if (searchableInfo != null) {
            h0();
            g0();
        }
        boolean zK = K();
        this.g0 = zK;
        if (zK) {
            this.v.setPrivateImeOptions("nm");
        }
        k0(L());
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.b0 = z;
        k0(L());
    }

    public void setSuggestionsAdapter(c.j.a.a aVar) {
        this.a0 = aVar;
        this.v.setAdapter(aVar);
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.a.a.I);
    }

    public SearchView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.F = new Rect();
        this.G = new Rect();
        this.H = new int[2];
        this.I = new int[2];
        this.n0 = new b();
        this.o0 = new c();
        this.p0 = new WeakHashMap<>();
        f fVar = new f();
        this.q0 = fVar;
        this.r0 = new g();
        h hVar = new h();
        this.s0 = hVar;
        i iVar = new i();
        this.t0 = iVar;
        j jVar = new j();
        this.u0 = jVar;
        this.v0 = new a();
        q0 q0VarV = q0.v(context, attributeSet, c.a.j.i2, i2, 0);
        LayoutInflater.from(context).inflate(q0VarV.n(c.a.j.s2, c.a.g.r), (ViewGroup) this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(c.a.f.D);
        this.v = searchAutoComplete;
        searchAutoComplete.setSearchView(this);
        this.w = findViewById(c.a.f.z);
        View viewFindViewById = findViewById(c.a.f.C);
        this.x = viewFindViewById;
        View viewFindViewById2 = findViewById(c.a.f.J);
        this.y = viewFindViewById2;
        ImageView imageView = (ImageView) findViewById(c.a.f.x);
        this.z = imageView;
        ImageView imageView2 = (ImageView) findViewById(c.a.f.A);
        this.A = imageView2;
        ImageView imageView3 = (ImageView) findViewById(c.a.f.y);
        this.B = imageView3;
        ImageView imageView4 = (ImageView) findViewById(c.a.f.E);
        this.C = imageView4;
        ImageView imageView5 = (ImageView) findViewById(c.a.f.B);
        this.J = imageView5;
        androidx.core.view.u.m0(viewFindViewById, q0VarV.g(c.a.j.t2));
        androidx.core.view.u.m0(viewFindViewById2, q0VarV.g(c.a.j.x2));
        int i3 = c.a.j.w2;
        imageView.setImageDrawable(q0VarV.g(i3));
        imageView2.setImageDrawable(q0VarV.g(c.a.j.q2));
        imageView3.setImageDrawable(q0VarV.g(c.a.j.n2));
        imageView4.setImageDrawable(q0VarV.g(c.a.j.z2));
        imageView5.setImageDrawable(q0VarV.g(i3));
        this.K = q0VarV.g(c.a.j.v2);
        s0.a(imageView, getResources().getString(c.a.h.l));
        this.L = q0VarV.n(c.a.j.y2, c.a.g.q);
        this.M = q0VarV.n(c.a.j.o2, 0);
        imageView.setOnClickListener(fVar);
        imageView3.setOnClickListener(fVar);
        imageView2.setOnClickListener(fVar);
        imageView4.setOnClickListener(fVar);
        searchAutoComplete.setOnClickListener(fVar);
        searchAutoComplete.addTextChangedListener(this.v0);
        searchAutoComplete.setOnEditorActionListener(hVar);
        searchAutoComplete.setOnItemClickListener(iVar);
        searchAutoComplete.setOnItemSelectedListener(jVar);
        searchAutoComplete.setOnKeyListener(this.r0);
        searchAutoComplete.setOnFocusChangeListener(new d());
        setIconifiedByDefault(q0VarV.a(c.a.j.r2, true));
        int iF = q0VarV.f(c.a.j.k2, -1);
        if (iF != -1) {
            setMaxWidth(iF);
        }
        this.P = q0VarV.p(c.a.j.p2);
        this.c0 = q0VarV.p(c.a.j.u2);
        int iK = q0VarV.k(c.a.j.m2, -1);
        if (iK != -1) {
            setImeOptions(iK);
        }
        int iK2 = q0VarV.k(c.a.j.l2, -1);
        if (iK2 != -1) {
            setInputType(iK2);
        }
        setFocusable(q0VarV.a(c.a.j.j2, true));
        q0VarV.w();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.N = intent;
        intent.addFlags(268435456);
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.O = intent2;
        intent2.addFlags(268435456);
        View viewFindViewById3 = findViewById(searchAutoComplete.getDropDownAnchor());
        this.D = viewFindViewById3;
        if (viewFindViewById3 != null) {
            viewFindViewById3.addOnLayoutChangeListener(new e());
        }
        k0(this.V);
        g0();
    }
}
