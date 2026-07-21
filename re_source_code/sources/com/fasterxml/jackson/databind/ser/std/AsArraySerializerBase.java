package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AsArraySerializerBase<T> extends ContainerSerializer<T> implements ContextualSerializer {
    protected PropertySerializerMap _dynamicSerializers;
    protected final JsonSerializer<Object> _elementSerializer;
    protected final JavaType _elementType;
    protected final BeanProperty _property;
    protected final boolean _staticTyping;
    protected final Boolean _unwrapSingle;
    protected final TypeSerializer _valueTypeSerializer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected AsArraySerializerBase(Class<?> cls, JavaType javaType, boolean z, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer) {
        super(cls, false);
        boolean z2 = false;
        this._elementType = javaType;
        if (z || (javaType != null && javaType.isFinal())) {
            z2 = true;
        }
        this._staticTyping = z2;
        this._valueTypeSerializer = typeSerializer;
        this._property = null;
        this._elementSerializer = jsonSerializer;
        this._dynamicSerializers = PropertySerializerMap.emptyForProperties();
        this._unwrapSingle = null;
    }

    protected final JsonSerializer<Object> _findAndAddDynamic(PropertySerializerMap propertySerializerMap, Class<?> cls, SerializerProvider serializerProvider) throws JsonMappingException {
        PropertySerializerMap.SerializerAndMapResult serializerAndMapResultFindAndAddSecondarySerializer = propertySerializerMap.findAndAddSecondarySerializer(cls, serializerProvider, this._property);
        PropertySerializerMap propertySerializerMap2 = serializerAndMapResultFindAndAddSecondarySerializer.map;
        if (propertySerializerMap != propertySerializerMap2) {
            this._dynamicSerializers = propertySerializerMap2;
        }
        return serializerAndMapResultFindAndAddSecondarySerializer.serializer;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0020  */
    @Override // com.fasterxml.jackson.databind.ser.ContextualSerializer
    public JsonSerializer<?> createContextual(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        JsonSerializer<Object> jsonSerializerSerializerInstance;
        Object objFindContentSerializer;
        TypeSerializer typeSerializerForProperty = this._valueTypeSerializer;
        if (typeSerializerForProperty != null) {
            typeSerializerForProperty = typeSerializerForProperty.forProperty(beanProperty);
        }
        if (beanProperty != null) {
            AnnotationIntrospector annotationIntrospector = serializerProvider.getAnnotationIntrospector();
            AnnotatedMember member = beanProperty.getMember();
            if (member == null || (objFindContentSerializer = annotationIntrospector.findContentSerializer(member)) == null) {
                jsonSerializerSerializerInstance = null;
            } else {
                jsonSerializerSerializerInstance = serializerProvider.serializerInstance(member, objFindContentSerializer);
            }
        } else {
            jsonSerializerSerializerInstance = null;
        }
        JsonFormat.Value valueFindFormatOverrides = findFormatOverrides(serializerProvider, beanProperty, handledType());
        Boolean feature = valueFindFormatOverrides != null ? valueFindFormatOverrides.getFeature(JsonFormat.Feature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED) : null;
        if (jsonSerializerSerializerInstance == null) {
            jsonSerializerSerializerInstance = this._elementSerializer;
        }
        JsonSerializer<?> jsonSerializerFindConvertingContentSerializer = findConvertingContentSerializer(serializerProvider, beanProperty, jsonSerializerSerializerInstance);
        if (jsonSerializerFindConvertingContentSerializer == null) {
            JavaType javaType = this._elementType;
            if (javaType != null && this._staticTyping && !javaType.isJavaLangObject()) {
                jsonSerializerFindConvertingContentSerializer = serializerProvider.findValueSerializer(this._elementType, beanProperty);
            }
        } else {
            jsonSerializerFindConvertingContentSerializer = serializerProvider.handleSecondaryContextualization(jsonSerializerFindConvertingContentSerializer, beanProperty);
        }
        return (jsonSerializerFindConvertingContentSerializer == this._elementSerializer && beanProperty == this._property && this._valueTypeSerializer == typeSerializerForProperty && this._unwrapSingle == feature) ? this : withResolved(beanProperty, typeSerializerForProperty, jsonSerializerFindConvertingContentSerializer, feature);
    }

    protected abstract void serializeContents(T t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException;

    @Override // com.fasterxml.jackson.databind.JsonSerializer
    public void serializeWithType(T t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        typeSerializer.writeTypePrefixForArray(t, jsonGenerator);
        jsonGenerator.setCurrentValue(t);
        serializeContents(t, jsonGenerator, serializerProvider);
        typeSerializer.writeTypeSuffixForArray(t, jsonGenerator);
    }

    public abstract AsArraySerializerBase<T> withResolved(BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer, Boolean bool);

    protected final JsonSerializer<Object> _findAndAddDynamic(PropertySerializerMap propertySerializerMap, JavaType javaType, SerializerProvider serializerProvider) throws JsonMappingException {
        PropertySerializerMap.SerializerAndMapResult serializerAndMapResultFindAndAddSecondarySerializer = propertySerializerMap.findAndAddSecondarySerializer(javaType, serializerProvider, this._property);
        PropertySerializerMap propertySerializerMap2 = serializerAndMapResultFindAndAddSecondarySerializer.map;
        if (propertySerializerMap != propertySerializerMap2) {
            this._dynamicSerializers = propertySerializerMap2;
        }
        return serializerAndMapResultFindAndAddSecondarySerializer.serializer;
    }

    protected AsArraySerializerBase(AsArraySerializerBase<?> asArraySerializerBase, BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer, Boolean bool) {
        super(asArraySerializerBase);
        this._elementType = asArraySerializerBase._elementType;
        this._staticTyping = asArraySerializerBase._staticTyping;
        this._valueTypeSerializer = typeSerializer;
        this._property = beanProperty;
        this._elementSerializer = jsonSerializer;
        this._dynamicSerializers = asArraySerializerBase._dynamicSerializers;
        this._unwrapSingle = bool;
    }
}
