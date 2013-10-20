package com.github.nmorel.gwtjackson.client.ser.array;

import javax.annotation.Nonnull;
import java.io.IOException;

import com.github.nmorel.gwtjackson.client.JsonSerializationContext;
import com.github.nmorel.gwtjackson.client.JsonSerializer;
import com.github.nmorel.gwtjackson.client.stream.JsonWriter;
import com.github.nmorel.gwtjackson.client.utils.Base64;

/**
 * Default {@link JsonSerializer} implementation for array of byte.
 *
 * @author Nicolas Morel
 */
public class PrimitiveByteArrayJsonSerializer extends JsonSerializer<byte[]> {

    private static final PrimitiveByteArrayJsonSerializer INSTANCE = new PrimitiveByteArrayJsonSerializer();

    /**
     * @return an instance of {@link PrimitiveByteArrayJsonSerializer}
     */
    public static PrimitiveByteArrayJsonSerializer getInstance() {
        return INSTANCE;
    }

    private PrimitiveByteArrayJsonSerializer() { }

    @Override
    public void doSerialize( JsonWriter writer, @Nonnull byte[] values, JsonSerializationContext ctx ) throws IOException {
        if ( !ctx.isWriteEmptyJsonArrays() && values.length == 0 ) {
            writer.cancelName();
            return;
        }

        writer.value( Base64.encode( new String( values ) ) );
    }
}
