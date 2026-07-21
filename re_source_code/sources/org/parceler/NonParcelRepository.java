package org.parceler;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes3.dex */
final class NonParcelRepository implements org.parceler.e<org.parceler.d.c> {
    private static final NonParcelRepository a = new NonParcelRepository();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<Class, org.parceler.d.c> f25947b;

    public static final class BooleanArrayParcelable extends ConverterParcelable<boolean[]> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final org.parceler.g.b f25948h = new org.parceler.g.b();
        public static final a CREATOR = new a();

        private static final class a implements Parcelable.Creator<BooleanArrayParcelable> {
            private a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public BooleanArrayParcelable createFromParcel(Parcel parcel) {
                return new BooleanArrayParcelable(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public BooleanArrayParcelable[] newArray(int i2) {
                return new BooleanArrayParcelable[i2];
            }
        }

        public BooleanArrayParcelable(Parcel parcel) {
            super(parcel, (org.parceler.f) f25948h);
        }

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
        }

        public BooleanArrayParcelable(boolean[] zArr) {
            super(zArr, f25948h);
        }
    }

    public static final class BooleanParcelable extends ConverterParcelable<Boolean> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final org.parceler.g.k<Boolean> f25949h = new a();
        public static final b CREATOR = new b();

        static class a extends org.parceler.g.k<Boolean> {
            a() {
            }

            @Override // org.parceler.g.k
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public Boolean c(Parcel parcel) {
                return Boolean.valueOf(parcel.createBooleanArray()[0]);
            }

            @Override // org.parceler.g.k
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void d(Boolean bool, Parcel parcel) {
                parcel.writeBooleanArray(new boolean[]{bool.booleanValue()});
            }
        }

        private static final class b implements Parcelable.Creator<BooleanParcelable> {
            private b() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public BooleanParcelable createFromParcel(Parcel parcel) {
                return new BooleanParcelable(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public BooleanParcelable[] newArray(int i2) {
                return new BooleanParcelable[i2];
            }
        }

        public BooleanParcelable(Parcel parcel) {
            super(parcel, (org.parceler.f) f25949h);
        }

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
        }

        public BooleanParcelable(boolean z) {
            super(Boolean.valueOf(z), f25949h);
        }
    }

    public static final class ByteArrayParcelable extends ConverterParcelable<byte[]> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final org.parceler.g.k<byte[]> f25950h = new a();
        public static final b CREATOR = new b();

        static class a extends org.parceler.g.k<byte[]> {
            a() {
            }

            @Override // org.parceler.g.k
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public byte[] c(Parcel parcel) {
                return parcel.createByteArray();
            }

            @Override // org.parceler.g.k
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void d(byte[] bArr, Parcel parcel) {
                parcel.writeByteArray(bArr);
            }
        }

        private static final class b implements Parcelable.Creator<ByteArrayParcelable> {
            private b() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public ByteArrayParcelable createFromParcel(Parcel parcel) {
                return new ByteArrayParcelable(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public ByteArrayParcelable[] newArray(int i2) {
                return new ByteArrayParcelable[i2];
            }
        }

        public ByteArrayParcelable(Parcel parcel) {
            super(parcel, (org.parceler.f) f25950h);
        }

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
        }

        public ByteArrayParcelable(byte[] bArr) {
            super(bArr, f25950h);
        }
    }

    public static final class ByteParcelable extends ConverterParcelable<Byte> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final org.parceler.g.k<Byte> f25951h = new a();
        public static final b CREATOR = new b();

        static class a extends org.parceler.g.k<Byte> {
            a() {
            }

            @Override // org.parceler.g.k
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public Byte c(Parcel parcel) {
                return Byte.valueOf(parcel.readByte());
            }

            @Override // org.parceler.g.k
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void d(Byte b2, Parcel parcel) {
                parcel.writeByte(b2.byteValue());
            }
        }

        private static final class b implements Parcelable.Creator<ByteParcelable> {
            private b() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public ByteParcelable createFromParcel(Parcel parcel) {
                return new ByteParcelable(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public ByteParcelable[] newArray(int i2) {
                return new ByteParcelable[i2];
            }
        }

        public ByteParcelable(Parcel parcel) {
            super(parcel, (org.parceler.f) f25951h);
        }

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
        }

        public ByteParcelable(Byte b2) {
            super(b2, f25951h);
        }
    }

    public static final class CharArrayParcelable extends ConverterParcelable<char[]> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final org.parceler.g.c f25952h = new org.parceler.g.c();
        public static final a CREATOR = new a();

        private static final class a implements Parcelable.Creator<CharArrayParcelable> {
            private a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public CharArrayParcelable createFromParcel(Parcel parcel) {
                return new CharArrayParcelable(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public CharArrayParcelable[] newArray(int i2) {
                return new CharArrayParcelable[i2];
            }
        }

        public CharArrayParcelable(Parcel parcel) {
            super(parcel, (org.parceler.f) f25952h);
        }

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
        }

        public CharArrayParcelable(char[] cArr) {
            super(cArr, f25952h);
        }
    }

    public static final class CharacterParcelable extends ConverterParcelable<Character> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final org.parceler.g.k<Character> f25953h = new a();
        public static final b CREATOR = new b();

        static class a extends org.parceler.g.k<Character> {
            a() {
            }

            @Override // org.parceler.g.k
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public Character c(Parcel parcel) {
                return Character.valueOf(parcel.createCharArray()[0]);
            }

            @Override // org.parceler.g.k
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void d(Character ch, Parcel parcel) {
                parcel.writeCharArray(new char[]{ch.charValue()});
            }
        }

        private static final class b implements Parcelable.Creator<CharacterParcelable> {
            private b() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public CharacterParcelable createFromParcel(Parcel parcel) {
                return new CharacterParcelable(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public CharacterParcelable[] newArray(int i2) {
                return new CharacterParcelable[i2];
            }
        }

        public CharacterParcelable(Parcel parcel) {
            super(parcel, (org.parceler.f) f25953h);
        }

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
        }

        public CharacterParcelable(Character ch) {
            super(ch, f25953h);
        }
    }

    public static final class CollectionParcelable extends ConverterParcelable<Collection> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final org.parceler.g.d f25954h = new a();
        public static final b CREATOR = new b();

        static class a extends org.parceler.g.a {
            a() {
            }

            @Override // org.parceler.g.d
            public Object e(Parcel parcel) {
                return org.parceler.d.a(parcel.readParcelable(CollectionParcelable.class.getClassLoader()));
            }

            @Override // org.parceler.g.d
            public void f(Object obj, Parcel parcel) {
                parcel.writeParcelable(org.parceler.d.c(obj), 0);
            }
        }

        private static final class b implements Parcelable.Creator<CollectionParcelable> {
            private b() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public CollectionParcelable createFromParcel(Parcel parcel) {
                return new CollectionParcelable(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public CollectionParcelable[] newArray(int i2) {
                return new CollectionParcelable[i2];
            }
        }

        public CollectionParcelable(Parcel parcel) {
            super(parcel, (org.parceler.f) f25954h);
        }

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
        }

        public CollectionParcelable(Collection collection) {
            super(collection, f25954h);
        }
    }

    public static final class DoubleParcelable extends ConverterParcelable<Double> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final org.parceler.g.k<Double> f25957h = new a();
        public static final b CREATOR = new b();

        static class a extends org.parceler.g.k<Double> {
            a() {
            }

            @Override // org.parceler.g.k
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public Double c(Parcel parcel) {
                return Double.valueOf(parcel.readDouble());
            }

            @Override // org.parceler.g.k
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void d(Double d2, Parcel parcel) {
                parcel.writeDouble(d2.doubleValue());
            }
        }

        private static final class b implements Parcelable.Creator<DoubleParcelable> {
            private b() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public DoubleParcelable createFromParcel(Parcel parcel) {
                return new DoubleParcelable(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public DoubleParcelable[] newArray(int i2) {
                return new DoubleParcelable[i2];
            }
        }

        public DoubleParcelable(Parcel parcel) {
            super(parcel, (org.parceler.f) f25957h);
        }

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
        }

        public DoubleParcelable(Double d2) {
            super(d2, f25957h);
        }
    }

    public static final class FloatParcelable extends ConverterParcelable<Float> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final org.parceler.g.k<Float> f25958h = new a();
        public static final b CREATOR = new b();

        static class a extends org.parceler.g.k<Float> {
            a() {
            }

            @Override // org.parceler.g.k
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public Float c(Parcel parcel) {
                return Float.valueOf(parcel.readFloat());
            }

            @Override // org.parceler.g.k
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void d(Float f2, Parcel parcel) {
                parcel.writeFloat(f2.floatValue());
            }
        }

        private static final class b implements Parcelable.Creator<FloatParcelable> {
            private b() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public FloatParcelable createFromParcel(Parcel parcel) {
                return new FloatParcelable(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public FloatParcelable[] newArray(int i2) {
                return new FloatParcelable[i2];
            }
        }

        public FloatParcelable(Parcel parcel) {
            super(parcel, (org.parceler.f) f25958h);
        }

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
        }

        public FloatParcelable(Float f2) {
            super(f2, f25958h);
        }
    }

    public static final class IBinderParcelable extends ConverterParcelable<IBinder> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final org.parceler.g.k<IBinder> f25959h = new a();
        public static final b CREATOR = new b();

        static class a extends org.parceler.g.k<IBinder> {
            a() {
            }

            @Override // org.parceler.g.k
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public IBinder c(Parcel parcel) {
                return parcel.readStrongBinder();
            }

            @Override // org.parceler.g.k
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void d(IBinder iBinder, Parcel parcel) {
                parcel.writeStrongBinder(iBinder);
            }
        }

        private static final class b implements Parcelable.Creator<IBinderParcelable> {
            private b() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public IBinderParcelable createFromParcel(Parcel parcel) {
                return new IBinderParcelable(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public IBinderParcelable[] newArray(int i2) {
                return new IBinderParcelable[i2];
            }
        }

        public IBinderParcelable(Parcel parcel) {
            super(parcel, (org.parceler.f) f25959h);
        }

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
        }

        public IBinderParcelable(IBinder iBinder) {
            super(iBinder, f25959h);
        }
    }

    public static final class IntegerParcelable extends ConverterParcelable<Integer> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final org.parceler.g.k<Integer> f25960h = new a();
        public static final b CREATOR = new b();

        static class a extends org.parceler.g.k<Integer> {
            a() {
            }

            @Override // org.parceler.g.k
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public Integer c(Parcel parcel) {
                return Integer.valueOf(parcel.readInt());
            }

            @Override // org.parceler.g.k
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void d(Integer num, Parcel parcel) {
                parcel.writeInt(num.intValue());
            }
        }

        private static final class b implements Parcelable.Creator<IntegerParcelable> {
            private b() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public IntegerParcelable createFromParcel(Parcel parcel) {
                return new IntegerParcelable(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public IntegerParcelable[] newArray(int i2) {
                return new IntegerParcelable[i2];
            }
        }

        public IntegerParcelable(Parcel parcel) {
            super(parcel, (org.parceler.f) f25960h);
        }

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
        }

        public IntegerParcelable(Integer num) {
            super(num, f25960h);
        }
    }

    public static final class LinkedHashMapParcelable extends ConverterParcelable<LinkedHashMap> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final org.parceler.g.g f25961h = new a();
        public static final b CREATOR = new b();

        static class a extends org.parceler.g.g {
            a() {
            }

            @Override // org.parceler.g.j
            public Object e(Parcel parcel) {
                return org.parceler.d.a(parcel.readParcelable(MapParcelable.class.getClassLoader()));
            }

            @Override // org.parceler.g.j
            public void f(Object obj, Parcel parcel) {
                parcel.writeParcelable(org.parceler.d.c(obj), 0);
            }

            @Override // org.parceler.g.j
            public Object g(Parcel parcel) {
                return org.parceler.d.a(parcel.readParcelable(MapParcelable.class.getClassLoader()));
            }

            @Override // org.parceler.g.j
            public void h(Object obj, Parcel parcel) {
                parcel.writeParcelable(org.parceler.d.c(obj), 0);
            }
        }

        private static final class b implements Parcelable.Creator<LinkedHashMapParcelable> {
            private b() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public LinkedHashMapParcelable createFromParcel(Parcel parcel) {
                return new LinkedHashMapParcelable(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public LinkedHashMapParcelable[] newArray(int i2) {
                return new LinkedHashMapParcelable[i2];
            }
        }

        public LinkedHashMapParcelable(Parcel parcel) {
            super(parcel, (org.parceler.f) f25961h);
        }

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
        }

        public LinkedHashMapParcelable(LinkedHashMap linkedHashMap) {
            super(linkedHashMap, f25961h);
        }
    }

    public static final class LinkedHashSetParcelable extends ConverterParcelable<LinkedHashSet> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final org.parceler.g.h f25962h = new a();
        public static final b CREATOR = new b();

        static class a extends org.parceler.g.h {
            a() {
            }

            @Override // org.parceler.g.d
            public Object e(Parcel parcel) {
                return org.parceler.d.a(parcel.readParcelable(LinkedHashSetParcelable.class.getClassLoader()));
            }

            @Override // org.parceler.g.d
            public void f(Object obj, Parcel parcel) {
                parcel.writeParcelable(org.parceler.d.c(obj), 0);
            }
        }

        private static final class b implements Parcelable.Creator<LinkedHashSetParcelable> {
            private b() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public LinkedHashSetParcelable createFromParcel(Parcel parcel) {
                return new LinkedHashSetParcelable(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public LinkedHashSetParcelable[] newArray(int i2) {
                return new LinkedHashSetParcelable[i2];
            }
        }

        public LinkedHashSetParcelable(Parcel parcel) {
            super(parcel, (org.parceler.f) f25962h);
        }

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
        }

        public LinkedHashSetParcelable(LinkedHashSet linkedHashSet) {
            super(linkedHashSet, f25962h);
        }
    }

    public static final class LinkedListParcelable extends ConverterParcelable<LinkedList> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final org.parceler.g.i f25963h = new a();
        public static final b CREATOR = new b();

        static class a extends org.parceler.g.i {
            a() {
            }

            @Override // org.parceler.g.d
            public Object e(Parcel parcel) {
                return org.parceler.d.a(parcel.readParcelable(LinkedListParcelable.class.getClassLoader()));
            }

            @Override // org.parceler.g.d
            public void f(Object obj, Parcel parcel) {
                parcel.writeParcelable(org.parceler.d.c(obj), 0);
            }
        }

        private static final class b implements Parcelable.Creator<LinkedListParcelable> {
            private b() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public LinkedListParcelable createFromParcel(Parcel parcel) {
                return new LinkedListParcelable(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public LinkedListParcelable[] newArray(int i2) {
                return new LinkedListParcelable[i2];
            }
        }

        public LinkedListParcelable(Parcel parcel) {
            super(parcel, (org.parceler.f) f25963h);
        }

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
        }

        public LinkedListParcelable(LinkedList linkedList) {
            super(linkedList, f25963h);
        }
    }

    public static final class ListParcelable extends ConverterParcelable<List> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final org.parceler.g.a f25964h = new a();
        public static final b CREATOR = new b();

        static class a extends org.parceler.g.a {
            a() {
            }

            @Override // org.parceler.g.d
            public Object e(Parcel parcel) {
                return org.parceler.d.a(parcel.readParcelable(ListParcelable.class.getClassLoader()));
            }

            @Override // org.parceler.g.d
            public void f(Object obj, Parcel parcel) {
                parcel.writeParcelable(org.parceler.d.c(obj), 0);
            }
        }

        private static final class b implements Parcelable.Creator<ListParcelable> {
            private b() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public ListParcelable createFromParcel(Parcel parcel) {
                return new ListParcelable(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public ListParcelable[] newArray(int i2) {
                return new ListParcelable[i2];
            }
        }

        public ListParcelable(Parcel parcel) {
            super(parcel, (org.parceler.f) f25964h);
        }

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
        }

        public ListParcelable(List list) {
            super(list, f25964h);
        }
    }

    public static final class LongParcelable extends ConverterParcelable<Long> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final org.parceler.g.k<Long> f25965h = new a();
        public static final b CREATOR = new b();

        static class a extends org.parceler.g.k<Long> {
            a() {
            }

            @Override // org.parceler.g.k
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public Long c(Parcel parcel) {
                return Long.valueOf(parcel.readLong());
            }

            @Override // org.parceler.g.k
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void d(Long l, Parcel parcel) {
                parcel.writeLong(l.longValue());
            }
        }

        private static final class b implements Parcelable.Creator<LongParcelable> {
            private b() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public LongParcelable createFromParcel(Parcel parcel) {
                return new LongParcelable(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public LongParcelable[] newArray(int i2) {
                return new LongParcelable[i2];
            }
        }

        public LongParcelable(Parcel parcel) {
            super(parcel, (org.parceler.f) f25965h);
        }

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
        }

        public LongParcelable(Long l) {
            super(l, f25965h);
        }
    }

    public static final class MapParcelable extends ConverterParcelable<Map> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final org.parceler.g.e f25966h = new a();
        public static final b CREATOR = new b();

        static class a extends org.parceler.g.e {
            a() {
            }

            @Override // org.parceler.g.j
            public Object e(Parcel parcel) {
                return org.parceler.d.a(parcel.readParcelable(MapParcelable.class.getClassLoader()));
            }

            @Override // org.parceler.g.j
            public void f(Object obj, Parcel parcel) {
                parcel.writeParcelable(org.parceler.d.c(obj), 0);
            }

            @Override // org.parceler.g.j
            public Object g(Parcel parcel) {
                return org.parceler.d.a(parcel.readParcelable(MapParcelable.class.getClassLoader()));
            }

            @Override // org.parceler.g.j
            public void h(Object obj, Parcel parcel) {
                parcel.writeParcelable(org.parceler.d.c(obj), 0);
            }
        }

        private static final class b implements Parcelable.Creator<MapParcelable> {
            private b() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public MapParcelable createFromParcel(Parcel parcel) {
                return new MapParcelable(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public MapParcelable[] newArray(int i2) {
                return new MapParcelable[i2];
            }
        }

        public MapParcelable(Parcel parcel) {
            super(parcel, (org.parceler.f) f25966h);
        }

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
        }

        public MapParcelable(Map map) {
            super(map, f25966h);
        }
    }

    public static final class SetParcelable extends ConverterParcelable<Set> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final org.parceler.g.f f25968h = new a();
        public static final b CREATOR = new b();

        static class a extends org.parceler.g.f {
            a() {
            }

            @Override // org.parceler.g.d
            public Object e(Parcel parcel) {
                return org.parceler.d.a(parcel.readParcelable(SetParcelable.class.getClassLoader()));
            }

            @Override // org.parceler.g.d
            public void f(Object obj, Parcel parcel) {
                parcel.writeParcelable(org.parceler.d.c(obj), 0);
            }
        }

        private static final class b implements Parcelable.Creator<SetParcelable> {
            private b() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SetParcelable createFromParcel(Parcel parcel) {
                return new SetParcelable(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SetParcelable[] newArray(int i2) {
                return new SetParcelable[i2];
            }
        }

        public SetParcelable(Parcel parcel) {
            super(parcel, (org.parceler.f) f25968h);
        }

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
        }

        public SetParcelable(Set set) {
            super(set, f25968h);
        }
    }

    public static final class SparseArrayParcelable extends ConverterParcelable<SparseArray> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final org.parceler.g.l f25969h = new a();
        public static final b CREATOR = new b();

        static class a extends org.parceler.g.l {
            a() {
            }

            @Override // org.parceler.g.l
            public Object d(Parcel parcel) {
                return org.parceler.d.a(parcel.readParcelable(SparseArrayParcelable.class.getClassLoader()));
            }

            @Override // org.parceler.g.l
            public void e(Object obj, Parcel parcel) {
                parcel.writeParcelable(org.parceler.d.c(obj), 0);
            }
        }

        private static final class b implements Parcelable.Creator<SparseArrayParcelable> {
            private b() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SparseArrayParcelable createFromParcel(Parcel parcel) {
                return new SparseArrayParcelable(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SparseArrayParcelable[] newArray(int i2) {
                return new SparseArrayParcelable[i2];
            }
        }

        public SparseArrayParcelable(Parcel parcel) {
            super(parcel, (org.parceler.f) f25969h);
        }

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
        }

        public SparseArrayParcelable(SparseArray sparseArray) {
            super(sparseArray, f25969h);
        }
    }

    public static final class SparseBooleanArrayParcelable extends ConverterParcelable<SparseBooleanArray> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final org.parceler.g.k<SparseBooleanArray> f25970h = new a();
        public static final b CREATOR = new b();

        static class a extends org.parceler.g.k<SparseBooleanArray> {
            a() {
            }

            @Override // org.parceler.g.k
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public SparseBooleanArray c(Parcel parcel) {
                return parcel.readSparseBooleanArray();
            }

            @Override // org.parceler.g.k
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void d(SparseBooleanArray sparseBooleanArray, Parcel parcel) {
                parcel.writeSparseBooleanArray(sparseBooleanArray);
            }
        }

        private static final class b implements Parcelable.Creator<SparseBooleanArrayParcelable> {
            private b() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SparseBooleanArrayParcelable createFromParcel(Parcel parcel) {
                return new SparseBooleanArrayParcelable(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SparseBooleanArrayParcelable[] newArray(int i2) {
                return new SparseBooleanArrayParcelable[i2];
            }
        }

        public SparseBooleanArrayParcelable(Parcel parcel) {
            super(parcel, (org.parceler.f) f25970h);
        }

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
        }

        public SparseBooleanArrayParcelable(SparseBooleanArray sparseBooleanArray) {
            super(sparseBooleanArray, f25970h);
        }
    }

    public static final class TreeMapParcelable extends ConverterParcelable<Map> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final org.parceler.g.m f25972h = new a();
        public static final b CREATOR = new b();

        static class a extends org.parceler.g.m {
            a() {
            }

            @Override // org.parceler.g.j
            public Object e(Parcel parcel) {
                return org.parceler.d.a(parcel.readParcelable(MapParcelable.class.getClassLoader()));
            }

            @Override // org.parceler.g.j
            public void f(Object obj, Parcel parcel) {
                parcel.writeParcelable(org.parceler.d.c(obj), 0);
            }

            @Override // org.parceler.g.j
            public Object g(Parcel parcel) {
                return org.parceler.d.a(parcel.readParcelable(MapParcelable.class.getClassLoader()));
            }

            @Override // org.parceler.g.j
            public void h(Object obj, Parcel parcel) {
                parcel.writeParcelable(org.parceler.d.c(obj), 0);
            }
        }

        private static final class b implements Parcelable.Creator<TreeMapParcelable> {
            private b() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public TreeMapParcelable createFromParcel(Parcel parcel) {
                return new TreeMapParcelable(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public TreeMapParcelable[] newArray(int i2) {
                return new TreeMapParcelable[i2];
            }
        }

        public TreeMapParcelable(Parcel parcel) {
            super(parcel, (org.parceler.f) f25972h);
        }

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
        }

        public TreeMapParcelable(Map map) {
            super(map, f25972h);
        }
    }

    public static final class TreeSetParcelable extends ConverterParcelable<Set> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final org.parceler.g.n f25973h = new a();
        public static final b CREATOR = new b();

        static class a extends org.parceler.g.n {
            a() {
            }

            @Override // org.parceler.g.d
            public Object e(Parcel parcel) {
                return org.parceler.d.a(parcel.readParcelable(TreeSetParcelable.class.getClassLoader()));
            }

            @Override // org.parceler.g.d
            public void f(Object obj, Parcel parcel) {
                parcel.writeParcelable(org.parceler.d.c(obj), 0);
            }
        }

        private static final class b implements Parcelable.Creator<TreeSetParcelable> {
            private b() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public TreeSetParcelable createFromParcel(Parcel parcel) {
                return new TreeSetParcelable(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public TreeSetParcelable[] newArray(int i2) {
                return new TreeSetParcelable[i2];
            }
        }

        public TreeSetParcelable(Parcel parcel) {
            super(parcel, (org.parceler.f) f25973h);
        }

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
        }

        public TreeSetParcelable(Set set) {
            super(set, f25973h);
        }
    }

    private static class b implements org.parceler.d.c<boolean[]> {
        private b() {
        }

        @Override // org.parceler.d.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Parcelable a(boolean[] zArr) {
            return new BooleanArrayParcelable(zArr);
        }
    }

    private static class c implements org.parceler.d.c<Boolean> {
        private c() {
        }

        @Override // org.parceler.d.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Parcelable a(Boolean bool) {
            return new BooleanParcelable(bool.booleanValue());
        }
    }

    private static class d implements org.parceler.d.c<Bundle> {
        private d() {
        }

        @Override // org.parceler.d.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Parcelable a(Bundle bundle) {
            return bundle;
        }
    }

    private static class e implements org.parceler.d.c<byte[]> {
        private e() {
        }

        @Override // org.parceler.d.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Parcelable a(byte[] bArr) {
            return new ByteArrayParcelable(bArr);
        }
    }

    private static class f implements org.parceler.d.c<Byte> {
        private f() {
        }

        @Override // org.parceler.d.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Parcelable a(Byte b2) {
            return new ByteParcelable(b2);
        }
    }

    private static class g implements org.parceler.d.c<char[]> {
        private g() {
        }

        @Override // org.parceler.d.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Parcelable a(char[] cArr) {
            return new CharArrayParcelable(cArr);
        }
    }

    private static class h implements org.parceler.d.c<Character> {
        private h() {
        }

        @Override // org.parceler.d.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Parcelable a(Character ch) {
            return new CharacterParcelable(ch);
        }
    }

    private static class i implements org.parceler.d.c<Collection> {
        private i() {
        }

        @Override // org.parceler.d.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Parcelable a(Collection collection) {
            return new CollectionParcelable(collection);
        }
    }

    private static class j implements org.parceler.d.c<Double> {
        private j() {
        }

        @Override // org.parceler.d.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Parcelable a(Double d2) {
            return new DoubleParcelable(d2);
        }
    }

    private static class k implements org.parceler.d.c<Float> {
        private k() {
        }

        @Override // org.parceler.d.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Parcelable a(Float f2) {
            return new FloatParcelable(f2);
        }
    }

    private static class l implements org.parceler.d.c<IBinder> {
        private l() {
        }

        @Override // org.parceler.d.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Parcelable a(IBinder iBinder) {
            return new IBinderParcelable(iBinder);
        }
    }

    private static class m implements org.parceler.d.c<Integer> {
        private m() {
        }

        @Override // org.parceler.d.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Parcelable a(Integer num) {
            return new IntegerParcelable(num);
        }
    }

    private static class n implements org.parceler.d.c<LinkedHashMap> {
        private n() {
        }

        @Override // org.parceler.d.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Parcelable a(LinkedHashMap linkedHashMap) {
            return new LinkedHashMapParcelable(linkedHashMap);
        }
    }

    private static class o implements org.parceler.d.c<LinkedHashSet> {
        private o() {
        }

        @Override // org.parceler.d.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Parcelable a(LinkedHashSet linkedHashSet) {
            return new LinkedHashSetParcelable(linkedHashSet);
        }
    }

    private static class p implements org.parceler.d.c<LinkedList> {
        private p() {
        }

        @Override // org.parceler.d.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Parcelable a(LinkedList linkedList) {
            return new LinkedListParcelable(linkedList);
        }
    }

    private static class q implements org.parceler.d.c<List> {
        private q() {
        }

        @Override // org.parceler.d.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Parcelable a(List list) {
            return new ListParcelable(list);
        }
    }

    private static class r implements org.parceler.d.c<Long> {
        private r() {
        }

        @Override // org.parceler.d.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Parcelable a(Long l) {
            return new LongParcelable(l);
        }
    }

    private static class s implements org.parceler.d.c<Map> {
        private s() {
        }

        @Override // org.parceler.d.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Parcelable a(Map map) {
            return new MapParcelable(map);
        }
    }

    static class t implements org.parceler.d.c<Parcelable> {
        t() {
        }

        @Override // org.parceler.d.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Parcelable a(Parcelable parcelable) {
            return new ParcelableParcelable(parcelable);
        }
    }

    private static class u implements org.parceler.d.c<Set> {
        private u() {
        }

        @Override // org.parceler.d.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Parcelable a(Set set) {
            return new SetParcelable(set);
        }
    }

    private static class v implements org.parceler.d.c<SparseArray> {
        private v() {
        }

        @Override // org.parceler.d.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Parcelable a(SparseArray sparseArray) {
            return new SparseArrayParcelable(sparseArray);
        }
    }

    private static class w implements org.parceler.d.c<SparseBooleanArray> {
        private w() {
        }

        @Override // org.parceler.d.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Parcelable a(SparseBooleanArray sparseBooleanArray) {
            return new SparseBooleanArrayParcelable(sparseBooleanArray);
        }
    }

    private static class x implements org.parceler.d.c<String> {
        private x() {
        }

        @Override // org.parceler.d.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Parcelable a(String str) {
            return new StringParcelable(str);
        }
    }

    private static class y implements org.parceler.d.c<Map> {
        private y() {
        }

        @Override // org.parceler.d.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Parcelable a(Map map) {
            return new TreeMapParcelable(map);
        }
    }

    private static class z implements org.parceler.d.c<Set> {
        private z() {
        }

        @Override // org.parceler.d.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Parcelable a(Set set) {
            return new TreeSetParcelable(set);
        }
    }

    private NonParcelRepository() {
        HashMap map = new HashMap();
        this.f25947b = map;
        map.put(Collection.class, new i());
        map.put(List.class, new q());
        map.put(ArrayList.class, new q());
        map.put(Set.class, new u());
        map.put(HashSet.class, new u());
        map.put(TreeSet.class, new z());
        map.put(SparseArray.class, new v());
        map.put(Map.class, new s());
        map.put(HashMap.class, new s());
        map.put(TreeMap.class, new y());
        map.put(Integer.class, new m());
        map.put(Long.class, new r());
        map.put(Double.class, new j());
        map.put(Float.class, new k());
        map.put(Byte.class, new f());
        map.put(String.class, new x());
        map.put(Character.class, new h());
        map.put(Boolean.class, new c());
        map.put(byte[].class, new e());
        map.put(char[].class, new g());
        map.put(boolean[].class, new b());
        map.put(IBinder.class, new l());
        map.put(Bundle.class, new d());
        map.put(SparseBooleanArray.class, new w());
        map.put(LinkedList.class, new p());
        map.put(LinkedHashMap.class, new n());
        map.put(SortedMap.class, new y());
        map.put(SortedSet.class, new z());
        map.put(LinkedHashSet.class, new o());
    }

    public static NonParcelRepository a() {
        return a;
    }

    @Override // org.parceler.e
    public Map<Class, org.parceler.d.c> get() {
        return this.f25947b;
    }

    private static class ConverterParcelable<T> implements Parcelable, org.parceler.c<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final T f25955f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final org.parceler.f<T, T> f25956g;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // org.parceler.c
        public T getParcel() {
            return this.f25955f;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            this.f25956g.b(this.f25955f, parcel);
        }

        private ConverterParcelable(Parcel parcel, org.parceler.f<T, T> fVar) {
            this(fVar.a(parcel), fVar);
        }

        private ConverterParcelable(T t, org.parceler.f<T, T> fVar) {
            this.f25956g = fVar;
            this.f25955f = t;
        }
    }

    public static final class ParcelableParcelable implements Parcelable, org.parceler.c<Parcelable> {
        public static final a CREATOR = new a();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Parcelable f25967f;

        private static final class a implements Parcelable.Creator<ParcelableParcelable> {
            private a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public ParcelableParcelable createFromParcel(Parcel parcel) {
                return new ParcelableParcelable(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public ParcelableParcelable[] newArray(int i2) {
                return new ParcelableParcelable[i2];
            }
        }

        @Override // org.parceler.c
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Parcelable getParcel() {
            return this.f25967f;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeParcelable(this.f25967f, i2);
        }

        private ParcelableParcelable(Parcel parcel) {
            this.f25967f = parcel.readParcelable(ParcelableParcelable.class.getClassLoader());
        }

        private ParcelableParcelable(Parcelable parcelable) {
            this.f25967f = parcelable;
        }
    }

    public static final class StringParcelable implements Parcelable, org.parceler.c<String> {
        public static final a CREATOR = new a();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f25971f;

        private static final class a implements Parcelable.Creator<StringParcelable> {
            private a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public StringParcelable createFromParcel(Parcel parcel) {
                return new StringParcelable(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public StringParcelable[] newArray(int i2) {
                return new StringParcelable[i2];
            }
        }

        @Override // org.parceler.c
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public String getParcel() {
            return this.f25971f;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeString(this.f25971f);
        }

        private StringParcelable(Parcel parcel) {
            this.f25971f = parcel.readString();
        }

        private StringParcelable(String str) {
            this.f25971f = str;
        }
    }
}
