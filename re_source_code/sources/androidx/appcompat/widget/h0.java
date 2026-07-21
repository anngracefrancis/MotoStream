package androidx.appcompat.widget;

import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import java.io.IOException;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: ResourcesWrapper.java */
/* JADX INFO: loaded from: classes.dex */
class h0 extends Resources {
    private final Resources a;

    public h0(Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.a = resources;
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getAnimation(int i2) throws Resources.NotFoundException {
        return this.a.getAnimation(i2);
    }

    @Override // android.content.res.Resources
    public boolean getBoolean(int i2) throws Resources.NotFoundException {
        return this.a.getBoolean(i2);
    }

    @Override // android.content.res.Resources
    public int getColor(int i2) throws Resources.NotFoundException {
        return this.a.getColor(i2);
    }

    @Override // android.content.res.Resources
    public ColorStateList getColorStateList(int i2) throws Resources.NotFoundException {
        return this.a.getColorStateList(i2);
    }

    @Override // android.content.res.Resources
    public Configuration getConfiguration() {
        return this.a.getConfiguration();
    }

    @Override // android.content.res.Resources
    public float getDimension(int i2) throws Resources.NotFoundException {
        return this.a.getDimension(i2);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelOffset(int i2) throws Resources.NotFoundException {
        return this.a.getDimensionPixelOffset(i2);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelSize(int i2) throws Resources.NotFoundException {
        return this.a.getDimensionPixelSize(i2);
    }

    @Override // android.content.res.Resources
    public DisplayMetrics getDisplayMetrics() {
        return this.a.getDisplayMetrics();
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i2) throws Resources.NotFoundException {
        return this.a.getDrawable(i2);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawableForDensity(int i2, int i3) throws Resources.NotFoundException {
        return this.a.getDrawableForDensity(i2, i3);
    }

    @Override // android.content.res.Resources
    public float getFraction(int i2, int i3, int i4) {
        return this.a.getFraction(i2, i3, i4);
    }

    @Override // android.content.res.Resources
    public int getIdentifier(String str, String str2, String str3) {
        return this.a.getIdentifier(str, str2, str3);
    }

    @Override // android.content.res.Resources
    public int[] getIntArray(int i2) throws Resources.NotFoundException {
        return this.a.getIntArray(i2);
    }

    @Override // android.content.res.Resources
    public int getInteger(int i2) throws Resources.NotFoundException {
        return this.a.getInteger(i2);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getLayout(int i2) throws Resources.NotFoundException {
        return this.a.getLayout(i2);
    }

    @Override // android.content.res.Resources
    public Movie getMovie(int i2) throws Resources.NotFoundException {
        return this.a.getMovie(i2);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i2, int i3, Object... objArr) throws Resources.NotFoundException {
        return this.a.getQuantityString(i2, i3, objArr);
    }

    @Override // android.content.res.Resources
    public CharSequence getQuantityText(int i2, int i3) throws Resources.NotFoundException {
        return this.a.getQuantityText(i2, i3);
    }

    @Override // android.content.res.Resources
    public String getResourceEntryName(int i2) throws Resources.NotFoundException {
        return this.a.getResourceEntryName(i2);
    }

    @Override // android.content.res.Resources
    public String getResourceName(int i2) throws Resources.NotFoundException {
        return this.a.getResourceName(i2);
    }

    @Override // android.content.res.Resources
    public String getResourcePackageName(int i2) throws Resources.NotFoundException {
        return this.a.getResourcePackageName(i2);
    }

    @Override // android.content.res.Resources
    public String getResourceTypeName(int i2) throws Resources.NotFoundException {
        return this.a.getResourceTypeName(i2);
    }

    @Override // android.content.res.Resources
    public String getString(int i2) throws Resources.NotFoundException {
        return this.a.getString(i2);
    }

    @Override // android.content.res.Resources
    public String[] getStringArray(int i2) throws Resources.NotFoundException {
        return this.a.getStringArray(i2);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i2) throws Resources.NotFoundException {
        return this.a.getText(i2);
    }

    @Override // android.content.res.Resources
    public CharSequence[] getTextArray(int i2) throws Resources.NotFoundException {
        return this.a.getTextArray(i2);
    }

    @Override // android.content.res.Resources
    public void getValue(int i2, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        this.a.getValue(i2, typedValue, z);
    }

    @Override // android.content.res.Resources
    public void getValueForDensity(int i2, int i3, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        this.a.getValueForDensity(i2, i3, typedValue, z);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getXml(int i2) throws Resources.NotFoundException {
        return this.a.getXml(i2);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        return this.a.obtainAttributes(attributeSet, iArr);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainTypedArray(int i2) throws Resources.NotFoundException {
        return this.a.obtainTypedArray(i2);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i2) throws Resources.NotFoundException {
        return this.a.openRawResource(i2);
    }

    @Override // android.content.res.Resources
    public AssetFileDescriptor openRawResourceFd(int i2) throws Resources.NotFoundException {
        return this.a.openRawResourceFd(i2);
    }

    @Override // android.content.res.Resources
    public void parseBundleExtra(String str, AttributeSet attributeSet, Bundle bundle) throws XmlPullParserException {
        this.a.parseBundleExtra(str, attributeSet, bundle);
    }

    @Override // android.content.res.Resources
    public void parseBundleExtras(XmlResourceParser xmlResourceParser, Bundle bundle) throws XmlPullParserException, IOException {
        this.a.parseBundleExtras(xmlResourceParser, bundle);
    }

    @Override // android.content.res.Resources
    public void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        super.updateConfiguration(configuration, displayMetrics);
        Resources resources = this.a;
        if (resources != null) {
            resources.updateConfiguration(configuration, displayMetrics);
        }
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i2, Resources.Theme theme) throws Resources.NotFoundException {
        return this.a.getDrawable(i2, theme);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawableForDensity(int i2, int i3, Resources.Theme theme) {
        return this.a.getDrawableForDensity(i2, i3, theme);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i2, int i3) throws Resources.NotFoundException {
        return this.a.getQuantityString(i2, i3);
    }

    @Override // android.content.res.Resources
    public String getString(int i2, Object... objArr) throws Resources.NotFoundException {
        return this.a.getString(i2, objArr);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i2, CharSequence charSequence) {
        return this.a.getText(i2, charSequence);
    }

    @Override // android.content.res.Resources
    public void getValue(String str, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        this.a.getValue(str, typedValue, z);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i2, TypedValue typedValue) throws Resources.NotFoundException {
        return this.a.openRawResource(i2, typedValue);
    }
}
