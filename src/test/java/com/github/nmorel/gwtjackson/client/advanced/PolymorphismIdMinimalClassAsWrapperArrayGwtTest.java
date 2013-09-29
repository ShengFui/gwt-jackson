package com.github.nmorel.gwtjackson.client.advanced;

import com.github.nmorel.gwtjackson.client.GwtJacksonTestCase;
import com.github.nmorel.gwtjackson.client.ObjectMapper;
import com.github.nmorel.gwtjackson.shared.ObjectMapperTester;
import com.github.nmorel.gwtjackson.shared.advanced.PolymorphismIdMinimalClassAsWrapperArrayTester;
import com.github.nmorel.gwtjackson.shared.advanced.PolymorphismIdMinimalClassAsWrapperArrayTester.Person;
import com.google.gwt.core.client.GWT;

/**
 * @author Nicolas Morel
 */
public class PolymorphismIdMinimalClassAsWrapperArrayGwtTest extends GwtJacksonTestCase {

    public interface PolymorphismMapper extends ObjectMapper<Person[]>, ObjectMapperTester<Person[]> {

        static PolymorphismMapper INSTANCE = GWT.create( PolymorphismMapper.class );
    }

    private PolymorphismIdMinimalClassAsWrapperArrayTester tester = PolymorphismIdMinimalClassAsWrapperArrayTester.INSTANCE;

    public void testSerialize() {
        tester.testSerialize( PolymorphismMapper.INSTANCE );
    }

    public void testDeserialize() {
        tester.testDeserialize( PolymorphismMapper.INSTANCE );
    }
}
