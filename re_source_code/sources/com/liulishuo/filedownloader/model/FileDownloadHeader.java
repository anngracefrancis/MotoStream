package com.liulishuo.filedownloader.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class FileDownloadHeader implements Parcelable {
    public static final Parcelable.Creator<FileDownloadHeader> CREATOR = new a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private HashMap<String, List<String>> f20494f;

    static class a implements Parcelable.Creator<FileDownloadHeader> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public FileDownloadHeader createFromParcel(Parcel parcel) {
            return new FileDownloadHeader(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public FileDownloadHeader[] newArray(int i2) {
            return new FileDownloadHeader[i2];
        }
    }

    public FileDownloadHeader() {
    }

    public void a(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (str.isEmpty()) {
            throw new IllegalArgumentException("name is empty");
        }
        if (str2 == null) {
            throw new NullPointerException("value == null");
        }
        if (this.f20494f == null) {
            this.f20494f = new HashMap<>();
        }
        List<String> arrayList = this.f20494f.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.f20494f.put(str, arrayList);
        }
        if (arrayList.contains(str2)) {
            return;
        }
        arrayList.add(str2);
    }

    public HashMap<String, List<String>> b() {
        return this.f20494f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return this.f20494f.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeMap(this.f20494f);
    }

    protected FileDownloadHeader(Parcel parcel) {
        this.f20494f = parcel.readHashMap(String.class.getClassLoader());
    }
}
