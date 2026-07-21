package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: ConstraintAttribute.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b f728b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f729c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f730d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f731e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f732f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f733g;

    /* JADX INFO: renamed from: androidx.constraintlayout.widget.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ConstraintAttribute.java */
    static /* synthetic */ class C0014a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.values().length];
            a = iArr;
            try {
                iArr[b.COLOR_TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[b.COLOR_DRAWABLE_TYPE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[b.INT_TYPE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[b.FLOAT_TYPE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[b.STRING_TYPE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[b.BOOLEAN_TYPE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[b.DIMENSION_TYPE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: ConstraintAttribute.java */
    public enum b {
        INT_TYPE,
        FLOAT_TYPE,
        COLOR_TYPE,
        COLOR_DRAWABLE_TYPE,
        STRING_TYPE,
        BOOLEAN_TYPE,
        DIMENSION_TYPE
    }

    public a(String str, b bVar, Object obj) {
        this.a = str;
        this.f728b = bVar;
        d(obj);
    }

    public static HashMap<String, a> a(HashMap<String, a> map, View view) {
        HashMap<String, a> map2 = new HashMap<>();
        Class<?> cls = view.getClass();
        for (String str : map.keySet()) {
            a aVar = map.get(str);
            try {
                if (str.equals("BackgroundColor")) {
                    map2.put(str, new a(aVar, Integer.valueOf(((ColorDrawable) view.getBackground()).getColor())));
                } else {
                    map2.put(str, new a(aVar, cls.getMethod("getMap" + str, new Class[0]).invoke(view, new Object[0])));
                }
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (NoSuchMethodException e3) {
                e3.printStackTrace();
            } catch (InvocationTargetException e4) {
                e4.printStackTrace();
            }
        }
        return map2;
    }

    public static void b(Context context, XmlPullParser xmlPullParser, HashMap<String, a> map) {
        b bVar;
        Object string;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), i.C2);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        String string2 = null;
        Object objValueOf = null;
        b bVar2 = null;
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i2);
            if (index == i.D2) {
                string2 = typedArrayObtainStyledAttributes.getString(index);
                if (string2 != null && string2.length() > 0) {
                    string2 = Character.toUpperCase(string2.charAt(0)) + string2.substring(1);
                }
            } else if (index == i.E2) {
                objValueOf = Boolean.valueOf(typedArrayObtainStyledAttributes.getBoolean(index, false));
                bVar2 = b.BOOLEAN_TYPE;
            } else {
                if (index == i.G2) {
                    bVar = b.COLOR_TYPE;
                    string = Integer.valueOf(typedArrayObtainStyledAttributes.getColor(index, 0));
                } else if (index == i.F2) {
                    bVar = b.COLOR_DRAWABLE_TYPE;
                    string = Integer.valueOf(typedArrayObtainStyledAttributes.getColor(index, 0));
                } else if (index == i.K2) {
                    bVar = b.DIMENSION_TYPE;
                    string = Float.valueOf(TypedValue.applyDimension(1, typedArrayObtainStyledAttributes.getDimension(index, 0.0f), context.getResources().getDisplayMetrics()));
                } else if (index == i.H2) {
                    bVar = b.DIMENSION_TYPE;
                    string = Float.valueOf(typedArrayObtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == i.I2) {
                    bVar = b.FLOAT_TYPE;
                    string = Float.valueOf(typedArrayObtainStyledAttributes.getFloat(index, Float.NaN));
                } else if (index == i.J2) {
                    bVar = b.INT_TYPE;
                    string = Integer.valueOf(typedArrayObtainStyledAttributes.getInteger(index, -1));
                } else if (index == i.L2) {
                    bVar = b.STRING_TYPE;
                    string = typedArrayObtainStyledAttributes.getString(index);
                }
                Object obj = string;
                bVar2 = bVar;
                objValueOf = obj;
            }
        }
        if (string2 != null && objValueOf != null) {
            map.put(string2, new a(string2, bVar2, objValueOf));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public static void c(View view, HashMap<String, a> map) {
        Class<?> cls = view.getClass();
        for (String str : map.keySet()) {
            a aVar = map.get(str);
            String str2 = "set" + str;
            try {
                switch (C0014a.a[aVar.f728b.ordinal()]) {
                    case 1:
                        cls.getMethod(str2, Integer.TYPE).invoke(view, Integer.valueOf(aVar.f733g));
                        break;
                    case 2:
                        Method method = cls.getMethod(str2, Drawable.class);
                        ColorDrawable colorDrawable = new ColorDrawable();
                        colorDrawable.setColor(aVar.f733g);
                        method.invoke(view, colorDrawable);
                        break;
                    case 3:
                        cls.getMethod(str2, Integer.TYPE).invoke(view, Integer.valueOf(aVar.f729c));
                        break;
                    case 4:
                        cls.getMethod(str2, Float.TYPE).invoke(view, Float.valueOf(aVar.f730d));
                        break;
                    case 5:
                        cls.getMethod(str2, CharSequence.class).invoke(view, aVar.f731e);
                        break;
                    case 6:
                        cls.getMethod(str2, Boolean.TYPE).invoke(view, Boolean.valueOf(aVar.f732f));
                        break;
                    case 7:
                        cls.getMethod(str2, Float.TYPE).invoke(view, Float.valueOf(aVar.f730d));
                        break;
                }
            } catch (IllegalAccessException e2) {
                Log.e("TransitionLayout", " Custom Attribute \"" + str + "\" not found on " + cls.getName());
                e2.printStackTrace();
            } catch (NoSuchMethodException e3) {
                Log.e("TransitionLayout", e3.getMessage());
                Log.e("TransitionLayout", " Custom Attribute \"" + str + "\" not found on " + cls.getName());
                StringBuilder sb = new StringBuilder();
                sb.append(cls.getName());
                sb.append(" must have a method ");
                sb.append(str2);
                Log.e("TransitionLayout", sb.toString());
            } catch (InvocationTargetException e4) {
                Log.e("TransitionLayout", " Custom Attribute \"" + str + "\" not found on " + cls.getName());
                e4.printStackTrace();
            }
        }
    }

    public void d(Object obj) {
        switch (C0014a.a[this.f728b.ordinal()]) {
            case 1:
            case 2:
                this.f733g = ((Integer) obj).intValue();
                break;
            case 3:
                this.f729c = ((Integer) obj).intValue();
                break;
            case 4:
                this.f730d = ((Float) obj).floatValue();
                break;
            case 5:
                this.f731e = (String) obj;
                break;
            case 6:
                this.f732f = ((Boolean) obj).booleanValue();
                break;
            case 7:
                this.f730d = ((Float) obj).floatValue();
                break;
        }
    }

    public a(a aVar, Object obj) {
        this.a = aVar.a;
        this.f728b = aVar.f728b;
        d(obj);
    }
}
