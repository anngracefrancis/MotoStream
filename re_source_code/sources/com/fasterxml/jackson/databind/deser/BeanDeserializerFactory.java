package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators$PropertyGenerator;
import com.fasterxml.jackson.annotation.ObjectIdResolver;
import com.fasterxml.jackson.databind.AbstractTypeResolver;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.databind.cfg.ConfigOverride;
import com.fasterxml.jackson.databind.cfg.DeserializerFactoryConfig;
import com.fasterxml.jackson.databind.deser.impl.ErrorThrowingDeserializer;
import com.fasterxml.jackson.databind.deser.impl.FieldProperty;
import com.fasterxml.jackson.databind.deser.impl.MethodProperty;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import com.fasterxml.jackson.databind.deser.impl.PropertyBasedObjectIdGenerator;
import com.fasterxml.jackson.databind.deser.impl.SetterlessProperty;
import com.fasterxml.jackson.databind.deser.std.ThrowableDeserializer;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.fasterxml.jackson.databind.introspect.ObjectIdInfo;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.SimpleBeanPropertyDefinition;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class BeanDeserializerFactory extends BasicDeserializerFactory implements Serializable {
    private static final Class<?>[] INIT_CAUSE_PARAMS = {Throwable.class};
    private static final Class<?>[] NO_VIEWS = new Class[0];
    public static final BeanDeserializerFactory instance = new BeanDeserializerFactory(new DeserializerFactoryConfig());

    public BeanDeserializerFactory(DeserializerFactoryConfig deserializerFactoryConfig) {
        super(deserializerFactoryConfig);
    }

    /* JADX WARN: Code duplicated, block: B:52:0x0135  */
    protected void addBeanProps(DeserializationContext deserializationContext, BeanDescription beanDescription, BeanDeserializerBuilder beanDeserializerBuilder) throws JsonMappingException {
        Set<String> setEmptySet;
        AnnotatedMember annotatedMemberFindAnySetterField;
        SettableBeanProperty settableBeanPropertyConstructSetterlessProperty;
        CreatorProperty creatorProperty;
        Set<String> ignoredPropertyNames;
        SettableBeanProperty[] fromObjectArguments = beanDeserializerBuilder.getValueInstantiator().getFromObjectArguments(deserializationContext.getConfig());
        boolean z = !beanDescription.getType().isAbstract();
        JsonIgnoreProperties.Value defaultPropertyIgnorals = deserializationContext.getConfig().getDefaultPropertyIgnorals(beanDescription.getBeanClass(), beanDescription.getClassInfo());
        if (defaultPropertyIgnorals != null) {
            beanDeserializerBuilder.setIgnoreUnknownProperties(defaultPropertyIgnorals.getIgnoreUnknown());
            setEmptySet = defaultPropertyIgnorals.getIgnored();
            Iterator<String> it = setEmptySet.iterator();
            while (it.hasNext()) {
                beanDeserializerBuilder.addIgnorable(it.next());
            }
        } else {
            setEmptySet = Collections.emptySet();
        }
        Set<String> set = setEmptySet;
        AnnotatedMethod annotatedMethodFindAnySetter = beanDescription.findAnySetter();
        if (annotatedMethodFindAnySetter != null) {
            beanDeserializerBuilder.setAnySetter(constructAnySetter(deserializationContext, beanDescription, annotatedMethodFindAnySetter));
            annotatedMemberFindAnySetterField = null;
        } else {
            annotatedMemberFindAnySetterField = beanDescription.findAnySetterField();
            if (annotatedMemberFindAnySetterField != null) {
                beanDeserializerBuilder.setAnySetter(constructAnySetter(deserializationContext, beanDescription, annotatedMemberFindAnySetterField));
            }
        }
        if (annotatedMethodFindAnySetter == null && annotatedMemberFindAnySetterField == null && (ignoredPropertyNames = beanDescription.getIgnoredPropertyNames()) != null) {
            Iterator<String> it2 = ignoredPropertyNames.iterator();
            while (it2.hasNext()) {
                beanDeserializerBuilder.addIgnorable(it2.next());
            }
        }
        boolean z2 = deserializationContext.isEnabled(MapperFeature.USE_GETTERS_AS_SETTERS) && deserializationContext.isEnabled(MapperFeature.AUTO_DETECT_GETTERS);
        List<BeanPropertyDefinition> listFilterBeanProps = filterBeanProps(deserializationContext, beanDescription, beanDeserializerBuilder, beanDescription.findProperties(), set);
        if (this._factoryConfig.hasDeserializerModifiers()) {
            Iterator<BeanDeserializerModifier> it3 = this._factoryConfig.deserializerModifiers().iterator();
            while (it3.hasNext()) {
                listFilterBeanProps = it3.next().updateProperties(deserializationContext.getConfig(), beanDescription, listFilterBeanProps);
            }
        }
        for (BeanPropertyDefinition beanPropertyDefinition : listFilterBeanProps) {
            if (beanPropertyDefinition.hasSetter()) {
                settableBeanPropertyConstructSetterlessProperty = constructSettableProperty(deserializationContext, beanDescription, beanPropertyDefinition, beanPropertyDefinition.getSetter().getParameterType(0));
            } else if (beanPropertyDefinition.hasField()) {
                settableBeanPropertyConstructSetterlessProperty = constructSettableProperty(deserializationContext, beanDescription, beanPropertyDefinition, beanPropertyDefinition.getField().getType());
            } else if (z2 && beanPropertyDefinition.hasGetter()) {
                Class<?> rawType = beanPropertyDefinition.getGetter().getRawType();
                if (Collection.class.isAssignableFrom(rawType) || Map.class.isAssignableFrom(rawType)) {
                    settableBeanPropertyConstructSetterlessProperty = constructSetterlessProperty(deserializationContext, beanDescription, beanPropertyDefinition);
                } else {
                    settableBeanPropertyConstructSetterlessProperty = null;
                }
            } else {
                settableBeanPropertyConstructSetterlessProperty = null;
            }
            if (z && beanPropertyDefinition.hasConstructorParameter()) {
                String name = beanPropertyDefinition.getName();
                if (fromObjectArguments == null) {
                    creatorProperty = null;
                    break;
                }
                int length = fromObjectArguments.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        creatorProperty = null;
                        break;
                    }
                    SettableBeanProperty settableBeanProperty = fromObjectArguments[i2];
                    if (name.equals(settableBeanProperty.getName()) && (settableBeanProperty instanceof CreatorProperty)) {
                        creatorProperty = (CreatorProperty) settableBeanProperty;
                        break;
                    }
                    i2++;
                }
                if (creatorProperty == null) {
                    deserializationContext.reportMappingException("Could not find creator property with name '%s' (in class %s)", name, beanDescription.getBeanClass().getName());
                } else {
                    if (settableBeanPropertyConstructSetterlessProperty != null) {
                        creatorProperty.setFallbackSetter(settableBeanPropertyConstructSetterlessProperty);
                    }
                    beanDeserializerBuilder.addCreatorProperty(creatorProperty);
                }
            } else if (settableBeanPropertyConstructSetterlessProperty != null) {
                Class<?>[] clsArrFindViews = beanPropertyDefinition.findViews();
                if (clsArrFindViews == null && !deserializationContext.isEnabled(MapperFeature.DEFAULT_VIEW_INCLUSION)) {
                    clsArrFindViews = NO_VIEWS;
                }
                settableBeanPropertyConstructSetterlessProperty.setViews(clsArrFindViews);
                beanDeserializerBuilder.addProperty(settableBeanPropertyConstructSetterlessProperty);
            }
        }
    }

    protected void addInjectables(DeserializationContext deserializationContext, BeanDescription beanDescription, BeanDeserializerBuilder beanDeserializerBuilder) throws JsonMappingException {
        Map<Object, AnnotatedMember> mapFindInjectables = beanDescription.findInjectables();
        if (mapFindInjectables != null) {
            for (Map.Entry<Object, AnnotatedMember> entry : mapFindInjectables.entrySet()) {
                AnnotatedMember value = entry.getValue();
                beanDeserializerBuilder.addInjectable(PropertyName.construct(value.getName()), value.getType(), beanDescription.getClassAnnotations(), value, entry.getKey());
            }
        }
    }

    protected void addObjectIdReader(DeserializationContext deserializationContext, BeanDescription beanDescription, BeanDeserializerBuilder beanDeserializerBuilder) throws JsonMappingException {
        SettableBeanProperty settableBeanPropertyFindProperty;
        ObjectIdGenerator<?> objectIdGeneratorObjectIdGeneratorInstance;
        JavaType type;
        ObjectIdInfo objectIdInfo = beanDescription.getObjectIdInfo();
        if (objectIdInfo == null) {
            return;
        }
        Class<? extends ObjectIdGenerator<?>> generatorType = objectIdInfo.getGeneratorType();
        ObjectIdResolver objectIdResolverObjectIdResolverInstance = deserializationContext.objectIdResolverInstance(beanDescription.getClassInfo(), objectIdInfo);
        if (generatorType == ObjectIdGenerators$PropertyGenerator.class) {
            PropertyName propertyName = objectIdInfo.getPropertyName();
            settableBeanPropertyFindProperty = beanDeserializerBuilder.findProperty(propertyName);
            if (settableBeanPropertyFindProperty == null) {
                throw new IllegalArgumentException("Invalid Object Id definition for " + beanDescription.getBeanClass().getName() + ": can not find property with name '" + propertyName + "'");
            }
            type = settableBeanPropertyFindProperty.getType();
            objectIdGeneratorObjectIdGeneratorInstance = new PropertyBasedObjectIdGenerator(objectIdInfo.getScope());
        } else {
            JavaType javaType = deserializationContext.getTypeFactory().findTypeParameters(deserializationContext.constructType((Class<?>) generatorType), ObjectIdGenerator.class)[0];
            settableBeanPropertyFindProperty = null;
            objectIdGeneratorObjectIdGeneratorInstance = deserializationContext.objectIdGeneratorInstance(beanDescription.getClassInfo(), objectIdInfo);
            type = javaType;
        }
        beanDeserializerBuilder.setObjectIdReader(ObjectIdReader.construct(type, objectIdInfo.getPropertyName(), objectIdGeneratorObjectIdGeneratorInstance, deserializationContext.findRootValueDeserializer(type), settableBeanPropertyFindProperty, objectIdResolverObjectIdResolverInstance));
    }

    protected void addReferenceProperties(DeserializationContext deserializationContext, BeanDescription beanDescription, BeanDeserializerBuilder beanDeserializerBuilder) throws JsonMappingException {
        Map<String, AnnotatedMember> mapFindBackReferenceProperties = beanDescription.findBackReferenceProperties();
        if (mapFindBackReferenceProperties != null) {
            for (Map.Entry<String, AnnotatedMember> entry : mapFindBackReferenceProperties.entrySet()) {
                String key = entry.getKey();
                AnnotatedMember value = entry.getValue();
                beanDeserializerBuilder.addBackReferenceProperty(key, constructSettableProperty(deserializationContext, beanDescription, SimpleBeanPropertyDefinition.construct(deserializationContext.getConfig(), value), value instanceof AnnotatedMethod ? ((AnnotatedMethod) value).getParameterType(0) : value.getType()));
            }
        }
    }

    public JsonDeserializer<Object> buildBeanDeserializer(DeserializationContext deserializationContext, JavaType javaType, BeanDescription beanDescription) throws JsonMappingException {
        try {
            ValueInstantiator valueInstantiatorFindValueInstantiator = findValueInstantiator(deserializationContext, beanDescription);
            BeanDeserializerBuilder beanDeserializerBuilderConstructBeanDeserializerBuilder = constructBeanDeserializerBuilder(deserializationContext, beanDescription);
            beanDeserializerBuilderConstructBeanDeserializerBuilder.setValueInstantiator(valueInstantiatorFindValueInstantiator);
            addBeanProps(deserializationContext, beanDescription, beanDeserializerBuilderConstructBeanDeserializerBuilder);
            addObjectIdReader(deserializationContext, beanDescription, beanDeserializerBuilderConstructBeanDeserializerBuilder);
            addReferenceProperties(deserializationContext, beanDescription, beanDeserializerBuilderConstructBeanDeserializerBuilder);
            addInjectables(deserializationContext, beanDescription, beanDeserializerBuilderConstructBeanDeserializerBuilder);
            DeserializationConfig config = deserializationContext.getConfig();
            if (this._factoryConfig.hasDeserializerModifiers()) {
                Iterator<BeanDeserializerModifier> it = this._factoryConfig.deserializerModifiers().iterator();
                while (it.hasNext()) {
                    beanDeserializerBuilderConstructBeanDeserializerBuilder = it.next().updateBuilder(config, beanDescription, beanDeserializerBuilderConstructBeanDeserializerBuilder);
                }
            }
            JsonDeserializer<?> jsonDeserializerBuild = (!javaType.isAbstract() || valueInstantiatorFindValueInstantiator.canInstantiate()) ? beanDeserializerBuilderConstructBeanDeserializerBuilder.build() : beanDeserializerBuilderConstructBeanDeserializerBuilder.buildAbstract();
            if (this._factoryConfig.hasDeserializerModifiers()) {
                Iterator<BeanDeserializerModifier> it2 = this._factoryConfig.deserializerModifiers().iterator();
                while (it2.hasNext()) {
                    jsonDeserializerBuild = it2.next().modifyDeserializer(config, beanDescription, jsonDeserializerBuild);
                }
            }
            return jsonDeserializerBuild;
        } catch (NoClassDefFoundError e2) {
            return new ErrorThrowingDeserializer(e2);
        }
    }

    protected JsonDeserializer<Object> buildBuilderBasedDeserializer(DeserializationContext deserializationContext, JavaType javaType, BeanDescription beanDescription) throws JsonMappingException {
        ValueInstantiator valueInstantiatorFindValueInstantiator = findValueInstantiator(deserializationContext, beanDescription);
        DeserializationConfig config = deserializationContext.getConfig();
        BeanDeserializerBuilder beanDeserializerBuilderConstructBeanDeserializerBuilder = constructBeanDeserializerBuilder(deserializationContext, beanDescription);
        beanDeserializerBuilderConstructBeanDeserializerBuilder.setValueInstantiator(valueInstantiatorFindValueInstantiator);
        addBeanProps(deserializationContext, beanDescription, beanDeserializerBuilderConstructBeanDeserializerBuilder);
        addObjectIdReader(deserializationContext, beanDescription, beanDeserializerBuilderConstructBeanDeserializerBuilder);
        addReferenceProperties(deserializationContext, beanDescription, beanDeserializerBuilderConstructBeanDeserializerBuilder);
        addInjectables(deserializationContext, beanDescription, beanDeserializerBuilderConstructBeanDeserializerBuilder);
        JsonPOJOBuilder.Value valueFindPOJOBuilderConfig = beanDescription.findPOJOBuilderConfig();
        String str = valueFindPOJOBuilderConfig == null ? "build" : valueFindPOJOBuilderConfig.buildMethodName;
        AnnotatedMethod annotatedMethodFindMethod = beanDescription.findMethod(str, null);
        if (annotatedMethodFindMethod != null && config.canOverrideAccessModifiers()) {
            ClassUtil.checkAndFixAccess(annotatedMethodFindMethod.getMember(), config.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
        }
        beanDeserializerBuilderConstructBeanDeserializerBuilder.setPOJOBuilder(annotatedMethodFindMethod, valueFindPOJOBuilderConfig);
        if (this._factoryConfig.hasDeserializerModifiers()) {
            Iterator<BeanDeserializerModifier> it = this._factoryConfig.deserializerModifiers().iterator();
            while (it.hasNext()) {
                beanDeserializerBuilderConstructBeanDeserializerBuilder = it.next().updateBuilder(config, beanDescription, beanDeserializerBuilderConstructBeanDeserializerBuilder);
            }
        }
        JsonDeserializer<?> jsonDeserializerBuildBuilderBased = beanDeserializerBuilderConstructBeanDeserializerBuilder.buildBuilderBased(javaType, str);
        if (this._factoryConfig.hasDeserializerModifiers()) {
            Iterator<BeanDeserializerModifier> it2 = this._factoryConfig.deserializerModifiers().iterator();
            while (it2.hasNext()) {
                jsonDeserializerBuildBuilderBased = it2.next().modifyDeserializer(config, beanDescription, jsonDeserializerBuildBuilderBased);
            }
        }
        return jsonDeserializerBuildBuilderBased;
    }

    public JsonDeserializer<Object> buildThrowableDeserializer(DeserializationContext deserializationContext, JavaType javaType, BeanDescription beanDescription) throws JsonMappingException {
        SettableBeanProperty settableBeanPropertyConstructSettableProperty;
        DeserializationConfig config = deserializationContext.getConfig();
        BeanDeserializerBuilder beanDeserializerBuilderConstructBeanDeserializerBuilder = constructBeanDeserializerBuilder(deserializationContext, beanDescription);
        beanDeserializerBuilderConstructBeanDeserializerBuilder.setValueInstantiator(findValueInstantiator(deserializationContext, beanDescription));
        addBeanProps(deserializationContext, beanDescription, beanDeserializerBuilderConstructBeanDeserializerBuilder);
        AnnotatedMethod annotatedMethodFindMethod = beanDescription.findMethod("initCause", INIT_CAUSE_PARAMS);
        if (annotatedMethodFindMethod != null && (settableBeanPropertyConstructSettableProperty = constructSettableProperty(deserializationContext, beanDescription, SimpleBeanPropertyDefinition.construct(deserializationContext.getConfig(), annotatedMethodFindMethod, new PropertyName("cause")), annotatedMethodFindMethod.getParameterType(0))) != null) {
            beanDeserializerBuilderConstructBeanDeserializerBuilder.addOrReplaceProperty(settableBeanPropertyConstructSettableProperty, true);
        }
        beanDeserializerBuilderConstructBeanDeserializerBuilder.addIgnorable("localizedMessage");
        beanDeserializerBuilderConstructBeanDeserializerBuilder.addIgnorable("suppressed");
        beanDeserializerBuilderConstructBeanDeserializerBuilder.addIgnorable("message");
        if (this._factoryConfig.hasDeserializerModifiers()) {
            Iterator<BeanDeserializerModifier> it = this._factoryConfig.deserializerModifiers().iterator();
            while (it.hasNext()) {
                beanDeserializerBuilderConstructBeanDeserializerBuilder = it.next().updateBuilder(config, beanDescription, beanDeserializerBuilderConstructBeanDeserializerBuilder);
            }
        }
        JsonDeserializer<?> jsonDeserializerBuild = beanDeserializerBuilderConstructBeanDeserializerBuilder.build();
        if (jsonDeserializerBuild instanceof BeanDeserializer) {
            jsonDeserializerBuild = new ThrowableDeserializer((BeanDeserializer) jsonDeserializerBuild);
        }
        if (this._factoryConfig.hasDeserializerModifiers()) {
            Iterator<BeanDeserializerModifier> it2 = this._factoryConfig.deserializerModifiers().iterator();
            while (it2.hasNext()) {
                jsonDeserializerBuild = it2.next().modifyDeserializer(config, beanDescription, jsonDeserializerBuild);
            }
        }
        return jsonDeserializerBuild;
    }

    protected SettableAnyProperty constructAnySetter(DeserializationContext deserializationContext, BeanDescription beanDescription, AnnotatedMember annotatedMember) throws JsonMappingException {
        JavaType contentType;
        if (annotatedMember instanceof AnnotatedMethod) {
            contentType = ((AnnotatedMethod) annotatedMember).getParameterType(1);
        } else {
            contentType = annotatedMember instanceof AnnotatedField ? ((AnnotatedField) annotatedMember).getType().getContentType() : null;
        }
        JavaType javaTypeResolveMemberAndTypeAnnotations = resolveMemberAndTypeAnnotations(deserializationContext, annotatedMember, contentType);
        BeanProperty.Std std = new BeanProperty.Std(PropertyName.construct(annotatedMember.getName()), javaTypeResolveMemberAndTypeAnnotations, null, beanDescription.getClassAnnotations(), annotatedMember, PropertyMetadata.STD_OPTIONAL);
        JsonDeserializer<?> jsonDeserializerFindDeserializerFromAnnotation = findDeserializerFromAnnotation(deserializationContext, annotatedMember);
        if (jsonDeserializerFindDeserializerFromAnnotation == null) {
            jsonDeserializerFindDeserializerFromAnnotation = (JsonDeserializer) javaTypeResolveMemberAndTypeAnnotations.getValueHandler();
        }
        return new SettableAnyProperty(std, annotatedMember, javaTypeResolveMemberAndTypeAnnotations, jsonDeserializerFindDeserializerFromAnnotation != null ? deserializationContext.handlePrimaryContextualization(jsonDeserializerFindDeserializerFromAnnotation, std, javaTypeResolveMemberAndTypeAnnotations) : jsonDeserializerFindDeserializerFromAnnotation, (TypeDeserializer) javaTypeResolveMemberAndTypeAnnotations.getTypeHandler());
    }

    protected BeanDeserializerBuilder constructBeanDeserializerBuilder(DeserializationContext deserializationContext, BeanDescription beanDescription) {
        return new BeanDeserializerBuilder(beanDescription, deserializationContext.getConfig());
    }

    protected SettableBeanProperty constructSettableProperty(DeserializationContext deserializationContext, BeanDescription beanDescription, BeanPropertyDefinition beanPropertyDefinition, JavaType javaType) throws JsonMappingException {
        AnnotatedMember nonConstructorMutator = beanPropertyDefinition.getNonConstructorMutator();
        if (nonConstructorMutator == null) {
            deserializationContext.reportBadPropertyDefinition(beanDescription, beanPropertyDefinition, "No non-constructor mutator available", new Object[0]);
        }
        JavaType javaTypeResolveMemberAndTypeAnnotations = resolveMemberAndTypeAnnotations(deserializationContext, nonConstructorMutator, javaType);
        TypeDeserializer typeDeserializer = (TypeDeserializer) javaTypeResolveMemberAndTypeAnnotations.getTypeHandler();
        SettableBeanProperty methodProperty = nonConstructorMutator instanceof AnnotatedMethod ? new MethodProperty(beanPropertyDefinition, javaTypeResolveMemberAndTypeAnnotations, typeDeserializer, beanDescription.getClassAnnotations(), (AnnotatedMethod) nonConstructorMutator) : new FieldProperty(beanPropertyDefinition, javaTypeResolveMemberAndTypeAnnotations, typeDeserializer, beanDescription.getClassAnnotations(), (AnnotatedField) nonConstructorMutator);
        JsonDeserializer<?> jsonDeserializerFindDeserializerFromAnnotation = findDeserializerFromAnnotation(deserializationContext, nonConstructorMutator);
        if (jsonDeserializerFindDeserializerFromAnnotation == null) {
            jsonDeserializerFindDeserializerFromAnnotation = (JsonDeserializer) javaTypeResolveMemberAndTypeAnnotations.getValueHandler();
        }
        if (jsonDeserializerFindDeserializerFromAnnotation != null) {
            methodProperty = methodProperty.withValueDeserializer(deserializationContext.handlePrimaryContextualization(jsonDeserializerFindDeserializerFromAnnotation, methodProperty, javaTypeResolveMemberAndTypeAnnotations));
        }
        AnnotationIntrospector.ReferenceProperty referencePropertyFindReferenceType = beanPropertyDefinition.findReferenceType();
        if (referencePropertyFindReferenceType != null && referencePropertyFindReferenceType.isManagedReference()) {
            methodProperty.setManagedReferenceName(referencePropertyFindReferenceType.getName());
        }
        ObjectIdInfo objectIdInfoFindObjectIdInfo = beanPropertyDefinition.findObjectIdInfo();
        if (objectIdInfoFindObjectIdInfo != null) {
            methodProperty.setObjectIdInfo(objectIdInfoFindObjectIdInfo);
        }
        return methodProperty;
    }

    protected SettableBeanProperty constructSetterlessProperty(DeserializationContext deserializationContext, BeanDescription beanDescription, BeanPropertyDefinition beanPropertyDefinition) throws JsonMappingException {
        AnnotatedMethod getter = beanPropertyDefinition.getGetter();
        JavaType javaTypeResolveMemberAndTypeAnnotations = resolveMemberAndTypeAnnotations(deserializationContext, getter, getter.getType());
        SetterlessProperty setterlessProperty = new SetterlessProperty(beanPropertyDefinition, javaTypeResolveMemberAndTypeAnnotations, (TypeDeserializer) javaTypeResolveMemberAndTypeAnnotations.getTypeHandler(), beanDescription.getClassAnnotations(), getter);
        JsonDeserializer<?> jsonDeserializerFindDeserializerFromAnnotation = findDeserializerFromAnnotation(deserializationContext, getter);
        if (jsonDeserializerFindDeserializerFromAnnotation == null) {
            jsonDeserializerFindDeserializerFromAnnotation = (JsonDeserializer) javaTypeResolveMemberAndTypeAnnotations.getValueHandler();
        }
        return jsonDeserializerFindDeserializerFromAnnotation != null ? setterlessProperty.withValueDeserializer(deserializationContext.handlePrimaryContextualization(jsonDeserializerFindDeserializerFromAnnotation, setterlessProperty, javaTypeResolveMemberAndTypeAnnotations)) : setterlessProperty;
    }

    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    public JsonDeserializer<Object> createBeanDeserializer(DeserializationContext deserializationContext, JavaType javaType, BeanDescription beanDescription) throws JsonMappingException {
        JavaType javaTypeMaterializeAbstractType;
        DeserializationConfig config = deserializationContext.getConfig();
        JsonDeserializer<Object> jsonDeserializer_findCustomBeanDeserializer = _findCustomBeanDeserializer(javaType, config, beanDescription);
        if (jsonDeserializer_findCustomBeanDeserializer != null) {
            return jsonDeserializer_findCustomBeanDeserializer;
        }
        if (javaType.isThrowable()) {
            return buildThrowableDeserializer(deserializationContext, javaType, beanDescription);
        }
        if (javaType.isAbstract() && !javaType.isPrimitive() && !javaType.isEnumType() && (javaTypeMaterializeAbstractType = materializeAbstractType(deserializationContext, javaType, beanDescription)) != null) {
            return buildBeanDeserializer(deserializationContext, javaTypeMaterializeAbstractType, config.introspect(javaTypeMaterializeAbstractType));
        }
        JsonDeserializer<?> jsonDeserializerFindStdDeserializer = findStdDeserializer(deserializationContext, javaType, beanDescription);
        if (jsonDeserializerFindStdDeserializer != null) {
            return jsonDeserializerFindStdDeserializer;
        }
        if (isPotentialBeanType(javaType.getRawClass())) {
            return buildBeanDeserializer(deserializationContext, javaType, beanDescription);
        }
        return null;
    }

    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    public JsonDeserializer<Object> createBuilderBasedDeserializer(DeserializationContext deserializationContext, JavaType javaType, BeanDescription beanDescription, Class<?> cls) throws JsonMappingException {
        return buildBuilderBasedDeserializer(deserializationContext, javaType, deserializationContext.getConfig().introspectForBuilder(deserializationContext.constructType(cls)));
    }

    protected List<BeanPropertyDefinition> filterBeanProps(DeserializationContext deserializationContext, BeanDescription beanDescription, BeanDeserializerBuilder beanDeserializerBuilder, List<BeanPropertyDefinition> list, Set<String> set) throws JsonMappingException {
        ArrayList arrayList = new ArrayList(Math.max(4, list.size()));
        HashMap map = new HashMap();
        for (BeanPropertyDefinition beanPropertyDefinition : list) {
            String name = beanPropertyDefinition.getName();
            if (!set.contains(name)) {
                if (!beanPropertyDefinition.hasConstructorParameter()) {
                    Class<?> rawType = null;
                    if (beanPropertyDefinition.hasSetter()) {
                        rawType = beanPropertyDefinition.getSetter().getRawParameterType(0);
                    } else if (beanPropertyDefinition.hasField()) {
                        rawType = beanPropertyDefinition.getField().getRawType();
                    }
                    if (rawType != null && isIgnorableType(deserializationContext.getConfig(), beanDescription, rawType, map)) {
                        beanDeserializerBuilder.addIgnorable(name);
                    }
                }
                arrayList.add(beanPropertyDefinition);
            }
        }
        return arrayList;
    }

    protected JsonDeserializer<?> findStdDeserializer(DeserializationContext deserializationContext, JavaType javaType, BeanDescription beanDescription) throws JsonMappingException {
        JsonDeserializer<?> jsonDeserializerFindDefaultDeserializer = findDefaultDeserializer(deserializationContext, javaType, beanDescription);
        if (jsonDeserializerFindDefaultDeserializer != null && this._factoryConfig.hasDeserializerModifiers()) {
            Iterator<BeanDeserializerModifier> it = this._factoryConfig.deserializerModifiers().iterator();
            while (it.hasNext()) {
                jsonDeserializerFindDefaultDeserializer = it.next().modifyDeserializer(deserializationContext.getConfig(), beanDescription, jsonDeserializerFindDefaultDeserializer);
            }
        }
        return jsonDeserializerFindDefaultDeserializer;
    }

    protected boolean isIgnorableType(DeserializationConfig deserializationConfig, BeanDescription beanDescription, Class<?> cls, Map<Class<?>, Boolean> map) {
        Boolean boolIsIgnorableType = map.get(cls);
        if (boolIsIgnorableType != null) {
            return boolIsIgnorableType.booleanValue();
        }
        ConfigOverride configOverrideFindConfigOverride = deserializationConfig.findConfigOverride(cls);
        if (configOverrideFindConfigOverride != null) {
            boolIsIgnorableType = configOverrideFindConfigOverride.getIsIgnoredType();
        }
        if (boolIsIgnorableType == null) {
            boolIsIgnorableType = deserializationConfig.getAnnotationIntrospector().isIgnorableType(deserializationConfig.introspectClassAnnotations(cls).getClassInfo());
            if (boolIsIgnorableType == null) {
                boolIsIgnorableType = Boolean.FALSE;
            }
        }
        map.put(cls, boolIsIgnorableType);
        return boolIsIgnorableType.booleanValue();
    }

    protected boolean isPotentialBeanType(Class<?> cls) {
        String strCanBeABeanType = ClassUtil.canBeABeanType(cls);
        if (strCanBeABeanType != null) {
            throw new IllegalArgumentException("Can not deserialize Class " + cls.getName() + " (of type " + strCanBeABeanType + ") as a Bean");
        }
        if (ClassUtil.isProxyType(cls)) {
            throw new IllegalArgumentException("Can not deserialize Proxy class " + cls.getName() + " as a Bean");
        }
        String strIsLocalType = ClassUtil.isLocalType(cls, true);
        if (strIsLocalType == null) {
            return true;
        }
        throw new IllegalArgumentException("Can not deserialize Class " + cls.getName() + " (of type " + strIsLocalType + ") as a Bean");
    }

    protected JavaType materializeAbstractType(DeserializationContext deserializationContext, JavaType javaType, BeanDescription beanDescription) throws JsonMappingException {
        Iterator<AbstractTypeResolver> it = this._factoryConfig.abstractTypeResolvers().iterator();
        while (it.hasNext()) {
            JavaType javaTypeResolveAbstractType = it.next().resolveAbstractType(deserializationContext.getConfig(), beanDescription);
            if (javaTypeResolveAbstractType != null) {
                return javaTypeResolveAbstractType;
            }
        }
        return null;
    }
}
