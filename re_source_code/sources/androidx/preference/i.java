package androidx.preference;

import android.content.Context;
import android.content.Intent;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: PreferenceInflater.java */
/* JADX INFO: loaded from: classes.dex */
class i {
    private static final Class<?>[] a = {Context.class, AttributeSet.class};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final HashMap<String, Constructor> f1841b = new HashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f1842c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object[] f1843d = new Object[2];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private j f1844e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String[] f1845f;

    public i(Context context, j jVar) {
        this.f1842c = context;
        f(jVar);
    }

    private Preference a(String str, String[] strArr, AttributeSet attributeSet) throws InflateException, ClassNotFoundException {
        Class<?> cls;
        Constructor<?> constructor = f1841b.get(str);
        if (constructor == null) {
            try {
                try {
                    ClassLoader classLoader = this.f1842c.getClassLoader();
                    if (strArr == null || strArr.length == 0) {
                        cls = Class.forName(str, false, classLoader);
                    } else {
                        cls = null;
                        ClassNotFoundException e2 = null;
                        for (String str2 : strArr) {
                            try {
                                cls = Class.forName(str2 + str, false, classLoader);
                                break;
                            } catch (ClassNotFoundException e3) {
                                e2 = e3;
                            }
                        }
                        if (cls == null) {
                            if (e2 != null) {
                                throw e2;
                            }
                            throw new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
                        }
                    }
                    constructor = cls.getConstructor(a);
                    constructor.setAccessible(true);
                    f1841b.put(str, constructor);
                } catch (ClassNotFoundException e4) {
                    throw e4;
                }
            } catch (Exception e5) {
                InflateException inflateException = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
                inflateException.initCause(e5);
                throw inflateException;
            }
        }
        Object[] objArr = this.f1843d;
        objArr[1] = attributeSet;
        return (Preference) constructor.newInstance(objArr);
    }

    private Preference b(String str, AttributeSet attributeSet) {
        try {
            return -1 == str.indexOf(46) ? g(str, attributeSet) : a(str, null, attributeSet);
        } catch (InflateException e2) {
            throw e2;
        } catch (ClassNotFoundException e3) {
            InflateException inflateException = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class (not found)" + str);
            inflateException.initCause(e3);
            throw inflateException;
        } catch (Exception e4) {
            InflateException inflateException2 = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
            inflateException2.initCause(e4);
            throw inflateException2;
        }
    }

    private void f(j jVar) {
        this.f1844e = jVar;
        j(new String[]{Preference.class.getPackage().getName() + ".", SwitchPreference.class.getPackage().getName() + "."});
    }

    private PreferenceGroup h(PreferenceGroup preferenceGroup, PreferenceGroup preferenceGroup2) {
        if (preferenceGroup != null) {
            return preferenceGroup;
        }
        preferenceGroup2.i0(this.f1844e);
        return preferenceGroup2;
    }

    private void i(XmlPullParser xmlPullParser, Preference preference, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if ((next == 3 && xmlPullParser.getDepth() <= depth) || next == 1) {
                return;
            }
            if (next == 2) {
                String name = xmlPullParser.getName();
                if ("intent".equals(name)) {
                    try {
                        preference.K0(Intent.parseIntent(c().getResources(), xmlPullParser, attributeSet));
                    } catch (IOException e2) {
                        XmlPullParserException xmlPullParserException = new XmlPullParserException("Error parsing preference");
                        xmlPullParserException.initCause(e2);
                        throw xmlPullParserException;
                    }
                } else if ("extra".equals(name)) {
                    c().getResources().parseBundleExtra("extra", attributeSet, preference.E());
                    try {
                        k(xmlPullParser);
                    } catch (IOException e3) {
                        XmlPullParserException xmlPullParserException2 = new XmlPullParserException("Error parsing preference");
                        xmlPullParserException2.initCause(e3);
                        throw xmlPullParserException2;
                    }
                } else {
                    Preference preferenceB = b(name, attributeSet);
                    ((PreferenceGroup) preference).Z0(preferenceB);
                    i(xmlPullParser, preferenceB, attributeSet);
                }
            }
        }
    }

    private static void k(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1) {
                return;
            }
            if (next == 3 && xmlPullParser.getDepth() <= depth) {
                return;
            }
        }
    }

    public Context c() {
        return this.f1842c;
    }

    public Preference d(int i2, PreferenceGroup preferenceGroup) {
        XmlResourceParser xml = c().getResources().getXml(i2);
        try {
            return e(xml, preferenceGroup);
        } finally {
            xml.close();
        }
    }

    public Preference e(XmlPullParser xmlPullParser, PreferenceGroup preferenceGroup) {
        int next;
        PreferenceGroup preferenceGroupH;
        synchronized (this.f1843d) {
            AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xmlPullParser);
            this.f1843d[0] = this.f1842c;
            do {
                try {
                    next = xmlPullParser.next();
                    if (next == 2) {
                        break;
                    }
                } catch (InflateException e2) {
                    throw e2;
                } catch (IOException e3) {
                    InflateException inflateException = new InflateException(xmlPullParser.getPositionDescription() + ": " + e3.getMessage());
                    inflateException.initCause(e3);
                    throw inflateException;
                } catch (XmlPullParserException e4) {
                    InflateException inflateException2 = new InflateException(e4.getMessage());
                    inflateException2.initCause(e4);
                    throw inflateException2;
                }
            } while (next != 1);
            if (next != 2) {
                throw new InflateException(xmlPullParser.getPositionDescription() + ": No start tag found!");
            }
            preferenceGroupH = h(preferenceGroup, (PreferenceGroup) b(xmlPullParser.getName(), attributeSetAsAttributeSet));
            i(xmlPullParser, preferenceGroupH, attributeSetAsAttributeSet);
        }
        return preferenceGroupH;
    }

    protected Preference g(String str, AttributeSet attributeSet) throws ClassNotFoundException {
        return a(str, this.f1845f, attributeSet);
    }

    public void j(String[] strArr) {
        this.f1845f = strArr;
    }
}
