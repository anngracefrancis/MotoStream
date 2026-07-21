package com.facebook.o0.m0.n;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import androidx.recyclerview.widget.RecyclerView;
import cm.aptoide.pt.DeepLinkIntentReceiver;
import cm.aptoide.pt.networking.BodyInterceptorV3;
import cm.aptoide.pt.root.execution.Command;
import cm.aptoide.pt.store.view.StoreTabGridRecyclerFragment;
import com.facebook.internal.p0;
import com.google.android.gms.ads.AdRequest;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.jvm.internal.m;
import okhttp3.HttpUrl;
import okhttp3.internal.http2.Http2;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ViewHierarchy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class f {
    public static final f a = new f();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f10338b = f.class.getCanonicalName();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static WeakReference<View> f10339c = new WeakReference<>(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Method f10340d;

    private f() {
    }

    public static final View a(View view) {
        while (view != null) {
            if (a.q(view)) {
                return view;
            }
            Object parent = view.getParent();
            if (!(parent instanceof View)) {
                return null;
            }
            view = (View) parent;
        }
        return null;
    }

    public static final List<View> b(View view) {
        ArrayList arrayList = new ArrayList();
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            int i2 = 0;
            if (childCount > 0) {
                while (true) {
                    int i3 = i2 + 1;
                    arrayList.add(viewGroup.getChildAt(i2));
                    if (i3 >= childCount) {
                        break;
                    }
                    i2 = i3;
                }
            }
        }
        return arrayList;
    }

    public static final int c(View view) {
        m.f(view, "view");
        int i2 = view instanceof ImageView ? 2 : 0;
        if (view.isClickable()) {
            i2 |= 32;
        }
        f fVar = a;
        if (o(view)) {
            i2 |= AdRequest.MAX_CONTENT_URL_LENGTH;
        }
        if (view instanceof TextView) {
            int i3 = i2 | 1024 | 1;
            if (view instanceof Button) {
                i3 |= 4;
                if (view instanceof Switch) {
                    i3 |= 8192;
                } else if (view instanceof CheckBox) {
                    i3 |= 32768;
                }
            }
            return view instanceof EditText ? i3 | RecyclerView.l.FLAG_MOVED : i3;
        }
        if ((view instanceof Spinner) || (view instanceof DatePicker)) {
            return i2 | RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT;
        }
        if (view instanceof RatingBar) {
            return i2 | 65536;
        }
        if (view instanceof RadioGroup) {
            return i2 | Http2.INITIAL_MAX_FRAME_SIZE;
        }
        return ((view instanceof ViewGroup) && fVar.p(view, f10339c.get())) ? i2 | 64 : i2;
    }

    public static final JSONObject d(View view) {
        m.f(view, "view");
        if (m.a(view.getClass().getName(), "com.facebook.react.ReactRootView")) {
            f10339c = new WeakReference<>(view);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            s(view, jSONObject);
            JSONArray jSONArray = new JSONArray();
            List<View> listB = b(view);
            int i2 = 0;
            int size = listB.size() - 1;
            if (size >= 0) {
                while (true) {
                    int i3 = i2 + 1;
                    jSONArray.put(d(listB.get(i2)));
                    if (i3 > size) {
                        break;
                    }
                    i2 = i3;
                }
            }
            jSONObject.put("childviews", jSONArray);
        } catch (JSONException e2) {
            Log.e(f10338b, "Failed to create JSONObject for view.", e2);
        }
        return jSONObject;
    }

    private final JSONObject e(View view) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("top", view.getTop());
            jSONObject.put("left", view.getLeft());
            jSONObject.put("width", view.getWidth());
            jSONObject.put("height", view.getHeight());
            jSONObject.put("scrollx", view.getScrollX());
            jSONObject.put("scrolly", view.getScrollY());
            jSONObject.put("visibility", view.getVisibility());
        } catch (JSONException e2) {
            Log.e(f10338b, "Failed to create JSONObject for dimension.", e2);
        }
        return jSONObject;
    }

    private final Class<?> f(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static final View.OnClickListener g(View view) {
        Field declaredField;
        try {
            Field declaredField2 = Class.forName("android.view.View").getDeclaredField("mListenerInfo");
            if (declaredField2 != null) {
                declaredField2.setAccessible(true);
            }
            Object obj = declaredField2.get(view);
            if (obj == null || (declaredField = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnClickListener")) == null) {
                return null;
            }
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(obj);
            if (obj2 != null) {
                return (View.OnClickListener) obj2;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.View.OnClickListener");
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException unused) {
            return null;
        }
    }

    public static final View.OnTouchListener h(View view) {
        Field declaredField;
        try {
            Field declaredField2 = Class.forName("android.view.View").getDeclaredField("mListenerInfo");
            if (declaredField2 != null) {
                declaredField2.setAccessible(true);
            }
            Object obj = declaredField2.get(view);
            if (obj == null || (declaredField = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnTouchListener")) == null) {
                return null;
            }
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(obj);
            if (obj2 != null) {
                return (View.OnTouchListener) obj2;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.View.OnTouchListener");
        } catch (ClassNotFoundException e2) {
            p0 p0Var = p0.a;
            p0.i0(f10338b, e2);
            return null;
        } catch (IllegalAccessException e3) {
            p0 p0Var2 = p0.a;
            p0.i0(f10338b, e3);
            return null;
        } catch (NoSuchFieldException e4) {
            p0 p0Var3 = p0.a;
            p0.i0(f10338b, e4);
            return null;
        }
    }

    public static final String i(View view) {
        CharSequence hint;
        String string;
        if (view instanceof EditText) {
            hint = ((EditText) view).getHint();
        } else {
            hint = view instanceof TextView ? ((TextView) view).getHint() : null;
        }
        return (hint == null || (string = hint.toString()) == null) ? HttpUrl.FRAGMENT_ENCODE_SET : string;
    }

    public static final ViewGroup j(View view) {
        if (view == null) {
            return null;
        }
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            return (ViewGroup) parent;
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00ed A[EDGE_INSN: B:39:0x00ed->B:40:0x00ee BREAK  A[LOOP:0: B:28:0x00c2->B:35:0x00dc]] */
    public static final String k(View view) {
        CharSequence charSequenceValueOf;
        Object selectedItem;
        String string;
        if (!(view instanceof TextView)) {
            if (!(view instanceof Spinner)) {
                int i2 = 0;
                if (!(view instanceof DatePicker)) {
                    if (!(view instanceof TimePicker)) {
                        if (!(view instanceof RadioGroup)) {
                            if (!(view instanceof RatingBar)) {
                                charSequenceValueOf = null;
                                break;
                            }
                            charSequenceValueOf = String.valueOf(((RatingBar) view).getRating());
                        } else {
                            RadioGroup radioGroup = (RadioGroup) view;
                            int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
                            int childCount = radioGroup.getChildCount();
                            if (childCount <= 0) {
                                charSequenceValueOf = null;
                                break;
                            }
                            while (true) {
                                int i3 = i2 + 1;
                                View childAt = radioGroup.getChildAt(i2);
                                if (childAt.getId() == checkedRadioButtonId && (childAt instanceof RadioButton)) {
                                    charSequenceValueOf = ((RadioButton) childAt).getText();
                                    break;
                                }
                                if (i3 >= childCount) {
                                    charSequenceValueOf = null;
                                    break;
                                }
                                i2 = i3;
                            }
                        }
                    } else {
                        TimePicker timePicker = (TimePicker) view;
                        Integer currentHour = timePicker.getCurrentHour();
                        m.e(currentHour, "view.currentHour");
                        int iIntValue = currentHour.intValue();
                        Integer currentMinute = timePicker.getCurrentMinute();
                        m.e(currentMinute, "view.currentMinute");
                        int iIntValue2 = currentMinute.intValue();
                        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
                        charSequenceValueOf = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(iIntValue), Integer.valueOf(iIntValue2)}, 2));
                        m.e(charSequenceValueOf, "java.lang.String.format(format, *args)");
                    }
                } else {
                    DatePicker datePicker = (DatePicker) view;
                    int year = datePicker.getYear();
                    int month = datePicker.getMonth();
                    int dayOfMonth = datePicker.getDayOfMonth();
                    StringCompanionObject stringCompanionObject2 = StringCompanionObject.a;
                    charSequenceValueOf = String.format("%04d-%02d-%02d", Arrays.copyOf(new Object[]{Integer.valueOf(year), Integer.valueOf(month), Integer.valueOf(dayOfMonth)}, 3));
                    m.e(charSequenceValueOf, "java.lang.String.format(format, *args)");
                }
            } else {
                Spinner spinner = (Spinner) view;
                if (spinner.getCount() <= 0 || (selectedItem = spinner.getSelectedItem()) == null) {
                    charSequenceValueOf = null;
                    break;
                }
                charSequenceValueOf = selectedItem.toString();
            }
        } else {
            charSequenceValueOf = ((TextView) view).getText();
            if (view instanceof Switch) {
                charSequenceValueOf = ((Switch) view).isChecked() ? "1" : "0";
            }
        }
        return (charSequenceValueOf == null || (string = charSequenceValueOf.toString()) == null) ? HttpUrl.FRAGMENT_ENCODE_SET : string;
    }

    private final View l(float[] fArr, View view) {
        n();
        Method method = f10340d;
        if (method != null && view != null) {
            try {
                if (method == null) {
                    throw new IllegalStateException("Required value was null.".toString());
                }
                Object objInvoke = method.invoke(null, fArr, view);
                if (objInvoke == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.View");
                }
                View view2 = (View) objInvoke;
                if (view2.getId() > 0) {
                    Object parent = view2.getParent();
                    if (parent != null) {
                        return (View) parent;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type android.view.View");
                }
            } catch (IllegalAccessException e2) {
                p0 p0Var = p0.a;
                p0.i0(f10338b, e2);
            } catch (InvocationTargetException e3) {
                p0 p0Var2 = p0.a;
                p0.i0(f10338b, e3);
            }
        }
        return null;
    }

    private final float[] m(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return new float[]{iArr[0], iArr[1]};
    }

    private final void n() {
        if (f10340d != null) {
            return;
        }
        try {
            Method declaredMethod = Class.forName("com.facebook.react.uimanager.TouchTargetHelper").getDeclaredMethod("findTouchTargetView", float[].class, ViewGroup.class);
            f10340d = declaredMethod;
            if (declaredMethod == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            declaredMethod.setAccessible(true);
        } catch (ClassNotFoundException e2) {
            p0 p0Var = p0.a;
            p0.i0(f10338b, e2);
        } catch (NoSuchMethodException e3) {
            p0 p0Var2 = p0.a;
            p0.i0(f10338b, e3);
        }
    }

    private static final boolean o(View view) {
        ViewParent parent = view.getParent();
        if (parent instanceof AdapterView) {
            return true;
        }
        f fVar = a;
        Class<?> clsF = fVar.f("android.support.v4.view.NestedScrollingChild");
        if (clsF != null && clsF.isInstance(parent)) {
            return true;
        }
        Class<?> clsF2 = fVar.f("androidx.core.view.NestedScrollingChild");
        return clsF2 != null && clsF2.isInstance(parent);
    }

    private final boolean q(View view) {
        return m.a(view.getClass().getName(), "com.facebook.react.ReactRootView");
    }

    public static final void r(View view, View.OnClickListener onClickListener) {
        Field declaredField;
        Field declaredField2;
        m.f(view, "view");
        Object obj = null;
        try {
            try {
                declaredField = Class.forName("android.view.View").getDeclaredField("mListenerInfo");
                try {
                    declaredField2 = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnClickListener");
                } catch (ClassNotFoundException | NoSuchFieldException unused) {
                    declaredField2 = null;
                }
            } catch (ClassNotFoundException | NoSuchFieldException unused2) {
                declaredField = null;
            }
            if (declaredField == null || declaredField2 == null) {
                view.setOnClickListener(onClickListener);
                return;
            }
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            try {
                declaredField.setAccessible(true);
                obj = declaredField.get(view);
            } catch (IllegalAccessException unused3) {
            }
            if (obj == null) {
                view.setOnClickListener(onClickListener);
            } else {
                declaredField2.set(obj, onClickListener);
            }
        } catch (Exception unused4) {
        }
    }

    public static final void s(View view, JSONObject jSONObject) {
        m.f(view, "view");
        m.f(jSONObject, BodyInterceptorV3.RESPONSE_MODE_JSON);
        try {
            f fVar = a;
            String strK = k(view);
            String strI = i(view);
            Object tag = view.getTag();
            CharSequence contentDescription = view.getContentDescription();
            jSONObject.put("classname", view.getClass().getCanonicalName());
            jSONObject.put("classtypebitmask", c(view));
            jSONObject.put(DeepLinkIntentReceiver.DeepLinksKeys.ID, view.getId());
            d dVar = d.a;
            if (d.g(view)) {
                jSONObject.put(Command.CommandHandler.TEXT, HttpUrl.FRAGMENT_ENCODE_SET);
                jSONObject.put("is_user_input", true);
            } else {
                p0 p0Var = p0.a;
                jSONObject.put(Command.CommandHandler.TEXT, p0.i(p0.F0(strK), HttpUrl.FRAGMENT_ENCODE_SET));
            }
            p0 p0Var2 = p0.a;
            jSONObject.put("hint", p0.i(p0.F0(strI), HttpUrl.FRAGMENT_ENCODE_SET));
            if (tag != null) {
                jSONObject.put(StoreTabGridRecyclerFragment.BundleCons.TAG, p0.i(p0.F0(tag.toString()), HttpUrl.FRAGMENT_ENCODE_SET));
            }
            if (contentDescription != null) {
                jSONObject.put("description", p0.i(p0.F0(contentDescription.toString()), HttpUrl.FRAGMENT_ENCODE_SET));
            }
            jSONObject.put("dimension", fVar.e(view));
        } catch (JSONException e2) {
            p0 p0Var3 = p0.a;
            p0.i0(f10338b, e2);
        }
    }

    public final boolean p(View view, View view2) {
        View viewL;
        m.f(view, "view");
        return m.a(view.getClass().getName(), "com.facebook.react.views.view.ReactViewGroup") && (viewL = l(m(view), view2)) != null && viewL.getId() == view.getId();
    }
}
