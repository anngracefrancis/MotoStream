package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import cm.aptoide.pt.DeepLinkIntentReceiver;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: ConstraintLayoutStates.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    private final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f746b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f747c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private SparseArray<a> f748d = new SparseArray<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private SparseArray<d> f749e = new SparseArray<>();

    /* JADX INFO: compiled from: ConstraintLayoutStates.java */
    static class a {
        int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        ArrayList<b> f750b = new ArrayList<>();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f751c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        d f752d;

        public a(Context context, XmlPullParser xmlPullParser) {
            this.f751c = -1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), i.F4);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i2);
                if (index == i.G4) {
                    this.a = typedArrayObtainStyledAttributes.getResourceId(index, this.a);
                } else if (index == i.H4) {
                    this.f751c = typedArrayObtainStyledAttributes.getResourceId(index, this.f751c);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f751c);
                    context.getResources().getResourceName(this.f751c);
                    if ("layout".equals(resourceTypeName)) {
                        d dVar = new d();
                        this.f752d = dVar;
                        dVar.e(context, this.f751c);
                    }
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        void a(b bVar) {
            this.f750b.add(bVar);
        }
    }

    /* JADX INFO: compiled from: ConstraintLayoutStates.java */
    static class b {
        float a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f753b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        float f754c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        float f755d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f756e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        d f757f;

        public b(Context context, XmlPullParser xmlPullParser) {
            this.a = Float.NaN;
            this.f753b = Float.NaN;
            this.f754c = Float.NaN;
            this.f755d = Float.NaN;
            this.f756e = -1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), i.b5);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i2);
                if (index == i.c5) {
                    this.f756e = typedArrayObtainStyledAttributes.getResourceId(index, this.f756e);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f756e);
                    context.getResources().getResourceName(this.f756e);
                    if ("layout".equals(resourceTypeName)) {
                        d dVar = new d();
                        this.f757f = dVar;
                        dVar.e(context, this.f756e);
                    }
                } else if (index == i.d5) {
                    this.f755d = typedArrayObtainStyledAttributes.getDimension(index, this.f755d);
                } else if (index == i.e5) {
                    this.f753b = typedArrayObtainStyledAttributes.getDimension(index, this.f753b);
                } else if (index == i.f5) {
                    this.f754c = typedArrayObtainStyledAttributes.getDimension(index, this.f754c);
                } else if (index == i.g5) {
                    this.a = typedArrayObtainStyledAttributes.getDimension(index, this.a);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    c(Context context, ConstraintLayout constraintLayout, int i2) {
        this.a = constraintLayout;
        a(context, i2);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private void a(Context context, int i2) {
        XmlResourceParser xml = context.getResources().getXml(i2);
        a aVar = null;
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    byte b2 = -1;
                    switch (name.hashCode()) {
                        case -1349929691:
                            if (name.equals("ConstraintSet")) {
                                b2 = 4;
                            }
                            break;
                        case 80204913:
                            if (name.equals("State")) {
                                b2 = 2;
                            }
                            break;
                        case 1382829617:
                            if (name.equals("StateSet")) {
                                b2 = 1;
                            }
                            break;
                        case 1657696882:
                            if (name.equals("layoutDescription")) {
                                b2 = 0;
                            }
                            break;
                        case 1901439077:
                            if (name.equals("Variant")) {
                                b2 = 3;
                            }
                            break;
                    }
                    if (b2 != 0 && b2 != 1) {
                        if (b2 == 2) {
                            aVar = new a(context, xml);
                            this.f748d.put(aVar.a, aVar);
                        } else if (b2 == 3) {
                            b bVar = new b(context, xml);
                            if (aVar != null) {
                                aVar.a(bVar);
                            }
                        } else if (b2 != 4) {
                            Log.v("ConstraintLayoutStates", "unknown tag " + name);
                        } else {
                            b(context, xml);
                        }
                    }
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (XmlPullParserException e3) {
            e3.printStackTrace();
        }
    }

    private void b(Context context, XmlPullParser xmlPullParser) {
        d dVar = new d();
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i2 = 0; i2 < attributeCount; i2++) {
            if (DeepLinkIntentReceiver.DeepLinksKeys.ID.equals(xmlPullParser.getAttributeName(i2))) {
                String attributeValue = xmlPullParser.getAttributeValue(i2);
                int identifier = attributeValue.contains("/") ? context.getResources().getIdentifier(attributeValue.substring(attributeValue.indexOf(47) + 1), DeepLinkIntentReceiver.DeepLinksKeys.ID, context.getPackageName()) : -1;
                if (identifier == -1) {
                    if (attributeValue.length() > 1) {
                        identifier = Integer.parseInt(attributeValue.substring(1));
                    } else {
                        Log.e("ConstraintLayoutStates", "error in parsing id");
                    }
                }
                dVar.m(context, xmlPullParser);
                this.f749e.put(identifier, dVar);
                return;
            }
        }
    }

    public void c(f fVar) {
    }
}
