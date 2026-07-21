package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InflateException;
import android.view.View;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.n0;
import androidx.appcompat.widget.p;
import androidx.appcompat.widget.t;
import androidx.appcompat.widget.v;
import androidx.core.view.u;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: AppCompatViewInflater.java */
/* JADX INFO: loaded from: classes.dex */
public class j {
    private static final Class<?>[] a = {Context.class, AttributeSet.class};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f194b = {R.attr.onClick};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String[] f195c = {"android.widget.", "android.view.", "android.webkit."};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final c.e.g<String, Constructor<? extends View>> f196d = new c.e.g<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object[] f197e = new Object[2];

    /* JADX INFO: compiled from: AppCompatViewInflater.java */
    private static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final View f198f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final String f199g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private Method f200h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private Context f201i;

        public a(View view, String str) {
            this.f198f = view;
            this.f199g = str;
        }

        private void a(Context context) {
            String str;
            Method method;
            while (context != null) {
                try {
                    if (!context.isRestricted() && (method = context.getClass().getMethod(this.f199g, View.class)) != null) {
                        this.f200h = method;
                        this.f201i = context;
                        return;
                    }
                } catch (NoSuchMethodException unused) {
                }
                context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
            }
            int id = this.f198f.getId();
            if (id == -1) {
                str = HttpUrl.FRAGMENT_ENCODE_SET;
            } else {
                str = " with id '" + this.f198f.getContext().getResources().getResourceEntryName(id) + "'";
            }
            throw new IllegalStateException("Could not find method " + this.f199g + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.f198f.getClass() + str);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f200h == null) {
                a(this.f198f.getContext());
            }
            try {
                this.f200h.invoke(this.f201i, view);
            } catch (IllegalAccessException e2) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e2);
            } catch (InvocationTargetException e3) {
                throw new IllegalStateException("Could not execute method for android:onClick", e3);
            }
        }
    }

    private void a(View view, AttributeSet attributeSet) {
        Context context = view.getContext();
        if (context instanceof ContextWrapper) {
            if (Build.VERSION.SDK_INT < 15 || u.J(view)) {
                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f194b);
                String string = typedArrayObtainStyledAttributes.getString(0);
                if (string != null) {
                    view.setOnClickListener(new a(view, string));
                }
                typedArrayObtainStyledAttributes.recycle();
            }
        }
    }

    private View r(Context context, String str, String str2) throws InflateException, ClassNotFoundException {
        String str3;
        c.e.g<String, Constructor<? extends View>> gVar = f196d;
        Constructor<? extends View> constructor = gVar.get(str);
        if (constructor == null) {
            if (str2 != null) {
                try {
                    str3 = str2 + str;
                } catch (Exception unused) {
                    return null;
                }
            } else {
                str3 = str;
            }
            constructor = Class.forName(str3, false, context.getClassLoader()).asSubclass(View.class).getConstructor(a);
            gVar.put(str, constructor);
        }
        constructor.setAccessible(true);
        return constructor.newInstance(this.f197e);
    }

    private View s(Context context, String str, AttributeSet attributeSet) {
        if (str.equals("view")) {
            str = attributeSet.getAttributeValue(null, "class");
        }
        try {
            Object[] objArr = this.f197e;
            objArr[0] = context;
            objArr[1] = attributeSet;
            if (-1 != str.indexOf(46)) {
                return r(context, str, null);
            }
            int i2 = 0;
            while (true) {
                String[] strArr = f195c;
                if (i2 >= strArr.length) {
                    return null;
                }
                View viewR = r(context, str, strArr[i2]);
                if (viewR != null) {
                    return viewR;
                }
                i2++;
            }
        } catch (Exception unused) {
            return null;
        } finally {
            Object[] objArr2 = this.f197e;
            objArr2[0] = null;
            objArr2[1] = null;
        }
    }

    private static Context t(Context context, AttributeSet attributeSet, boolean z, boolean z2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.j.O3, 0, 0);
        int resourceId = z ? typedArrayObtainStyledAttributes.getResourceId(c.a.j.P3, 0) : 0;
        if (z2 && resourceId == 0 && (resourceId = typedArrayObtainStyledAttributes.getResourceId(c.a.j.Q3, 0)) != 0) {
            Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
        }
        typedArrayObtainStyledAttributes.recycle();
        if (resourceId != 0) {
            return ((context instanceof c.a.o.d) && ((c.a.o.d) context).c() == resourceId) ? context : new c.a.o.d(context, resourceId);
        }
        return context;
    }

    private void u(View view, String str) {
        if (view != null) {
            return;
        }
        throw new IllegalStateException(getClass().getName() + " asked to inflate view for <" + str + ">, but returned null");
    }

    protected androidx.appcompat.widget.c b(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.c(context, attributeSet);
    }

    protected AppCompatButton c(Context context, AttributeSet attributeSet) {
        return new AppCompatButton(context, attributeSet);
    }

    protected androidx.appcompat.widget.e d(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.e(context, attributeSet);
    }

    protected androidx.appcompat.widget.f e(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.f(context, attributeSet);
    }

    protected androidx.appcompat.widget.i f(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.i(context, attributeSet);
    }

    protected androidx.appcompat.widget.k g(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.k(context, attributeSet);
    }

    protected AppCompatImageView h(Context context, AttributeSet attributeSet) {
        return new AppCompatImageView(context, attributeSet);
    }

    protected androidx.appcompat.widget.m i(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.m(context, attributeSet);
    }

    protected AppCompatRadioButton j(Context context, AttributeSet attributeSet) {
        return new AppCompatRadioButton(context, attributeSet);
    }

    protected AppCompatRatingBar k(Context context, AttributeSet attributeSet) {
        return new AppCompatRatingBar(context, attributeSet);
    }

    protected p l(Context context, AttributeSet attributeSet) {
        return new p(context, attributeSet);
    }

    protected AppCompatSpinner m(Context context, AttributeSet attributeSet) {
        return new AppCompatSpinner(context, attributeSet);
    }

    protected t n(Context context, AttributeSet attributeSet) {
        return new t(context, attributeSet);
    }

    protected v o(Context context, AttributeSet attributeSet) {
        return new v(context, attributeSet);
    }

    protected View p(Context context, String str, AttributeSet attributeSet) {
        return null;
    }

    final View q(View view, String str, Context context, AttributeSet attributeSet, boolean z, boolean z2, boolean z3, boolean z4) {
        View viewK;
        Context context2 = (!z || view == null) ? context : view.getContext();
        if (z2 || z3) {
            context2 = t(context2, attributeSet, z2, z3);
        }
        if (z4) {
            context2 = n0.b(context2);
        }
        str.hashCode();
        switch (str) {
            case "RatingBar":
                viewK = k(context2, attributeSet);
                u(viewK, str);
                break;
            case "CheckedTextView":
                viewK = e(context2, attributeSet);
                u(viewK, str);
                break;
            case "MultiAutoCompleteTextView":
                viewK = i(context2, attributeSet);
                u(viewK, str);
                break;
            case "TextView":
                viewK = n(context2, attributeSet);
                u(viewK, str);
                break;
            case "ImageButton":
                viewK = g(context2, attributeSet);
                u(viewK, str);
                break;
            case "SeekBar":
                viewK = l(context2, attributeSet);
                u(viewK, str);
                break;
            case "Spinner":
                viewK = m(context2, attributeSet);
                u(viewK, str);
                break;
            case "RadioButton":
                viewK = j(context2, attributeSet);
                u(viewK, str);
                break;
            case "ToggleButton":
                viewK = o(context2, attributeSet);
                u(viewK, str);
                break;
            case "ImageView":
                viewK = h(context2, attributeSet);
                u(viewK, str);
                break;
            case "AutoCompleteTextView":
                viewK = b(context2, attributeSet);
                u(viewK, str);
                break;
            case "CheckBox":
                viewK = d(context2, attributeSet);
                u(viewK, str);
                break;
            case "EditText":
                viewK = f(context2, attributeSet);
                u(viewK, str);
                break;
            case "Button":
                viewK = c(context2, attributeSet);
                u(viewK, str);
                break;
            default:
                viewK = p(context2, str, attributeSet);
                break;
        }
        if (viewK == null && context != context2) {
            viewK = s(context2, str, attributeSet);
        }
        if (viewK != null) {
            a(viewK, attributeSet);
        }
        return viewK;
    }
}
